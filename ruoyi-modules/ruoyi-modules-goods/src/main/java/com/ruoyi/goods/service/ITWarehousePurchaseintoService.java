package com.ruoyi.goods.service;

import java.util.List;

import com.ruoyi.goods.domain.TWarehousePurchase;
import com.ruoyi.goods.domain.TWarehousePurchaseinto;
import com.ruoyi.goods.domain.TWarehousePurchaserecord;

/**
 * 采购入库单Service接口
 * 
 * @author ruoyi
 * @date 2022-03-24
 */
public interface ITWarehousePurchaseintoService 
{
    /**
     * 查询采购入库单
     * 
     * @param id 采购入库单主键
     * @return 采购入库单
     */
    public TWarehousePurchaseinto selectTWarehousePurchaseintoById(Long id);

    /**
     * 查询采购入库单列表
     * 
     * @param tWarehousePurchaseinto 采购入库单
     * @return 采购入库单集合
     */
    public List<TWarehousePurchaseinto> selectTWarehousePurchaseintoList(TWarehousePurchaseinto tWarehousePurchaseinto);

    /**
     * 新增采购入库单
     * 
     * @param tWarehousePurchaseinto 采购入库单
     * @return 结果
     */
    public int insertTWarehousePurchaseinto(TWarehousePurchaseinto tWarehousePurchaseinto);

    /**
     * 修改采购入库单
     * 
     * @param tWarehousePurchaseinto 采购入库单
     * @return 结果
     */
    public int updateTWarehousePurchaseinto(TWarehousePurchaseinto tWarehousePurchaseinto);

    /**
     * 批量删除采购入库单
     * 
     * @param ids 需要删除的采购入库单主键集合
     * @return 结果
     */
    public int deleteTWarehousePurchaseintoByIds(Long[] ids);

    /**
     * 删除采购入库单信息
     * 
     * @param id 采购入库单主键
     * @return 结果
     */
    public int deleteTWarehousePurchaseintoById(Long id);
    /**
     * 查询采购入库审核列表
     */
    public List<TWarehousePurchaseinto> purchaseintoCheckList(TWarehousePurchaseinto tWarehousePurchaseinto);
    /**
     * 采购入库申请审核
     */
    public int updateTWarehousePurchaseIntoCheck(TWarehousePurchaseinto tWarehousePurchaseinto);
    /**
     * 采购入库审核记录列表
     */
    public List<TWarehousePurchaserecord> selectTWarehousePurchaseIntoCheckList(TWarehousePurchaseinto tWarehousePurchaseinto);
}
