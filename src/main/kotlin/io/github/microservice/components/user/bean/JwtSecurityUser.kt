package io.github.microservice.components.user.bean

/**
 * Jwt 安全用户对象，包含用户 ID，手机号等
 *
 * @author hookszhang on 2018/3/30.
 */
data class JwtSecurityUser(
        var id: Int, var phone: String
)
