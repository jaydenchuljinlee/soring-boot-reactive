package com.example.reactive.service

import com.example.reactive.entity.Fund
import reactor.core.publisher.Mono

interface FundService {
    fun getReactiveData(id: Long): Mono<Fund>

    fun getNormalData(id: Long): Fund
}