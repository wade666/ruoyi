package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TProductLabel;

/**
 * 商品标签Service接口
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
public interface ITProductLabelService 
{
    /**
     * 查询商品标签
     * 
     * @param id 商品标签主键
     * @return 商品标签
     */
    public TProductLabel selectTProductLabelById(Long id);

    /**
     * 查询商品标签列表
     * 
     * @param tProductLabel 商品标签
     * @return 商品标签集合
     */
    public List<TProductLabel> selectTProductLabelList(TProductLabel tProductLabel);

    /**
     * 新增商品标签
     * 
     * @param tProductLabel 商品标签
     * @return 结果
     */
    public int insertTProductLabel(TProductLabel tProductLabel);

    /**
     * 修改商品标签
     * 
     * @param tProductLabel 商品标签
     * @return 结果
     */
    public int updateTProductLabel(TProductLabel tProductLabel);

    /**
     * 批量删除商品标签
     * 
     * @param ids 需要删除的商品标签主键集合
     * @return 结果
     */
    public int deleteTProductLabelByIds(Long[] ids);

    /**
     * 删除商品标签信息
     * 
     * @param id 商品标签主键
     * @return 结果
     */
    public int deleteTProductLabelById(Long id);
}
