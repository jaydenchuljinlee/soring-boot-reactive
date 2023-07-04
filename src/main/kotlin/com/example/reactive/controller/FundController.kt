package com.example.reactive.controller

import com.example.reactive.entity.Fund
import com.example.reactive.service.FundService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class FundController(
    private val fundService: FundService
) {
    @GetMapping("/reactive")
    fun reactive(id: Long): Mono<Fund> {
        return fundService.getReactiveData(id)
    }

    @GetMapping("/normal")
    fun normal(id: Long): Fund {
        return fundService.getNormalData(id)
    }
}