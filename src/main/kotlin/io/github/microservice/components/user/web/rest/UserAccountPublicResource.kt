package io.github.microservice.components.user.web.rest

import io.github.microservice.components.user.service.UserAccountService
import io.github.microservice.components.user.web.rest.vo.JwtToken
import io.github.microservice.components.user.web.rest.vo.LoginVM
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * The public resource for user account
 *
 * @author Hooks Zhang
 */
@RestController
@RequestMapping("/public")
class UserAccountPublicResource(private val userAccountService: UserAccountService) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("/authorize")
    fun authorize(@Valid @RequestBody vm: LoginVM): ResponseEntity<JwtToken> {
        return ResponseEntity.ok(userAccountService.register(vm))
    }

    @GetMapping("/sms_captcha")
    fun sendCaptcha(phoneNumber: String): ResponseEntity<Void> {
        userAccountService.sendSmsCaptcha(phoneNumber)
        return ResponseEntity.ok().build();
    }

    @GetMapping("/image_captcha")
    fun imageCaptcha() {

    }
}