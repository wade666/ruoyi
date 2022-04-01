package com.ruoyi.goods.domain.vo;
/**
 * 审核类型
 */
public interface DictType {

    /**
     * 1采购审核,2入库审核
     */
    Integer CHECKTYPE_PURCHASE = 1;
    Integer CHECKTYPE_IN_WAREHOUSE = 2;
    /**
     * 出入库类型（1入库，2出库）
     */
    Integer SURPLUSTYPE_ONE = 1;
    Integer SURPLUSTYPE_TWO = 2;
    /**
     * 出入库详情（1生产入库 2调拨入库 3售后入库 4其他入库 5采购入库，6销售出库 7调拨出库 8其他出库）
     */
    Integer DETAILTYPE_ONE = 1;
    Integer DETAILTYPE_TWO = 2;
    Integer DETAILTYPE_THREE = 3;
    Integer DETAILTYPE_FOUR = 4;
    Integer DETAILTYPE_FIVE = 5;
    Integer DETAILTYPE_SIX = 6;
    Integer DETAILTYPE_SEVEN = 7;
    Integer DETAILTYPE_EIGHT = 8;
}
