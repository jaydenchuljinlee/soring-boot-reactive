package com.example.reactive.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime


@Table(name = "fund")
@Entity
class Fund(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0,

    @Column(name = "name")
    val name: String = "",

    @Column(name = "regDatetime")
    @CreatedDate
    val regDatetime: LocalDateTime = LocalDateTime.now(),
) {
    @Column(name = "decs")
    var decs: String? = null

    @Column(name = "modDateTime")
    @LastModifiedDate
    var modDateTime: LocalDateTime? = null
}