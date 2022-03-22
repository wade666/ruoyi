package com.ruoyi.goods.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TAreaMapper;
import com.ruoyi.goods.domain.TArea;
import com.ruoyi.goods.service.ITAreaService;

/**
 * 省市区数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
@Service
public class TAreaServiceImpl implements ITAreaService 
{
    @Autowired
    private TAreaMapper tAreaMapper;

    /**
     * 查询省市区数据列表
     * @param tArea 省市区数据
     * @return 省市区数据
     */
    @Override
    public List<TArea> selectTAreaList(TArea tArea)
    {
        if(tArea.getPid() == null){
            tArea.setPid(0L);
        }
        return tAreaMapper.selectTAreaList(tArea);
    }
}
