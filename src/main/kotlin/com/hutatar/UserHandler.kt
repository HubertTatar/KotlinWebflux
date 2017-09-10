package com.hutatar

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux

@Suppress("UNUSED_PARAMETER")
class UserHandler {

    private val users = Flux.just(
            User("adam", "1"),
            User("adam", "2")
    )

    fun findAll(req: ServerRequest) = ok().body(users)
}