package com.example.reactive.service

import com.example.reactive.entity.Fund
import com.example.reactive.repository.jpa.FundJpaRepository
import com.example.reactive.repository.r2dbc.FundR2dbcRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class FundServiceImpl(
    private val fundR2dbcRepository: FundR2dbcRepository,
    private val fundJpaRepository: FundJpaRepository
): FundService {
    override fun getReactiveData(id: Long): Mono<Fund> {
        return fundR2dbcRepository.findById(id)
    }

    override fun getNormalData(id: Long): Fund {
        return fundJpaRepository.findById(id).get()
    }
}