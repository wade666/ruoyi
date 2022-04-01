package com.ruoyi.goods.mapper;

import java.util.List;

import com.ruoyi.goods.domain.TWarehousePurchase;
import com.ruoyi.goods.domain.TWarehousePurchaseinto;

/**
 * 采购入库单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-24
 */
public interface TWarehousePurchaseintoMapper 
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
     * 删除采购入库单
     * 
     * @param id 采购入库单主键
     * @return 结果
     */
    public int deleteTWarehousePurchaseintoById(Long id);

    /**
     * 批量删除采购入库单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWarehousePurchaseintoByIds(Long[] ids);

    /**
     * 查询采购入库申请列表
     * @param tWarehousePurchaseinto 采购申请
     * @return 采购申请集合
     */
    public List<TWarehousePurchaseinto> selectTWarehousePurchaseIntoList(TWarehousePurchaseinto tWarehousePurchaseinto);
    /**
     * 查询采购入库申请列表,仓库管理员
     */
    public List<TWarehousePurchaseinto> selectTWarehousePurchaseIntoListBySysUserId(TWarehousePurchaseinto tWarehousePurchaseinto);

    /**
     * 查询采购审核列表
     */
    List<TWarehousePurchaseinto> purchaseintoCheckList(TWarehousePurchaseinto tWarehousePurchaseinto);

    /**
     * 采购入库单审核
     */
    public int updateTWarehousePurchaseintoCheck(TWarehousePurchaseinto tWarehousePurchaseinto);
}
