package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TShippingMethodMapper;
import com.ruoyi.goods.domain.TShippingMethod;
import com.ruoyi.goods.service.ITShippingMethodService;

/**
 * 配送方式Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
@Service
public class TShippingMethodServiceImpl implements ITShippingMethodService 
{
    @Autowired
    private TShippingMethodMapper tShippingMethodMapper;

    /**
     * 查询配送方式
     * 
     * @param id 配送方式主键
     * @return 配送方式
     */
    @Override
    public TShippingMethod selectTShippingMethodById(Long id)
    {
        return tShippingMethodMapper.selectTShippingMethodById(id);
    }

    /**
     * 查询配送方式列表
     * 
     * @param tShippingMethod 配送方式
     * @return 配送方式
     */
    @Override
    public List<TShippingMethod> selectTShippingMethodList(TShippingMethod tShippingMethod)
    {
        return tShippingMethodMapper.selectTShippingMethodList(tShippingMethod);
    }

    /**
     * 新增配送方式
     * 
     * @param tShippingMethod 配送方式
     * @return 结果
     */
    @Override
    public int insertTShippingMethod(TShippingMethod tShippingMethod)
    {
        tShippingMethod.setCreateTime(DateUtils.getNowDate());
        return tShippingMethodMapper.insertTShippingMethod(tShippingMethod);
    }

    /**
     * 修改配送方式
     * 
     * @param tShippingMethod 配送方式
     * @return 结果
     */
    @Override
    public int updateTShippingMethod(TShippingMethod tShippingMethod)
    {
        tShippingMethod.setUpdateTime(DateUtils.getNowDate());
        return tShippingMethodMapper.updateTShippingMethod(tShippingMethod);
    }

    /**
     * 批量删除配送方式
     * 
     * @param ids 需要删除的配送方式主键
     * @return 结果
     */
    @Override
    public int deleteTShippingMethodByIds(Long[] ids)
    {
        return tShippingMethodMapper.deleteTShippingMethodByIds(ids);
    }

    /**
     * 删除配送方式信息
     * 
     * @param id 配送方式主键
     * @return 结果
     */
    @Override
    public int deleteTShippingMethodById(Long id)
    {
        return tShippingMethodMapper.deleteTShippingMethodById(id);
    }
}
