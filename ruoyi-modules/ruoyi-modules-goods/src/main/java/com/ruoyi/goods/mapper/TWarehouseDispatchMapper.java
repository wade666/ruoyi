package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TWarehouseDispatch;

/**
 * 调拨单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
public interface TWarehouseDispatchMapper 
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
     * 删除调拨单
     * 
     * @param id 调拨单主键
     * @return 结果
     */
    public int deleteTWarehouseDispatchById(Long id);

    /**
     * 批量删除调拨单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWarehouseDispatchByIds(Long[] ids);
    /**
     * 根据调拨单号修改调拨单
     */
    public int updateTWarehouseDispatchByDispatchNo(TWarehouseDispatch tWarehouseDispatch);
}
