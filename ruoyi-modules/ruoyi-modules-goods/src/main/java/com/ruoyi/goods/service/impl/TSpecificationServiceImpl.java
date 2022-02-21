package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TSpecificationMapper;
import com.ruoyi.goods.domain.TSpecification;
import com.ruoyi.goods.service.ITSpecificationService;

/**
 * 商品规格Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
@Service
public class TSpecificationServiceImpl implements ITSpecificationService 
{
    @Autowired
    private TSpecificationMapper tSpecificationMapper;

    /**
     * 查询商品规格
     * 
     * @param id 商品规格主键
     * @return 商品规格
     */
    @Override
    public TSpecification selectTSpecificationById(Long id)
    {
        return tSpecificationMapper.selectTSpecificationById(id);
    }
    /**
     * 根据分类id获取商品规格详细信息
     */
    @Override
    public TSpecification selectTSpecificationByProductCategoryId(Long productCategoryId)
    {
        return tSpecificationMapper.selectTSpecificationById(productCategoryId);
    }
    /**
     * 查询商品规格列表
     * 
     * @param tSpecification 商品规格
     * @return 商品规格
     */
    @Override
    public List<TSpecification> selectTSpecificationList(TSpecification tSpecification)
    {
        return tSpecificationMapper.selectTSpecificationList(tSpecification);
    }

    /**
     * 新增商品规格
     * 
     * @param tSpecification 商品规格
     * @return 结果
     */
    @Override
    public int insertTSpecification(TSpecification tSpecification)
    {
        tSpecification.setCreateTime(DateUtils.getNowDate());
        return tSpecificationMapper.insertTSpecification(tSpecification);
    }

    /**
     * 修改商品规格
     * 
     * @param tSpecification 商品规格
     * @return 结果
     */
    @Override
    public int updateTSpecification(TSpecification tSpecification)
    {
        tSpecification.setUpdateTime(DateUtils.getNowDate());
        return tSpecificationMapper.updateTSpecification(tSpecification);
    }

    /**
     * 批量删除商品规格
     * 
     * @param ids 需要删除的商品规格主键
     * @return 结果
     */
    @Override
    public int deleteTSpecificationByIds(Long[] ids)
    {
        return tSpecificationMapper.deleteTSpecificationByIds(ids);
    }

    /**
     * 删除商品规格信息
     * 
     * @param id 商品规格主键
     * @return 结果
     */
    @Override
    public int deleteTSpecificationById(Long id)
    {
        return tSpecificationMapper.deleteTSpecificationById(id);
    }
}
