package com.hutatar

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.http.MediaType.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import reactor.test.test

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserTests {

    @LocalServerPort
    var port: Int? = null

    lateinit var client: WebClient

    @Before
    fun setup() {
        client = WebClient.create("http://localhost:$port")
    }


    @Test
    fun `Find all users on JSON REST endpoint`() {
        client.get().uri("/user/list")
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux<User>()
                .test()
                .expectNextMatches { it.firstName == "adam" }
                .expectNextMatches { it.firstName == "adam" }
                .verifyComplete()
    }
}