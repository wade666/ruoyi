package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TWarehousePurchasedetail;

/**
 * 采购申请详情Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-22
 */
public interface TWarehousePurchasedetailMapper 
{
    /**
     * 查询采购申请详情
     * 
     * @param id 采购申请详情主键
     * @return 采购申请详情
     */
    public TWarehousePurchasedetail selectTWarehousePurchasedetailById(Long id);

    /**
     * 查询采购申请详情列表
     * 
     * @param tWarehousePurchasedetail 采购申请详情
     * @return 采购申请详情集合
     */
    public List<TWarehousePurchasedetail> selectTWarehousePurchasedetailList(TWarehousePurchasedetail tWarehousePurchasedetail);

    /**
     * 新增采购申请详情
     * 
     * @param tWarehousePurchasedetail 采购申请详情
     * @return 结果
     */
    public int insertTWarehousePurchasedetail(TWarehousePurchasedetail tWarehousePurchasedetail);

    /**
     * 修改采购申请详情
     * 
     * @param tWarehousePurchasedetail 采购申请详情
     * @return 结果
     */
    public int updateTWarehousePurchasedetail(TWarehousePurchasedetail tWarehousePurchasedetail);

    /**
     * 删除采购申请详情
     * 
     * @param id 采购申请详情主键
     * @return 结果
     */
    public int deleteTWarehousePurchasedetailById(Long id);

    /**
     * 批量删除采购申请详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWarehousePurchasedetailByIds(Long[] ids);
}
