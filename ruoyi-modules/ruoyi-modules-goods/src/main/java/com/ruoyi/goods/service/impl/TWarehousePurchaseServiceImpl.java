package com.ruoyi.goods.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.datascope.annotation.DataScope;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.goods.mapper.TWarehouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TWarehousePurchaseMapper;
import com.ruoyi.goods.domain.TWarehousePurchase;
import com.ruoyi.goods.service.ITWarehousePurchaseService;

/**
 * 采购申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
@Service
public class TWarehousePurchaseServiceImpl implements ITWarehousePurchaseService 
{
    @Autowired
    private TWarehousePurchaseMapper tWarehousePurchaseMapper;
    @Autowired
    private TWarehouseMapper tWarehouseMapper;

    /**
     * 查询采购申请
     * 
     * @param id 采购申请主键
     * @return 采购申请
     */
    @Override
    public TWarehousePurchase selectTWarehousePurchaseById(Long id)
    {
        return tWarehousePurchaseMapper.selectTWarehousePurchaseById(id);
    }

    /**
     * 查询采购申请列表
     * 
     * @param tWarehousePurchase 采购申请
     * @return 采购申请
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<TWarehousePurchase> selectTWarehousePurchaseList(TWarehousePurchase tWarehousePurchase)
    {
        List<TWarehousePurchase> list = new ArrayList<>();
        //本人及部门的采购单
        if(tWarehousePurchase.getQueryType()!= null && tWarehousePurchase.getQueryType() == 1){
            list = tWarehousePurchaseMapper.selectTWarehousePurchaseList(tWarehousePurchase);
        }
        //仓库下面的采购单
        if(tWarehousePurchase.getQueryType()!= null && tWarehousePurchase.getQueryType() == 2){
            list = tWarehousePurchaseMapper.selectTWarehousePurchaseListBySysUserId(tWarehousePurchase);
        }
        return list;
    }

    /**
     * 新增采购申请
     * 
     * @param tWarehousePurchase 采购申请
     * @return 结果
     */
    @Override
    public int insertTWarehousePurchase(TWarehousePurchase tWarehousePurchase)
    {
        tWarehousePurchase.setSysUserId(SecurityUtils.getUserId());
        return tWarehousePurchaseMapper.insertTWarehousePurchase(tWarehousePurchase);
    }

    /**
     * 修改采购申请
     * 
     * @param tWarehousePurchase 采购申请
     * @return 结果
     */
    @Override
    public int updateTWarehousePurchase(TWarehousePurchase tWarehousePurchase)
    {
        return tWarehousePurchaseMapper.updateTWarehousePurchase(tWarehousePurchase);
    }

    /**
     * 批量删除采购申请
     * 
     * @param ids 需要删除的采购申请主键
     * @return 结果
     */
    @Override
    public int deleteTWarehousePurchaseByIds(Long[] ids)
    {
        return tWarehousePurchaseMapper.deleteTWarehousePurchaseByIds(ids);
    }

    /**
     * 删除采购申请信息
     * 
     * @param id 采购申请主键
     * @return 结果
     */
    @Override
    public int deleteTWarehousePurchaseById(Long id)
    {
        return tWarehousePurchaseMapper.deleteTWarehousePurchaseById(id);
    }
}
