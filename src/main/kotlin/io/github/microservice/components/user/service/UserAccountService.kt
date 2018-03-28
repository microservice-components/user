package io.github.microservice.components.user.service

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import io.github.microservice.components.user.mapper.UserAccountMapper
import io.github.microservice.components.user.model.UserAccount
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserAccountService : ServiceImpl<UserAccountMapper, UserAccount>() {

  private val log = LoggerFactory.getLogger(javaClass)

}
