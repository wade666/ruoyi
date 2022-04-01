package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TWarehouseDispatchdetail;

/**
 * 调拨单详情Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
public interface TWarehouseDispatchdetailMapper 
{
    /**
     * 查询调拨单详情
     * 
     * @param id 调拨单详情主键
     * @return 调拨单详情
     */
    public TWarehouseDispatchdetail selectTWarehouseDispatchdetailById(Long id);

    /**
     * 查询调拨单详情列表
     * 
     * @param tWarehouseDispatchdetail 调拨单详情
     * @return 调拨单详情集合
     */
    public List<TWarehouseDispatchdetail> selectTWarehouseDispatchdetailList(TWarehouseDispatchdetail tWarehouseDispatchdetail);

    /**
     * 新增调拨单详情
     * 
     * @param tWarehouseDispatchdetail 调拨单详情
     * @return 结果
     */
    public int insertTWarehouseDispatchdetail(TWarehouseDispatchdetail tWarehouseDispatchdetail);

    /**
     * 修改调拨单详情
     * 
     * @param tWarehouseDispatchdetail 调拨单详情
     * @return 结果
     */
    public int updateTWarehouseDispatchdetail(TWarehouseDispatchdetail tWarehouseDispatchdetail);

    /**
     * 删除调拨单详情
     * 
     * @param id 调拨单详情主键
     * @return 结果
     */
    public int deleteTWarehouseDispatchdetailById(Long id);

    /**
     * 批量删除调拨单详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWarehouseDispatchdetailByIds(Long[] ids);
}
