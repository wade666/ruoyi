package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TProductLabel;

/**
 * 商品标签Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-16
 */
public interface TProductLabelMapper 
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
     * 删除商品标签
     * 
     * @param id 商品标签主键
     * @return 结果
     */
    public int deleteTProductLabelById(Long id);

    /**
     * 批量删除商品标签
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProductLabelByIds(Long[] ids);
}
