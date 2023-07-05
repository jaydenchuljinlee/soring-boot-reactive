package com.example.reactive.config.properties

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "spring.jpa")
@Component
data class JpaProperty(
    var driverClassName: String = ""
) {
    @Autowired
    constructor(): this("default")
}