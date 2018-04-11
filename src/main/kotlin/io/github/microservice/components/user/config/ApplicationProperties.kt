package io.github.microservice.components.user.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * @author hookszhang on 2018/4/11.
 */
@Component
@ConfigurationProperties(prefix = "application")
class ApplicationProperties {
    var jwtSecret: String = "DEFAULT_JWT_SECRET"
}
