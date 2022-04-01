package com.ruoyi.goods.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.datascope.annotation.DataScope;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.goods.domain.TPurchaseReviewer;
import com.ruoyi.goods.domain.TWarehousePurchasedetail;
import com.ruoyi.goods.domain.TWarehousePurchaserecord;
import com.ruoyi.goods.domain.vo.DictType;
import com.ruoyi.goods.mapper.*;
import com.ruoyi.goods.mapper.TWarehousePurchaserecordMapper;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.domain.TWarehousePurchase;
import com.ruoyi.goods.service.ITWarehousePurchaseService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * 采购申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
@Service
public class TWarehousePurchaseServiceImpl implements ITWarehousePurchaseService 
{
    @Resource
    private TWarehousePurchaseMapper tWarehousePurchaseMapper;
    @Resource
    private TWarehousePurchasedetailMapper tWarehousePurchasedetailMapper;
    @Resource
    private TPurchaseReviewerMapper tPurchaseReviewerMapper;
    @Resource
    private TWarehousePurchaserecordMapper tWarehousePurchaserecordMapper;

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
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public int insertTWarehousePurchase(TWarehousePurchase tWarehousePurchase)
    {
        setCheckStep(tWarehousePurchase);
        tWarehousePurchase.setSysUserId(SecurityUtils.getUserId());
        tWarehousePurchase.setCreateBy(SecurityUtils.getUsername());
        tWarehousePurchase.setCreateTime(DateUtils.getNowDate());
        int count = tWarehousePurchaseMapper.insertTWarehousePurchase(tWarehousePurchase);
        List<TWarehousePurchasedetail> detailList = tWarehousePurchase.getDetailList();
        if(detailList != null && detailList.size()>0){
            for(TWarehousePurchasedetail detail : detailList){
                detail.setPurchaseId(tWarehousePurchase.getId());
                tWarehousePurchasedetailMapper.insertTWarehousePurchasedetail(detail);
            }
        }
        return count;
    }

    public void setCheckStep(TWarehousePurchase tWarehousePurchase){
        TPurchaseReviewer reviewer = new TPurchaseReviewer();
        reviewer.setCheckType(DictType.CHECKTYPE_PURCHASE);
        List<TPurchaseReviewer> list = tPurchaseReviewerMapper.selectTPurchaseReviewerList(reviewer);
        String checkStep = "";
        String checkIds = "";
        if(list == null || list.size() == 0){
            throw new ServiceException("请先到系统配置采购审核人");
        }
        for (TPurchaseReviewer domain : list) {
            checkStep = checkStep + domain.getUserName() + "—";
            checkIds = checkIds + domain.getCheckUserId() + ",";
        }
        tWarehousePurchase.setNowCheckId(list.get(0).getCheckUserId());
        checkStep = checkStep.substring(0,checkStep.lastIndexOf("—"));
        tWarehousePurchase.setCheckStep(checkStep);
        checkIds = checkIds.substring(0,checkIds.lastIndexOf(","));
        tWarehousePurchase.setCheckIds(checkIds);
        tWarehousePurchase.setCheckIndex(0);
        tWarehousePurchase.setApplyState(1);//1 审核中
    }
    /**
     * 修改采购申请-拒绝时可修改
     */
    @Override
    public int updateTWarehousePurchase(TWarehousePurchase tWarehousePurchase)
    {
        setCheckStep(tWarehousePurchase);
        tWarehousePurchase.setUpdateTime(DateUtils.getNowDate());
        int count = tWarehousePurchaseMapper.updateTWarehousePurchase(tWarehousePurchase);
        List<TWarehousePurchasedetail> detailList = tWarehousePurchase.getDetailList();
        if(detailList != null && detailList.size()>0){
            for(TWarehousePurchasedetail detail : detailList){
                tWarehousePurchasedetailMapper.updateTWarehousePurchasedetail(detail);
            }
        }
        return count;
    }
    /**
     * 采购申请审核
     */
    @Override
    public int updateTWarehousePurchaseCheck(TWarehousePurchase tWarehousePurchase)
    {
        String bak = "";
        Integer state = null;
        TWarehousePurchase tWarehouse = selectTWarehousePurchaseById(tWarehousePurchase.getId());
        if(tWarehouse == null){
            throw new ServiceException("记录不存在");
        }
        if(tWarehousePurchase.getApplyState() != null && tWarehousePurchase.getApplyState() == 2){
            bak = "审核通过";
            String [] ids = tWarehouse.getCheckIds().split(",");
            int index = tWarehouse.getCheckIndex()+1;
            if(index < ids.length){
                tWarehousePurchase.setNowCheckId(Long.valueOf(ids[index]));
                tWarehousePurchase.setCheckIndex(index);
            }
            if(index == ids.length){
                tWarehousePurchase.setNowCheckId(null);
                //最后一个审核人并且同意
                state = 2;
            }
        }
        if(tWarehousePurchase.getApplyState() != null && tWarehousePurchase.getApplyState() == 3){
            bak = "审核拒绝";
            state = 3;
        }
        if(StringUtils.isEmpty(tWarehousePurchase.getRemark())){
            tWarehousePurchase.setRemark(SecurityUtils.getUsername()+ bak);
        }
        tWarehousePurchase.setApplyState(state);
        tWarehousePurchase.setUpdateTime(DateUtils.getNowDate());
        TWarehousePurchaserecord record = new TWarehousePurchaserecord();
        record.setPurchaseId(tWarehousePurchase.getId());
        record.setCheckOper(bak);
        record.setSysUserId(SecurityUtils.getUserId());
        record.setCreateTime(DateUtils.getNowDate());
        record.setRemark(tWarehousePurchase.getRemark());
        record.setCheckType(DictType.CHECKTYPE_IN_WAREHOUSE);
        tWarehousePurchaserecordMapper.insertTWarehousePurchaserecord(record);
        return tWarehousePurchaseMapper.updateTWarehousePurchaseCheck(tWarehousePurchase);
    }
    /**
     * 采购审核记录列表
     */
    @Override
    public List<TWarehousePurchaserecord> selectTWarehousePurchaseCheckList(TWarehousePurchase tWarehousePurchase) {
        if(tWarehousePurchase.getId() == null){
            throw new ServiceException("采购申请id不能为空");
        }
        TWarehousePurchaserecord tWarehousePurchaserecord = new TWarehousePurchaserecord();
        tWarehousePurchaserecord.setCheckType(DictType.CHECKTYPE_PURCHASE);
        tWarehousePurchaserecord.setPurchaseId(tWarehousePurchase.getId());
        return tWarehousePurchaserecordMapper.selectTWarehousePurchaserecordList(tWarehousePurchaserecord);
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

    @Override
    public List<TWarehousePurchase> checkList(TWarehousePurchase tWarehousePurchase) {
        tWarehousePurchase.setNowCheckId(SecurityUtils.getUserId());
        return tWarehousePurchaseMapper.checkList(tWarehousePurchase);
    }
}
