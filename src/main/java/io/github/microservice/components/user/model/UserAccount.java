package io.github.microservice.components.user.model;

import io.github.microservice.components.user.enums.From;
import io.github.microservice.components.user.enums.Device;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * Entity UserAccount. 
 *
 * @author duiker(generated)
 */
@Data
@Table(name = "user_account")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @ApiParam(required = true)
    @ApiModelProperty(value = "手机号码")
    @Column(name = "phone")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    @Column(name = "email")
    private String email;

    @NotNull
    @ApiParam(required = true)
    @ApiModelProperty(value = "昵称")
    @Column(name = "nick_name")
    private String nickName;

    @ApiModelProperty(value = "头像")
    @Column(name = "photo")
    private String photo;

    @NotNull
    @ApiParam(required = true)
    @ApiModelProperty(value = "用户语言")
    @Column(name = "user_language")
    private String userLanguage;

    @NotNull
    @ApiParam(required = true)
    @ApiModelProperty(value = "来源渠道")
    @Column(name = "channel")
    private String channel;

    @NotNull
    @ApiParam(required = true)
    @ApiModelProperty(value = "激活时间")
    @Column(name = "activated_time")
    private Date activatedTime;

    @ApiModelProperty(value = "用户来自哪个市场AppStore,meizu,xiaomi,huawei.....")
    @Column(name = "market")
    private String market;

    @NotNull
    @ApiParam(required = true)
    @ApiModelProperty(value = "来源APP,h5,小程序")
    @Column(name = "from")
    private From from;

    @NotNull
    @ApiParam(required = true)
    @ApiModelProperty(value = "设备类型安卓,iOS,PC,小程序")
    @Column(name = "device")
    private Device device;

    @NotNull
    @ApiParam(required = true)
    @ApiModelProperty(value = "微信openId")
    @Column(name = "wx_open_id")
    private String wxOpenId;

    @NotNull
    @ApiParam(required = true)
    @ApiModelProperty(value = "QQopenId")
    @Column(name = "qq_open_id")
    private String qqOpenId;

    @ApiModelProperty(value = "邀请码")
    @Column(name = "invite_code")
    private String inviteCode;

    @ApiModelProperty(value = "被邀请码")
    @Column(name = "invited_code")
    private String invitedCode;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;

}
