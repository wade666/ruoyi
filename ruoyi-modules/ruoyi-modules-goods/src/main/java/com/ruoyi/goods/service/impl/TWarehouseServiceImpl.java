package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.datascope.annotation.DataScope;
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
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<TWarehouse> selectTWarehouseList(TWarehouse tWarehouse)
    {
        tWarehouse.setParentId(0L);
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
        tWarehouse.setWarehouseType(1);
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
        TWarehouse house = new TWarehouse();
        house.setSysUserId(tWarehouse.getSysUserId());
        house.setAddress(tWarehouse.getAddress());
        house.setPhone(tWarehouse.getPhone());
        house.setParentId(tWarehouse.getId());
        house.setUpdateTime(DateUtils.getNowDate());
        tWarehouseMapper.updateTWarehouseParent(house);
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
        List<TWarehouse> list = tWarehouseMapper.selectTWarehouseByParentId(id);
        if(list != null && list.size()> 0){
            throw new ServiceException("有所属子仓库不能删除");
        }
        return tWarehouseMapper.deleteTWarehouseById(id);
    }

    @Override
    public int insertTWarehouseChild(TWarehouse tWarehouse) {
        if(tWarehouse.getParentId() == null){
            throw new ServiceException("父id不能为空");
        }
        TWarehouse house = tWarehouseMapper.selectTWarehouseById(tWarehouse.getParentId());
        if(house == null){
            throw new ServiceException("父仓库不存在");
        }
        tWarehouse.setWarehouseType(2);
        tWarehouse.setAddress(house.getAddress());
        tWarehouse.setSysUserId(house.getSysUserId());
        tWarehouse.setPhone(house.getPhone());
        tWarehouse.setCreateTime(DateUtils.getNowDate());
        return tWarehouseMapper.insertTWarehouse(tWarehouse);
    }

    @Override
    public int updateTWarehouseChild(TWarehouse tWarehouse) {
        tWarehouse.setUpdateTime(DateUtils.getNowDate());
        return tWarehouseMapper.updateTWarehouse(tWarehouse);
    }

    @Override
    public List<TWarehouse> selectTWarehouseListChild(TWarehouse tWarehouse) {
        return tWarehouseMapper.selectTWarehouseByParentId(tWarehouse.getId());
    }
}
