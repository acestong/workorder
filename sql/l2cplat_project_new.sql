/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.10
 Source Server Type    : MySQL
 Source Server Version : 50624
 Source Host           : 192.168.1.10:3306
 Source Schema         : l2cplat_project_new

 Target Server Type    : MySQL
 Target Server Version : 50624
 File Encoding         : 65001

 Date: 21/11/2019 17:04:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_project_appendix
-- ----------------------------
DROP TABLE IF EXISTS `t_project_appendix`;
CREATE TABLE `t_project_appendix`  (
  `id` bigint(64) NOT NULL COMMENT '附件id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `real_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '附件URL',
  `business_id` bigint(64) NULL DEFAULT NULL COMMENT '业务id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识（0未删除， 1删除了）',
  `file_size` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件大小',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '附件表 ' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_appendix
-- ----------------------------
INSERT INTO `t_project_appendix` VALUES (347551957138976768, NULL, '广大.jpg', 'D://uploads\\1571974453994.jpg', 349360462380568576, '曹操', '2019-10-25 11:34:14', NULL, NULL, 0, '10.71K');
INSERT INTO `t_project_appendix` VALUES (347551957629710336, NULL, '华姐.jpeg', 'D://uploads\\1571974454114.jpeg', 349360462380568576, '曹操', '2019-10-25 11:34:14', NULL, NULL, 0, '3.95K');
INSERT INTO `t_project_appendix` VALUES (347552029469749248, NULL, '广大.jpg', 'D://uploads\\1571974471252.jpg', 346911325080940544, '曹操', '2019-10-25 11:34:31', NULL, NULL, 0, '10.71K');
INSERT INTO `t_project_appendix` VALUES (347552483041783808, NULL, '广大.jpg', 'D://uploads\\1571974579378.jpg', 346911325080940544, '曹操', '2019-10-25 11:36:19', NULL, NULL, 0, '10.71K');
INSERT INTO `t_project_appendix` VALUES (347553190838972416, NULL, '广大.jpg', 'D://uploads\\1571974748142.jpg', 346909396464463872, '曹操', '2019-10-25 11:39:08', NULL, NULL, 0, '10.71K');
INSERT INTO `t_project_appendix` VALUES (352620734683770880, '', 'upload.txt', 'D://uploads\\1573182944746.txt', 352622717993971712, '曹操', '2019-11-08 11:15:45', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (352622456856604672, '', 'upload2.txt', 'D://uploads\\1573183355332.txt', 352622810218328064, '曹操', '2019-11-08 11:22:35', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (352675116775337984, '', 'upload.txt', 'D://uploads\\1573195910430.txt', 352675140749979648, '曹操', '2019-11-08 14:51:50', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (352677230578724864, '', 'upload2.txt', 'D://uploads\\1573196414417.txt', 352677248790392832, '曹操', '2019-11-08 15:00:14', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (352678529835692032, '', 'upload.txt', 'D://uploads\\1573196724184.txt', NULL, '曹操', '2019-11-08 15:05:24', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (352685531106340864, '', 'upload.txt', 'D://uploads\\1573198393403.txt', 352685535858487296, '曹操', '2019-11-08 15:33:13', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (353748666659598336, '', 'upload2.txt', 'D://uploads\\1573451864668.txt', 353748805704970240, '曹操', '2019-11-11 13:57:45', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354147552742043648, '', 'upload2.txt', 'D://uploads\\1573546966524.txt', 356948883951362048, '曹操', '2019-11-12 16:22:47', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354147610665381888, '', 'upload2.txt', 'D://uploads\\1573546980349.txt', 356948883951362048, '曹操', '2019-11-12 16:23:00', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354156112167268352, '', 'TEST002.sql', 'D://uploads\\1573549007261.sql', 354163279142285312, '曹操', '2019-11-12 16:56:47', NULL, NULL, 0, '5.50K');
INSERT INTO `t_project_appendix` VALUES (354156427310493696, '', 'upload2.txt', 'D://uploads\\1573549082400.txt', 354156506004025344, '曹操', '2019-11-12 16:58:02', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354158150192164864, '', 'data.txt', 'D://uploads\\1573549493167.txt', 354163279142285312, '曹操', '2019-11-12 17:04:53', NULL, NULL, 0, '0.67K');
INSERT INTO `t_project_appendix` VALUES (354161977683308544, '', '新建文本文档.txt', 'D://uploads\\1573550405711.txt', 354162016795193344, '曹操', '2019-11-12 17:20:06', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (354163067149578240, '', 'data.txt', 'D://uploads\\1573550665462.txt', 354163168421048320, '曹操', '2019-11-12 17:24:25', NULL, NULL, 0, '0.67K');
INSERT INTO `t_project_appendix` VALUES (354166112625324032, '', '新建文本文档.txt', 'D://uploads\\1573551391559.txt', 354166175623770112, '曹操', '2019-11-12 17:36:32', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (354166228585246720, '', '新建文本文档.txt', 'D://uploads\\1573551419206.txt', 354166241579200512, '曹操', '2019-11-12 17:36:59', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (354166387998158848, '', '新建文本文档.txt', 'D://uploads\\1573551457214.txt', 1, '曹操', '2019-11-12 17:37:37', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (354411627826941952, '', 'upload2.txt', 'D://uploads\\1573609926940.txt', NULL, '曹操', '2019-11-13 09:52:07', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354420634096537600, '', 'upload2.txt', 'D://uploads\\1573612074204.txt', NULL, '曹操', '2019-11-13 10:27:54', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354420975764541440, '', 'upload2.txt', 'D://uploads\\1573612155663.txt', NULL, '曹操', '2019-11-13 10:29:16', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354421555824201728, '', 'upload.txt', 'D://uploads\\1573612293965.txt', NULL, '曹操', '2019-11-13 10:31:34', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354422212362801152, '', 'upload2.txt', 'D://uploads\\1573612450495.txt', NULL, '曹操', '2019-11-13 10:34:10', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354422212375384064, '', 'upload.txt', 'D://uploads\\1573612450498.txt', NULL, '曹操', '2019-11-13 10:34:10', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354422520618979328, '', 'upload.txt', 'D://uploads\\1573612523990.txt', NULL, '曹操', '2019-11-13 10:35:24', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354422917823762432, '', 'upload2.txt', 'D://uploads\\1573612618686.txt', NULL, '曹操', '2019-11-13 10:36:59', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354423538551394304, '', 'upload2.txt', 'D://uploads\\1573612766684.txt', NULL, '曹操', '2019-11-13 10:39:27', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354423918932824064, '', 'upload2.txt', 'D://uploads\\1573612857375.txt', NULL, '曹操', '2019-11-13 10:40:57', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354424052072615936, '', 'upload.txt', 'D://uploads\\1573612889118.txt', NULL, '曹操', '2019-11-13 10:41:29', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354424124667629568, '', 'upload.txt', 'D://uploads\\1573612906423.txt', NULL, '曹操', '2019-11-13 10:41:46', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354424186017714176, '', 'upload.txt', 'D://uploads\\1573612921052.txt', NULL, '曹操', '2019-11-13 10:42:01', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354425198476562432, '', 'upload.txt', 'D://uploads\\1573613162396.txt', NULL, '曹操', '2019-11-13 10:46:02', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354425350687854592, '', 'upload.txt', 'D://uploads\\1573613198729.txt', NULL, '曹操', '2019-11-13 10:46:39', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354427192725508096, '', 'upload.txt', 'D://uploads\\1573613637900.txt', 354438238810968064, '曹操', '2019-11-13 10:53:58', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354427681663913984, '', 'upload2.txt', 'D://uploads\\1573613754480.txt', NULL, '曹操', '2019-11-13 10:55:54', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354436214555971584, '', 'upload.txt', 'D://uploads\\1573615788874.txt', NULL, '曹操', '2019-11-13 11:29:49', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354437236431032320, '', 'upload.txt', 'D://uploads\\1573616032508.txt', NULL, '曹操', '2019-11-13 11:33:53', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354437524743294976, '', 'upload.txt', 'D://uploads\\1573616101248.txt', NULL, '曹操', '2019-11-13 11:35:01', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354438147161231360, '', 'upload.txt', 'D://uploads\\1573616249644.txt', NULL, '曹操', '2019-11-13 11:37:30', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354440142228066304, '', 'upload.txt', '1573616725309.txt', NULL, '曹操', '2019-11-13 11:45:25', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354440434889822208, '', 'upload.txt', 'D://uploads\\1573616795085.txt', NULL, '曹操', '2019-11-13 11:46:35', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354443536757985280, '', 'upload.txt', 'D://uploads\\1573617534624.txt', NULL, '曹操', '2019-11-13 11:58:55', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354489157971906560, '', 'upload.txt', 'D://uploads\\1573628411526.txt', NULL, '曹操', '2019-11-13 15:00:12', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354492844538630144, '', 'upload.txt', 'D://uploads\\1573629290447.txt', NULL, '曹操', '2019-11-13 15:14:50', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354493875771183104, '', 'upload.txt', 'D://uploads\\1573629536371.txt', 354493890430275584, '曹操', '2019-11-13 15:18:56', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354495849472233472, '', 'upload.txt', 'D://uploads\\1573630006919.txt', NULL, '曹操', '2019-11-13 15:26:47', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354496294890541056, '', 'upload.txt', 'D://uploads\\1573630113141.txt', NULL, '曹操', '2019-11-13 15:28:33', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354497458960896000, '', 'upload.txt', 'D://uploads\\1573630390668.txt', NULL, '曹操', '2019-11-13 15:33:11', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354770813710540800, '', 'upload.txt', 'D://uploads\\1573695563527.txt', NULL, '曹操', '2019-11-14 09:39:24', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354770981541421056, '', 'upload2.txt', 'D://uploads\\1573695603540.txt', NULL, '曹操', '2019-11-14 09:40:04', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354778194498592768, '', 'upload.txt', 'D://uploads\\1573697323243.txt', NULL, '曹操', '2019-11-14 10:08:43', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354779020084420608, '', 'upload.txt', 'D://uploads\\1573697520079.txt', NULL, '曹操', '2019-11-14 10:12:00', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354779674714611712, '', 'upload2.txt', 'D://uploads\\1573697676155.txt', NULL, '曹操', '2019-11-14 10:14:36', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354783691536637952, '', 'upload.txt', 'D://uploads\\1573698633840.txt', NULL, '曹操', '2019-11-14 10:30:34', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354784806349086720, '', '测试附件.txt', 'D://uploads\\1573698899632.txt', NULL, '曹操', '2019-11-14 10:35:00', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354785304020033536, '', '测试附件.txt', 'D://uploads\\1573699018286.txt', NULL, '曹操', '2019-11-14 10:36:58', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354793287173054464, '', '新建文本文档.txt', 'D://uploads\\1573700921617.txt', NULL, '曹操', '2019-11-14 11:08:42', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (354800344928395264, '', '测试附件.txt', '1573702604298.txt', NULL, '曹操', '2019-11-14 11:36:44', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354848742108864512, '', '附件上传.txt', '1573714143110.txt', NULL, '曹操', '2019-11-14 14:49:03', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (354848980936728576, '', '附件上传.txt', '1573714200052.txt', NULL, '曹操', '2019-11-14 14:50:00', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (354855209977290752, '', 'upload2.txt', '1573715685158.txt', 354855231041085440, '曹操', '2019-11-14 15:14:45', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354855899793498112, '', 'test.txt', '1573715849633.txt', NULL, '曹操', '2019-11-14 15:17:30', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (354857018330488832, '', 'test.txt', '1573716116317.txt', NULL, '曹操', '2019-11-14 15:21:56', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (354857507847708672, '', 'test.txt', '1573716233026.txt', NULL, '曹操', '2019-11-14 15:23:53', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (354858545422049280, '', 'test.txt', '1573716480407.txt', 354858556042027008, '曹操', '2019-11-14 15:28:00', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (354858615898939392, '', 'upload.txt', '1573716497210.txt', NULL, '曹操', '2019-11-14 15:28:17', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354859171958792192, '', 'test.txt', '1573716629768.txt', NULL, '曹操', '2019-11-14 15:30:30', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (354860633019424768, '', 'test.txt', '1573716978121.txt', NULL, '曹操', '2019-11-14 15:36:18', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (354861659218812928, '', 'test.txt', '1573717222779.txt', NULL, '曹操', '2019-11-14 15:40:23', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (354861937947090944, '', 'upload.txt', '1573717289245.txt', NULL, '曹操', '2019-11-14 15:41:29', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (354862252683468800, '', 'test.txt', '1573717364272.txt', NULL, '曹操', '2019-11-14 15:42:44', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (355199161750319104, '', '123.txt', '1573797689658.txt', NULL, '曹操', '2019-11-15 14:01:30', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (355199228745936896, '', 'upload.txt', '1573797705638.txt', NULL, '曹操', '2019-11-15 14:01:46', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (355594554967367680, '', 'upload2.txt', 'D://uploads\\1573891958743.txt', NULL, '何革学', '2019-11-16 16:12:39', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (355594962880208896, '', 'upload2.txt', 'D://uploads\\1573892056008.txt', 355594969972776960, '何革学', '2019-11-16 16:14:16', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (355595310864834560, '', 'test.txt', 'D://uploads\\1573892138974.txt', NULL, '何革学', '2019-11-16 16:15:39', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (355611373774086144, '', 'upload.txt', 'D://uploads\\1573895968667.txt', NULL, '何革学', '2019-11-16 17:19:29', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (355612063451881472, '', 'test.txt', 'D://uploads\\1573896133099.txt', NULL, '何革学', '2019-11-16 17:22:13', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (355619338929348608, '', 'upload.txt', 'D://uploads\\1573897867708.txt', NULL, '何革学', '2019-11-16 17:51:08', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (355620338125807616, '', 'test.txt', 'D://uploads\\1573898105938.txt', NULL, '何革学', '2019-11-16 17:55:06', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (355620812447064064, '', 'upload2.txt', 'D://uploads\\1573898219025.txt', NULL, '何革学', '2019-11-16 17:56:59', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (355622466609258496, '', '新建文本文档.txt', 'D://uploads\\1573898613353.txt', NULL, '何革学', '2019-11-16 18:03:33', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (355626417803010048, '', '新建文本文档.txt', 'D://uploads\\1573899555440.txt', 355626432097198080, '何革学', '2019-11-16 18:19:15', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (355627727264718848, '', '新建文本文档.txt', 'D://uploads\\1573899867640.txt', 355627769773989888, '何革学', '2019-11-16 18:24:28', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (355628371274932224, '', '新建文本文档.txt', 'D://uploads\\1573900021120.txt', 355628375062388736, '何革学', '2019-11-16 18:27:01', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (355628455890821120, '', '新建文本文档.txt', 'D://uploads\\1573900041364.txt', NULL, '何革学', '2019-11-16 18:27:21', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (355628988772950016, '', '交接文档(1).docx', 'D://uploads\\1573900168412.docx', 355629017688481792, '何革学', '2019-11-16 18:29:28', NULL, NULL, 0, '858.81K');
INSERT INTO `t_project_appendix` VALUES (355629225625296896, '', '交接文档(1).docx', 'D://uploads\\1573900224883.docx', 356305073021952000, '何革学', '2019-11-16 18:30:25', NULL, NULL, 0, '858.81K');
INSERT INTO `t_project_appendix` VALUES (356310776906293248, '', 'upload.txt', 'D://uploads\\1574062719365.txt', NULL, '何革学', '2019-11-18 15:38:39', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356313172097146880, '', 'upload.txt', 'D://uploads\\1574063290425.txt', 356314676082286592, '何革学', '2019-11-18 15:48:10', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356313407796060160, '', 'upload.txt', 'D://uploads\\1574063346624.txt', NULL, '何革学', '2019-11-18 15:49:07', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356313481326403584, '', 'upload.txt', 'D://uploads\\1574063364156.txt', NULL, '何革学', '2019-11-18 15:49:24', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356313577585680384, '', 'upload.txt', 'D://uploads\\1574063387105.txt', NULL, '何革学', '2019-11-18 15:49:47', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356315401826902016, '', 'upload.txt', 'D://uploads\\1574063822032.txt', 356315416657960960, '何革学', '2019-11-18 15:57:02', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356315938697814016, '', 'upload.txt', 'D://uploads\\1574063950038.txt', 356315957832228864, '何革学', '2019-11-18 15:59:10', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356319348725686272, '', 'upload.txt', 'D://uploads\\1574064763046.txt', 356319391692136448, '何革学', '2019-11-18 16:12:43', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356333888108535808, '', 'upload.txt', 'D://uploads\\1574068229505.txt', NULL, '何革学', '2019-11-18 17:10:30', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356334133706006528, '', 'upload.txt', 'D://uploads\\1574068288059.txt', NULL, '何革学', '2019-11-18 17:11:28', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356335374272077824, '', 'upload.txt', 'D://uploads\\1574068583835.txt', NULL, '何革学', '2019-11-18 17:16:24', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356335462172106752, '', 'upload.txt', 'D://uploads\\1574068604798.txt', NULL, '何革学', '2019-11-18 17:16:45', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356336784514523136, '', 'upload.txt', 'D://uploads\\1574068920051.txt', NULL, '何革学', '2019-11-18 17:22:00', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356338753576673280, '', 'upload.txt', 'D://uploads\\1574069389530.txt', NULL, '何革学', '2019-11-18 17:29:50', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356340927501213696, '', 'upload.txt', 'D://uploads\\1574069907828.txt', NULL, '何革学', '2019-11-18 17:38:28', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356346640688521216, '', 'upload.txt', 'D://uploads\\1574071269958.txt', NULL, '何革学', '2019-11-18 18:01:10', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356358148638154752, '', 'upload.txt', 'D://uploads\\1574074013666.txt', 356358163481796608, '何革学', '2019-11-18 18:46:54', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356358249477611520, '', 'upload.txt', 'D://uploads\\1574074037715.txt', NULL, '何革学', '2019-11-18 18:47:18', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356358614717603840, '', 'upload2.txt', 'D://uploads\\1574074124786.txt', NULL, '何革学', '2019-11-18 18:48:45', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356359504459505664, '', '新建文本文档.txt', 'D://uploads\\1574074336911.txt', NULL, '何革学', '2019-11-18 18:52:17', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (356359953820459008, '', 'upload2.txt', 'D://uploads\\1574074444061.txt', 356359967451947008, '何革学', '2019-11-18 18:54:04', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356360336441647104, '', 'upload2.txt', 'D://uploads\\1574074535286.txt', 356360348340887552, '何革学', '2019-11-18 18:55:35', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356360456893669376, '', '114地址.txt', 'D://uploads\\1574074564003.txt', NULL, '何革学', '2019-11-18 18:56:04', NULL, NULL, 0, '0.13K');
INSERT INTO `t_project_appendix` VALUES (356360456944001024, '', '123.txt', 'D://uploads\\1574074564015.txt', NULL, '何革学', '2019-11-18 18:56:04', NULL, NULL, 0, '0.00K');
INSERT INTO `t_project_appendix` VALUES (356360545045356544, '', 'upload.txt', 'D://uploads\\1574074585020.txt', NULL, '何革学', '2019-11-18 18:56:25', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356360815997394944, '', '新建文本文档.txt', 'D://uploads\\1574074649612.txt', 356360829272367104, '何革学', '2019-11-18 18:57:30', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (356361330080653312, '', '新增计划模块.doc', 'D://uploads\\1574074772131.doc', 356361344181903360, '何革学', '2019-11-18 18:59:32', NULL, NULL, 0, '84.04K');
INSERT INTO `t_project_appendix` VALUES (356361422833491968, '', '新建文本文档.txt', 'D://uploads\\1574074794301.txt', 356683693276037120, '何革学', '2019-11-18 18:59:54', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (356704676909187072, '', 'upload.txt', 'D://uploads\\1574156632443.txt', NULL, '何革学', '2019-11-19 17:43:52', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356714672099196928, '', 'upload.txt', 'D://uploads\\1574159015484.txt', NULL, '何革学', '2019-11-19 18:23:35', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356722899318767616, '', 'upload2.txt', 'D://uploads\\1574160977007.txt', 356722910198792192, '何革学', '2019-11-19 18:56:17', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356733165196574720, '', 'upload.txt', 'D://uploads\\1574163424586.txt', 356951436457975808, '何革学', '2019-11-19 19:37:05', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356735465726181376, '', 'upload.txt', 'D://uploads\\1574163973077.txt', 356951436457975808, '何革学', '2019-11-19 19:46:13', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356953170332917760, '', 'upload.txt', 'D://uploads\\1574215877893.txt', NULL, '何革学', '2019-11-20 10:11:18', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356954963620175872, '', 'upload.txt', 'D://uploads\\1574216305452.txt', 356954968116469760, '何革学', '2019-11-20 10:18:25', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356958607459524608, '', '销售线索11(1).xls', 'D://uploads\\1574217174205.xls', 356958641911537664, '何革学', '2019-11-20 10:32:54', NULL, NULL, 0, '134.00K');
INSERT INTO `t_project_appendix` VALUES (356959246776311808, '', '新建文本文档.txt', 'D://uploads\\1574217326636.txt', NULL, '何革学', '2019-11-20 10:35:27', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (356960563108290560, '', '新建文本文档.txt', 'D://uploads\\1574217640468.txt', NULL, '何革学', '2019-11-20 10:40:40', NULL, NULL, 0, '0.68K');
INSERT INTO `t_project_appendix` VALUES (356960953937731584, '', 'upload.txt', 'D://uploads\\1574217733656.txt', NULL, '何革学', '2019-11-20 10:42:14', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356961124595572736, '', 'upload.txt', 'D://uploads\\1574217774343.txt', NULL, '何革学', '2019-11-20 10:42:54', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356961381685436416, '', 'notepad++.exe', 'D://uploads\\1574217835633.exe', 356961422957387776, '何革学', '2019-11-20 10:43:56', NULL, NULL, 0, '2.73M');
INSERT INTO `t_project_appendix` VALUES (356963540959272960, '', 'upload.txt', 'D://uploads\\1574218350444.txt', 356963555215712256, '何革学', '2019-11-20 10:52:30', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356963859919314944, '', 'change.log', 'D://uploads\\1574218426495.log', 356963924595482624, '何革学', '2019-11-20 10:53:46', NULL, NULL, 0, '0.93K');
INSERT INTO `t_project_appendix` VALUES (356964315886297088, '', 'LICENSE', 'D://uploads\\1574218535207', 356964357275688960, '何革学', '2019-11-20 10:55:35', NULL, NULL, 0, '15.82K');
INSERT INTO `t_project_appendix` VALUES (356964456198348800, '', 'NppShell_06.dll', 'D://uploads\\1574218568660.dll', 356964520408948736, '何革学', '2019-11-20 10:56:09', NULL, NULL, 0, '224.64K');
INSERT INTO `t_project_appendix` VALUES (356981916435783680, '', 'upload2.txt', 'D://uploads\\1574222731504.txt', 356981929043861504, '何革学', '2019-11-20 12:05:32', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356982050406047744, '', 'upload.txt', 'D://uploads\\1574222763446.txt', 356982053719547904, '何革学', '2019-11-20 12:06:03', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356982106127376384, '', 'upload2.txt', 'D://uploads\\1574222776730.txt', 356982109587677184, '何革学', '2019-11-20 12:06:17', NULL, NULL, 0, '0.01K');
INSERT INTO `t_project_appendix` VALUES (356982166097534976, '', 'upload.txt', 'D://uploads\\1574222791028.txt', 356982168689614848, '何革学', '2019-11-20 12:06:31', NULL, NULL, 0, '0.01K');

-- ----------------------------
-- Table structure for t_project_apply
-- ----------------------------
DROP TABLE IF EXISTS `t_project_apply`;
CREATE TABLE `t_project_apply`  (
  `id` bigint(64) NOT NULL,
  `apply_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `business_id` bigint(64) NULL DEFAULT NULL,
  `business_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `applyer_id` bigint(64) NULL DEFAULT NULL,
  `apply_depart` bigint(255) NULL DEFAULT NULL,
  `apply_time` datetime(0) NULL DEFAULT NULL,
  `verify_status` int(2) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `apply_type` int(2) NULL DEFAULT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL,
  `stop_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `business_flow_id` bigint(64) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_apply
-- ----------------------------
INSERT INTO `t_project_apply` VALUES (1, '123', '项目创建申请', 1, 'Project123456', 380, 283, '2019-11-19 14:07:01', 1, NULL, NULL, NULL, NULL, NULL, NULL, 0, 16, 1, NULL, NULL);

-- ----------------------------
-- Table structure for t_project_apply_advise
-- ----------------------------
DROP TABLE IF EXISTS `t_project_apply_advise`;
CREATE TABLE `t_project_apply_advise`  (
  `id` bigint(64) NOT NULL,
  `apply_id` bigint(64) NULL DEFAULT NULL,
  `user_id` bigint(64) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_apply_flow_info
-- ----------------------------
DROP TABLE IF EXISTS `t_project_apply_flow_info`;
CREATE TABLE `t_project_apply_flow_info`  (
  `id` bigint(64) NOT NULL,
  `apply_id` bigint(64) NULL DEFAULT NULL COMMENT '申请单号',
  `business_flow_verify_id` bigint(20) NULL DEFAULT NULL COMMENT '实际业务的流程id',
  `person_type` int(2) NULL DEFAULT NULL COMMENT '人员类型',
  `verify_type` int(2) NULL DEFAULT NULL COMMENT '审核类型（获签/会签）',
  `verify_status` int(2) NULL DEFAULT NULL COMMENT '审核状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_apply_flow_toward
-- ----------------------------
DROP TABLE IF EXISTS `t_project_apply_flow_toward`;
CREATE TABLE `t_project_apply_flow_toward`  (
  `id` bigint(64) NOT NULL,
  `apply_id` bigint(64) NULL DEFAULT NULL COMMENT '申请单号',
  `business_flow_verify_id` bigint(20) NULL DEFAULT NULL COMMENT '实际业务的流程id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_apply_flow_verify
-- ----------------------------
DROP TABLE IF EXISTS `t_project_apply_flow_verify`;
CREATE TABLE `t_project_apply_flow_verify`  (
  `id` bigint(64) NOT NULL,
  `apply_id` bigint(64) NULL DEFAULT NULL,
  `apply_flow_id` bigint(20) NULL DEFAULT NULL,
  `verifyer_id` bigint(64) NULL DEFAULT NULL,
  `verify_status` int(2) NULL DEFAULT NULL,
  `verify_result` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `action_time` datetime(0) NULL DEFAULT NULL,
  `stop_time` datetime(0) NULL DEFAULT NULL,
  `describe` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_baseset_flow
-- ----------------------------
DROP TABLE IF EXISTS `t_project_baseset_flow`;
CREATE TABLE `t_project_baseset_flow`  (
  `id` bigint(20) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL COMMENT '组织id',
  `type_id` int(64) NULL DEFAULT NULL COMMENT '类型id',
  `type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `state` int(2) NULL DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_baseset_flow
-- ----------------------------
INSERT INTO `t_project_baseset_flow` VALUES (354498662571319296, 204, 16, 'project_verify', 1, '2', 380, '何革学', '2019-11-13 15:37:58', 380, '何革学', '2019-11-18 10:53:31', 0);
INSERT INTO `t_project_baseset_flow` VALUES (354498662571319297, 204, 17, 'project_verify', 0, '5', 380, '何革学', '2019-11-13 15:37:58', 380, '何革学', '2019-11-18 10:53:31', 0);

-- ----------------------------
-- Table structure for t_project_baseset_plan
-- ----------------------------
DROP TABLE IF EXISTS `t_project_baseset_plan`;
CREATE TABLE `t_project_baseset_plan`  (
  `id` bigint(64) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL,
  `type_id` int(2) NULL DEFAULT NULL,
  `short_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dataStr` int(2) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `number` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_baseset_plan
-- ----------------------------
INSERT INTO `t_project_baseset_plan` VALUES (354511797537611776, 204, 2, 'wfff', 1, 380, '何革学', '2019-11-13 16:30:09', 380, '何革学', '2019-11-18 10:53:31', 0, 1);
INSERT INTO `t_project_baseset_plan` VALUES (354511797550194688, 204, 2, 'w', 1, 380, '何革学', '2019-11-13 16:30:09', 380, '何革学', '2019-11-18 10:53:31', 0, 1);

-- ----------------------------
-- Table structure for t_project_baseset_task
-- ----------------------------
DROP TABLE IF EXISTS `t_project_baseset_task`;
CREATE TABLE `t_project_baseset_task`  (
  `id` bigint(64) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL,
  `type_id` int(2) NULL DEFAULT NULL,
  `short_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `dataStr` int(2) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `number` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_baseset_task
-- ----------------------------
INSERT INTO `t_project_baseset_task` VALUES (354772894253457408, 204, 1, '1', 1, 380, '何革学', '2019-11-14 09:47:40', 380, '何革学', '2019-11-18 10:53:31', 0, 1);
INSERT INTO `t_project_baseset_task` VALUES (354772894274428928, 204, 1, '1', 1, 380, '何革学', '2019-11-14 09:47:40', 380, '何革学', '2019-11-18 10:53:31', 0, 1);
INSERT INTO `t_project_baseset_task` VALUES (354772894291206144, 204, 1, '1', 1, 380, '何革学', '2019-11-14 09:47:40', 380, '何革学', '2019-11-18 10:53:31', 0, 1);

-- ----------------------------
-- Table structure for t_project_business_flow
-- ----------------------------
DROP TABLE IF EXISTS `t_project_business_flow`;
CREATE TABLE `t_project_business_flow`  (
  `id` bigint(64) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `flow_type` int(255) NULL DEFAULT NULL,
  `state` int(255) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `cant_change_verifyer` int(2) NULL DEFAULT NULL,
  `cant_change_copyer` int(2) NULL DEFAULT NULL,
  `verify_cant_revert` int(2) NULL DEFAULT NULL,
  `copy_set_type` int(2) NULL DEFAULT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '选填，如果填了，其他项目选择流程时，该流程无法获取',
  `original_id` bigint(64) NULL DEFAULT NULL COMMENT 't_project_flow表真实id',
  `list_id` bigint(64) NULL DEFAULT NULL COMMENT 'flowList选择的业务',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_business_flow_copyer
-- ----------------------------
DROP TABLE IF EXISTS `t_project_business_flow_copyer`;
CREATE TABLE `t_project_business_flow_copyer`  (
  `id` bigint(64) NOT NULL,
  `list_id` bigint(64) NULL DEFAULT NULL,
  `person_type` int(2) NULL DEFAULT NULL,
  `detail_str` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_business_flow_list
-- ----------------------------
DROP TABLE IF EXISTS `t_project_business_flow_list`;
CREATE TABLE `t_project_business_flow_list`  (
  `id` bigint(64) NOT NULL,
  `flow_id` bigint(64) NULL DEFAULT NULL,
  `index` bigint(64) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `type_id` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_business_flow_list_condition
-- ----------------------------
DROP TABLE IF EXISTS `t_project_business_flow_list_condition`;
CREATE TABLE `t_project_business_flow_list_condition`  (
  `id` bigint(64) NOT NULL,
  `list_id` bigint(64) NULL DEFAULT NULL COMMENT '方法id',
  `field_type` int(2) NULL DEFAULT NULL COMMENT '字段类型',
  `filter_type` int(2) NULL DEFAULT NULL COMMENT '过滤类型',
  `filter_value` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '过滤值',
  `condition_str` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模型解析',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  `action_code` int(2) NULL DEFAULT NULL COMMENT '按钮类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_business_flow_verifyer
-- ----------------------------
DROP TABLE IF EXISTS `t_project_business_flow_verifyer`;
CREATE TABLE `t_project_business_flow_verifyer`  (
  `id` bigint(64) NOT NULL,
  `list_id` bigint(64) NULL DEFAULT NULL,
  `person_type` int(2) NULL DEFAULT NULL,
  `detail_str` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `parent_id` bigint(64) NULL DEFAULT NULL,
  `verify_type` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_code
-- ----------------------------
DROP TABLE IF EXISTS `t_project_code`;
CREATE TABLE `t_project_code`  (
  `id` bigint(64) NOT NULL,
  `dataStr` int(2) NULL DEFAULT NULL COMMENT '日期类型',
  `parent_number` int(10) NULL DEFAULT NULL COMMENT '父项目数字个数',
  `child_number` int(10) NULL DEFAULT NULL COMMENT '子项目数字个数',
  `create_period` int(2) NULL DEFAULT NULL COMMENT '生成周期类型',
  `reg_id` bigint(64) NULL DEFAULT NULL COMMENT '组织机构id',
  `child_short_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '子项目简称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_code
-- ----------------------------
INSERT INTO `t_project_code` VALUES (1, 1, 4, 3, 1, NULL, NULL);
INSERT INTO `t_project_code` VALUES (351626034665025536, 1, 4, 3, 1, 1439443889766823051, 'zzz');
INSERT INTO `t_project_code` VALUES (351902280334487552, 1, 4, 3, 1, 351626034665025536, NULL);
INSERT INTO `t_project_code` VALUES (351905244461707264, 1, 4, 3, 1, 337108679578677248, NULL);
INSERT INTO `t_project_code` VALUES (354125200350650368, 1, 4, 3, 1, 204, 'dddssss');

-- ----------------------------
-- Table structure for t_project_code_plan_regchild
-- ----------------------------
DROP TABLE IF EXISTS `t_project_code_plan_regchild`;
CREATE TABLE `t_project_code_plan_regchild`  (
  `id` bigint(64) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL,
  `parent_plan_id` bigint(64) NULL DEFAULT NULL,
  `plan_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type_id` int(2) NULL DEFAULT NULL,
  `date_str` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_code_plan_regchild
-- ----------------------------
INSERT INTO `t_project_code_plan_regchild` VALUES (352264505746313216, 1439443889766823051, 1, NULL, '0018', 1, '2019');
INSERT INTO `t_project_code_plan_regchild` VALUES (352710509933686784, 1439443889766823051, 349716776946900992, NULL, '063', 1, '2019');
INSERT INTO `t_project_code_plan_regchild` VALUES (484898534533681152, 1439443889766823051, 1, NULL, '0002', 1, '2020');

-- ----------------------------
-- Table structure for t_project_code_reg
-- ----------------------------
DROP TABLE IF EXISTS `t_project_code_reg`;
CREATE TABLE `t_project_code_reg`  (
  `id` bigint(64) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL COMMENT '组织id',
  `year_quarter` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '年-季度',
  `parent_project` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父项目code',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目组织编号' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_code_reg
-- ----------------------------
INSERT INTO `t_project_code_reg` VALUES (351913314264854528, 1439443889766823051, NULL, '0010', '2019-11-06 14:57:05', 0);
INSERT INTO `t_project_code_reg` VALUES (356298551215136768, 204, NULL, '0001', '2019-11-18 14:50:05', 0);

-- ----------------------------
-- Table structure for t_project_code_regchild
-- ----------------------------
DROP TABLE IF EXISTS `t_project_code_regchild`;
CREATE TABLE `t_project_code_regchild`  (
  `id` bigint(64) NOT NULL,
  `parent_project_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `child_project_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL,
  `child_short_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_code_regchild
-- ----------------------------
INSERT INTO `t_project_code_regchild` VALUES (351913314298408960, 'Project201911060001', '000', NULL, NULL);
INSERT INTO `t_project_code_regchild` VALUES (351914125673934848, 'Project201911060002', '000', NULL, NULL);
INSERT INTO `t_project_code_regchild` VALUES (351936776849108992, 'Project201911060003', '000', NULL, NULL);
INSERT INTO `t_project_code_regchild` VALUES (351936905232560128, '351936905232560128', '001', 1439443889766823051, NULL);
INSERT INTO `t_project_code_regchild` VALUES (351940893390712832, 'Project201911060005', '001', 1439443889766823051, NULL);
INSERT INTO `t_project_code_regchild` VALUES (351947352270745600, 'Project201911060006', '000', 1439443889766823051, NULL);
INSERT INTO `t_project_code_regchild` VALUES (351947468994031616, 'Project201911060007', '000', 1439443889766823051, NULL);
INSERT INTO `t_project_code_regchild` VALUES (351947526627962880, 'Project201911060008', '000', 1439443889766823051, NULL);
INSERT INTO `t_project_code_regchild` VALUES (351947619703762944, 'Project201911060009', '000', 1439443889766823051, NULL);
INSERT INTO `t_project_code_regchild` VALUES (351951659183419392, 'Project201911060010', '010', 1439443889766823051, 'zzz');
INSERT INTO `t_project_code_regchild` VALUES (356298551236108288, 'yf201911180001', '000', 204, 'dddssss');

-- ----------------------------
-- Table structure for t_project_code_shortname
-- ----------------------------
DROP TABLE IF EXISTS `t_project_code_shortname`;
CREATE TABLE `t_project_code_shortname`  (
  `id` bigint(64) NOT NULL,
  `code_id` bigint(64) NULL DEFAULT NULL,
  `dic_project_type` bigint(64) NULL DEFAULT NULL,
  `short_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_code_shortname
-- ----------------------------
INSERT INTO `t_project_code_shortname` VALUES (351904576711733248, 351626034665025536, 337108679578677248, 'Project');
INSERT INTO `t_project_code_shortname` VALUES (354485746321203200, 354125200350650368, 346515989577101312, 'yf');
INSERT INTO `t_project_code_shortname` VALUES (354485746333786112, 354125200350650368, 346515989577101313, 'cx');
INSERT INTO `t_project_code_shortname` VALUES (354485746346369024, 354125200350650368, 346515989577101314, 'sc');
INSERT INTO `t_project_code_shortname` VALUES (354485746358951936, 354125200350650368, 346515989577101315, 'fw');
INSERT INTO `t_project_code_shortname` VALUES (354485746367340544, 354125200350650368, 346515989577101316, 'gc');
INSERT INTO `t_project_code_shortname` VALUES (354487498697220096, 354125200350650368, 346515989577101317, 'othor');

-- ----------------------------
-- Table structure for t_project_code_task_regchild
-- ----------------------------
DROP TABLE IF EXISTS `t_project_code_task_regchild`;
CREATE TABLE `t_project_code_task_regchild`  (
  `id` bigint(64) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL,
  `parent_task_id` bigint(64) NULL DEFAULT NULL,
  `task_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type_id` int(2) NULL DEFAULT NULL,
  `date_str` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_code_task_regchild
-- ----------------------------
INSERT INTO `t_project_code_task_regchild` VALUES (352265572458483712, 1439443889766823051, 1, NULL, '0002', 1, '2019');
INSERT INTO `t_project_code_task_regchild` VALUES (352265635163328512, 1439443889766823051, 1, 1, '0003', 2, '2019');

-- ----------------------------
-- Table structure for t_project_concern
-- ----------------------------
DROP TABLE IF EXISTS `t_project_concern`;
CREATE TABLE `t_project_concern`  (
  `id` bigint(64) NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL,
  `user_id` bigint(64) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目关注表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_concern
-- ----------------------------
INSERT INTO `t_project_concern` VALUES (346830710553489408, 346823536683036672, 662, 662, '曹操', '2019-10-23 11:48:15', 662, '曹操', '2019-10-23 11:48:33', 1);
INSERT INTO `t_project_concern` VALUES (346832226064576512, 346823536683036672, 662, 662, '曹操', '2019-10-23 11:54:17', 662, '曹操', '2019-10-25 12:02:17', 1);
INSERT INTO `t_project_concern` VALUES (347559338651033600, 346823536683036672, 662, 662, '曹操', '2019-10-25 12:03:34', 662, '曹操', '2019-10-25 12:03:36', 1);
INSERT INTO `t_project_concern` VALUES (347559379000238080, 346823536683036672, 662, 662, '曹操', '2019-10-25 12:03:44', 662, '曹操', '2019-10-25 12:03:45', 1);
INSERT INTO `t_project_concern` VALUES (347559389490192384, 346823536683036672, 662, 662, '曹操', '2019-10-25 12:03:46', 662, '曹操', '2019-10-25 12:08:05', 1);
INSERT INTO `t_project_concern` VALUES (347560468630085632, 1, 662, 662, '曹操', '2019-10-25 12:08:03', 662, '曹操', '2019-10-25 12:08:04', 1);
INSERT INTO `t_project_concern` VALUES (347560480189587456, 346823536683036672, 662, 662, '曹操', '2019-10-25 12:08:06', 662, '曹操', '2019-10-25 16:47:12', 1);
INSERT INTO `t_project_concern` VALUES (347878674074836992, 346823536683036672, 662, 662, '曹操', '2019-10-26 09:12:29', 662, '曹操', '2019-10-28 17:10:51', 1);
INSERT INTO `t_project_concern` VALUES (352245961422675968, 351951778888855552, 662, 662, '曹操', '2019-11-07 10:26:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_concern` VALUES (352247207059660800, 351951774266732544, 662, 662, '曹操', '2019-11-07 10:31:29', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_config
-- ----------------------------
DROP TABLE IF EXISTS `t_project_config`;
CREATE TABLE `t_project_config`  (
  `id` bigint(20) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL COMMENT '组织id',
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `type_id` int(64) NULL DEFAULT NULL COMMENT '类型id',
  `type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `state` int(2) NULL DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `type_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_config
-- ----------------------------
INSERT INTO `t_project_config` VALUES (351151103871336448, 1439443889766823051, 1, 1, '是否启用项目计划', 0, '', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'project');
INSERT INTO `t_project_config` VALUES (351151103871336449, 1439443889766823051, 1, 2, '项目计划是否需要审批', 1, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'verify_set');
INSERT INTO `t_project_config` VALUES (351151103871336450, 1439443889766823051, 1, 3, '项目团队计划是否需要审批', 1, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'verify_set');
INSERT INTO `t_project_config` VALUES (351151103871336451, 1439443889766823051, 1, 4, '项目成员计划是否需要审批', 1, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'verify_set');
INSERT INTO `t_project_config` VALUES (351151103871336452, 1439443889766823051, 1, 5, '项目任务交付物是否需要审批', 1, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'verify_set');
INSERT INTO `t_project_config` VALUES (351151103871336453, 1439443889766823051, 1, 6, '项目结项是否需要审批', 1, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'verify_set');
INSERT INTO `t_project_config` VALUES (351151103871336454, 1439443889766823051, 1, 7, '项目预算是否需要审批', 1, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'verify_set');
INSERT INTO `t_project_config` VALUES (351151103871336455, 1439443889766823051, 1, 8, '项目计划变更是否需要审批', 0, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'change_apply');
INSERT INTO `t_project_config` VALUES (351151103871336456, 1439443889766823051, 1, 9, '项目团队计划变更是否需要审批', 0, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'change_apply');
INSERT INTO `t_project_config` VALUES (351151103871336457, 1439443889766823051, 1, 10, '项目成员计划变更是否需要审批', 0, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'change_apply');
INSERT INTO `t_project_config` VALUES (351151103871336458, 1439443889766823051, 1, 11, '项目预算变更是否需要审批', 0, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'change_apply');
INSERT INTO `t_project_config` VALUES (351151103871336459, 1439443889766823051, 1, 12, '项目工时确认时间周期', 0, '2', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'working_time_set');
INSERT INTO `t_project_config` VALUES (351151103871336460, 1439443889766823051, 1, 13, '任务交付物是否需要评价', 1, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'deliverable');
INSERT INTO `t_project_config` VALUES (351151103871336461, 1439443889766823051, 1, 14, '项目任务是否需要评价', 0, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'task');
INSERT INTO `t_project_config` VALUES (351151103871336462, 1439443889766823051, 1, 15, '项目结项是否需要评价', 1, '1', 662, '曹操', '2019-11-04 09:55:57', 662, '曹操', '2019-11-08 14:36:39', 0, 'close');

-- ----------------------------
-- Table structure for t_project_config_estimate_close
-- ----------------------------
DROP TABLE IF EXISTS `t_project_config_estimate_close`;
CREATE TABLE `t_project_config_estimate_close`  (
  `id` bigint(64) NOT NULL COMMENT '主键',
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `close_id` bigint(64) NULL DEFAULT NULL COMMENT '结项id',
  `quality_estimate_weight` decimal(5, 2) NULL DEFAULT NULL COMMENT '质量评价权重',
  `time_estimate_weight` decimal(5, 2) NULL DEFAULT NULL COMMENT '时间评价权重',
  `price_estimate_weight` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格评价权重',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  `type_id` int(2) NULL DEFAULT NULL COMMENT '项目评价设置',
  `step_id` bigint(64) NULL DEFAULT NULL COMMENT '阶段id',
  `step_weight` decimal(5, 2) NULL DEFAULT NULL COMMENT '阶段权重',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_config_estimate_close
-- ----------------------------
INSERT INTO `t_project_config_estimate_close` VALUES (352362604602904576, 1, 351151103871336462, 10.00, 10.00, 10.00, 662, '曹操', '2019-11-07 18:10:02', NULL, NULL, NULL, 0, NULL, 348623606850920448, 10.00);
INSERT INTO `t_project_config_estimate_close` VALUES (352603644441010176, 1, 351151103871336462, 1.00, 1.00, 1.00, 662, '曹操', '2019-11-08 10:07:50', NULL, NULL, NULL, 0, 2, 348633470419476480, 1.00);
INSERT INTO `t_project_config_estimate_close` VALUES (352610426412474368, 1, 351151103871336462, 1.00, 1.00, 1.00, 662, '曹操', '2019-11-08 10:34:47', NULL, NULL, NULL, 0, NULL, 2, 1.00);
INSERT INTO `t_project_config_estimate_close` VALUES (352668952044380160, 1, 351151103871336462, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:27:21', NULL, NULL, NULL, 0, NULL, 2, NULL);
INSERT INTO `t_project_config_estimate_close` VALUES (352671294131150848, 1, 351151103871336462, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:36:39', NULL, NULL, NULL, 0, NULL, 2, NULL);

-- ----------------------------
-- Table structure for t_project_config_estimate_devlierable
-- ----------------------------
DROP TABLE IF EXISTS `t_project_config_estimate_devlierable`;
CREATE TABLE `t_project_config_estimate_devlierable`  (
  `id` bigint(64) NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL,
  `deliverable_id` bigint(64) NULL DEFAULT NULL,
  `quality_estimate_weight` decimal(5, 2) NULL DEFAULT NULL,
  `time_estimate_weight` decimal(5, 2) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_config_estimate_devlierable
-- ----------------------------
INSERT INTO `t_project_config_estimate_devlierable` VALUES (351213995052281856, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-04 14:05:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (351989593257324545, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-06 17:27:49', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (351994100582232066, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-06 17:45:44', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (351994428975263745, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-06 17:47:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (351994803497250816, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-06 17:48:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (351995247518855168, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-06 17:50:17', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (351995315584020481, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-06 17:50:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352362604519018497, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-07 18:10:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352595465514655745, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 09:35:20', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352598122186809344, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 09:45:54', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352603644424232960, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 10:07:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352605048417165312, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 10:13:25', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352605523979935744, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 10:15:18', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352610426265673728, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 10:34:47', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352611865738223616, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 10:40:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352627043645136896, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 11:40:49', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352630402766741504, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 11:54:10', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352633203651649536, NULL, NULL, 10.00, 20.00, 662, '曹操', '2019-11-08 12:05:18', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352633558590431232, NULL, NULL, 10.00, 10.00, 662, '曹操', '2019-11-08 12:06:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352633752233058304, NULL, NULL, 10.00, 10.00, 662, '曹操', '2019-11-08 12:07:28', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352633830104506368, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 12:07:47', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352633909817253888, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 12:08:06', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352634632579719168, 1, NULL, 20.00, 20.00, 662, '曹操', '2019-11-08 12:10:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352635281363050496, 1, NULL, 10.00, 10.00, 662, '曹操', '2019-11-08 12:13:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352636433920040960, 1, NULL, 10.00, 10.00, 662, '曹操', '2019-11-08 12:18:08', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352637179566628864, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 12:21:06', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352668199833706496, 1, NULL, 10.00, 10.00, 662, '曹操', '2019-11-08 14:24:21', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352668683529232384, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 14:26:17', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352668719990317056, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 14:26:25', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352668829801390080, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 14:26:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352668951893385216, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 14:27:21', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352669809041350656, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 14:30:45', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352669820726681600, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 14:30:48', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352670844635979776, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 14:34:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352671154959949824, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 14:36:06', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352671177332367360, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 14:36:11', NULL, NULL, NULL, 0);
INSERT INTO `t_project_config_estimate_devlierable` VALUES (352671293996933120, 1, 351151103871336460, 50.00, 50.00, 662, '曹操', '2019-11-08 14:36:39', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_config_estimate_percent
-- ----------------------------
DROP TABLE IF EXISTS `t_project_config_estimate_percent`;
CREATE TABLE `t_project_config_estimate_percent`  (
  `id` bigint(64) NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL,
  `action_id` int(2) NULL DEFAULT NULL,
  `action_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `business_id` bigint(64) NULL DEFAULT NULL,
  `estimate_id` bigint(64) NULL DEFAULT NULL,
  `estimate_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type_id` int(2) NULL DEFAULT NULL,
  `value` decimal(5, 2) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` bigint(64) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_config_estimate_percent
-- ----------------------------
INSERT INTO `t_project_config_estimate_percent` VALUES (352668081755660288, 1, 2, '≥', 351151103871336461, 351230960449925121, '优秀', 1, 10.00, 662, '曹操', '2019-11-08 14:23:53', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_config_estimate_task
-- ----------------------------
DROP TABLE IF EXISTS `t_project_config_estimate_task`;
CREATE TABLE `t_project_config_estimate_task`  (
  `id` bigint(64) NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL,
  `task_id` bigint(64) NULL DEFAULT NULL,
  `quality_estimate_weight` decimal(5, 2) NULL DEFAULT NULL,
  `time_estimate_weight` decimal(5, 2) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_config_estimate_task
-- ----------------------------
INSERT INTO `t_project_config_estimate_task` VALUES (352664386976489472, NULL, NULL, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:09:12', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352664796084707328, NULL, NULL, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:10:50', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352664872362319872, NULL, NULL, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:11:08', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352665143498907648, NULL, NULL, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:12:13', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352665537922867200, NULL, NULL, 80.00, 80.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:13:47', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352666673639727104, NULL, NULL, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:18:17', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352666869098487808, NULL, NULL, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:19:04', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352667107179765760, NULL, NULL, 10.00, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:20:01', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352667302328147968, NULL, NULL, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:20:47', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352667350503923712, NULL, NULL, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:20:59', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352667592037113856, NULL, NULL, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:21:56', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352667867456086016, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:23:02', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352667911630495744, NULL, NULL, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:23:13', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352668043281309696, 1, 351151103871336461, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:23:44', 0);
INSERT INTO `t_project_config_estimate_task` VALUES (352668081436893184, 1, 351151103871336461, 10.00, 10.00, NULL, NULL, NULL, 662, '曹操', '2019-11-08 14:23:53', 0);

-- ----------------------------
-- Table structure for t_project_config_milestone
-- ----------------------------
DROP TABLE IF EXISTS `t_project_config_milestone`;
CREATE TABLE `t_project_config_milestone`  (
  `id` bigint(20) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL COMMENT '组织id',
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '里程碑类型名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `index` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_config_milestone
-- ----------------------------
INSERT INTO `t_project_config_milestone` VALUES (101, 204, 1, '进度里程碑', '0', 308, '22', '2019-11-19 18:31:10', NULL, NULL, NULL, 0, 3);
INSERT INTO `t_project_config_milestone` VALUES (102, 204, 1, '回款里程碑', '1', 308, '11', '2019-11-19 17:38:03', NULL, NULL, NULL, 0, 2);
INSERT INTO `t_project_config_milestone` VALUES (352671294265368576, 204, 1, '验收里程碑', '1', 308, '曹操', '2019-11-08 14:36:39', NULL, NULL, NULL, 0, 1);

-- ----------------------------
-- Table structure for t_project_deliver_claim
-- ----------------------------
DROP TABLE IF EXISTS `t_project_deliver_claim`;
CREATE TABLE `t_project_deliver_claim`  (
  `id` bigint(64) NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交付物名称',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '交付时间',
  `leader` bigint(64) NULL DEFAULT NULL COMMENT '负责人',
  `deliver_claim` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交付要求',
  `remark` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  `deliver` bigint(64) NULL DEFAULT NULL COMMENT '交付人',
  `deliver_status` int(2) NULL DEFAULT NULL COMMENT '交付状态',
  `deliver_time` datetime(0) NULL DEFAULT NULL COMMENT '交付时间',
  `verifyer` bigint(64) NULL DEFAULT NULL COMMENT '审核人',
  `verifyer_status` int(2) NULL DEFAULT NULL COMMENT '审核状态',
  `verifyer_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_deliver_claim
-- ----------------------------
INSERT INTO `t_project_deliver_claim` VALUES (1, '123456', '2019-10-25 15:55:26', 535, '交付立项说明书', '要保证时间保证时间', 1, 0, 'system', '2019-10-25 15:55:57', 662, '曹操', '2019-10-28 15:09:11', 0, 535, 1, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_deliver_claim` VALUES (2, '交付要求2', '2019-10-25 15:58:54', 535, '项目计划', '保证时间', 1, 0, 'system', '2019-10-25 15:59:19', NULL, NULL, NULL, 0, 535, 1, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_deliver_claim` VALUES (347627759611973632, '交付要求2', '2019-10-28 15:55:26', 535, '交付立项说明书3', '要保证时间3', 1, 662, '曹操', '2019-10-25 16:35:27', 662, '曹操', '2019-10-25 16:42:08', 1, 535, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_deliver_claim` VALUES (348685234703310848, '3', '2019-10-14 02:00:00', 389, '对等', '地地道道', 1, 662, '曹操', '2019-10-28 14:37:28', 662, '曹操', '2019-10-28 15:06:16', 1, 382, 1, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_deliver_claim` VALUES (348692664732491776, '111', '2019-10-20 02:00:00', 379, '地方上大方几哦啊放假哦', '还不开始的恢复', 1, 662, '曹操', '2019-10-28 15:07:00', 662, '曹操', '2019-10-28 15:07:03', 1, 513, 1, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_deliver_claim` VALUES (357023639501676544, '111', '2019-11-06 00:00:00', 513, '对等', '多对多', 356298551248691200, 380, '何革学', '2019-11-20 14:51:19', NULL, NULL, NULL, 0, 383, 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_project_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_project_dictionary`;
CREATE TABLE `t_project_dictionary`  (
  `id` bigint(64) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建用户id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建用户名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新用户id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新用户名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `short_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简称',
  `reg_id` bigint(64) NULL DEFAULT NULL COMMENT '组织id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_dictionary
-- ----------------------------
INSERT INTO `t_project_dictionary` VALUES (1, '项目类型', 0, 'system', '2019-09-25 14:20:42', NULL, NULL, NULL, 'project_type', NULL);
INSERT INTO `t_project_dictionary` VALUES (2, '优先级', 0, 'system', '2019-09-25 14:21:29', NULL, NULL, NULL, 'project_priority', NULL);
INSERT INTO `t_project_dictionary` VALUES (3, '项目级别', 0, 'system', '2019-09-25 14:22:24', NULL, NULL, NULL, 'project_level', NULL);
INSERT INTO `t_project_dictionary` VALUES (4, '风险等级', 0, 'system', '2019-09-25 14:31:27', NULL, NULL, NULL, 'project_risk_level', NULL);
INSERT INTO `t_project_dictionary` VALUES (5, '评价分值类型', 0, 'system', '2019-10-08 14:29:05', NULL, NULL, NULL, 'project_estimate_percent', NULL);
INSERT INTO `t_project_dictionary` VALUES (6, '附件资料类型', 0, 'system', '2019-11-18 20:01:01', NULL, NULL, NULL, 'appendix_data_type', NULL);

-- ----------------------------
-- Table structure for t_project_dictionary_item
-- ----------------------------
DROP TABLE IF EXISTS `t_project_dictionary_item`;
CREATE TABLE `t_project_dictionary_item`  (
  `id` bigint(64) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `index` int(3) NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `dic_id` bigint(64) NULL DEFAULT NULL,
  `parent_id` bigint(64) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_dictionary_item
-- ----------------------------
INSERT INTO `t_project_dictionary_item` VALUES (1, '研发项目', 1, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (2, '咨询项目', 2, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (3, '生产项目', 3, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (4, '服务项目', 4, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (5, '工程项目', 5, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (6, '其他', 6, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (7, '最高', 1, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (8, '高', 2, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (9, '中', 3, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (10, '低', 4, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (11, 'A-集团级', 1, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (12, 'B-公司级', 2, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (13, 'C-部门级', 3, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (14, '一级', 1, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (15, '二级', 2, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (16, '三级', 3, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (17, '四级', 4, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (18, '五级', 5, '1', NULL, 0, 'system', '2019-09-25 16:31:09', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (19, '优异', 1, '1', NULL, 0, 'system', '2019-10-08 14:45:29', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (20, '优秀', 2, '1', NULL, 0, 'system', '2019-10-08 14:45:32', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (21, '合格', 3, '1', NULL, 0, 'system', '2019-10-08 14:45:34', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (22, '差', 4, '1', NULL, 0, 'system', '2019-10-08 14:45:36', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (23, '极差', 5, '1', NULL, 0, 'system', '2019-10-08 14:45:38', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (101, '输入物', 1, '1', NULL, 0, 'system', '2019-10-08 14:45:38', NULL, NULL, NULL, 0, 6, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (102, '过程物', 2, '1', NULL, 0, 'system', '2019-10-08 14:45:38', NULL, NULL, NULL, 0, 6, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (103, '参考物', 3, '1', NULL, 0, 'system', '2019-10-08 14:45:38', NULL, NULL, NULL, 0, 6, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (104, '来往物', 4, '1', NULL, 0, 'system', '2019-10-08 14:45:38', NULL, NULL, NULL, 0, 6, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (105, '汇报物', 5, '1', NULL, 0, 'system', '2019-10-08 14:45:38', NULL, NULL, NULL, 0, 6, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (111111111, '其他1', 1, '1', 337108679578677248, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1, 351905244335878149);
INSERT INTO `t_project_dictionary_item` VALUES (337108679578677248, '研发项目', 1, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108679578677249, '咨询项目', 2, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108679578677250, '生产项目', 3, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108679578677251, '服务项目', 4, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108679578677252, '工程项目', 5, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108679578677253, '其他', 6, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108679859695616, '最高', 1, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108679859695617, '高', 2, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108679859695618, '中', 3, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108679859695619, '低', 4, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108680136519680, 'A-集团级', 1, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108680136519681, 'B-公司级', 2, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108680136519682, 'C-部门级', 3, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108680430120960, '一级', 1, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108680430120961, '二级', 2, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108680430120962, '三级', 3, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108680434315264, '四级', 4, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337108680434315265, '五级', 5, '1', 1439443889766823051, 662, '曹操', '2019-09-26 15:56:23', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455796830650368, '研发项目', 1, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455796830650369, '咨询项目', 2, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455796830650370, '生产项目', 3, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455796830650371, '服务项目', 4, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455796830650372, '工程项目', 5, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455796830650373, '其他', 6, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455796935507968, '最高', 1, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455796935507969, '高', 2, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455796935507970, '中', 3, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455796935507971, '低', 4, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455797011005440, 'A-集团级', 1, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455797011005441, 'B-公司级', 2, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455797011005442, 'C-部门级', 3, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455797090697216, '一级', 1, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455797090697217, '二级', 2, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455797090697218, '三级', 3, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455797090697219, '四级', 4, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (337455797090697220, '五级', 5, '1', 14383335124397610, 662, '曹操', '2019-09-27 14:55:42', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989577101312, '研发项目', 1, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989577101313, '咨询项目', 2, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989577101314, '生产项目', 3, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989577101315, '服务项目', 4, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989577101316, '工程项目', 5, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989577101317, '其他', 6, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989627432960, '最高', 1, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989627432961, '高', 2, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989627432962, '中', 3, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989627432963, '低', 4, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 2, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989673570304, 'A-集团级', 1, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989673570305, 'B-公司级', 2, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989673570306, 'C-部门级', 3, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 3, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989723901952, '一级', 1, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989723901953, '二级', 2, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989723901954, '三级', 3, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989723901955, '四级', 4, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (346515989723901956, '五级', 5, '1', 204, 662, '曹操', '2019-10-22 14:57:40', NULL, NULL, NULL, 0, 4, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351230960449925120, '优异', 1, '1', 204, 662, '曹操', '2019-11-04 15:13:17', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351230960449925121, '优秀', 2, '1', 204, 662, '曹操', '2019-11-04 15:13:17', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351230960449925122, '合格', 3, '1', 204, 662, '曹操', '2019-11-04 15:13:17', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351230960449925123, '差', 4, '1', 204, 662, '曹操', '2019-11-04 15:13:17', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351230960449925124, '极差', 5, '1', 204, 662, '曹操', '2019-11-04 15:13:17', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351885575712284672, '优异', 1, '1', 1439443889766823051, 662, '曹操', '2019-11-06 10:34:29', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351885575712284673, '优秀', 2, '1', 1439443889766823051, 662, '曹操', '2019-11-06 10:34:29', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351885575712284674, '合格', 3, '1', 1439443889766823051, 662, '曹操', '2019-11-06 10:34:29', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351885575712284675, '差', 4, '1', 1439443889766823051, 662, '曹操', '2019-11-06 10:34:29', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351885575712284676, '极差', 5, '1', 1439443889766823051, 662, '曹操', '2019-11-06 10:34:29', NULL, NULL, NULL, 0, 5, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351902280212852736, '研发项目', 1, '1', 351626034665025536, 662, '曹操', '2019-11-06 11:40:52', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351902280212852737, '咨询项目', 2, '1', 351626034665025536, 662, '曹操', '2019-11-06 11:40:52', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351902280212852738, '生产项目', 3, '1', 351626034665025536, 662, '曹操', '2019-11-06 11:40:52', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351902280212852739, '服务项目', 4, '1', 351626034665025536, 662, '曹操', '2019-11-06 11:40:52', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351902280212852740, '工程项目', 5, '1', 351626034665025536, 662, '曹操', '2019-11-06 11:40:52', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351902280212852741, '其他', 6, '1', 351626034665025536, 662, '曹操', '2019-11-06 11:40:52', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351905244335878144, '研发项目', 1, '1', 337108679578677248, 662, '曹操', '2019-11-06 11:52:39', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351905244335878145, '咨询项目', 2, '1', 337108679578677248, 662, '曹操', '2019-11-06 11:52:39', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351905244335878146, '生产项目', 3, '1', 337108679578677248, 662, '曹操', '2019-11-06 11:52:39', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351905244335878147, '服务项目', 4, '1', 337108679578677248, 662, '曹操', '2019-11-06 11:52:39', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351905244335878148, '工程项目', 5, '1', 337108679578677248, 662, '曹操', '2019-11-06 11:52:39', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (351905244335878149, '其他', 6, '1', 337108679578677248, 662, '曹操', '2019-11-06 11:52:39', NULL, NULL, NULL, 0, 1, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (356655460633505792, '输入物', 1, '1', 204, 380, '何革学', '2019-11-19 14:28:18', NULL, NULL, NULL, 0, 6, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (356655460633505793, '过程物', 2, '1', 204, 380, '何革学', '2019-11-19 14:28:18', NULL, NULL, NULL, 0, 6, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (356655460633505794, '参考物', 3, '1', 204, 380, '何革学', '2019-11-19 14:28:18', NULL, NULL, NULL, 0, 6, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (356655460633505795, '来往物', 4, '1', 204, 380, '何革学', '2019-11-19 14:28:18', NULL, NULL, NULL, 0, 6, NULL);
INSERT INTO `t_project_dictionary_item` VALUES (356655460633505796, '汇报物', 5, '1', 204, 380, '何革学', '2019-11-19 14:28:18', NULL, NULL, NULL, 0, 6, NULL);

-- ----------------------------
-- Table structure for t_project_flow
-- ----------------------------
DROP TABLE IF EXISTS `t_project_flow`;
CREATE TABLE `t_project_flow`  (
  `id` bigint(64) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `flow_type` int(255) NULL DEFAULT NULL,
  `state` int(255) NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `cant_change_verifyer` int(2) NULL DEFAULT NULL,
  `cant_change_copyer` int(2) NULL DEFAULT NULL,
  `verify_cant_revert` int(2) NULL DEFAULT NULL,
  `copy_set_type` int(2) NULL DEFAULT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '选填，如果填了，其他项目选择流程时，该流程无法获取',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_flow
-- ----------------------------
INSERT INTO `t_project_flow` VALUES (357397287219634176, 204, '111111111111111111', '测试2', 16, 1, '2019-11-21 15:36:04', NULL, 380, '何革学', '2019-11-21 15:36:04', 380, '何革学', '2019-11-21 17:00:32', 0, 1, 1, 1, 1, NULL);
INSERT INTO `t_project_flow` VALUES (357413144914173952, 204, '123', '项目创建', 16, 1, '2019-11-21 16:39:04', NULL, 380, '何革学', '2019-11-21 16:39:04', 380, '何革学', '2019-11-21 16:57:10', 0, 1, 1, 1, 1, NULL);
INSERT INTO `t_project_flow` VALUES (357413374715895808, 204, '1234656789', '项目变更流程', 17, 1, '2019-11-21 16:39:59', NULL, 380, '何革学', '2019-11-21 16:39:59', 380, '何革学', '2019-11-21 16:59:15', 0, 1, 1, 1, 1, NULL);
INSERT INTO `t_project_flow` VALUES (357419171105611776, 204, '326598', '项目变更（不改）', 16, 1, '2019-11-21 17:03:01', NULL, 380, '何革学', '2019-11-21 17:03:01', NULL, NULL, NULL, 0, 1, 1, 1, 1, NULL);

-- ----------------------------
-- Table structure for t_project_flow_copyer
-- ----------------------------
DROP TABLE IF EXISTS `t_project_flow_copyer`;
CREATE TABLE `t_project_flow_copyer`  (
  `id` bigint(64) NOT NULL,
  `list_id` bigint(64) NULL DEFAULT NULL,
  `person_type` int(2) NULL DEFAULT NULL,
  `detail_str` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_flow_copyer
-- ----------------------------
INSERT INTO `t_project_flow_copyer` VALUES (357396855948713984, 357396855898382336, 3, '1', 380, '何革学', '2019-11-21 15:34:21', 380, '何革学', '2019-11-21 15:59:29', 1);
INSERT INTO `t_project_flow_copyer` VALUES (357397287257382912, 357397287236411392, 2, '302', 380, '何革学', '2019-11-21 15:36:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357403869592559616, 357403869517062144, 4, '492', 380, '何革学', '2019-11-21 16:02:13', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357407044097679360, 357407044030570496, 4, '492', 380, '何革学', '2019-11-21 16:14:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357410796615639040, 357410796569501696, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:29:45', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357411006813184000, 357411006762852352, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:30:35', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357411902783627264, 357411902737489920, 4, '492', 380, '何革学', '2019-11-21 16:34:08', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357413132062826496, 357413132004106240, 2, '302', 380, '何革学', '2019-11-21 16:39:01', 380, '何革学', '2019-11-21 16:53:06', 1);
INSERT INTO `t_project_flow_copyer` VALUES (357413144947728384, 357413144926756864, 2, '322', 380, '何革学', '2019-11-21 16:39:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357413144956116992, 357413144926756864, 1, '1', 380, '何革学', '2019-11-21 16:39:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357413144964505600, 357413144926756864, 4, '875', 380, '何革学', '2019-11-21 16:39:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357413363240280064, 357413363185754112, 3, '1', 380, '何革学', '2019-11-21 16:39:56', 380, '何革学', '2019-11-21 16:40:39', 1);
INSERT INTO `t_project_flow_copyer` VALUES (357413374757838848, 357413374728478720, 4, '492', 380, '何革学', '2019-11-21 16:39:59', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357416314277076992, 357416314247716864, 4, '492', 380, '何革学', '2019-11-21 16:51:40', 380, '何革学', '2019-11-21 16:53:06', 1);
INSERT INTO `t_project_flow_copyer` VALUES (357417699013959680, 357417698992988160, 2, '322', 380, '何革学', '2019-11-21 16:57:10', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357417699022348288, 357417698992988160, 1, '1', 380, '何革学', '2019-11-21 16:57:10', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357417699030736896, 357417698992988160, 4, '875', 380, '何革学', '2019-11-21 16:57:10', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357418035137093632, 357418035095150592, 4, '492', 380, '何革学', '2019-11-21 16:58:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357418207413936128, 357418207359410176, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:59:11', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357418221972365312, 357418221951393792, 4, '492', 380, '何革学', '2019-11-21 16:59:15', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357418532204060672, 357418532149534720, 4, '492', 380, '何革学', '2019-11-21 17:00:29', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357418545080573952, 357418545055408128, 2, '302', 380, '何革学', '2019-11-21 17:00:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357419156274552832, 357419156199055360, 6, '', 380, '何革学', '2019-11-21 17:02:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357419171143360512, 357419171122388992, 1, '1', 380, '何革学', '2019-11-21 17:03:01', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357419171151749120, 357419171122388992, 2, '322', 380, '何革学', '2019-11-21 17:03:01', NULL, NULL, NULL, 0);
INSERT INTO `t_project_flow_copyer` VALUES (357419171160137728, 357419171122388992, 6, '1', 380, '何革学', '2019-11-21 17:03:01', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_flow_list
-- ----------------------------
DROP TABLE IF EXISTS `t_project_flow_list`;
CREATE TABLE `t_project_flow_list`  (
  `id` bigint(64) NOT NULL,
  `flow_id` bigint(64) NULL DEFAULT NULL,
  `index` bigint(64) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `type_id` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_flow_list
-- ----------------------------
INSERT INTO `t_project_flow_list` VALUES (357396855898382336, 357397287219634176, 1574321660783, '测试1111111111', 380, '何革学', '2019-11-21 15:34:21', 380, '何革学', '2019-11-21 15:59:29', 1, 16);
INSERT INTO `t_project_flow_list` VALUES (357397287236411392, 357397287219634176, 0, NULL, 380, '何革学', '2019-11-21 15:36:04', 380, '何革学', '2019-11-21 15:36:04', 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357403869517062144, NULL, 1574323332960, '层', 380, '何革学', '2019-11-21 16:02:13', NULL, NULL, NULL, 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357407044030570496, NULL, 1574324089823, '错误', 380, '何革学', '2019-11-21 16:14:50', NULL, NULL, NULL, 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357410796569501696, NULL, 1574324984498, '测试', 380, '何革学', '2019-11-21 16:29:44', NULL, NULL, NULL, 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357411006762852352, NULL, 1574325034613, ' 凤飞飞', 380, '何革学', '2019-11-21 16:30:35', NULL, NULL, NULL, 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357411902737489920, NULL, 1574325248229, '从呃呃呃', 380, '何革学', '2019-11-21 16:34:08', NULL, NULL, NULL, 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357413132004106240, 357413144914173952, 1574325541309, '创建流程1', 380, '何革学', '2019-11-21 16:39:01', 380, '何革学', '2019-11-21 16:52:58', 1, 16);
INSERT INTO `t_project_flow_list` VALUES (357413144926756864, 357413144914173952, 0, NULL, 380, '何革学', '2019-11-21 16:39:04', 380, '何革学', '2019-11-21 16:39:04', 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357413363185754112, 357413374715895808, 1574325596427, '变更', 380, '何革学', '2019-11-21 16:39:56', 380, '何革学', '2019-11-21 16:40:37', 1, 17);
INSERT INTO `t_project_flow_list` VALUES (357413374728478720, 357413374715895808, 0, NULL, 380, '何革学', '2019-11-21 16:39:59', 380, '何革学', '2019-11-21 16:39:59', 0, 17);
INSERT INTO `t_project_flow_list` VALUES (357414756764229632, NULL, 1574325928682, 'VVV', 380, '何革学', '2019-11-21 16:45:29', NULL, NULL, NULL, 0, 17);
INSERT INTO `t_project_flow_list` VALUES (357414847629631488, NULL, 1574325950346, '对等', 380, '何革学', '2019-11-21 16:45:50', NULL, NULL, NULL, 0, 17);
INSERT INTO `t_project_flow_list` VALUES (357415810427920384, NULL, 1574326179896, 'QQ群', 380, '何革学', '2019-11-21 16:49:40', NULL, NULL, NULL, 0, 17);
INSERT INTO `t_project_flow_list` VALUES (357415875859062784, NULL, 1574326195496, '呃呃呃', 380, '何革学', '2019-11-21 16:49:55', NULL, NULL, NULL, 0, 17);
INSERT INTO `t_project_flow_list` VALUES (357416231057891328, 357413374715895808, 1574326280182, '多对多', 380, '何革学', '2019-11-21 16:51:20', 380, '何革学', '2019-11-21 16:53:04', 1, 17);
INSERT INTO `t_project_flow_list` VALUES (357416277086183424, 357413374715895808, 1574326291156, '的凤飞飞', 380, '何革学', '2019-11-21 16:51:31', 380, '何革学', '2019-11-21 16:53:01', 1, 17);
INSERT INTO `t_project_flow_list` VALUES (357416314247716864, 357413374715895808, 0, NULL, 380, '何革学', '2019-11-21 16:51:40', 380, '何革学', '2019-11-21 16:53:03', 1, 17);
INSERT INTO `t_project_flow_list` VALUES (357416972845719552, NULL, 1574326457038, '项目创建', 380, '何革学', '2019-11-21 16:54:17', NULL, NULL, NULL, 0, 17);
INSERT INTO `t_project_flow_list` VALUES (357417680374472704, 357413144914173952, 1574326625725, '创建', 380, '何革学', '2019-11-21 16:57:06', 380, '何革学', '2019-11-21 16:57:10', 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357417698992988160, 357413144914173952, 0, NULL, 380, '何革学', '2019-11-21 16:57:10', 380, '何革学', '2019-11-21 16:57:10', 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357418035095150592, 357413374715895808, 1574326710298, '变更1', 380, '何革学', '2019-11-21 16:58:30', 380, '何革学', '2019-11-21 16:59:15', 0, 17);
INSERT INTO `t_project_flow_list` VALUES (357418207359410176, 357413374715895808, 1574326751368, '变更2', 380, '何革学', '2019-11-21 16:59:11', 380, '何革学', '2019-11-21 16:59:15', 0, 17);
INSERT INTO `t_project_flow_list` VALUES (357418221951393792, 357413374715895808, 0, NULL, 380, '何革学', '2019-11-21 16:59:15', 380, '何革学', '2019-11-21 16:59:15', 0, 17);
INSERT INTO `t_project_flow_list` VALUES (357418532149534720, 357397287219634176, 1574326828804, '多对多', 380, '何革学', '2019-11-21 17:00:29', 380, '何革学', '2019-11-21 17:00:32', 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357418545055408128, 357397287219634176, 0, NULL, 380, '何革学', '2019-11-21 17:00:32', 380, '何革学', '2019-11-21 17:00:32', 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357419156199055360, 357419171105611776, 1574326977589, '变更不动', 380, '何革学', '2019-11-21 17:02:58', 380, '何革学', '2019-11-21 17:03:01', 0, 16);
INSERT INTO `t_project_flow_list` VALUES (357419171122388992, 357419171105611776, 0, NULL, 380, '何革学', '2019-11-21 17:03:01', 380, '何革学', '2019-11-21 17:03:01', 0, 16);

-- ----------------------------
-- Table structure for t_project_flow_list_condition
-- ----------------------------
DROP TABLE IF EXISTS `t_project_flow_list_condition`;
CREATE TABLE `t_project_flow_list_condition`  (
  `id` bigint(64) NOT NULL,
  `list_id` bigint(64) NULL DEFAULT NULL COMMENT '方法id',
  `field_type` int(2) NULL DEFAULT NULL COMMENT '字段类型',
  `filter_type` int(2) NULL DEFAULT NULL COMMENT '过滤类型',
  `filter_value` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '过滤值',
  `condition_str` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模型解析',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  `action_code` int(2) NULL DEFAULT NULL COMMENT '按钮类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_flow_list_condition
-- ----------------------------
INSERT INTO `t_project_flow_list_condition` VALUES (357396855923548160, 357396855898382336, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 15:34:21', 380, '何革学', '2019-11-21 15:59:29', 1, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357403869567393792, 357403869517062144, 2, 1, '89', ' and project_connect_product = 89', 380, '何革学', '2019-11-21 16:02:13', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357407044068319232, 357407044030570496, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 16:14:50', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357410796594667520, 357410796569501696, 4, 1, '346515989673570304', ' and project_level = 346515989673570304', 380, '何革学', '2019-11-21 16:29:45', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357411006792212480, 357411006762852352, 4, 1, '346515989673570304', ' and project_level = 346515989673570304', 380, '何革学', '2019-11-21 16:30:35', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357411902762655744, 357411902737489920, 3, 1, '286', ' and apply_depart = 286', 380, '何革学', '2019-11-21 16:34:08', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357413132029272064, 357413132004106240, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 16:39:01', 380, '何革学', '2019-11-21 16:53:06', 1, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357413132037660672, 357413132004106240, 3, 1, '283', ' and apply_depart = 283', 380, '何革学', '2019-11-21 16:39:01', 380, '何革学', '2019-11-21 16:53:06', 1, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357413363206725632, 357413363185754112, 9, 1, '20', ' and project_contract_cost > 20', 380, '何革学', '2019-11-21 16:39:56', 380, '何革学', '2019-11-21 16:40:39', 1, 2);
INSERT INTO `t_project_flow_list_condition` VALUES (357413363219308544, 357413363185754112, 2, 1, '92', ' and project_connect_product = 92', 380, '何革学', '2019-11-21 16:39:56', 380, '何革学', '2019-11-21 16:40:39', 1, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357414756793589760, 357414756764229632, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 16:45:29', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357414847663185920, 357414847629631488, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 16:45:50', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357415810448891904, 357415810427920384, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 16:49:40', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357415875884228608, 357415875859062784, 2, 1, '89', ' and project_connect_product = 89', 380, '何革学', '2019-11-21 16:49:55', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357416231078862848, 357416231057891328, 3, 1, '284', ' and apply_depart = 284', 380, '何革学', '2019-11-21 16:51:20', 380, '何革学', '2019-11-21 16:53:06', 1, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357416277111349248, 357416277086183424, 3, 1, '284', ' and apply_depart = 284', 380, '何革学', '2019-11-21 16:51:31', 380, '何革学', '2019-11-21 16:53:06', 1, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357416972875079680, 357416972845719552, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 16:54:17', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357417680395444224, 357417680374472704, 4, 1, '346515989673570304', ' and project_level = 346515989673570304', 380, '何革学', '2019-11-21 16:57:06', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357418035120316416, 357418035095150592, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 16:58:30', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357418207384576000, 357418207359410176, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 16:59:11', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357418207397158912, 357418207359410176, 11, 6, '10,20', ' and TYPE_PROJECT_CONNECT_SALE_CHANCE_ESTIMATED_CONTRACT_AMOUNT = 10,20', 380, '何革学', '2019-11-21 16:59:11', NULL, NULL, NULL, 0, 2);
INSERT INTO `t_project_flow_list_condition` VALUES (357418532183089152, 357418532149534720, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 17:00:29', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357419156224221184, 357419156199055360, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 380, '何革学', '2019-11-21 17:02:58', NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_flow_list_condition` VALUES (357419156245192704, 357419156199055360, 11, 2, '10', ' and TYPE_PROJECT_CONNECT_SALE_CHANCE_ESTIMATED_CONTRACT_AMOUNT >= 10', 380, '何革学', '2019-11-21 17:02:58', NULL, NULL, NULL, 0, 2);

-- ----------------------------
-- Table structure for t_project_flow_verifyer
-- ----------------------------
DROP TABLE IF EXISTS `t_project_flow_verifyer`;
CREATE TABLE `t_project_flow_verifyer`  (
  `id` bigint(64) NOT NULL,
  `list_id` bigint(64) NULL DEFAULT NULL,
  `person_type` int(2) NULL DEFAULT NULL,
  `detail_str` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `parent_id` bigint(64) NULL DEFAULT NULL,
  `verify_type` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_flow_verifyer
-- ----------------------------
INSERT INTO `t_project_flow_verifyer` VALUES (357396855973879808, 357396855898382336, 2, '302', 380, '何革学', '2019-11-21 15:34:21', 380, '何革学', '2019-11-21 15:59:29', 1, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357397287282548736, 357397287236411392, 1, '1', 380, '何革学', '2019-11-21 15:36:04', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357403869617725440, 357403869517062144, 2, '322', 380, '何革学', '2019-11-21 16:02:13', NULL, NULL, NULL, 0, NULL, 2);
INSERT INTO `t_project_flow_verifyer` VALUES (357403869626114048, 357403869517062144, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:02:13', NULL, NULL, NULL, 0, 357403869617725440, 2);
INSERT INTO `t_project_flow_verifyer` VALUES (357407044122845184, 357407044030570496, 4, '875', 380, '何革学', '2019-11-21 16:14:50', NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `t_project_flow_verifyer` VALUES (357410796636610560, 357410796569501696, 4, '492', 380, '何革学', '2019-11-21 16:29:45', NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `t_project_flow_verifyer` VALUES (357410796644999168, 357410796569501696, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:29:45', NULL, NULL, NULL, 0, 357410796636610560, NULL);
INSERT INTO `t_project_flow_verifyer` VALUES (357410796653387776, 357410796569501696, 1, '1', 380, '何革学', '2019-11-21 16:29:45', NULL, NULL, NULL, 0, 357410796644999168, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357411006838349824, 357411006762852352, 1, '1', 380, '何革学', '2019-11-21 16:30:35', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357411902804598784, 357411902737489920, 2, '302', 380, '何革学', '2019-11-21 16:34:08', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357411902812987392, 357411902737489920, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:34:08', NULL, NULL, NULL, 0, 357411902804598784, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413132083798016, 357413132004106240, 1, '1', 380, '何革学', '2019-11-21 16:39:01', 380, '何革学', '2019-11-21 16:53:06', 1, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413132092186624, 357413132004106240, 3, '1', 380, '何革学', '2019-11-21 16:39:01', 380, '何革学', '2019-11-21 16:53:06', 1, 357413132083798016, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413144985477120, 357413144926756864, 1, '1', 380, '何革学', '2019-11-21 16:39:04', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413144993865728, 357413144926756864, 2, '322', 380, '何革学', '2019-11-21 16:39:04', NULL, NULL, NULL, 0, 357413144985477120, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413145006448640, 357413144926756864, 3, '1', 380, '何革学', '2019-11-21 16:39:04', NULL, NULL, NULL, 0, 357413144993865728, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413145014837248, 357413144926756864, 4, '875', 380, '何革学', '2019-11-21 16:39:04', NULL, NULL, NULL, 0, 357413145006448640, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413145023225856, 357413144926756864, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:39:04', NULL, NULL, NULL, 0, 357413145014837248, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413145035808768, 357413144926756864, 6, '1', 380, '何革学', '2019-11-21 16:39:04', NULL, NULL, NULL, 0, 357413145023225856, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413363257057280, 357413363185754112, 1, '1', 380, '何革学', '2019-11-21 16:39:56', 380, '何革学', '2019-11-21 16:40:39', 1, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413363265445888, 357413363185754112, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:39:56', 380, '何革学', '2019-11-21 16:40:39', 1, 357413363257057280, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413374778810368, 357413374728478720, 1, '1', 380, '何革学', '2019-11-21 16:39:59', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357413374791393280, 357413374728478720, 4, '875', 380, '何革学', '2019-11-21 16:39:59', NULL, NULL, NULL, 0, 357413374778810368, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357414756839727104, 357414756764229632, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:45:29', NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `t_project_flow_verifyer` VALUES (357414847700934656, 357414847629631488, 6, '', 380, '何革学', '2019-11-21 16:45:50', NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `t_project_flow_verifyer` VALUES (357415810490834944, 357415810427920384, 2, '302', 380, '何革学', '2019-11-21 16:49:40', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357415875913588736, 357415875859062784, 6, '', 380, '何革学', '2019-11-21 16:49:56', NULL, NULL, NULL, 0, NULL, 2);
INSERT INTO `t_project_flow_verifyer` VALUES (357416231104028672, 357416231057891328, 6, '', 380, '何革学', '2019-11-21 16:51:20', 380, '何革学', '2019-11-21 16:53:06', 1, NULL, NULL);
INSERT INTO `t_project_flow_verifyer` VALUES (357416277136515072, 357416277086183424, 4, '784', 380, '何革学', '2019-11-21 16:51:31', 380, '何革学', '2019-11-21 16:53:06', 1, NULL, NULL);
INSERT INTO `t_project_flow_verifyer` VALUES (357416314302242816, 357416314247716864, 1, '1', 380, '何革学', '2019-11-21 16:51:40', 380, '何革学', '2019-11-21 16:53:06', 1, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357416314314825728, 357416314247716864, 4, '875', 380, '何革学', '2019-11-21 16:51:40', 380, '何革学', '2019-11-21 16:53:06', 1, 357416314302242816, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357416972904439808, 357416972845719552, 2, '302', 380, '何革学', '2019-11-21 16:54:17', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357417680424804352, 357417680374472704, 1, '7', 380, '何革学', '2019-11-21 16:57:06', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357417699047514112, 357417698992988160, 1, '1', 380, '何革学', '2019-11-21 16:57:10', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357417699055902720, 357417698992988160, 2, '322', 380, '何革学', '2019-11-21 16:57:10', NULL, NULL, NULL, 0, 357417699047514112, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357417699064291328, 357417698992988160, 3, '1', 380, '何革学', '2019-11-21 16:57:10', NULL, NULL, NULL, 0, 357417699055902720, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357417699072679936, 357417698992988160, 4, '875', 380, '何革学', '2019-11-21 16:57:10', NULL, NULL, NULL, 0, 357417699064291328, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357417699081068544, 357417698992988160, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:57:10', NULL, NULL, NULL, 0, 357417699072679936, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357417699089457152, 357417698992988160, 6, '1', 380, '何革学', '2019-11-21 16:57:10', NULL, NULL, NULL, 0, 357417699081068544, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357418035158065152, 357418035095150592, 2, '322', 380, '何革学', '2019-11-21 16:58:30', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357418035170648064, 357418035095150592, 3, '1', 380, '何革学', '2019-11-21 16:58:30', NULL, NULL, NULL, 0, 357418035158065152, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357418035179036672, 357418035095150592, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:58:30', NULL, NULL, NULL, 0, 357418035170648064, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357418207430713344, 357418207359410176, 4, '492', 380, '何革学', '2019-11-21 16:59:11', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357418207439101952, 357418207359410176, 1, '4', 380, '何革学', '2019-11-21 16:59:11', NULL, NULL, NULL, 0, 357418207430713344, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357418207447490560, 357418207359410176, 5, '354515456077996043', 380, '何革学', '2019-11-21 16:59:11', NULL, NULL, NULL, 0, 357418207439101952, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357418221989142528, 357418221951393792, 1, '1', 380, '何革学', '2019-11-21 16:59:15', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357418222001725440, 357418221951393792, 4, '875', 380, '何革学', '2019-11-21 16:59:15', NULL, NULL, NULL, 0, 357418221989142528, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357418532220837888, 357418532149534720, 5, '354515456077996043', 380, '何革学', '2019-11-21 17:00:29', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357418545097351168, 357418545055408128, 1, '1', 380, '何革学', '2019-11-21 17:00:32', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357419156291330048, 357419156199055360, 4, '492', 380, '何革学', '2019-11-21 17:02:58', NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `t_project_flow_verifyer` VALUES (357419156299718656, 357419156199055360, 4, '391', 380, '何革学', '2019-11-21 17:02:58', NULL, NULL, NULL, 0, 357419156291330048, NULL);
INSERT INTO `t_project_flow_verifyer` VALUES (357419171176914944, 357419171122388992, 2, '302', 380, '何革学', '2019-11-21 17:03:01', NULL, NULL, NULL, 0, NULL, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357419171185303552, 357419171122388992, 1, '1', 380, '何革学', '2019-11-21 17:03:01', NULL, NULL, NULL, 0, 357419171176914944, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357419171193692160, 357419171122388992, 3, '1', 380, '何革学', '2019-11-21 17:03:01', NULL, NULL, NULL, 0, 357419171185303552, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357419171206275072, 357419171122388992, 4, '492', 380, '何革学', '2019-11-21 17:03:01', NULL, NULL, NULL, 0, 357419171193692160, 1);
INSERT INTO `t_project_flow_verifyer` VALUES (357419171214663680, 357419171122388992, 6, '1', 380, '何革学', '2019-11-21 17:03:01', NULL, NULL, NULL, 0, 357419171206275072, 1);

-- ----------------------------
-- Table structure for t_project_milestone
-- ----------------------------
DROP TABLE IF EXISTS `t_project_milestone`;
CREATE TABLE `t_project_milestone`  (
  `id` bigint(64) NOT NULL COMMENT 'id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '里程碑名称',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '里程碑编号',
  `type` bigint(64) NULL DEFAULT NULL COMMENT '里程碑类型（进度，回款，验收等里程碑）',
  `sort` int(2) NULL DEFAULT NULL COMMENT '排序序号',
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目编号',
  `project_stage_id` bigint(64) NULL DEFAULT NULL COMMENT '关联项目阶段id',
  `project_stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联项目阶段',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间（上一里程碑完成时间）',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间（里程碑时间）',
  `owner_id` bigint(64) NULL DEFAULT NULL COMMENT '负责人id',
  `owner` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `team_id` bigint(64) NULL DEFAULT NULL COMMENT '负责团队id',
  `team` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责团队',
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '里程碑目标',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '里程碑说明',
  `status` int(1) NULL DEFAULT NULL COMMENT '审核状态(1未提交，2已提交，3已通过，4已拒绝)',
  `version` int(2) NULL DEFAULT NULL COMMENT '版本',
  `del_states` int(1) NULL DEFAULT NULL COMMENT '删除状态(0正常，1删除)',
  `org_id` bigint(64) NULL DEFAULT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL COMMENT '组织id',
  `is_finish` int(2) NULL DEFAULT NULL COMMENT '是否完成（0未完成，1已完成）',
  `finish_time` datetime(0) NULL DEFAULT NULL COMMENT '确认完成时间',
  `notarize` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '确认人',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目里程碑' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_milestone
-- ----------------------------
INSERT INTO `t_project_milestone` VALUES (1, '202', 'XMLCB201910250001', 101, 0, 1, NULL, 1, '第一阶段', NULL, '2019-10-22 09:59:14', 1, '李四', 1, '团队', '目标', '备注', 1, 1, 0, NULL, NULL, 1, '2019-10-24 10:00:51', '确认人', 'ok', 662, '曹操', '2019-10-29 17:59:21', 662, '曹操', '2019-11-06 15:09:06');
INSERT INTO `t_project_milestone` VALUES (2, '202', 'XMLCB201910250001', 102, 1, 1, NULL, 1, '第二阶段', NULL, '2019-10-24 09:48:38', 1, '张三', 1, '团一', '交付版本一', '版本一测试通过', 1, 1, 0, NULL, NULL, 0, NULL, NULL, NULL, 662, '曹操', '2019-10-29 17:59:21', 662, '曹操', '2019-11-08 11:34:41');
INSERT INTO `t_project_milestone` VALUES (347615100145938432, '202', 'XMLCB201910250001', 103, 3, 1, NULL, NULL, NULL, NULL, '2019-10-22 09:59:14', 662, '李四', 1, '团队', '目标', '说明', NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, NULL, 662, '曹操', '2019-10-29 17:59:21', 662, '曹操', '2019-11-08 11:34:39');
INSERT INTO `t_project_milestone` VALUES (347618688201043968, '202', 'XMLCB201910250001', 101, 2, 1, NULL, NULL, NULL, NULL, '2019-10-28 09:59:14', 662, '李四', 1, '团队', '目标', '说明', NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, NULL, 662, '曹操', '2019-10-29 17:59:21', NULL, NULL, NULL);
INSERT INTO `t_project_milestone` VALUES (349098425905745920, '202', 'XMLCB201910250002', 102, 4, 1, NULL, NULL, NULL, NULL, '2019-10-28 09:59:14', 662, '李四', 1, '团队', '目标', '说明', NULL, 1, 0, NULL, 1439443889766823051, 0, NULL, NULL, NULL, 662, '曹操', '2019-10-29 17:59:21', NULL, NULL, NULL);
INSERT INTO `t_project_milestone` VALUES (351981044934832128, '测试里程碑名称', 'XMLCB201911060039', 101, 1, 1, NULL, NULL, '', NULL, '2019-11-06 16:52:19', 513, '李四', 349716777068535808, '前端项目团队', '目标', '说明', NULL, 1, 0, NULL, 1439443889766823051, 0, NULL, NULL, NULL, 662, '曹操', '2019-11-06 16:53:51', NULL, NULL, NULL);
INSERT INTO `t_project_milestone` VALUES (352003061130129408, '测试里程碑名称22', 'XMLCB201911060062', 101, 1, 1, '', NULL, '', NULL, '2019-11-06 18:19:47', 513, '李四', 349716777068535808, '前端项目团队', '目标', '说明', NULL, 1, 0, NULL, 1439443889766823051, 0, NULL, NULL, NULL, 662, '曹操', '2019-11-06 18:21:20', 662, '曹操', '2019-11-08 14:33:16');
INSERT INTO `t_project_milestone` VALUES (352008983466405888, '里程碑名称测试', 'XMLCB201911060064', 101, 1, 1, NULL, NULL, '', NULL, '2019-11-06 18:43:18', 513, '李四', 349716777068535808, '前端项目团队', '目标', '说明', NULL, 1, 0, NULL, 1439443889766823051, 0, NULL, NULL, NULL, 662, '曹操', '2019-11-06 18:44:52', NULL, NULL, NULL);
INSERT INTO `t_project_milestone` VALUES (352009793319399424, '测试交付要求', 'XMLCB201911060066', 101, 1, 1, NULL, NULL, '', NULL, '2019-11-06 18:46:33', 513, '李四', 349716777068535808, '前端项目团队', '测试目标', '测试说明', NULL, 1, 0, NULL, 1439443889766823051, 0, NULL, NULL, NULL, 662, '曹操', '2019-11-06 18:48:05', NULL, NULL, NULL);
INSERT INTO `t_project_milestone` VALUES (352011744983576576, '里程碑名称测试1111', 'XMLCB201911060071', 101, 1, 1, NULL, NULL, '', NULL, '2019-11-06 18:52:19', 513, '李四', 349716777068535808, '前端项目团队', '里程碑目标', '里程碑说明', NULL, 1, 0, NULL, 1439443889766823051, 0, NULL, NULL, NULL, 662, '曹操', '2019-11-06 18:55:50', NULL, NULL, NULL);
INSERT INTO `t_project_milestone` VALUES (352593001664704512, '1108里程碑', 'XMLCB201911080072', 101, 1, 1, NULL, NULL, '', NULL, '2019-11-08 09:23:29', 513, '李四', 349716777068535808, '前端项目团队', '里程碑目标', '里程碑说明', NULL, 1, 0, NULL, 1439443889766823051, 1, '2019-11-08 10:11:47', '曹操', '确认完成', 662, '曹操', '2019-11-08 09:25:33', NULL, NULL, NULL);
INSERT INTO `t_project_milestone` VALUES (352608802681614336, '1108测试附件', 'XMLCB201911080073', 101, 1, 1, NULL, NULL, '', NULL, '2019-11-08 10:26:30', 513, '李四', 349716777068535808, '前端项目团队', '目标', '说明', NULL, 1, 1, NULL, 1439443889766823051, 0, NULL, NULL, NULL, 662, '曹操', '2019-11-08 10:28:20', 662, '曹操', '2019-11-08 10:28:34');
INSERT INTO `t_project_milestone` VALUES (352609721632649216, '1108测试附件', 'XMLCB201911080074', 101, 1, 1, NULL, NULL, '', NULL, '2019-11-08 10:30:19', 513, '李四', 349716777068535808, '前端项目团队', '目标', '说明', NULL, 1, 1, NULL, 1439443889766823051, 0, NULL, NULL, NULL, 662, '曹操', '2019-11-08 10:31:59', 662, '曹操', '2019-11-08 10:32:12');
INSERT INTO `t_project_milestone` VALUES (352610009995243520, '1108测试附件', 'XMLCB201911080075', 101, 1, 1, NULL, NULL, '', NULL, '2019-11-08 10:31:26', 513, '李四', 349716777068535808, '前端项目团队', '目标', '说明', NULL, 1, 1, NULL, 1439443889766823051, 0, NULL, NULL, NULL, 662, '曹操', '2019-11-08 10:33:08', 662, '曹操', '2019-11-08 10:38:02');

-- ----------------------------
-- Table structure for t_project_milestone_appendix
-- ----------------------------
DROP TABLE IF EXISTS `t_project_milestone_appendix`;
CREATE TABLE `t_project_milestone_appendix`  (
  `id` bigint(64) NOT NULL COMMENT '附件业务表id',
  `milestone_id` bigint(64) NULL DEFAULT NULL COMMENT '里程碑id',
  `appendix_id` bigint(64) NULL DEFAULT NULL COMMENT '附件id',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '附件类型',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '附件描述',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_milestone_appendix
-- ----------------------------
INSERT INTO `t_project_milestone_appendix` VALUES (349098426732023808, NULL, 347551957138976768, '类型1', '202', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_milestone_appendix` VALUES (349098426732023809, NULL, 347551957629710336, '类型2', '202', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_project_milestone_codeconfig
-- ----------------------------
DROP TABLE IF EXISTS `t_project_milestone_codeconfig`;
CREATE TABLE `t_project_milestone_codeconfig`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编码主键',
  `type` int(11) NULL DEFAULT NULL COMMENT '编码类型',
  `prefix` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码前缀',
  `is_prefix` bit(1) NULL DEFAULT NULL COMMENT '是否含编码前缀(0-false,1-true)',
  `is_date` bit(1) NULL DEFAULT NULL COMMENT '是否含日期(0-false,1-true)',
  `next_no` bigint(11) NULL DEFAULT NULL COMMENT '最大值',
  `no_len` int(11) NULL DEFAULT NULL COMMENT '数值长度',
  `reg_id` bigint(20) NULL DEFAULT NULL COMMENT '组织注册编号',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(20) NULL DEFAULT NULL COMMENT '更新用户ID',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新用户',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1568268765310863837 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '编码配置表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_milestone_codeconfig
-- ----------------------------
INSERT INTO `t_project_milestone_codeconfig` VALUES (356704894557843456, 1, 'XMLCB', b'1', b'1', 6, 4, 204, 380, '何革学', '2019-11-19 17:44:44', NULL, NULL, '2019-11-19 17:47:27');
INSERT INTO `t_project_milestone_codeconfig` VALUES (1568268765310863835, 1, 'XMLCB', b'1', b'1', 3, 4, 1439443889766823051, 2, 'aa', '2019-10-26 17:50:16', NULL, NULL, '2019-11-12 17:37:02');
INSERT INTO `t_project_milestone_codeconfig` VALUES (1568268765310863836, 2, 'LCBJF', b'1', b'1', 1, 4, 1439443889766823051, 2, 'aa', '2019-10-26 17:50:16', NULL, NULL, '2019-11-11 13:58:18');

-- ----------------------------
-- Table structure for t_project_milestone_deliverable
-- ----------------------------
DROP TABLE IF EXISTS `t_project_milestone_deliverable`;
CREATE TABLE `t_project_milestone_deliverable`  (
  `id` bigint(64) NOT NULL COMMENT '里程碑交付物主键id',
  `milestone_id` bigint(20) NULL DEFAULT NULL COMMENT '里程碑id',
  `deliverable_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交付物名称',
  `deliverable_number` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交付物编号',
  `delivery_id` bigint(64) NULL DEFAULT NULL COMMENT '关联交付要求id',
  `delivery_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联要求交付物名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交付物说明',
  `deliverable_status` int(2) NULL DEFAULT NULL COMMENT '交付状态',
  `deliverable_time` datetime(0) NULL DEFAULT NULL COMMENT '实际交付时间',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_state` int(1) NULL DEFAULT NULL COMMENT '删除状态(0正常，1删除)',
  `org_id` bigint(20) NULL DEFAULT NULL,
  `reg_id` bigint(20) NULL DEFAULT NULL COMMENT '组织id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_milestone_deliverable
-- ----------------------------
INSERT INTO `t_project_milestone_deliverable` VALUES (1, 1, '交付项目模块一', '2019001', 1, '关联交付要求', '交付物说明', 1, '2019-10-22 14:50:00', 1, '创建人', '2019-10-22 14:50:24', 1, '更新人', '2019-10-22 14:50:37', 0, 1, 2);
INSERT INTO `t_project_milestone_deliverable` VALUES (346522169137860608, 1, '交付项目模块二', 'JF201910220002', 1, '关联交付要求', '交付物说明', NULL, '2019-10-22 15:22:13', 1, '', '2019-10-22 15:22:13', NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO `t_project_milestone_deliverable` VALUES (346532562853859328, 1, '交付项目模块二', 'JF201910220003', 1, '关联交付要求11101', '交付物说明', NULL, '2019-10-22 16:03:31', 1, '', '2019-10-22 16:03:31', 1, '更新人', '2019-10-22 16:08:42', 1, NULL, NULL);
INSERT INTO `t_project_milestone_deliverable` VALUES (352709651596537856, 352622634082725888, '交付物名称测试', 'LCBJF201911080005', 352621303204900864, '交付要求名称', '交付物说明', 0, '2019-11-08 17:09:04', 662, '曹操', '2019-11-08 17:09:04', 662, '曹操', '2019-11-11 14:12:09', 1, NULL, NULL);
INSERT INTO `t_project_milestone_deliverable` VALUES (353748805704970240, 352622634082725888, '交付物名称测试12', 'LCBJF201911110001', 352621303204900864, '交付要求名称', '交付物说明3', 0, '2019-11-11 13:58:18', 662, '曹操', '2019-11-11 13:58:18', 662, '曹操', '2019-11-11 14:19:39', 0, NULL, NULL);

-- ----------------------------
-- Table structure for t_project_milestone_delivery
-- ----------------------------
DROP TABLE IF EXISTS `t_project_milestone_delivery`;
CREATE TABLE `t_project_milestone_delivery`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `milestone_id` bigint(20) NULL DEFAULT NULL COMMENT '里程碑id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '要求交付物名称',
  `delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '要求交付时间',
  `owner_id` bigint(20) NULL DEFAULT NULL COMMENT '负责人id',
  `owner` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `team_id` bigint(20) NULL DEFAULT NULL COMMENT '负责团队id',
  `team_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责团队',
  `requirement` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交付要求说明',
  `sort` int(1) NULL DEFAULT NULL COMMENT '排序',
  `org_id` bigint(20) NULL DEFAULT NULL,
  `reg_id` bigint(20) NULL DEFAULT NULL COMMENT '组织id',
  `create_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(20) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_state` int(1) NULL DEFAULT NULL COMMENT '删除状态(0正常，1删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目里程碑交付物要求' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_milestone_delivery
-- ----------------------------
INSERT INTO `t_project_milestone_delivery` VALUES (346908422723235840, 349098425905745920, '交付要求测试', NULL, 123456, '李四', 123, '技术部', '交付接口', NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-10-29 17:59:21', 1);
INSERT INTO `t_project_milestone_delivery` VALUES (346908958948225024, 349098425905745920, '交付要求测试', '2019-10-23 16:59:11', 123456, '李四', 123, '技术部', '交付接口', NULL, NULL, NULL, 1, '', '2019-10-23 16:59:11', 662, '曹操', '2019-10-29 17:59:21', 0);
INSERT INTO `t_project_milestone_delivery` VALUES (346909396464463872, 1, '交付要求测试', '2019-10-24 16:00:00', 123456, '李四', 123, '技术部', '交付接口', NULL, NULL, NULL, 1, '', '2019-10-23 17:00:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (346911325080940544, 1, '交付要求测试', '2019-10-24 16:00:00', 123456, '李四', 123, '技术部', '交付接口', NULL, NULL, NULL, 1, '', '2019-10-23 17:08:35', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (347615100871553024, 347615100145938432, 'ceshi', '2019-10-21 18:23:29', 110, '110', 110, '110', 'xxxxxxxxxxxx', NULL, NULL, NULL, 662, '曹操', '2019-10-25 15:45:09', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (347618688259764224, 347618688201043968, '测试交付要求', '2019-10-30 15:58:11', 1, '110', 1, '110', '就看见看见', NULL, NULL, NULL, 662, '曹操', '2019-10-25 15:59:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (349360462380568576, 1, '交付要求测试', '2019-10-23 16:59:11', 123456, '李四', 123, '技术部', '交付接口', NULL, NULL, NULL, 662, '曹操', '2019-10-30 11:20:35', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (351141558252367872, 1, '交付要求测试', '2019-10-23 16:59:11', 123456, '李四', 123, '技术部', '交付接口', NULL, NULL, NULL, 662, '曹操', '2019-11-04 09:18:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (351990453115219968, NULL, '交付物名称测试', '2019-11-06 17:29:46', 513, '李四', 349716777068535808, '前端项目团队', '交付要求说明', NULL, NULL, NULL, 662, '曹操', '2019-11-06 17:31:14', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (351990821056344064, NULL, '交付物名称测试1', '2019-11-06 17:31:13', 513, '李四', 349716777068535808, '前端项目团队', '交付要求说明', NULL, NULL, NULL, 662, '曹操', '2019-11-06 17:32:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (351991043518033920, NULL, '测试交付物名称111', '2019-11-06 17:32:07', 513, '李四', 349716777068535808, '前端项目团队', '交付要求说明', NULL, NULL, NULL, 662, '曹操', '2019-11-06 17:33:35', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (351995787619790848, 352009793319399424, '交付物名称', '2019-11-06 17:50:56', 513, '李四', 349716777068535808, '前端项目团队', '交付要求说明', NULL, NULL, NULL, 662, '曹操', '2019-11-06 17:52:26', 662, '曹操', '2019-11-06 18:48:05', 0);
INSERT INTO `t_project_milestone_delivery` VALUES (352011622220492800, 352011744983576576, '交付要求名称', '2019-11-06 18:52:44', 513, '李四', 349716777068535808, '前端项目团队', '交付', NULL, NULL, NULL, 662, '曹操', '2019-11-06 18:55:21', 662, '曹操', '2019-11-06 18:55:50', 0);
INSERT INTO `t_project_milestone_delivery` VALUES (352592936409722880, 352593001664704512, '1108交付要求', '2019-11-08 09:23:44', 513, '李四', 349716777068535808, '前端项目团队', '交付要求说明', NULL, NULL, NULL, 662, '曹操', '2019-11-08 09:25:17', 662, '曹操', '2019-11-08 09:25:33', 0);
INSERT INTO `t_project_milestone_delivery` VALUES (352620754170507264, NULL, '交付要求名称', '2019-11-08 11:13:29', 513, '李四', 349716777068535808, '前端项目团队', '交付要求说明', NULL, NULL, NULL, 662, '曹操', '2019-11-08 11:15:49', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (352621303204900864, 352622634082725888, '交付要求名称', '2019-11-08 11:13:29', 513, '李四', 349716777068535808, '前端项目团队', '交付要求说明', NULL, NULL, NULL, 662, '曹操', '2019-11-08 11:18:00', 662, '曹操', '2019-11-08 11:23:18', 0);
INSERT INTO `t_project_milestone_delivery` VALUES (352622717993971712, 352622810218328064, '交付要求名称1', '2019-11-08 11:13:29', 513, '李四', 349716777068535808, '前端项目团队', '交付要求说明', NULL, NULL, NULL, 662, '曹操', '2019-11-08 11:23:38', 662, '曹操', '2019-11-08 11:24:00', 0);
INSERT INTO `t_project_milestone_delivery` VALUES (352685535858487296, 352677248790392832, '交付要求名称', '2019-11-08 15:31:38', 513, '李四', 349716777068535808, '前端项目团队', '交付要求说明', NULL, NULL, NULL, 662, '曹操', '2019-11-08 15:33:15', 662, '曹操', '2019-11-08 15:33:18', 0);
INSERT INTO `t_project_milestone_delivery` VALUES (354148033577054208, NULL, '12313', '2019-11-12 16:23:02', 513, '李四', 349716777068535808, '前端项目团队', '222', NULL, NULL, NULL, 662, '曹操', '2019-11-12 16:24:41', NULL, NULL, NULL, 0);
INSERT INTO `t_project_milestone_delivery` VALUES (354162016795193344, 354163279142285312, '11', '2019-11-05 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-12 17:20:15', 662, '曹操', '2019-11-12 17:25:16', 0);
INSERT INTO `t_project_milestone_delivery` VALUES (354163168421048320, 354163279142285312, 'bb', '2019-11-11 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-12 17:24:50', 662, '曹操', '2019-11-12 17:25:16', 0);
INSERT INTO `t_project_milestone_delivery` VALUES (354166175623770112, 354166241579200512, 'aa', '2019-10-29 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-12 17:36:47', 662, '曹操', '2019-11-12 17:37:02', 0);

-- ----------------------------
-- Table structure for t_project_milestone_delivery_temp
-- ----------------------------
DROP TABLE IF EXISTS `t_project_milestone_delivery_temp`;
CREATE TABLE `t_project_milestone_delivery_temp`  (
  `id` bigint(20) NOT NULL COMMENT 'id,里程碑交付要求临时表',
  `milestone_id` bigint(20) NULL DEFAULT NULL COMMENT '里程碑id(无用字段)',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '要求交付物名称',
  `delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '要求交付时间',
  `owner_id` bigint(20) NULL DEFAULT NULL COMMENT '负责人id',
  `owner` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `depart_id` bigint(20) NULL DEFAULT NULL COMMENT '负责部门id',
  `depart_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责部门',
  `requirement` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交付要求说明',
  `create_user_id` bigint(20) NULL DEFAULT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目里程碑交付物要求临时表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_plan_appendix
-- ----------------------------
DROP TABLE IF EXISTS `t_project_plan_appendix`;
CREATE TABLE `t_project_plan_appendix`  (
  `plan_appendix_id` bigint(64) NOT NULL COMMENT '计划附件id',
  `plan_appendix_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '附件主题名称',
  `plan_appendix_type` bigint(64) NULL DEFAULT NULL COMMENT '计划附件类型，取值为枚举',
  `plan_appendix_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划附件描述',
  `appendix_id` bigint(64) NULL DEFAULT NULL COMMENT '附件id，外键到附件表',
  `plan_id` bigint(64) NULL DEFAULT NULL COMMENT '修改存放业务Id，包括计划，任务，项目等模块的中间附件表',
  `business_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务名称',
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `business_type` bigint(64) NULL DEFAULT NULL COMMENT '业务类型',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '修改人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`plan_appendix_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_plan_appendix
-- ----------------------------
INSERT INTO `t_project_plan_appendix` VALUES (1, NULL, 1, 'ceshi', NULL, 351608351653953536, NULL, NULL, NULL, 1, '修改人测试账号', '2019-11-06 10:41:23', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (351877431657009152, NULL, 1, NULL, NULL, 351183715493543936, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (351878048001593344, NULL, 1, NULL, NULL, 351183715493543936, NULL, NULL, NULL, 1, '创建人测试', '2019-11-06 10:04:34', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_appendix` VALUES (354174866559369216, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-12 18:11:19', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354175125188542464, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-12 18:12:20', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354436235489742848, NULL, 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-13 11:29:54', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354437259789111296, NULL, 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-13 11:33:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354437548088791040, NULL, 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-13 11:35:07', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354438166064959488, NULL, 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-13 11:37:34', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354440156669054976, NULL, 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-13 11:45:29', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354440449657966592, NULL, 1, '附件说明', NULL, 354476389671669760, NULL, NULL, NULL, 1, '创建人测试', '2019-11-13 11:46:39', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354443555363917824, NULL, 1, '附件说明', NULL, 354476389671669760, NULL, NULL, NULL, 1, '创建人测试', '2019-11-13 11:58:59', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354489222060871680, NULL, 1, '附件说明123', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-13 15:00:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354770838125584384, NULL, 1, '测试说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-14 09:39:29', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354771063506509824, NULL, 1, '测试附件说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-14 09:40:23', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354796958413791232, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-14 11:23:17', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354848761452994560, '附件名称', 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-14 14:49:08', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354849005091725312, '附件名称', 1, '测试说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-14 14:50:06', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354861952186753024, '测试', 1, '测试', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-14 15:41:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (354862266893770752, '测试', 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-14 15:42:48', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355199176392634368, '附件名称', 1, '测试', NULL, 355199246219407360, NULL, NULL, NULL, 1, '创建人测试', '2019-11-15 14:01:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355199235804950528, '啛啛喳喳', 2, '测试', NULL, 355199246219407360, NULL, NULL, NULL, 1, '创建人测试', '2019-11-15 14:01:47', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355595325247102976, '附件', 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 16:15:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355596713129713664, '测', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 16:21:13', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355596871812816896, '测', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 16:21:51', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355597385841549312, '测', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 16:23:54', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355597477407399936, '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 16:24:16', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355597655778566144, '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 16:24:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355599956941512704, '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 16:34:07', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355600308902338560, '123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 16:35:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355611391138504704, '附件名称', 1, '附件说明', NULL, 355611502920900608, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 17:19:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355612072486412288, '456', 1, '123', NULL, 355612109689888768, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 17:22:15', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355619352380481536, '附件名称', 1, '附件说明', NULL, 355619360471293952, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 17:51:11', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355620366911315968, '18:00测试', 1, '测试', NULL, 355621199392579584, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 17:55:13', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355620895309733888, '1801测试', 1, '附件说明', NULL, 355621199392579584, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 17:57:19', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355622528387162112, 'tesat', 1, NULL, NULL, 355626693465251840, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 18:03:48', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355627769773989888, 'poi', 3, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 18:24:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355628375062388736, '00000', 1, NULL, NULL, 355628494675550208, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 18:27:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (355629017688481792, '交接', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试', '2019-11-16 18:29:35', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356313192036868096, '测试附件', 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:48:15', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356314676082286592, '附件名称', 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:54:09', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356315416657960960, '附件名称', 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:57:06', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356315957832228864, '测试附件名称', 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:59:15', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356319391692136448, '附件名称', 1, '附件说明', NULL, 356320553220743168, NULL, NULL, NULL, 380, '何革学', '2019-11-18 16:12:53', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356358163481796608, '附件名称', 1, '附件说', NULL, 356358285175332864, NULL, NULL, NULL, 380, '何革学', '2019-11-18 18:46:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356359967451947008, '附件名称', 1, '附件说明', NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 18:54:07', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356360348340887552, '附件', 2, '说明', NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 18:55:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356360829272367104, '11', NULL, NULL, NULL, 356360964626751488, NULL, NULL, NULL, 380, '何革学', '2019-11-18 18:57:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356361344181903360, '123', NULL, NULL, NULL, 356361443540770816, NULL, NULL, NULL, 380, '何革学', '2019-11-18 18:59:36', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356704718583791616, '附件名称', 1, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-19 17:44:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356705528533254144, '附件名称测试', 1, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-19 17:47:15', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356711153933778944, '附件名称', 1, '说明', NULL, 356711161475137536, NULL, NULL, NULL, 380, '何革学', '2019-11-19 18:09:37', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356714688914161664, '附件名称', 1, '说明', NULL, 356714699517362176, NULL, NULL, NULL, 380, '何革学', '2019-11-19 18:23:40', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356722910198792192, '附件名称', 1, '说明', NULL, 356722949478449152, NULL, NULL, NULL, 380, '何革学', '2019-11-19 18:56:20', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356948883951362048, '123aaa', NULL, NULL, NULL, NULL, 'aaa123', 123, 1, 380, '何革学', '2019-11-20 09:54:16', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356951436457975808, '123aaa', NULL, NULL, NULL, NULL, 'aaa123', 123, 1, 380, '何革学', '2019-11-20 10:04:25', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356963924595482624, '123', NULL, NULL, NULL, 356964007890165760, 'jihua ', NULL, 1, 380, '何革学', '2019-11-20 10:54:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_appendix` VALUES (356981929043861504, '附件名称', 1, '附件说明', NULL, 356982255113248768, '计划名称', NULL, 1, 380, '何革学', '2019-11-20 12:05:35', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_plan_association
-- ----------------------------
DROP TABLE IF EXISTS `t_project_plan_association`;
CREATE TABLE `t_project_plan_association`  (
  `plan_association_id` bigint(64) NOT NULL COMMENT '关联关系id',
  `plan_association_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联计划名称',
  `plan_step` bigint(32) NULL DEFAULT NULL COMMENT '计划阶段--更改为项目阶段，字段名称就不做修改了',
  `plan_pority` bigint(64) NULL DEFAULT NULL COMMENT '计划优先级',
  `plan_execution_status` bigint(64) NULL DEFAULT NULL COMMENT '计划执行状态',
  `plan_relationship` bigint(64) NULL DEFAULT NULL,
  `plan_leader_id` bigint(64) NULL DEFAULT NULL COMMENT '负责人id',
  `plan_team_id` bigint(64) NULL DEFAULT NULL COMMENT '项目团队id',
  `plan_startTime` datetime(0) NULL DEFAULT NULL COMMENT '项目开始时间',
  `plan_endTime` datetime(0) NULL DEFAULT NULL COMMENT '计划结束时间',
  `plan_working_hour` bigint(64) NULL DEFAULT NULL COMMENT '计划工时',
  `plan_id` bigint(64) NULL DEFAULT NULL COMMENT '计划id外键',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`plan_association_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_plan_association
-- ----------------------------
INSERT INTO `t_project_plan_association` VALUES (355151144515072000, NULL, 1, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, 351183715493543936, 1, '创建人id', '2019-11-15 10:50:41', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_association` VALUES (356342435147980800, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 351183916966936576, 380, '何革学', '2019-11-18 17:44:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_association` VALUES (356342979061129216, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 356343029787041792, 380, '何革学', '2019-11-18 17:46:37', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_association` VALUES (356981985792794624, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 356982255113248768, 380, '何革学', '2019-11-20 12:05:48', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_association` VALUES (356983581230538752, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, 356983660389638144, 380, '何革学', '2019-11-20 12:12:08', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_association` VALUES (356985572614774784, NULL, NULL, 1, NULL, 1, NULL, NULL, NULL, NULL, NULL, 356985741452288000, 380, '何革学', '2019-11-20 12:20:03', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_association` VALUES (356986200573386752, NULL, NULL, NULL, NULL, 1, 662, 346823537177964544, NULL, NULL, NULL, 356986260770037760, 380, '何革学', '2019-11-20 12:22:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_association` VALUES (357076848806764544, NULL, 1, 1, NULL, 1, 622, 346823537177964544, '2019-11-20 12:03:04', '2019-11-21 00:00:00', 11, 357076868691959808, 380, '何革学', '2019-11-20 18:22:45', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_association` VALUES (357079557941272576, NULL, 1, 1, NULL, NULL, NULL, NULL, '2019-11-20 12:03:04', '2019-11-21 00:00:00', 11, 356982255113248768, 380, '何革学', '2019-11-20 18:33:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_association` VALUES (357317393672081408, '计划名称', 1, 1, NULL, 1, 622, 346823537177964544, '2019-11-20 12:03:04', '2019-11-21 00:00:00', 11, 357317452572692480, 380, '何革学', '2019-11-21 10:18:36', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_plan_create
-- ----------------------------
DROP TABLE IF EXISTS `t_project_plan_create`;
CREATE TABLE `t_project_plan_create`  (
  `plan_id` bigint(64) NOT NULL COMMENT '计划id',
  `plan_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划名',
  `plan_version` bigint(64) NULL DEFAULT NULL COMMENT '计划版本',
  `plan_apply_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划申请描述',
  `plan_num` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划编号',
  `parent_plan_id` bigint(64) NULL DEFAULT NULL COMMENT '父计划id',
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `project_step` bigint(64) NULL DEFAULT NULL COMMENT '项目阶段',
  `priority` bigint(64) NULL DEFAULT NULL COMMENT '优先级',
  `plan_startTime` datetime(0) NULL DEFAULT NULL COMMENT '计划开始时间',
  `plan_endTime` datetime(0) NULL DEFAULT NULL COMMENT '计划结束时间',
  `plan_deadline` datetime(0) NULL DEFAULT NULL COMMENT '截止完成时间',
  `plan_duration` bigint(64) NULL DEFAULT NULL COMMENT '工时',
  `plan_leader_id` bigint(64) NULL DEFAULT NULL,
  `plan_team_id` bigint(64) NULL DEFAULT NULL,
  `plan_participant_id` bigint(64) NULL DEFAULT NULL,
  `plan_milestone_id` bigint(64) NULL DEFAULT NULL COMMENT '里程碑id',
  `plan_remind_hour` bigint(64) UNSIGNED NULL DEFAULT NULL COMMENT '提醒时间',
  `plan_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划内容',
  `plan_appendix_id` bigint(64) NULL DEFAULT NULL COMMENT '计划附件id',
  `association_plan_id` bigint(64) NULL DEFAULT NULL COMMENT '关联关系id',
  `delivery_requirement_id` bigint(64) NULL DEFAULT NULL COMMENT '交付要求id',
  `report_requirement_id` bigint(64) NULL DEFAULT NULL COMMENT '汇报要求id',
  `quality_requirement_id` bigint(64) NULL DEFAULT NULL COMMENT '质量要求id',
  `plan_remark` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划备注',
  `check_status` bigint(64) NULL DEFAULT NULL COMMENT '审核状态',
  `plan_type` bigint(64) NULL DEFAULT NULL COMMENT '计划类型，枚举',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '修改id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`plan_id`) USING BTREE,
  INDEX `FK_appendix`(`plan_appendix_id`) USING BTREE,
  INDEX `FK_assoxiation`(`association_plan_id`) USING BTREE,
  INDEX `FK_deliver`(`delivery_requirement_id`) USING BTREE,
  INDEX `FK_report`(`report_requirement_id`) USING BTREE,
  INDEX `FK_quality`(`quality_requirement_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_plan_create
-- ----------------------------
INSERT INTO `t_project_plan_create` VALUES (351183715493543936, '测试修改计划', 1, NULL, NULL, NULL, 349716776946900992, NULL, 1, NULL, NULL, NULL, NULL, 662, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 'ceshichuangjian', '2019-11-04 12:05:33', 1, 'ceshigengxin', '2019-11-04 12:05:33', 0);
INSERT INTO `t_project_plan_create` VALUES (351183913540190208, 'XX第一计划', 2, NULL, NULL, 351183715493543936, 349716776946900992, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 'ceshichuangjian', '2019-11-04 12:06:20', 1, 'ceshigengxin', '2019-11-04 12:06:20', 0);
INSERT INTO `t_project_plan_create` VALUES (351183914861395968, 'XX第一计划', 3, NULL, NULL, 351183913540190208, 349716776946900992, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 'ceshichuangjian', '2019-11-04 12:06:20', 1, 'ceshigengxin', '2019-11-04 12:06:20', 0);
INSERT INTO `t_project_plan_create` VALUES (351183915645730816, '测试修改计划', 4, NULL, NULL, NULL, 349716776946900992, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-04 12:06:20', 1, '更新人测试账号', '2019-11-05 14:17:36', 0);
INSERT INTO `t_project_plan_create` VALUES (351183916329402368, 'XX第一计划', 5, NULL, NULL, 351183915645730816, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-04 12:06:21', 1, '更新人测试账号', '2019-11-04 16:40:00', 0);
INSERT INTO `t_project_plan_create` VALUES (351183916966936576, '11111', 2, NULL, 'PLAN001', NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-04 12:06:21', 1, '更新人测试账号', '2019-11-05 10:57:20', 0);
INSERT INTO `t_project_plan_create` VALUES (351183917696745472, 'XX第一计划', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 'ceshichuangjian', '2019-11-04 12:06:21', 1, 'ceshigengxin', '2019-11-04 12:06:21', 1);
INSERT INTO `t_project_plan_create` VALUES (351183918288142336, 'XX第一计划', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 'ceshichuangjian', '2019-11-04 12:06:21', 1, 'ceshigengxin', '2019-11-04 12:06:21', 1);
INSERT INTO `t_project_plan_create` VALUES (351183918850179072, '测试修改计划', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-04 12:06:21', 1, '更新人测试账号', '2019-11-05 11:11:09', 1);
INSERT INTO `t_project_plan_create` VALUES (351183919575793664, '测试修改计划11', 2, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-04 14:28:24', 1, '更新人测试账号', '2019-11-05 10:54:00', 1);
INSERT INTO `t_project_plan_create` VALUES (351267371138482176, '测试名称3', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, '2019-11-26 15:34:14', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-04 17:37:58', 1, '更新人测试账号', '2019-11-04 17:37:58', 1);
INSERT INTO `t_project_plan_create` VALUES (351529326453522432, '测试修改计划', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 10:58:53', 1, '更新人测试账号', '2019-11-05 11:02:06', 1);
INSERT INTO `t_project_plan_create` VALUES (351534169234669568, '测试修改计划', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 11:18:07', 1, '更新人测试账号', '2019-11-05 11:18:50', 1);
INSERT INTO `t_project_plan_create` VALUES (351543403837980672, '测试计划1105', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 11:54:49', 1, '更新人测试账号', '2019-11-05 11:54:49', 1);
INSERT INTO `t_project_plan_create` VALUES (351543669861711872, '计划名称11051', NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 11:55:52', 1, '更新人测试账号', '2019-11-05 11:55:52', 1);
INSERT INTO `t_project_plan_create` VALUES (351544486371065856, 'aaa', NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 11:59:07', 1, '更新人测试账号', '2019-11-05 11:59:07', 1);
INSERT INTO `t_project_plan_create` VALUES (351545399290691584, '测试计划名称', NULL, NULL, NULL, NULL, NULL, 1, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 12:02:45', 1, '更新人测试账号', '2019-11-05 12:02:45', 1);
INSERT INTO `t_project_plan_create` VALUES (351547225180274688, '测试时间', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2019-11-05 12:08:37', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 12:10:00', 1, '更新人测试账号', '2019-11-05 12:10:00', 1);
INSERT INTO `t_project_plan_create` VALUES (351549654122692608, '测试计划名称111', NULL, NULL, NULL, NULL, NULL, 1, 1, '2019-11-05 12:18:10', '2019-11-06 12:18:11', '2019-11-05 12:18:12', 24, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 12:19:39', 1, '更新人测试账号', '2019-11-05 12:19:39', 1);
INSERT INTO `t_project_plan_create` VALUES (351552635807268864, 'b123a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 12:31:30', 1, '更新人测试账号', '2019-11-05 12:31:30', 1);
INSERT INTO `t_project_plan_create` VALUES (351578288845815808, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '计划内容测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 14:13:26', 1, '更新人测试账号', '2019-11-05 14:13:26', 1);
INSERT INTO `t_project_plan_create` VALUES (351578312191311872, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '备注测试', NULL, NULL, 1, '创建人测试账号', '2019-11-05 14:13:32', 1, '更新人测试账号', '2019-11-05 14:13:32', 1);
INSERT INTO `t_project_plan_create` VALUES (351578552264884224, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 14:14:29', 1, '更新人测试账号', '2019-11-05 14:14:29', 1);
INSERT INTO `t_project_plan_create` VALUES (351578769936678912, '测试计划名称', NULL, NULL, NULL, NULL, NULL, 1, 1, '2019-11-05 00:00:00', '2019-11-06 00:00:00', '2019-11-07 00:00:00', 24, NULL, NULL, NULL, NULL, 1, '计划内容', NULL, NULL, NULL, NULL, NULL, '备注', NULL, NULL, 1, '创建人测试账号', '2019-11-05 14:15:21', 1, '更新人测试账号', '2019-11-05 14:15:21', 1);
INSERT INTO `t_project_plan_create` VALUES (351585661106847744, 'cece', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 14:42:44', 1, '更新人测试账号', '2019-11-05 14:42:44', 1);
INSERT INTO `t_project_plan_create` VALUES (351585676567052288, 'ce', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 14:42:48', 1, '更新人测试账号', '2019-11-05 14:42:48', 1);
INSERT INTO `t_project_plan_create` VALUES (351585699681861632, 'ce', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 14:42:53', 1, '更新人测试账号', '2019-11-05 14:42:53', 1);
INSERT INTO `t_project_plan_create` VALUES (351608351653953536, '计划名称测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-05 16:12:54', 1, '更新人测试账号', '2019-11-05 16:12:54', 1);
INSERT INTO `t_project_plan_create` VALUES (351877761132171264, '计划1106', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-06 10:03:26', 1, '更新人测试账号', '2019-11-06 10:03:26', 1);
INSERT INTO `t_project_plan_create` VALUES (352674078301417472, 'FridayPlan', NULL, NULL, '007', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-08 14:47:43', 1, '更新人测试账号', '2019-11-08 14:47:43', 1);
INSERT INTO `t_project_plan_create` VALUES (352677739610042368, 'FridayPlan', NULL, NULL, '007', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-08 15:02:16', 1, '更新人测试账号', '2019-11-08 15:02:16', 1);
INSERT INTO `t_project_plan_create` VALUES (352679457169141760, 'TuesdayPlan', NULL, NULL, '001', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-08 15:09:05', 1, '更新人测试账号', '2019-11-08 15:09:05', 1);
INSERT INTO `t_project_plan_create` VALUES (353770825798950912, '测试计划名称111', NULL, NULL, 'TP201911110012', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '计划内容', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-11 15:25:48', 1, '更新人测试账号', '2019-11-11 15:25:48', 1);
INSERT INTO `t_project_plan_create` VALUES (353770926739070976, '1111计划', NULL, NULL, 'TP201911110013', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '这是一条测试计划内容', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-11 15:26:12', 1, '更新人测试账号', '2019-11-11 15:26:12', 1);
INSERT INTO `t_project_plan_create` VALUES (353776975999180800, '测试计划名称211', NULL, NULL, 'TP201911110015', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-11 15:50:14', 1, '更新人测试账号', '2019-11-11 15:50:14', 1);
INSERT INTO `t_project_plan_create` VALUES (353807912728305664, '测试子计划', NULL, NULL, 'TP201911110009', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-11 17:53:10', 1, '更新人测试账号', '2019-11-11 17:53:10', 1);
INSERT INTO `t_project_plan_create` VALUES (354134373288935424, '测试计划11', NULL, NULL, 'TP201911120017', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-12 15:30:24', 1, '更新人测试账号', '2019-11-12 15:30:24', 1);
INSERT INTO `t_project_plan_create` VALUES (354443400552157184, 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 11:58:22', 1, '更新人测试账号', '2019-11-13 11:58:22', 1);
INSERT INTO `t_project_plan_create` VALUES (354443564956291072, '测试附件1113', NULL, NULL, 'TP201911130061', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 11:59:01', 1, '更新人测试账号', '2019-11-13 11:59:01', 1);
INSERT INTO `t_project_plan_create` VALUES (354445350752522240, 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 12:06:07', 1, '更新人测试账号', '2019-11-13 12:06:07', 1);
INSERT INTO `t_project_plan_create` VALUES (354445490489954304, 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 12:06:40', 1, '更新人测试账号', '2019-11-13 12:06:40', 1);
INSERT INTO `t_project_plan_create` VALUES (354473597175369728, 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 13:58:22', 1, '更新人测试账号', '2019-11-13 13:58:22', 1);
INSERT INTO `t_project_plan_create` VALUES (354473865791180800, 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 13:59:26', 1, '更新人测试账号', '2019-11-13 13:59:26', 1);
INSERT INTO `t_project_plan_create` VALUES (354475558578720768, 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 14:06:09', 1, '更新人测试账号', '2019-11-13 14:06:09', 1);
INSERT INTO `t_project_plan_create` VALUES (354475892537593856, 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 14:07:29', 1, '更新人测试账号', '2019-11-13 14:07:29', 1);
INSERT INTO `t_project_plan_create` VALUES (354476126038691840, 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 14:08:25', 1, '更新人测试账号', '2019-11-13 14:08:25', 1);
INSERT INTO `t_project_plan_create` VALUES (354476389671669760, 'aa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 14:09:27', 1, '更新人测试账号', '2019-11-13 14:09:27', 1);
INSERT INTO `t_project_plan_create` VALUES (354497812888850432, '测试质量要求', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-13 15:34:35', 1, '更新人测试账号', '2019-11-13 15:34:35', 1);
INSERT INTO `t_project_plan_create` VALUES (354846803816128512, '测试参与人', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-14 14:41:21', 1, '更新人测试账号', '2019-11-14 14:41:21', 1);
INSERT INTO `t_project_plan_create` VALUES (355159056771772416, '测试关联计划', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-15 11:22:08', 1, '更新人测试账号', '2019-11-15 11:22:08', 1);
INSERT INTO `t_project_plan_create` VALUES (355199246219407360, '计划1115', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-15 14:01:50', 1, '更新人测试账号', '2019-11-15 14:01:50', 1);
INSERT INTO `t_project_plan_create` VALUES (355218958571597824, NULL, NULL, NULL, NULL, 354476389671669760, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, 513, 349716777475383300, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:20:10', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355219123869118464, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, 513, 349716777068535800, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:20:49', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355219216873615360, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:21:11', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355219366517993472, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:21:47', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355219733154689024, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:23:14', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355219991666421760, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:24:16', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355220347930603520, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:25:41', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355220987264167936, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:28:13', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355221369444954112, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:29:44', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355223246228221952, NULL, NULL, NULL, NULL, 355218958571597824, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:37:12', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355223871376650240, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:39:41', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355224614498267136, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-15 15:42:38', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355506460716998656, '测试参与人', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-16 10:22:35', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355611220656824320, '计划名称', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-16 17:18:52', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355611502920900608, '测试计划名称', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-16 17:19:59', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355612109689888768, '123', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-16 17:22:24', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355616309396152320, '测试相关内容', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-16 17:39:05', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355619360471293952, '测试附件', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-16 17:51:13', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355621199392579584, '测试111', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-16 17:58:31', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355626693465251840, 'aa', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-16 18:20:21', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (355628494675550208, '计划', NULL, NULL, NULL, NULL, 349716776946900992, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-16 18:27:31', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356320553220743168, '计划附件测试', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 16:17:30', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356334160650215424, '测试交付要求', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 17:11:34', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356335491184107520, '测试质量要求汇报要求', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 17:16:52', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356336821139185664, '测试汇报要求', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 17:22:09', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356338774464307200, '测试汇报要求', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 17:29:55', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_create` VALUES (356342527380725760, '测试关联计划', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 17:44:49', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356343029787041792, '测试关联计划', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 17:46:49', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356358285175332864, '测试交付要求附件', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 18:47:26', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_create` VALUES (356358789615886336, '1118交付要求', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 18:49:26', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_create` VALUES (356359698571894784, '1111', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 18:53:03', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356360964626751488, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 18:58:05', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356361443540770816, '123', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-18 18:59:59', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356958728310005760, 'aa', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, '2019-11-05 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-20 10:33:23', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356961560673165312, NULL, NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-20 10:44:38', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356964007890165760, 'jihua ', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-20 10:54:22', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356964711816011776, '12test', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-20 10:57:10', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356982255113248768, '计划名称', NULL, NULL, NULL, NULL, 349716776946900992, 1, 1, '2019-11-20 12:03:04', '2019-11-21 00:00:00', '2019-11-22 00:00:00', 11, 513, 349716777068535800, NULL, NULL, 1, '计划内容', NULL, NULL, NULL, NULL, NULL, '备注', NULL, 1, 380, '何革学', '2019-11-20 12:06:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_create` VALUES (356983660389638144, '测试关联计划', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-20 12:12:27', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_create` VALUES (356985741452288000, '123', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-20 12:20:43', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_create` VALUES (356986260770037760, '231', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-20 12:22:47', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_create` VALUES (357076868691959808, '测试关联计划111', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-20 18:22:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_create` VALUES (357317452572692480, '测试关联计划', NULL, NULL, NULL, NULL, 349716776946900992, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 380, '何革学', '2019-11-21 10:18:50', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_plan_deliver_requirement
-- ----------------------------
DROP TABLE IF EXISTS `t_project_plan_deliver_requirement`;
CREATE TABLE `t_project_plan_deliver_requirement`  (
  `plan_deliver_requirement_id` bigint(64) NOT NULL COMMENT '交付要求id',
  `plan_deliver_requirement_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交付要求名',
  `plan_deliver_requirement_time` datetime(0) NULL DEFAULT NULL COMMENT '交付要求时间',
  `plan_deliver_requirement_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交付要求描述',
  `plan_deliver_requirement_appendix_id` bigint(64) NULL DEFAULT NULL COMMENT '交付要求附件id',
  `plan_id` bigint(64) NULL DEFAULT NULL COMMENT '计划id外键',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`plan_deliver_requirement_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_plan_deliver_requirement
-- ----------------------------
INSERT INTO `t_project_plan_deliver_requirement` VALUES (351525891830251520, '交付要求aa', NULL, NULL, NULL, 356595750993690624, 1, '创建人测试账号', '2019-11-05 10:45:14', 1, '更新人测试账号', '2019-11-05 10:45:14', 1);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (351535324727672832, 'aaa', NULL, '123aaa', NULL, 351578769936678912, 1, '创建人测试账号', '2019-11-05 11:22:43', 1, '更新人测试账号', '2019-11-05 14:04:29', 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (351543111654375424, 'test', NULL, '123', NULL, 351578769936678912, 1, '创建人测试账号', '2019-11-05 11:53:39', 1, '更新人测试账号', '2019-11-05 14:07:54', 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (351543182110294016, 'ccc', NULL, NULL, NULL, 351578769936678912, 1, '创建人测试账号', '2019-11-05 11:53:56', 1, '更新人测试账号', '2019-11-05 11:53:56', 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (351543209985638400, 'ddd', NULL, NULL, NULL, 351578769936678912, 1, '创建人测试账号', '2019-11-05 11:54:03', 1, '更新人测试账号', '2019-11-05 11:54:03', 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354169153552416768, 'zzzz', NULL, NULL, NULL, 349360462380568576, 662, '曹操', '2019-11-12 17:48:37', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354171384469159936, 'zzzz', NULL, NULL, NULL, 356595985497227264, 662, '曹操', '2019-11-12 17:57:28', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354171439779446784, 'zzzz', NULL, NULL, NULL, 356595985497227264, 662, '曹操', '2019-11-12 17:57:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354171517650894848, '交付物名称测试', '2019-11-12 17:56:19', '交付要求说明', NULL, NULL, 662, '曹操', '2019-11-12 17:58:00', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354171537569644544, '交付物名称测试', '2019-11-12 17:56:19', '交付要求说明', NULL, NULL, 662, '曹操', '2019-11-12 17:58:05', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354171698878382080, 'zzzz', NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-12 17:58:43', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354171982606270464, 'zzzz', NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-12 17:59:51', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354172231068450816, '交付物名称', '2019-11-12 17:59:13', '交付要求说明', NULL, NULL, 662, '曹操', '2019-11-12 18:00:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354172734699503616, 'zzzz', NULL, NULL, NULL, NULL, 662, '曹操', '2019-11-12 18:02:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354177603309174784, '测试交付物名称', '2019-11-12 18:20:35', '交付要求说明', NULL, NULL, 662, '曹操', '2019-11-12 18:22:11', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354181192383496192, '测试交付物名称', '2019-11-12 18:34:51', '交付要求说明', NULL, NULL, 662, '曹操', '2019-11-12 18:36:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354404616930365440, '交付物名称1113', '2019-11-13 09:22:38', '交付要求说明', NULL, 354476389671669760, 662, '曹操', '2019-11-13 09:24:15', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354438238810968064, '1', NULL, NULL, NULL, 354476389671669760, 662, '曹操', '2019-11-13 11:37:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354493890430275584, '交付物名称', '2019-11-13 15:17:17', '交付要求说明', NULL, NULL, 662, '曹操', '2019-11-13 15:19:00', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354855231041085440, '交付物名称', '2019-11-14 15:13:06', '交付要求说明', NULL, NULL, 662, '曹操', '2019-11-14 15:14:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (354858556042027008, '交付名称', '2019-11-14 15:26:20', '交付要求说明', NULL, NULL, 662, '曹操', '2019-11-14 15:28:03', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (355594969972776960, 'ces', '2019-11-16 16:12:39', '说明', NULL, NULL, 380, '何革学', '2019-11-16 16:14:18', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (355613981469351936, '交付物名称', '2019-11-16 17:28:16', '交付要求说明', NULL, 355616309396152320, 380, '何革学', '2019-11-16 17:29:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (355626432097198080, 'aa', '2019-11-06 00:00:00', NULL, NULL, 355626693465251840, 380, '何革学', '2019-11-16 18:19:19', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (355628466158477312, '千万千万', NULL, NULL, NULL, 355628494675550208, 380, '何革学', '2019-11-16 18:27:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (355629258651246592, '123', NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-16 18:30:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (356313416880922624, '交付物名称', '2019-11-18 15:47:18', '交付物要求说明', NULL, NULL, 380, '何革学', '2019-11-18 15:49:09', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (356333904097222656, '交付物名称', '2019-11-18 17:08:30', '交付要求说明', NULL, NULL, 380, '何革学', '2019-11-18 17:10:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (356334141448691712, '交付物名称', '2019-11-18 17:09:40', '交付要求说明', NULL, 356334160650215424, 380, '何革学', '2019-11-18 17:11:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (356358256855392256, '交付物名称', '2019-11-18 18:45:29', '交付要求说明', NULL, 356358285175332864, 380, '何革学', '2019-11-18 18:47:19', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (356358623009742848, '交付名称', '2019-11-18 18:46:54', '交付要求说明', NULL, 356358789615886336, 380, '何革学', '2019-11-18 18:48:47', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (356359512382545920, '请求', NULL, NULL, NULL, 356359698571894784, 380, '何革学', '2019-11-18 18:52:19', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (356361427745021952, '123', NULL, NULL, NULL, 356361443540770816, 380, '何革学', '2019-11-18 18:59:55', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (356735473179459584, '交付物名称', '2019-11-19 19:38:58', '交付要求说明', NULL, 356735550476288000, 380, '何革学', '2019-11-19 19:46:15', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (356964357275688960, '1223', NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-20 10:55:45', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_deliver_requirement` VALUES (356982053719547904, '交付物名称', '2019-11-20 12:04:15', '交付要求说明', NULL, 356982255113248768, 380, '何革学', '2019-11-20 12:06:04', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_plan_head_status
-- ----------------------------
DROP TABLE IF EXISTS `t_project_plan_head_status`;
CREATE TABLE `t_project_plan_head_status`  (
  `plan_head_status_id` bigint(64) NULL DEFAULT NULL,
  `cur_user_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '当前登陆用户id',
  `plan_id` bigint(32) NULL DEFAULT 1 COMMENT '计划id显示状态',
  `plan_name` bigint(32) NULL DEFAULT 1 COMMENT '计划名显示状态',
  `plan_version` bigint(32) NULL DEFAULT 1 COMMENT '计划版本显示状态',
  `plan_apply_desc` bigint(32) NULL DEFAULT 1 COMMENT '计划申请描述显示状态',
  `plan_num` bigint(32) NULL DEFAULT 1 COMMENT '计划编号显示状态',
  `parent_plan_id` bigint(32) NULL DEFAULT 1 COMMENT '父计划id显示状态',
  `project_id` bigint(32) NULL DEFAULT 1 COMMENT '项目id显示状态',
  `project_step` bigint(32) NULL DEFAULT 1 COMMENT '项目阶段显示状态',
  `priority` bigint(32) NULL DEFAULT 1 COMMENT '项目优先级显示状态',
  `plan_startTime` bigint(32) NULL DEFAULT 1 COMMENT '项目开始时间显示状态',
  `plan_endTime` bigint(32) NULL DEFAULT 1 COMMENT '项目结束时间显示状态',
  `plan_deadline` bigint(32) NULL DEFAULT 1 COMMENT '项目截止完成时间显示状态',
  `plan_duration` bigint(32) NULL DEFAULT 1 COMMENT '项目工时显示状态',
  `plan_leader_id` bigint(32) NULL DEFAULT NULL COMMENT '负责人Id',
  `plan_team_id` bigint(32) NULL DEFAULT NULL COMMENT '团队Id',
  `plan_milestone_id` bigint(32) NULL DEFAULT 1 COMMENT '项目里程碑id显示状态',
  `plan_remind_hour` bigint(32) NULL DEFAULT 1 COMMENT '计划提醒时间显示状态',
  `plan_content` bigint(32) NULL DEFAULT 1 COMMENT '计划内容显示状态',
  `plan_appendix_id` bigint(32) NULL DEFAULT 1 COMMENT '计划附件id显示状态',
  `association_plan_id` bigint(32) NULL DEFAULT 1 COMMENT '关联计划显示状态',
  `delivery_requirement_id` bigint(32) NULL DEFAULT 1 COMMENT '交付要求id显示状态',
  `report_requirement_id` bigint(32) NULL DEFAULT 1 COMMENT '汇报要求显示状态',
  `quality_requirement_id` bigint(32) NULL DEFAULT 1 COMMENT '质量要求id显示状态',
  `plan_remark` bigint(32) NULL DEFAULT 1 COMMENT '计划备注显示状态',
  `check_status` bigint(32) NULL DEFAULT 1 COMMENT '审核状态显示状态',
  `create_id` bigint(32) NULL DEFAULT 1 COMMENT '创建人id显示状态',
  `create_by` bigint(32) NULL DEFAULT 1 COMMENT '创建人显示状态',
  `create_time` bigint(32) NULL DEFAULT 1 COMMENT '创建时间显示状态',
  `update_id` bigint(32) NULL DEFAULT 1 COMMENT '更新人id显示状态',
  `update_by` bigint(32) NULL DEFAULT 1 COMMENT '更新人显示状态',
  `update_time` bigint(32) NULL DEFAULT 1 COMMENT '更新时间显示状态',
  `del_status` bigint(32) NULL DEFAULT 1 COMMENT '删除状态显示状态',
  PRIMARY KEY (`cur_user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_plan_head_status
-- ----------------------------
INSERT INTO `t_project_plan_head_status` VALUES (355611220451303424, 380, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `t_project_plan_head_status` VALUES (355199246097772544, 662, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (352677739048005632, 1573196535647, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (352679457009758208, 1573196945240, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (353770825631178752, 1573457147793, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (353770926579687424, 1573457171868, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (353776975663636480, 1573458614066, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (353807912594087936, 1573465990020, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354134372945002496, 1573543824233, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354439547643531264, 1573616583551, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354439571534286848, 1573616589247, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354440184049471488, 1573616735283, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354440536371007488, 1573616819282, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354441297582657536, 1573617000766, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354441539606581248, 1573617058472, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354442360410902528, 1573617254165, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354442559434821632, 1573617301616, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354442825492107264, 1573617365051, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354443159954296832, 1573617444793, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354443400145309696, 1573617502055, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354443564788518912, 1573617541313, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354443714185433088, 1573617576929, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354443913255489536, 1573617624394, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354445194531475456, 1573617929871, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354445350593138688, 1573617967082, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354445405639184384, 1573617980206, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354445424719073280, 1573617984755, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354445490238296064, 1573618000376, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354445659340050432, 1573618040693, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354448610376847360, 1573618744273, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354472063528112128, 1573624335929, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354472156608106496, 1573624358134, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354472190951067648, 1573624366322, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354472491892379648, 1573624438072, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354472871560777728, 1573624528590, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354472909506646016, 1573624537638, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354473421933154304, 1573624659810, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354473596789493760, 1573624701495, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354473865615020032, 1573624765593, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354474356788989952, 1573624882698, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354475134903685120, 1573625068213, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354475380480184320, 1573625126763, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354475558410948608, 1573625169185, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354475892260769792, 1573625248783, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354476125837365248, 1573625304472, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354476389537452032, 1573625367343, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354497812658163712, 1573630475013, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (354846803614801920, 1573713680942, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_project_plan_head_status` VALUES (355159056591417340, 1573788127852, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1);

-- ----------------------------
-- Table structure for t_project_plan_participant
-- ----------------------------
DROP TABLE IF EXISTS `t_project_plan_participant`;
CREATE TABLE `t_project_plan_participant`  (
  `plan_panticipant_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '计划参与人表主键id',
  `plan_id` bigint(64) NULL DEFAULT NULL COMMENT '计划id',
  `plan_paticipant_user_id` bigint(64) NULL DEFAULT NULL COMMENT '参与人id',
  PRIMARY KEY (`plan_panticipant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_plan_participant
-- ----------------------------
INSERT INTO `t_project_plan_participant` VALUES (1, 1, 1);
INSERT INTO `t_project_plan_participant` VALUES (2, 1, 2);
INSERT INTO `t_project_plan_participant` VALUES (3, 1, 535);
INSERT INTO `t_project_plan_participant` VALUES (355200545795141632, NULL, 1001);
INSERT INTO `t_project_plan_participant` VALUES (355200545828696064, NULL, 1002);
INSERT INTO `t_project_plan_participant` VALUES (355200545837084672, NULL, 1003);
INSERT INTO `t_project_plan_participant` VALUES (355219216890392576, NULL, 513);
INSERT INTO `t_project_plan_participant` VALUES (355219216902975488, NULL, 381);
INSERT INTO `t_project_plan_participant` VALUES (355219366547353600, NULL, 513);
INSERT INTO `t_project_plan_participant` VALUES (355219366555742208, NULL, 381);
INSERT INTO `t_project_plan_participant` VALUES (355219733179854848, NULL, 513);
INSERT INTO `t_project_plan_participant` VALUES (355219733188243456, NULL, 381);
INSERT INTO `t_project_plan_participant` VALUES (355219733200826368, NULL, 382);
INSERT INTO `t_project_plan_participant` VALUES (355219991691587584, NULL, 513);
INSERT INTO `t_project_plan_participant` VALUES (355219991704170496, NULL, 381);
INSERT INTO `t_project_plan_participant` VALUES (355220347955769344, NULL, 513);
INSERT INTO `t_project_plan_participant` VALUES (355220987301916672, NULL, 513);
INSERT INTO `t_project_plan_participant` VALUES (355220987310305280, NULL, 381);
INSERT INTO `t_project_plan_participant` VALUES (355221369474314240, NULL, 383);
INSERT INTO `t_project_plan_participant` VALUES (355223246253387776, 355223246228221952, 513);
INSERT INTO `t_project_plan_participant` VALUES (355223246265970688, 355223246228221952, 381);
INSERT INTO `t_project_plan_participant` VALUES (355223871401816064, 355223871376650240, 513);
INSERT INTO `t_project_plan_participant` VALUES (355223871414398976, 355223871376650240, 382);
INSERT INTO `t_project_plan_participant` VALUES (355224614527627264, 355224614498267136, 513);
INSERT INTO `t_project_plan_participant` VALUES (355224614540210176, 355224614498267136, 381);
INSERT INTO `t_project_plan_participant` VALUES (355506460758941696, 355506460716998656, 513);
INSERT INTO `t_project_plan_participant` VALUES (355506460771524608, 355506460716998656, 381);

-- ----------------------------
-- Table structure for t_project_plan_quality_requirement
-- ----------------------------
DROP TABLE IF EXISTS `t_project_plan_quality_requirement`;
CREATE TABLE `t_project_plan_quality_requirement`  (
  `plan_quality_requirement_id` bigint(64) NOT NULL COMMENT '质量要求id',
  `plan_quality_requirement_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '质量要求名',
  `plan_quality_requirement_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '质量要求内容',
  `plan_quality_appendix_id` bigint(64) NULL DEFAULT NULL COMMENT '质量要求附件id',
  `plan_id` bigint(64) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`plan_quality_requirement_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_plan_quality_requirement
-- ----------------------------
INSERT INTO `t_project_plan_quality_requirement` VALUES (350162965265428480, NULL, NULL, NULL, 351877761132171264, 111, NULL, NULL, NULL, 'Scot', NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (350162981342195712, NULL, NULL, NULL, 351877761132171264, 111, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (350162984404037632, NULL, NULL, NULL, 351877761132171264, 111, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (350162987432325120, NULL, NULL, NULL, 351877761132171264, 111, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (350162989353316352, NULL, NULL, NULL, 351585661106847744, 111, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (350162990812934144, NULL, NULL, NULL, 351585661106847744, 111, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (350162991790206976, NULL, NULL, NULL, 351585661106847744, 111, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_quality_requirement` VALUES (351908611953561600, '质量要求名称aa', NULL, NULL, 351183918288142336, 1, '创建人测试id', '2019-11-06 12:06:01', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (354176996485660672, 'test1112', NULL, NULL, 354476389671669760, 1, '创建人测试id', '2019-11-12 18:19:46', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (354189974232662016, '质量名称', '质量要求', NULL, 354476389671669760, 1, '创建人测试id', '2019-11-12 19:11:21', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (354495860197068800, '质量名称', '质量要求', NULL, NULL, 1, '创建人测试id', '2019-11-13 15:26:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (354497465709531136, '测试质量名称', '测试质量要求', NULL, 354497812888850432, 1, '创建人测试id', '2019-11-13 15:33:12', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (354778212911587328, '质量名称', '质量要求', NULL, NULL, 1, '创建人测试id', '2019-11-14 10:08:48', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (354779031576813568, '质量名称', '质量要求', NULL, NULL, 1, '创建人测试id', '2019-11-14 10:12:03', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (354779684403453952, '质量名称', '质量要求', NULL, NULL, 1, '创建人测试id', '2019-11-14 10:14:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (354783714915688448, '测试质量名称', '质量要求', NULL, NULL, 1, '创建人测试id', '2019-11-14 10:30:39', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (354858619094999040, '质量名称', '质量要求', NULL, NULL, 1, '创建人测试id', '2019-11-14 15:28:18', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (356313489912143872, '质量名称', '质量要求', NULL, NULL, 380, '何革学', '2019-11-18 15:49:26', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (356335383541489664, '质量名称', '质量要求', NULL, 356335491184107520, 380, '何革学', '2019-11-18 17:16:26', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (356953180327944192, '质量名称', '质量要求', NULL, NULL, 380, '何革学', '2019-11-20 10:11:20', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (356954968116469760, '质量要求', '质量要求', NULL, 356954989905879040, 380, '何革学', '2019-11-20 10:18:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (356958641911537664, 'test1120', NULL, NULL, 356958728310005760, 380, '何革学', '2019-11-20 10:33:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (356959252631560192, 'qwe12', NULL, NULL, 356959308831039488, 380, '何革学', '2019-11-20 10:35:28', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (356960663096303616, '1120test002', NULL, NULL, NULL, 380, '何革学', '2019-11-20 10:41:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (356961422957387776, 'test003', NULL, NULL, 356961560673165312, 380, '何革学', '2019-11-20 10:44:05', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (356964520408948736, '880-0-', NULL, NULL, 356964711816011776, 380, '何革学', '2019-11-20 10:56:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_quality_requirement` VALUES (356982109587677184, '质量名称', '质量要求', NULL, 356982255113248768, 380, '何革学', '2019-11-20 12:06:18', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_plan_report_requirement
-- ----------------------------
DROP TABLE IF EXISTS `t_project_plan_report_requirement`;
CREATE TABLE `t_project_plan_report_requirement`  (
  `plan_report_requirement_id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '汇报要求id',
  `plan_report_requirement_theme` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '汇报要求主题',
  `plan_report_requirement_time` datetime(0) NULL DEFAULT NULL COMMENT '汇报要求时间',
  `plan_report_requirement_method` bigint(64) NULL DEFAULT NULL COMMENT '汇报要求方式',
  `plan_report_requirement` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '汇报要求方式',
  `plan_report_appendix_id` bigint(64) NULL DEFAULT NULL COMMENT '汇报要求附件id',
  `plan_id` bigint(64) NULL DEFAULT NULL COMMENT '计划id 外键',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '修改人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_status` bigint(64) UNSIGNED NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`plan_report_requirement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 356982168689614849 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_plan_report_requirement
-- ----------------------------
INSERT INTO `t_project_plan_report_requirement` VALUES (351943363368620032, '1', NULL, NULL, NULL, NULL, 354476389671669760, 1, '创建人测试账号', '2019-11-06 14:24:07', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (351943494998462464, '1', NULL, NULL, NULL, NULL, 351608351653953536, 1, '创建人测试账号', '2019-11-06 14:24:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (351943768970399744, '1', NULL, NULL, NULL, NULL, 351608351653953536, 1, '创建人测试账号', '2019-11-06 14:25:44', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (351943925870923776, '1', NULL, NULL, NULL, NULL, 351608351653953536, 1, '创建人测试账号', '2019-11-06 14:26:21', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (351944016031682560, '1', NULL, NULL, NULL, NULL, 351585699681861632, 1, '创建人测试账号', '2019-11-06 14:26:42', NULL, NULL, NULL, 1);
INSERT INTO `t_project_plan_report_requirement` VALUES (354177992746106880, '111', NULL, NULL, NULL, NULL, NULL, 1, '创建人测试账号', '2019-11-12 18:23:44', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (354551511279505408, '汇报主题', '2019-11-13 19:06:20', 1, '汇报要求', NULL, NULL, 1, '创建人测试账号', '2019-11-13 19:07:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (354855910157623296, '汇报主题', '2019-11-14 15:15:46', 1, '汇报要求', NULL, NULL, 1, '创建人测试账号', '2019-11-14 15:17:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (354857036189835264, '汇报主题', '2019-11-14 15:20:13', 1, '汇报要求', NULL, NULL, 1, '创建人测试账号', '2019-11-14 15:22:01', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (354857520724221952, '汇报主题', '2019-11-14 15:22:11', 1, '汇报要求', NULL, NULL, 1, '创建人测试账号', '2019-11-14 15:23:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (354859188257857536, '测试', '2019-11-14 15:28:52', 2, '测试', NULL, NULL, 1, '创建人测试账号', '2019-11-14 15:30:34', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (354860681694322688, '汇报主题', '2019-11-14 15:34:53', 1, '汇报要求', NULL, NULL, 1, '创建人测试账号', '2019-11-14 15:36:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (354861669398388736, '汇报主题', '2019-11-14 15:38:43', 1, '汇报要求', NULL, NULL, 1, '创建人测试账号', '2019-11-14 15:40:25', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (355205810523271168, '汇报主题', '2019-11-15 14:26:15', 3, '123', NULL, NULL, 1, '创建人测试账号', '2019-11-15 14:27:55', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (356313591150059520, '汇报主题', '2019-11-18 15:47:57', 1, '汇报要求', NULL, NULL, 380, '何革学', '2019-11-18 15:49:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (356335475233169408, '汇报主题', '2019-11-18 17:14:55', 1, '汇报要求', NULL, NULL, 380, '何革学', '2019-11-18 17:16:48', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (356336790638206976, '汇报主题', '2019-11-18 17:20:12', 1, '汇报要求', NULL, NULL, 380, '何革学', '2019-11-18 17:22:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (356338763496202240, '汇报主题', '2019-11-18 17:28:00', 1, '汇报要求', NULL, 356338774464307200, 380, '何革学', '2019-11-18 17:29:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (356340940952346624, '测试汇报要求附件', '2019-11-18 17:36:40', 1, '汇报要求', NULL, NULL, 380, '何革学', '2019-11-18 17:38:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (356961132506030080, '汇报主题', '2019-11-20 10:41:05', 1, '汇报要求', NULL, NULL, 380, '何革学', '2019-11-20 10:42:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (356963555215712256, '汇报主题', '2019-11-20 10:50:41', 1, '汇报要求', NULL, 356963578057891840, 380, '何革学', '2019-11-20 10:52:34', NULL, NULL, NULL, 0);
INSERT INTO `t_project_plan_report_requirement` VALUES (356982168689614848, '汇报主题', '2019-11-20 12:04:43', 1, '汇报要求', NULL, 356982255113248768, 380, '何革学', '2019-11-20 12:06:32', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_post
-- ----------------------------
DROP TABLE IF EXISTS `t_project_post`;
CREATE TABLE `t_project_post`  (
  `id` bigint(64) NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL,
  `content` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `area_type` int(2) NULL DEFAULT NULL,
  `origin` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `place` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` bigint(64) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目动态表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_post_connect
-- ----------------------------
DROP TABLE IF EXISTS `t_project_post_connect`;
CREATE TABLE `t_project_post_connect`  (
  `id` bigint(64) UNSIGNED ZEROFILL NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `type` int(2) NULL DEFAULT NULL COMMENT '类型(1.@我，2.我的收藏，3.赞，4.评论)',
  `post_id` bigint(64) NULL DEFAULT NULL COMMENT '发布id',
  `user_id` bigint(64) NULL DEFAULT NULL COMMENT '用户id',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '动态查询分类表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_project
-- ----------------------------
DROP TABLE IF EXISTS `t_project_project`;
CREATE TABLE `t_project_project`  (
  `id` bigint(64) NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编号',
  `type` bigint(64) NULL DEFAULT NULL COMMENT '类型',
  `priority` bigint(64) NULL DEFAULT NULL COMMENT '优先级',
  `level` bigint(64) NULL DEFAULT NULL COMMENT '项目级别',
  `risk_level` bigint(64) NULL DEFAULT NULL COMMENT '风险级别',
  `resource` int(5) NULL DEFAULT NULL COMMENT '来源',
  `connect_id` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联的业务id',
  `resource_describe` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '其他类型使用-来源说明',
  `partners` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参与人',
  `applyer` bigint(64) NULL DEFAULT NULL COMMENT '申请人',
  `apply_depart` bigint(64) NULL DEFAULT NULL COMMENT '申请部门',
  `plan_startTime` datetime(0) NULL DEFAULT NULL COMMENT '计划开始时间',
  `plan_endTime` datetime(0) NULL DEFAULT NULL COMMENT '计划结束时间',
  `duration` decimal(12, 2) NULL DEFAULT NULL COMMENT '项目工期',
  `leader` bigint(64) NULL DEFAULT NULL COMMENT '项目负责人',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `content` blob NULL COMMENT '项目内容',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新人时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  `reg_id` bigint(64) NULL DEFAULT NULL COMMENT '组织id',
  `parent_id` bigint(64) NULL DEFAULT NULL COMMENT '父项目',
  `real_duration` decimal(12, 2) NULL DEFAULT NULL COMMENT '实际工期',
  `real_start_time` datetime(0) NULL DEFAULT NULL COMMENT '实际开始时间',
  `real_end_time` datetime(0) NULL DEFAULT NULL COMMENT '实际结束时间',
  `verify_status` int(2) NULL DEFAULT NULL COMMENT '审核状态',
  `establishment` int(2) NULL DEFAULT NULL COMMENT '是否立项',
  `project_status` int(2) NULL DEFAULT NULL COMMENT '项目状态',
  `action_status` int(2) NULL DEFAULT NULL COMMENT '执行状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '项目信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_project
-- ----------------------------
INSERT INTO `t_project_project` VALUES (1, '111', '123456789', 337455796830650368, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', '', '535,538', 535, 283, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0x3C703EE698AFE79A84E983ADE5BEB7E7BAB23C2F703E, 662, NULL, NULL, 662, '曹操', '2019-10-29 14:55:50', 1, 204, NULL, NULL, NULL, NULL, 1, 1, 1, 2);
INSERT INTO `t_project_project` VALUES (2, NULL, '33444555', 337455796830650368, 337455796935507968, 337455797011005440, 337455797090697216, 2, '1447742867754946237,1447743095172724926', NULL, '535,538', 535, 284, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, NULL, NULL, 662, NULL, NULL, 0, 204, NULL, NULL, NULL, NULL, 1, 1, 1, 1);
INSERT INTO `t_project_project` VALUES (3, NULL, '53698221151', 337455796830650368, 337455796935507968, 337455797011005440, 337455797090697216, 3, '', '测试', '535,538', 535, 283, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, NULL, NULL, 662, '曹操', '2019-10-25 12:21:36', 1, 204, NULL, NULL, NULL, NULL, 1, 1, 1, 1);
INSERT INTO `t_project_project` VALUES (10, '计划测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 499, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_project` VALUES (346823536683036672, '测试项目2', NULL, 1, 2, 3, 4, 1, '5,6', '', NULL, 9, 285, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 11.00, 9, '12', 0x3133, 662, '曹操', '2019-10-23 11:19:45', 662, '曹操', '2019-10-28 18:16:48', 1, 204, NULL, NULL, NULL, NULL, 1, 1, 1, 1);
INSERT INTO `t_project_project` VALUES (348737495773093888, '前端', NULL, 346515989577101300, 346515989627432960, 346515989673570300, 346515989723901950, 3, '', NULL, NULL, 379, NULL, '2019-10-15 00:00:00', '2019-10-15 00:00:00', 20.00, 386, '多对多', '', 662, '曹操', '2019-10-28 18:05:08', 662, '曹操', '2019-10-28 18:16:46', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (348738015267004416, '对等', NULL, 346515989577101300, 346515989627432960, 346515989673570300, 346515989723901950, 3, '', NULL, NULL, 380, NULL, '2019-10-06 00:00:00', '2019-10-21 00:00:00', 20.00, 384, '多对多', '', 662, '曹操', '2019-10-28 18:07:12', 662, '曹操', '2019-10-28 18:19:33', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (348740712703598592, '前端', NULL, 346515989577101300, 346515989627432960, 346515989673570300, 346515989723901950, 3, '', NULL, NULL, 513, NULL, '2019-10-29 02:00:00', '2019-10-23 02:00:00', 20.00, 382, '多对多', '', 662, '曹操', '2019-10-28 18:17:55', 662, '曹操', '2019-10-28 18:19:31', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (348741009387692032, '对等', NULL, 346515989577101300, 346515989627432960, 346515989673570300, 346515989723901950, 3, '', NULL, NULL, 381, NULL, '2019-10-30 00:00:00', '2019-10-13 00:00:00', 2.00, 513, '对等', '', 662, '曹操', '2019-10-28 18:19:06', 662, '曹操', '2019-10-28 18:19:29', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (348741405044776960, '前端', NULL, 346515989577101300, 346515989627432960, 346515989673570300, 346515989723901950, 3, '', NULL, NULL, 385, NULL, '2019-10-28 18:20:31', '2019-10-29 01:00:00', 2.00, 383, '发', '', 662, '曹操', '2019-10-28 18:20:40', 662, '曹操', '2019-10-29 10:34:58', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (348971174197862400, '前端', NULL, 346515989577101300, 346515989627432960, 346515989673570300, 346515989723901950, 3, '', NULL, NULL, 379, NULL, '2019-10-29 09:33:32', '2019-10-24 02:00:00', 10.00, 383, '的冯绍峰', '', 662, '曹操', '2019-10-29 09:33:42', 662, '曹操', '2019-10-29 10:34:56', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (348978252421406720, '测试测试测试测试测试测试测试测试测试', NULL, 346515989577101300, 346515989627432960, 346515989673570300, 346515989723901950, 3, '', NULL, NULL, 379, NULL, '2019-10-29 10:01:32', '2019-10-31 19:00:00', 2.00, 382, '测试测试测试', '', 662, '曹操', '2019-10-29 10:01:49', 662, '曹操', '2019-10-29 10:34:55', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (348981350716022784, '测试测试111111111', NULL, 346515989577101300, 346515989627432960, 346515989673570300, 346515989723901950, 3, '', NULL, NULL, 379, NULL, '2019-10-07 00:00:00', '2019-10-29 10:13:59', 10.00, 385, '地地道道', '', 662, '曹操', '2019-10-29 10:14:08', 662, '曹操', '2019-10-29 10:34:53', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (348986819090194432, '测试', NULL, 346515989577101300, 346515989627432960, 346515989673570300, 346515989723901950, 3, '2,336289884868546560,336292048735145984,', NULL, NULL, 381, NULL, '2019-10-29 10:35:42', '2019-10-31 00:00:00', 1.00, 379, '对等', '', 662, '曹操', '2019-10-29 10:35:52', 662, '曹操', '2019-10-29 10:57:25', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (348989741702193152, '多对多', NULL, 346515989577101300, 346515989627432960, 346515989673570300, 346515989723901950, 3, '336289884868546560,336292048735145984,', NULL, NULL, 513, NULL, '2019-10-21 00:00:00', '2019-10-27 00:00:00', 3.00, 381, '', '', 662, '曹操', '2019-10-29 10:47:29', 662, '曹操', '2019-10-29 10:57:23', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (348999602510897152, '测试', NULL, 346515989577101313, 346515989627432960, 346515989673570304, 346515989723901952, 3, '336289884868546560,', NULL, NULL, 379, NULL, '2019-10-29 11:26:27', '2019-10-31 00:00:00', 2.00, 513, '测试', '', 662, '曹操', '2019-10-29 11:26:40', 662, '曹操', '2019-10-29 14:51:23', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (349000894559084544, '测试', NULL, 346515989577101313, 346515989627432960, 346515989673570304, 346515989723901952, 3, '336289884868546560,', NULL, NULL, 379, NULL, '2019-10-29 11:26:27', '2019-10-31 00:00:00', 2.00, 513, '测试', '', 662, '曹操', '2019-10-29 11:31:48', 662, '曹操', '2019-10-29 12:00:57', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (349003037072482304, '测试', NULL, 346515989577101313, 346515989627432960, 346515989673570304, 346515989723901952, 3, '336289884868546560,', NULL, NULL, 379, NULL, '2019-10-29 11:26:27', '2019-10-31 00:00:00', 2.00, 513, '测试', '', 662, '曹操', '2019-10-29 11:40:18', 662, '曹操', '2019-10-29 12:00:56', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (349003990688210944, '地地道道', NULL, 346515989577101312, 346515989627432961, 346515989673570304, 346515989723901953, 3, '336289884868546560,', NULL, NULL, 513, NULL, NULL, NULL, NULL, 382, '', '', 662, '曹操', '2019-10-29 11:44:06', 662, '曹操', '2019-10-29 12:00:54', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (349047720610766848, '前端测试', NULL, 346515989577101312, 346515989627432960, 346515989673570304, 346515989723901952, 3, '2,', NULL, NULL, 379, NULL, NULL, NULL, NULL, 379, '', '', 662, '曹操', '2019-10-29 14:37:52', 662, '曹操', '2019-10-29 14:51:20', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (349048343481688064, 'DDFFF', NULL, 346515989577101313, 346515989627432962, 346515989673570305, 346515989723901952, 3, '336289884868546560,336292048735145984,', NULL, NULL, 513, NULL, NULL, NULL, NULL, 381, '', '', 662, '曹操', '2019-10-29 14:40:20', 662, '曹操', '2019-10-29 14:51:17', 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (349048983813496832, '测试', NULL, 346515989577101313, 346515989627432960, 346515989673570306, 346515989723901956, 3, '2,336289884868546560,336292048735145984,', NULL, NULL, 513, NULL, NULL, NULL, NULL, 384, '', '', 662, '曹操', '2019-10-29 14:42:53', 662, '曹操', '2019-10-29 14:51:14', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (349051701441470464, '测试', NULL, 346515989577101313, 346515989627432961, 346515989673570304, 346515989723901956, 3, '336292048735145984,336293372323270656', NULL, NULL, 379, 293, NULL, NULL, NULL, 513, '', '', 662, '曹操', '2019-10-29 14:53:41', 662, '曹操', '2019-11-04 10:33:15', 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (349716776946900992, '前端', NULL, 346515989577101312, 346515989627432961, 346515989673570305, 346515989723901953, 3, '2,336289884868546560,', NULL, NULL, 379, 292, NULL, NULL, NULL, 513, '', '', 662, '曹操', '2019-10-31 10:56:27', 662, '曹操', '2019-11-01 10:03:01', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (349721012568989696, '1111前端', NULL, 346515989577101312, 346515989627432961, 346515989673570305, 346515989723901953, 3, '2,336289884868546560,', NULL, NULL, 379, 294, NULL, NULL, NULL, 513, '', '', 662, '曹操', '2019-10-31 11:13:17', 662, '曹操', '2019-11-01 10:02:58', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (349721351036739584, '前端22222222222', NULL, 346515989577101312, 346515989627432961, 346515989673570305, 346515989723901953, 3, '2,336289884868546560,', NULL, NULL, 379, 294, NULL, NULL, NULL, 513, '', '', 662, '曹操', '2019-10-31 11:14:38', 662, '曹操', '2019-11-01 10:02:56', 1, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351161415935598592, '测试', NULL, 346515989577101313, 346515989627432960, 346515989673570304, 346515989723901956, 3, '336295379272568832', NULL, NULL, 513, 293, NULL, NULL, NULL, 382, '', '', 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351913314323574784, '测试项目11111', 'Project201911060001', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351914125690712064, '测试项目11111', 'Project201911060002', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351936776865886208, '测试项目11111', 'Project201911060003', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 13:57:56', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351936905253531648, '测试项目11111', 'Project201911060004', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351940112302256128, '测试项目11111', '351936905232560128001', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL, 0, 662, 351936905253531648, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351940893411684352, '测试项目11111', 'Project201911060005', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351946089906876416, '测试项目11111', 'Project201911060005001', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL, 0, 662, 351940893411684352, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351947352291717120, '测试项目11111', 'Project201911060006', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351947469006614528, '测试项目11111', 'Project201911060007', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351947526640545792, '测试项目11111', 'Project201911060008', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:40:39', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351947619716345856, '测试项目11111', 'Project201911060009', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351951659208585216, '测试项目11111', 'Project201911060010', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL, 0, 662, NULL, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351951721422696448, '测试项目11111', 'Project201911060010zzz001', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL, 0, 662, 351951659208585216, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351951743644119040, '测试项目11111', 'Project201911060010zzz002', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL, 0, 662, 351951659208585216, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351951760140316672, '测试项目11111', 'Project201911060010zzz003', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL, 0, 662, 351951659208585216, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351951763537702912, '测试项目11111', 'Project201911060010zzz004', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 1439518603544811862, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:30', 662, '曹操', '2019-11-07 09:35:24', 0, 662, 351951659208585216, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351951766318526464, '测试项目11111', 'Project201911060010zzz005', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0, 662, 351951659208585216, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351951769099350016, '测试项目11111', 'Project201911060010zzz006', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL, 0, 662, 351951659208585216, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351951772006002688, '测试项目11111', 'Project201911060010zzz007', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0, 662, 351951659208585216, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351951774266732544, '测试项目11111', 'Project201911060010zzz008', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:32', 662, '曹操', '2019-11-09 09:59:10', 0, 662, 351951659208585216, NULL, NULL, NULL, 1, 0, 1, 2);
INSERT INTO `t_project_project` VALUES (351951776502296576, '测试项目11111', 'Project201911060010zzz009', 337108679578677248, 337108679859695619, 337108680136519680, 337108680430120960, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:33', 662, '曹操', '2019-11-07 10:16:41', 1, 662, 351951659208585216, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (351951778888855552, '测试项目11111', 'Project201911060010zzz010', 337108679578677248, 337455796935507968, 337455797011005440, 337455797090697216, 1, '1456191678252410264,1457575745619363853', NULL, NULL, 535, 14383335124461571, '2019-09-29 14:05:29', '2019-09-30 14:05:32', 1.00, 535, '测试', 0xE9A1B9E79BAEE8AFA6E68385, 662, '曹操', '2019-11-06 14:57:33', 662, '曹操', '2019-11-07 11:00:04', 1, 662, 351951659208585216, NULL, NULL, NULL, 1, 0, 1, 1);
INSERT INTO `t_project_project` VALUES (356298551248691200, 'ddd ', 'yf201911180001', 346515989577101312, 346515989627432960, 346515989673570304, 346515989723901952, 1, '1455784421584286595', NULL, NULL, 379, NULL, NULL, NULL, NULL, 379, '', '', 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL, 0, 380, NULL, NULL, NULL, NULL, 1, 0, 1, 1);

-- ----------------------------
-- Table structure for t_project_project_contactor
-- ----------------------------
DROP TABLE IF EXISTS `t_project_project_contactor`;
CREATE TABLE `t_project_project_contactor`  (
  `id` bigint(64) NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `contactor_id` bigint(64) NULL DEFAULT NULL COMMENT '联系人id',
  `customer_id` bigint(64) NULL DEFAULT NULL COMMENT '客户id',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  `remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_project_contactor
-- ----------------------------
INSERT INTO `t_project_project_contactor` VALUES (347554514590273536, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-25 11:44:24', 662, '曹操', '2019-10-25 11:52:15', 1, '1223333333');
INSERT INTO `t_project_project_contactor` VALUES (347892809927892992, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 10:08:40', 662, '曹操', '2019-10-26 14:56:36', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347903051470348288, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 10:49:21', 662, '曹操', '2019-10-26 14:51:49', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347903068419530752, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 10:49:25', 662, '曹操', '2019-10-26 14:50:01', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347903068419530753, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 10:49:25', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347903187130916864, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 10:49:54', 662, '曹操', '2019-10-26 14:46:58', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347903187130916865, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 10:49:54', 662, '曹操', '2019-10-26 14:11:49', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347903187130916866, 1, 1453683723616336371, 1, 662, '曹操', '2019-10-26 10:49:54', 662, '曹操', '2019-10-26 14:03:26', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347905425333166080, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 10:58:47', 662, '曹操', '2019-10-26 14:11:45', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347905641364987904, 1, 1453683723616336371, 1, 662, '曹操', '2019-10-26 10:59:39', 662, '曹操', '2019-10-26 14:02:21', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347905817462841344, 1, 1453683723616336371, 1, 662, '曹操', '2019-10-26 11:00:21', 662, '曹操', '2019-10-26 14:00:56', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347905817462841345, 1, 1453882561827809883, 1, 662, '曹操', '2019-10-26 11:00:21', 662, '曹操', '2019-10-26 14:03:10', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347906080735109120, 1, 1453683723616336371, 1, 662, '曹操', '2019-10-26 11:01:24', 662, '曹操', '2019-10-26 11:17:45', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347906080735109121, 1, 1453882561827809883, 1, 662, '曹操', '2019-10-26 11:01:24', 662, '曹操', '2019-10-26 11:32:32', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347906080735109122, 1, 1454031038704039251, 1, 662, '曹操', '2019-10-26 11:01:24', 662, '曹操', '2019-10-26 12:24:48', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347906241754439680, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 11:02:02', 662, '曹操', '2019-10-26 11:16:23', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347906329562193920, 1, 1453882561827809883, 1, 662, '曹操', '2019-10-26 11:02:23', 662, '曹操', '2019-10-26 11:16:44', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347965379637288960, 1, 1453683723616336371, 1, 662, '曹操', '2019-10-26 14:57:02', 662, '曹操', '2019-10-26 15:01:58', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347965409563648000, 1, 1453683723616336371, 1, 662, '曹操', '2019-10-26 14:57:09', 662, '曹操', '2019-10-26 14:58:43', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347965409563648001, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 14:57:09', 662, '曹操', '2019-10-26 14:59:34', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347965409563648002, 1, 1453882561827809883, 1, 662, '曹操', '2019-10-26 14:57:09', 662, '曹操', '2019-10-26 15:03:27', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347965409563648003, 1, 1454031038704039251, 1, 662, '曹操', '2019-10-26 14:57:09', 662, '曹操', '2019-10-26 15:00:50', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347966507036844032, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 15:01:30', 662, '曹操', '2019-10-26 15:03:30', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347966507036844033, 1, 1453683723616336371, 1, 662, '曹操', '2019-10-26 15:01:30', 662, '曹操', '2019-10-26 15:01:54', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347966507036844034, 1, 1453882561827809883, 1, 662, '曹操', '2019-10-26 15:01:30', 662, '曹操', '2019-10-26 15:01:51', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347966507036844035, 1, 1454031038704039251, 1, 662, '曹操', '2019-10-26 15:01:30', 662, '曹操', '2019-10-26 15:01:46', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347966974194229248, 1, 1452838012792298573, 1, 662, '曹操', '2019-10-26 15:03:22', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347966974194229249, 1, 1453683723616336371, 1, 662, '曹操', '2019-10-26 15:03:22', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347966974194229250, 1, 1453882561827809883, 1, 662, '曹操', '2019-10-26 15:03:22', 662, '曹操', '2019-10-26 15:03:35', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (347966974194229251, 1, 1454031038704039251, 1, 662, '曹操', '2019-10-26 15:03:22', 662, '曹操', '2019-10-26 15:03:33', 1, NULL);
INSERT INTO `t_project_project_contactor` VALUES (348977059653623808, 2, 1447742838917815051, 2, 662, '曹操', '2019-10-29 09:57:05', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_project_project_contactor` VALUES (351508767372353536, 2, 1447742838917815051, 2, 662, '曹操', '2019-11-05 09:37:11', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_project_project_contactor` VALUES (352620281797943296, 351951774266732544, 1452838012792298573, 351951774266732544, 662, '曹操', '2019-11-08 11:13:57', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_project_project_contactor` VALUES (352620281797943297, 351951774266732544, 1453683723616336371, 351951774266732544, 662, '曹操', '2019-11-08 11:13:57', 662, '曹操', '2019-11-08 11:14:13', 0, '');
INSERT INTO `t_project_project_contactor` VALUES (352620281797943298, 351951774266732544, 1453882561827809883, 351951774266732544, 662, '曹操', '2019-11-08 11:13:57', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_project_project_contactor` VALUES (352620281797943299, 351951774266732544, 1454031038704039251, 351951774266732544, 662, '曹操', '2019-11-08 11:13:57', 662, '曹操', '2019-11-08 11:14:20', 1, NULL);

-- ----------------------------
-- Table structure for t_project_project_external_contactor
-- ----------------------------
DROP TABLE IF EXISTS `t_project_project_external_contactor`;
CREATE TABLE `t_project_project_external_contactor`  (
  `id` bigint(64) NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人id',
  `sex` int(2) NULL DEFAULT NULL COMMENT '创建人',
  `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人名称',
  `department_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人名称',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除标识',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_project_external_contactor
-- ----------------------------
INSERT INTO `t_project_project_external_contactor` VALUES (1, 1, '富强', 0, '中国联通', '开发部', '卡法', '123456', '789@qq.com', '备注', 0, NULL, '2019-10-25 12:05:29', 662, '曹操', '2019-10-26 14:11:56', 0);
INSERT INTO `t_project_project_external_contactor` VALUES (347561472038834176, 1, '富强2', 0, '中国联通2', '开发部2', '卡法2', '123456222', '789@qq.com22', '备注2', 662, '曹操', '2019-10-25 12:12:02', 662, '曹操', '2019-10-26 14:53:50', 0);
INSERT INTO `t_project_project_external_contactor` VALUES (347628506125574144, 1, '张三', 1, '北京北京', '项目组', '前端', '123456', '95285550', 'ggdg g地对地导弹地对地导弹多对多的 的', 662, '曹操', '2019-10-25 16:38:25', 662, '曹操', '2019-10-28 11:27:38', 0);
INSERT INTO `t_project_project_external_contactor` VALUES (347636765322518528, 2, '多对多', 1, '多对多', '多对多', '对等', '122', '95428', '对等', 662, '曹操', '2019-10-25 17:11:14', 662, '曹操', '2019-10-25 17:57:07', 0);
INSERT INTO `t_project_project_external_contactor` VALUES (347647799076724736, 2, '多对多', NULL, '对等', '多对多', '的', '234', '666', ' 多对多', 662, '曹操', '2019-10-25 17:55:05', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_role
-- ----------------------------
DROP TABLE IF EXISTS `t_project_role`;
CREATE TABLE `t_project_role`  (
  `id` bigint(64) NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '人天成本',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新人时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除状态',
  `can_edit` int(2) NULL DEFAULT NULL COMMENT '可编辑状态',
  `short_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_role
-- ----------------------------
INSERT INTO `t_project_role` VALUES (1, 1, '测试角色', 12.00, '2222222', NULL, NULL, NULL, 662, '曹操', '2019-10-18 11:32:26', 0, 1, NULL);
INSERT INTO `t_project_role` VALUES (2, 1, '项目经理角色', 12.00, '22222222222', NULL, NULL, NULL, 662, '曹操', '2019-10-18 17:51:59', 1, 0, 'project_admin');
INSERT INTO `t_project_role` VALUES (346187504665018368, 1, '后援', 100.00, '后援后援ddddd d', 662, '曹操', '2019-10-21 17:12:23', 662, '曹操', '2019-10-22 11:27:34', 0, NULL, NULL);
INSERT INTO `t_project_role` VALUES (346823536779505664, 346823536683036672, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-23 11:19:45', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348737495861174272, 348737495773093888, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-28 18:05:08', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348738015321530368, 348738015267004416, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-28 18:07:12', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348740712758124544, 348740712703598592, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-28 18:17:55', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348741009438023681, 348741009387692032, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-28 18:19:06', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348741405107691520, 348741405044776960, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-28 18:20:41', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348971174302720000, 348971174197862400, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 09:33:42', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348978252467544064, 348978252421406720, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 10:01:49', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348981350749577216, 348981350716022784, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 10:14:08', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348986819748700160, 348986819090194432, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 10:35:52', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348989741786079232, 348989741702193152, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 10:47:29', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (348999602640920576, 348999602510897152, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 11:26:40', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349000894676525056, 349000894559084544, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 11:31:48', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349002856344117248, 349002856176345088, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 11:39:35', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349003037231865856, 349003037072482304, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 11:40:18', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349003990839205888, 349003990688210944, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 11:44:06', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349047720677875712, 349047720610766848, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 14:37:52', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349048343561379840, 349048343481688064, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 14:40:20', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349048983884800000, 349048983813496832, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 14:42:53', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349051701491802113, 349051701441470464, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-29 14:53:41', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349716777093701632, 349716776946900992, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349721012636098561, 349721012568989696, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-31 11:13:17', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (349721351103848449, 349721351036739584, '项目经理', NULL, '项目经理', 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351161416015290368, 351161415935598592, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351913314441015296, 351913314323574784, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351914125741043712, 351914125690712064, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351936776916217857, 351936776865886208, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 13:57:57', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351936905383555072, 351936905253531648, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351940112449056769, 351940112302256128, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351940893533319168, 351940893411684352, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351946090045288448, 351946089906876416, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351947352425934848, 351947352291717120, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351947469065334784, 351947469006614528, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351947526674100225, 351947526640545792, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:40:39', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351947619754094593, 351947619716345856, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951659334414336, 351951659208585216, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951721464639489, 351951721422696448, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951743698644992, 351951743644119040, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951760249368577, 351951760140316672, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951763583840257, 351951763537702912, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951766377246721, 351951766318526464, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951769145487361, 351951769099350016, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951772056334337, 351951772006002688, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951774308675585, 351951774266732544, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951776531656704, 351951776502296576, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (351951778930798592, 351951778888855552, '项目经理', NULL, '项目经理', 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0, NULL, 'project_admin');
INSERT INTO `t_project_role` VALUES (356298551303217153, 356298551248691200, '项目经理', NULL, '项目经理', 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL, 0, NULL, 'project_admin');

-- ----------------------------
-- Table structure for t_project_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_project_role_authority`;
CREATE TABLE `t_project_role_authority`  (
  `id` bigint(64) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `status` int(2) NULL DEFAULT NULL COMMENT '启用状态',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新人时间',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父节点',
  `serial_id` decimal(10, 2) NULL DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_role_authority
-- ----------------------------
INSERT INTO `t_project_role_authority` VALUES (1, '项目', 1, 0, 0, 'system', '2019-10-12 16:51:31', NULL, NULL, NULL, NULL, 1.00);
INSERT INTO `t_project_role_authority` VALUES (2, '项目基本信息', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 1, 2.00);
INSERT INTO `t_project_role_authority` VALUES (3, '项目阶段', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 1, 3.00);
INSERT INTO `t_project_role_authority` VALUES (4, '项目交付要求', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 1, 4.00);
INSERT INTO `t_project_role_authority` VALUES (5, '项目动态', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 5.00);
INSERT INTO `t_project_role_authority` VALUES (6, '项目团队页面', 1, 0, 0, 'system', '2019-10-14 15:58:27', NULL, NULL, NULL, NULL, 6.00);
INSERT INTO `t_project_role_authority` VALUES (7, '项目团队', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 6, 7.00);
INSERT INTO `t_project_role_authority` VALUES (8, '项目角色', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 6, 8.00);
INSERT INTO `t_project_role_authority` VALUES (9, '项目计划', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 9.00);
INSERT INTO `t_project_role_authority` VALUES (10, '计划基本信息', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 9, 10.00);
INSERT INTO `t_project_role_authority` VALUES (11, '计划前置关系', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 9, 11.00);
INSERT INTO `t_project_role_authority` VALUES (12, '计划交付要求', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 9, 12.00);
INSERT INTO `t_project_role_authority` VALUES (13, '计划资料', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 9, 13.00);
INSERT INTO `t_project_role_authority` VALUES (14, '项目任务', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 14.00);
INSERT INTO `t_project_role_authority` VALUES (15, '任务基本信息', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 14, 15.00);
INSERT INTO `t_project_role_authority` VALUES (16, '子任务', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 14, 16.00);
INSERT INTO `t_project_role_authority` VALUES (17, '任务汇报', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 14, 17.00);
INSERT INTO `t_project_role_authority` VALUES (18, '任务交付物', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 14, 18.00);
INSERT INTO `t_project_role_authority` VALUES (19, '任务资料', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 14, 19.00);
INSERT INTO `t_project_role_authority` VALUES (20, '任务评价', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 14, 20.00);
INSERT INTO `t_project_role_authority` VALUES (21, '工时汇报', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 14, 21.00);
INSERT INTO `t_project_role_authority` VALUES (22, '项目工时', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 22.00);
INSERT INTO `t_project_role_authority` VALUES (23, '工时汇报', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 22, 23.00);
INSERT INTO `t_project_role_authority` VALUES (24, '工时确认', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 22, 24.00);
INSERT INTO `t_project_role_authority` VALUES (25, '项目里程碑', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 25.00);
INSERT INTO `t_project_role_authority` VALUES (26, '项目资料', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 26.00);
INSERT INTO `t_project_role_authority` VALUES (27, '项目交付物', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 27.00);
INSERT INTO `t_project_role_authority` VALUES (28, '项目交流', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 28.00);
INSERT INTO `t_project_role_authority` VALUES (29, '项目费用', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 29.00);
INSERT INTO `t_project_role_authority` VALUES (30, '项目预算', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 29, 30.00);
INSERT INTO `t_project_role_authority` VALUES (31, '项目费用控制', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 31, 30.00);
INSERT INTO `t_project_role_authority` VALUES (32, '项目成本预估', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 32, 31.00);
INSERT INTO `t_project_role_authority` VALUES (33, '项目成本', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 29, 33.00);
INSERT INTO `t_project_role_authority` VALUES (34, '项目回款', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 29, 34.00);
INSERT INTO `t_project_role_authority` VALUES (35, '项目开票', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 29, 35.00);
INSERT INTO `t_project_role_authority` VALUES (36, '项目问题', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 36.00);
INSERT INTO `t_project_role_authority` VALUES (37, '项目看板', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 37.00);
INSERT INTO `t_project_role_authority` VALUES (38, '项目任务看板', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 37, 38.00);
INSERT INTO `t_project_role_authority` VALUES (39, '项目任务燃尽图', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 37, 39.00);
INSERT INTO `t_project_role_authority` VALUES (40, '项目工时看板', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 37, 40.00);
INSERT INTO `t_project_role_authority` VALUES (41, '项目问题看板', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 37, 41.00);
INSERT INTO `t_project_role_authority` VALUES (42, '项目费用看板', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 37, 42.00);
INSERT INTO `t_project_role_authority` VALUES (43, '项目风险', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 43.00);
INSERT INTO `t_project_role_authority` VALUES (44, '项目风险管理', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 43, 44.00);
INSERT INTO `t_project_role_authority` VALUES (45, '项目风险评估', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, 43, 45.00);
INSERT INTO `t_project_role_authority` VALUES (46, '项目发货', 1, 0, 0, 'system', '2019-10-12 17:00:17', NULL, NULL, NULL, NULL, 46.00);

-- ----------------------------
-- Table structure for t_project_role_authority_config
-- ----------------------------
DROP TABLE IF EXISTS `t_project_role_authority_config`;
CREATE TABLE `t_project_role_authority_config`  (
  `id` bigint(64) NOT NULL,
  `role_id` bigint(64) NULL DEFAULT NULL,
  `authority_detail_id` bigint(64) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_role_authority_config
-- ----------------------------
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433728, 346187504665018368, 1, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433729, 346187504665018368, 2, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433730, 346187504665018368, 3, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433731, 346187504665018368, 4, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433732, 346187504665018368, 5, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433733, 346187504665018368, 6, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433734, 346187504665018368, 15, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433735, 346187504665018368, 16, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433736, 346187504665018368, 17, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433737, 346187504665018368, 18, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433738, 346187504665018368, 19, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433739, 346187504665018368, 20, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433740, 346187504665018368, 21, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433741, 346187504665018368, 22, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433742, 346187504665018368, 23, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433743, 346187504665018368, 24, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433744, 346187504665018368, 25, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433745, 346187504665018368, 26, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433746, 346187504665018368, 34, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433747, 346187504665018368, 35, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433748, 346187504665018368, 36, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433749, 346187504665018368, 37, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433750, 346187504665018368, 38, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433751, 346187504665018368, 39, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433752, 346187504665018368, 40, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433753, 346187504665018368, 41, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433754, 346187504665018368, 54, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433755, 346187504665018368, 55, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433756, 346187504665018368, 56, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433757, 346187504665018368, 57, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433758, 346187504665018368, 58, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433759, 346187504665018368, 59, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433760, 346187504665018368, 60, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433761, 346187504665018368, 61, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433762, 346187504665018368, 62, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433763, 346187504665018368, 63, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433764, 346187504665018368, 64, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433765, 346187504665018368, 65, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433766, 346187504665018368, 66, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433767, 346187504665018368, 67, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433768, 346187504665018368, 68, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433769, 346187504665018368, 69, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433770, 346187504665018368, 70, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433771, 346187504665018368, 94, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433772, 346187504665018368, 95, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433773, 346187504665018368, 96, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433774, 346187504665018368, 97, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433775, 346187504665018368, 98, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433776, 346187504665018368, 99, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433777, 346187504665018368, 100, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433778, 346187504665018368, 101, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433779, 346187504665018368, 106, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433780, 346187504665018368, 107, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433781, 346187504665018368, 108, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433782, 346187504665018368, 109, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433783, 346187504665018368, 110, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433784, 346187504665018368, 111, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433785, 346187504665018368, 112, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433786, 346187504665018368, 113, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433787, 346187504665018368, 114, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433788, 346187504665018368, 115, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433789, 346187504665018368, 116, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433790, 346187504665018368, 117, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433791, 346187504665018368, 118, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433792, 346187504665018368, 119, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433793, 346187504665018368, 120, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433794, 346187504665018368, 121, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433795, 346187504665018368, 122, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433796, 346187504665018368, 123, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433797, 346187504665018368, 124, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433798, 346187504665018368, 125, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433799, 346187504665018368, 126, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433800, 346187504665018368, 127, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433801, 346187504665018368, 128, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433802, 346187504665018368, 129, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433803, 346187504665018368, 150, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433804, 346187504665018368, 151, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433805, 346187504665018368, 152, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433806, 346187504665018368, 153, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433807, 346187504665018368, 154, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433808, 346187504665018368, 155, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433809, 346187504665018368, 156, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433810, 346187504665018368, 157, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433811, 346187504665018368, 158, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433812, 346187504665018368, 159, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433813, 346187504665018368, 160, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433814, 346187504665018368, 161, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433815, 346187504665018368, 178, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433816, 346187504665018368, 179, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433817, 346187504665018368, 180, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433818, 346187504665018368, 181, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433819, 346187504665018368, 182, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433820, 346187504665018368, 183, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433821, 346187504665018368, 184, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433822, 346187504665018368, 185, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433823, 346187504665018368, 190, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433824, 346187504665018368, 191, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433825, 346187504665018368, 192, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (349104175503433826, 346187504665018368, 193, 662, '曹操', '2019-10-29 18:22:12');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455936, 1, 1, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455937, 1, 2, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455938, 1, 3, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455939, 1, 4, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455940, 1, 5, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455941, 1, 6, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455942, 1, 15, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455943, 1, 16, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455944, 1, 17, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455945, 1, 18, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455946, 1, 19, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455947, 1, 20, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455948, 1, 21, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455949, 1, 22, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455950, 1, 23, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455951, 1, 24, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455952, 1, 25, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455953, 1, 26, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455954, 1, 34, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455955, 1, 35, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455956, 1, 36, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455957, 1, 37, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455958, 1, 38, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455959, 1, 39, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455960, 1, 40, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455961, 1, 41, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455962, 1, 54, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455963, 1, 55, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455964, 1, 56, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455965, 1, 57, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455966, 1, 58, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455967, 1, 59, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455968, 1, 60, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455969, 1, 61, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455970, 1, 62, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455971, 1, 63, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455972, 1, 64, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455973, 1, 65, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455974, 1, 66, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455975, 1, 67, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455976, 1, 68, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455977, 1, 69, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455978, 1, 70, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455979, 1, 94, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455980, 1, 95, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455981, 1, 96, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455982, 1, 97, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455983, 1, 98, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455984, 1, 99, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455985, 1, 100, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455986, 1, 101, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455987, 1, 106, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455988, 1, 107, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455989, 1, 108, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455990, 1, 109, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455991, 1, 110, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455992, 1, 111, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455993, 1, 112, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455994, 1, 113, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455995, 1, 114, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455996, 1, 115, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455997, 1, 116, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455998, 1, 117, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276455999, 1, 118, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456000, 1, 119, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456001, 1, 120, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456002, 1, 121, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456003, 1, 122, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456004, 1, 123, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456005, 1, 124, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456006, 1, 125, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456007, 1, 126, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456008, 1, 127, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456009, 1, 128, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456010, 1, 129, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456011, 1, 150, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456012, 1, 151, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456013, 1, 152, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456014, 1, 153, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456015, 1, 154, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456016, 1, 155, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456017, 1, 156, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456018, 1, 157, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456019, 1, 158, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456020, 1, 159, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456021, 1, 160, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456022, 1, 161, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456023, 1, 178, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456024, 1, 179, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456025, 1, 180, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456026, 1, 181, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456027, 1, 182, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456028, 1, 183, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456029, 1, 184, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456030, 1, 185, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456031, 1, 190, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456032, 1, 191, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456033, 1, 192, 662, '曹操', '2019-11-11 17:52:57');
INSERT INTO `t_project_role_authority_config` VALUES (353807859276456034, 1, 193, 662, '曹操', '2019-11-11 17:52:57');

-- ----------------------------
-- Table structure for t_project_role_authority_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_project_role_authority_detail`;
CREATE TABLE `t_project_role_authority_detail`  (
  `id` bigint(64) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `signatures` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '启用状态',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新人时间',
  `authority_id` bigint(20) NULL DEFAULT NULL COMMENT '父节点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_role_authority_detail
-- ----------------------------
INSERT INTO `t_project_role_authority_detail` VALUES (1, '新建', 'project.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 1);
INSERT INTO `t_project_role_authority_detail` VALUES (2, '查看', 'project.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 1);
INSERT INTO `t_project_role_authority_detail` VALUES (3, '编辑', 'project.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 1);
INSERT INTO `t_project_role_authority_detail` VALUES (4, '删除', 'project.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 1);
INSERT INTO `t_project_role_authority_detail` VALUES (5, '提交审核', 'project.submit', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 1);
INSERT INTO `t_project_role_authority_detail` VALUES (6, '查看', 'project.base.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 2);
INSERT INTO `t_project_role_authority_detail` VALUES (7, '新建', 'project.step.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 3);
INSERT INTO `t_project_role_authority_detail` VALUES (8, '查看', 'project.step.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 3);
INSERT INTO `t_project_role_authority_detail` VALUES (9, '编辑', 'project.step.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 3);
INSERT INTO `t_project_role_authority_detail` VALUES (10, '删除', 'project.step.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 3);
INSERT INTO `t_project_role_authority_detail` VALUES (11, '新建', 'project.deliverable.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 4);
INSERT INTO `t_project_role_authority_detail` VALUES (12, '查看', 'project.deliverable.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 4);
INSERT INTO `t_project_role_authority_detail` VALUES (13, '编辑', 'project.deliverable.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 4);
INSERT INTO `t_project_role_authority_detail` VALUES (14, '删除', 'project.deliverable.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 4);
INSERT INTO `t_project_role_authority_detail` VALUES (15, '发布', 'projectTrend.post', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 5);
INSERT INTO `t_project_role_authority_detail` VALUES (16, '点赞', 'projectTrend.thumbUp', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 5);
INSERT INTO `t_project_role_authority_detail` VALUES (17, '评论', 'projectTrend.discuss', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 5);
INSERT INTO `t_project_role_authority_detail` VALUES (18, '删除', 'projectTrend.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 5);
INSERT INTO `t_project_role_authority_detail` VALUES (19, '项目团队信息', 'projectTeamPage.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 6);
INSERT INTO `t_project_role_authority_detail` VALUES (20, '新建团队', 'projectTeamPage.team.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 7);
INSERT INTO `t_project_role_authority_detail` VALUES (21, '查看', 'projectTeamPage.team.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 7);
INSERT INTO `t_project_role_authority_detail` VALUES (22, '编辑团队', 'projectTeamPage.team.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 7);
INSERT INTO `t_project_role_authority_detail` VALUES (23, '删除团队', 'projectTeamPage.team.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 7);
INSERT INTO `t_project_role_authority_detail` VALUES (24, '添加成员', 'projectTeamPage.team.addUser', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 7);
INSERT INTO `t_project_role_authority_detail` VALUES (25, '删除成员', 'projectTeamPage.team.deleteUser', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 7);
INSERT INTO `t_project_role_authority_detail` VALUES (26, '移出项目', 'projectTeamPage.team.removeUser', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 7);
INSERT INTO `t_project_role_authority_detail` VALUES (27, '新建角色', 'projectTeamPage.role.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 8);
INSERT INTO `t_project_role_authority_detail` VALUES (28, '查看', 'projectTeamPage.role.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 8);
INSERT INTO `t_project_role_authority_detail` VALUES (29, '编辑角色', 'projectTeamPage.role.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 8);
INSERT INTO `t_project_role_authority_detail` VALUES (30, '删除角色', 'projectTeamPage.role.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 8);
INSERT INTO `t_project_role_authority_detail` VALUES (31, '添加角色人员', 'projectTeamPage.role.addUser', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 8);
INSERT INTO `t_project_role_authority_detail` VALUES (32, '查看角色人员', 'projectTeamPage.role.showUser', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 8);
INSERT INTO `t_project_role_authority_detail` VALUES (33, '删除角色人员', 'projectRole.deleteUser', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 8);
INSERT INTO `t_project_role_authority_detail` VALUES (34, '新建', 'projectPlan.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 9);
INSERT INTO `t_project_role_authority_detail` VALUES (35, '新建子计划', 'projectPlan.createChild', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 9);
INSERT INTO `t_project_role_authority_detail` VALUES (36, '查看', 'projectPlan.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 9);
INSERT INTO `t_project_role_authority_detail` VALUES (37, '编辑', 'projectPlan.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 9);
INSERT INTO `t_project_role_authority_detail` VALUES (38, '删除', 'projectPlan.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 9);
INSERT INTO `t_project_role_authority_detail` VALUES (39, '分配负责人', 'projectPlan.lead', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 9);
INSERT INTO `t_project_role_authority_detail` VALUES (40, '提交评审', 'projectPlan.submit', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 9);
INSERT INTO `t_project_role_authority_detail` VALUES (41, '查看', 'projectPlan.base.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 10);
INSERT INTO `t_project_role_authority_detail` VALUES (42, '新建', 'projectPlan.beforeTask.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 11);
INSERT INTO `t_project_role_authority_detail` VALUES (43, '查看', 'projectPlan.beforeTask.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 11);
INSERT INTO `t_project_role_authority_detail` VALUES (44, '更新', 'projectPlan.beforeTask.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 11);
INSERT INTO `t_project_role_authority_detail` VALUES (45, '删除', 'projectPlan.beforeTask.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 11);
INSERT INTO `t_project_role_authority_detail` VALUES (46, '新建', 'projectPlan.deliverableRequest.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 12);
INSERT INTO `t_project_role_authority_detail` VALUES (47, '查看', 'projectPlan.deliverableRequest.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 12);
INSERT INTO `t_project_role_authority_detail` VALUES (48, '编辑', 'projectPlan.deliverableRequest.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 12);
INSERT INTO `t_project_role_authority_detail` VALUES (49, '删除', 'projectPlan.deliverableRequest.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 12);
INSERT INTO `t_project_role_authority_detail` VALUES (50, '新建', 'projectPlan.resource.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 13);
INSERT INTO `t_project_role_authority_detail` VALUES (51, '查看', 'projectPlan.resource.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 13);
INSERT INTO `t_project_role_authority_detail` VALUES (52, '编辑', 'projectPlan.resource.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 13);
INSERT INTO `t_project_role_authority_detail` VALUES (53, '删除', 'projectPlan.resource.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 13);
INSERT INTO `t_project_role_authority_detail` VALUES (54, '新建', 'projectTask.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (55, '查看', 'projectTask.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (56, '编辑', 'projectTask.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (57, '删除', 'projectTask.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (58, '中止', 'projectTask.stop', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (59, '取消', 'projectTask.cancel', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (60, '关闭', 'projectTask.close', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (61, '重启', 'projectTask.restart', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (62, '分配负责人', 'projectTask.lead', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (63, '新建子任务', 'projectTask.createChild', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (64, '任务汇报', 'projectTask.submit', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (65, '提出问题', 'projectTask.submitQuestion', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (66, '转为工作任务', 'projectTask.translateWorkTask', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (67, '新建工作任务', 'projectTask.createWorkTask', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (68, '任务评价', 'projectTask.discuss', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (69, '设为评价任务', 'projectTask.setDiscussTask', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 14);
INSERT INTO `t_project_role_authority_detail` VALUES (70, '查看', 'projectTask.base.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 15);
INSERT INTO `t_project_role_authority_detail` VALUES (71, '新建', 'projectTask.childTask.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 16);
INSERT INTO `t_project_role_authority_detail` VALUES (72, '查看', 'projectTask.childTask.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 16);
INSERT INTO `t_project_role_authority_detail` VALUES (73, '编辑', 'projectTask.childTask.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 16);
INSERT INTO `t_project_role_authority_detail` VALUES (74, '删除', 'projectTask.childTask.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 16);
INSERT INTO `t_project_role_authority_detail` VALUES (75, '新建', 'projectTask.report.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 17);
INSERT INTO `t_project_role_authority_detail` VALUES (76, '查看', 'projectTask.report.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 17);
INSERT INTO `t_project_role_authority_detail` VALUES (77, '更新', 'projectTask.report.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 17);
INSERT INTO `t_project_role_authority_detail` VALUES (78, '删除', 'projectTask.report.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 17);
INSERT INTO `t_project_role_authority_detail` VALUES (79, '新建', 'projectTask.deliverable.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 18);
INSERT INTO `t_project_role_authority_detail` VALUES (80, '查看', 'projectTask.deliverable.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 18);
INSERT INTO `t_project_role_authority_detail` VALUES (81, '更新', 'projectTask.deliverable.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 18);
INSERT INTO `t_project_role_authority_detail` VALUES (82, '删除', 'projectTask.deliverable.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 18);
INSERT INTO `t_project_role_authority_detail` VALUES (83, '新建', 'projectTask.resource.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 19);
INSERT INTO `t_project_role_authority_detail` VALUES (84, '查看', 'projectTask.resource.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 19);
INSERT INTO `t_project_role_authority_detail` VALUES (85, '更新', 'projectTask.resource.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 19);
INSERT INTO `t_project_role_authority_detail` VALUES (86, '删除', 'projectTask.resource.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 19);
INSERT INTO `t_project_role_authority_detail` VALUES (87, '新建', 'projectTask.discuss.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 20);
INSERT INTO `t_project_role_authority_detail` VALUES (88, '查看', 'projectTask.discuss.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 20);
INSERT INTO `t_project_role_authority_detail` VALUES (89, '更新', 'projectTask.discuss.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 20);
INSERT INTO `t_project_role_authority_detail` VALUES (90, '删除', 'projectTask.discuss.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 20);
INSERT INTO `t_project_role_authority_detail` VALUES (91, '新建', 'projectTask.workTimeReport.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 21);
INSERT INTO `t_project_role_authority_detail` VALUES (92, '编辑', 'projectTask.workTimeReport.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 21);
INSERT INTO `t_project_role_authority_detail` VALUES (93, '确认', 'projectTask.workTimeReport.submit', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 21);
INSERT INTO `t_project_role_authority_detail` VALUES (94, '新建', 'projectWorkTime.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 22);
INSERT INTO `t_project_role_authority_detail` VALUES (95, '查看', 'projectWorkTime.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 22);
INSERT INTO `t_project_role_authority_detail` VALUES (96, '更新', 'projectWorkTime.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 22);
INSERT INTO `t_project_role_authority_detail` VALUES (97, '删除', 'projectWorkTime.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 22);
INSERT INTO `t_project_role_authority_detail` VALUES (98, '新建', 'projectWorkTime.report.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 23);
INSERT INTO `t_project_role_authority_detail` VALUES (99, '查看', 'projectWorkTime.report.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 23);
INSERT INTO `t_project_role_authority_detail` VALUES (100, '更新', 'projectWorkTime.report.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 23);
INSERT INTO `t_project_role_authority_detail` VALUES (101, '删除', 'projectWorkTime.report.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 23);
INSERT INTO `t_project_role_authority_detail` VALUES (102, '新建', 'projectWorkTime.timeSubmit.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 24);
INSERT INTO `t_project_role_authority_detail` VALUES (103, '查看', 'projectWorkTime.timeSubmit.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 24);
INSERT INTO `t_project_role_authority_detail` VALUES (104, '更新', 'projectWorkTime.timeSubmit.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 24);
INSERT INTO `t_project_role_authority_detail` VALUES (105, '删除', 'projectWorkTime.timeSubmit.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 24);
INSERT INTO `t_project_role_authority_detail` VALUES (106, '新建', 'projectMilestones.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 25);
INSERT INTO `t_project_role_authority_detail` VALUES (107, '查看', 'projectMilestones.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 25);
INSERT INTO `t_project_role_authority_detail` VALUES (108, '更新', 'projectMilestones.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 25);
INSERT INTO `t_project_role_authority_detail` VALUES (109, '删除', 'projectMilestones.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 25);
INSERT INTO `t_project_role_authority_detail` VALUES (110, '新建', 'projectResource.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 26);
INSERT INTO `t_project_role_authority_detail` VALUES (111, '查看', 'projectResource.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 26);
INSERT INTO `t_project_role_authority_detail` VALUES (112, '更新', 'projectResource.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 26);
INSERT INTO `t_project_role_authority_detail` VALUES (113, '删除', 'projectResource.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 26);
INSERT INTO `t_project_role_authority_detail` VALUES (114, '新建', 'projectDeliverable.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 27);
INSERT INTO `t_project_role_authority_detail` VALUES (115, '查看', 'projectDeliverable.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 27);
INSERT INTO `t_project_role_authority_detail` VALUES (116, '更新', 'projectDeliverable.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 27);
INSERT INTO `t_project_role_authority_detail` VALUES (117, '删除', 'projectDeliverable.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 27);
INSERT INTO `t_project_role_authority_detail` VALUES (118, '新建', 'projectCommunication.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 28);
INSERT INTO `t_project_role_authority_detail` VALUES (119, '查看', 'projectCommunication.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 28);
INSERT INTO `t_project_role_authority_detail` VALUES (120, '更新', 'projectCommunication.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 28);
INSERT INTO `t_project_role_authority_detail` VALUES (121, '删除', 'projectCommunication.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 28);
INSERT INTO `t_project_role_authority_detail` VALUES (122, '新建', 'projectCost.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 29);
INSERT INTO `t_project_role_authority_detail` VALUES (123, '查看', 'projectCost.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 29);
INSERT INTO `t_project_role_authority_detail` VALUES (124, '更新', 'projectCost.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 29);
INSERT INTO `t_project_role_authority_detail` VALUES (125, '删除', 'projectCost.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 29);
INSERT INTO `t_project_role_authority_detail` VALUES (126, '新建', 'projectCost.budge.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 30);
INSERT INTO `t_project_role_authority_detail` VALUES (127, '查看', 'projectCost.budge.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 30);
INSERT INTO `t_project_role_authority_detail` VALUES (128, '更新', 'projectCost.budge.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 30);
INSERT INTO `t_project_role_authority_detail` VALUES (129, '删除', 'projectCost.budge.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 30);
INSERT INTO `t_project_role_authority_detail` VALUES (130, '新建', 'projectCost.costControl.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 31);
INSERT INTO `t_project_role_authority_detail` VALUES (131, '查看', 'projectCost.costControl.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 31);
INSERT INTO `t_project_role_authority_detail` VALUES (132, '更新', 'projectCost.costControl.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 31);
INSERT INTO `t_project_role_authority_detail` VALUES (133, '删除', 'projectCost.costControl.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 31);
INSERT INTO `t_project_role_authority_detail` VALUES (134, '新建', 'projectCost.costEstimate.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 32);
INSERT INTO `t_project_role_authority_detail` VALUES (135, '查看', 'projectCost.costEstimate.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 32);
INSERT INTO `t_project_role_authority_detail` VALUES (136, '更新', 'projectCost.costEstimate.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 32);
INSERT INTO `t_project_role_authority_detail` VALUES (137, '删除', 'projectCost.costEstimate.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 32);
INSERT INTO `t_project_role_authority_detail` VALUES (138, '新建', 'projectCost.cost.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 33);
INSERT INTO `t_project_role_authority_detail` VALUES (139, '查看', 'projectCost.cost.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 33);
INSERT INTO `t_project_role_authority_detail` VALUES (140, '更新', 'projectCost.cost.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 33);
INSERT INTO `t_project_role_authority_detail` VALUES (141, '删除', 'projectCost.cost.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 33);
INSERT INTO `t_project_role_authority_detail` VALUES (142, '新建', 'projectCost.moneyBack.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 34);
INSERT INTO `t_project_role_authority_detail` VALUES (143, '查看', 'projectCost.moneyBack.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 34);
INSERT INTO `t_project_role_authority_detail` VALUES (144, '更新', 'projectCost.moneyBack.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 34);
INSERT INTO `t_project_role_authority_detail` VALUES (145, '删除', 'projectCost.moneyBack.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 34);
INSERT INTO `t_project_role_authority_detail` VALUES (146, '新建', 'projectCost.invoice.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 35);
INSERT INTO `t_project_role_authority_detail` VALUES (147, '查看', 'projectCost.invoice.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 35);
INSERT INTO `t_project_role_authority_detail` VALUES (148, '更新', 'projectCost.invoice.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 35);
INSERT INTO `t_project_role_authority_detail` VALUES (149, '删除', 'projectCost.invoice.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 35);
INSERT INTO `t_project_role_authority_detail` VALUES (150, '新建', 'projectQuestion.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 36);
INSERT INTO `t_project_role_authority_detail` VALUES (151, '查看', 'projectQuestion.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 36);
INSERT INTO `t_project_role_authority_detail` VALUES (152, '更新', 'projectQuestion.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 36);
INSERT INTO `t_project_role_authority_detail` VALUES (153, '删除', 'projectQuestion.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 36);
INSERT INTO `t_project_role_authority_detail` VALUES (154, '新建', 'projectBoard.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 37);
INSERT INTO `t_project_role_authority_detail` VALUES (155, '查看', 'projectBoard.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 37);
INSERT INTO `t_project_role_authority_detail` VALUES (156, '更新', 'projectBoard.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 37);
INSERT INTO `t_project_role_authority_detail` VALUES (157, '删除', 'projectBoard.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 37);
INSERT INTO `t_project_role_authority_detail` VALUES (158, '新建', 'projectBoard.taskBoard.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 38);
INSERT INTO `t_project_role_authority_detail` VALUES (159, '查看', 'projectBoard.taskBoard.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 38);
INSERT INTO `t_project_role_authority_detail` VALUES (160, '更新', 'projectBoard.taskBoard.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 38);
INSERT INTO `t_project_role_authority_detail` VALUES (161, '删除', 'projectBoard.taskBoard.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 38);
INSERT INTO `t_project_role_authority_detail` VALUES (162, '新建', 'projectBoard.burnOutPicture.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 39);
INSERT INTO `t_project_role_authority_detail` VALUES (163, '查看', 'projectBoard.burnOutPicture.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 39);
INSERT INTO `t_project_role_authority_detail` VALUES (164, '更新', 'projectBoard.burnOutPicture.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 39);
INSERT INTO `t_project_role_authority_detail` VALUES (165, '删除', 'projectBoard.burnOutPicture.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 39);
INSERT INTO `t_project_role_authority_detail` VALUES (166, '新建', 'projectBoard.workTime.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 40);
INSERT INTO `t_project_role_authority_detail` VALUES (167, '查看', 'projectBoard.workTime.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 40);
INSERT INTO `t_project_role_authority_detail` VALUES (168, '更新', 'projectBoard.workTime.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 40);
INSERT INTO `t_project_role_authority_detail` VALUES (169, '删除', 'projectBoard.workTime.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 40);
INSERT INTO `t_project_role_authority_detail` VALUES (170, '新建', 'projectBoard.question.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 41);
INSERT INTO `t_project_role_authority_detail` VALUES (171, '查看', 'projectBoard.question.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 41);
INSERT INTO `t_project_role_authority_detail` VALUES (172, '更新', 'projectBoard.question.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 41);
INSERT INTO `t_project_role_authority_detail` VALUES (173, '删除', 'projectBoard.question.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 41);
INSERT INTO `t_project_role_authority_detail` VALUES (174, '新建', 'projectBoard.cost.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 42);
INSERT INTO `t_project_role_authority_detail` VALUES (175, '查看', 'projectBoard.cost.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 42);
INSERT INTO `t_project_role_authority_detail` VALUES (176, '更新', 'projectBoard.cost.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 42);
INSERT INTO `t_project_role_authority_detail` VALUES (177, '删除', 'projectBoard.cost.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 42);
INSERT INTO `t_project_role_authority_detail` VALUES (178, '新建', 'projectRisk.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 43);
INSERT INTO `t_project_role_authority_detail` VALUES (179, '查看', 'projectRisk.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 43);
INSERT INTO `t_project_role_authority_detail` VALUES (180, '更新', 'projectRisk.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 43);
INSERT INTO `t_project_role_authority_detail` VALUES (181, '删除', 'projectRisk.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 43);
INSERT INTO `t_project_role_authority_detail` VALUES (182, '新建', 'projectRisk.riskControl.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 44);
INSERT INTO `t_project_role_authority_detail` VALUES (183, '查看', 'projectRisk.riskControl.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 44);
INSERT INTO `t_project_role_authority_detail` VALUES (184, '更新', 'projectRisk.riskControl.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 44);
INSERT INTO `t_project_role_authority_detail` VALUES (185, '删除', 'projectRisk.riskControl.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 44);
INSERT INTO `t_project_role_authority_detail` VALUES (186, '新建', 'projectRisk.riskEstimate.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 45);
INSERT INTO `t_project_role_authority_detail` VALUES (187, '查看', 'projectRisk.riskEstimate.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 45);
INSERT INTO `t_project_role_authority_detail` VALUES (188, '更新', 'projectRisk.riskEstimate.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 45);
INSERT INTO `t_project_role_authority_detail` VALUES (189, '删除', 'projectRisk.riskEstimate.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 45);
INSERT INTO `t_project_role_authority_detail` VALUES (190, '新建', 'projectSendGoods.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 46);
INSERT INTO `t_project_role_authority_detail` VALUES (191, '查看', 'projectSendGoods.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 46);
INSERT INTO `t_project_role_authority_detail` VALUES (192, '更新', 'projectSendGoods.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 46);
INSERT INTO `t_project_role_authority_detail` VALUES (193, '删除', 'projectSendGoods.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 46);
INSERT INTO `t_project_role_authority_detail` VALUES (194, '新建', 'projectReturnMoney.create', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 47);
INSERT INTO `t_project_role_authority_detail` VALUES (195, '查看', 'projectReturnMoney.show', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 47);
INSERT INTO `t_project_role_authority_detail` VALUES (196, '更新', 'projectReturnMoney.update', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 47);
INSERT INTO `t_project_role_authority_detail` VALUES (197, '删除', 'projectReturnMoney.delete', 0, 0, 'system', '2019-10-14 09:39:08', NULL, NULL, NULL, 47);

-- ----------------------------
-- Table structure for t_project_role_authority_disable
-- ----------------------------
DROP TABLE IF EXISTS `t_project_role_authority_disable`;
CREATE TABLE `t_project_role_authority_disable`  (
  `id` bigint(64) NOT NULL,
  `reg_id` bigint(64) NULL DEFAULT NULL,
  `authority_id` bigint(64) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_project_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_project_role_user`;
CREATE TABLE `t_project_role_user`  (
  `id` bigint(64) NOT NULL COMMENT '主键id',
  `role_id` bigint(64) NULL DEFAULT NULL COMMENT '角色id',
  `user_id` bigint(64) NULL DEFAULT NULL COMMENT '用户id',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人姓名',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_role_user
-- ----------------------------
INSERT INTO `t_project_role_user` VALUES (346194895904055296, NULL, 664, 662, '曹操', '2019-10-21 17:41:45', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346194941324173312, NULL, 664, 662, '曹操', '2019-10-21 17:41:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346195026481127424, 1, 664, 662, '曹操', '2019-10-21 17:42:17', 662, '曹操', '2019-10-21 18:47:25', 1);
INSERT INTO `t_project_role_user` VALUES (346195203719831552, 1, 662, 662, '曹操', '2019-10-21 17:42:59', 662, '曹操', '2019-10-21 17:45:01', 1);
INSERT INTO `t_project_role_user` VALUES (346195203719831553, 1, 670, 662, '曹操', '2019-10-21 17:42:59', 662, '曹操', '2019-10-21 17:45:01', 1);
INSERT INTO `t_project_role_user` VALUES (346208440420188160, 1, 662, 662, '曹操', '2019-10-21 18:35:35', 662, '曹操', '2019-10-21 18:47:23', 1);
INSERT INTO `t_project_role_user` VALUES (346211274091970560, NULL, 670, 662, '曹操', '2019-10-21 18:46:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346211274091970561, NULL, 664, 662, '曹操', '2019-10-21 18:46:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346211897562677248, 1, 664, 662, '曹操', '2019-10-21 18:49:19', 662, '曹操', '2019-10-22 16:32:37', 1);
INSERT INTO `t_project_role_user` VALUES (346211897562677249, 1, 662, 662, '曹操', '2019-10-21 18:49:19', 662, '曹操', '2019-10-22 16:32:39', 1);
INSERT INTO `t_project_role_user` VALUES (346213807434809344, 1, 346183708756983808, 662, '曹操', '2019-10-21 18:56:54', 662, '曹操', '2019-10-21 18:58:28', 1);
INSERT INTO `t_project_role_user` VALUES (346213841052155904, 346187504665018368, 346190233638584320, 662, '曹操', '2019-10-21 18:57:02', 662, '曹操', '2019-10-21 18:58:25', 1);
INSERT INTO `t_project_role_user` VALUES (346214435036905472, NULL, 670, 662, '曹操', '2019-10-21 18:59:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346214435036905473, NULL, 664, 662, '曹操', '2019-10-21 18:59:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346214435036905474, NULL, 662, 662, '曹操', '2019-10-21 18:59:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346214550749364224, 1, 346183708756983808, 662, '曹操', '2019-10-21 18:59:51', 662, '曹操', '2019-10-21 19:00:15', 1);
INSERT INTO `t_project_role_user` VALUES (346214601701769216, 346187504665018368, 346190233638584320, 662, '曹操', '2019-10-21 19:00:04', 662, '曹操', '2019-10-21 19:01:02', 1);
INSERT INTO `t_project_role_user` VALUES (346214808623562752, NULL, 670, 662, '曹操', '2019-10-21 19:00:53', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346214808623562753, NULL, 664, 662, '曹操', '2019-10-21 19:00:53', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346214808623562754, NULL, 662, 662, '曹操', '2019-10-21 19:00:53', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346214904077533184, NULL, 670, 662, '曹操', '2019-10-21 19:01:16', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346214904077533185, NULL, 664, 662, '曹操', '2019-10-21 19:01:16', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346214904077533186, NULL, 662, 662, '曹操', '2019-10-21 19:01:16', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346215317405220864, NULL, 670, 662, '曹操', '2019-10-21 19:02:54', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346215386980335616, NULL, 664, 662, '曹操', '2019-10-21 19:03:11', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346220650167934976, 1, 670, 662, '曹操', '2019-10-21 19:24:06', 662, '曹操', '2019-10-22 16:32:35', 1);
INSERT INTO `t_project_role_user` VALUES (346426895845060608, NULL, 664, 662, '曹操', '2019-10-22 09:03:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346426922919292928, NULL, 664, 662, '曹操', '2019-10-22 09:03:45', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346427206244528129, NULL, 664, 662, '曹操', '2019-10-22 09:04:53', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346427257607974914, NULL, 664, 662, '曹操', '2019-10-22 09:05:05', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346427257607974915, NULL, 662, 662, '曹操', '2019-10-22 09:05:05', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346429445650542593, NULL, 670, 662, '曹操', '2019-10-22 09:13:46', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346436617486757888, NULL, 664, 662, '曹操', '2019-10-22 09:42:16', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346437141971890176, 346187504665018368, 346183708756983808, 662, '曹操', '2019-10-22 09:44:21', 662, '曹操', '2019-10-22 09:51:20', 1);
INSERT INTO `t_project_role_user` VALUES (346438027037143040, NULL, 664, 662, '曹操', '2019-10-22 09:47:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346438027037143041, NULL, 662, 662, '曹操', '2019-10-22 09:47:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346439624123248640, NULL, 664, 662, '曹操', '2019-10-22 09:54:13', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346439624123248641, NULL, 662, 662, '曹操', '2019-10-22 09:54:13', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346439668821946368, NULL, 664, 662, '曹操', '2019-10-22 09:54:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346440197740457984, NULL, 670, 662, '曹操', '2019-10-22 09:56:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346440548799508481, NULL, 662, 662, '曹操', '2019-10-22 09:57:54', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346440564788195328, NULL, 664, 662, '曹操', '2019-10-22 09:57:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346440987431432192, NULL, 670, 662, '曹操', '2019-10-22 09:59:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346441547056443394, NULL, 664, 662, '曹操', '2019-10-22 10:01:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346441547056443395, NULL, 662, 662, '曹操', '2019-10-22 10:01:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346441809598902272, NULL, 664, 662, '曹操', '2019-10-22 10:02:54', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346442958397796354, NULL, 670, 662, '曹操', '2019-10-22 10:07:28', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346442958397796355, NULL, 664, 662, '曹操', '2019-10-22 10:07:28', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346444653869690880, NULL, 670, 662, '曹操', '2019-10-22 10:14:12', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346444653869690881, NULL, 664, 662, '曹操', '2019-10-22 10:14:12', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346474183200108544, NULL, 664, 662, '曹操', '2019-10-22 12:11:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346474183200108545, NULL, 662, 662, '曹操', '2019-10-22 12:11:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346478785412755457, NULL, 664, 662, '曹操', '2019-10-22 12:29:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346497274827534336, NULL, 670, 662, '曹操', '2019-10-22 13:43:18', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346497274827534337, NULL, 664, 662, '曹操', '2019-10-22 13:43:18', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346531563304677376, NULL, 664, 662, '曹操', '2019-10-22 15:59:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346531563304677377, NULL, 662, 662, '曹操', '2019-10-22 15:59:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346533805839642624, NULL, 664, 662, '曹操', '2019-10-22 16:08:28', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346533805839642625, NULL, 662, 662, '曹操', '2019-10-22 16:08:28', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346539136527396864, NULL, 670, 662, '曹操', '2019-10-22 16:29:39', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346541664237285376, NULL, 670, 662, '曹操', '2019-10-22 16:39:41', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346541664237285377, NULL, 664, 662, '曹操', '2019-10-22 16:39:41', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346542923719667712, NULL, 670, 662, '曹操', '2019-10-22 16:44:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346544241125388288, NULL, 670, 662, '曹操', '2019-10-22 16:49:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346544241125388289, NULL, 664, 662, '曹操', '2019-10-22 16:49:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346544438203150336, NULL, 670, 662, '曹操', '2019-10-22 16:50:43', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346544438203150337, NULL, 664, 662, '曹操', '2019-10-22 16:50:43', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346544641673031680, NULL, 670, 662, '曹操', '2019-10-22 16:51:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346544641673031681, NULL, 664, 662, '曹操', '2019-10-22 16:51:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346544641673031682, NULL, 662, 662, '曹操', '2019-10-22 16:51:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346545619814084608, NULL, 670, 662, '曹操', '2019-10-22 16:55:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346545619818278912, NULL, 664, 662, '曹操', '2019-10-22 16:55:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346550315157057536, NULL, 670, 662, '曹操', '2019-10-22 17:14:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346550315157057537, NULL, 664, 662, '曹操', '2019-10-22 17:14:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346550315157057538, NULL, 662, 662, '曹操', '2019-10-22 17:14:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346551218501087232, NULL, 662, 662, '曹操', '2019-10-22 17:17:39', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346551279905697792, NULL, 670, 662, '曹操', '2019-10-22 17:17:54', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346551279905697793, NULL, 664, 662, '曹操', '2019-10-22 17:17:54', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346566175505391616, NULL, 664, 662, '曹操', '2019-10-22 18:17:05', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346570988905439232, 1, 664, 662, '曹操', '2019-10-22 18:36:13', 662, '曹操', '2019-10-23 11:57:46', 1);
INSERT INTO `t_project_role_user` VALUES (346570988905439233, 1, 662, 662, '曹操', '2019-10-22 18:36:13', 662, '曹操', '2019-10-23 11:10:13', 1);
INSERT INTO `t_project_role_user` VALUES (346793243216322560, NULL, 670, 662, '曹操', '2019-10-23 09:19:23', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346793243216322561, NULL, 664, 662, '曹操', '2019-10-23 09:19:23', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346793243216322562, NULL, 662, 662, '曹操', '2019-10-23 09:19:23', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346799503563169792, NULL, 664, 662, '曹操', '2019-10-23 09:44:15', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346799503563169793, NULL, 662, 662, '曹操', '2019-10-23 09:44:15', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346799535695732736, NULL, 670, 662, '曹操', '2019-10-23 09:44:23', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346801409861754880, NULL, 662, 662, '曹操', '2019-10-23 09:51:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346801466560356352, NULL, 670, 662, '曹操', '2019-10-23 09:52:03', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346801466560356353, NULL, 664, 662, '曹操', '2019-10-23 09:52:03', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346801466560356354, NULL, 662, 662, '曹操', '2019-10-23 09:52:03', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346805214808514560, NULL, 670, 662, '曹操', '2019-10-23 10:06:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346805214808514561, NULL, 664, 662, '曹操', '2019-10-23 10:06:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346805214808514562, NULL, 662, 662, '曹操', '2019-10-23 10:06:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346806437930475520, NULL, 670, 662, '曹操', '2019-10-23 10:11:48', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346806437930475521, NULL, 664, 662, '曹操', '2019-10-23 10:11:48', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346806437930475522, NULL, 662, 662, '曹操', '2019-10-23 10:11:48', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346810239240773632, 1, 346183708756983809, 662, '曹操', '2019-10-23 10:26:55', 662, '曹操', '2019-10-23 12:15:10', 1);
INSERT INTO `t_project_role_user` VALUES (346813162079264768, NULL, 346190233638584320, 662, '曹操', '2019-10-23 10:38:32', 662, '曹操', '2019-10-23 12:11:52', 1);
INSERT INTO `t_project_role_user` VALUES (346813288583667712, 346187504665018368, 346190233638584320, 662, '曹操', '2019-10-23 10:39:02', 662, '曹操', '2019-10-23 12:11:52', 1);
INSERT INTO `t_project_role_user` VALUES (346816177536376832, 1, 346805253693906945, 662, '曹操', '2019-10-23 10:50:30', 662, '曹操', '2019-10-23 12:05:55', 1);
INSERT INTO `t_project_role_user` VALUES (346830552695447552, 1, 670, 662, '曹操', '2019-10-23 11:47:38', 662, '曹操', '2019-10-23 11:57:41', 1);
INSERT INTO `t_project_role_user` VALUES (346830552695447553, 1, 662, 662, '曹操', '2019-10-23 11:47:38', 662, '曹操', '2019-10-23 11:57:38', 1);
INSERT INTO `t_project_role_user` VALUES (346834990009032704, NULL, 664, 662, '曹操', '2019-10-23 12:05:16', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346835308126019584, NULL, 664, 662, '曹操', '2019-10-23 12:06:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346836485551038464, NULL, 670, 662, '曹操', '2019-10-23 12:11:12', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346836736877928448, NULL, 664, 662, '曹操', '2019-10-23 12:12:12', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346836907984560128, 1, 670, 662, '曹操', '2019-10-23 12:12:53', 662, '曹操', '2019-10-29 18:13:47', 1);
INSERT INTO `t_project_role_user` VALUES (346836949025824768, 1, 664, 662, '曹操', '2019-10-23 12:13:03', 662, '曹操', '2019-10-29 18:13:45', 1);
INSERT INTO `t_project_role_user` VALUES (346837243302387712, NULL, 662, 662, '曹操', '2019-10-23 12:14:13', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346837699147735040, NULL, 664, 662, '曹操', '2019-10-23 12:16:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346837924461551616, NULL, 662, 662, '曹操', '2019-10-23 12:16:55', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346838201163980800, NULL, 670, 662, '曹操', '2019-10-23 12:18:01', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346839784392105984, 1, 346805298879143936, 662, '曹操', '2019-10-23 12:24:19', 662, '曹操', '2019-10-23 14:01:47', 1);
INSERT INTO `t_project_role_user` VALUES (346864410438541312, NULL, 664, 662, '曹操', '2019-10-23 14:02:10', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346864629901303808, NULL, 670, 662, '曹操', '2019-10-23 14:03:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (346865226339721216, 346187504665018368, 346190233638584320, 662, '曹操', '2019-10-23 14:05:25', 662, '曹操', '2019-10-26 17:33:42', 1);
INSERT INTO `t_project_role_user` VALUES (348004762256023552, NULL, 670, 662, '曹操', '2019-10-26 17:33:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (348004762256023553, NULL, 664, 662, '曹操', '2019-10-26 17:33:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (348004762256023554, NULL, 662, 662, '曹操', '2019-10-26 17:33:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349075554574147584, NULL, 664, 662, '曹操', '2019-10-29 16:28:28', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349076000625795072, NULL, 664, 662, '曹操', '2019-10-29 16:30:14', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349076422245621760, NULL, 670, 662, '曹操', '2019-10-29 16:31:55', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349076459663007744, NULL, 670, 662, '曹操', '2019-10-29 16:32:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349077010085715968, NULL, 662, 662, '曹操', '2019-10-29 16:34:15', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349077343209922560, NULL, 664, 662, '曹操', '2019-10-29 16:35:34', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349078633201672192, NULL, 664, 662, '曹操', '2019-10-29 16:40:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349079424251600896, NULL, 670, 662, '曹操', '2019-10-29 16:43:51', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349090914455134208, NULL, 662, 662, '曹操', '2019-10-29 17:29:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349090914455134209, NULL, 664, 662, '曹操', '2019-10-29 17:29:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349091828658216960, NULL, 670, 662, '曹操', '2019-10-29 17:33:08', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349092508982714368, NULL, 670, 662, '曹操', '2019-10-29 17:35:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349092508982714369, NULL, 664, 662, '曹操', '2019-10-29 17:35:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349092508982714370, NULL, 662, 662, '曹操', '2019-10-29 17:35:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349096403546202112, NULL, 664, 662, '曹操', '2019-10-29 17:51:19', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349096403546202113, NULL, 670, 662, '曹操', '2019-10-29 17:51:19', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349096906241925120, NULL, 670, 662, '曹操', '2019-10-29 17:53:19', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349096906241925121, NULL, 664, 662, '曹操', '2019-10-29 17:53:19', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349096906241925122, NULL, 662, 662, '曹操', '2019-10-29 17:53:19', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349097112215805952, NULL, 662, 662, '曹操', '2019-10-29 17:54:08', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349097186224300032, NULL, 662, 662, '曹操', '2019-10-29 17:54:25', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349097585220050944, NULL, 662, 662, '曹操', '2019-10-29 17:56:00', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349099347809198080, NULL, 662, 662, '曹操', '2019-10-29 18:03:01', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349102794470121472, NULL, 662, 662, '曹操', '2019-10-29 18:16:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349102850971590656, NULL, 662, 662, '曹操', '2019-10-29 18:16:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349102850971590657, NULL, 664, 662, '曹操', '2019-10-29 18:16:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349102850971590658, NULL, 670, 662, '曹操', '2019-10-29 18:16:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349102956701605888, NULL, 662, 662, '曹操', '2019-10-29 18:17:21', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349102956701605889, NULL, 664, 662, '曹操', '2019-10-29 18:17:21', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349107088321732608, NULL, 670, 662, '曹操', '2019-10-29 18:33:46', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349109672344346624, NULL, 670, 662, '曹操', '2019-10-29 18:44:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349110077447004160, NULL, 664, 662, '曹操', '2019-10-29 18:45:39', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349110594264948736, NULL, 664, 662, '曹操', '2019-10-29 18:47:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349110841322037248, NULL, 664, 662, '曹操', '2019-10-29 18:48:41', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349110871487471616, NULL, 670, 662, '曹操', '2019-10-29 18:48:48', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349111359901589504, NULL, 662, 662, '曹操', '2019-10-29 18:50:45', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349111391744745472, NULL, 664, 662, '曹操', '2019-10-29 18:50:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349111418949001216, NULL, 662, 662, '曹操', '2019-10-29 18:50:59', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349114462067548160, NULL, 670, 662, '曹操', '2019-10-29 19:03:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349114462067548161, NULL, 664, 662, '曹操', '2019-10-29 19:03:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349114462067548162, NULL, 662, 662, '曹操', '2019-10-29 19:03:04', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349114914498732032, NULL, 670, 662, '曹操', '2019-10-29 19:04:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349114914498732033, NULL, 664, 662, '曹操', '2019-10-29 19:04:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349114914498732034, NULL, 662, 662, '曹操', '2019-10-29 19:04:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349115246377230336, NULL, 670, 662, '曹操', '2019-10-29 19:06:11', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349115246377230337, NULL, 664, 662, '曹操', '2019-10-29 19:06:11', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349115246377230338, NULL, 662, 662, '曹操', '2019-10-29 19:06:11', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349115740583682048, NULL, 664, 662, '曹操', '2019-10-29 19:08:09', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349115740583682049, NULL, 662, 662, '曹操', '2019-10-29 19:08:09', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349116420979482624, NULL, 670, 662, '曹操', '2019-10-29 19:10:51', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349116420979482625, NULL, 664, 662, '曹操', '2019-10-29 19:10:51', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349116420979482626, NULL, 662, 662, '曹操', '2019-10-29 19:10:51', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349116891819466752, NULL, 664, 662, '曹操', '2019-10-29 19:12:44', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349116891819466753, NULL, 662, 662, '曹操', '2019-10-29 19:12:44', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349116974497587200, NULL, 670, 662, '曹操', '2019-10-29 19:13:03', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349116974497587201, NULL, 664, 662, '曹操', '2019-10-29 19:13:03', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349116974497587202, NULL, 662, 662, '曹操', '2019-10-29 19:13:03', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (349338906646945792, 1, 670, 662, '曹操', '2019-10-30 09:54:56', 662, '曹操', '2019-11-05 10:21:26', 1);
INSERT INTO `t_project_role_user` VALUES (349344244523737088, 1, 664, 662, '曹操', '2019-10-30 10:16:09', 662, '曹操', '2019-11-05 10:21:22', 1);
INSERT INTO `t_project_role_user` VALUES (349344244523737089, 1, 662, 662, '曹操', '2019-10-30 10:16:09', 662, '曹操', '2019-11-05 10:21:24', 1);
INSERT INTO `t_project_role_user` VALUES (354777858870747136, 1, 388, 380, '何革学', '2019-11-14 10:07:23', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (354777858870747137, 1, 422, 380, '何革学', '2019-11-14 10:07:23', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (354777896686592000, 346187504665018368, 389, 380, '何革学', '2019-11-14 10:07:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (354777896686592001, 346187504665018368, 390, 380, '何革学', '2019-11-14 10:07:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (354881664044376064, 346187504665018368, 457, 380, '何革学', '2019-11-14 16:59:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_role_user` VALUES (355205019691786240, NULL, 354515456077996039, 380, '何革学', '2019-11-15 14:24:46', 380, '何革学', '2019-11-15 14:24:51', 1);

-- ----------------------------
-- Table structure for t_project_step
-- ----------------------------
DROP TABLE IF EXISTS `t_project_step`;
CREATE TABLE `t_project_step`  (
  `id` bigint(64) NOT NULL COMMENT '主键',
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `index` int(6) NULL DEFAULT NULL COMMENT '阶段排序',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `duration` int(8) NULL DEFAULT NULL COMMENT '工期',
  `leader` bigint(64) NULL DEFAULT NULL COMMENT '责任人',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '阶段内容',
  `deliver_claim` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交付物',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_step
-- ----------------------------
INSERT INTO `t_project_step` VALUES (1, 1, '立项阶段', 1, '2019-10-25 14:54:22', '2019-10-25 14:54:24', 1, 535, '编写立项申请书', '调研立项', 0, 0, 'system', '2019-10-25 14:54:59', NULL, NULL, NULL);
INSERT INTO `t_project_step` VALUES (2, 1, '创建项目团队', 2, '2019-10-26 14:59:11', '2019-10-28 14:59:15', 3, 535, '选择合适组员', '创建项目团队', 0, 0, 'system', '2019-10-25 14:59:52', NULL, NULL, NULL);
INSERT INTO `t_project_step` VALUES (347611650624098304, 1, '计划阶段2', 4, '2019-10-24 14:54:22', '2019-10-30 14:54:24', 7, 535, '创建项目计划2', '计划创建成功2', 1, 662, '曹操', '2019-10-25 15:31:26', 662, '曹操', '2019-10-25 15:36:51');
INSERT INTO `t_project_step` VALUES (348632324216856576, 2, '第一', 1, '2019-10-14 02:00:00', '2019-10-22 00:00:00', 20, 380, '多对多', '多对多', 0, 662, '曹操', '2019-10-28 11:07:14', NULL, NULL, NULL);
INSERT INTO `t_project_step` VALUES (348632485995356160, 2, '第二', 3, '2019-10-20 00:00:00', '2019-10-31 00:00:00', 50, NULL, 'CCC', '出差', 0, 662, '曹操', '2019-10-28 11:07:52', NULL, NULL, NULL);
INSERT INTO `t_project_step` VALUES (348633470419476480, 1, '第三阶段', 3, '2019-10-16 00:02:00', '2019-10-31 02:00:00', 20, 390, '加快顿了顿', '地地道道', 0, 662, '曹操', '2019-10-28 11:11:47', NULL, NULL, NULL);
INSERT INTO `t_project_step` VALUES (348649474889490432, 1, 'd', 4, '2019-10-07 00:00:00', '2019-10-07 00:00:00', 20, 513, '', '', 1, 662, '曹操', '2019-10-28 12:15:23', 662, '曹操', '2019-10-28 14:04:10');
INSERT INTO `t_project_step` VALUES (351952694038634496, 351951776502296576, '凤飞飞', 1, '2019-11-06 15:00:52', '2019-11-27 00:00:00', 30, 663, '对等', '多对多', 0, 662, '曹操', '2019-11-06 15:01:11', NULL, NULL, NULL);
INSERT INTO `t_project_step` VALUES (352274797464002560, 351951769099350016, '多对多', 2, '2019-11-06 00:00:00', '2019-11-29 00:00:00', 10, 381, '110', '110', 0, 662, '曹操', '2019-11-07 12:21:07', NULL, NULL, NULL);
INSERT INTO `t_project_step` VALUES (352616601350709248, 351951774266732544, '1', 1, '2019-11-08 10:59:04', '2019-11-30 00:00:00', 10, 379, '11', '', 0, 662, '曹操', '2019-11-08 10:59:19', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_project_step_verify
-- ----------------------------
DROP TABLE IF EXISTS `t_project_step_verify`;
CREATE TABLE `t_project_step_verify`  (
  `id` bigint(64) NOT NULL COMMENT '主键',
  `step_id` bigint(64) NULL DEFAULT NULL COMMENT '项目',
  `status` int(2) NULL DEFAULT NULL COMMENT '名称',
  `verify_time` datetime(0) NULL DEFAULT NULL COMMENT '阶段排序',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `verify_user` bigint(64) NULL DEFAULT NULL COMMENT '确认人',
  `verify_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '确认人名称',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '确备注',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '实际开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '实际结束时间',
  `work_time` decimal(8, 2) NULL DEFAULT NULL COMMENT '项目工时',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_step_verify
-- ----------------------------
INSERT INTO `t_project_step_verify` VALUES (1, 1, 3, '2019-11-06 17:00:00', 0, 'system', '2019-11-06 17:01:30', 662, '曹操', '2019-11-06 17:07:09', 662, '曹操', '1111', NULL, NULL, NULL);
INSERT INTO `t_project_step_verify` VALUES (352274797484974080, 352274797464002560, 1, NULL, 662, '曹操', '2019-11-07 12:21:07', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_step_verify` VALUES (352616601367486464, 352616601350709248, 3, NULL, 662, '曹操', '2019-11-08 10:59:19', 662, '曹操', '2019-11-08 16:45:26', 662, '曹操', '', '2019-11-08 16:44:51', '2019-11-30 00:00:00', 21.30);

-- ----------------------------
-- Table structure for t_project_task_appendix
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_appendix`;
CREATE TABLE `t_project_task_appendix`  (
  `task_appendix_id` bigint(64) NOT NULL COMMENT '计划附件id',
  `task_appendix_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '附件主题名称',
  `task_appendix_type` bigint(64) NULL DEFAULT NULL COMMENT '计划附件类型，取值为枚举',
  `task_appendix_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划附件描述',
  `appendix_id` bigint(64) NULL DEFAULT NULL COMMENT '附件id，外键到附件表',
  `task_id` bigint(64) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '修改人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`task_appendix_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_appendix
-- ----------------------------
INSERT INTO `t_project_task_appendix` VALUES (1, NULL, 1, 'ceshi', NULL, 1, 1, '修改人测试账号', '2019-11-06 10:41:23', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (351877431657009152, NULL, 1, 'taskAppendixDesc1111', NULL, 1, 1573457311968, NULL, NULL, 1573459254862, '修改人测试账号', '2019-11-11 16:00:55', 0);
INSERT INTO `t_project_task_appendix` VALUES (351878048001593344, NULL, 1, NULL, NULL, 1, 1, '创建人测试', '2019-11-06 10:04:34', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (353771514222649344, NULL, 1, '任务附件描述aa', NULL, 1, 1573457311968, '创建人测试账号', '2019-11-11 15:28:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (353771681868980224, NULL, 2, '任务附件描述bb', NULL, 1, 1573457351942, '创建人测试账号', '2019-11-11 15:29:12', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (353771730917171200, NULL, 2, '任务附件描述bb', NULL, 1, 1573457363636, '创建人测试账号', '2019-11-11 15:29:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (353771732628447232, NULL, 2, '任务附件描述bb', NULL, 1, 1573457364044, '创建人测试账号', '2019-11-11 15:29:24', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (353780598598574080, NULL, NULL, 'taskAppendixDesc1111', NULL, NULL, 1573459477838, '创建人测试账号', '2019-11-11 16:04:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (356300689122828288, 'taskAppendixName001', NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 14:58:34', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (356301175699841024, 'taskAppendixName001', NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:00:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (356301349142700032, 'taskAppendixName001', NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:01:12', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (356301608648482816, 'taskAppendixName001', NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:02:13', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (356304059455807488, 'taskAppendixName001', NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:11:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (356304459831484416, 'taskAppendixName001', NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:13:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (356304893455409152, 'taskAppendixName001', NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:15:17', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_appendix` VALUES (356305073021952000, 'taskAppendixName001', NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 15:15:59', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_task_association
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_association`;
CREATE TABLE `t_project_task_association`  (
  `task_association_id` bigint(64) NOT NULL COMMENT '关联关系id',
  `task_association_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联计划名称',
  `task_step` bigint(32) NULL DEFAULT NULL COMMENT '计划阶段',
  `task_pority` bigint(64) NULL DEFAULT NULL COMMENT '计划优先级',
  `task_execution_status` bigint(64) NULL DEFAULT NULL COMMENT '计划执行状态',
  `task_relationship` bigint(64) NULL DEFAULT NULL,
  `task_leader_id` bigint(64) NULL DEFAULT NULL COMMENT '负责人id',
  `task_team_id` bigint(64) NULL DEFAULT NULL COMMENT '项目团队id',
  `task_startTime` datetime(0) NULL DEFAULT NULL COMMENT '项目开始时间',
  `task_endTime` datetime(0) NULL DEFAULT NULL COMMENT '计划结束时间',
  `task_working_hour` bigint(64) NULL DEFAULT NULL COMMENT '计划工时',
  `task_id` bigint(64) NULL DEFAULT NULL COMMENT '计划id外键',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`task_association_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_association
-- ----------------------------
INSERT INTO `t_project_task_association` VALUES (350097139615182848, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 'Scot', '2019-11-06 11:20:39', 1, '更新人测试账号', NULL, 0);
INSERT INTO `t_project_task_association` VALUES (350097197639184384, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 'Scot', NULL, 1573465113693, '修改人测试账号', '2019-11-11 17:38:34', 0);
INSERT INTO `t_project_task_association` VALUES (351893246586425344, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, '创建人id', '2019-11-06 11:04:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_association` VALUES (353802822982344704, NULL, 2, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1573464776535, '创建人测试账号', '2019-11-11 17:32:57', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_task_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_comment`;
CREATE TABLE `t_project_task_comment`  (
  `task_comment_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '评价id',
  `business_id` bigint(64) NULL DEFAULT NULL COMMENT '业务id（任务或者交付物评价）',
  `task_deliver_product_id` bigint(64) NULL DEFAULT NULL COMMENT '交付物外键Id',
  `valid_duration` bigint(64) NULL DEFAULT NULL COMMENT '有效工时',
  `task_score` double(64, 2) NULL DEFAULT NULL COMMENT '评分',
  `task_deliver_product_score` double(64, 2) NULL DEFAULT NULL,
  `total_score` double(64, 2) NULL DEFAULT NULL,
  `task_comment_time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `result_desc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '时间评估结果说明',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`task_comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_comment
-- ----------------------------
INSERT INTO `t_project_task_comment` VALUES (356710964426735616, 354855785507102720, 356683693276037120, 20, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-19 18:08:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_comment` VALUES (356714247912456192, 354855785507102720, 356683693276037120, 20, 100.00, NULL, NULL, NULL, 'resultDesc001', 380, '何革学', '2019-11-19 18:21:54', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_comment` VALUES (356721019066810368, 354855785507102720, 356683693276037120, 20, 100.00, 100.00, NULL, NULL, 'resultDesc001', 380, '何革学', '2019-11-19 18:48:49', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_comment` VALUES (356721464740970496, 354855785507102720, 356683693276037120, 20, 100.00, 100.00, 100.00, '2019-11-19 18:50:35', 'resultDesc001', 380, '何革学', '2019-11-19 18:50:35', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_task_create
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_create`;
CREATE TABLE `t_project_task_create`  (
  `task_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '项目任务id',
  `task_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目任务名称',
  `task_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务编号',
  `parent_task_id` bigint(64) NULL DEFAULT NULL COMMENT '父计划id',
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '所属项目',
  `project_step` bigint(64) NULL DEFAULT NULL,
  `priority` bigint(64) NULL DEFAULT NULL COMMENT '优先级',
  `task_start_time` datetime(0) NULL DEFAULT NULL COMMENT '任务开始时间',
  `task_end_time` datetime(0) NULL DEFAULT NULL COMMENT '任务完成时间',
  `task_deadline` datetime(0) NULL DEFAULT NULL COMMENT '截止完成时间',
  `task_duration` bigint(64) NULL DEFAULT NULL COMMENT '任务工时',
  `task_leader_id` bigint(64) NULL DEFAULT NULL COMMENT '项目负责人id',
  `task_leader_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目负责人姓名',
  `task_team_id` bigint(64) NULL DEFAULT NULL COMMENT '任务团队id',
  `task_team_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务团队名称',
  `task_dispatch_method` bigint(64) NULL DEFAULT NULL COMMENT '任务分配方式',
  `task_dispatcher_id` bigint(64) NULL DEFAULT NULL COMMENT '分配人Id（分配给别人的）',
  `task_dispatch_user_id` bigint(64) NULL DEFAULT NULL COMMENT '被分配人Id，别人分配过来的',
  `task_participants` bigint(64) NULL DEFAULT NULL COMMENT '任务参与人外键Id',
  `task_remind_hour` bigint(64) NULL DEFAULT NULL COMMENT '任务提醒时间',
  `task_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务内容',
  `task_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务备注',
  `work_task_status` bigint(64) NULL DEFAULT NULL COMMENT '工作任务状态',
  `work_task_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工作任务编号',
  `cancel_task_status` bigint(64) NULL DEFAULT NULL COMMENT '取消任务状态',
  `cancel_task_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '取消任务原因',
  `stop_task_status` bigint(64) NULL DEFAULT NULL COMMENT '取消任务状态',
  `stop_task_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '取消任务原因',
  `restart_task_status` bigint(64) NULL DEFAULT NULL COMMENT '重启任务状态',
  `restart_task_reason` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '重启任务原因',
  `task_progross_rate` double(64, 2) NULL DEFAULT NULL COMMENT '任务进度',
  `task_response_id` bigint(64) NULL DEFAULT NULL COMMENT '任务响应id',
  `task_status` bigint(64) NULL DEFAULT NULL COMMENT '任务提交状态',
  `task_attention_status` bigint(64) NULL DEFAULT NULL COMMENT '关注任务状态',
  `task_question` bigint(64) NULL DEFAULT NULL COMMENT '提出问题',
  `task_type` bigint(64) NULL DEFAULT NULL COMMENT '任务类型',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '修改人',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '假删除，删除状态',
  PRIMARY KEY (`task_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_create
-- ----------------------------
INSERT INTO `t_project_task_create` VALUES (354855785507102720, 'test002', 'Num002', NULL, 1, 1, 346515989627432960, '2019-11-21 17:53:21', NULL, NULL, NULL, 662, '', NULL, NULL, 1, NULL, 662, 1, 1, '任务内容', '任务备注', 0, 'GZRW001', 0, '', 1, '', 0, '终止任务原因', 0.10, NULL, 0, 1, NULL, NULL, 662, '曹操', '2019-11-14 15:17:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (354885433993502720, 'test001', 'Num003', 354855785507102720, 1, 1, 346515989627432961, '2019-11-18 18:00:04', '2019-11-21 18:00:09', NULL, NULL, 1, NULL, NULL, NULL, NULL, 662, NULL, 1, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 0.80, NULL, 0, 1, NULL, NULL, 662, '曹操', '2019-11-14 17:14:51', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (354900996459372544, 'test001', 'Num004', 354855785507102720, 1, NULL, 346515989627432962, '2019-11-29 09:50:46', NULL, NULL, NULL, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 0.50, NULL, 0, 0, NULL, NULL, 662, '曹操', '2019-11-14 18:16:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356595750993690624, NULL, NULL, 354855785507102720, 1, NULL, 346515989627432963, '2019-11-21 09:51:33', '2019-11-29 09:51:47', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, 0.20, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 10:31:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356595985497227264, NULL, NULL, NULL, 351951778888855552, NULL, NULL, '2019-11-13 09:52:23', '2019-11-26 09:52:27', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 10:31:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356624649081356288, 'test001', 'Num001', 1, 351951778888855552, 1, 1, NULL, NULL, NULL, NULL, 535, NULL, NULL, NULL, 1, NULL, NULL, 1, 1, '任务内容', '任务备注', 0, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 12:25:52', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356625306660143104, 'test001', 'Num001', 1, 351951778888855552, 1, 1, NULL, NULL, NULL, NULL, 535, NULL, NULL, NULL, 1, NULL, NULL, 1, 1, '任务内容', '任务备注', 0, NULL, 1, NULL, 1, NULL, 1, NULL, 0.10, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 12:28:29', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356626322638012416, 'test001', 'Num001', 1, 351951778888855552, 1, 1, NULL, NULL, NULL, NULL, 535, NULL, NULL, NULL, 1, NULL, NULL, 1, 1, '任务内容', '任务备注', 0, 'GZRW1574137951314', 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 12:32:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356651697938137088, 'test001', 'Num001', 1, 351951778888855552, 1, 1, NULL, NULL, NULL, NULL, 535, NULL, NULL, NULL, 1, NULL, NULL, 1, 1, '任务内容', '任务备注', 0, 'GZRW1574144001256', 1, NULL, 1, NULL, 1, NULL, 0.30, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 14:13:21', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356693635462627328, '测试任务', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 1, NULL, 1, NULL, 1, NULL, 0.60, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 17:00:00', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356694678711861248, '测试项目任务名称', NULL, NULL, NULL, NULL, NULL, '2019-11-19 09:53:51', '2019-12-04 09:53:56', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, 0.99, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 17:04:09', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356711161475137536, '测试项目任务名称', NULL, NULL, NULL, NULL, NULL, '2019-11-12 09:54:06', '2019-11-28 09:54:13', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 18:09:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356714526137417728, '测试123', NULL, NULL, 351951778888855552, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 18:23:01', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356714699517362176, '测试项目附件', NULL, NULL, 351951778888855552, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 18:23:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356722949478449152, '测试附件上传', NULL, NULL, 351951778888855552, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 18:56:29', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356735550476288000, '项目交付物测试', NULL, NULL, 351951778888855552, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-19 19:46:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356954398496432128, '测试质量要求', NULL, NULL, 351951778888855552, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '取消原因测试', 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-20 10:16:11', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356954989905879040, '测试质量要求1', NULL, NULL, 351951778888855552, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-20 10:18:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356959308831039488, 'task00112', NULL, NULL, 351951778888855552, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-20 10:35:41', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356961254329589760, '测试汇报要求', NULL, NULL, 351951778888855552, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-20 10:43:25', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (356963578057891840, '汇报要求测试1', NULL, NULL, 351951778888855552, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, NULL, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-20 10:52:39', NULL, NULL, NULL, 1);
INSERT INTO `t_project_task_create` VALUES (357419069426929664, '测试项目任务名称', NULL, NULL, 351951778888855552, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, 0.00, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-21 17:02:37', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_create` VALUES (357419244744642560, '测试任务名称', NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, NULL, 1, NULL, 0.00, NULL, 0, 1, NULL, NULL, 380, '何革学', '2019-11-21 17:03:19', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_task_deliver_product
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_deliver_product`;
CREATE TABLE `t_project_task_deliver_product`  (
  `deliver_product_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '交付物id',
  `deliver_product_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交付物名称',
  `task_id` bigint(64) NULL DEFAULT NULL COMMENT '任务id',
  `task_deliver_time` datetime(0) NULL DEFAULT NULL COMMENT '任务交付时间',
  `task_deliverer_id` bigint(64) NULL DEFAULT NULL COMMENT '交付人id',
  `task_deliverer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务交付名称',
  `task_deliver_status` bigint(64) NULL DEFAULT NULL COMMENT '审核状态',
  `deliver_check_score` bigint(64) NULL DEFAULT NULL COMMENT '交付物审核评分',
  `deliver_checker_id` bigint(64) NULL DEFAULT NULL COMMENT '审核人id',
  `deliver_produce_desc` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交付物描述',
  `delivery_check_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '修改人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`deliver_product_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_deliver_product
-- ----------------------------
INSERT INTO `t_project_task_deliver_product` VALUES (1, 'aa', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_deliver_product` VALUES (2, 'bb', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_deliver_product` VALUES (356671374420639744, 'cc', 354855785507102720, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-19 15:31:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_deliver_product` VALUES (356673713965662208, 'cc1', 354855785507102720, '2019-11-19 15:40:50', 380, NULL, 0, NULL, NULL, '描述', NULL, 380, '何革学', '2019-11-19 15:40:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_deliver_product` VALUES (356680642121203712, 'bb', 354855785507102720, '2019-11-19 16:08:22', 380, NULL, 0, NULL, NULL, '描述', NULL, 380, '何革学', '2019-11-19 16:08:22', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_deliver_product` VALUES (356682028632276992, 'aa', 354855785507102720, '2019-11-19 16:13:53', 380, NULL, 0, NULL, NULL, '描述', NULL, 380, '何革学', '2019-11-19 16:13:53', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_deliver_product` VALUES (356683393131642880, 'aa', 354855785507102720, '2019-11-19 16:19:18', 380, NULL, 0, NULL, NULL, '描述', NULL, 380, '何革学', '2019-11-19 16:19:18', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_deliver_product` VALUES (356683693276037120, 'aa', 354855785507102720, '2019-11-19 16:20:30', 380, NULL, 0, NULL, NULL, '描述', NULL, 380, '何革学', '2019-11-19 16:20:30', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_task_deliver_requirement
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_deliver_requirement`;
CREATE TABLE `t_project_task_deliver_requirement`  (
  `task_deliver_requirement_id` bigint(64) NOT NULL COMMENT '交付要求id',
  `task_deliver_requirement_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交付要求名',
  `task_deliver_requirement_time` datetime(0) NULL DEFAULT NULL COMMENT '交付要求时间',
  `task_deliver_requirement_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交付要求描述',
  `task_deliver_requirement_appendix_id` bigint(64) NULL DEFAULT NULL COMMENT '交付要求附件id',
  `task_id` bigint(64) NULL DEFAULT NULL COMMENT '计划id外键',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`task_deliver_requirement_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_deliver_requirement
-- ----------------------------
INSERT INTO `t_project_task_deliver_requirement` VALUES (351525891830251520, '交付要求aa', NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-05 10:45:14', 1, '更新人测试账号', '2019-11-05 10:45:14', 0);
INSERT INTO `t_project_task_deliver_requirement` VALUES (351535324727672832, 'aaa', NULL, '123aaa', NULL, 222, 1, '创建人测试账号', '2019-11-05 11:22:43', 1573543526397, '修改人测试账号', '2019-11-12 15:25:26', 0);
INSERT INTO `t_project_task_deliver_requirement` VALUES (351543111654375424, 'test', NULL, '123', NULL, 1, 1, '创建人测试账号', '2019-11-05 11:53:39', 1, '更新人测试账号', '2019-11-05 14:07:54', 0);
INSERT INTO `t_project_task_deliver_requirement` VALUES (351543182110294016, 'ccc', NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-05 11:53:56', 1, '更新人测试账号', '2019-11-05 11:53:56', 0);
INSERT INTO `t_project_task_deliver_requirement` VALUES (351543209985638400, 'ddd', NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-05 11:54:03', 1, '更新人测试账号', '2019-11-05 11:54:03', 0);
INSERT INTO `t_project_task_deliver_requirement` VALUES (354130377773973504, '测试', NULL, NULL, NULL, 1, 1573542871706, '创建人测试账号', '2019-11-12 15:14:32', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_task_message
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_message`;
CREATE TABLE `t_project_task_message`  (
  `task_message_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '消息id',
  `task_id` bigint(64) NULL DEFAULT NULL COMMENT '任务id',
  `message_sender_id` bigint(64) NULL DEFAULT NULL COMMENT '发送方id',
  `message_sender_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发送方姓名',
  `message_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '信息内容',
  `message_send_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `message_receiver_id` bigint(64) NULL DEFAULT NULL COMMENT '接受信息人id',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建人',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '修改人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`task_message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_message
-- ----------------------------
INSERT INTO `t_project_task_message` VALUES (1, 1, 1, 'aa', 'aaa123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_task_message` VALUES (2, 1, 2, 'bb', 'bb234', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_project_task_participant
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_participant`;
CREATE TABLE `t_project_task_participant`  (
  `task_id` bigint(64) NULL DEFAULT NULL COMMENT '计划id',
  `task_paticipant_user_id` bigint(64) NULL DEFAULT NULL COMMENT '参与人id',
  `task_panticipant_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '计划参与人表主键id',
  PRIMARY KEY (`task_panticipant_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_participant
-- ----------------------------
INSERT INTO `t_project_task_participant` VALUES (354844572391874560, 662, 1);
INSERT INTO `t_project_task_participant` VALUES (354855785507102720, 662, 2);
INSERT INTO `t_project_task_participant` VALUES (354885433993502720, 662, 3);
INSERT INTO `t_project_task_participant` VALUES (354855785507102720, 0, 4);

-- ----------------------------
-- Table structure for t_project_task_quality_requirement
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_quality_requirement`;
CREATE TABLE `t_project_task_quality_requirement`  (
  `task_quality_requirement_id` bigint(64) NOT NULL COMMENT '质量要求id',
  `task_quality_requirement_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '质量要求名',
  `task_quality_requirement_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '质量要求内容',
  `task_quality_appendix_id` bigint(64) NULL DEFAULT NULL COMMENT '质量要求附件id',
  `task_id` bigint(64) NULL DEFAULT NULL,
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`task_quality_requirement_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_quality_requirement
-- ----------------------------
INSERT INTO `t_project_task_quality_requirement` VALUES (350162965265428480, NULL, NULL, NULL, 1, 111, NULL, NULL, NULL, 'Scot', NULL, 0);
INSERT INTO `t_project_task_quality_requirement` VALUES (350162981342195712, NULL, NULL, NULL, 1, 111, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_quality_requirement` VALUES (350162984404037632, NULL, NULL, NULL, 1, 111, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_quality_requirement` VALUES (350162987432325120, NULL, NULL, NULL, 351877761132171264, 111, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_quality_requirement` VALUES (350162989353316352, NULL, NULL, NULL, 351585661106847744, 111, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_quality_requirement` VALUES (350162990812934144, NULL, NULL, NULL, 351585661106847744, 111, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_quality_requirement` VALUES (350162991790206976, NULL, NULL, NULL, 351585661106847744, 111, NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `t_project_task_quality_requirement` VALUES (351908611953561600, '质量要求名称aa', NULL, NULL, 351183918288142336, 1, '创建人测试id', '2019-11-06 12:06:01', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_task_report_requirement
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_report_requirement`;
CREATE TABLE `t_project_task_report_requirement`  (
  `task_report_requirement_id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '汇报要求id',
  `task_report_requirement_theme` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '汇报要求主题',
  `task_report_requirement_time` datetime(0) NULL DEFAULT NULL COMMENT '汇报要求时间',
  `task_report_requirement_method` bigint(64) NULL DEFAULT NULL COMMENT '汇报要求方式',
  `task_report_requirement` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '汇报要求方式',
  `task_report_appendix_id` bigint(64) NULL DEFAULT NULL COMMENT '汇报要求附件id',
  `task_id` bigint(64) NULL DEFAULT NULL COMMENT '任务id 外键',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '修改人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_status` bigint(64) UNSIGNED NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`task_report_requirement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 351944016031682561 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_report_requirement
-- ----------------------------
INSERT INTO `t_project_task_report_requirement` VALUES (351943363368620032, '1', NULL, NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-06 14:24:07', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_report_requirement` VALUES (351943494998462464, '1', NULL, NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-06 14:24:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_report_requirement` VALUES (351943768970399744, '1', NULL, NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-06 14:25:44', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_report_requirement` VALUES (351943925870923776, '1', NULL, NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-06 14:26:21', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_report_requirement` VALUES (351944016031682560, '1', NULL, NULL, NULL, NULL, 1, 1, '创建人测试账号', '2019-11-06 14:26:42', NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for t_project_task_response
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_response`;
CREATE TABLE `t_project_task_response`  (
  `task_response_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '任务响应id',
  `task_id` bigint(64) NULL DEFAULT NULL COMMENT '任务id',
  `task_response_method` bigint(64) NULL DEFAULT NULL COMMENT '任务响应方式',
  `task_start_time` datetime(0) NULL DEFAULT NULL COMMENT '任务开始时间',
  `task_end_time` datetime(0) NULL DEFAULT NULL COMMENT '任务结束时间',
  `task_duration` bigint(64) NULL DEFAULT NULL COMMENT '任务计划工时',
  `task_deadline` datetime(0) NULL DEFAULT NULL COMMENT '截止完成时间',
  `task_response_desc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务响应说明',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`task_response_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_response
-- ----------------------------
INSERT INTO `t_project_task_response` VALUES (356974699695349760, 354855785507102720, 1, NULL, NULL, NULL, NULL, '描述', 380, '何革学', '2019-11-20 11:36:51', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_task_work_report
-- ----------------------------
DROP TABLE IF EXISTS `t_project_task_work_report`;
CREATE TABLE `t_project_task_work_report`  (
  `work_report_id` bigint(64) NOT NULL DEFAULT 0 COMMENT '工作汇报id',
  `work_report_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工作汇报标题',
  `task_id` bigint(64) NULL DEFAULT NULL COMMENT '任务id',
  `work_reporter_id` bigint(64) NULL DEFAULT NULL COMMENT '工作汇报id',
  `actual_task_start_time` datetime(0) NULL DEFAULT NULL COMMENT '实际开始时间',
  `actual_task_end_time` datetime(0) NULL DEFAULT NULL COMMENT '实际结束时间',
  `actual_task_duration` bigint(64) NULL DEFAULT NULL COMMENT '实际任务工时',
  `work_task_content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '工作汇报内容',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` bigint(64) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`work_report_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_task_work_report
-- ----------------------------
INSERT INTO `t_project_task_work_report` VALUES (1, 'aa', 354855785507102720, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_task_work_report` VALUES (356612264589295616, '工作汇报TITLE', 354855785507102720, 662, NULL, NULL, 20, '', 380, '何革学', '2019-11-19 11:36:40', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_work_report` VALUES (356613453615759360, '工作汇报TITLE', 354855785507102720, 662, NULL, NULL, 20, '曹操123', 380, '何革学', '2019-11-19 11:41:23', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_work_report` VALUES (357032325959426048, NULL, NULL, NULL, NULL, NULL, NULL, '123', 380, '何革学', '2019-11-20 15:25:50', NULL, NULL, NULL, 0);
INSERT INTO `t_project_task_work_report` VALUES (357035737874735104, NULL, 354855785507102720, NULL, NULL, NULL, NULL, '123', 380, '何革学', '2019-11-20 15:39:24', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_team
-- ----------------------------
DROP TABLE IF EXISTS `t_project_team`;
CREATE TABLE `t_project_team`  (
  `id` bigint(64) NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `parent_id` bigint(64) NULL DEFAULT NULL COMMENT '父节点',
  `leader` bigint(64) NULL DEFAULT NULL COMMENT '负责人',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '说明',
  `responsibility` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '团队职责',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标识',
  `reg_id` bigint(64) NULL DEFAULT NULL COMMENT '组织id',
  `can_delete` int(2) NULL DEFAULT NULL COMMENT '可删标识',
  `index` int(8) NULL DEFAULT NULL COMMENT '排序编号',
  `short_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内置分组特征码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_team
-- ----------------------------
INSERT INTO `t_project_team` VALUES (1, 1, '测试项目团队', NULL, 535, '测试', '负责创建', 0, 'SYSTEM', '2019-10-15 11:29:52', 662, '曹操', '2019-10-22 17:22:22', 0, 204, 0, 0, 'root_queue');
INSERT INTO `t_project_team` VALUES (2, 1, '未分配成员', 1, 535, '未分配', '未分配人员', 0, 'SYSTEM', '2019-10-15 11:29:54', 0, 'SYSTEM', '2019-10-15 11:30:08', 0, 204, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (3, 1, '移出项目组的成员', 1, 535, '移出', '移出项目人员', 0, 'SYSTEM', '2019-10-15 11:29:56', 0, 'SYSTEM', '2019-10-15 11:30:09', 0, 204, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (11, 10, '计划测试1组', NULL, 505, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team` VALUES (12, 10, '计划测试2组', NULL, 506, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team` VALUES (13, 10, '计划测试3组', NULL, 507, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team` VALUES (346823537177964544, 346823536683036672, '未分配成员', 346823536783699968, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-23 11:19:45', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (346823537177964545, 346823536683036672, '移出项目组的成员', 346823536783699968, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-23 11:19:45', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348737495873757184, 348737495773093888, '前端项目团队', NULL, 386, '前端项目团队', NULL, 662, '曹操', '2019-10-28 18:05:08', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348737496309964800, 348737495773093888, '未分配成员', 348737495873757184, 386, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-28 18:05:09', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348737496309964801, 348737495773093888, '移出项目组的成员', 348737495873757184, 386, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-28 18:05:09', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348738015317336064, 348738015267004416, '对等项目团队', NULL, 384, '对等项目团队', NULL, 662, '曹操', '2019-10-28 18:07:12', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348738015753543680, 348738015267004416, '未分配成员', 348738015317336064, 384, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-28 18:07:12', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348738015753543681, 348738015267004416, '移出项目组的成员', 348738015317336064, 384, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-28 18:07:12', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348740712753930240, 348740712703598592, '前端项目团队', NULL, 382, '前端项目团队', NULL, 662, '曹操', '2019-10-28 18:17:55', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348740713181749248, 348740712703598592, '未分配成员', 348740712753930240, 382, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-28 18:17:56', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348740713181749249, 348740712703598592, '移出项目组的成员', 348740712753930240, 382, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-28 18:17:56', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348741009438023680, 348741009387692032, '对等项目团队', NULL, 513, '对等项目团队', NULL, 662, '曹操', '2019-10-28 18:19:06', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348741009748402176, 348741009387692032, '未分配成员', 348741009438023680, 513, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-28 18:19:06', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348741009748402177, 348741009387692032, '移出项目组的成员', 348741009438023680, 513, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-28 18:19:06', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348741405107691521, 348741405044776960, '前端项目团队', NULL, 383, '前端项目团队', NULL, 662, '曹操', '2019-10-28 18:20:41', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348741405317406720, 348741405044776960, '未分配成员', 348741405107691521, 383, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-28 18:20:41', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348741405317406721, 348741405044776960, '移出项目组的成员', 348741405107691521, 383, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-28 18:20:41', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348971174323691520, 348971174197862400, '前端项目团队', NULL, 383, '前端项目团队', NULL, 662, '曹操', '2019-10-29 09:33:42', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348971174734733312, 348971174197862400, '未分配成员', 348971174323691520, 383, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 09:33:42', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348971174734733313, 348971174197862400, '移出项目组的成员', 348971174323691520, 383, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 09:33:42', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348978252463349760, 348978252421406720, '测试测试测试测试测试测试测试测试测试项目团队', NULL, 382, '测试测试测试测试测试测试测试测试测试项目团队', NULL, 662, '曹操', '2019-10-29 10:01:49', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348978252845031424, 348978252421406720, '未分配成员', 348978252463349760, 382, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 10:01:49', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348978252845031425, 348978252421406720, '移出项目组的成员', 348978252463349760, 382, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 10:01:49', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348981350749577217, 348981350716022784, '测试测试111111111项目团队', NULL, 385, '测试测试111111111项目团队', NULL, 662, '曹操', '2019-10-29 10:14:08', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348981351173201920, 348981350716022784, '未分配成员', 348981350749577217, 385, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 10:14:08', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348981351173201921, 348981350716022784, '移出项目组的成员', 348981350749577217, 385, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 10:14:08', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348986819748700161, 348986819090194432, '测试项目团队', NULL, 379, '测试项目团队', NULL, 662, '曹操', '2019-10-29 10:35:52', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348986820180713472, 348986819090194432, '未分配成员', 348986819748700161, 379, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 10:35:52', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348986820180713473, 348986819090194432, '移出项目组的成员', 348986819748700161, 379, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 10:35:52', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348989741760913408, 348989741702193152, '多对多项目团队', NULL, 381, '多对多项目团队', NULL, 662, '曹操', '2019-10-29 10:47:29', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348989742197121024, 348989741702193152, '未分配成员', 348989741760913408, 381, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 10:47:29', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348989742197121025, 348989741702193152, '移出项目组的成员', 348989741760913408, 381, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 10:47:29', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (348999602632531968, 348999602510897152, '测试项目团队', NULL, 513, '测试项目团队', NULL, 662, '曹操', '2019-10-29 11:26:40', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (348999602951299072, 348999602510897152, '未分配成员', 348999602632531968, 513, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 11:26:40', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (348999602951299073, 348999602510897152, '移出项目组的成员', 348999602632531968, 513, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 11:26:40', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349000894676525057, 349000894559084544, '测试项目团队', NULL, 513, '测试项目团队', NULL, 662, '曹操', '2019-10-29 11:31:48', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349000895112732672, 349000894559084544, '未分配成员', 349000894676525057, 513, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 11:31:48', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349000895112732673, 349000894559084544, '移出项目组的成员', 349000894676525057, 513, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 11:31:48', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349002856339922944, 349002856176345088, '测试项目团队', NULL, 513, '测试项目团队', NULL, 662, '曹操', '2019-10-29 11:39:35', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349002856633524224, 349002856176345088, '未分配成员', 349002856339922944, 513, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 11:39:35', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349002856633524225, 349002856176345088, '移出项目组的成员', 349002856339922944, 513, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 11:39:35', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349003037231865857, 349003037072482304, '测试项目团队', NULL, 513, '测试项目团队', NULL, 662, '曹操', '2019-10-29 11:40:18', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349003037487718400, 349003037072482304, '未分配成员', 349003037231865857, 513, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 11:40:19', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349003037487718401, 349003037072482304, '移出项目组的成员', 349003037231865857, 513, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 11:40:19', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349003990851788800, 349003990688210944, '地地道道项目团队', NULL, 382, '地地道道项目团队', NULL, 662, '曹操', '2019-10-29 11:44:06', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349003991250247680, 349003990688210944, '未分配成员', 349003990851788800, 382, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 11:44:06', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349003991250247681, 349003990688210944, '移出项目组的成员', 349003990851788800, 382, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 11:44:06', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349047720682070016, 349047720610766848, '前端测试项目团队', NULL, 379, '前端测试项目团队', NULL, 662, '曹操', '2019-10-29 14:37:52', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349047721172803584, 349047720610766848, '未分配成员', 349047720682070016, 379, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 14:37:52', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349047721172803585, 349047720610766848, '移出项目组的成员', 349047720682070016, 379, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 14:37:52', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349048343540408320, 349048343481688064, 'DDFFF项目团队', NULL, 381, 'DDFFF项目团队', NULL, 662, '曹操', '2019-10-29 14:40:20', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349048343959838720, 349048343481688064, '未分配成员', 349048343540408320, 381, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 14:40:20', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349048343959838721, 349048343481688064, '移出项目组的成员', 349048343540408320, 381, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 14:40:20', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349048983880605696, 349048983813496832, '测试项目团队', NULL, 384, '测试项目团队', NULL, 662, '曹操', '2019-10-29 14:42:53', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349048984283258880, 349048983813496832, '未分配成员', 349048983880605696, 384, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 14:42:53', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349048984283258881, 349048983813496832, '移出项目组的成员', 349048983880605696, 384, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 14:42:53', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349051701491802112, 349051701441470464, '测试项目团队', NULL, 513, '测试项目团队', NULL, 662, '曹操', '2019-10-29 14:53:41', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349051701680545792, 349051701441470464, '未分配成员', 349051701491802112, 513, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-29 14:53:41', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349051701680545793, 349051701441470464, '移出项目组的成员', 349051701491802112, 513, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-29 14:53:41', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349102926481645568, 1, 'ff ', 346542586506014720, 664, 'ff ', 'f ', 662, '曹操', '2019-10-29 18:17:14', 662, '曹操', '2019-10-29 18:44:57', 1, 1439443889766823051, 1, 0, NULL);
INSERT INTO `t_project_team` VALUES (349346754945933312, NULL, '前端1111', 1, 664, '多对多', '对等', 662, '曹操', '2019-10-30 10:26:07', NULL, NULL, NULL, 0, 1439443889766823051, 1, 0, NULL);
INSERT INTO `t_project_team` VALUES (349346855768612864, 1, '对等', 1, 664, 'dd', '对等', 662, '曹操', '2019-10-30 10:26:31', NULL, NULL, NULL, 0, 1439443889766823051, 1, 0, NULL);
INSERT INTO `t_project_team` VALUES (349347849369870336, 1, '测试', 349346855768612864, 670, '对等', '的', 662, '曹操', '2019-10-30 10:30:28', 662, '曹操', '2019-10-30 10:45:59', 1, 1439443889766823051, 1, 0, NULL);
INSERT INTO `t_project_team` VALUES (349716777068535808, 349716776946900992, '前端项目团队', NULL, 513, '前端项目团队', NULL, 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349716777475383296, 349716776946900992, '未分配成员', 349716777068535808, 513, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349716777475383297, 349716776946900992, '移出项目组的成员', 349716777068535808, 513, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349721012636098560, 349721012568989696, '前端项目团队', NULL, 513, '前端项目团队', NULL, 662, '曹操', '2019-10-31 11:13:17', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349721013030363136, 349721012568989696, '未分配成员', 349721012636098560, 513, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-31 11:13:17', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349721013030363137, 349721012568989696, '移出项目组的成员', 349721012636098560, 513, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-31 11:13:17', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (349721351103848448, 349721351036739584, '前端22222222222项目团队', NULL, 513, '前端22222222222项目团队', NULL, 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (349721351514890240, 349721351036739584, '未分配成员', 349721351103848448, 513, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (349721351514890241, 349721351036739584, '移出项目组的成员', 349721351103848448, 513, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351161416036261888, 351161415935598592, '测试项目团队', NULL, 382, '测试项目团队', NULL, 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351161416388583424, 351161415935598592, '未分配成员', 351161416036261888, 382, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351161416388583425, 351161415935598592, '移出项目组的成员', 351161416036261888, 382, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351913314445209600, 351913314323574784, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351913314684284928, 351913314323574784, '未分配成员', 351913314445209600, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351913314684284929, 351913314323574784, '移出项目组的成员', 351913314445209600, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351914125741043713, 351914125690712064, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351914126001090560, 351914125690712064, '未分配成员', 351914125741043713, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351914126001090561, 351914125690712064, '移出项目组的成员', 351914125741043713, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351936776916217856, 351936776865886208, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 13:57:57', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351936777239179264, 351936776865886208, '未分配成员', 351936776916217856, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 13:57:57', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351936777239179265, 351936776865886208, '移出项目组的成员', 351936776916217856, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 13:57:57', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351936905383555073, 351936905253531648, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351936905735876608, 351936905253531648, '未分配成员', 351936905383555073, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351936905735876609, 351936905253531648, '移出项目组的成员', 351936905383555073, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351940112449056768, 351940112302256128, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351940112688132096, 351940112302256128, '未分配成员', 351940112449056768, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351940112688132097, 351940112302256128, '移出项目组的成员', 351940112449056768, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351940893537513472, 351940893411684352, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351940894279905280, 351940893411684352, '未分配成员', 351940893537513472, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351940894279905281, 351940893411684352, '移出项目组的成员', 351940893537513472, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351946090045288449, 351946089906876416, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351946090380832768, 351946089906876416, '未分配成员', 351946090045288449, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351946090380832769, 351946089906876416, '移出项目组的成员', 351946090045288449, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351947352442712064, 351947352291717120, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351947353088634880, 351947352291717120, '未分配成员', 351947352442712064, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351947353088634881, 351947352291717120, '移出项目组的成员', 351947352442712064, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351947469065334785, 351947469006614528, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351947469480570880, 351947469006614528, '未分配成员', 351947469065334785, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351947469480570881, 351947469006614528, '移出项目组的成员', 351947469065334785, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351947526674100224, 351947526640545792, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:40:39', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351947526908981248, 351947526640545792, '未分配成员', 351947526674100224, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:40:40', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351947526908981249, 351947526640545792, '移出项目组的成员', 351947526674100224, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:40:40', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351947619754094592, 351947619716345856, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351947620085444608, 351947619716345856, '未分配成员', 351947619754094592, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351947620085444609, 351947619716345856, '移出项目组的成员', 351947619754094592, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951659338608640, 351951659208585216, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951659992920064, 351951659208585216, '未分配成员', 351951659338608640, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951659992920065, 351951659208585216, '移出项目组的成员', 351951659338608640, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951721464639488, 351951721422696448, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951721770823680, 351951721422696448, '未分配成员', 351951721464639488, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951721770823681, 351951721422696448, '移出项目组的成员', 351951721464639488, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951743698644993, 351951743644119040, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951743929331712, 351951743644119040, '未分配成员', 351951743698644993, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951743929331713, 351951743644119040, '移出项目组的成员', 351951743698644993, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951760249368576, 351951760140316672, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951760396169216, 351951760140316672, '未分配成员', 351951760249368576, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951760396169217, 351951760140316672, '移出项目组的成员', 351951760249368576, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951763583840256, 351951763537702912, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951763822915584, 351951763537702912, '未分配成员', 351951763583840256, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951763822915585, 351951763537702912, '移出项目组的成员', 351951763583840256, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951766377246720, 351951766318526464, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951766477910016, 351951766318526464, '未分配成员', 351951766377246720, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951766477910017, 351951766318526464, '移出项目组的成员', 351951766377246720, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951769145487360, 351951769099350016, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951769351008256, 351951769099350016, '未分配成员', 351951769145487360, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951769351008257, 351951769099350016, '移出项目组的成员', 351951769145487360, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951772056334336, 351951772006002688, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951772182163456, 351951772006002688, '未分配成员', 351951772056334336, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951772182163457, 351951772006002688, '移出项目组的成员', 351951772056334336, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951774308675584, 351951774266732544, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951774589693952, 351951774266732544, '未分配成员', 351951774308675584, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951774589693953, 351951774266732544, '移出项目组的成员', 351951774308675584, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951776531656705, 351951776502296576, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951776795897856, 351951776502296576, '未分配成员', 351951776531656705, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951776795897857, 351951776502296576, '移出项目组的成员', 351951776531656705, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (351951778930798593, 351951778888855552, '测试项目11111项目团队', NULL, 535, '测试项目11111项目团队', NULL, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0, 1439443889766823051, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (351951779136319488, 351951778888855552, '未分配成员', 351951778930798593, 535, '没有分组的成员', '没有分组的成员', 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0, 1439443889766823051, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (351951779136319489, 351951778888855552, '移出项目组的成员', 351951778930798593, 535, '移出项目族的成员', '移出项目族的成员', 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0, 1439443889766823051, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (356298551303217152, 356298551248691200, 'ddd 项目团队', NULL, 379, 'ddd 项目团队', NULL, 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL, 0, 204, 0, NULL, 'root_queue');
INSERT INTO `t_project_team` VALUES (356298551970111488, 356298551248691200, '未分配成员', 356298551303217152, 379, '没有分组的成员', '没有分组的成员', 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL, 0, 204, 0, -1, 'ungroup_queue');
INSERT INTO `t_project_team` VALUES (356298551970111489, 356298551248691200, '移出项目组的成员', 356298551303217152, 379, '移出项目族的成员', '移出项目族的成员', 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL, 0, 204, 0, -2, 'remove_queue');
INSERT INTO `t_project_team` VALUES (356350144430088192, 1, 'ddd', 1, 513, 'dd', '对等所得到的的的 d', 380, '何革学', '2019-11-18 18:15:05', 380, '何革学', '2019-11-19 16:16:12', 1, 204, 1, 0, NULL);

-- ----------------------------
-- Table structure for t_project_team_user
-- ----------------------------
DROP TABLE IF EXISTS `t_project_team_user`;
CREATE TABLE `t_project_team_user`  (
  `id` bigint(64) NOT NULL,
  `team_id` bigint(64) NULL DEFAULT NULL COMMENT '队伍id',
  `user_id` bigint(64) NULL DEFAULT NULL COMMENT 't_project_user id',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `duration` int(10) NULL DEFAULT NULL COMMENT '持续时间',
  `time_percent` decimal(6, 2) NULL DEFAULT NULL COMMENT '投入项目时间比例',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_team_user
-- ----------------------------
INSERT INTO `t_project_team_user` VALUES (14, 11, 508, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team_user` VALUES (15, 11, 513, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team_user` VALUES (16, 11, 521, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team_user` VALUES (17, 12, 522, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team_user` VALUES (18, 12, 526, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team_user` VALUES (19, 13, 527, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team_user` VALUES (10001, 348737495873757184, 662, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team_user` VALUES (1000001, 1, 381, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_project_team_user` VALUES (349716777886425088, 349716777068535808, 513, '2019-10-31 10:56:27', NULL, NULL, NULL, 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349716777886425089, 349716777475383296, 381, '2019-10-31 10:56:27', NULL, NULL, NULL, 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349716777886425090, 349716777475383296, 382, '2019-10-31 10:56:27', NULL, NULL, NULL, 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349716777886425091, 349716777475383296, 383, '2019-10-31 10:56:27', NULL, NULL, NULL, 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349721013483347968, 349721012636098560, 513, '2019-10-31 11:13:17', NULL, NULL, NULL, 662, '曹操', '2019-10-31 11:13:17', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349721013483347969, 349721013030363136, 381, '2019-10-31 11:13:17', NULL, NULL, NULL, 662, '曹操', '2019-10-31 11:13:17', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349721013483347970, 349721013030363136, 382, '2019-10-31 11:13:17', NULL, NULL, NULL, 662, '曹操', '2019-10-31 11:13:17', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349721013483347971, 349721013030363136, 383, '2019-10-31 11:13:17', NULL, NULL, NULL, 662, '曹操', '2019-10-31 11:13:17', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349721352001429504, 349721351103848448, 513, '2019-10-31 11:14:38', NULL, NULL, NULL, 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349721352001429505, 349721351514890240, 381, '2019-10-31 11:14:38', NULL, NULL, NULL, 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349721352001429506, 349721351514890240, 382, '2019-10-31 11:14:38', NULL, NULL, NULL, 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (349721352001429507, 349721351514890240, 383, '2019-10-31 11:14:38', NULL, NULL, NULL, 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351161416896094208, 351161416388583424, 384, '2019-11-04 10:36:56', NULL, NULL, NULL, 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351161416896094209, 351161416036261888, 382, '2019-11-04 10:36:56', NULL, NULL, NULL, 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351161416896094210, 351161416388583424, 383, '2019-11-04 10:36:56', NULL, NULL, NULL, 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351913315011440640, 351913314684284928, 662, '2019-11-06 12:24:43', NULL, NULL, NULL, 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351913315011440641, 351913314445209600, 535, '2019-11-06 12:24:43', NULL, NULL, NULL, 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351913315011440642, 351913314684284928, 664, '2019-11-06 12:24:43', NULL, NULL, NULL, 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351914126282108928, 351914126001090560, 662, '2019-11-06 12:27:56', NULL, NULL, NULL, 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351914126282108929, 351914125741043713, 535, '2019-11-06 12:27:56', NULL, NULL, NULL, 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351914126282108930, 351914126001090560, 664, '2019-11-06 12:27:56', NULL, NULL, NULL, 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351936777587306496, 351936777239179264, 662, '2019-11-06 13:57:56', NULL, NULL, NULL, 662, '曹操', '2019-11-06 13:57:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351936777587306497, 351936776916217856, 535, '2019-11-06 13:57:56', NULL, NULL, NULL, 662, '曹操', '2019-11-06 13:57:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351936777587306498, 351936777239179264, 664, '2019-11-06 13:57:56', NULL, NULL, NULL, 662, '曹操', '2019-11-06 13:57:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351936905953980416, 351936905735876608, 662, '2019-11-06 13:58:27', NULL, NULL, NULL, 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351936905953980417, 351936905383555073, 535, '2019-11-06 13:58:27', NULL, NULL, NULL, 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351936905953980418, 351936905735876608, 664, '2019-11-06 13:58:27', NULL, NULL, NULL, 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351940113057230848, 351940112688132096, 662, '2019-11-06 14:11:12', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351940113057230849, 351940112449056768, 535, '2019-11-06 14:11:12', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351940113057230850, 351940112688132096, 664, '2019-11-06 14:11:12', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351940894506397696, 351940894279905280, 662, '2019-11-06 14:14:18', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351940894506397697, 351940893537513472, 535, '2019-11-06 14:14:18', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351940894506397698, 351940894279905280, 664, '2019-11-06 14:14:18', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351946090607325184, 351946090380832768, 662, '2019-11-06 14:34:57', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351946090607325185, 351946090045288449, 535, '2019-11-06 14:34:57', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351946090607325186, 351946090380832768, 664, '2019-11-06 14:34:57', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947353793277952, 351947353088634880, 662, '2019-11-06 14:39:58', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947353793277953, 351947352442712064, 535, '2019-11-06 14:39:58', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947353793277954, 351947353088634880, 664, '2019-11-06 14:39:58', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947469744812032, 351947469480570880, 662, '2019-11-06 14:40:26', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947469744812033, 351947469065334785, 535, '2019-11-06 14:40:26', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947469744812034, 351947469480570880, 664, '2019-11-06 14:40:26', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947527189999616, 351947526908981248, 662, '2019-11-06 14:40:39', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:40:40', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947527189999617, 351947526674100224, 535, '2019-11-06 14:40:39', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:40:40', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947527189999618, 351947526908981248, 664, '2019-11-06 14:40:39', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:40:40', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947620609732608, 351947620085444608, 662, '2019-11-06 14:41:02', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947620609732609, 351947619754094592, 535, '2019-11-06 14:41:02', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351947620609732610, 351947620085444608, 664, '2019-11-06 14:41:02', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951660148109312, 351951659992920064, 662, '2019-11-06 14:57:05', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951660148109313, 351951659338608640, 535, '2019-11-06 14:57:05', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951660148109314, 351951659992920064, 664, '2019-11-06 14:57:05', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951722009899008, 351951721770823680, 662, '2019-11-06 14:57:20', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951722009899009, 351951721464639488, 535, '2019-11-06 14:57:20', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951722009899010, 351951721770823680, 664, '2019-11-06 14:57:20', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951744696889344, 351951743929331712, 662, '2019-11-06 14:57:25', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951744696889345, 351951743698644993, 535, '2019-11-06 14:57:25', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951744696889346, 351951743929331712, 664, '2019-11-06 14:57:25', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951760639438848, 351951760396169216, 662, '2019-11-06 14:57:29', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951760639438849, 351951760249368576, 535, '2019-11-06 14:57:29', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951760639438850, 351951760396169216, 664, '2019-11-06 14:57:29', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951764103933952, 351951763822915584, 662, '2019-11-06 14:57:30', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951764103933953, 351951763583840256, 535, '2019-11-06 14:57:30', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951764103933954, 351951763822915584, 664, '2019-11-06 14:57:30', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951766763122688, 351951766477910016, 662, '2019-11-06 14:57:30', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951766763122689, 351951766377246720, 535, '2019-11-06 14:57:30', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951766763122690, 351951766477910016, 664, '2019-11-06 14:57:30', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951769590083584, 351951769351008256, 662, '2019-11-06 14:57:31', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951769590083585, 351951769145487360, 535, '2019-11-06 14:57:31', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951769590083586, 351951769351008256, 664, '2019-11-06 14:57:31', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951772421238784, 351951772182163456, 662, '2019-11-06 14:57:32', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951772421238785, 351951772056334336, 535, '2019-11-06 14:57:32', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951772421238786, 351951772182163456, 664, '2019-11-06 14:57:32', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951774732300288, 351951774589693952, 662, '2019-11-06 14:57:32', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951774732300289, 351951774308675584, 535, '2019-11-06 14:57:32', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951774732300290, 351951774589693952, 664, '2019-11-06 14:57:32', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951777072721920, 351951776795897856, 662, '2019-11-06 14:57:33', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951777072721921, 351951776531656705, 535, '2019-11-06 14:57:33', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951777072721922, 351951776795897856, 664, '2019-11-06 14:57:33', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951779274731520, 351951779136319488, 662, '2019-11-06 14:57:33', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951779274731521, 351951778930798593, 535, '2019-11-06 14:57:33', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (351951779274731522, 351951779136319488, 664, '2019-11-06 14:57:33', NULL, NULL, NULL, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (354515456145104897, 3, 354515456077996033, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-14 09:56:54', 380, '何革学', '2019-11-14 10:17:10', 0);
INSERT INTO `t_project_team_user` VALUES (354515456145104898, 3, 354515456077996034, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-14 10:13:07', 380, '何革学', '2019-11-14 10:16:04', 0);
INSERT INTO `t_project_team_user` VALUES (354515456145104899, 349346855768612864, 354515456077996035, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-14 10:18:27', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (354515456145104906, 349346855768612864, 354515456077996042, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-19 16:01:55', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (354515456145104907, 2, 354515456077996043, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (354515456145104909, 349346855768612864, 354515456077996045, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-15 14:25:07', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (354515456145104911, 3, 354515456077996047, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-14 09:57:14', 380, '何革学', '2019-11-14 10:17:18', 0);
INSERT INTO `t_project_team_user` VALUES (354515456145104913, 3, 354515456077996049, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-14 10:17:40', 380, '何革学', '2019-11-14 10:18:13', 0);
INSERT INTO `t_project_team_user` VALUES (354515456145104914, 349346855768612864, 354515456077996050, NULL, NULL, NULL, NULL, 380, '何革学', '2019-11-18 11:01:08', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (356298552251129856, 356298551303217152, 379, '2019-11-18 14:50:05', NULL, NULL, NULL, 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (356298552251129857, 356298551970111488, 381, '2019-11-18 14:50:05', NULL, NULL, NULL, 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL, 0);
INSERT INTO `t_project_team_user` VALUES (356298552251129858, 356298551970111488, 382, '2019-11-18 14:50:05', NULL, NULL, NULL, 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_project_user
-- ----------------------------
DROP TABLE IF EXISTS `t_project_user`;
CREATE TABLE `t_project_user`  (
  `id` bigint(64) NOT NULL,
  `project_id` bigint(64) NULL DEFAULT NULL COMMENT '项目id',
  `user_id` bigint(64) NULL DEFAULT NULL COMMENT '项目用户id',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建人',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新人',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人名称',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_user
-- ----------------------------
INSERT INTO `t_project_user` VALUES (349347595153104896, 1, 664, -1, 662, '曹操', '2019-10-30 10:29:27', 662, '曹操', '2019-10-30 10:29:58');
INSERT INTO `t_project_user` VALUES (349347595153104897, 1, 662, 1, 662, '曹操', '2019-10-30 10:29:27', 662, '曹操', '2019-10-30 10:30:02');
INSERT INTO `t_project_user` VALUES (349347595153104898, 1, 670, -1, 662, '曹操', '2019-10-30 10:29:27', 662, '曹操', '2019-10-30 10:30:06');
INSERT INTO `t_project_user` VALUES (349347790561533952, 1, 664, -1, 662, '曹操', '2019-10-30 10:30:14', 662, '曹操', '2019-10-30 10:45:57');
INSERT INTO `t_project_user` VALUES (349347790561533953, 1, 662, -1, 662, '曹操', '2019-10-30 10:30:14', 662, '曹操', '2019-10-30 10:46:07');
INSERT INTO `t_project_user` VALUES (349347790561533954, 1, 670, -1, 662, '曹操', '2019-10-30 10:30:14', 662, '曹操', '2019-10-30 10:45:51');
INSERT INTO `t_project_user` VALUES (349351810881609728, 1, 664, -1, 662, '曹操', '2019-10-30 10:46:13', 662, '曹操', '2019-10-31 09:36:23');
INSERT INTO `t_project_user` VALUES (349351810881609729, 1, 662, -1, 662, '曹操', '2019-10-30 10:46:13', 662, '曹操', '2019-10-30 15:07:27');
INSERT INTO `t_project_user` VALUES (349351810881609730, 1, 670, -1, 662, '曹操', '2019-10-30 10:46:13', 662, '曹操', '2019-10-30 15:07:24');
INSERT INTO `t_project_user` VALUES (349417607166304256, 1, 662, -1, 662, '曹操', '2019-10-30 15:07:40', 662, '曹操', '2019-10-31 09:36:21');
INSERT INTO `t_project_user` VALUES (349417607166304257, 1, 513, -1, 662, '曹操', '2019-10-30 15:07:40', 662, '曹操', '2019-10-31 09:36:25');
INSERT INTO `t_project_user` VALUES (349716777030787072, 349716776946900992, 513, 1, 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349716777030787073, 349716776946900992, 381, 1, 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349716777030787074, 349716776946900992, 382, 1, 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349716777030787075, 349716776946900992, 383, 1, 662, '曹操', '2019-10-31 10:56:27', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349721351061905408, 349721351036739584, 513, 1, 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349721351061905409, 349721351036739584, 381, 1, 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349721351061905410, 349721351036739584, 382, 1, 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349721351061905411, 349721351036739584, 383, 1, 662, '曹操', '2019-10-31 11:14:38', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349723555269320704, 349721012568989696, 513, 1, 662, '曹操', '2019-10-31 11:23:23', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349723555269320705, 349721012568989696, 381, 1, 662, '曹操', '2019-10-31 11:23:23', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349723555269320706, 349721012568989696, 382, 1, 662, '曹操', '2019-10-31 11:23:23', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (349723555269320707, 349721012568989696, 383, 1, 662, '曹操', '2019-10-31 11:23:23', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351160490827325440, 349051701441470464, 513, 1, 662, '曹操', '2019-11-04 10:33:15', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351160490827325441, 349051701441470464, 380, 1, 662, '曹操', '2019-11-04 10:33:15', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351160490827325442, 349051701441470464, 381, 1, 662, '曹操', '2019-11-04 10:33:15', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351161415964958720, 351161415935598592, 384, 1, 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351161415969153024, 351161415935598592, 382, 1, 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351161415969153025, 351161415935598592, 383, 1, 662, '曹操', '2019-11-04 10:36:56', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351165329800044544, 1, 664, 1, 662, '曹操', '2019-11-04 10:52:29', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351165329800044545, 1, 662, 1, 662, '曹操', '2019-11-04 10:52:29', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351165329800044546, 1, 670, 1, 662, '曹操', '2019-11-04 10:52:29', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351913314394877952, 351913314323574784, 662, 1, 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351913314394877953, 351913314323574784, 535, 1, 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351913314394877954, 351913314323574784, 664, 1, 662, '曹操', '2019-11-06 12:24:43', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351914125715877888, 351914125690712064, 662, 1, 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351914125715877889, 351914125690712064, 535, 1, 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351914125715877890, 351914125690712064, 664, 1, 662, '曹操', '2019-11-06 12:27:56', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351936776895246336, 351936776865886208, 662, 1, 662, '曹操', '2019-11-06 13:57:56', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351936776895246337, 351936776865886208, 535, 1, 662, '曹操', '2019-11-06 13:57:56', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351936776895246338, 351936776865886208, 664, 1, 662, '曹操', '2019-11-06 13:57:56', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351936905324834816, 351936905253531648, 662, 1, 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351936905324834817, 351936905253531648, 535, 1, 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351936905324834818, 351936905253531648, 664, 1, 662, '曹操', '2019-11-06 13:58:27', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351940112390336512, 351940112302256128, 662, 1, 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351940112390336513, 351940112302256128, 535, 1, 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351940112390336514, 351940112302256128, 664, 1, 662, '曹操', '2019-11-06 14:11:12', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351940893487181824, 351940893411684352, 662, 1, 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351940893487181825, 351940893411684352, 535, 1, 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351940893487181826, 351940893411684352, 664, 1, 662, '曹操', '2019-11-06 14:14:18', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351946089986568192, 351946089906876416, 662, 1, 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351946089986568193, 351946089906876416, 535, 1, 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351946089986568194, 351946089906876416, 664, 1, 662, '曹操', '2019-11-06 14:34:57', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947352371408896, 351947352291717120, 662, 1, 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947352371408897, 351947352291717120, 535, 1, 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947352371408898, 351947352291717120, 664, 1, 662, '曹操', '2019-11-06 14:39:58', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947469035974656, 351947469006614528, 662, 1, 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947469035974657, 351947469006614528, 535, 1, 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947469035974658, 351947469006614528, 664, 1, 662, '曹操', '2019-11-06 14:40:26', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947526657323008, 351947526640545792, 662, 1, 662, '曹操', '2019-11-06 14:40:39', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947526657323009, 351947526640545792, 535, 1, 662, '曹操', '2019-11-06 14:40:39', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947526657323010, 351947526640545792, 664, 1, 662, '曹操', '2019-11-06 14:40:39', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947619737317376, 351947619716345856, 662, 1, 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947619737317377, 351947619716345856, 535, 1, 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351947619737317378, 351947619716345856, 664, 1, 662, '曹操', '2019-11-06 14:41:02', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951659284082688, 351951659208585216, 662, 1, 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951659284082689, 351951659208585216, 535, 1, 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951659284082690, 351951659208585216, 664, 1, 662, '曹操', '2019-11-06 14:57:05', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951721443667968, 351951721422696448, 662, 1, 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951721443667969, 351951721422696448, 535, 1, 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951721443667970, 351951721422696448, 664, 1, 662, '曹操', '2019-11-06 14:57:20', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951743673479168, 351951743644119040, 662, 1, 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951743673479169, 351951743644119040, 535, 1, 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951743673479170, 351951743644119040, 664, 1, 662, '曹操', '2019-11-06 14:57:25', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951760169676800, 351951760140316672, 662, 1, 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951760169676801, 351951760140316672, 535, 1, 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951760169676802, 351951760140316672, 664, 1, 662, '曹操', '2019-11-06 14:57:29', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951766347886592, 351951766318526464, 662, 1, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951766347886593, 351951766318526464, 535, 1, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951766347886594, 351951766318526464, 664, 1, 662, '曹操', '2019-11-06 14:57:30', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951769116127232, 351951769099350016, 662, 1, 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951769116127233, 351951769099350016, 535, 1, 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951769116127234, 351951769099350016, 664, 1, 662, '曹操', '2019-11-06 14:57:31', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951772035362816, 351951772006002688, 662, 1, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951772035362817, 351951772006002688, 535, 1, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951772035362818, 351951772006002688, 664, 1, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951774283509760, 351951774266732544, 662, 1, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951774283509761, 351951774266732544, 535, 1, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951774283509762, 351951774266732544, 664, 1, 662, '曹操', '2019-11-06 14:57:32', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951778909827072, 351951778888855552, 662, 1, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951778909827073, 351951778888855552, 535, 1, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (351951778909827074, 351951778888855552, 664, 1, 662, '曹操', '2019-11-06 14:57:33', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (352232490022871040, 351951776502296576, 662, 1, 662, '曹操', '2019-11-07 09:33:00', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (352232490022871041, 351951776502296576, 535, 1, 662, '曹操', '2019-11-07 09:33:00', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (352232490022871042, 351951776502296576, 664, 1, 662, '曹操', '2019-11-07 09:33:00', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (352233095936221184, 351951763537702912, 662, 1, 662, '曹操', '2019-11-07 09:35:24', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (352233095936221185, 351951763537702912, 535, 1, 662, '曹操', '2019-11-07 09:35:24', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (352233095936221186, 351951763537702912, 664, 1, 662, '曹操', '2019-11-07 09:35:24', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996032, 1, 492, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996033, 1, 388, 0, 380, '何革学', '2019-11-13 16:44:42', 380, '何革学', '2019-11-14 10:17:10');
INSERT INTO `t_project_user` VALUES (354515456077996034, 1, 389, 0, 380, '何革学', '2019-11-13 16:44:42', 380, '何革学', '2019-11-14 10:16:04');
INSERT INTO `t_project_user` VALUES (354515456077996035, 1, 390, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996036, 1, 513, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996037, 1, 422, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996038, 1, 423, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996039, 1, 470, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996040, 1, 487, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996041, 1, 822, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996042, 1, 527, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996043, 1, 529, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996044, 1, 460, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996045, 1, 476, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996046, 1, 457, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996047, 1, 449, 0, 380, '何革学', '2019-11-13 16:44:42', 380, '何革学', '2019-11-14 10:17:18');
INSERT INTO `t_project_user` VALUES (354515456077996048, 1, 475, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354515456077996049, 1, 459, 0, 380, '何革学', '2019-11-13 16:44:42', 380, '何革学', '2019-11-14 10:18:13');
INSERT INTO `t_project_user` VALUES (354515456077996050, 1, 489, 1, 380, '何革学', '2019-11-13 16:44:42', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354779724727853056, 1, 822, 1, 380, '何革学', '2019-11-14 10:14:48', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354779814876028928, 1, 822, 1, 380, '何革学', '2019-11-14 10:15:10', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354779814876028929, 1, 875, 1, 380, '何革学', '2019-11-14 10:15:10', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (354852249537224704, 1, 822, 1, 380, '何革学', '2019-11-14 15:02:59', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (356298551278051328, 356298551248691200, 379, 1, 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (356298551278051329, 356298551248691200, 381, 1, 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL);
INSERT INTO `t_project_user` VALUES (356298551278051330, 356298551248691200, 382, 1, 380, '何革学', '2019-11-18 14:50:05', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_project_view
-- ----------------------------
DROP TABLE IF EXISTS `t_project_view`;
CREATE TABLE `t_project_view`  (
  `id` bigint(64) NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `user_id` bigint(64) NULL DEFAULT NULL COMMENT '用户id',
  `reg_id` bigint(64) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL COMMENT '状态（0隐藏，1是显示）',
  `create_id` bigint(64) NULL DEFAULT NULL COMMENT '创建id',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_id` bigint(64) NULL DEFAULT NULL COMMENT '更新id',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_status` int(2) NULL DEFAULT NULL COMMENT '删除标示',
  `type_id` int(2) NULL DEFAULT NULL COMMENT '类型id',
  `short_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简称标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_view
-- ----------------------------
INSERT INTO `t_project_view` VALUES (1, '产品维度', NULL, NULL, 1, 0, 'system', '2019-10-28 17:27:45', NULL, NULL, NULL, 0, 1, 'project_product');
INSERT INTO `t_project_view` VALUES (2, '区域维度', NULL, NULL, 1, 0, 'system', '2019-10-28 17:29:33', NULL, NULL, NULL, 0, 2, 'project_area');
INSERT INTO `t_project_view` VALUES (3, '行业维度', NULL, NULL, 1, 0, 'system', '2019-10-28 17:29:33', NULL, NULL, NULL, 0, 3, 'project_industry');
INSERT INTO `t_project_view` VALUES (4, '规模维度', NULL, NULL, 1, 0, 'system', '2019-10-28 17:29:33', NULL, NULL, NULL, 0, 4, 'project_scope');
INSERT INTO `t_project_view` VALUES (5, '风险维度', NULL, NULL, 1, 0, 'system', '2019-10-28 17:29:33', NULL, NULL, NULL, 0, 5, 'project_risk');
INSERT INTO `t_project_view` VALUES (6, '所属部门', NULL, NULL, 1, 0, 'system', '2019-10-28 17:29:33', NULL, NULL, NULL, 0, 6, 'project_dept');
INSERT INTO `t_project_view` VALUES (7, '客户维度', NULL, NULL, 1, 0, 'system', '2019-10-30 14:26:48', NULL, NULL, NULL, 0, 7, 'project_customer');
INSERT INTO `t_project_view` VALUES (350170120401489920, '产品维度', 662, 1439443889766823051, 0, 662, '曹操', '2019-11-01 16:57:53', 662, '曹操', '2019-11-09 10:59:04', 0, 1, 'project_product');
INSERT INTO `t_project_view` VALUES (350170120401489921, '区域维度', 662, 1439443889766823051, 1, 662, '曹操', '2019-11-01 16:57:53', 662, '曹操', '2019-11-04 09:18:05', 0, 2, 'project_area');
INSERT INTO `t_project_view` VALUES (350170120401489922, '行业维度', 662, 1439443889766823051, 1, 662, '曹操', '2019-11-01 16:57:53', 662, '曹操', '2019-11-04 09:18:08', 0, 3, 'project_industry');
INSERT INTO `t_project_view` VALUES (350170120401489923, '规模维度', 662, 1439443889766823051, 1, 662, '曹操', '2019-11-01 16:57:53', 662, '曹操', '2019-11-09 10:55:42', 0, 4, 'project_scope');
INSERT INTO `t_project_view` VALUES (350170120401489924, '风险维度', 662, 1439443889766823051, 1, 662, '曹操', '2019-11-01 16:57:53', 662, '曹操', '2019-11-09 10:55:43', 0, 5, 'project_risk');
INSERT INTO `t_project_view` VALUES (350170120401489925, '所属部门', 662, 1439443889766823051, 1, 662, '曹操', '2019-11-01 16:57:53', 662, '曹操', '2019-11-09 10:55:46', 0, 6, 'project_dept');
INSERT INTO `t_project_view` VALUES (350170120401489926, '客户维度', 662, 1439443889766823051, 1, 662, '曹操', '2019-11-01 16:57:53', 662, '曹操', '2019-11-09 10:55:48', 0, 7, 'project_customer');
INSERT INTO `t_project_view` VALUES (354076035159564288, '产品维度', 380, 204, 1, 380, '何革学', '2019-11-12 11:38:35', NULL, NULL, NULL, 0, 1, 'project_product');
INSERT INTO `t_project_view` VALUES (354076035159564289, '区域维度', 380, 204, 1, 380, '何革学', '2019-11-12 11:38:35', NULL, NULL, NULL, 0, 2, 'project_area');
INSERT INTO `t_project_view` VALUES (354076035159564290, '行业维度', 380, 204, 1, 380, '何革学', '2019-11-12 11:38:35', NULL, NULL, NULL, 0, 3, 'project_industry');
INSERT INTO `t_project_view` VALUES (354076035159564291, '规模维度', 380, 204, 1, 380, '何革学', '2019-11-12 11:38:35', NULL, NULL, NULL, 0, 4, 'project_scope');
INSERT INTO `t_project_view` VALUES (354076035159564292, '风险维度', 380, 204, 1, 380, '何革学', '2019-11-12 11:38:35', NULL, NULL, NULL, 0, 5, 'project_risk');
INSERT INTO `t_project_view` VALUES (354076035159564293, '所属部门', 380, 204, 1, 380, '何革学', '2019-11-12 11:38:35', NULL, NULL, NULL, 0, 6, 'project_dept');
INSERT INTO `t_project_view` VALUES (354076035159564294, '客户维度', 380, 204, 1, 380, '何革学', '2019-11-12 11:38:35', NULL, NULL, NULL, 0, 7, 'project_customer');

-- ----------------------------
-- Table structure for t_project_view_selfconfig
-- ----------------------------
DROP TABLE IF EXISTS `t_project_view_selfconfig`;
CREATE TABLE `t_project_view_selfconfig`  (
  `id` bigint(64) NOT NULL,
  `view_id` bigint(64) NULL DEFAULT NULL COMMENT '主视图信息id',
  `field_type` int(2) NULL DEFAULT NULL COMMENT '字段类型',
  `filter_type` int(2) NULL DEFAULT NULL COMMENT '过滤类型',
  `filter_value` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '过滤值',
  `condition_str` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模型解析',
  `create_id` bigint(64) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_id` bigint(64) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `del_status` int(2) NULL DEFAULT NULL,
  `action_code` int(2) NULL DEFAULT NULL COMMENT '操作符类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_project_view_selfconfig
-- ----------------------------
INSERT INTO `t_project_view_selfconfig` VALUES (1, 11111111, 1, 1, '346515989577101312', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 1);
INSERT INTO `t_project_view_selfconfig` VALUES (350100210224762880, 350099365332553728, 1, 1, '346515989577101312', ' and project_type = 346515989577101312', 662, '曹操', '2019-11-01 12:20:05', NULL, NULL, NULL, 0, 1);

-- ----------------------------
-- Function structure for dataPermQueryChildDicByPIds
-- ----------------------------
DROP FUNCTION IF EXISTS `dataPermQueryChildDicByPIds`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `dataPermQueryChildDicByPIds`(p_id VARCHAR(4000)) RETURNS varchar(4000) CHARSET utf8mb4
    READS SQL DATA
    SQL SECURITY INVOKER
BEGIN 
#递归查询系统部门   根据父节点查询下面的所有子节点
DECLARE idTemp VARCHAR(4000); 

DECLARE idTempChd VARCHAR(4000); 

SET idTemp = '$'; 

SET idTempChd = p_id; 

WHILE idTempChd is not NULL DO 

SET idTemp = CONCAT(idTemp,',',idTempChd); 

select group_concat(ID) INTO idTempChd from t_project_dictionary_item t
WHERE FIND_IN_SET(PARENT_ID,idTempChd)>0;

END WHILE; 

return idTemp; 

END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
