package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TWarehouse;

/**
 * 仓库Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
public interface TWarehouseMapper 
{
    /**
     * 查询仓库
     * 
     * @param id 仓库主键
     * @return 仓库
     */
    public TWarehouse selectTWarehouseById(Long id);

    /**
     * 查询仓库列表
     * 
     * @param tWarehouse 仓库
     * @return 仓库集合
     */
    public List<TWarehouse> selectTWarehouseList(TWarehouse tWarehouse);

    /**
     * 新增仓库
     * 
     * @param tWarehouse 仓库
     * @return 结果
     */
    public int insertTWarehouse(TWarehouse tWarehouse);

    /**
     * 修改仓库
     * 
     * @param tWarehouse 仓库
     * @return 结果
     */
    public int updateTWarehouse(TWarehouse tWarehouse);

    /**
     * 删除仓库
     * 
     * @param id 仓库主键
     * @return 结果
     */
    public int deleteTWarehouseById(Long id);

    /**
     * 批量删除仓库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWarehouseByIds(Long[] ids);
}
