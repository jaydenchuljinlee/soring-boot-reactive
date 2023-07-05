package com.example.reactive.config.properties

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "spring.jpa.properties.hibernate")
@Component
data class HibernateProperty(
    var dialect: String = "not set",
    var formatSql: String = "not set",
    var ddlAuto: String = "not set",
) {
    @Autowired
    constructor(): this("default", "default", "default")
}