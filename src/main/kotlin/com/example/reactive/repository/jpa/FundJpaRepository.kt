package com.example.reactive.repository.jpa

import com.example.reactive.entity.Fund
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

interface FundJpaRepository: JpaRepository<Fund, Long> {
}