package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TPurchaseReviewer;

/**
 * 采购审核人配置Service接口
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public interface ITPurchaseReviewerService 
{
    /**
     * 查询采购审核人配置
     * 
     * @param id 采购审核人配置主键
     * @return 采购审核人配置
     */
    public TPurchaseReviewer selectTPurchaseReviewerById(Long id);

    /**
     * 查询采购审核人配置列表
     * 
     * @param tPurchaseReviewer 采购审核人配置
     * @return 采购审核人配置集合
     */
    public List<TPurchaseReviewer> selectTPurchaseReviewerList(TPurchaseReviewer tPurchaseReviewer);

    /**
     * 新增采购审核人配置
     * 
     * @param tPurchaseReviewer 采购审核人配置
     * @return 结果
     */
    public int insertTPurchaseReviewer(TPurchaseReviewer tPurchaseReviewer);

    /**
     * 修改采购审核人配置
     * 
     * @param tPurchaseReviewer 采购审核人配置
     * @return 结果
     */
    public int updateTPurchaseReviewer(TPurchaseReviewer tPurchaseReviewer);

    /**
     * 批量删除采购审核人配置
     * 
     * @param ids 需要删除的采购审核人配置主键集合
     * @return 结果
     */
    public int deleteTPurchaseReviewerByIds(Long[] ids);

    /**
     * 删除采购审核人配置信息
     * 
     * @param id 采购审核人配置主键
     * @return 结果
     */
    public int deleteTPurchaseReviewerById(Long id);
}
