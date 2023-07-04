package com.example.reactive.repository.r2dbc

import com.example.reactive.entity.Fund
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FundR2dbcRepository: R2dbcRepository<Fund, Long> {
}