package io.github.microservice.components.user.web.rest.vo

data class JwtToken(var token: String, var newUser: Boolean = false)