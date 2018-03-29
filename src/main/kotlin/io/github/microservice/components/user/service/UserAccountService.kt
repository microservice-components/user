package io.github.microservice.components.user.service

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import io.github.microservice.components.user.mapper.UserAccountMapper
import io.github.microservice.components.user.model.UserAccount
import io.github.microservice.components.user.utils.JWTUtils
import io.github.microservice.components.user.web.rest.vo.JwtToken
import io.github.microservice.components.user.web.rest.vo.LoginVM
import org.apache.commons.lang.RandomStringUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserAccountService(private val jwtUtils: JWTUtils) : ServiceImpl<UserAccountMapper, UserAccount>() {

    private val log = LoggerFactory.getLogger(javaClass)

    fun register(loginVM: LoginVM): JwtToken {
        var user = baseMapper.findByPhone(loginVM.phone)

        return if (user == null) {
            user = UserAccount(loginVM.phone, loginVM.from, loginVM.device, generatorInviteCode(), loginVM.invitedCode)
            save(user)
            val token = createToken(user)
            token.newUser = true
            token
        } else {
            createToken(user)
        }
    }

    private fun createToken(user: UserAccount): JwtToken {
        val token = jwtUtils.createToken(user.id!!, user.phone!!)
        return JwtToken(token)
    }

    private fun save(user: UserAccount) {
        baseMapper.insert(user)
    }

    private fun generatorInviteCode(): String? {
        // TODO unique
        return RandomStringUtils.random(6)
    }
}
