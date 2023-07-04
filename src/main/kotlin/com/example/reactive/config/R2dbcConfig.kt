package com.example.reactive.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@EnableR2dbcRepositories("com.example.reactive.repository.r2dbc")
@EnableR2dbcAuditing
@Configuration
class R2dbcConfig {
}