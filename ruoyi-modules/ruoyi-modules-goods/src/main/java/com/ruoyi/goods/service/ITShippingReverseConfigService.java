package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TShippingReverseConfig;

/**
 * 物流拒收配置Service接口
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
public interface ITShippingReverseConfigService 
{
    /**
     * 查询物流拒收配置
     * 
     * @param reverseId 物流拒收配置主键
     * @return 物流拒收配置
     */
    public TShippingReverseConfig selectTShippingReverseConfigByReverseId(Long reverseId);

    /**
     * 查询物流拒收配置列表
     * 
     * @param tShippingReverseConfig 物流拒收配置
     * @return 物流拒收配置集合
     */
    public List<TShippingReverseConfig> selectTShippingReverseConfigList(TShippingReverseConfig tShippingReverseConfig);

    /**
     * 新增物流拒收配置
     * 
     * @param tShippingReverseConfig 物流拒收配置
     * @return 结果
     */
    public int insertTShippingReverseConfig(TShippingReverseConfig tShippingReverseConfig);

    /**
     * 修改物流拒收配置
     * 
     * @param tShippingReverseConfig 物流拒收配置
     * @return 结果
     */
    public int updateTShippingReverseConfig(TShippingReverseConfig tShippingReverseConfig);

    /**
     * 批量删除物流拒收配置
     * 
     * @param reverseIds 需要删除的物流拒收配置主键集合
     * @return 结果
     */
    public int deleteTShippingReverseConfigByReverseIds(Long[] reverseIds);

    /**
     * 删除物流拒收配置信息
     * 
     * @param reverseId 物流拒收配置主键
     * @return 结果
     */
    public int deleteTShippingReverseConfigByReverseId(Long reverseId);
}
