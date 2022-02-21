package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TWarehouseMapper;
import com.ruoyi.goods.domain.TWarehouse;
import com.ruoyi.goods.service.ITWarehouseService;

/**
 * 仓库Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
@Service
public class TWarehouseServiceImpl implements ITWarehouseService 
{
    @Autowired
    private TWarehouseMapper tWarehouseMapper;

    /**
     * 查询仓库
     * 
     * @param id 仓库主键
     * @return 仓库
     */
    @Override
    public TWarehouse selectTWarehouseById(Long id)
    {
        return tWarehouseMapper.selectTWarehouseById(id);
    }

    /**
     * 查询仓库列表
     * 
     * @param tWarehouse 仓库
     * @return 仓库
     */
    @Override
    public List<TWarehouse> selectTWarehouseList(TWarehouse tWarehouse)
    {
        return tWarehouseMapper.selectTWarehouseList(tWarehouse);
    }

    /**
     * 新增仓库
     * 
     * @param tWarehouse 仓库
     * @return 结果
     */
    @Override
    public int insertTWarehouse(TWarehouse tWarehouse)
    {
        tWarehouse.setCreateTime(DateUtils.getNowDate());
        return tWarehouseMapper.insertTWarehouse(tWarehouse);
    }

    /**
     * 修改仓库
     * 
     * @param tWarehouse 仓库
     * @return 结果
     */
    @Override
    public int updateTWarehouse(TWarehouse tWarehouse)
    {
        tWarehouse.setUpdateTime(DateUtils.getNowDate());
        return tWarehouseMapper.updateTWarehouse(tWarehouse);
    }

    /**
     * 批量删除仓库
     * 
     * @param ids 需要删除的仓库主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseByIds(Long[] ids)
    {
        return tWarehouseMapper.deleteTWarehouseByIds(ids);
    }

    /**
     * 删除仓库信息
     * 
     * @param id 仓库主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseById(Long id)
    {
        return tWarehouseMapper.deleteTWarehouseById(id);
    }
}
