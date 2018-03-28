--liquibase formatted sql
--changeset duiker(generated):20180328115724_add_table_user_account

SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `phone` char(11) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `nick_name` char(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '头像',
  `user_language` char(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'zh_cn' COMMENT '用户语言',
  `channel` char(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '来源渠道',
  `activated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '激活时间',
  `market` char(15) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '用户来自哪个市场AppStore,meizu,xiaomi,huawei.....',
  `from` enum('APP','HTML','MICRO_PROGRAM') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'APP' COMMENT '来源 APP,h5,小程序',
  `device` enum('ANDROID','IOS','PC','MICRO_PROGRAM') COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '设备类型安卓, iOS,PC,小程序',
  `wx_open_id` char(28) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '微信 openId',
  `qq_open_id` char(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'QQ openId',
  `invite_code` char(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邀请码',
  `invited_code` char(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '被邀请码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_invited` (`invite_code`) USING BTREE COMMENT '邀请码唯一'
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户账号表';

SET FOREIGN_KEY_CHECKS = 1;
