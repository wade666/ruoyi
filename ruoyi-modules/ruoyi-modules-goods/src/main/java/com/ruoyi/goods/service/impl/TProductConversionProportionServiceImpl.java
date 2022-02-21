package com.ruoyi.goods.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TProductConversionProportionMapper;
import com.ruoyi.goods.domain.TProductConversionProportion;
import com.ruoyi.goods.service.ITProductConversionProportionService;

/**
 * 商品规格换算Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
@Service
public class TProductConversionProportionServiceImpl implements ITProductConversionProportionService 
{
    @Autowired
    private TProductConversionProportionMapper tProductConversionProportionMapper;

    /**
     * 查询商品规格换算
     * 
     * @param conversionId 商品规格换算主键
     * @return 商品规格换算
     */
    @Override
    public TProductConversionProportion selectTProductConversionProportionByConversionId(Long conversionId)
    {
        return tProductConversionProportionMapper.selectTProductConversionProportionByConversionId(conversionId);
    }

    /**
     * 查询商品规格换算列表
     * 
     * @param tProductConversionProportion 商品规格换算
     * @return 商品规格换算
     */
    @Override
    public List<TProductConversionProportion> selectTProductConversionProportionList(TProductConversionProportion tProductConversionProportion)
    {
        return tProductConversionProportionMapper.selectTProductConversionProportionList(tProductConversionProportion);
    }

    /**
     * 新增商品规格换算
     * 
     * @param tProductConversionProportion 商品规格换算
     * @return 结果
     */
    @Override
    public int insertTProductConversionProportion(TProductConversionProportion tProductConversionProportion)
    {
        return tProductConversionProportionMapper.insertTProductConversionProportion(tProductConversionProportion);
    }

    /**
     * 修改商品规格换算
     * 
     * @param tProductConversionProportion 商品规格换算
     * @return 结果
     */
    @Override
    public int updateTProductConversionProportion(TProductConversionProportion tProductConversionProportion)
    {
        return tProductConversionProportionMapper.updateTProductConversionProportion(tProductConversionProportion);
    }

    /**
     * 批量删除商品规格换算
     * 
     * @param conversionIds 需要删除的商品规格换算主键
     * @return 结果
     */
    @Override
    public int deleteTProductConversionProportionByConversionIds(Long[] conversionIds)
    {
        return tProductConversionProportionMapper.deleteTProductConversionProportionByConversionIds(conversionIds);
    }

    /**
     * 删除商品规格换算信息
     * 
     * @param conversionId 商品规格换算主键
     * @return 结果
     */
    @Override
    public int deleteTProductConversionProportionByConversionId(Long conversionId)
    {
        return tProductConversionProportionMapper.deleteTProductConversionProportionByConversionId(conversionId);
    }
}
