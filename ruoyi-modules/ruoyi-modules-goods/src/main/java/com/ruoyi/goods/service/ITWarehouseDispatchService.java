package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TWarehouseDispatch;

/**
 * 调拨单Service接口
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
public interface ITWarehouseDispatchService 
{
    /**
     * 查询调拨单
     * 
     * @param id 调拨单主键
     * @return 调拨单
     */
    public TWarehouseDispatch selectTWarehouseDispatchById(Long id);

    /**
     * 查询调拨单列表
     * 
     * @param tWarehouseDispatch 调拨单
     * @return 调拨单集合
     */
    public List<TWarehouseDispatch> selectTWarehouseDispatchList(TWarehouseDispatch tWarehouseDispatch);

    /**
     * 新增调拨单
     * 
     * @param tWarehouseDispatch 调拨单
     * @return 结果
     */
    public int insertTWarehouseDispatch(TWarehouseDispatch tWarehouseDispatch);

    /**
     * 修改调拨单
     * 
     * @param tWarehouseDispatch 调拨单
     * @return 结果
     */
    public int updateTWarehouseDispatch(TWarehouseDispatch tWarehouseDispatch);

    /**
     * 批量删除调拨单
     * 
     * @param ids 需要删除的调拨单主键集合
     * @return 结果
     */
    public int deleteTWarehouseDispatchByIds(Long[] ids);

    /**
     * 删除调拨单信息
     * 
     * @param id 调拨单主键
     * @return 结果
     */
    public int deleteTWarehouseDispatchById(Long id);
}
