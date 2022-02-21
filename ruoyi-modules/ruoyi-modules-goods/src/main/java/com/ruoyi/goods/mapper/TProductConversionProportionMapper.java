package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TProductConversionProportion;

/**
 * 商品规格换算Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
public interface TProductConversionProportionMapper 
{
    /**
     * 查询商品规格换算
     * 
     * @param conversionId 商品规格换算主键
     * @return 商品规格换算
     */
    public TProductConversionProportion selectTProductConversionProportionByConversionId(Long conversionId);

    /**
     * 查询商品规格换算列表
     * 
     * @param tProductConversionProportion 商品规格换算
     * @return 商品规格换算集合
     */
    public List<TProductConversionProportion> selectTProductConversionProportionList(TProductConversionProportion tProductConversionProportion);

    /**
     * 新增商品规格换算
     * 
     * @param tProductConversionProportion 商品规格换算
     * @return 结果
     */
    public int insertTProductConversionProportion(TProductConversionProportion tProductConversionProportion);

    /**
     * 修改商品规格换算
     * 
     * @param tProductConversionProportion 商品规格换算
     * @return 结果
     */
    public int updateTProductConversionProportion(TProductConversionProportion tProductConversionProportion);

    /**
     * 删除商品规格换算
     * 
     * @param conversionId 商品规格换算主键
     * @return 结果
     */
    public int deleteTProductConversionProportionByConversionId(Long conversionId);

    /**
     * 批量删除商品规格换算
     * 
     * @param conversionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProductConversionProportionByConversionIds(Long[] conversionIds);
}
