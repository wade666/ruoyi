package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TSku;

/**
 * 商品skuMapper接口
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
public interface TSkuMapper 
{
    /**
     * 查询商品sku
     * 
     * @param id 商品sku主键
     * @return 商品sku
     */
    public TSku selectTSkuById(Long id);

    /**
     * 查询商品sku列表
     * 
     * @param tSku 商品sku
     * @return 商品sku集合
     */
    public List<TSku> selectTSkuList(TSku tSku);

    /**
     * 新增商品sku
     * 
     * @param tSku 商品sku
     * @return 结果
     */
    public int insertTSku(TSku tSku);

    /**
     * 修改商品sku
     * 
     * @param tSku 商品sku
     * @return 结果
     */
    public int updateTSku(TSku tSku);

    /**
     * 删除商品sku
     * 
     * @param id 商品sku主键
     * @return 结果
     */
    public int deleteTSkuById(Long id);

    /**
     * 批量删除商品sku
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTSkuByIds(Long[] ids);

    /**
     * 根据product_id查询商品sn
     */
    TSku selectSku(TSku tSku);
}
