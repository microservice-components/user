package io.github.microservice.components.user

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
class UserApplication

fun main(args: Array<String>) {
    runApplication<UserApplication>(*args)
}
