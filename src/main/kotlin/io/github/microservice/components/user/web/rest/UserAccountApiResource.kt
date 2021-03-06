package io.github.microservice.components.user.web.rest

import io.github.microservice.components.user.bean.JwtSecurityUser
import io.github.microservice.components.user.utils.JwtSecurityUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * The user account api resource.
 *
 * @author Hooks Zhang
 */
@RestController
@RequestMapping("/api")
class UserAccountApiResource {

    @GetMapping("/account")
    fun account(): JwtSecurityUser? {
        return JwtSecurityUtils.getCurrentLoginUser()
    }
}