package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TArea;

/**
 * 省市区数据Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
public interface TAreaMapper 
{
    /**
     * 查询省市区数据列表
     * 
     * @param tArea 省市区数据
     * @return 省市区数据集合
     */
    public List<TArea> selectTAreaList(TArea tArea);
}
