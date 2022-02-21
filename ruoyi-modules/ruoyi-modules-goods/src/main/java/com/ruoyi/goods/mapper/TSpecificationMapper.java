package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TSpecification;

/**
 * 商品规格Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
public interface TSpecificationMapper 
{
    /**
     * 查询商品规格
     * 
     * @param id 商品规格主键
     * @return 商品规格
     */
    public TSpecification selectTSpecificationById(Long id);
    /**
     * 根据分类id获取商品规格详细信息
     */
    public TSpecification selectTSpecificationByProductCategoryId(Long productCategoryId);

    /**
     * 查询商品规格列表
     * 
     * @param tSpecification 商品规格
     * @return 商品规格集合
     */
    public List<TSpecification> selectTSpecificationList(TSpecification tSpecification);

    /**
     * 新增商品规格
     * 
     * @param tSpecification 商品规格
     * @return 结果
     */
    public int insertTSpecification(TSpecification tSpecification);

    /**
     * 修改商品规格
     * 
     * @param tSpecification 商品规格
     * @return 结果
     */
    public int updateTSpecification(TSpecification tSpecification);

    /**
     * 删除商品规格
     * 
     * @param id 商品规格主键
     * @return 结果
     */
    public int deleteTSpecificationById(Long id);

    /**
     * 批量删除商品规格
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTSpecificationByIds(Long[] ids);
}
