package io.github.microservice.components.user.utils

import io.github.microservice.components.user.bean.JwtSecurityUser
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest

/**
 * Jwt 安全工具类，可以获得当前登录用户
 *
 * @author hookszhang on 2018/3/30.
 */
object JwtSecurityUtils {

    const val HEADER_USER_ID = "x-user-id"
    const val HEADER_USER_PHONE = "x-user-phone"

    /**
     * 获得当前登录的用户 ID
     * 从请求头中获得，Zuul 转发时会携带 x-user-id 头，未登录时表示为 -1
     */
    fun getCurrentLoginUserId(): Int {
        return getContextRequest().getIntHeader(HEADER_USER_ID)
    }

    /**
     * 获得当前登录的用户手机号
     * 从请求头中获得，Zuul 转发时会携带 x-user-phone 头，未登录时表示为 -1
     */
    fun getCurrentLoginUserPhone(): String {
        return getContextRequest().getHeader(HEADER_USER_PHONE)
    }

    /**
     * 获得当前登录用户的完整信息
     */
    fun getCurrentLoginUser(): JwtSecurityUser {
        val id = getCurrentLoginUserId()
        val phone = getCurrentLoginUserPhone()
        return JwtSecurityUser(id, phone)
    }

    /**
     * 从请求上下文中获得当前 HttpServletRequest
     */
    fun getContextRequest(): HttpServletRequest {
        return (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
    }
}
