package io.github.microservice.components.user.service

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import io.github.microservice.components.user.mapper.UserAccountMapper
import io.github.microservice.components.user.model.UserAccount
import org.springframework.stereotype.Service
import lombok.extern.slf4j.Slf4j

@Service
@Slf4j
class UserAccountService : ServiceImpl<UserAccountMapper, UserAccount>()
