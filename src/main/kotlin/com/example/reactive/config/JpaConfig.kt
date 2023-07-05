package com.example.reactive.config

import com.example.reactive.config.properties.DataSourceProperty
import com.example.reactive.config.properties.HibernateProperty
import com.example.reactive.config.properties.JpaProperty
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@EnableTransactionManagement
@EnableJpaRepositories("com.example.reactive.repository.jpa")
@Configuration
class JpaConfig(
    private val jpaProperty: JpaProperty,
    private val dataSourceProperty: DataSourceProperty,
    private val hibernateProperty: HibernateProperty
) {
    @Bean
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()
        em.dataSource = dataSource()
        em.setPackagesToScan("com.example.reactive.entity")

        val vendorAdapter = HibernateJpaVendorAdapter()
        em.jpaVendorAdapter = vendorAdapter

        val properties = hashMapOf<String, Any>()
        properties["hibernate.hbm2ddl.auto"] = hibernateProperty.ddlAuto
        properties["hibernate.dialect"] = hibernateProperty.dialect

        em.jpaPropertyMap = properties

        return em
    }

    @Bean
    fun dataSource(): DataSource {
        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName(jpaProperty.driverClassName)
        dataSourceBuilder.url(dataSourceProperty.url)
        dataSourceBuilder.username(dataSourceProperty.username)
        dataSourceBuilder.password(dataSourceProperty.password)
        return dataSourceBuilder.build()
    }

    @Bean
    fun jpaTransactionManager(): PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory().`object`
        return transactionManager
    }

    @Bean
    fun exceptionTranslation(): PersistenceExceptionTranslationPostProcessor {
        return PersistenceExceptionTranslationPostProcessor()
    }
}