package io.github.microservice.components.user.model

import io.github.microservice.components.user.enums.Device
import io.github.microservice.components.user.enums.From
import io.swagger.annotations.ApiModelProperty
import io.swagger.annotations.ApiParam
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * Entity UserAccount.
 *
 * @author duiker(generated)
 */
@Table(name = "user_account")
data class UserAccount(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        var id: Int? = null,

        @NotNull
        @ApiParam(required = true)
        @ApiModelProperty(value = "手机号码")
        @Column(name = "phone")
        var phone: String? = null,

        @ApiModelProperty(value = "邮箱")
        @Column(name = "email")
        var email: String? = null,

        @ApiParam(required = true)
        @ApiModelProperty(value = "昵称")
        @Column(name = "nick_name")
        var nickName: String? = null,

        @ApiModelProperty(value = "头像")
        @Column(name = "photo")
        var photo: String? = null,

        @ApiParam(required = true)
        @ApiModelProperty(value = "用户语言")
        @Column(name = "user_language")
        var userLanguage: String? = null,

        @ApiParam(required = true)
        @ApiModelProperty(value = "来源渠道")
        @Column(name = "channel")
        var channel: String? = null,

        @ApiParam(required = true)
        @ApiModelProperty(value = "激活时间")
        @Column(name = "activated_time")
        var activatedTime: Date? = null,

        @ApiModelProperty(value = "用户来自哪个市场AppStore,meizu,xiaomi,huawei.....")
        @Column(name = "market")
        var market: String? = null,

        @NotNull
        @ApiParam(required = true)
        @ApiModelProperty(value = "来源APP,h5,小程序")
        @Column(name = "from")
        var from: From? = null,

        @NotNull
        @ApiParam(required = true)
        @ApiModelProperty(value = "设备类型安卓,iOS,PC,小程序")
        @Column(name = "device")
        var device: Device? = null,

        @NotNull
        @ApiParam(required = true)
        @ApiModelProperty(value = "微信openId")
        @Column(name = "wx_open_id")
        var wxOpenId: String? = null,

        @NotNull
        @ApiParam(required = true)
        @ApiModelProperty(value = "QQopenId")
        @Column(name = "qq_open_id")
        var qqOpenId: String? = null,

        @ApiModelProperty(value = "邀请码")
        @Column(name = "invite_code")
        var inviteCode: String? = null,

        @ApiModelProperty(value = "被邀请码")
        @Column(name = "invited_code")
        var invitedCode: String? = null,

        @ApiModelProperty(value = "创建时间")
        @Column(name = "create_time")
        var createTime: Date? = null,

        @ApiModelProperty(value = "更新时间")
        @Column(name = "update_time")
        var updateTime: Date? = null

) {
    constructor(phone: String?, from: From?, device: Device?, inviteCode: String?, invitedCode: String?) : this() {
        this.phone = phone
        this.from = from
        this.device = device
        this.inviteCode = inviteCode
        this.invitedCode = invitedCode
    }
}
