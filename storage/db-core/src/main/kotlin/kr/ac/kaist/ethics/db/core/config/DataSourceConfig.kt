package kr.ac.kaist.ethics.db.core.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "kaist.datasource.ethics")
    fun hikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun dataSource(@Qualifier("hikariConfig") config: HikariConfig): HikariDataSource {
        return HikariDataSource(config)
    }
}
