-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 2017-09-29 16:11:50
-- 服务器版本： 5.6.35
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- 表的结构 `sys_config`
--

CREATE TABLE `sys_config` (
  `name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `value` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `sys_config`
--

INSERT INTO `sys_config` (`name`, `remark`, `value`) VALUES
('a', 'a', 'a');

-- --------------------------------------------------------

--
-- 表的结构 `sys_log`
--

CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ip` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `method` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `operation` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `params` text COLLATE utf8mb4_unicode_ci,
  `time` bigint(20) DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `sys_log`
--

INSERT INTO `sys_log` (`id`, `created`, `ip`, `method`, `operation`, `params`, `time`, `username`) VALUES
(1, '2017-09-28 02:47:37', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.delete()', '删除管理员', '[3]', 12, 'admin'),
(2, '2017-09-28 03:16:07', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.delete()', '删除管理员', '[4]', 14, 'admin'),
(3, '2017-09-28 03:16:11', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.delete()', '删除管理员', '[5]', 4, 'admin'),
(4, '2017-09-28 03:18:26', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":9,\"username\":\"a\",\"password\":\"a\",\"email\":\"a@a.com\",\"mobile\":\"1\",\"status\":1,\"userId\":1}', 53, 'admin'),
(5, '2017-09-28 03:18:32', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":9,\"username\":\"a\",\"password\":\"a\",\"email\":\"a@a.com\",\"mobile\":\"1\",\"status\":1,\"userId\":1}', 22, 'admin'),
(6, '2017-09-28 06:02:23', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":9,\"username\":\"a\",\"password\":\"a\",\"email\":\"a@a.com\",\"mobile\":\"1\",\"status\":1}', 58, 'admin'),
(7, '2017-09-28 06:03:34', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":9,\"username\":\"a\",\"password\":\"a\",\"email\":\"a@a.com\",\"mobile\":\"1\",\"status\":1}', 57, 'admin'),
(8, '2017-09-28 06:03:38', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":9,\"username\":\"a\",\"password\":\"a\",\"email\":\"a@a.com\",\"mobile\":\"1\",\"status\":1}', 10, 'admin'),
(9, '2017-09-28 06:03:53', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.delete()', '删除管理员', '[9]', 11, 'admin'),
(10, '2017-09-28 06:04:00', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.delete()', '删除角色', '[2]', 11, 'admin'),
(11, '2017-09-28 06:04:03', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.delete()', '删除角色', '[1]', 5, 'admin'),
(12, '2017-09-28 06:19:33', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"username\":\"a\",\"password\":\"b\",\"email\":\"c@q.com\",\"mobile\":\"34\",\"status\":1}', 94, 'admin'),
(13, '2017-09-28 06:19:38', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.delete()', '删除管理员', '[10,11]', 14, 'admin'),
(14, '2017-09-28 06:19:41', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.delete()', '删除管理员', '[12]', 6, 'admin'),
(15, '2017-09-28 06:27:57', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"username\":\"a\",\"password\":\"b\",\"email\":\"a@q.com\",\"mobile\":\"234\",\"status\":1}', 9, 'admin'),
(16, '2017-09-28 06:28:21', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":13,\"username\":\"ab\",\"password\":\"b\",\"email\":\"a@q.com\",\"mobile\":\"234\"}', 19, 'admin'),
(17, '2017-09-28 06:28:25', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":13,\"username\":\"ab\",\"password\":\"b\",\"email\":\"a@q.com\",\"mobile\":\"234\"}', 4, 'admin'),
(18, '2017-09-28 06:28:30', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":13,\"username\":\"ab\",\"password\":\"b\",\"email\":\"a@q.com\",\"mobile\":\"234\"}', 3, 'admin'),
(19, '2017-09-28 06:31:32', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":13,\"username\":\"ab\",\"password\":\"b\",\"email\":\"a@q.com\",\"mobile\":\"234\"}', 8, 'admin'),
(20, '2017-09-28 06:31:36', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":13,\"username\":\"ab\",\"password\":\"b\",\"email\":\"a@q.com\",\"mobile\":\"234\"}', 14, 'admin'),
(21, '2017-09-28 06:33:19', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.save()', '保存角色', '{\"id\":9,\"name\":\"a\",\"userId\":1}', 6, 'admin'),
(22, '2017-09-28 06:33:25', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.save()', '保存角色', '{\"id\":10,\"name\":\"af\",\"userId\":1}', 3, 'admin'),
(23, '2017-09-28 06:33:30', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.save()', '保存角色', '{\"id\":9,\"name\":\"a\",\"remark\":\"asfasf\",\"userId\":1}', 10, 'admin'),
(24, '2017-09-29 06:04:32', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"username\":\"b\",\"password\":\"c\",\"email\":\"a@q.com\",\"mobile\":\"234\",\"status\":1}', 87, 'admin'),
(25, '2017-09-29 06:04:36', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":14,\"username\":\"b\",\"password\":\"c\",\"email\":\"a@q.com\",\"mobile\":\"234\"}', 21, 'admin'),
(26, '2017-09-29 06:04:41', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"id\":14,\"username\":\"b\",\"password\":\"c\",\"email\":\"a@q.com\",\"mobile\":\"234\"}', 8, 'admin'),
(27, '2017-09-29 06:04:44', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.delete()', '删除管理员', '[14]', 12, 'admin'),
(28, '2017-09-29 06:04:50', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.delete()', '删除管理员', '[13]', 4, 'admin'),
(29, '2017-09-29 06:04:57', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.delete()', '删除角色', '[8]', 8, 'admin'),
(30, '2017-09-29 06:04:59', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.delete()', '删除角色', '[9]', 4, 'admin'),
(31, '2017-09-29 06:05:03', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.delete()', '删除角色', '[10]', 5, 'admin'),
(32, '2017-09-29 06:07:00', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.save()', '保存角色', '{\"name\":\"b\",\"remark\":\"b\"}', 4, 'admin'),
(33, '2017-09-29 06:07:05', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.save()', '保存角色', '{\"id\":11,\"name\":\"b\",\"remark\":\"b\",\"userId\":1}', 23, 'admin'),
(34, '2017-09-29 06:07:15', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.save()', '保存角色', '{\"id\":11,\"name\":\"b\",\"remark\":\"b\",\"userId\":1}', 14, 'admin'),
(35, '2017-09-29 06:07:34', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysUserController.save()', '保存管理员', '{\"username\":\"heyujia\",\"password\":\"heyujia\",\"email\":\"heyujia@q.com\",\"mobile\":\"123\",\"status\":1}', 11, 'admin'),
(36, '2017-09-29 06:09:11', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysConfigController.save()', '保存配置', '{\"name\":\"a\",\"value\":\"a\",\"remark\":\"a\"}', 10, 'admin'),
(37, '2017-09-29 06:39:15', '0:0:0:0:0:0:0:1', 'com.shop.modules.sys.controller.SysRoleController.save()', '保存角色', '{\"id\":11,\"name\":\"b\",\"remark\":\"b\",\"userId\":1}', 60, 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `sys_menu`
--

CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL,
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `perms` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `parent` tinyblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `sys_menu`
--

INSERT INTO `sys_menu` (`id`, `icon`, `name`, `order_num`, `parent_id`, `perms`, `type`, `url`, `parent`) VALUES
(1, 'fa fa-cog', '系统管理', 0, NULL, NULL, 0, NULL, NULL),
(2, 'fa fa-user', '管理员列表', 1, 1, NULL, 1, 'modules/sys/user.html', NULL),
(3, 'fa fa-user-secret', '角色管理', 2, 1, NULL, 1, 'modules/sys/role.html', NULL),
(4, 'fa fa-th-list', '菜单管理', 3, 1, NULL, 1, 'modules/sys/menu.html', NULL),
(5, 'fa fa-bug', 'SQL监控', 4, 1, '', 1, '/druid/sql.html', NULL),
(15, NULL, '查看', 0, 2, 'sys:user:list,sys:user:info', 2, NULL, NULL),
(16, NULL, '新增', 0, 2, 'sys:user:save,sys:role:select', 2, NULL, NULL),
(17, NULL, '修改', 0, 2, 'sys:user:update,sys:role:select', 2, NULL, NULL),
(18, NULL, '删除', 0, 2, 'sys:user:delete', 2, NULL, NULL),
(19, NULL, '查看', 0, 3, 'sys:role:list,sys:role:info', 2, NULL, NULL),
(20, NULL, '新增', 0, 3, 'sys:role:save,sys:menu:list', 2, NULL, NULL),
(21, NULL, '修改', 0, 3, 'sys:role:update,sys:menu:list', 2, NULL, NULL),
(22, NULL, '删除', 0, 3, 'sys:role:delete', 2, NULL, NULL),
(23, NULL, '查看', 0, 4, 'sys:menu:list,sys:menu:info', 2, NULL, NULL),
(24, NULL, '新增', 0, 4, 'sys:menu:save,sys:menu:select', 2, NULL, NULL),
(25, NULL, '修改', 0, 4, 'sys:menu:update,sys:menu:select', 2, NULL, NULL),
(26, NULL, '删除', 0, 4, 'sys:menu:delete', 2, NULL, NULL),
(27, 'fa fa-sun-o', '参数管理', 6, 1, 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', 1, 'modules/sys/config.html', NULL),
(29, 'fa fa-file-text-o', '系统日志', 7, 1, 'sys:log:list', 1, 'modules/sys/log.html', NULL),
(33, 'fa fa-cog', '商城管理', 0, NULL, '', 0, '', NULL),
(34, 'fa fa-user-secret', '商品列表', 0, 33, '', 1, 'modules/shop/goods.html', NULL),
(35, 'fa fa-bug', '商品标签', 0, 33, '', 1, 'modules/shop/goodsTags.html', NULL),
(36, 'fa fa-user-secret', '幻灯片', 0, 33, '', 1, 'modules/shop/slide.html', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `sys_role`
--

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `sys_role`
--

INSERT INTO `sys_role` (`id`, `created`, `name`, `remark`, `user_id`) VALUES
(11, '2017-09-29 06:07:00', 'b', 'b', 1);

-- --------------------------------------------------------

--
-- 表的结构 `sys_role_menu`
--

CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL,
  `menu_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `sys_role_menu`
--

INSERT INTO `sys_role_menu` (`role_id`, `menu_id`) VALUES
(11, 1),
(11, 4),
(11, 5),
(11, 23),
(11, 24),
(11, 25),
(11, 27),
(11, 33),
(11, 34),
(11, 35),
(11, 36);

-- --------------------------------------------------------

--
-- 表的结构 `sys_role_user`
--

CREATE TABLE `sys_role_user` (
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `sys_role_user`
--

INSERT INTO `sys_role_user` (`role_id`, `user_id`) VALUES
(11, 15);

-- --------------------------------------------------------

--
-- 表的结构 `sys_user`
--

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mobile` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `status` int(11) UNSIGNED DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `sys_user`
--

INSERT INTO `sys_user` (`id`, `created`, `email`, `mobile`, `password`, `username`, `user_id`, `status`) VALUES
(1, '2017-07-27 07:56:02', 'a', 'da', 'admin', 'admin', NULL, 1),
(15, '2017-09-29 06:07:34', 'heyujia@q.com', '123', 'heyujia', 'heyujia', 1, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `y_address`
--

CREATE TABLE `y_address` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `area` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_default` tinyint(1) NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `y_address`
--

INSERT INTO `y_address` (`id`, `address`, `area`, `is_default`, `phone`, `user_id`) VALUES
(1, 'aaaa', '北京 北京市 东城区', 0, '32', 1),
(2, 'vvvv', '北京 北京市 东城区', 1, '24', 1),
(3, '4324', '北京 北京市 东城区', 0, '24', 1),
(4, 'aasv2', '北京 北京市 东城区', 0, '123', 1);

-- --------------------------------------------------------

--
-- 表的结构 `y_cart`
--

CREATE TABLE `y_cart` (
  `id` bigint(20) NOT NULL,
  `number` int(11) UNSIGNED NOT NULL DEFAULT '0',
  `goods_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `y_cart`
--

INSERT INTO `y_cart` (`id`, `number`, `goods_id`, `user_id`) VALUES
(38, 1, 5, 1);

-- --------------------------------------------------------

--
-- 表的结构 `y_goods`
--

CREATE TABLE `y_goods` (
  `id` bigint(20) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `img_url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content` text COLLATE utf8mb4_unicode_ci,
  `sale_count` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `y_goods`
--

INSERT INTO `y_goods` (`id`, `created`, `img_url`, `price`, `title`, `updated`, `content`, `sale_count`) VALUES
(5, '2017-08-07 07:51:01', '/upload/image/20170806/1502001294088085179.jpg', '134.00', '手机', '2017-08-18 06:55:52', '<p>但是 v山东 v粉丝 vds</p><p>fds</p><p>f</p><p>ds</p><p>f</p><p>ds</p><p>f</p><p>ds</p><p>f</p><p><img src=\"/upload/image/20170806/1502009572661075950.png\" alt=\"1502009572661075950.png\"/></p><p>sdf</p><p>as</p><p><br/></p><p>dfas</p><p>d</p><p>as</p><p>d</p><p>as</p><p>d</p><p>asd</p>', 0),
(6, '2017-08-09 09:41:32', '/upload/image/20170806/1502001294088085179.jpg', '12.00', '电脑', '2017-08-10 06:22:34', '<p>山东 v 水淀粉</p>', 0),
(7, '2017-08-17 08:15:22', '/upload/image/20170806/1502001294088085179.jpg', '123.00', '阿斯顿', '2017-08-18 03:09:41', '', 0),
(8, '2017-08-17 08:16:33', '/upload/image/20170806/1502001294088085179.jpg', '23.00', '玩儿', '2017-08-18 03:11:44', '', 0),
(9, '2017-08-17 08:17:09', '/upload/image/20170806/1502001294088085179.jpg', '23.00', '发的', '2017-08-17 08:17:09', '', 0),
(10, '2017-08-17 08:17:30', '/upload/image/20170806/1502001294088085179.jpg', '123.00', 'adfsd', '2017-08-17 08:17:30', '', 0),
(11, '2017-08-07 07:51:01', '/upload/image/20170806/1502001294088085179.jpg', '134.00', '手机', '2017-08-18 03:11:33', '<p>但是 v山东 v粉丝 v</p>', 0),
(12, '2017-08-09 09:41:32', '/upload/image/20170806/1502001294088085179.jpg', '12.00', '电脑', '2017-08-18 03:11:06', '<p>山东 v 水淀粉</p>', 0),
(13, '2017-08-17 08:15:22', '/upload/image/20170806/1502001294088085179.jpg', '123.00', '阿斯顿', '2017-08-18 03:11:20', '', 0),
(14, '2017-08-17 08:16:33', '/upload/image/20170806/1502001294088085179.jpg', '23.00', '玩儿', '2017-08-18 03:11:11', '', 0),
(15, '2017-08-17 08:17:09', '/upload/image/20170806/1502001294088085179.jpg', '23.00', '发的', '2017-08-17 08:17:09', '', 0),
(16, '2017-08-17 08:17:30', '/upload/image/20170806/1502001294088085179.jpg', '123.00', 'adfsd', '2017-08-18 03:26:04', '', 0),
(17, '2017-08-07 07:51:01', '/upload/image/20170806/1502001294088085179.jpg', '134.00', '手机', '2017-08-10 06:22:09', '<p>但是 v山东 v粉丝 v</p>', 0),
(18, '2017-08-09 09:41:32', '/upload/image/20170806/1502001294088085179.jpg', '12.00', '电脑', '2017-08-10 06:22:34', '<p>山东 v 水淀粉</p>', 0),
(19, '2017-08-17 08:15:22', '/upload/image/20170806/1502001294088085179.jpg', '123.00', '阿斯顿', '2017-08-17 08:15:22', '', 0),
(20, '2017-08-17 08:16:33', '/upload/image/20170806/1502001294088085179.jpg', '23.00', '玩儿', '2017-08-18 03:26:00', '', 0),
(21, '2017-08-17 08:17:09', '/upload/image/20170806/1502001294088085179.jpg', '23.00', '发的', '2017-08-18 03:15:37', '', 0),
(23, '2017-08-07 07:51:01', '/upload/image/20170806/1502001294088085179.jpg', '134.00', '手机', '2017-08-18 03:25:21', '<p>但是 v山东 v粉丝 v</p>', 0),
(24, '2017-08-09 09:41:32', '/upload/image/20170806/1502001294088085179.jpg', '12.00', '电脑', '2017-08-10 06:22:34', '<p>山东 v 水淀粉</p>', 0),
(25, '2017-08-17 08:15:22', '/upload/image/20170806/1502001294088085179.jpg', '123.00', '阿斯顿', '2017-08-17 08:15:22', '', 0),
(27, '2017-08-17 08:17:09', '/upload/image/20170806/1502001294088085179.jpg', '23.00', '发的', '2017-08-17 08:17:09', '', 0),
(28, '2017-08-17 08:17:30', '/upload/image/20170806/1502001294088085179.jpg', '123.00', 'adfsd', '2017-08-17 08:17:30', '', 0),
(29, '2017-08-17 09:18:52', '/upload/image/20170806/1502001294088085179.jpg', '123.00', 'dfs', '2017-08-17 09:18:52', '', 0),
(30, '2017-08-17 09:19:58', '/upload/image/20170806/1502001294088085179.jpg', '123.00', 'dfs', '2017-08-17 09:19:58', '', 0),
(31, '2017-08-17 09:21:10', '/upload/image/20170806/1502001294088085179.jpg', '234.00', 'vv', '2017-08-18 03:23:51', '', 0);

-- --------------------------------------------------------

--
-- 表的结构 `y_goods_gallery`
--

CREATE TABLE `y_goods_gallery` (
  `id` bigint(20) NOT NULL,
  `img_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `y_goods_gallery`
--

INSERT INTO `y_goods_gallery` (`id`, `img_url`, `goods_id`) VALUES
(1, '/upload/image/20170806/1502009685898084150.png', NULL),
(2, '/upload/image/20170806/1502013665519066525.png', NULL),
(3, '/upload/image/20170808/1502162949917077108.png', NULL),
(4, '/upload/image/20170808/1502163318461042370.jpg', NULL),
(5, '/upload/image/20170806/1502009572661075950.png', NULL),
(6, '/upload/image/20170806/1502001294088085179.jpg', NULL),
(7, '/upload/image/20170806/1502009651795014629.jpg', NULL),
(8, '/upload/image/20170806/1502012103699079223.jpg', NULL),
(9, '/upload/image/20170808/1502163318461042370.jpg', NULL),
(10, '/upload/image/20170806/1502001294088085179.jpg', NULL),
(11, '/upload/image/20170808/1502163318461042370.jpg', NULL),
(12, '/upload/image/20170806/1502009572661075950.png', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `y_goods_spec`
--

CREATE TABLE `y_goods_spec` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `y_goods_tag`
--

CREATE TABLE `y_goods_tag` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_hot` tinyint(1) NOT NULL,
  `is_show` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `y_goods_tag`
--

INSERT INTO `y_goods_tag` (`id`, `title`, `is_hot`, `is_show`) VALUES
(1, '生活', 1, 1),
(2, '家具', 1, 1);

-- --------------------------------------------------------

--
-- 表的结构 `y_goods_tags_goods`
--

CREATE TABLE `y_goods_tags_goods` (
  `tags_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `y_goods_tags_goods`
--

INSERT INTO `y_goods_tags_goods` (`tags_id`, `goods_id`) VALUES
(1, 7),
(1, 12),
(1, 13),
(1, 14),
(1, 16),
(1, 20),
(1, 21),
(1, 31),
(2, 12),
(2, 13),
(2, 14),
(2, 16),
(2, 20),
(2, 21),
(2, 31);

-- --------------------------------------------------------

--
-- 表的结构 `y_order`
--

CREATE TABLE `y_order` (
  `id` bigint(20) NOT NULL,
  `address_str` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `y_order`
--

INSERT INTO `y_order` (`id`, `address_str`, `created`, `number`, `price`, `status`, `updated`, `user_id`) VALUES
(1, '北京 北京市 东城区vvvv', '2017-08-22 06:23:37', '503383017621714', '414.00', 0, '2017-08-22 06:23:37', 1),
(2, '北京 北京市 东城区vvvv', '2017-08-22 06:26:12', '503383172292524', '414.00', 0, '2017-08-22 06:26:12', 1),
(3, '北京 北京市 东城区vvvv', '2017-08-22 06:26:14', '503383174963652', '414.00', 0, '2017-08-22 06:26:14', 1),
(4, '北京 北京市 东城区vvvv', '2017-08-22 06:26:49', '503383209972477', '414.00', 0, '2017-08-22 06:26:49', 1),
(5, '北京 北京市 东城区vvvv', '2017-08-22 06:26:52', '503383212480247', '414.00', 0, '2017-08-22 06:26:52', 1),
(6, '北京 北京市 东城区vvvv', '2017-08-22 06:27:19', '503383239829105', '414.00', 0, '2017-08-22 06:27:19', 1),
(7, '北京 北京市 东城区vvvv', '2017-08-23 01:43:39', '503452619531036', '414.00', 0, '2017-08-23 01:43:39', 1);

-- --------------------------------------------------------

--
-- 表的结构 `y_order_goods`
--

CREATE TABLE `y_order_goods` (
  `id` bigint(20) NOT NULL,
  `goods_img_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `goods_num` int(11) DEFAULT NULL,
  `goods_price` decimal(10,2) DEFAULT NULL,
  `goods_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `y_order_goods`
--

INSERT INTO `y_order_goods` (`id`, `goods_img_url`, `goods_num`, `goods_price`, `goods_title`, `goods_id`, `order_id`) VALUES
(1, '/upload/image/20170806/1502001294088085179.jpg', 3, '402.00', '手机', 5, 1),
(2, '/upload/image/20170806/1502009572661075950.png', 1, '12.00', '电脑', 6, 1),
(3, '/upload/image/20170806/1502001294088085179.jpg', 3, '402.00', '手机', 5, 2),
(4, '/upload/image/20170806/1502009572661075950.png', 1, '12.00', '电脑', 6, 2),
(5, '/upload/image/20170806/1502001294088085179.jpg', 3, '402.00', '手机', 5, 3),
(6, '/upload/image/20170806/1502009572661075950.png', 1, '12.00', '电脑', 6, 3),
(7, '/upload/image/20170806/1502001294088085179.jpg', 3, '402.00', '手机', 5, 4),
(8, '/upload/image/20170806/1502009572661075950.png', 1, '12.00', '电脑', 6, 4),
(9, '/upload/image/20170806/1502009572661075950.png', 1, '12.00', '电脑', 6, 5),
(10, '/upload/image/20170806/1502001294088085179.jpg', 3, '402.00', '手机', 5, 5),
(11, '/upload/image/20170806/1502009572661075950.png', 1, '12.00', '电脑', 6, 6),
(12, '/upload/image/20170806/1502001294088085179.jpg', 3, '402.00', '手机', 5, 6),
(13, '/upload/image/20170806/1502001294088085179.jpg', 3, '402.00', '手机', 5, 7),
(14, '/upload/image/20170806/1502009572661075950.png', 1, '12.00', '电脑', 6, 7);

-- --------------------------------------------------------

--
-- 表的结构 `y_slide`
--

CREATE TABLE `y_slide` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_show` tinyint(1) NOT NULL,
  `type` tinyint(1) NOT NULL,
  `img_url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `y_slide`
--

INSERT INTO `y_slide` (`id`, `title`, `url`, `is_show`, `type`, `img_url`) VALUES
(1, 'a', 'www.baidu.com', 1, 0, '/upload/image/20170806/1502001294088085179.jpg'),
(2, 'b', 'b', 1, 0, '/upload/image/20170806/1502001294088085179.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `y_user`
--

CREATE TABLE `y_user` (
  `id` bigint(20) NOT NULL,
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `headimgurl` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `openid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `province` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sex` tinyint(4) DEFAULT '0',
  `unionid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- 转存表中的数据 `y_user`
--

INSERT INTO `y_user` (`id`, `city`, `country`, `created`, `headimgurl`, `nickname`, `openid`, `province`, `sex`, `unionid`) VALUES
(1, '深圳', '中国', '2017-08-01 16:24:22', '/upload/image/20170806/1502001294088085179.jpg', 'jiaHey', 'otY8Fs7xXKszYKzwdmmwdjbuYPAI', '广东', 1, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sys_config`
--
ALTER TABLE `sys_config`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `sys_log`
--
ALTER TABLE `sys_log`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sys_menu`
--
ALTER TABLE `sys_menu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2jrf4gb0gjqi8882gxytpxnhe` (`parent_id`);

--
-- Indexes for table `sys_role`
--
ALTER TABLE `sys_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKce4uus2biaik6iv5wtwteetb2` (`user_id`);

--
-- Indexes for table `sys_role_menu`
--
ALTER TABLE `sys_role_menu`
  ADD PRIMARY KEY (`role_id`,`menu_id`),
  ADD KEY `FKf3mud4qoc7ayew8nml4plkevo` (`menu_id`);

--
-- Indexes for table `sys_role_user`
--
ALTER TABLE `sys_role_user`
  ADD PRIMARY KEY (`role_id`,`user_id`),
  ADD KEY `FK1qf7bu5lhwt9y00uesmcgnbxd` (`user_id`);

--
-- Indexes for table `sys_user`
--
ALTER TABLE `sys_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrg8wsmjn9ruu4k700hnq3oxtm` (`user_id`);

--
-- Indexes for table `y_address`
--
ALTER TABLE `y_address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKini0e7s2nlxcguuyt32q5lbl0` (`user_id`);

--
-- Indexes for table `y_cart`
--
ALTER TABLE `y_cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKip1856jt94eo54j97qdrq3bil` (`goods_id`),
  ADD KEY `FKtbj7ccvhwn3dtlb675cq3apid` (`user_id`);

--
-- Indexes for table `y_goods`
--
ALTER TABLE `y_goods`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `y_goods_gallery`
--
ALTER TABLE `y_goods_gallery`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfol7rag41cnavd8owb63n9mf5` (`goods_id`);

--
-- Indexes for table `y_goods_spec`
--
ALTER TABLE `y_goods_spec`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqiwsepfal7ia08hm3e3py294o` (`goods_id`);

--
-- Indexes for table `y_goods_tag`
--
ALTER TABLE `y_goods_tag`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `y_goods_tags_goods`
--
ALTER TABLE `y_goods_tags_goods`
  ADD PRIMARY KEY (`goods_id`,`tags_id`),
  ADD KEY `FKd35qcvwe90s48utep3vtu05o1` (`tags_id`);

--
-- Indexes for table `y_order`
--
ALTER TABLE `y_order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg87q234wyqwr6mbjlwqeco86q` (`user_id`);

--
-- Indexes for table `y_order_goods`
--
ALTER TABLE `y_order_goods`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjdtasvaejqw2tqgxacgqxgsx2` (`goods_id`),
  ADD KEY `FK1t1tfnuuygtyhb5e4psc5ulg` (`order_id`);

--
-- Indexes for table `y_slide`
--
ALTER TABLE `y_slide`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `y_user`
--
ALTER TABLE `y_user`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `sys_log`
--
ALTER TABLE `sys_log`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- 使用表AUTO_INCREMENT `sys_menu`
--
ALTER TABLE `sys_menu`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- 使用表AUTO_INCREMENT `sys_role`
--
ALTER TABLE `sys_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- 使用表AUTO_INCREMENT `sys_user`
--
ALTER TABLE `sys_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- 使用表AUTO_INCREMENT `y_address`
--
ALTER TABLE `y_address`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- 使用表AUTO_INCREMENT `y_cart`
--
ALTER TABLE `y_cart`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
--
-- 使用表AUTO_INCREMENT `y_goods`
--
ALTER TABLE `y_goods`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- 使用表AUTO_INCREMENT `y_goods_gallery`
--
ALTER TABLE `y_goods_gallery`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- 使用表AUTO_INCREMENT `y_goods_spec`
--
ALTER TABLE `y_goods_spec`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `y_goods_tag`
--
ALTER TABLE `y_goods_tag`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `y_order`
--
ALTER TABLE `y_order`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- 使用表AUTO_INCREMENT `y_order_goods`
--
ALTER TABLE `y_order_goods`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- 使用表AUTO_INCREMENT `y_slide`
--
ALTER TABLE `y_slide`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `y_user`
--
ALTER TABLE `y_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- 限制导出的表
--

--
-- 限制表 `sys_menu`
--
ALTER TABLE `sys_menu`
  ADD CONSTRAINT `FK2jrf4gb0gjqi8882gxytpxnhe` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`);

--
-- 限制表 `sys_role`
--
ALTER TABLE `sys_role`
  ADD CONSTRAINT `FKce4uus2biaik6iv5wtwteetb2` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`);

--
-- 限制表 `sys_role_menu`
--
ALTER TABLE `sys_role_menu`
  ADD CONSTRAINT `FKf3mud4qoc7ayew8nml4plkevo` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`),
  ADD CONSTRAINT `FKkeitxsgxwayackgqllio4ohn5` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`);

--
-- 限制表 `sys_role_user`
--
ALTER TABLE `sys_role_user`
  ADD CONSTRAINT `FK1qf7bu5lhwt9y00uesmcgnbxd` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  ADD CONSTRAINT `FKe853e1gbgbb6ov7al35mfd3nm` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`);

--
-- 限制表 `sys_user`
--
ALTER TABLE `sys_user`
  ADD CONSTRAINT `FKrg8wsmjn9ruu4k700hnq3oxtm` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`);

--
-- 限制表 `y_address`
--
ALTER TABLE `y_address`
  ADD CONSTRAINT `FKini0e7s2nlxcguuyt32q5lbl0` FOREIGN KEY (`user_id`) REFERENCES `y_user` (`id`);

--
-- 限制表 `y_cart`
--
ALTER TABLE `y_cart`
  ADD CONSTRAINT `FKip1856jt94eo54j97qdrq3bil` FOREIGN KEY (`goods_id`) REFERENCES `y_goods` (`id`),
  ADD CONSTRAINT `FKtbj7ccvhwn3dtlb675cq3apid` FOREIGN KEY (`user_id`) REFERENCES `y_user` (`id`);

--
-- 限制表 `y_goods_gallery`
--
ALTER TABLE `y_goods_gallery`
  ADD CONSTRAINT `FKfol7rag41cnavd8owb63n9mf5` FOREIGN KEY (`goods_id`) REFERENCES `y_goods` (`id`);

--
-- 限制表 `y_goods_spec`
--
ALTER TABLE `y_goods_spec`
  ADD CONSTRAINT `FKqiwsepfal7ia08hm3e3py294o` FOREIGN KEY (`goods_id`) REFERENCES `y_goods` (`id`);

--
-- 限制表 `y_goods_tags_goods`
--
ALTER TABLE `y_goods_tags_goods`
  ADD CONSTRAINT `FK5xkqq6pgxbwv38b7gsff5inqh` FOREIGN KEY (`goods_id`) REFERENCES `y_goods` (`id`),
  ADD CONSTRAINT `FKd35qcvwe90s48utep3vtu05o1` FOREIGN KEY (`tags_id`) REFERENCES `y_goods_tag` (`id`);

--
-- 限制表 `y_order`
--
ALTER TABLE `y_order`
  ADD CONSTRAINT `FKg87q234wyqwr6mbjlwqeco86q` FOREIGN KEY (`user_id`) REFERENCES `y_user` (`id`);

--
-- 限制表 `y_order_goods`
--
ALTER TABLE `y_order_goods`
  ADD CONSTRAINT `FK1t1tfnuuygtyhb5e4psc5ulg` FOREIGN KEY (`order_id`) REFERENCES `y_order` (`id`),
  ADD CONSTRAINT `FKjdtasvaejqw2tqgxacgqxgsx2` FOREIGN KEY (`goods_id`) REFERENCES `y_goods` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
