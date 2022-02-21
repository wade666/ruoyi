/*
 Navicat Premium Data Transfer

 Source Server         : ruoyi
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : ry-cloud

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 18/02/2022 14:19:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES (6, 't_product_brand', '商品品牌表', NULL, NULL, 'TProductBrand', 'crud', 'com.ruoyi.goods', 'goods', 'brand', '商品品牌', 'ruoyi', '0', '/', NULL, 'admin', '2022-02-11 17:59:17', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (7, 't_product', '商品表', NULL, NULL, 'TProduct', 'crud', 'com.ruoyi.goods', 'goods', 'product', '商品', 'ruoyi', '0', '/', NULL, 'admin', '2022-02-12 09:33:56', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (8, 't_sku', '商品sku表', NULL, NULL, 'TSku', 'crud', 'com.ruoyi.goods', 'goods', 'sku', '商品sku', 'ruoyi', '0', '/', NULL, 'admin', '2022-02-12 10:42:55', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (9, 't_specification', '商品规格', NULL, NULL, 'TSpecification', 'crud', 'com.ruoyi.goods', 'goods', 'specification', '商品规格', 'ruoyi', '0', '/', NULL, 'admin', '2022-02-12 13:59:18', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (10, 't_warehouse', '仓库', NULL, NULL, 'TWarehouse', 'crud', 'com.ruoyi.goods', 'goods', 'warehouse', '仓库', 'ruoyi', '0', '/', NULL, 'admin', '2022-02-12 17:43:34', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (11, 't_product_conversion_proportion', '商品规格换算表', NULL, NULL, 'TProductConversionProportion', 'crud', 'com.ruoyi.goods', 'goods', 'proportion', '商品规格换算', 'ruoyi', '0', '/', NULL, 'admin', '2022-02-14 14:43:15', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (12, 't_shipping_method', '配送方式', NULL, NULL, 'TShippingMethod', 'crud', 'com.ruoyi.goods', 'goods', 'method', '配送方式', 'ruoyi', '0', '/', NULL, 'admin', '2022-02-15 16:43:38', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (13, 't_shipping_reverse_config', '物流拒收配置表', NULL, NULL, 'TShippingReverseConfig', 'crud', 'com.ruoyi.goods', 'goods', 'config', '物流拒收配置', 'ruoyi', '0', '/', NULL, 'admin', '2022-02-15 16:43:38', '', NULL, NULL);
INSERT INTO `gen_table` VALUES (14, 't_product_label', '商品标签', NULL, NULL, 'TProductLabel', 'crud', 'com.ruoyi.goods', 'goods', 'label', '商品标签', 'ruoyi', '0', '/', NULL, 'admin', '2022-02-16 11:47:42', '', NULL, NULL);

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 204 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES (92, '6', 'brand_id', '品牌id', 'bigint(20)', 'Long', 'brandId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (93, '6', 'parent_id', '父分类id', 'bigint(20)', 'Long', 'parentId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (94, '6', 'ancestors', '祖级列表', 'varchar(50)', 'String', 'ancestors', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (95, '6', 'brand_name', '品牌名称', 'varchar(30)', 'String', 'brandName', '0', '0', NULL, '1', '1', '1', '1', 'LIKE', 'input', '', 4, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (96, '6', 'sort_num', '显示顺序', 'int(4)', 'Integer', 'sortNum', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (97, '6', 'status', '品牌状态（0正常 1停用）', 'char(1)', 'String', 'status', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'radio', '', 6, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (98, '6', 'del_flag', '删除标志（0代表存在 2代表删除）', 'char(1)', 'String', 'delFlag', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 7, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (99, '6', 'create_by', '创建者', 'varchar(64)', 'String', 'createBy', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 8, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (100, '6', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 9, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (101, '6', 'update_by', '更新者', 'varchar(64)', 'String', 'updateBy', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'input', '', 10, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (102, '6', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 11, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (103, '6', 'logo', 'logo', 'varchar(128)', 'String', 'logo', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 12, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (104, '6', 'introduction', '介绍', 'varchar(1024)', 'String', 'introduction', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'textarea', '', 13, 'admin', '2022-02-11 17:59:17', '', NULL);
INSERT INTO `gen_table_column` VALUES (105, '7', 'id', '主键id', 'bigint(20)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (106, '7', 'sn', '商品标号', 'varchar(255)', 'String', 'sn', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (107, '7', 'product_name', '商品名称', 'varchar(50)', 'String', 'productName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 3, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (108, '7', 'product_images', '轮播图json保存多中类型大图中图小图原图', 'json', 'String', 'productImages', '0', '0', NULL, '1', '1', '1', '1', 'EQ', NULL, '', 4, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (109, '7', 'image', '商品主图', 'varchar(200)', 'String', 'image', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'imageUpload', '', 5, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (110, '7', 'price', '商品销售价', 'decimal(10,2)', 'BigDecimal', 'price', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (111, '7', 'vip_price', '会员价格后续扩展，暂时冗余不需要使用', 'decimal(10,2)', 'BigDecimal', 'vipPrice', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (112, '7', 'product_category_id', '关联商品分类', 'bigint(20)', 'Long', 'productCategoryId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (113, '7', 'unit', '单位名', 'varchar(10)', 'String', 'unit', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (114, '7', 'sort', '排序正序', 'int(10)', 'Integer', 'sort', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (115, '7', 'sales', '销量', 'int(10)', 'Integer', 'sales', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (116, '7', 'introduction', '产品描述', 'text', 'String', 'introduction', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'textarea', '', 12, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (117, '7', 'create_time', NULL, 'datetime', 'Date', 'createTime', '0', '0', '1', '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 13, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (118, '7', 'update_time', NULL, 'timestamp', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 14, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (119, '7', 'is_del', '是否删除 0是1否', 'tinyint(1)', 'Integer', 'isDel', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 15, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (120, '7', 'caption', '副标题', 'varchar(20)', 'String', 'caption', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 16, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (121, '7', 'market_price', '市场价', 'decimal(10,2)', 'BigDecimal', 'marketPrice', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 17, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (122, '7', 'is_marketable', '是否上架 1是2否', 'tinyint(1)', 'Integer', 'isMarketable', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 18, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (123, '7', 'memo', '备注', 'varchar(50)', 'String', 'memo', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 19, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (124, '7', 'seo_title', '冗余', 'varchar(200)', 'String', 'seoTitle', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 20, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (125, '7', 'keyword', '搜索关键词', 'varchar(255)', 'String', 'keyword', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 21, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (126, '7', 'brand_id', '品牌id', 'bigint(20)', 'Long', 'brandId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 22, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (127, '7', 'parameter_values', '参数值json-暂时保留字段目前不需要使用', 'json', 'String', 'parameterValues', '0', '0', NULL, '1', '1', '1', '1', 'EQ', NULL, '', 23, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (128, '7', 'specification_items', '规格项 json', 'json', 'String', 'specificationItems', '0', '0', NULL, '1', '1', '1', '1', 'EQ', NULL, '', 24, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (129, '7', 'version', '版本号', 'int(10)', 'Integer', 'version', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 25, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (130, '7', 'product_type', '商品类型见枚举', 'int(4)', 'Integer', 'productType', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'select', '', 26, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (131, '7', 'shipping_method_id', '配送方式', 'bigint(20)', 'Long', 'shippingMethodId', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 27, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (132, '7', 'warehouse_id', '仓库id', 'bigint(20)', 'Long', 'warehouseId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 28, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (133, '7', 'project_id', '项目id', 'bigint(20)', 'Long', 'projectId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 29, 'admin', '2022-02-12 09:33:56', '', NULL);
INSERT INTO `gen_table_column` VALUES (134, '8', 'id', '主键id', 'bigint(20)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (135, '8', 'product_id', '关联商品id', 'bigint(20)', 'Long', 'productId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (136, '8', 'price', '销售价', 'decimal(10,2)', 'BigDecimal', 'price', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (137, '8', 'cost', '成本价', 'decimal(10,2)', 'BigDecimal', 'cost', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (138, '8', 'market_price', '市场价', 'decimal(10,2)', 'BigDecimal', 'marketPrice', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (139, '8', 'stock', '库存', 'int(10)', 'Integer', 'stock', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (140, '8', 'allocated_stock', '已分配库存', 'int(10)', 'Integer', 'allocatedStock', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (141, '8', 'is_default', '是否默认', 'tinyint(1)', 'Integer', 'isDefault', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (142, '8', 'specification_values', '规格值[]', 'json', 'String', 'specificationValues', '0', '0', '1', '1', '1', '1', '1', 'EQ', NULL, '', 9, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (143, '8', 'image', '规格图片', 'varchar(128)', 'String', 'image', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'imageUpload', '', 10, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (144, '8', 'sn', 'sku编号全局唯一', 'varchar(50)', 'String', 'sn', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (145, '8', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', '1', '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 12, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (146, '8', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', '1', '1', '1', NULL, NULL, 'EQ', 'datetime', '', 13, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (147, '8', 'version', '版本号', 'int(10)', 'Integer', 'version', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (148, '8', 'weight', '重量', 'double(10,2)', 'BigDecimal', 'weight', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 15, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (149, '8', 'exchange_point', '兑换积分', 'bigint(20)', 'Long', 'exchangePoint', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 16, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (150, '8', 'reward_point', '赠送积分', 'bigint(20)', 'Long', 'rewardPoint', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 17, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (151, '8', 'is_sale', '是否上架 1是2否', 'tinyint(1)', 'Integer', 'isSale', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 18, 'admin', '2022-02-12 10:42:55', '', NULL);
INSERT INTO `gen_table_column` VALUES (152, '9', 'id', '主键id', 'bigint(20)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-02-12 13:59:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (153, '9', 'name', '名称', 'varchar(255)', 'String', 'name', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2022-02-12 13:59:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (154, '9', 'options', '可选项目', 'json', 'String', 'options', '0', '0', '1', '1', '1', '1', '1', 'EQ', NULL, '', 3, 'admin', '2022-02-12 13:59:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (155, '9', 'product_category_id', '绑定分类', 'bigint(20)', 'Long', 'productCategoryId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-02-12 13:59:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (156, '9', 'sort', '排序', 'int(10)', 'Integer', 'sort', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-02-12 13:59:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (157, '9', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', '1', '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 6, 'admin', '2022-02-12 13:59:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (158, '9', 'update_time', '最后修改时间', 'datetime', 'Date', 'updateTime', '0', '0', '1', '1', '1', NULL, NULL, 'EQ', 'datetime', '', 7, 'admin', '2022-02-12 13:59:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (159, '9', 'version', '版本号', 'int(10)', 'Integer', 'version', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-02-12 13:59:18', '', NULL);
INSERT INTO `gen_table_column` VALUES (160, '10', 'id', '主键id', 'bigint(20)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (161, '10', 'warehouse_name', '仓库名', 'varchar(255)', 'String', 'warehouseName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (162, '10', 'sys_user_id', '仓库管理员', 'bigint(20)', 'Long', 'sysUserId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (163, '10', 'contact', '联系人', 'varchar(20)', 'String', 'contact', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (164, '10', 'address', '地址省市县以及详细地址暂时不区分，可能存在退货使用此地址', 'varchar(255)', 'String', 'address', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (165, '10', 'phone', '手机', 'varchar(20)', 'String', 'phone', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (166, '10', 'memo', '备注', 'varchar(255)', 'String', 'memo', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (167, '10', 'is_default', '是否默认 0是1否', 'tinyint(1)', 'Integer', 'isDefault', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (168, '10', 'state', '状态 0禁用 1正常', 'tinyint(1)', 'Integer', 'state', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (169, '10', 'app_key', '快递助手appKey', 'varchar(255)', 'String', 'appKey', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (170, '10', 'app_secret', '快递助手appSecret', 'varchar(255)', 'String', 'appSecret', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 11, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (171, '10', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 12, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (172, '10', 'update_time', '最后修改时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 13, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (173, '10', 'version', '版本号', 'int(10)', 'Integer', 'version', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2022-02-12 17:43:34', '', NULL);
INSERT INTO `gen_table_column` VALUES (174, '11', 'conversion_id', NULL, 'bigint(20)', 'Long', 'conversionId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-02-14 14:43:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (175, '11', 'conversion_proportion', '换算率', 'int(11)', 'Long', 'conversionProportion', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 2, 'admin', '2022-02-14 14:43:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (176, '11', 'specification_values', '规格', 'json', 'String', 'specificationValues', '0', '0', '1', '1', '1', '1', '1', 'EQ', NULL, '', 3, 'admin', '2022-02-14 14:43:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (177, '11', 'is_del', '是否删除 0是1否', 'tinyint(1)', 'Integer', 'isDel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-02-14 14:43:15', '', NULL);
INSERT INTO `gen_table_column` VALUES (178, '12', 'id', '主键id', 'bigint(20)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (179, '12', 'name', '名称', 'varchar(255)', 'String', 'name', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (180, '12', 'first_weight', '首重', 'double(10,2)', 'BigDecimal', 'firstWeight', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (181, '12', 'continue_weight', '续重量', 'double(10,2)', 'BigDecimal', 'continueWeight', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 4, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (182, '12', 'default_first_price', '默认首重价格', 'decimal(10,2)', 'BigDecimal', 'defaultFirstPrice', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (183, '12', 'default_continue_price', '默认续重价格', 'decimal(10,2)', 'BigDecimal', 'defaultContinuePrice', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (184, '12', 'description', '介绍', 'varchar(255)', 'String', 'description', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (185, '12', 'code', '代码用于阿里快递查询编码', 'varchar(255)', 'String', 'code', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 8, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (186, '12', 'alipay_code', '冗余支付宝订单中心编码如果做支付宝订单中心需要此字段', 'varchar(255)', 'String', 'alipayCode', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 9, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (187, '12', 'courier_code', '快递助手物流编码', 'varchar(255)', 'String', 'courierCode', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 10, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (188, '12', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', '1', '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 11, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (189, '12', 'update_time', '最后修改时间', 'datetime', 'Date', 'updateTime', '0', '0', '1', '1', '1', NULL, NULL, 'EQ', 'datetime', '', 12, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (190, '12', 'version', '版本号', 'int(10)', 'Integer', 'version', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 13, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (191, '12', 'orders', '排序', 'int(5)', 'Integer', 'orders', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 14, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (192, '13', 'reverse_id', '主键', 'bigint(20)', 'Long', 'reverseId', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (193, '13', 'reverse_status', '反向签收状态', 'varchar(510)', 'String', 'reverseStatus', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'radio', '', 2, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (194, '13', 'shipping_id', '物流id', 'bigint(20)', 'Long', 'shippingId', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (195, '13', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', '1', '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 4, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (196, '13', 'is_delete', '是否删除 0否1是', 'tinyint(1)', 'Integer', 'isDelete', '0', '0', '1', '1', '1', '1', '1', 'EQ', 'input', '', 5, 'admin', '2022-02-15 16:43:38', '', NULL);
INSERT INTO `gen_table_column` VALUES (197, '14', 'id', '主键', 'bigint(20)', 'Long', 'id', '1', '1', NULL, '1', NULL, NULL, NULL, 'EQ', 'input', '', 1, 'admin', '2022-02-16 11:47:42', '', NULL);
INSERT INTO `gen_table_column` VALUES (198, '14', 'label_name', '标签名称', 'varchar(200)', 'String', 'labelName', '0', '0', '1', '1', '1', '1', '1', 'LIKE', 'input', '', 2, 'admin', '2022-02-16 11:47:42', '', NULL);
INSERT INTO `gen_table_column` VALUES (199, '14', 'bak', '备注', 'varchar(255)', 'String', 'bak', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 3, 'admin', '2022-02-16 11:47:42', '', NULL);
INSERT INTO `gen_table_column` VALUES (200, '14', 'create_time', '创建时间', 'datetime', 'Date', 'createTime', '0', '0', NULL, '1', NULL, NULL, NULL, 'EQ', 'datetime', '', 4, 'admin', '2022-02-16 11:47:42', '', NULL);
INSERT INTO `gen_table_column` VALUES (201, '14', 'update_time', '更新时间', 'datetime', 'Date', 'updateTime', '0', '0', NULL, '1', '1', NULL, NULL, 'EQ', 'datetime', '', 5, 'admin', '2022-02-16 11:47:42', '', NULL);
INSERT INTO `gen_table_column` VALUES (202, '14', 'is_del', '是否删除 0是1否', 'tinyint(1)', 'Integer', 'isDel', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 6, 'admin', '2022-02-16 11:47:42', '', NULL);
INSERT INTO `gen_table_column` VALUES (203, '14', 'version', '版本号', 'int(10)', 'Integer', 'version', '0', '0', NULL, '1', '1', '1', '1', 'EQ', 'input', '', 7, 'admin', '2022-02-16 11:47:42', '', NULL);

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `blob_data` blob NULL COMMENT '存放持久化Trigger对象',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Blob类型的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `calendar_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '日历名称',
  `calendar` blob NOT NULL COMMENT '存放持久化calendar对象',
  PRIMARY KEY (`sched_name`, `calendar_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日历信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `cron_expression` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'cron表达式',
  `time_zone_id` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '时区',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'Cron类型的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `entry_id` varchar(95) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度器实例id',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `instance_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度器实例名',
  `fired_time` bigint(13) NOT NULL COMMENT '触发的时间',
  `sched_time` bigint(13) NOT NULL COMMENT '定时器制定的时间',
  `priority` int(11) NOT NULL COMMENT '优先级',
  `state` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态',
  `job_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '任务组名',
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否并发',
  `requests_recovery` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否接受恢复执行',
  PRIMARY KEY (`sched_name`, `entry_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '已触发的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `job_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务组名',
  `description` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相关介绍',
  `job_class_name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '执行任务类名称',
  `is_durable` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否持久化',
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否并发',
  `is_update_data` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否更新数据',
  `requests_recovery` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '是否接受恢复执行',
  `job_data` blob NULL COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务详细信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `lock_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '悲观锁名称',
  PRIMARY KEY (`sched_name`, `lock_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '存储的悲观锁信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  PRIMARY KEY (`sched_name`, `trigger_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '暂停的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `instance_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '实例名称',
  `last_checkin_time` bigint(13) NOT NULL COMMENT '上次检查时间',
  `checkin_interval` bigint(13) NOT NULL COMMENT '检查间隔时间',
  PRIMARY KEY (`sched_name`, `instance_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '调度器状态表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `repeat_count` bigint(7) NOT NULL COMMENT '重复的次数统计',
  `repeat_interval` bigint(12) NOT NULL COMMENT '重复的间隔时间',
  `times_triggered` bigint(10) NOT NULL COMMENT '已经触发的次数',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '简单触发器的信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_triggers表trigger_group的外键',
  `str_prop_1` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第一个参数',
  `str_prop_2` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第二个参数',
  `str_prop_3` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第三个参数',
  `int_prop_1` int(11) NULL DEFAULT NULL COMMENT 'int类型的trigger的第一个参数',
  `int_prop_2` int(11) NULL DEFAULT NULL COMMENT 'int类型的trigger的第二个参数',
  `long_prop_1` bigint(20) NULL DEFAULT NULL COMMENT 'long类型的trigger的第一个参数',
  `long_prop_2` bigint(20) NULL DEFAULT NULL COMMENT 'long类型的trigger的第二个参数',
  `dec_prop_1` decimal(13, 4) NULL DEFAULT NULL COMMENT 'decimal类型的trigger的第一个参数',
  `dec_prop_2` decimal(13, 4) NULL DEFAULT NULL COMMENT 'decimal类型的trigger的第二个参数',
  `bool_prop_1` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Boolean类型的trigger的第一个参数',
  `bool_prop_2` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Boolean类型的trigger的第二个参数',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '同步机制的行锁表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '触发器的名字',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '触发器所属组的名字',
  `job_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_job_details表job_name的外键',
  `job_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'qrtz_job_details表job_group的外键',
  `description` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相关介绍',
  `next_fire_time` bigint(13) NULL DEFAULT NULL COMMENT '上一次触发时间（毫秒）',
  `prev_fire_time` bigint(13) NULL DEFAULT NULL COMMENT '下一次触发时间（默认为-1表示不触发）',
  `priority` int(11) NULL DEFAULT NULL COMMENT '优先级',
  `trigger_state` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '触发器状态',
  `trigger_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '触发器的类型',
  `start_time` bigint(13) NOT NULL COMMENT '开始时间',
  `end_time` bigint(13) NULL DEFAULT NULL COMMENT '结束时间',
  `calendar_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日程表名称',
  `misfire_instr` smallint(2) NULL DEFAULT NULL COMMENT '补偿执行的策略',
  `job_data` blob NULL COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  INDEX `sched_name`(`sched_name`, `job_name`, `job_group`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '触发器详细信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2022-01-19 13:49:52', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2022-01-19 13:49:52', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2022-01-19 13:49:52', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (4, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2022-01-19 13:49:52', '', NULL, '是否开启注册用户功能（true开启，false关闭）');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', '若依科技', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL);
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL);
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL);
INSERT INTO `sys_dept` VALUES (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL);
INSERT INTO `sys_dept` VALUES (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL);
INSERT INTO `sys_dept` VALUES (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL);
INSERT INTO `sys_dept` VALUES (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL);
INSERT INTO `sys_dept` VALUES (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL);
INSERT INTO `sys_dept` VALUES (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL);
INSERT INTO `sys_dept` VALUES (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL);
INSERT INTO `sys_dept` VALUES (110, 101, '0,100,101', '技术部2', 6, '若依', '15888888888', NULL, '0', '2', 'admin', '2022-01-25 16:01:31', 'admin', '2022-01-26 09:22:03');
INSERT INTO `sys_dept` VALUES (111, 102, '0,100,102', '技术部', 6, 'admin', '15088888888', NULL, '0', '0', 'admin', '2022-01-26 09:29:05', 'admin', '2022-01-26 10:13:15');
INSERT INTO `sys_dept` VALUES (112, 101, '0,100,101', '技术3', 7, NULL, NULL, NULL, '0', '0', 'admin', '2022-01-26 09:55:45', '', NULL);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (29, 1, '普通商品', '1', 'product_type', NULL, NULL, 'Y', '0', 'admin', '2022-02-16 15:38:08', '', NULL, '商品类型');
INSERT INTO `sys_dict_data` VALUES (30, 2, '兑换商品', '2', 'product_type', NULL, NULL, 'Y', '0', 'admin', '2022-02-16 15:43:33', '', NULL, '商品类型');
INSERT INTO `sys_dict_data` VALUES (31, 3, '赠品', '3', 'product_type', NULL, NULL, 'Y', '0', 'admin', '2022-02-16 15:45:17', '', NULL, '商品类型');
INSERT INTO `sys_dict_data` VALUES (32, 4, '定制商品', '4', 'product_type', NULL, NULL, 'Y', '0', 'admin', '2022-02-16 15:46:04', '', NULL, '商品类型');
INSERT INTO `sys_dict_data` VALUES (33, 5, '电销专供', '5', 'product_type', NULL, NULL, 'Y', '0', 'admin', '2022-02-16 15:48:04', '', NULL, '商品类型');
INSERT INTO `sys_dict_data` VALUES (34, 6, '电商专供', '6', 'product_type', NULL, NULL, 'Y', '0', 'admin', '2022-02-16 15:48:06', '', NULL, '商品类型');
INSERT INTO `sys_dict_data` VALUES (35, 7, '直播专供', '7', 'product_type', NULL, NULL, 'Y', '0', 'admin', '2022-02-16 15:48:09', '', NULL, '商品类型');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '登录状态列表');
INSERT INTO `sys_dict_type` VALUES (11, '商品类型', 'product_type', '0', 'admin', '2022-02-16 15:36:03', '', NULL, '商品类型列表');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_job` VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_job` VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2022-01-19 13:49:52', '', NULL, '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '提示信息',
  `access_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 134 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES (100, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-20 09:49:55');
INSERT INTO `sys_logininfor` VALUES (101, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-21 17:25:07');
INSERT INTO `sys_logininfor` VALUES (102, 'admin', '127.0.0.1', '0', '退出成功', '2022-01-22 10:35:45');
INSERT INTO `sys_logininfor` VALUES (103, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-22 10:35:51');
INSERT INTO `sys_logininfor` VALUES (104, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-22 16:30:18');
INSERT INTO `sys_logininfor` VALUES (105, 'admin', '127.0.0.1', '0', '退出成功', '2022-01-22 16:53:16');
INSERT INTO `sys_logininfor` VALUES (106, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-22 16:53:23');
INSERT INTO `sys_logininfor` VALUES (107, 'admin', '127.0.0.1', '0', '退出成功', '2022-01-22 16:57:46');
INSERT INTO `sys_logininfor` VALUES (108, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-22 16:58:06');
INSERT INTO `sys_logininfor` VALUES (109, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-24 10:00:38');
INSERT INTO `sys_logininfor` VALUES (110, 'admin', '127.0.0.1', '0', '退出成功', '2022-01-25 10:26:44');
INSERT INTO `sys_logininfor` VALUES (111, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-25 10:26:50');
INSERT INTO `sys_logininfor` VALUES (112, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-25 14:36:33');
INSERT INTO `sys_logininfor` VALUES (113, 'admin', '127.0.0.1', '0', '退出成功', '2022-01-26 09:17:42');
INSERT INTO `sys_logininfor` VALUES (114, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-26 09:17:52');
INSERT INTO `sys_logininfor` VALUES (115, 'admin', '127.0.0.1', '0', '退出成功', '2022-01-27 10:53:03');
INSERT INTO `sys_logininfor` VALUES (116, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-27 10:53:17');
INSERT INTO `sys_logininfor` VALUES (117, 'admin', '127.0.0.1', '0', '退出成功', '2022-01-28 08:48:35');
INSERT INTO `sys_logininfor` VALUES (118, 'admin', '127.0.0.1', '0', '退出成功', '2022-01-28 08:48:35');
INSERT INTO `sys_logininfor` VALUES (119, 'admin', '127.0.0.1', '0', '登录成功', '2022-01-28 08:48:46');
INSERT INTO `sys_logininfor` VALUES (120, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-09 09:32:35');
INSERT INTO `sys_logininfor` VALUES (121, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-10 08:38:05');
INSERT INTO `sys_logininfor` VALUES (122, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-11 13:54:50');
INSERT INTO `sys_logininfor` VALUES (123, 'admin', '127.0.0.1', '0', '退出成功', '2022-02-11 16:28:54');
INSERT INTO `sys_logininfor` VALUES (124, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-11 16:29:09');
INSERT INTO `sys_logininfor` VALUES (125, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-11 16:44:42');
INSERT INTO `sys_logininfor` VALUES (126, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-12 08:44:48');
INSERT INTO `sys_logininfor` VALUES (127, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-14 09:02:00');
INSERT INTO `sys_logininfor` VALUES (128, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-15 09:31:05');
INSERT INTO `sys_logininfor` VALUES (129, 'admin', '127.0.0.1', '0', '退出成功', '2022-02-16 08:55:54');
INSERT INTO `sys_logininfor` VALUES (130, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-16 08:56:15');
INSERT INTO `sys_logininfor` VALUES (131, 'admin', '127.0.0.1', '0', '退出成功', '2022-02-17 09:24:51');
INSERT INTO `sys_logininfor` VALUES (132, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-17 09:25:03');
INSERT INTO `sys_logininfor` VALUES (133, 'admin', '127.0.0.1', '0', '登录成功', '2022-02-18 10:10:17');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int(1) NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1120 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', '2022-01-19 13:49:52', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 2, 'monitor', NULL, '', 1, 0, 'M', '0', '0', '', 'monitor', 'admin', '2022-01-19 13:49:52', '', NULL, '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 3, 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', '2022-01-19 13:49:52', '', NULL, '系统工具目录');
INSERT INTO `sys_menu` VALUES (4, '商品中心', 0, 4, 'goods', NULL, '', 1, 0, 'M', '0', '0', '', 'goods', 'admin', '2022-01-19 13:49:52', '', NULL, '商品中心目录');
INSERT INTO `sys_menu` VALUES (5, '若依官网', 0, 5, 'http://ruoyi.vip', NULL, '', 0, 0, 'M', '0', '0', '', 'guide', 'admin', '2022-01-19 13:49:52', '', NULL, '若依官网地址');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2022-01-19 13:49:52', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2022-01-19 13:49:52', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2022-01-19 13:49:52', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2022-01-19 13:49:52', '', NULL, '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2022-01-19 13:49:52', '', NULL, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2022-01-19 13:49:52', '', NULL, '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2022-01-19 13:49:52', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2022-01-19 13:49:52', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2022-01-19 13:49:52', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2022-01-19 13:49:52', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2022-01-19 13:49:52', '', NULL, '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, 'Sentinel控制台', 2, 3, 'http://localhost:8718', '', '', 0, 0, 'C', '0', '0', 'monitor:sentinel:list', 'sentinel', 'admin', '2022-01-19 13:49:52', '', NULL, '流量控制菜单');
INSERT INTO `sys_menu` VALUES (112, 'Nacos控制台', 2, 4, 'http://localhost:8848/nacos', '', '', 0, 0, 'C', '0', '0', 'monitor:nacos:list', 'nacos', 'admin', '2022-01-19 13:49:52', '', NULL, '服务治理菜单');
INSERT INTO `sys_menu` VALUES (113, 'Admin控制台', 2, 5, 'http://localhost:9100/login', '', '', 0, 0, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2022-01-19 13:49:52', '', NULL, '服务监控菜单');
INSERT INTO `sys_menu` VALUES (114, '表单构建', 3, 1, 'build', 'tool/build/index', '', 1, 0, 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2022-01-19 13:49:52', '', NULL, '表单构建菜单');
INSERT INTO `sys_menu` VALUES (115, '代码生成', 3, 2, 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2022-01-19 13:49:52', '', NULL, '代码生成菜单');
INSERT INTO `sys_menu` VALUES (116, '系统接口', 3, 3, 'http://localhost:8080/swagger-ui/index.html', '', '', 0, 0, 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2022-01-19 13:49:52', '', NULL, '系统接口菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'system/operlog/index', '', 1, 0, 'C', '0', '0', 'system:operlog:list', 'form', 'admin', '2022-01-19 13:49:52', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'system/logininfor/index', '', 1, 0, 'C', '0', '0', 'system:logininfor:list', 'logininfor', 'admin', '2022-01-19 13:49:52', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, 6, '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, 7, '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1031, '参数查询', 106, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1032, '参数新增', 106, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1033, '参数修改', 106, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1034, '参数删除', 106, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '参数导出', 106, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:operlog:export', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:logininfor:export', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, 7, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 115, 1, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 115, 3, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 115, 4, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 115, 5, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1061, '商品管理', 4, 3, 'product', 'goods/product/index', NULL, 1, 0, 'C', '0', '0', 'goods:product:list', '#', 'admin', '2022-01-22 16:15:37', '', NULL, '商品菜单');
INSERT INTO `sys_menu` VALUES (1062, '商品查询', 1061, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:product:query', '#', 'admin', '2022-01-22 16:15:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1063, '商品新增', 1061, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:product:add', '#', 'admin', '2022-01-22 16:15:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1064, '商品修改', 1061, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:product:edit', '#', 'admin', '2022-01-22 16:15:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1065, '商品删除', 1061, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:product:remove', '#', 'admin', '2022-01-22 16:15:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1066, '商品导出', 1061, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:product:export', '#', 'admin', '2022-01-22 16:15:37', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1072, '商品分类', 4, 2, 'category', 'goods/category/index', NULL, 1, 0, 'C', '0', '0', 'goods:category:list', '#', 'admin', '2022-01-24 11:48:34', '', NULL, '商品分类菜单');
INSERT INTO `sys_menu` VALUES (1073, '商品分类查询', 1072, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:category:query', '#', 'admin', '2022-01-24 11:48:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1074, '商品分类新增', 1072, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:category:add', '#', 'admin', '2022-01-24 11:48:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1075, '商品分类修改', 1072, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:category:edit', '#', 'admin', '2022-01-24 11:48:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1076, '商品分类删除', 1072, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:category:remove', '#', 'admin', '2022-01-24 11:48:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1077, '商品分类导出', 1072, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:category:export', '#', 'admin', '2022-01-24 11:48:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1078, '商品品牌', 4, 1, 'brand', 'goods/brand/index', NULL, 1, 0, 'C', '0', '0', 'goods:brand:list', '#', 'admin', '2022-01-27 14:26:49', '', NULL, '商品品牌菜单');
INSERT INTO `sys_menu` VALUES (1079, '商品品牌查询', 1078, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:brand:query', '#', 'admin', '2022-01-27 14:26:49', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1080, '商品品牌新增', 1078, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:brand:add', '#', 'admin', '2022-01-27 14:26:49', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1081, '商品品牌修改', 1078, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:brand:edit', '#', 'admin', '2022-01-27 14:26:49', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1082, '商品品牌删除', 1078, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:brand:remove', '#', 'admin', '2022-01-27 14:26:49', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1083, '商品品牌导出', 1078, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:brand:export', '#', 'admin', '2022-01-27 14:26:49', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1084, '商品规格', 4, 4, 'specification', 'goods/specification/index', NULL, 1, 0, 'C', '0', '0', 'goods:specification:list', '#', 'admin', '2022-02-12 14:05:10', '', NULL, '商品规格菜单');
INSERT INTO `sys_menu` VALUES (1085, '商品规格查询', 1084, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:specification:query', '#', 'admin', '2022-02-12 14:05:51', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1086, '商品规格新增', 1084, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:specification:add', '#', 'admin', '2022-02-12 14:05:51', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1087, '商品规格修改', 1084, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:specification:edit', '#', 'admin', '2022-02-12 14:05:51', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1088, '商品规格删除', 1084, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:specification:remove', '#', 'admin', '2022-02-12 14:05:51', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1089, '商品规格导出', 1084, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:specification:export', '#', 'admin', '2022-02-12 14:05:51', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1090, '仓库管理', 4, 5, 'warehouse', 'goods/warehouse/index', NULL, 1, 0, 'C', '0', '0', 'goods:warehouse:list', '#', 'admin', '2022-02-14 09:24:57', '', NULL, '仓库菜单');
INSERT INTO `sys_menu` VALUES (1091, '仓库查询', 1090, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:warehouse:query', '#', 'admin', '2022-02-14 09:24:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1092, '仓库新增', 1090, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:warehouse:add', '#', 'admin', '2022-02-14 09:24:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1093, '仓库修改', 1090, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:warehouse:edit', '#', 'admin', '2022-02-14 09:24:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1094, '仓库删除', 1090, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:warehouse:remove', '#', 'admin', '2022-02-14 09:24:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1095, '仓库导出', 1090, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:warehouse:export', '#', 'admin', '2022-02-14 09:24:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1096, '商品规格换算', 4, 6, 'proportion', 'goods/proportion/index', NULL, 1, 0, 'C', '0', '0', 'goods:proportion:list', '#', 'admin', '2022-02-15 10:15:34', '', NULL, '商品规格换算菜单');
INSERT INTO `sys_menu` VALUES (1097, '商品规格换算查询', 1096, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:proportion:query', '#', 'admin', '2022-02-15 10:15:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1098, '商品规格换算新增', 1096, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:proportion:add', '#', 'admin', '2022-02-15 10:15:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1099, '商品规格换算修改', 1096, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:proportion:edit', '#', 'admin', '2022-02-15 10:15:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1100, '商品规格换算删除', 1096, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:proportion:remove', '#', 'admin', '2022-02-15 10:15:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1101, '商品规格换算导出', 1096, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:proportion:export', '#', 'admin', '2022-02-15 10:15:34', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1102, '物流拒收配置', 4, 7, 'config', 'goods/config/index', NULL, 1, 0, 'C', '0', '0', 'goods:config:list', '#', 'admin', '2022-02-15 16:54:32', '', NULL, '物流拒收配置菜单');
INSERT INTO `sys_menu` VALUES (1103, '物流拒收配置查询', 1102, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:config:query', '#', 'admin', '2022-02-15 16:54:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1104, '物流拒收配置新增', 1102, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:config:add', '#', 'admin', '2022-02-15 16:54:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1105, '物流拒收配置修改', 1102, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:config:edit', '#', 'admin', '2022-02-15 16:54:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1106, '物流拒收配置删除', 1102, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:config:remove', '#', 'admin', '2022-02-15 16:54:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1107, '物流拒收配置导出', 1102, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:config:export', '#', 'admin', '2022-02-15 16:54:32', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1108, '配送方式', 4, 8, 'method', 'goods/method/index', NULL, 1, 0, 'C', '0', '0', 'goods:method:list', '#', 'admin', '2022-02-15 18:01:53', '', NULL, '配送方式菜单');
INSERT INTO `sys_menu` VALUES (1109, '配送方式查询', 1108, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:method:query', '#', 'admin', '2022-02-15 18:01:53', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1110, '配送方式新增', 1108, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:method:add', '#', 'admin', '2022-02-15 18:01:53', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1111, '配送方式修改', 1108, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:method:edit', '#', 'admin', '2022-02-15 18:01:53', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1112, '配送方式删除', 1108, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:method:remove', '#', 'admin', '2022-02-15 18:01:53', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1113, '配送方式导出', 1108, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:method:export', '#', 'admin', '2022-02-15 18:01:53', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1114, '商品标签', 4, 9, 'label', 'goods/label/index', NULL, 1, 0, 'C', '0', '0', 'goods:label:list', '#', 'admin', '2022-02-16 11:55:17', '', NULL, '商品标签菜单');
INSERT INTO `sys_menu` VALUES (1115, '商品标签查询', 1114, 1, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:label:query', '#', 'admin', '2022-02-16 11:55:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1116, '商品标签新增', 1114, 2, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:label:add', '#', 'admin', '2022-02-16 11:55:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1117, '商品标签修改', 1114, 3, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:label:edit', '#', 'admin', '2022-02-16 11:55:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1118, '商品标签删除', 1114, 4, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:label:remove', '#', 'admin', '2022-02-16 11:55:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1119, '商品标签导出', 1114, 5, '#', '', NULL, 1, 0, 'F', '0', '0', 'goods:label:export', '#', 'admin', '2022-02-16 11:55:17', '', NULL, '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '温馨提醒：2018-07-01 若依新版本发布啦', '2', 0xE696B0E78988E69CACE58685E5AEB9, '0', 'admin', '2022-01-19 13:49:52', '', NULL, '管理员');
INSERT INTO `sys_notice` VALUES (2, '维护通知：2018-07-01 若依系统凌晨维护', '1', 0xE7BBB4E68AA4E58685E5AEB9, '0', 'admin', '2022-01-19 13:49:52', '', NULL, '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (1, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_product', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-22 11:00:56');
INSERT INTO `sys_oper_log` VALUES (2, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-01-22 11:44:53');
INSERT INTO `sys_oper_log` VALUES (3, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-01-22 11:48:01');
INSERT INTO `sys_oper_log` VALUES (4, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-01-22 11:50:24');
INSERT INTO `sys_oper_log` VALUES (5, '商品', 2, 'com.ruoyi.system.controller.TProductController.edit()', 'PUT', 1, 'admin', NULL, '/product', '127.0.0.1', '', '{\"marketPrice\":1,\"productName\":\"商品名字\",\"sales\":0,\"specificationItems\":\"2\",\"productCategoryId\":1,\"price\":13,\"vipPrice\":23,\"id\":1,\"sn\":\"233\",\"productType\":2,\"parameterValues\":\"2\",\"image\":\"1\",\"isMarketable\":1,\"shippingMethodId\":3,\"updateTime\":1642843934563,\"sort\":0,\"params\":{},\"version\":0,\"productImages\":\"1\",\"createTime\":1642842464000,\"warehouseId\":3,\"brandId\":1,\"isDel\":0,\"projectId\":3}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-22 17:32:14');
INSERT INTO `sys_oper_log` VALUES (6, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_product_category', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-24 11:20:41');
INSERT INTO `sys_oper_log` VALUES (7, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-01-24 11:26:07');
INSERT INTO `sys_oper_log` VALUES (8, '代码生成', 3, 'com.ruoyi.gen.controller.GenController.remove()', 'DELETE', 1, 'admin', NULL, '/gen/2', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-24 14:20:03');
INSERT INTO `sys_oper_log` VALUES (9, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_product_category', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-24 14:20:15');
INSERT INTO `sys_oper_log` VALUES (10, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-01-24 14:20:31');
INSERT INTO `sys_oper_log` VALUES (11, '商品分类', 1, 'com.ruoyi.system.controller.TProductCategoryController.add()', 'POST', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":3,\"params\":{},\"categoryName\":\"金奖陆号\",\"parentId\":104,\"children\":[],\"createTime\":1643097452666,\"categoryId\":106,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-25 15:57:32');
INSERT INTO `sys_oper_log` VALUES (12, '商品分类', 3, 'com.ruoyi.system.controller.TProductCategoryController.remove()', 'DELETE', 1, 'admin', NULL, '/category/106', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-25 15:57:44');
INSERT INTO `sys_oper_log` VALUES (13, '商品分类', 1, 'com.ruoyi.system.controller.TProductCategoryController.add()', 'POST', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":3,\"params\":{},\"categoryName\":\"金奖陆号\",\"parentId\":101,\"children\":[],\"createTime\":1643097487847,\"categoryId\":107,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-25 15:58:07');
INSERT INTO `sys_oper_log` VALUES (14, '商品分类', 1, 'com.ruoyi.system.controller.TProductCategoryController.add()', 'POST', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":4,\"params\":{},\"categoryName\":\"茅祖壹号\",\"parentId\":101,\"children\":[],\"createTime\":1643097512786,\"categoryId\":108,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-25 15:58:32');
INSERT INTO `sys_oper_log` VALUES (15, '商品分类', 1, 'com.ruoyi.system.controller.TProductCategoryController.add()', 'POST', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":1,\"params\":{},\"categoryName\":\"绿袍关羽\",\"parentId\":102,\"children\":[],\"createTime\":1643097550785,\"categoryId\":109,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-25 15:59:10');
INSERT INTO `sys_oper_log` VALUES (16, '商品分类', 1, 'com.ruoyi.system.controller.TProductCategoryController.add()', 'POST', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":2,\"params\":{},\"categoryName\":\"红袍关羽\",\"parentId\":102,\"children\":[],\"createTime\":1643097566345,\"categoryId\":110,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-25 15:59:26');
INSERT INTO `sys_oper_log` VALUES (17, '商品分类', 1, 'com.ruoyi.system.controller.TProductCategoryController.add()', 'POST', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":1,\"params\":{},\"categoryName\":\"乾吉烧坊\",\"parentId\":103,\"children\":[],\"createTime\":1643097585146,\"categoryId\":111,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-25 15:59:45');
INSERT INTO `sys_oper_log` VALUES (18, '部门管理', 1, 'com.ruoyi.system.controller.SysDeptController.add()', 'POST', 1, 'admin', NULL, '/dept', '127.0.0.1', '', '{\"deptName\":\"技术部\",\"leader\":\"你\",\"orderNum\":\"6\",\"params\":{},\"parentId\":101,\"createBy\":\"admin\",\"children\":[],\"ancestors\":\"0,100,101\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-25 16:01:31');
INSERT INTO `sys_oper_log` VALUES (19, '商品分类', 1, 'com.ruoyi.system.controller.TProductCategoryController.add()', 'POST', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":5,\"params\":{},\"categoryName\":\"茅祖壹号\",\"parentId\":101,\"children\":[],\"status\":\"0\"}', '{\"msg\":\"新增部门\'茅祖壹号\'失败，部门名称已存在\",\"code\":500}', 0, NULL, '2022-01-25 16:35:51');
INSERT INTO `sys_oper_log` VALUES (20, '商品分类', 1, 'com.ruoyi.system.controller.TProductCategoryController.add()', 'POST', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":5,\"params\":{},\"categoryName\":\"茅祖壹号\",\"parentId\":101,\"children\":[],\"status\":\"0\"}', '{\"msg\":\"新增部门\'茅祖壹号\'失败，部门名称已存在\",\"code\":500}', 0, NULL, '2022-01-25 16:35:55');
INSERT INTO `sys_oper_log` VALUES (21, '部门管理', 2, 'com.ruoyi.system.controller.SysDeptController.edit()', 'PUT', 1, 'admin', NULL, '/dept', '127.0.0.1', '', '{\"deptName\":\"技术部2\",\"leader\":\"若依\",\"deptId\":110,\"orderNum\":\"6\",\"delFlag\":\"0\",\"params\":{},\"parentId\":101,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643097691000,\"phone\":\"15888888888\",\"updateBy\":\"admin\",\"ancestors\":\"0,100,101\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-26 09:22:04');
INSERT INTO `sys_oper_log` VALUES (22, '商品分类', 1, 'com.ruoyi.system.controller.TProductCategoryController.add()', 'POST', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":5,\"params\":{},\"categoryName\":\"茅祖红标\",\"parentId\":101,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643160455183,\"categoryId\":112,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-26 09:27:35');
INSERT INTO `sys_oper_log` VALUES (23, '部门管理', 1, 'com.ruoyi.system.controller.SysDeptController.add()', 'POST', 1, 'admin', NULL, '/dept', '127.0.0.1', '', '{\"deptName\":\"技术部\",\"leader\":\"admin\",\"orderNum\":\"6\",\"params\":{},\"parentId\":101,\"createBy\":\"admin\",\"children\":[],\"phone\":\"15088888888\",\"ancestors\":\"0,100,101\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-26 09:29:05');
INSERT INTO `sys_oper_log` VALUES (24, '部门管理', 3, 'com.ruoyi.system.controller.SysDeptController.remove()', 'DELETE', 1, 'admin', NULL, '/dept/110', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-26 09:52:39');
INSERT INTO `sys_oper_log` VALUES (25, '部门管理', 1, 'com.ruoyi.system.controller.SysDeptController.add()', 'POST', 1, 'admin', NULL, '/dept', '127.0.0.1', '', '{\"deptName\":\"技术3\",\"orderNum\":\"7\",\"params\":{},\"parentId\":101,\"createBy\":\"admin\",\"children\":[],\"ancestors\":\"0,100,101\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-26 09:55:45');
INSERT INTO `sys_oper_log` VALUES (26, '商品分类', 1, 'com.ruoyi.system.controller.TProductCategoryController.add()', 'POST', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":6,\"params\":{},\"categoryName\":\"茅祖红标\",\"parentId\":101,\"children\":[],\"status\":\"0\"}', '{\"msg\":\"新增分类\'茅祖红标\'失败，分类名称已存在\",\"code\":500}', 0, NULL, '2022-01-26 10:09:50');
INSERT INTO `sys_oper_log` VALUES (27, '部门管理', 2, 'com.ruoyi.system.controller.SysDeptController.edit()', 'PUT', 1, 'admin', NULL, '/dept', '127.0.0.1', '', '{\"deptName\":\"技术部\",\"leader\":\"admin\",\"deptId\":111,\"orderNum\":\"6\",\"delFlag\":\"0\",\"params\":{},\"parentId\":102,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643160545000,\"phone\":\"15088888888\",\"updateBy\":\"admin\",\"ancestors\":\"0,100,102\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-26 10:13:15');
INSERT INTO `sys_oper_log` VALUES (28, '商品分类', 2, 'com.ruoyi.system.controller.TProductCategoryController.edit()', 'PUT', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":5,\"updateTime\":1643163467031,\"delFlag\":\"0\",\"params\":{},\"categoryName\":\"茅祖红标\",\"parentId\":101,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643160455000,\"updateBy\":\"admin\",\"ancestors\":\"\",\"categoryId\":112,\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-26 10:17:47');
INSERT INTO `sys_oper_log` VALUES (29, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_product_brand', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 10:58:18');
INSERT INTO `sys_oper_log` VALUES (30, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-01-27 10:59:07');
INSERT INTO `sys_oper_log` VALUES (31, '商品分类', 2, 'com.ruoyi.system.controller.TProductCategoryController.edit()', 'PUT', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":1,\"updateTime\":1643266388385,\"delFlag\":\"0\",\"params\":{},\"categoryName\":\"酱香\",\"parentId\":100,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643007603000,\"updateBy\":\"admin\",\"ancestors\":\"0,100\",\"categoryId\":101,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:53:08');
INSERT INTO `sys_oper_log` VALUES (32, '商品分类', 2, 'com.ruoyi.system.controller.TProductCategoryController.edit()', 'PUT', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":2,\"updateTime\":1643266445191,\"delFlag\":\"0\",\"params\":{},\"categoryName\":\"清香\",\"parentId\":100,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643007610000,\"updateBy\":\"admin\",\"ancestors\":\"0,100\",\"categoryId\":102,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:54:05');
INSERT INTO `sys_oper_log` VALUES (33, '商品分类', 2, 'com.ruoyi.system.controller.TProductCategoryController.edit()', 'PUT', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":3,\"updateTime\":1643266475801,\"delFlag\":\"0\",\"params\":{},\"categoryName\":\"浓香\",\"parentId\":100,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643007616000,\"updateBy\":\"admin\",\"ancestors\":\"0,100\",\"categoryId\":103,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:54:35');
INSERT INTO `sys_oper_log` VALUES (34, '商品分类', 2, 'com.ruoyi.system.controller.TProductCategoryController.edit()', 'PUT', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":1,\"updateTime\":1643266503725,\"delFlag\":\"0\",\"params\":{},\"categoryName\":\"酱香1\",\"parentId\":101,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643007757000,\"updateBy\":\"admin\",\"ancestors\":\"0,100,101\",\"categoryId\":104,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:55:03');
INSERT INTO `sys_oper_log` VALUES (35, '商品分类', 2, 'com.ruoyi.system.controller.TProductCategoryController.edit()', 'PUT', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":2,\"updateTime\":1643266509861,\"delFlag\":\"0\",\"params\":{},\"categoryName\":\"酱香2\",\"parentId\":101,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643007762000,\"updateBy\":\"admin\",\"ancestors\":\"0,100,101\",\"categoryId\":105,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:55:09');
INSERT INTO `sys_oper_log` VALUES (36, '商品分类', 2, 'com.ruoyi.system.controller.TProductCategoryController.edit()', 'PUT', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":1,\"updateTime\":1643266521533,\"delFlag\":\"0\",\"params\":{},\"categoryName\":\"清香1\",\"parentId\":102,\"createBy\":\"\",\"children\":[],\"createTime\":1643097551000,\"updateBy\":\"admin\",\"ancestors\":\"\",\"categoryId\":109,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:55:21');
INSERT INTO `sys_oper_log` VALUES (37, '商品分类', 2, 'com.ruoyi.system.controller.TProductCategoryController.edit()', 'PUT', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":2,\"updateTime\":1643266528693,\"delFlag\":\"0\",\"params\":{},\"categoryName\":\"清香2\",\"parentId\":102,\"createBy\":\"\",\"children\":[],\"createTime\":1643097566000,\"updateBy\":\"admin\",\"ancestors\":\"\",\"categoryId\":110,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:55:28');
INSERT INTO `sys_oper_log` VALUES (38, '商品分类', 2, 'com.ruoyi.system.controller.TProductCategoryController.edit()', 'PUT', 1, 'admin', NULL, '/category', '127.0.0.1', '', '{\"orderNum\":1,\"updateTime\":1643266544960,\"delFlag\":\"0\",\"params\":{},\"categoryName\":\"浓香1\",\"parentId\":103,\"createBy\":\"\",\"children\":[],\"createTime\":1643097585000,\"updateBy\":\"admin\",\"ancestors\":\"\",\"categoryId\":111,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:55:44');
INSERT INTO `sys_oper_log` VALUES (39, '商品品牌', 1, 'com.ruoyi.system.controller.TProductBrandController.add()', 'POST', 1, 'admin', NULL, '/brand', '127.0.0.1', '', '{\"brandName\":\"绿袍关羽\",\"params\":{},\"parentId\":102,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643266660574,\"brandId\":106,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:57:40');
INSERT INTO `sys_oper_log` VALUES (40, '商品品牌', 1, 'com.ruoyi.system.controller.TProductBrandController.add()', 'POST', 1, 'admin', NULL, '/brand', '127.0.0.1', '', '{\"brandName\":\"红袍关羽\",\"params\":{},\"parentId\":102,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643266676044,\"brandId\":107,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:57:56');
INSERT INTO `sys_oper_log` VALUES (41, '商品品牌', 1, 'com.ruoyi.system.controller.TProductBrandController.add()', 'POST', 1, 'admin', NULL, '/brand', '127.0.0.1', '', '{\"brandName\":\"乾吉烧坊\",\"params\":{},\"parentId\":103,\"createBy\":\"admin\",\"children\":[],\"createTime\":1643266690919,\"brandId\":108,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-01-27 14:58:10');
INSERT INTO `sys_oper_log` VALUES (42, '商品', 2, 'com.ruoyi.system.controller.TProductController.edit()', 'PUT', 1, 'admin', NULL, '/product', '127.0.0.1', '', '{\"marketPrice\":2,\"productName\":\"商品名字2\",\"sales\":0,\"productCategoryId\":2,\"price\":14,\"vipPrice\":13,\"id\":2,\"sn\":\"234\",\"introduction\":\"富国天惠\",\"productType\":2,\"image\":\"2\",\"isMarketable\":1,\"shippingMethodId\":3,\"updateTime\":1644375518206,\"sort\":0,\"params\":{},\"version\":0,\"productImages\":\"2\",\"unit\":\"光听\",\"createTime\":1644375199000,\"warehouseId\":4,\"brandId\":5,\"isDel\":0,\"projectId\":4}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-09 10:58:38');
INSERT INTO `sys_oper_log` VALUES (43, '商品管理', 2, 'com.ruoyi.system.controller.TProductController.changeProductStatus()', 'PUT', 1, 'admin', NULL, '/product/changeProductStatus', '127.0.0.1', '', '{\"updateBy\":\"admin\",\"id\":2,\"isMarketable\":1,\"params\":{}}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-09 11:53:55');
INSERT INTO `sys_oper_log` VALUES (44, '商品管理', 2, 'com.ruoyi.system.controller.TProductController.changeProductStatus()', 'PUT', 1, 'admin', NULL, '/product/changeProductStatus', '127.0.0.1', '', '{\"updateBy\":\"admin\",\"id\":2,\"isMarketable\":1,\"params\":{}}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-09 11:54:52');
INSERT INTO `sys_oper_log` VALUES (45, '用户管理', 2, 'com.ruoyi.system.controller.SysUserController.changeStatus()', 'PUT', 1, 'admin', NULL, '/user/changeStatus', '127.0.0.1', '', '{\"admin\":false,\"updateBy\":\"admin\",\"params\":{},\"userId\":2,\"status\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-09 13:45:40');
INSERT INTO `sys_oper_log` VALUES (46, '用户管理', 2, 'com.ruoyi.system.controller.SysUserController.changeStatus()', 'PUT', 1, 'admin', NULL, '/user/changeStatus', '127.0.0.1', '', '{\"admin\":false,\"updateBy\":\"admin\",\"params\":{},\"userId\":2,\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-09 13:45:49');
INSERT INTO `sys_oper_log` VALUES (47, '商品', 2, 'com.ruoyi.system.controller.TProductController.edit()', 'PUT', 1, 'admin', NULL, '/product', '127.0.0.1', '', '{\"marketPrice\":2,\"productName\":\"商品名字2\",\"sales\":0,\"productCategoryId\":2,\"price\":144,\"vipPrice\":133,\"id\":2,\"sn\":\"234\",\"introduction\":\"富国天惠\",\"productType\":2,\"image\":\"2\",\"isMarketable\":2,\"shippingMethodId\":3,\"updateTime\":1644387707464,\"sort\":0,\"params\":{},\"version\":0,\"productImages\":\"2\",\"unit\":\"光听\",\"createTime\":1644375199000,\"warehouseId\":4,\"brandId\":101,\"isDel\":0,\"projectId\":4}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-09 14:21:47');
INSERT INTO `sys_oper_log` VALUES (48, '商品', 2, 'com.ruoyi.system.controller.TProductController.edit()', 'PUT', 1, 'admin', NULL, '/product', '127.0.0.1', '', '{\"marketPrice\":2,\"seoTitle\":\"5\",\"productName\":\"商品名字2\",\"sales\":0,\"productCategoryId\":25,\"price\":1445,\"vipPrice\":1335,\"id\":2,\"sn\":\"234\",\"introduction\":\"富国天惠\",\"productType\":2,\"image\":\"2\",\"isMarketable\":2,\"shippingMethodId\":3,\"updateTime\":1644454109981,\"sort\":5,\"params\":{},\"version\":0,\"productImages\":\"2\",\"unit\":\"光听\",\"createTime\":1644375199000,\"warehouseId\":4,\"brandId\":101,\"isDel\":0,\"projectId\":4}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-10 08:48:30');
INSERT INTO `sys_oper_log` VALUES (49, '商品管理', 2, 'com.ruoyi.system.controller.TProductController.changeProductStatus()', 'PUT', 1, 'admin', NULL, '/product/changeProductStatus', '127.0.0.1', '', '{\"updateBy\":\"admin\",\"id\":2,\"isMarketable\":1,\"params\":{}}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-10 08:48:49');
INSERT INTO `sys_oper_log` VALUES (50, '商品', 1, 'com.ruoyi.system.controller.TProductController.add()', 'POST', 1, 'admin', NULL, '/product', '127.0.0.1', '', '{\"marketPrice\":6,\"caption\":\"6\",\"memo\":\"6\",\"seoTitle\":\"6\",\"productName\":\"商品3\",\"sales\":6,\"productCategoryId\":6,\"price\":6,\"vipPrice\":6,\"id\":3,\"sn\":\"333\",\"keyword\":\"6\",\"introduction\":\"6\",\"productType\":1,\"image\":\"http://image.jpg\",\"isMarketable\":1,\"shippingMethodId\":6,\"sort\":6,\"params\":{},\"version\":6,\"unit\":\"6\",\"createTime\":1644457553852,\"warehouseId\":6,\"brandId\":6,\"isDel\":1,\"projectId\":6}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-10 09:45:54');
INSERT INTO `sys_oper_log` VALUES (51, '商品', 3, 'com.ruoyi.system.controller.TProductController.remove()', 'DELETE', 1, 'admin', NULL, '/product/5', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-10 09:50:26');
INSERT INTO `sys_oper_log` VALUES (52, '商品', 2, 'com.ruoyi.system.controller.TProductController.edit()', 'PUT', 1, 'admin', NULL, '/product', '127.0.0.1', '', '{\"marketPrice\":2,\"seoTitle\":\"5\",\"productName\":\"商品名字2\",\"sales\":0,\"productCategoryId\":25,\"price\":1445,\"vipPrice\":1335,\"id\":2,\"sn\":\"234\",\"introduction\":\"富国天惠\",\"productType\":2,\"image\":\"https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png,http://127.0.0.1:9300/statics/2022/02/10/22130a77-3628-4635-96bc-d8a3dd6f2124.png\",\"isMarketable\":1,\"shippingMethodId\":3,\"updateTime\":1644463637523,\"sort\":5,\"params\":{},\"version\":0,\"productImages\":\"2\",\"unit\":\"光听\",\"createTime\":1644375199000,\"warehouseId\":4,\"brandId\":101,\"isDel\":0,\"projectId\":4}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-10 11:27:17');
INSERT INTO `sys_oper_log` VALUES (53, '商品', 2, 'com.ruoyi.system.controller.TProductController.edit()', 'PUT', 1, 'admin', NULL, '/product', '127.0.0.1', '', '{\"marketPrice\":6,\"caption\":\"6\",\"memo\":\"6\",\"seoTitle\":\"6\",\"productName\":\"商品3\",\"sales\":6,\"productCategoryId\":6,\"price\":6,\"vipPrice\":6,\"id\":3,\"sn\":\"333\",\"keyword\":\"6\",\"introduction\":\"6\",\"productType\":1,\"image\":\"https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png,http://127.0.0.1:9300/statics/2022/02/10/3e51a1de-7b27-4e81-aa37-eb515dada8c4.png\",\"isMarketable\":1,\"shippingMethodId\":6,\"updateTime\":1644464463908,\"sort\":6,\"params\":{},\"version\":6,\"unit\":\"6\",\"createTime\":1644457554000,\"warehouseId\":6,\"brandId\":6,\"isDel\":1,\"projectId\":6}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-10 11:41:04');
INSERT INTO `sys_oper_log` VALUES (54, '代码生成', 3, 'com.ruoyi.gen.controller.GenController.remove()', 'DELETE', 1, 'admin', NULL, '/gen/1,3,4', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-11 14:02:54');
INSERT INTO `sys_oper_log` VALUES (55, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_product', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-11 14:03:11');
INSERT INTO `sys_oper_log` VALUES (56, '代码生成', 3, 'com.ruoyi.gen.controller.GenController.remove()', 'DELETE', 1, 'admin', NULL, '/gen/5', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-11 17:59:11');
INSERT INTO `sys_oper_log` VALUES (57, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_product_brand', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-11 17:59:17');
INSERT INTO `sys_oper_log` VALUES (58, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-11 17:59:42');
INSERT INTO `sys_oper_log` VALUES (59, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-11 18:00:04');
INSERT INTO `sys_oper_log` VALUES (60, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_product', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 09:33:56');
INSERT INTO `sys_oper_log` VALUES (61, '商品品牌', 1, 'com.ruoyi.goods.controller.TProductBrandController.add()', 'POST', 1, 'admin', NULL, '/brand', '127.0.0.1', '', '{\"brandName\":\"金奖四号\",\"params\":{},\"parentId\":104,\"children\":[],\"logo\":\"http://127.0.0.1:9300/statics/2022/02/12/4fbf1bca-b89f-45e4-900b-2f050e1dd2f7.png\",\"sortNum\":3,\"introduction\":\"金奖四号品牌介绍\",\"status\":\"0\"}', NULL, 1, 'Invalid bound statement (not found): com.ruoyi.goods.mapper.TProductBrandMapper.checkBrandNameUnique', '2022-02-12 10:00:33');
INSERT INTO `sys_oper_log` VALUES (62, '商品品牌', 1, 'com.ruoyi.goods.controller.TProductBrandController.add()', 'POST', 1, 'admin', NULL, '/brand', '127.0.0.1', '', '{\"brandName\":\"金奖四号\",\"params\":{},\"parentId\":101,\"createBy\":\"admin\",\"children\":[],\"createTime\":1644631595624,\"brandId\":109,\"logo\":\"http://127.0.0.1:9300/statics/2022/02/12/8c792989-711d-42a6-bdb5-fecaa103acd0.png\",\"sortNum\":3,\"introduction\":\"介绍\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 10:06:35');
INSERT INTO `sys_oper_log` VALUES (63, '商品品牌', 2, 'com.ruoyi.goods.controller.TProductBrandController.edit()', 'PUT', 1, 'admin', NULL, '/brand', '127.0.0.1', '', '{\"brandName\":\"金奖四号\",\"updateTime\":1644631612789,\"delFlag\":\"0\",\"params\":{},\"parentId\":101,\"createBy\":\"admin\",\"children\":[],\"createTime\":1644631596000,\"updateBy\":\"admin\",\"brandId\":109,\"logo\":\"http://127.0.0.1:9300/statics/2022/02/12/8c792989-711d-42a6-bdb5-fecaa103acd0.png\",\"sortNum\":3,\"ancestors\":\"\",\"introduction\":\"金奖四号介绍\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 10:06:52');
INSERT INTO `sys_oper_log` VALUES (64, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_sku', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 10:42:55');
INSERT INTO `sys_oper_log` VALUES (65, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-12 10:46:28');
INSERT INTO `sys_oper_log` VALUES (66, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_specification', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 13:59:18');
INSERT INTO `sys_oper_log` VALUES (67, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-12 13:59:36');
INSERT INTO `sys_oper_log` VALUES (68, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-12 14:00:09');
INSERT INTO `sys_oper_log` VALUES (69, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":1,\"params\":{},\"version\":1,\"productCategoryId\":1,\"createTime\":1644646063486,\"name\":\"白酒规格\"}', NULL, 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'options\' doesn\'t have a default value\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TSpecificationMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TSpecificationMapper.insertTSpecification-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_specification          ( name,                          product_category_id,             sort,             create_time,                          version )           values ( ?,                          ?,             ?,             ?,                          ? )\r\n### Cause: java.sql.SQLException: Field \'options\' doesn\'t have a default value\n; Field \'options\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'options\' doesn\'t have a default value', '2022-02-12 14:07:43');
INSERT INTO `sys_oper_log` VALUES (70, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":1,\"params\":{},\"version\":1,\"productCategoryId\":1,\"createTime\":1644646174477,\"name\":\"白酒规格\"}', NULL, 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'options\' doesn\'t have a default value\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TSpecificationMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TSpecificationMapper.insertTSpecification-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_specification          ( name,                          product_category_id,             sort,             create_time,                          version )           values ( ?,                          ?,             ?,             ?,                          ? )\r\n### Cause: java.sql.SQLException: Field \'options\' doesn\'t have a default value\n; Field \'options\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'options\' doesn\'t have a default value', '2022-02-12 14:09:34');
INSERT INTO `sys_oper_log` VALUES (71, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":1,\"params\":{},\"productCategoryId\":1,\"createTime\":1644647990471,\"name\":\"白酒规格\",\"options\":\"1瓶装\"}', NULL, 1, '\r\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"The document root must not be followed by other values.\" at position 1 in value for column \'t_specification.options\'.\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TSpecificationMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TSpecificationMapper.insertTSpecification-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_specification          ( name,             options,             product_category_id,             sort,             create_time )           values ( ?,             ?,             ?,             ?,             ? )\r\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"The document root must not be followed by other values.\" at position 1 in value for column \'t_specification.options\'.\n; Data truncation: Invalid JSON text: \"The document root must not be followed by other values.\" at position 1 in value for column \'t_specification.options\'.; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"The document root must not be followed by other values.\" at position 1 in value for column \'t_specification.options\'.', '2022-02-12 14:39:50');
INSERT INTO `sys_oper_log` VALUES (72, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":1,\"params\":{},\"productCategoryId\":1,\"createTime\":1644648275998,\"name\":\"白酒规格\",\"options\":\"[1瓶装,2瓶装]\"}', NULL, 1, '\r\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"Missing a comma or \']\' after an array element.\" at position 2 in value for column \'t_specification.options\'.\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TSpecificationMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TSpecificationMapper.insertTSpecification-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_specification          ( name,             options,             product_category_id,             sort,             create_time )           values ( ?,             ?,             ?,             ?,             ? )\r\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"Missing a comma or \']\' after an array element.\" at position 2 in value for column \'t_specification.options\'.\n; Data truncation: Invalid JSON text: \"Missing a comma or \']\' after an array element.\" at position 2 in value for column \'t_specification.options\'.; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"Missing a comma or \']\' after an array element.\" at position 2 in value for column \'t_specification.options\'.', '2022-02-12 14:44:36');
INSERT INTO `sys_oper_log` VALUES (73, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":1,\"params\":{},\"productCategoryId\":1,\"createTime\":1644648391530,\"name\":\"白酒规格\",\"options\":\"{1瓶装,2瓶装}\"}', NULL, 1, '\r\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"Missing a name for object member.\" at position 1 in value for column \'t_specification.options\'.\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TSpecificationMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TSpecificationMapper.insertTSpecification-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_specification          ( name,             options,             product_category_id,             sort,             create_time )           values ( ?,             ?,             ?,             ?,             ? )\r\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"Missing a name for object member.\" at position 1 in value for column \'t_specification.options\'.\n; Data truncation: Invalid JSON text: \"Missing a name for object member.\" at position 1 in value for column \'t_specification.options\'.; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"Missing a name for object member.\" at position 1 in value for column \'t_specification.options\'.', '2022-02-12 14:46:31');
INSERT INTO `sys_oper_log` VALUES (74, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":1,\"params\":{},\"productCategoryId\":1,\"createTime\":1644648639790,\"name\":\"白酒规格\",\"options\":\"[\'1瓶装\',\'2瓶装\']\"}', NULL, 1, '\r\n### Error updating database.  Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"Invalid value.\" at position 1 in value for column \'t_specification.options\'.\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TSpecificationMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TSpecificationMapper.insertTSpecification-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_specification          ( name,             options,             product_category_id,             sort,             create_time )           values ( ?,             ?,             ?,             ?,             ? )\r\n### Cause: com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"Invalid value.\" at position 1 in value for column \'t_specification.options\'.\n; Data truncation: Invalid JSON text: \"Invalid value.\" at position 1 in value for column \'t_specification.options\'.; nested exception is com.mysql.cj.jdbc.exceptions.MysqlDataTruncation: Data truncation: Invalid JSON text: \"Invalid value.\" at position 1 in value for column \'t_specification.options\'.', '2022-02-12 14:50:40');
INSERT INTO `sys_oper_log` VALUES (75, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":1,\"params\":{},\"productCategoryId\":1,\"createTime\":1644649407525,\"name\":\"白酒规格\",\"options\":\"[\\\"1瓶装\\\",\\\"2瓶装\\\"]\",\"id\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 15:03:27');
INSERT INTO `sys_oper_log` VALUES (76, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":2,\"params\":{},\"productCategoryId\":2,\"createTime\":1644649564235,\"name\":\"红酒规格\",\"options\":\"[\\\"1瓶装\\\",\\\"2瓶装\\\"]\",\"id\":2}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 15:06:04');
INSERT INTO `sys_oper_log` VALUES (77, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":5,\"params\":{},\"productCategoryId\":5,\"createTime\":1644649582794,\"name\":\"5\",\"options\":\"[\\\"1瓶装\\\",\\\"2瓶装\\\"]\",\"id\":3}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 15:06:22');
INSERT INTO `sys_oper_log` VALUES (78, '商品规格', 2, 'com.ruoyi.goods.controller.TSpecificationController.edit()', 'PUT', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"updateTime\":1644649589735,\"sort\":56,\"params\":{},\"version\":0,\"productCategoryId\":56,\"createTime\":1644649583000,\"name\":\"56\",\"options\":\"[\\\"1瓶装\\\", \\\"2瓶装\\\"]\",\"id\":3}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 15:06:29');
INSERT INTO `sys_oper_log` VALUES (79, '商品规格', 3, 'com.ruoyi.goods.controller.TSpecificationController.remove()', 'DELETE', 1, 'admin', NULL, '/specification/3', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 15:06:36');
INSERT INTO `sys_oper_log` VALUES (80, '商品规格', 2, 'com.ruoyi.goods.controller.TSpecificationController.edit()', 'PUT', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"updateTime\":1644650462799,\"sort\":2,\"params\":{},\"version\":0,\"productCategoryId\":2,\"createTime\":1644649564000,\"name\":\"红酒规格\",\"options\":\"[\\\"1瓶装\\\", \\\"2瓶装\\\"]\",\"id\":2}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 15:21:02');
INSERT INTO `sys_oper_log` VALUES (81, '商品规格', 2, 'com.ruoyi.goods.controller.TSpecificationController.edit()', 'PUT', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"updateTime\":1644650482283,\"sort\":2,\"params\":{},\"version\":0,\"productCategoryId\":2,\"createTime\":1644649564000,\"name\":\"红酒规格\",\"options\":\"[\\\"1瓶装\\\", \\\"2瓶装\\\",\\\"3瓶装\\\"]\",\"id\":2}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 15:21:22');
INSERT INTO `sys_oper_log` VALUES (82, '商品规格', 5, 'com.ruoyi.goods.controller.TSpecificationController.export()', 'POST', 1, 'admin', NULL, '/specification/export', '127.0.0.1', '', '{\"params\":{}}', NULL, 0, NULL, '2022-02-12 15:21:43');
INSERT INTO `sys_oper_log` VALUES (83, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":6,\"params\":{},\"productCategoryId\":6,\"createTime\":1644652865130,\"name\":\"6\",\"options\":\"[\\\"1瓶装\\\",\\\"2瓶装\\\"]\",\"id\":4}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 16:01:05');
INSERT INTO `sys_oper_log` VALUES (84, '商品规格', 1, 'com.ruoyi.goods.controller.TSpecificationController.add()', 'POST', 1, 'admin', NULL, '/specification', '127.0.0.1', '', '{\"sort\":5,\"params\":{},\"productCategoryId\":5,\"createTime\":1644653075107,\"name\":\"5\",\"options\":\"[\\\"1瓶装\\\",\\\"2瓶装\\\"]\",\"id\":5}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 16:04:35');
INSERT INTO `sys_oper_log` VALUES (85, '商品规格', 3, 'com.ruoyi.goods.controller.TSpecificationController.remove()', 'DELETE', 1, 'admin', NULL, '/specification/5', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 16:04:41');
INSERT INTO `sys_oper_log` VALUES (86, '商品规格', 3, 'com.ruoyi.goods.controller.TSpecificationController.remove()', 'DELETE', 1, 'admin', NULL, '/specification/4', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 16:05:06');
INSERT INTO `sys_oper_log` VALUES (87, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_warehouse', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-12 17:43:34');
INSERT INTO `sys_oper_log` VALUES (88, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-12 17:44:28');
INSERT INTO `sys_oper_log` VALUES (89, '仓库', 1, 'com.ruoyi.goods.controller.TWarehouseController.add()', 'POST', 1, 'admin', NULL, '/warehouse', '127.0.0.1', '', '{\"address\":\"郑州市金水区\",\"memo\":\"把这\",\"params\":{},\"warehouseName\":\"郑州仓库\",\"isDefault\":0,\"createTime\":1644818641769,\"phone\":\"15066666666\",\"contact\":\"若依\",\"appKey\":\"0\",\"appSecret\":\"0\",\"id\":1,\"state\":0,\"sysUserId\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-14 14:04:02');
INSERT INTO `sys_oper_log` VALUES (90, '仓库', 1, 'com.ruoyi.goods.controller.TWarehouseController.add()', 'POST', 1, 'admin', NULL, '/warehouse', '127.0.0.1', '', '{\"address\":\"2\",\"memo\":\"2\",\"params\":{},\"warehouseName\":\"2\",\"isDefault\":2,\"createTime\":1644818659376,\"phone\":\"2\",\"contact\":\"2\",\"appKey\":\"2\",\"appSecret\":\"2\",\"id\":2,\"state\":2,\"sysUserId\":2}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-14 14:04:19');
INSERT INTO `sys_oper_log` VALUES (91, '仓库', 2, 'com.ruoyi.goods.controller.TWarehouseController.edit()', 'PUT', 1, 'admin', NULL, '/warehouse', '127.0.0.1', '', '{\"address\":\"2\",\"memo\":\"2\",\"updateTime\":1644818679902,\"params\":{},\"version\":0,\"warehouseName\":\"白酒\",\"isDefault\":2,\"createTime\":1644818659000,\"phone\":\"2\",\"contact\":\"2\",\"appKey\":\"2\",\"appSecret\":\"2\",\"id\":2,\"state\":2,\"sysUserId\":2}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-14 14:04:39');
INSERT INTO `sys_oper_log` VALUES (92, '仓库', 3, 'com.ruoyi.goods.controller.TWarehouseController.remove()', 'DELETE', 1, 'admin', NULL, '/warehouse/2', '127.0.0.1', '', NULL, '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-14 14:04:45');
INSERT INTO `sys_oper_log` VALUES (93, '仓库', 1, 'com.ruoyi.goods.controller.TWarehouseController.add()', 'POST', 1, 'admin', NULL, '/warehouse', '127.0.0.1', '', '{\"params\":{},\"warehouseName\":\"5\",\"createTime\":1644818719664,\"id\":3,\"sysUserId\":5}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-14 14:05:19');
INSERT INTO `sys_oper_log` VALUES (94, '仓库', 2, 'com.ruoyi.goods.controller.TWarehouseController.edit()', 'PUT', 1, 'admin', NULL, '/warehouse', '127.0.0.1', '', '{\"address\":\"5\",\"memo\":\"5\",\"updateTime\":1644818733252,\"params\":{},\"version\":0,\"warehouseName\":\"5\",\"isDefault\":5,\"createTime\":1644818720000,\"phone\":\"5\",\"contact\":\"5\",\"appKey\":\"5\",\"appSecret\":\"5\",\"id\":3,\"state\":5,\"sysUserId\":5}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-14 14:05:33');
INSERT INTO `sys_oper_log` VALUES (95, '仓库', 2, 'com.ruoyi.goods.controller.TWarehouseController.edit()', 'PUT', 1, 'admin', NULL, '/warehouse', '127.0.0.1', '', '{\"address\":\"5\",\"memo\":\"5\",\"updateTime\":1644818919244,\"params\":{},\"version\":0,\"warehouseName\":\"上海仓库\",\"isDefault\":5,\"createTime\":1644818720000,\"phone\":\"15033333333\",\"contact\":\"5\",\"appKey\":\"5\",\"appSecret\":\"5\",\"id\":3,\"state\":5,\"sysUserId\":5}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-14 14:08:39');
INSERT INTO `sys_oper_log` VALUES (96, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_product_conversion_proportion', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-14 14:43:15');
INSERT INTO `sys_oper_log` VALUES (97, '仓库', 2, 'com.ruoyi.goods.controller.TWarehouseController.edit()', 'PUT', 1, 'admin', NULL, '/warehouse', '127.0.0.1', '', '{\"address\":\"5\",\"memo\":\"备注5\",\"updateTime\":1644889451026,\"params\":{},\"version\":0,\"warehouseName\":\"上海仓库\",\"isDefault\":5,\"createTime\":1644818720000,\"phone\":\"15033333333\",\"contact\":\"5\",\"appKey\":\"key\",\"appSecret\":\"seret5\",\"id\":3,\"state\":5,\"sysUserId\":5}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-15 09:44:11');
INSERT INTO `sys_oper_log` VALUES (98, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-15 10:07:24');
INSERT INTO `sys_oper_log` VALUES (99, '商品规格换算', 1, 'com.ruoyi.goods.controller.TProductConversionProportionController.add()', 'POST', 1, 'admin', NULL, '/proportion', '127.0.0.1', '', '{\"params\":{},\"conversionProportion\":1}', NULL, 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'specification_values\' doesn\'t have a default value\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TProductConversionProportionMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TProductConversionProportionMapper.insertTProductConversionProportion-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_product_conversion_proportion          ( conversion_proportion )           values ( ? )\r\n### Cause: java.sql.SQLException: Field \'specification_values\' doesn\'t have a default value\n; Field \'specification_values\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'specification_values\' doesn\'t have a default value', '2022-02-15 10:32:07');
INSERT INTO `sys_oper_log` VALUES (100, '商品规格换算', 1, 'com.ruoyi.goods.controller.TProductConversionProportionController.add()', 'POST', 1, 'admin', NULL, '/proportion', '127.0.0.1', '', '{\"specificationValues\":\"[\\\"1瓶装\\\", \\\"2瓶装\\\"]\",\"params\":{},\"conversionId\":2,\"conversionProportion\":3}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-15 15:44:59');
INSERT INTO `sys_oper_log` VALUES (101, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_shipping_method,t_shipping_reverse_config', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-15 16:43:38');
INSERT INTO `sys_oper_log` VALUES (102, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-15 16:44:04');
INSERT INTO `sys_oper_log` VALUES (103, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-15 16:44:17');
INSERT INTO `sys_oper_log` VALUES (104, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-15 16:44:53');
INSERT INTO `sys_oper_log` VALUES (105, '物流拒收配置', 1, 'com.ruoyi.goods.controller.TShippingReverseConfigController.add()', 'POST', 1, 'admin', NULL, '/config', '127.0.0.1', '', '{\"shippingId\":1,\"createTime\":1644918852892,\"params\":{},\"reverseStatus\":\"0\"}', NULL, 1, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1-0\' for key \'idx_shipping_delete\'\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TShippingReverseConfigMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TShippingReverseConfigMapper.insertTShippingReverseConfig-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_shipping_reverse_config          ( reverse_status,             shipping_id,             create_time )           values ( ?,             ?,             ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1-0\' for key \'idx_shipping_delete\'\n; Duplicate entry \'1-0\' for key \'idx_shipping_delete\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1-0\' for key \'idx_shipping_delete\'', '2022-02-15 17:54:13');
INSERT INTO `sys_oper_log` VALUES (106, '物流拒收配置', 1, 'com.ruoyi.goods.controller.TShippingReverseConfigController.add()', 'POST', 1, 'admin', NULL, '/config', '127.0.0.1', '', '{\"shippingId\":1,\"createTime\":1644918920560,\"params\":{},\"reverseStatus\":\"0\"}', NULL, 1, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1-0\' for key \'idx_shipping_delete\'\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TShippingReverseConfigMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TShippingReverseConfigMapper.insertTShippingReverseConfig-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_shipping_reverse_config          ( reverse_status,             shipping_id,             create_time )           values ( ?,             ?,             ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1-0\' for key \'idx_shipping_delete\'\n; Duplicate entry \'1-0\' for key \'idx_shipping_delete\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1-0\' for key \'idx_shipping_delete\'', '2022-02-15 17:55:20');
INSERT INTO `sys_oper_log` VALUES (107, '物流拒收配置', 1, 'com.ruoyi.goods.controller.TShippingReverseConfigController.add()', 'POST', 1, 'admin', NULL, '/config', '127.0.0.1', '', '{\"shippingId\":2,\"createTime\":1644918928770,\"reverseId\":4,\"params\":{},\"reverseStatus\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-15 17:55:28');
INSERT INTO `sys_oper_log` VALUES (108, '配送方式', 1, 'com.ruoyi.goods.controller.TShippingMethodController.add()', 'POST', 1, 'admin', NULL, '/method', '127.0.0.1', '', '{\"firstWeight\":1,\"defaultFirstPrice\":1,\"defaultContinuePrice\":1,\"description\":\"1\",\"params\":{},\"createTime\":1644976450008,\"continueWeight\":1,\"name\":\"中通\"}', NULL, 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'code\' doesn\'t have a default value\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TShippingMethodMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TShippingMethodMapper.insertTShippingMethod-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_shipping_method          ( name,             first_weight,             continue_weight,             default_first_price,             default_continue_price,             description,                                                    create_time )           values ( ?,             ?,             ?,             ?,             ?,             ?,                                                    ? )\r\n### Cause: java.sql.SQLException: Field \'code\' doesn\'t have a default value\n; Field \'code\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'code\' doesn\'t have a default value', '2022-02-16 09:54:10');
INSERT INTO `sys_oper_log` VALUES (109, '配送方式', 1, 'com.ruoyi.goods.controller.TShippingMethodController.add()', 'POST', 1, 'admin', NULL, '/method', '127.0.0.1', '', '{\"firstWeight\":1,\"code\":\"1\",\"defaultFirstPrice\":1,\"defaultContinuePrice\":1,\"description\":\"1\",\"params\":{},\"createTime\":1644976460719,\"continueWeight\":1,\"name\":\"中通\"}', NULL, 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'courier_code\' doesn\'t have a default value\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TShippingMethodMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TShippingMethodMapper.insertTShippingMethod-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_shipping_method          ( name,             first_weight,             continue_weight,             default_first_price,             default_continue_price,             description,             code,                                       create_time )           values ( ?,             ?,             ?,             ?,             ?,             ?,             ?,                                       ? )\r\n### Cause: java.sql.SQLException: Field \'courier_code\' doesn\'t have a default value\n; Field \'courier_code\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'courier_code\' doesn\'t have a default value', '2022-02-16 09:54:20');
INSERT INTO `sys_oper_log` VALUES (110, '配送方式', 1, 'com.ruoyi.goods.controller.TShippingMethodController.add()', 'POST', 1, 'admin', NULL, '/method', '127.0.0.1', '', '{\"firstWeight\":1,\"code\":\"1\",\"defaultFirstPrice\":1,\"defaultContinuePrice\":1,\"description\":\"1\",\"params\":{},\"createTime\":1644976466969,\"continueWeight\":1,\"name\":\"中通\",\"orders\":1,\"courierCode\":\"1\"}', NULL, 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'update_time\' doesn\'t have a default value\r\n### The error may exist in file [D:\\bai\\project\\shexian2\\RuoYi-Cloud-master\\ruoyi-modules\\ruoyi-modules-goods\\target\\classes\\mapper\\goods\\TShippingMethodMapper.xml]\r\n### The error may involve com.ruoyi.goods.mapper.TShippingMethodMapper.insertTShippingMethod-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into t_shipping_method          ( name,             first_weight,             continue_weight,             default_first_price,             default_continue_price,             description,             code,                          courier_code,             create_time,                                       orders )           values ( ?,             ?,             ?,             ?,             ?,             ?,             ?,                          ?,             ?,                                       ? )\r\n### Cause: java.sql.SQLException: Field \'update_time\' doesn\'t have a default value\n; Field \'update_time\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'update_time\' doesn\'t have a default value', '2022-02-16 09:54:26');
INSERT INTO `sys_oper_log` VALUES (111, '配送方式', 1, 'com.ruoyi.goods.controller.TShippingMethodController.add()', 'POST', 1, 'admin', NULL, '/method', '127.0.0.1', '', '{\"firstWeight\":1,\"defaultFirstPrice\":1,\"defaultContinuePrice\":1,\"params\":{},\"createTime\":1644979621221,\"continueWeight\":1,\"name\":\"中通\",\"id\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 10:47:01');
INSERT INTO `sys_oper_log` VALUES (112, '配送方式', 2, 'com.ruoyi.goods.controller.TShippingMethodController.edit()', 'PUT', 1, 'admin', NULL, '/method', '127.0.0.1', '', '{\"firstWeight\":1,\"code\":\"ZT\",\"defaultFirstPrice\":1,\"defaultContinuePrice\":1,\"description\":\"中通介绍\",\"updateTime\":1644979640156,\"params\":{},\"version\":0,\"createTime\":1644979621000,\"continueWeight\":1,\"name\":\"中通\",\"orders\":1,\"id\":1,\"courierCode\":\"ZT\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 10:47:20');
INSERT INTO `sys_oper_log` VALUES (113, '配送方式', 2, 'com.ruoyi.goods.controller.TShippingMethodController.edit()', 'PUT', 1, 'admin', NULL, '/method', '127.0.0.1', '', '{\"firstWeight\":1,\"code\":\"ZTO\",\"defaultFirstPrice\":10,\"defaultContinuePrice\":1,\"description\":\"中通介绍\",\"updateTime\":1644979663067,\"params\":{},\"version\":0,\"createTime\":1644979621000,\"continueWeight\":1,\"name\":\"中通\",\"orders\":1,\"id\":1,\"courierCode\":\"ZTO\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 10:47:43');
INSERT INTO `sys_oper_log` VALUES (114, '配送方式', 1, 'com.ruoyi.goods.controller.TShippingMethodController.add()', 'POST', 1, 'admin', NULL, '/method', '127.0.0.1', '', '{\"firstWeight\":1,\"code\":\"1\",\"defaultFirstPrice\":1,\"defaultContinuePrice\":1,\"description\":\"1\",\"params\":{},\"createTime\":1644979690979,\"continueWeight\":1,\"name\":\"圆通\",\"orders\":1,\"id\":2,\"courierCode\":\"1\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 10:48:11');
INSERT INTO `sys_oper_log` VALUES (115, '配送方式', 2, 'com.ruoyi.goods.controller.TShippingMethodController.edit()', 'PUT', 1, 'admin', NULL, '/method', '127.0.0.1', '', '{\"firstWeight\":1,\"code\":\"YTO\",\"defaultFirstPrice\":10,\"defaultContinuePrice\":1,\"description\":\"1\",\"updateTime\":1644979724655,\"params\":{},\"version\":0,\"createTime\":1644979691000,\"continueWeight\":1,\"name\":\"圆通\",\"orders\":1,\"id\":2,\"courierCode\":\"YTO\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 10:48:44');
INSERT INTO `sys_oper_log` VALUES (116, '配送方式', 1, 'com.ruoyi.goods.controller.TShippingMethodController.add()', 'POST', 1, 'admin', NULL, '/method', '127.0.0.1', '', '{\"firstWeight\":2,\"code\":\"YD\",\"defaultFirstPrice\":2,\"defaultContinuePrice\":2,\"description\":\"介绍\",\"params\":{},\"createTime\":1644979832384,\"continueWeight\":2,\"name\":\"韵达\",\"orders\":3,\"id\":3,\"courierCode\":\"YD\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 10:50:32');
INSERT INTO `sys_oper_log` VALUES (117, '配送方式', 2, 'com.ruoyi.goods.controller.TShippingMethodController.edit()', 'PUT', 1, 'admin', NULL, '/method', '127.0.0.1', '', '{\"firstWeight\":1,\"code\":\"YTO\",\"defaultFirstPrice\":10,\"defaultContinuePrice\":1,\"description\":\"1\",\"updateTime\":1644980004509,\"params\":{},\"version\":0,\"createTime\":1644979691000,\"continueWeight\":1,\"name\":\"圆通\",\"orders\":2,\"id\":2,\"courierCode\":\"YTO\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 10:53:24');
INSERT INTO `sys_oper_log` VALUES (118, '代码生成', 6, 'com.ruoyi.gen.controller.GenController.importTableSave()', 'POST', 1, 'admin', NULL, '/gen/importTable', '127.0.0.1', '', 't_product_label', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 11:47:42');
INSERT INTO `sys_oper_log` VALUES (119, '代码生成', 8, 'com.ruoyi.gen.controller.GenController.batchGenCode()', 'GET', 1, 'admin', NULL, '/gen/batchGenCode', '127.0.0.1', '', NULL, NULL, 0, NULL, '2022-02-16 11:48:55');
INSERT INTO `sys_oper_log` VALUES (120, '商品标签', 1, 'com.ruoyi.goods.controller.TProductLabelController.add()', 'POST', 1, 'admin', NULL, '/label', '127.0.0.1', '', '{\"createTime\":1644983845282,\"id\":1,\"labelName\":\"衣服\",\"params\":{},\"bak\":\"备注\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 11:57:25');
INSERT INTO `sys_oper_log` VALUES (121, '商品标签', 1, 'com.ruoyi.goods.controller.TProductLabelController.add()', 'POST', 1, 'admin', NULL, '/label', '127.0.0.1', '', '{\"createTime\":1644983859431,\"id\":2,\"labelName\":\"鞋\",\"params\":{},\"bak\":\"备注2\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 11:57:39');
INSERT INTO `sys_oper_log` VALUES (122, '商品标签', 2, 'com.ruoyi.goods.controller.TProductLabelController.edit()', 'PUT', 1, 'admin', NULL, '/label', '127.0.0.1', '', '{\"createTime\":1644983859000,\"updateTime\":1644983873252,\"id\":2,\"labelName\":\"男鞋\",\"params\":{},\"bak\":\"备注22\",\"isDel\":1,\"version\":0}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 11:57:53');
INSERT INTO `sys_oper_log` VALUES (123, '字典类型', 1, 'com.ruoyi.system.controller.SysDictTypeController.add()', 'POST', 1, 'admin', NULL, '/dict/type', '127.0.0.1', '', '{\"createBy\":\"admin\",\"dictName\":\"商品类型\",\"remark\":\"商品类型列表\",\"params\":{},\"dictType\":\"product_type\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-02-16 15:36:04');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, 'ceo', '董事长', 1, '0', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_post` VALUES (2, 'se', '项目经理', 2, '0', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_post` VALUES (3, 'hr', '人力资源', 3, '0', 'admin', '2022-01-19 13:49:52', '', NULL, '');
INSERT INTO `sys_post` VALUES (4, 'user', '普通员工', 4, '0', 'admin', '2022-01-19 13:49:52', '', NULL, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 2, '2', 1, 1, '0', '0', 'admin', '2022-01-19 13:49:52', '', NULL, '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (2, 100);
INSERT INTO `sys_role_dept` VALUES (2, 101);
INSERT INTO `sys_role_dept` VALUES (2, 105);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 103);
INSERT INTO `sys_role_menu` VALUES (2, 104);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 113);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 116);
INSERT INTO `sys_role_menu` VALUES (2, 500);
INSERT INTO `sys_role_menu` VALUES (2, 501);
INSERT INTO `sys_role_menu` VALUES (2, 1000);
INSERT INTO `sys_role_menu` VALUES (2, 1001);
INSERT INTO `sys_role_menu` VALUES (2, 1002);
INSERT INTO `sys_role_menu` VALUES (2, 1003);
INSERT INTO `sys_role_menu` VALUES (2, 1004);
INSERT INTO `sys_role_menu` VALUES (2, 1005);
INSERT INTO `sys_role_menu` VALUES (2, 1006);
INSERT INTO `sys_role_menu` VALUES (2, 1007);
INSERT INTO `sys_role_menu` VALUES (2, 1008);
INSERT INTO `sys_role_menu` VALUES (2, 1009);
INSERT INTO `sys_role_menu` VALUES (2, 1010);
INSERT INTO `sys_role_menu` VALUES (2, 1011);
INSERT INTO `sys_role_menu` VALUES (2, 1012);
INSERT INTO `sys_role_menu` VALUES (2, 1013);
INSERT INTO `sys_role_menu` VALUES (2, 1014);
INSERT INTO `sys_role_menu` VALUES (2, 1015);
INSERT INTO `sys_role_menu` VALUES (2, 1016);
INSERT INTO `sys_role_menu` VALUES (2, 1017);
INSERT INTO `sys_role_menu` VALUES (2, 1018);
INSERT INTO `sys_role_menu` VALUES (2, 1019);
INSERT INTO `sys_role_menu` VALUES (2, 1020);
INSERT INTO `sys_role_menu` VALUES (2, 1021);
INSERT INTO `sys_role_menu` VALUES (2, 1022);
INSERT INTO `sys_role_menu` VALUES (2, 1023);
INSERT INTO `sys_role_menu` VALUES (2, 1024);
INSERT INTO `sys_role_menu` VALUES (2, 1025);
INSERT INTO `sys_role_menu` VALUES (2, 1026);
INSERT INTO `sys_role_menu` VALUES (2, 1027);
INSERT INTO `sys_role_menu` VALUES (2, 1028);
INSERT INTO `sys_role_menu` VALUES (2, 1029);
INSERT INTO `sys_role_menu` VALUES (2, 1030);
INSERT INTO `sys_role_menu` VALUES (2, 1031);
INSERT INTO `sys_role_menu` VALUES (2, 1032);
INSERT INTO `sys_role_menu` VALUES (2, 1033);
INSERT INTO `sys_role_menu` VALUES (2, 1034);
INSERT INTO `sys_role_menu` VALUES (2, 1035);
INSERT INTO `sys_role_menu` VALUES (2, 1036);
INSERT INTO `sys_role_menu` VALUES (2, 1037);
INSERT INTO `sys_role_menu` VALUES (2, 1038);
INSERT INTO `sys_role_menu` VALUES (2, 1039);
INSERT INTO `sys_role_menu` VALUES (2, 1040);
INSERT INTO `sys_role_menu` VALUES (2, 1041);
INSERT INTO `sys_role_menu` VALUES (2, 1042);
INSERT INTO `sys_role_menu` VALUES (2, 1043);
INSERT INTO `sys_role_menu` VALUES (2, 1044);
INSERT INTO `sys_role_menu` VALUES (2, 1045);
INSERT INTO `sys_role_menu` VALUES (2, 1046);
INSERT INTO `sys_role_menu` VALUES (2, 1047);
INSERT INTO `sys_role_menu` VALUES (2, 1048);
INSERT INTO `sys_role_menu` VALUES (2, 1049);
INSERT INTO `sys_role_menu` VALUES (2, 1050);
INSERT INTO `sys_role_menu` VALUES (2, 1051);
INSERT INTO `sys_role_menu` VALUES (2, 1052);
INSERT INTO `sys_role_menu` VALUES (2, 1053);
INSERT INTO `sys_role_menu` VALUES (2, 1054);
INSERT INTO `sys_role_menu` VALUES (2, 1055);
INSERT INTO `sys_role_menu` VALUES (2, 1056);
INSERT INTO `sys_role_menu` VALUES (2, 1057);
INSERT INTO `sys_role_menu` VALUES (2, 1058);
INSERT INTO `sys_role_menu` VALUES (2, 1059);
INSERT INTO `sys_role_menu` VALUES (2, 1060);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-01-19 13:49:52', 'admin', '2022-01-19 13:49:52', '', NULL, '管理员');
INSERT INTO `sys_user` VALUES (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-01-19 13:49:52', 'admin', '2022-01-19 13:49:52', 'admin', '2022-02-09 13:45:49', '测试员');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES (1, 1);
INSERT INTO `sys_user_post` VALUES (2, 2);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品标号',
  `product_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `product_images` json NULL COMMENT '轮播图json保存多中类型大图中图小图原图',
  `image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品主图',
  `price` decimal(10, 2) NOT NULL COMMENT '商品销售价',
  `vip_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '会员价格后续扩展，暂时冗余不需要使用',
  `product_category_id` bigint(20) NOT NULL COMMENT '关联商品分类',
  `unit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '单位名',
  `sort` int(10) NOT NULL DEFAULT 0 COMMENT '排序正序',
  `sales` int(10) NOT NULL DEFAULT 0 COMMENT '销量',
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '产品描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `is_del` tinyint(1) NULL DEFAULT 1 COMMENT '是否删除 0是1否',
  `caption` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '副标题',
  `market_price` decimal(10, 2) NOT NULL COMMENT '市场价',
  `is_marketable` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否上架 1是2否',
  `memo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `seo_title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '冗余',
  `keyword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '搜索关键词',
  `brand_id` bigint(20) NULL DEFAULT NULL COMMENT '品牌id',
  `parameter_values` json NULL COMMENT '参数值json-暂时保留字段目前不需要使用',
  `specification_items` json NULL COMMENT '规格项 json',
  `version` int(10) NOT NULL DEFAULT 0 COMMENT '版本号',
  `product_type` int(4) NOT NULL COMMENT '商品类型见枚举',
  `shipping_method_id` bigint(20) NULL DEFAULT NULL COMMENT '配送方式',
  `warehouse_id` bigint(20) NOT NULL COMMENT '仓库id',
  `project_id` bigint(20) NOT NULL COMMENT '项目id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_sn`(`sn`) USING BTREE,
  INDEX `idx_category_id`(`product_category_id`) USING BTREE,
  INDEX `idx_brand_id`(`brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES (1, '233', '商品名字', '1', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png,https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', 13.00, 23.00, 1, NULL, 0, 0, NULL, '2022-01-22 17:07:44', '2022-02-12 16:12:05', 1, NULL, 1.00, 1, NULL, NULL, NULL, 106, '2', '2', 0, 2, 3, 3, 3);
INSERT INTO `t_product` VALUES (2, '234', '商品名字2', '2', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png,http://127.0.0.1:9300/statics/2022/02/10/22130a77-3628-4635-96bc-d8a3dd6f2124.png', 1445.00, 1335.00, 25, '光听', 5, 0, '富国天惠', '2022-02-09 10:53:19', '2022-02-12 16:12:09', 1, NULL, 2.00, 1, NULL, '5', NULL, 101, NULL, NULL, 0, 2, 3, 4, 4);
INSERT INTO `t_product` VALUES (3, '333', '商品3', '3', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png,http://127.0.0.1:9300/statics/2022/02/10/3e51a1de-7b27-4e81-aa37-eb515dada8c4.png', 6.00, 6.00, 6, '6', 6, 6, '6', '2022-02-10 09:45:54', '2022-02-12 16:25:51', 1, '6', 6.00, 1, '6', '6', '6', 104, NULL, NULL, 6, 1, 6, 6, 6);

-- ----------------------------
-- Table structure for t_product_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_product_brand`;
CREATE TABLE `t_product_brand`  (
  `brand_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父分类id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `brand_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '品牌名称',
  `sort_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '品牌状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `logo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'logo',
  `introduction` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍',
  PRIMARY KEY (`brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品品牌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product_brand
-- ----------------------------
INSERT INTO `t_product_brand` VALUES (100, 0, '0', '品牌', 0, '0', '0', 'admin', '2022-01-24 14:55:52', 'admin', '2022-01-24 14:55:59', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', '品牌介绍');
INSERT INTO `t_product_brand` VALUES (101, 100, '0,100', '王丙乾', 1, '0', '0', 'admin', '2022-01-24 15:00:03', 'admin', '2022-01-24 15:00:07', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', '品牌介绍');
INSERT INTO `t_product_brand` VALUES (102, 100, '0,100', '观羽', 2, '0', '0', 'admin', '2022-01-24 15:00:10', 'admin', '2022-01-24 15:00:13', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', '品牌介绍');
INSERT INTO `t_product_brand` VALUES (103, 100, '0,100', '乾吉烧坊', 3, '0', '0', 'admin', '2022-01-24 15:00:16', 'admin', '2022-01-24 15:00:19', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', '品牌介绍');
INSERT INTO `t_product_brand` VALUES (104, 101, '0,100,101', '金奖叁号', 1, '0', '0', 'admin', '2022-01-24 15:02:37', 'admin', '2022-01-24 15:02:39', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', '品牌介绍');
INSERT INTO `t_product_brand` VALUES (105, 101, '0,100,101', '金奖壹号', 2, '0', '0', 'admin', '2022-01-24 15:02:42', 'admin', '2022-01-24 15:02:45', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', '品牌介绍');
INSERT INTO `t_product_brand` VALUES (106, 102, '', '绿袍关羽', 0, '0', '0', 'admin', '2022-01-27 14:57:41', '', NULL, 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', '品牌介绍');
INSERT INTO `t_product_brand` VALUES (107, 102, '', '红袍关羽', 0, '0', '0', 'admin', '2022-01-27 14:57:56', '', NULL, 'https://www.baidu.com/img/PC_9d6532110a742ba494be893d19bc80f8.png', '品牌介绍');
INSERT INTO `t_product_brand` VALUES (108, 103, '', '乾吉烧坊', 0, '0', '0', 'admin', '2022-01-27 14:58:11', '', NULL, 'https://www.baidu.com/img/PC_9d6532110a742ba494be893d19bc80f8.png', NULL);
INSERT INTO `t_product_brand` VALUES (109, 101, '', '金奖四号', 3, '0', '0', 'admin', '2022-02-12 10:06:36', 'admin', '2022-02-12 10:06:53', 'http://127.0.0.1:9300/statics/2022/02/12/8c792989-711d-42a6-bdb5-fecaa103acd0.png', '金奖四号介绍');

-- ----------------------------
-- Table structure for t_product_category
-- ----------------------------
DROP TABLE IF EXISTS `t_product_category`;
CREATE TABLE `t_product_category`  (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父分类id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `category_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '分类名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '分类状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product_category
-- ----------------------------
INSERT INTO `t_product_category` VALUES (100, 0, '0', '分类', 0, '0', '0', 'admin', '2022-01-24 14:55:52', 'admin', '2022-01-24 14:55:59');
INSERT INTO `t_product_category` VALUES (101, 100, '0,100', '酱香', 1, '0', '0', 'admin', '2022-01-24 15:00:03', 'admin', '2022-01-27 14:53:08');
INSERT INTO `t_product_category` VALUES (102, 100, '0,100', '清香', 2, '0', '0', 'admin', '2022-01-24 15:00:10', 'admin', '2022-01-27 14:54:05');
INSERT INTO `t_product_category` VALUES (103, 100, '0,100', '浓香', 3, '0', '0', 'admin', '2022-01-24 15:00:16', 'admin', '2022-01-27 14:54:36');
INSERT INTO `t_product_category` VALUES (104, 101, '0,100,101', '酱香1', 1, '0', '0', 'admin', '2022-01-24 15:02:37', 'admin', '2022-01-27 14:55:04');
INSERT INTO `t_product_category` VALUES (105, 101, '0,100,101', '酱香2', 2, '0', '0', 'admin', '2022-01-24 15:02:42', 'admin', '2022-01-27 14:55:10');
INSERT INTO `t_product_category` VALUES (109, 102, '', '清香1', 1, '0', '0', '', '2022-01-25 15:59:11', 'admin', '2022-01-27 14:55:22');
INSERT INTO `t_product_category` VALUES (110, 102, '', '清香2', 2, '0', '0', '', '2022-01-25 15:59:26', 'admin', '2022-01-27 14:55:29');
INSERT INTO `t_product_category` VALUES (111, 103, '', '浓香1', 1, '0', '0', '', '2022-01-25 15:59:45', 'admin', '2022-01-27 14:55:45');

-- ----------------------------
-- Table structure for t_product_conversion_proportion
-- ----------------------------
DROP TABLE IF EXISTS `t_product_conversion_proportion`;
CREATE TABLE `t_product_conversion_proportion`  (
  `conversion_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `conversion_proportion` int(11) NOT NULL COMMENT '换算率',
  `specification_values` json NOT NULL COMMENT '规格',
  `is_del` tinyint(1) NULL DEFAULT 1 COMMENT '是否删除 0是1否',
  PRIMARY KEY (`conversion_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品规格换算表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product_conversion_proportion
-- ----------------------------
INSERT INTO `t_product_conversion_proportion` VALUES (1, 2, '[\"1瓶装\", \"2瓶装\"]', 1);
INSERT INTO `t_product_conversion_proportion` VALUES (2, 3, '[\"1瓶装\", \"2瓶装\"]', 1);

-- ----------------------------
-- Table structure for t_product_label
-- ----------------------------
DROP TABLE IF EXISTS `t_product_label`;
CREATE TABLE `t_product_label`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `label_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名称',
  `bak` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_del` tinyint(1) NULL DEFAULT 1 COMMENT '是否删除 0是1否',
  `version` int(10) NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product_label
-- ----------------------------
INSERT INTO `t_product_label` VALUES (1, '衣服', '备注', '2022-02-16 11:57:25', NULL, 1, 0);
INSERT INTO `t_product_label` VALUES (2, '男鞋', '备注22', '2022-02-16 11:57:39', '2022-02-16 11:57:53', 1, 0);

-- ----------------------------
-- Table structure for t_product_label_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_product_label_relation`;
CREATE TABLE `t_product_label_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_id` bigint(20) NOT NULL COMMENT '商品ID',
  `product_label_id` bigint(20) NOT NULL COMMENT '商品标签ID',
  `product_label_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品标签名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(10) NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_product_id`(`product_id`, `product_label_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品标签关联' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_shipping_method
-- ----------------------------
DROP TABLE IF EXISTS `t_shipping_method`;
CREATE TABLE `t_shipping_method`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `first_weight` double(10, 2) NOT NULL COMMENT '首重',
  `continue_weight` double(10, 2) NOT NULL COMMENT '续重量',
  `default_first_price` decimal(10, 2) NOT NULL COMMENT '默认首重价格',
  `default_continue_price` decimal(10, 2) NOT NULL COMMENT '默认续重价格',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '阿里快递查询编码',
  `alipay_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '冗余支付宝订单中心编码如果做支付宝订单中心需要此字段',
  `courier_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '快递助手物流编码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `version` int(10) NULL DEFAULT 0 COMMENT '版本号',
  `orders` int(5) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '配送方式' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_shipping_method
-- ----------------------------
INSERT INTO `t_shipping_method` VALUES (1, '中通', 1.00, 1.00, 10.00, 1.00, '中通介绍', 'ZTO', NULL, 'ZTO', '2022-02-16 10:47:01', '2022-02-16 10:47:43', 0, 1);
INSERT INTO `t_shipping_method` VALUES (2, '圆通', 1.00, 1.00, 10.00, 1.00, '1', 'YTO', NULL, 'YTO', '2022-02-16 10:48:11', '2022-02-16 10:53:25', 0, 2);
INSERT INTO `t_shipping_method` VALUES (3, '韵达', 2.00, 2.00, 2.00, 2.00, '介绍', 'YD', NULL, 'YD', '2022-02-16 10:50:32', NULL, 0, 3);

-- ----------------------------
-- Table structure for t_shipping_reverse_config
-- ----------------------------
DROP TABLE IF EXISTS `t_shipping_reverse_config`;
CREATE TABLE `t_shipping_reverse_config`  (
  `reverse_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `reverse_status` varchar(510) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '反向签收状态',
  `shipping_id` bigint(20) NOT NULL COMMENT '物流id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除 0否1是',
  PRIMARY KEY (`reverse_id`) USING BTREE,
  UNIQUE INDEX `idx_shipping_delete`(`shipping_id`, `is_delete`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '物流拒收配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_shipping_reverse_config
-- ----------------------------
INSERT INTO `t_shipping_reverse_config` VALUES (1, '运输中，离开【贵阳转运中心】，下一部门【贵阳白云区麦架镇营业部】', 1, '2022-02-15 17:52:44', 0);
INSERT INTO `t_shipping_reverse_config` VALUES (4, '快件在【贵阳小河中转场】完成分拣,准备发往 【商贸城速运营业点】', 2, '2022-02-15 17:55:29', 0);

-- ----------------------------
-- Table structure for t_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_sku`;
CREATE TABLE `t_sku`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_id` bigint(20) NOT NULL COMMENT '关联商品id',
  `price` decimal(10, 2) NOT NULL COMMENT '销售价',
  `cost` decimal(10, 2) NOT NULL COMMENT '成本价',
  `market_price` decimal(10, 2) NOT NULL COMMENT '市场价',
  `stock` int(10) NOT NULL DEFAULT 0 COMMENT '库存',
  `allocated_stock` int(10) NOT NULL DEFAULT 0 COMMENT '已分配库存',
  `is_default` tinyint(1) NOT NULL COMMENT '是否默认',
  `specification_values` json NOT NULL COMMENT '规格值[]',
  `image` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格图片',
  `sn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'sku编号全局唯一',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `version` int(10) NULL DEFAULT 0 COMMENT '版本号',
  `weight` double(10, 2) NOT NULL COMMENT '重量',
  `exchange_point` bigint(20) NOT NULL DEFAULT 0 COMMENT '兑换积分',
  `reward_point` bigint(20) NOT NULL DEFAULT 0 COMMENT '赠送积分',
  `is_sale` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否上架 1是2否',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_product_id`(`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品sku表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sku
-- ----------------------------
INSERT INTO `t_sku` VALUES (1, 1, 1.00, 1.00, 1.00, 0, 0, 1, '1', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', 'sn011', '2022-02-12 11:28:43', '2022-02-12 11:28:46', 0, 1.00, 0, 0, 1);
INSERT INTO `t_sku` VALUES (2, 2, 2.00, 2.00, 2.00, 0, 0, 2, '2', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', 'sn012', '2022-02-12 11:29:29', '2022-02-12 11:29:31', 0, 1.00, 0, 0, 1);
INSERT INTO `t_sku` VALUES (3, 1, 3.00, 3.00, 3.00, 0, 0, 1, '1', 'https://www.baidu.com/img/PC_880906d2a4ad95f5fafb2e540c5cdad7.png', 'sn003', '2022-02-12 11:43:07', '2022-02-12 11:43:14', 0, 1.00, 0, 0, 1);

-- ----------------------------
-- Table structure for t_specification
-- ----------------------------
DROP TABLE IF EXISTS `t_specification`;
CREATE TABLE `t_specification`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `options` json NOT NULL COMMENT '可选项目',
  `product_category_id` bigint(20) NOT NULL COMMENT '绑定分类',
  `sort` int(10) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `version` int(10) NULL DEFAULT 0 COMMENT '版本号',
  `is_del` tinyint(1) NULL DEFAULT 1 COMMENT '是否删除 0是1否',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_category_id`(`product_category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品规格' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_specification
-- ----------------------------
INSERT INTO `t_specification` VALUES (1, '白酒规格', '[\"1瓶装\", \"2瓶装\"]', 1, 1, '2022-02-12 15:03:28', NULL, 0, 1);
INSERT INTO `t_specification` VALUES (2, '红酒规格', '[\"1瓶装\", \"2瓶装\", \"3瓶装\"]', 2, 2, '2022-02-12 15:06:04', '2022-02-12 15:21:22', 0, 1);
INSERT INTO `t_specification` VALUES (4, '6', '[\"1瓶装\", \"2瓶装\"]', 6, 6, '2022-02-12 16:01:05', NULL, 0, 0);
INSERT INTO `t_specification` VALUES (5, '5', '[\"1瓶装\", \"2瓶装\"]', 5, 5, '2022-02-12 16:04:35', NULL, 0, 0);

-- ----------------------------
-- Table structure for t_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse`;
CREATE TABLE `t_warehouse`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `warehouse_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '仓库名',
  `sys_user_id` bigint(20) NOT NULL COMMENT '仓库管理员',
  `contact` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址省市县以及详细地址暂时不区分，可能存在退货使用此地址',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机',
  `memo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_default` tinyint(1) NULL DEFAULT NULL COMMENT '是否默认 0是1否',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '状态 0禁用 1正常',
  `app_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '快递助手appKey',
  `app_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '快递助手appSecret',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `version` int(10) NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_app_key`(`app_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '仓库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_warehouse
-- ----------------------------
INSERT INTO `t_warehouse` VALUES (1, '郑州仓库', 1, '若依', '郑州市金水区', '15066666666', '备注', 0, 0, '0', '0', '2022-02-14 14:04:02', NULL, 0);
INSERT INTO `t_warehouse` VALUES (3, '上海仓库', 5, '5', '5', '15033333333', '备注5', 5, 5, 'key', 'seret5', '2022-02-14 14:05:20', '2022-02-15 09:44:11', 0);
INSERT INTO `t_warehouse` VALUES (4, '仓库1', 1, '1', '1', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_warehouse` VALUES (5, '仓库2', 2, '2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_warehouse` VALUES (6, '仓库3', 3, '3', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_warehouse` VALUES (7, '仓库4', 4, '4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_warehouse` VALUES (8, '仓库5', 5, '5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_warehouse` VALUES (9, '仓库6', 6, '6', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_warehouse` VALUES (10, '仓库7', 7, '7', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_warehouse` VALUES (11, '仓库8', 8, '8', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_warehouse` VALUES (12, '仓库9', 9, '9', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for tb_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_info`;
CREATE TABLE `tb_goods_info`  (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `brand_id` bigint(20) NOT NULL COMMENT '品牌id',
  `product_category_id` bigint(20) NOT NULL COMMENT '商品分类id',
  `sort` int(10) NULL DEFAULT 0 COMMENT '排序',
  `introduction` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '产品价格售后等描述',
  `sku` bigint(20) NOT NULL COMMENT '商品sku',
  `version` int(10) NULL DEFAULT 0 COMMENT '版本号',
  `bak` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`goods_id`) USING BTREE,
  INDEX `idx_product_category_id`(`product_category_id`) USING BTREE,
  INDEX `idx_brand_id`(`brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_goods_specifications
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_specifications`;
CREATE TABLE `tb_goods_specifications`  (
  `specifications_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规格id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `specifications_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名称',
  `specifications_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格标题',
  `sale_price` decimal(10, 2) NOT NULL COMMENT '销售价',
  `discount_price` decimal(10, 2) NOT NULL COMMENT '优惠价',
  `stock` int(10) NOT NULL DEFAULT 0 COMMENT '库存',
  `video` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品视频',
  `image` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品主图',
  `product_images` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '轮播图',
  `del_flag` tinyint(1) NULL DEFAULT 1 COMMENT '删除标志:1存在 2删除',
  `sale_status` tinyint(1) NULL DEFAULT 1 COMMENT '销售状态:1上架，2下架',
  `sale_num` int(10) NULL DEFAULT 0 COMMENT '销量(真实)',
  `comment_num` int(10) NULL DEFAULT 0 COMMENT '评论量(真实)',
  `sale_num_virtualize` int(10) NULL DEFAULT 0 COMMENT '销量(虚拟)',
  `comment_num_virtualize` int(10) NULL DEFAULT 0 COMMENT '评论量(虚拟)',
  `version` int(10) NULL DEFAULT 0 COMMENT '版本号',
  `product_type` tinyint(1) NULL DEFAULT NULL COMMENT '商品类型,1赠品 2零售 3批发',
  `integral` int(10) NULL DEFAULT 0 COMMENT '积分',
  `bak` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`specifications_id`) USING BTREE,
  INDEX `idx_goods_id`(`goods_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品规格表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
