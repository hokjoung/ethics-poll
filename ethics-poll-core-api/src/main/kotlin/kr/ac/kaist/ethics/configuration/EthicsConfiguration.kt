package kr.ac.kaist.ethics.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class EthicsConfiguration {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}
