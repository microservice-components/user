package io.github.microservice.components.user.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("message")
interface MessageFeignClient {

    @GetMapping("/rpc/sms_captcha")
    fun sendSmsCaptcha(@RequestParam("phoneNumber") phoneNumber: String, @RequestParam("captcha") captcha: String)
}
