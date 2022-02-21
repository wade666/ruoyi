package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TShippingMethod;

/**
 * 配送方式Service接口
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
public interface ITShippingMethodService 
{
    /**
     * 查询配送方式
     * 
     * @param id 配送方式主键
     * @return 配送方式
     */
    public TShippingMethod selectTShippingMethodById(Long id);

    /**
     * 查询配送方式列表
     * 
     * @param tShippingMethod 配送方式
     * @return 配送方式集合
     */
    public List<TShippingMethod> selectTShippingMethodList(TShippingMethod tShippingMethod);

    /**
     * 新增配送方式
     * 
     * @param tShippingMethod 配送方式
     * @return 结果
     */
    public int insertTShippingMethod(TShippingMethod tShippingMethod);

    /**
     * 修改配送方式
     * 
     * @param tShippingMethod 配送方式
     * @return 结果
     */
    public int updateTShippingMethod(TShippingMethod tShippingMethod);

    /**
     * 批量删除配送方式
     * 
     * @param ids 需要删除的配送方式主键集合
     * @return 结果
     */
    public int deleteTShippingMethodByIds(Long[] ids);

    /**
     * 删除配送方式信息
     * 
     * @param id 配送方式主键
     * @return 结果
     */
    public int deleteTShippingMethodById(Long id);
}
