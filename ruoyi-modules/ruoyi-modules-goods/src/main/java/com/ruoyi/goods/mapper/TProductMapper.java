package com.ruoyi.goods.mapper;

import com.ruoyi.goods.domain.TProduct;

import java.util.List;

/**
 * 商品Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-22
 */
public interface TProductMapper {
    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    public TProduct selectTProductById(Long id);

    /**
     * 查询商品列表-数据权限-所有
     *
     * @param tProduct 商品
     * @return 商品集合
     */
    public List<TProduct> selectTProductList(TProduct tProduct);
    /**
     * 查询商品列表-数据权限-动态
     */
    public List<TProduct> selectTProductListByProject(TProduct tProduct);
    /**
     * 新增商品
     *
     * @param tProduct 商品
     * @return 结果
     */
    public int insertTProduct(TProduct tProduct);

    /**
     * 修改商品
     *
     * @param tProduct 商品
     * @return 结果
     */
    public int updateTProduct(TProduct tProduct);

    /**
     * 删除商品
     *
     * @param id 商品主键
     * @return 结果
     */
    public int deleteTProductById(Long id);

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProductByIds(Long[] ids);
}
