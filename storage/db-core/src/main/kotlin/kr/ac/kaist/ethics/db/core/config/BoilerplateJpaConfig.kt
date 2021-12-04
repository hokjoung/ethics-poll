package kr.ac.kaist.ethics.db.core.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["kr.ac.kaist.ethics.db.core"])
@EnableJpaRepositories(basePackages = ["kr.ac.kaist.ethics.db.core"])
internal class BoilerplateJpaConfig
