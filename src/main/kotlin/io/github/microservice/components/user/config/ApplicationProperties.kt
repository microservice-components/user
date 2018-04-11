package io.github.microservice.components.user.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * 应用个性化配置
 *
 * @author hookszhang on 2018/4/11.
 */
@Component
@ConfigurationProperties(prefix = "application")
class ApplicationProperties {

    var jwt = JWT()

    class JWT {
        /**
         * JWT 密钥，加密用
         */
        var secret: String = "DEFAULT_JWT_SECRET"
        /**
         * JWT token 过期时间（天）
         */
        var expirationDay: Int = 30
    }
}