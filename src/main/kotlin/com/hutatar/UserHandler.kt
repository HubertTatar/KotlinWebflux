package com.hutatar

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToServerSentEvents
import reactor.core.publisher.Flux

class UserHandler {

    private val users = Flux.just(
            User("adam", "bien"),
            User("adam", "cien")
    )

    fun findAll(req: ServerRequest) = ok().body(users)
}