package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TShippingReverseConfigMapper;
import com.ruoyi.goods.domain.TShippingReverseConfig;
import com.ruoyi.goods.service.ITShippingReverseConfigService;

/**
 * 物流拒收配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
@Service
public class TShippingReverseConfigServiceImpl implements ITShippingReverseConfigService 
{
    @Autowired
    private TShippingReverseConfigMapper tShippingReverseConfigMapper;

    /**
     * 查询物流拒收配置
     * 
     * @param reverseId 物流拒收配置主键
     * @return 物流拒收配置
     */
    @Override
    public TShippingReverseConfig selectTShippingReverseConfigByReverseId(Long reverseId)
    {
        return tShippingReverseConfigMapper.selectTShippingReverseConfigByReverseId(reverseId);
    }

    /**
     * 查询物流拒收配置列表
     * 
     * @param tShippingReverseConfig 物流拒收配置
     * @return 物流拒收配置
     */
    @Override
    public List<TShippingReverseConfig> selectTShippingReverseConfigList(TShippingReverseConfig tShippingReverseConfig)
    {
        tShippingReverseConfig.setIsDelete(0);
        return tShippingReverseConfigMapper.selectTShippingReverseConfigList(tShippingReverseConfig);
    }

    /**
     * 新增物流拒收配置
     * 
     * @param tShippingReverseConfig 物流拒收配置
     * @return 结果
     */
    @Override
    public int insertTShippingReverseConfig(TShippingReverseConfig tShippingReverseConfig)
    {
        tShippingReverseConfig.setCreateTime(DateUtils.getNowDate());
        return tShippingReverseConfigMapper.insertTShippingReverseConfig(tShippingReverseConfig);
    }

    /**
     * 修改物流拒收配置
     * 
     * @param tShippingReverseConfig 物流拒收配置
     * @return 结果
     */
    @Override
    public int updateTShippingReverseConfig(TShippingReverseConfig tShippingReverseConfig)
    {
        return tShippingReverseConfigMapper.updateTShippingReverseConfig(tShippingReverseConfig);
    }

    /**
     * 批量删除物流拒收配置
     * 
     * @param reverseIds 需要删除的物流拒收配置主键
     * @return 结果
     */
    @Override
    public int deleteTShippingReverseConfigByReverseIds(Long[] reverseIds)
    {
        return tShippingReverseConfigMapper.deleteTShippingReverseConfigByReverseIds(reverseIds);
    }

    /**
     * 删除物流拒收配置信息
     * 
     * @param reverseId 物流拒收配置主键
     * @return 结果
     */
    @Override
    public int deleteTShippingReverseConfigByReverseId(Long reverseId)
    {
        return tShippingReverseConfigMapper.deleteTShippingReverseConfigByReverseId(reverseId);
    }
}
