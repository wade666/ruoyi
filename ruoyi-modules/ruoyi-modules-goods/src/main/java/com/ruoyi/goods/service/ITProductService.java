package com.ruoyi.goods.service;

import com.ruoyi.goods.domain.TProduct;

import java.util.List;

/**
 * 商品Service接口
 *
 * @author ruoyi
 * @date 2022-01-22
 */
public interface ITProductService {
    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    public TProduct selectTProductById(Long id);

    /**
     * 查询商品列表
     *
     * @param tProduct 商品
     * @return 商品集合
     */
    public List<TProduct> selectTProductList(TProduct tProduct);

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
     * 批量删除商品
     *
     * @param ids 需要删除的商品主键集合
     * @return 结果
     */
    public int deleteTProductByIds(Long[] ids);

    /**
     * 删除商品信息
     *
     * @param id 商品主键
     * @return 结果
     */
    public int deleteTProductById(Long id);

    /**
     * 修改上下架状态
     */
    public int updateTProductStatus(TProduct tProduct);
}
