package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TWarehousePurchaserecord;

/**
 * 采购申请审核记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
public interface TWarehousePurchaserecordMapper 
{
    /**
     * 查询采购申请审核记录
     * 
     * @param id 采购申请审核记录主键
     * @return 采购申请审核记录
     */
    public TWarehousePurchaserecord selectTWarehousePurchaserecordById(Long id);

    /**
     * 查询采购申请审核记录列表
     * 
     * @param tWarehousePurchaserecord 采购申请审核记录
     * @return 采购申请审核记录集合
     */
    public List<TWarehousePurchaserecord> selectTWarehousePurchaserecordList(TWarehousePurchaserecord tWarehousePurchaserecord);

    /**
     * 新增采购申请审核记录
     * 
     * @param tWarehousePurchaserecord 采购申请审核记录
     * @return 结果
     */
    public int insertTWarehousePurchaserecord(TWarehousePurchaserecord tWarehousePurchaserecord);

    /**
     * 修改采购申请审核记录
     * 
     * @param tWarehousePurchaserecord 采购申请审核记录
     * @return 结果
     */
    public int updateTWarehousePurchaserecord(TWarehousePurchaserecord tWarehousePurchaserecord);

    /**
     * 删除采购申请审核记录
     * 
     * @param id 采购申请审核记录主键
     * @return 结果
     */
    public int deleteTWarehousePurchaserecordById(Long id);

    /**
     * 批量删除采购申请审核记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWarehousePurchaserecordByIds(Long[] ids);
}
