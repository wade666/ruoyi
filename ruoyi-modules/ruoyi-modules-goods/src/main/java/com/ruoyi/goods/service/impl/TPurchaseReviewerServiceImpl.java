package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.goods.domain.vo.DictType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TPurchaseReviewerMapper;
import com.ruoyi.goods.domain.TPurchaseReviewer;
import com.ruoyi.goods.service.ITPurchaseReviewerService;

/**
 * 采购审核人配置Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
@Service
public class TPurchaseReviewerServiceImpl implements ITPurchaseReviewerService 
{
    @Autowired
    private TPurchaseReviewerMapper tPurchaseReviewerMapper;

    /**
     * 查询采购审核人配置
     * 
     * @param id 采购审核人配置主键
     * @return 采购审核人配置
     */
    @Override
    public TPurchaseReviewer selectTPurchaseReviewerById(Long id)
    {
        return tPurchaseReviewerMapper.selectTPurchaseReviewerById(id);
    }

    /**
     * 查询采购审核人配置列表
     * 
     * @param tPurchaseReviewer 采购审核人配置
     * @return 采购审核人配置
     */
    @Override
    public List<TPurchaseReviewer> selectTPurchaseReviewerList(TPurchaseReviewer tPurchaseReviewer)
    {
        if(tPurchaseReviewer.getCheckType() == null){
            tPurchaseReviewer.setCheckType(DictType.CHECKTYPE_PURCHASE);
        }
        return tPurchaseReviewerMapper.selectTPurchaseReviewerList(tPurchaseReviewer);
    }

    /**
     * 新增采购审核人配置
     * 
     * @param tPurchaseReviewer 采购审核人配置
     * @return 结果
     */
    @Override
    public int insertTPurchaseReviewer(TPurchaseReviewer tPurchaseReviewer)
    {
        checkParam(tPurchaseReviewer);
        tPurchaseReviewer.setCreateTime(DateUtils.getNowDate());
        return tPurchaseReviewerMapper.insertTPurchaseReviewer(tPurchaseReviewer);
    }
    public void checkParam(TPurchaseReviewer tPurchaseReviewer){
        if(tPurchaseReviewer.getCheckType() == null){
            throw new ServiceException("审核类型不能为空");
        }
        if(tPurchaseReviewer.getCheckUserId() == null){
            throw new ServiceException("审核人不能为空");
        }
    }
    /**
     * 修改采购审核人配置
     * 
     * @param tPurchaseReviewer 采购审核人配置
     * @return 结果
     */
    @Override
    public int updateTPurchaseReviewer(TPurchaseReviewer tPurchaseReviewer)
    {
        checkParam(tPurchaseReviewer);
        return tPurchaseReviewerMapper.updateTPurchaseReviewer(tPurchaseReviewer);
    }

    /**
     * 批量删除采购审核人配置
     * 
     * @param ids 需要删除的采购审核人配置主键
     * @return 结果
     */
    @Override
    public int deleteTPurchaseReviewerByIds(Long[] ids)
    {
        return tPurchaseReviewerMapper.deleteTPurchaseReviewerByIds(ids);
    }

    /**
     * 删除采购审核人配置信息
     * 
     * @param id 采购审核人配置主键
     * @return 结果
     */
    @Override
    public int deleteTPurchaseReviewerById(Long id)
    {
        return tPurchaseReviewerMapper.deleteTPurchaseReviewerById(id);
    }
}
