package com.example.reactive.config

import com.example.reactive.config.properties.R2dbcProperty
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@EnableR2dbcRepositories("com.example.reactive.repository.r2dbc")
@EnableR2dbcAuditing
@Configuration
class R2dbcConfig(
    private val r2dbcProperty: R2dbcProperty,
): AbstractR2dbcConfiguration() {
    override fun connectionFactory(): ConnectionFactory {
        return ConnectionFactories.get(r2dbcProperty.url)
    }
}