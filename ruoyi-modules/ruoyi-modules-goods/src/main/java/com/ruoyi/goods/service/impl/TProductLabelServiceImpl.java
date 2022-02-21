package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TProductLabelMapper;
import com.ruoyi.goods.domain.TProductLabel;
import com.ruoyi.goods.service.ITProductLabelService;

/**
 * 商品标签Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
@Service
public class TProductLabelServiceImpl implements ITProductLabelService 
{
    @Autowired
    private TProductLabelMapper tProductLabelMapper;

    /**
     * 查询商品标签
     * 
     * @param id 商品标签主键
     * @return 商品标签
     */
    @Override
    public TProductLabel selectTProductLabelById(Long id)
    {
        return tProductLabelMapper.selectTProductLabelById(id);
    }

    /**
     * 查询商品标签列表
     * 
     * @param tProductLabel 商品标签
     * @return 商品标签
     */
    @Override
    public List<TProductLabel> selectTProductLabelList(TProductLabel tProductLabel)
    {
        return tProductLabelMapper.selectTProductLabelList(tProductLabel);
    }

    /**
     * 新增商品标签
     * 
     * @param tProductLabel 商品标签
     * @return 结果
     */
    @Override
    public int insertTProductLabel(TProductLabel tProductLabel)
    {
        tProductLabel.setCreateTime(DateUtils.getNowDate());
        return tProductLabelMapper.insertTProductLabel(tProductLabel);
    }

    /**
     * 修改商品标签
     * 
     * @param tProductLabel 商品标签
     * @return 结果
     */
    @Override
    public int updateTProductLabel(TProductLabel tProductLabel)
    {
        tProductLabel.setUpdateTime(DateUtils.getNowDate());
        return tProductLabelMapper.updateTProductLabel(tProductLabel);
    }

    /**
     * 批量删除商品标签
     * 
     * @param ids 需要删除的商品标签主键
     * @return 结果
     */
    @Override
    public int deleteTProductLabelByIds(Long[] ids)
    {
        return tProductLabelMapper.deleteTProductLabelByIds(ids);
    }

    /**
     * 删除商品标签信息
     * 
     * @param id 商品标签主键
     * @return 结果
     */
    @Override
    public int deleteTProductLabelById(Long id)
    {
        return tProductLabelMapper.deleteTProductLabelById(id);
    }
}
