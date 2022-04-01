package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TWarehouseDispatchinto;

/**
 * 调拨出入库单Service接口
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
public interface ITWarehouseDispatchintoService 
{
    /**
     * 查询调拨出入库单
     * 
     * @param id 调拨出入库单主键
     * @return 调拨出入库单
     */
    public TWarehouseDispatchinto selectTWarehouseDispatchintoById(Long id);

    /**
     * 查询调拨出入库单列表
     * 
     * @param tWarehouseDispatchinto 调拨出入库单
     * @return 调拨出入库单集合
     */
    public List<TWarehouseDispatchinto> selectTWarehouseDispatchintoList(TWarehouseDispatchinto tWarehouseDispatchinto);

    /**
     * 新增调拨出入库单
     * 
     * @param tWarehouseDispatchinto 调拨出入库单
     * @return 结果
     */
    public int insertTWarehouseDispatchinto(TWarehouseDispatchinto tWarehouseDispatchinto);

    /**
     * 修改调拨出入库单
     * 
     * @param tWarehouseDispatchinto 调拨出入库单
     * @return 结果
     */
    public int updateTWarehouseDispatchinto(TWarehouseDispatchinto tWarehouseDispatchinto);

    /**
     * 批量删除调拨出入库单
     * 
     * @param ids 需要删除的调拨出入库单主键集合
     * @return 结果
     */
    public int deleteTWarehouseDispatchintoByIds(Long[] ids);

    /**
     * 删除调拨出入库单信息
     * 
     * @param id 调拨出入库单主键
     * @return 结果
     */
    public int deleteTWarehouseDispatchintoById(Long id);
}
