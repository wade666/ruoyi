package com.ruoyi.goods.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.goods.domain.TArea;
import com.ruoyi.goods.mapper.TAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TSupplierMapper;
import com.ruoyi.goods.domain.TSupplier;
import com.ruoyi.goods.service.ITSupplierService;

/**
 * 供货商Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
@Service
public class TSupplierServiceImpl implements ITSupplierService 
{
    @Autowired
    private TSupplierMapper tSupplierMapper;
    @Autowired
    private TAreaMapper tAreaMapper;
    /**
     * 查询供货商
     * 
     * @param id 供货商主键
     * @return 供货商
     */
    @Override
    public TSupplier selectTSupplierById(Long id)
    {
        return tSupplierMapper.selectTSupplierById(id);
    }

    /**
     * 查询供货商列表
     * 
     * @param tSupplier 供货商
     * @return 供货商
     */
    @Override
    public List<TSupplier> selectTSupplierList(TSupplier tSupplier)
    {
        return tSupplierMapper.selectTSupplierList(tSupplier);
    }
    /**
     * 新增供货商
     * 
     * @param tSupplier 供货商
     * @return 结果
     */
    @Override
    public int insertTSupplier(TSupplier tSupplier)
    {
        tSupplier.setCreateTime(DateUtils.getNowDate());
        return tSupplierMapper.insertTSupplier(tSupplier);
    }

    /**
     * 修改供货商
     * 
     * @param tSupplier 供货商
     * @return 结果
     */
    @Override
    public int updateTSupplier(TSupplier tSupplier)
    {
        tSupplier.setUpdateTime(DateUtils.getNowDate());
        return tSupplierMapper.updateTSupplier(tSupplier);
    }

    /**
     * 批量删除供货商
     * 
     * @param ids 需要删除的供货商主键
     * @return 结果
     */
    @Override
    public int deleteTSupplierByIds(Long[] ids)
    {
        return tSupplierMapper.deleteTSupplierByIds(ids);
    }

    /**
     * 删除供货商信息
     * 
     * @param id 供货商主键
     * @return 结果
     */
    @Override
    public int deleteTSupplierById(Long id)
    {
        return tSupplierMapper.deleteTSupplierById(id);
    }
}
