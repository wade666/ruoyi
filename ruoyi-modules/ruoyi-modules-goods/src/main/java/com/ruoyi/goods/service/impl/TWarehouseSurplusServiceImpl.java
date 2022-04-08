package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.datascope.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TWarehouseSurplusMapper;
import com.ruoyi.goods.domain.TWarehouseSurplus;
import com.ruoyi.goods.service.ITWarehouseSurplusService;

import javax.annotation.Resource;

/**
 * 库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-08
 */
@Service
public class TWarehouseSurplusServiceImpl implements ITWarehouseSurplusService 
{
    @Resource
    private TWarehouseSurplusMapper tWarehouseSurplusMapper;

    /**
     * 查询库存
     * 
     * @param surplusId 库存主键
     * @return 库存
     */
    @Override
    public TWarehouseSurplus selectTWarehouseSurplusBySurplusId(Long surplusId)
    {
        return tWarehouseSurplusMapper.selectTWarehouseSurplusBySurplusId(surplusId);
    }

    /**
     * 查询库存列表
     * 
     * @param tWarehouseSurplus 库存
     * @return 库存
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<TWarehouseSurplus> selectTWarehouseSurplusList(TWarehouseSurplus tWarehouseSurplus)
    {
        List<TWarehouseSurplus> list = tWarehouseSurplusMapper.selectTWarehouseSurplusList(tWarehouseSurplus);
        for(TWarehouseSurplus surplus : list){
            //低于预警值报警
            if(surplus.getWarnNum() != null && surplus.getWarnNum().compareTo(surplus.getSurplusNum())>0){
                surplus.setWarn(true);
            }
        }
        return list;
    }

    /**
     * 新增库存
     * 
     * @param tWarehouseSurplus 库存
     * @return 结果
     */
    @Override
    public int insertTWarehouseSurplus(TWarehouseSurplus tWarehouseSurplus)
    {
        tWarehouseSurplus.setCreateTime(DateUtils.getNowDate());
        return tWarehouseSurplusMapper.insertTWarehouseSurplus(tWarehouseSurplus);
    }

    /**
     * 修改库存
     * 
     * @param tWarehouseSurplus 库存
     * @return 结果
     */
    @Override
    public int updateTWarehouseSurplus(TWarehouseSurplus tWarehouseSurplus)
    {
        tWarehouseSurplus.setUpdateTime(DateUtils.getNowDate());
        return tWarehouseSurplusMapper.updateTWarehouseSurplus(tWarehouseSurplus);
    }

    /**
     * 批量删除库存
     * 
     * @param surplusIds 需要删除的库存主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseSurplusBySurplusIds(Long[] surplusIds)
    {
        return tWarehouseSurplusMapper.deleteTWarehouseSurplusBySurplusIds(surplusIds);
    }

    /**
     * 删除库存信息
     * 
     * @param surplusId 库存主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseSurplusBySurplusId(Long surplusId)
    {
        return tWarehouseSurplusMapper.deleteTWarehouseSurplusBySurplusId(surplusId);
    }

    @Override
    public List<TWarehouseSurplus> selectTWarehouseSurplusByWarehouseId(TWarehouseSurplus tWarehouseSurplus) {
        return tWarehouseSurplusMapper.selectTWarehouseSurplusByWarehouseId(tWarehouseSurplus);
    }
}
