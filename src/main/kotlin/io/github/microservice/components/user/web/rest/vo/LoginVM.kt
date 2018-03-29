package io.github.microservice.components.user.web.rest.vo

import io.github.microservice.components.user.enums.Device
import io.github.microservice.components.user.enums.From
import javax.validation.constraints.NotEmpty

data class LoginVM(
        @field:NotEmpty
        var phone: String?, var from: From?, var device: Device?, var inviteCode: String?, var invitedCode: String?
)