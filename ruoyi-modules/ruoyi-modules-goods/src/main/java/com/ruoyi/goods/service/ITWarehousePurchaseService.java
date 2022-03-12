package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TWarehousePurchase;

/**
 * 采购申请Service接口
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
public interface ITWarehousePurchaseService 
{
    /**
     * 查询采购申请
     * 
     * @param id 采购申请主键
     * @return 采购申请
     */
    public TWarehousePurchase selectTWarehousePurchaseById(Long id);

    /**
     * 查询采购申请列表
     * 
     * @param tWarehousePurchase 采购申请
     * @return 采购申请集合
     */
    public List<TWarehousePurchase> selectTWarehousePurchaseList(TWarehousePurchase tWarehousePurchase);

    /**
     * 新增采购申请
     * 
     * @param tWarehousePurchase 采购申请
     * @return 结果
     */
    public int insertTWarehousePurchase(TWarehousePurchase tWarehousePurchase);

    /**
     * 修改采购申请
     * 
     * @param tWarehousePurchase 采购申请
     * @return 结果
     */
    public int updateTWarehousePurchase(TWarehousePurchase tWarehousePurchase);

    /**
     * 批量删除采购申请
     * 
     * @param ids 需要删除的采购申请主键集合
     * @return 结果
     */
    public int deleteTWarehousePurchaseByIds(Long[] ids);

    /**
     * 删除采购申请信息
     * 
     * @param id 采购申请主键
     * @return 结果
     */
    public int deleteTWarehousePurchaseById(Long id);
}
