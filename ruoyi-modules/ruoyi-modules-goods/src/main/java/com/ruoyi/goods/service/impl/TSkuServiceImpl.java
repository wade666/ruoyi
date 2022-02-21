package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TSkuMapper;
import com.ruoyi.goods.domain.TSku;
import com.ruoyi.goods.service.ITSkuService;

/**
 * 商品skuService业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-12
 */
@Service
public class TSkuServiceImpl implements ITSkuService 
{
    @Autowired
    private TSkuMapper tSkuMapper;

    /**
     * 查询商品sku
     * 
     * @param id 商品sku主键
     * @return 商品sku
     */
    @Override
    public TSku selectTSkuById(Long id)
    {
        return tSkuMapper.selectTSkuById(id);
    }

    /**
     * 查询商品sku列表
     * 
     * @param tSku 商品sku
     * @return 商品sku
     */
    @Override
    public List<TSku> selectTSkuList(TSku tSku)
    {
        return tSkuMapper.selectTSkuList(tSku);
    }

    /**
     * 新增商品sku
     * 
     * @param tSku 商品sku
     * @return 结果
     */
    @Override
    public int insertTSku(TSku tSku)
    {
        tSku.setCreateTime(DateUtils.getNowDate());
        return tSkuMapper.insertTSku(tSku);
    }

    /**
     * 修改商品sku
     * 
     * @param tSku 商品sku
     * @return 结果
     */
    @Override
    public int updateTSku(TSku tSku)
    {
        tSku.setUpdateTime(DateUtils.getNowDate());
        return tSkuMapper.updateTSku(tSku);
    }

    /**
     * 批量删除商品sku
     * 
     * @param ids 需要删除的商品sku主键
     * @return 结果
     */
    @Override
    public int deleteTSkuByIds(Long[] ids)
    {
        return tSkuMapper.deleteTSkuByIds(ids);
    }

    /**
     * 删除商品sku信息
     * 
     * @param id 商品sku主键
     * @return 结果
     */
    @Override
    public int deleteTSkuById(Long id)
    {
        return tSkuMapper.deleteTSkuById(id);
    }
}
