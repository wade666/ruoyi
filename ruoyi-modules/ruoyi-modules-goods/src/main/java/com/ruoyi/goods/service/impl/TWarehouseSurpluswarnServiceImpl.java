package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TWarehouseSurpluswarnMapper;
import com.ruoyi.goods.domain.TWarehouseSurpluswarn;
import com.ruoyi.goods.service.ITWarehouseSurpluswarnService;

/**
 * 库存预警设置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-09
 */
@Service
public class TWarehouseSurpluswarnServiceImpl implements ITWarehouseSurpluswarnService 
{
    @Autowired
    private TWarehouseSurpluswarnMapper tWarehouseSurpluswarnMapper;

    /**
     * 查询库存预警设置
     * 
     * @param id 库存预警设置主键
     * @return 库存预警设置
     */
    @Override
    public TWarehouseSurpluswarn selectTWarehouseSurpluswarnById(Long id)
    {
        return tWarehouseSurpluswarnMapper.selectTWarehouseSurpluswarnById(id);
    }

    /**
     * 查询库存预警设置列表
     * 
     * @param tWarehouseSurpluswarn 库存预警设置
     * @return 库存预警设置
     */
    @Override
    public List<TWarehouseSurpluswarn> selectTWarehouseSurpluswarnList(TWarehouseSurpluswarn tWarehouseSurpluswarn)
    {
        return tWarehouseSurpluswarnMapper.selectTWarehouseSurpluswarnList(tWarehouseSurpluswarn);
    }

    /**
     * 新增库存预警设置
     * 
     * @param tWarehouseSurpluswarn 库存预警设置
     * @return 结果
     */
    @Override
    public int insertTWarehouseSurpluswarn(TWarehouseSurpluswarn tWarehouseSurpluswarn)
    {
        tWarehouseSurpluswarn.setCreateTime(DateUtils.getNowDate());
        return tWarehouseSurpluswarnMapper.insertTWarehouseSurpluswarn(tWarehouseSurpluswarn);
    }

    /**
     * 修改库存预警设置
     * 
     * @param tWarehouseSurpluswarn 库存预警设置
     * @return 结果
     */
    @Override
    public int updateTWarehouseSurpluswarn(TWarehouseSurpluswarn tWarehouseSurpluswarn)
    {
        tWarehouseSurpluswarn.setUpdateTime(DateUtils.getNowDate());
        return tWarehouseSurpluswarnMapper.updateTWarehouseSurpluswarn(tWarehouseSurpluswarn);
    }

    /**
     * 批量删除库存预警设置
     * 
     * @param ids 需要删除的库存预警设置主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseSurpluswarnByIds(Long[] ids)
    {
        return tWarehouseSurpluswarnMapper.deleteTWarehouseSurpluswarnByIds(ids);
    }

    /**
     * 删除库存预警设置信息
     * 
     * @param id 库存预警设置主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseSurpluswarnById(Long id)
    {
        return tWarehouseSurpluswarnMapper.deleteTWarehouseSurpluswarnById(id);
    }
}
