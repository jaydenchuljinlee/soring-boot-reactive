package com.example.reactive.config.properties

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "spring.r2dbc")
@Component
data class R2dbcProperty(
    var url: String = "not set",
    var username: String = "not set",
    var password: String = "not set",
) {
    @Autowired
    constructor(): this("default", "default", "default")
}