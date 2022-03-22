package com.ruoyi.goods.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.datascope.annotation.DataScope;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.goods.domain.TProduct;
import com.ruoyi.goods.mapper.TProductMapper;
import com.ruoyi.goods.service.ITProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-22
 */
@Service
public class TProductServiceImpl implements ITProductService {
    @Autowired
    private TProductMapper tProductMapper;

    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public TProduct selectTProductById(Long id) {
        return tProductMapper.selectTProductById(id);
    }

    /**
     * 查询商品列表-数据权限-所有
     *
     * @param tProduct 商品
     * @return 商品
     */
    @Override
    public List<TProduct> selectTProductList(TProduct tProduct) {
        return tProductMapper.selectTProductList(tProduct);
    }
    /**
     * 查询商品列表-数据权限-动态
     */
    @Override
    public List<TProduct> selectTProductListByProject(TProduct tProduct) {
        tProduct.setUserId(SecurityUtils.getUserId());
        return tProductMapper.selectTProductListByProject(tProduct);
    }
    /**
     * 新增商品
     *
     * @param tProduct 商品
     * @return 结果
     */
    @Override
    public int insertTProduct(TProduct tProduct) {
        tProduct.setCreateTime(DateUtils.getNowDate());
        return tProductMapper.insertTProduct(tProduct);
    }

    /**
     * 修改商品
     *
     * @param tProduct 商品
     * @return 结果
     */
    @Override
    public int updateTProduct(TProduct tProduct) {
        tProduct.setUpdateTime(DateUtils.getNowDate());
        return tProductMapper.updateTProduct(tProduct);
    }

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteTProductByIds(Long[] ids) {
        return tProductMapper.deleteTProductByIds(ids);
    }

    /**
     * 删除商品信息
     *
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteTProductById(Long id) {
        return tProductMapper.deleteTProductById(id);
    }

    @Override
    public int updateTProductStatus(TProduct tProduct) {
        return tProductMapper.updateTProduct(tProduct);
    }
}
