package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TWarehousePurchaseintodetail;

/**
 * 采购入库单详情Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-24
 */
public interface TWarehousePurchaseintodetailMapper 
{
    /**
     * 查询采购入库单详情
     * 
     * @param id 采购入库单详情主键
     * @return 采购入库单详情
     */
    public TWarehousePurchaseintodetail selectTWarehousePurchaseintodetailById(Long id);

    /**
     * 查询采购入库单详情列表
     * 
     * @param tWarehousePurchaseintodetail 采购入库单详情
     * @return 采购入库单详情集合
     */
    public List<TWarehousePurchaseintodetail> selectTWarehousePurchaseintodetailList(TWarehousePurchaseintodetail tWarehousePurchaseintodetail);

    /**
     * 新增采购入库单详情
     * 
     * @param tWarehousePurchaseintodetail 采购入库单详情
     * @return 结果
     */
    public int insertTWarehousePurchaseintodetail(TWarehousePurchaseintodetail tWarehousePurchaseintodetail);

    /**
     * 修改采购入库单详情
     * 
     * @param tWarehousePurchaseintodetail 采购入库单详情
     * @return 结果
     */
    public int updateTWarehousePurchaseintodetail(TWarehousePurchaseintodetail tWarehousePurchaseintodetail);

    /**
     * 删除采购入库单详情
     * 
     * @param id 采购入库单详情主键
     * @return 结果
     */
    public int deleteTWarehousePurchaseintodetailById(Long id);

    /**
     * 批量删除采购入库单详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWarehousePurchaseintodetailByIds(Long[] ids);
}
