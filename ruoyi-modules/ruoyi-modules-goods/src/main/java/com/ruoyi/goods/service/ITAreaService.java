package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TArea;

/**
 * 省市区数据Service接口
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
public interface ITAreaService 
{

    /**
     * 查询省市区数据列表
     * @param tArea 省市区数据
     * @return 省市区数据集合
     */
    public List<TArea> selectTAreaList(TArea tArea);
}
