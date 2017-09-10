package com.hutatar

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

class Routes(private val userHandler: UserHandler) {

    fun router() = router {
        "/user".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                GET("/list", userHandler::findAll)
            }
        }
    }
}