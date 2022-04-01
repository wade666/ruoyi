package com.ruoyi.goods.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.datascope.annotation.DataScope;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.goods.domain.*;
import com.ruoyi.goods.domain.vo.DictType;
import com.ruoyi.goods.mapper.*;
import com.ruoyi.goods.mapper.TWarehousePurchaserecordMapper;
import com.ruoyi.goods.service.ITWarehouseSurplusdetailsService;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.service.ITWarehousePurchaseintoService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * 采购入库单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-24
 */
@Service
public class TWarehousePurchaseintoServiceImpl implements ITWarehousePurchaseintoService 
{
    @Resource
    private TWarehousePurchaseintoMapper tWarehousePurchaseintoMapper;
    @Resource
    private TPurchaseReviewerMapper tPurchaseReviewerMapper;
    @Resource
    private TWarehousePurchaseintodetailMapper tWarehousePurchaseintodetailMapper;
    @Resource
    private TWarehousePurchaserecordMapper tWarehousePurchaserecordMapper;
    @Resource
    private TWarehouseSurplusMapper tWarehouseSurplusMapper;
    @Resource
    private TWarehousePurchasedetailMapper tWarehousePurchasedetailMapper;
    @Resource
    private TWarehousePurchaseMapper tWarehousePurchaseMapper;
    @Resource
    private TSkuMapper tSkuMapper;
    @Resource
    private ITWarehouseSurplusdetailsService tWarehouseSurplusdetailsService;

    /**
     * 查询采购入库单
     * 
     * @param id 采购入库单主键
     * @return 采购入库单
     */
    @Override
    public TWarehousePurchaseinto selectTWarehousePurchaseintoById(Long id)
    {
        return tWarehousePurchaseintoMapper.selectTWarehousePurchaseintoById(id);
    }

    /**
     * 查询采购入库单列表
     * @param tWarehousePurchaseinto 采购入库单
     * @return 采购入库单
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<TWarehousePurchaseinto> selectTWarehousePurchaseintoList(TWarehousePurchaseinto tWarehousePurchaseinto)
    {
        List<TWarehousePurchaseinto> list = new ArrayList<>();
        //本人及部门的采购入库单
        if(tWarehousePurchaseinto.getQueryType()!= null && tWarehousePurchaseinto.getQueryType() == 1){
            list = tWarehousePurchaseintoMapper.selectTWarehousePurchaseIntoList(tWarehousePurchaseinto);
        }
        //仓库下面的采购入库单
        if(tWarehousePurchaseinto.getQueryType()!= null && tWarehousePurchaseinto.getQueryType() == 2){
            list = tWarehousePurchaseintoMapper.selectTWarehousePurchaseIntoListBySysUserId(tWarehousePurchaseinto);
        }
        return list;
    }

    /**
     * 新增采购入库单
     * 
     * @param tWarehousePurchaseinto 采购入库单
     * @return 结果
     */
    @Override
    public int insertTWarehousePurchaseinto(TWarehousePurchaseinto tWarehousePurchaseinto)
    {
        setCheckStep(tWarehousePurchaseinto);
        tWarehousePurchaseinto.setSysUserId(SecurityUtils.getUserId());
        tWarehousePurchaseinto.setCreateBy(SecurityUtils.getUsername());
        tWarehousePurchaseinto.setCreateTime(DateUtils.getNowDate());
        int count = tWarehousePurchaseintoMapper.insertTWarehousePurchaseinto(tWarehousePurchaseinto);
        List<TWarehousePurchaseintodetail> detailList = tWarehousePurchaseinto.getDetailList();
        //批次号
        String batchCode = DateUtils.dateTimeNow();
        if(detailList != null && detailList.size()>0){
            for(TWarehousePurchaseintodetail detail : detailList){
                String code = String.valueOf((int)((Math.random()*9+1)*1000));
                detail.setBatchCode(batchCode+code);
                detail.setPurchaseintoId(tWarehousePurchaseinto.getId());
                detail.setPurchaseId(tWarehousePurchaseinto.getPurchaseId());
                tWarehousePurchaseintodetailMapper.insertTWarehousePurchaseintodetail(detail);
            }
        }
        return count;
    }
    public void setCheckStep(TWarehousePurchaseinto tWarehousePurchaseinto){
        TPurchaseReviewer reviewer = new TPurchaseReviewer();
        reviewer.setCheckType(DictType.CHECKTYPE_IN_WAREHOUSE);
        List<TPurchaseReviewer> list = tPurchaseReviewerMapper.selectTPurchaseReviewerList(reviewer);
        String checkStep = "";
        String checkIds = "";
        if(list == null || list.size() == 0){
            throw new ServiceException("请先到系统配置采购入库审核人");
        }
        for (TPurchaseReviewer domain : list) {
            checkStep = checkStep + domain.getUserName() + "—";
            checkIds = checkIds + domain.getCheckUserId() + ",";
        }
        tWarehousePurchaseinto.setNowCheckId(list.get(0).getCheckUserId());
        checkStep = checkStep.substring(0,checkStep.lastIndexOf("—"));
        tWarehousePurchaseinto.setCheckStep(checkStep);
        checkIds = checkIds.substring(0,checkIds.lastIndexOf(","));
        tWarehousePurchaseinto.setCheckIds(checkIds);
        tWarehousePurchaseinto.setCheckIndex(0);
        tWarehousePurchaseinto.setApplyState(1);//1 审核中
    }
    /**
     * 修改采购入库单
     * @param tWarehousePurchaseinto 采购入库单
     * @return 结果
     */
    @Override
    public int updateTWarehousePurchaseinto(TWarehousePurchaseinto tWarehousePurchaseinto)
    {
        setCheckStep(tWarehousePurchaseinto);
        tWarehousePurchaseinto.setUpdateTime(DateUtils.getNowDate());
        int count = tWarehousePurchaseintoMapper.updateTWarehousePurchaseinto(tWarehousePurchaseinto);
        List<TWarehousePurchaseintodetail> detailList = tWarehousePurchaseinto.getDetailList();
        if(detailList != null && detailList.size()>0){
            for(TWarehousePurchaseintodetail detail : detailList){
                tWarehousePurchaseinto.setUpdateTime(DateUtils.getNowDate());
                tWarehousePurchaseintodetailMapper.updateTWarehousePurchaseintodetail(detail);
            }
        }
        return count;

    }

    /**
     * 批量删除采购入库单
     * 
     * @param ids 需要删除的采购入库单主键
     * @return 结果
     */
    @Override
    public int deleteTWarehousePurchaseintoByIds(Long[] ids)
    {
        return tWarehousePurchaseintoMapper.deleteTWarehousePurchaseintoByIds(ids);
    }

    /**
     * 删除采购入库单信息
     * 
     * @param id 采购入库单主键
     * @return 结果
     */
    @Override
    public int deleteTWarehousePurchaseintoById(Long id)
    {
        return tWarehousePurchaseintoMapper.deleteTWarehousePurchaseintoById(id);
    }

    @Override
    public List<TWarehousePurchaseinto> purchaseintoCheckList(TWarehousePurchaseinto tWarehousePurchaseinto) {
        tWarehousePurchaseinto.setNowCheckId(SecurityUtils.getUserId());
        System.out.println(JSON.toJSONString(tWarehousePurchaseintoMapper.purchaseintoCheckList(tWarehousePurchaseinto)));
        return tWarehousePurchaseintoMapper.purchaseintoCheckList(tWarehousePurchaseinto);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public int updateTWarehousePurchaseIntoCheck(TWarehousePurchaseinto tWarehousePurchaseinto) {
        String bak = "";
        Integer state = null;
        TWarehousePurchaseinto tWarehouse = selectTWarehousePurchaseintoById(tWarehousePurchaseinto.getId());
        if(tWarehouse == null){
            throw new ServiceException("记录不存在");
        }
        if(tWarehousePurchaseinto.getApplyState() != null && tWarehousePurchaseinto.getApplyState() == 2){
            bak = "审核通过";
            String [] ids = tWarehouse.getCheckIds().split(",");
            int index = tWarehouse.getCheckIndex()+1;
            if(index < ids.length){
                tWarehousePurchaseinto.setNowCheckId(Long.valueOf(ids[index]));
                tWarehousePurchaseinto.setCheckIndex(index);
            }
            if(index == ids.length){
                tWarehousePurchaseinto.setNowCheckId(null);
                //最后一个审核人并且同意
                state = 2;
                //库存表加库存
                addSurplus(tWarehousePurchaseinto);
            }
        }
        if(tWarehousePurchaseinto.getApplyState() != null && tWarehousePurchaseinto.getApplyState() == 3){
            bak = "审核拒绝";
            state = 3;
        }
        if(StringUtils.isEmpty(tWarehousePurchaseinto.getRemark())){
            tWarehousePurchaseinto.setRemark(SecurityUtils.getUsername()+ bak);
        }
        tWarehousePurchaseinto.setApplyState(state);
        tWarehousePurchaseinto.setUpdateTime(DateUtils.getNowDate());
        TWarehousePurchaserecord record = new TWarehousePurchaserecord();
        record.setPurchaseId(tWarehousePurchaseinto.getId());
        record.setCheckOper(bak);
        record.setSysUserId(SecurityUtils.getUserId());
        record.setCreateTime(DateUtils.getNowDate());
        record.setRemark(tWarehousePurchaseinto.getRemark());
        record.setCheckType(DictType.CHECKTYPE_IN_WAREHOUSE);
        tWarehousePurchaserecordMapper.insertTWarehousePurchaserecord(record);
        return tWarehousePurchaseintoMapper.updateTWarehousePurchaseintoCheck(tWarehousePurchaseinto);
    }
    /**
     * 库存表加库存
     * */
    public void addSurplus(TWarehousePurchaseinto tWarehousePurchaseinto){
        String allStatus = "yes";
        Long purchaseId = null ;
        List<TWarehousePurchaseintodetail> list = tWarehousePurchaseinto.getDetailList();
        if(list != null && list.size()>0){
            for(TWarehousePurchaseintodetail detail : list){
                Long purchaseDetailId = detail.getPurchaseDetailId();

//                purchaseDetailId = 2L;
//                detail.setArriveNum(97);
//                detail.setProductId(1L);
//                detail.setPurchaseId(2L);
//                detail.setBatchCode("20220328GS");
//                tWarehousePurchaseinto.setWarehouseId(1L);

                purchaseId = detail.getPurchaseId();
                TWarehousePurchasedetail purchaseDetail = tWarehousePurchasedetailMapper.selectTWarehousePurchasedetailById(purchaseDetailId);
                if(purchaseDetail == null){
                    throw new ServiceException("采购单不存在");
                }
                TWarehouseSurplus surplus = new TWarehouseSurplus();
                surplus.setProductId(detail.getProductId());
                TSku tSku = new TSku();
                tSku.setProductId(detail.getProductId());
                tSku.setSpecificationValues(detail.getSpecificationValues());
                TSku sku = tSkuMapper.selectSku(tSku);
                if(sku != null){
                    surplus.setSn(sku.getSn());
                }
                surplus.setBatchCode(detail.getBatchCode());//批次号
                surplus.setWarehouseId(tWarehousePurchaseinto.getWarehouseId());
                surplus.setCreateTime(DateUtils.getNowDate());
                if(purchaseDetail.getApplyNum()< detail.getArriveNum()){
                    //实到数量大于采购数量，分开存
                    surplus.setSurplusNum(detail.getArriveNum()-purchaseDetail.getApplyNum());
                    tWarehouseSurplusMapper.insertTWarehouseSurplus(surplus);
                    surplus.setSurplusNum(purchaseDetail.getApplyNum());
                    tWarehouseSurplusMapper.insertTWarehouseSurplus(surplus);
                }else{
                    surplus.setSurplusNum(detail.getArriveNum());
                    tWarehouseSurplusMapper.insertTWarehouseSurplus(surplus);
                }
                int purchaseNum = tWarehouseSurplusMapper.selectSumSurplus(surplus);
                //采购数量大于累计入库数量，部分到货
                if(purchaseDetail.getApplyNum()> purchaseNum){
                    allStatus = allStatus + "no";
                }
                purchaseDetail.setAlreadyNum(purchaseNum);
                if(purchaseDetail.getApplyNum() > purchaseNum){
                    purchaseDetail.setRealNum(purchaseDetail.getApplyNum()-purchaseNum);
                }else{
                    purchaseDetail.setRealNum(0);
                }
                tWarehousePurchasedetailMapper.updateTWarehousePurchasedetail(purchaseDetail);
                //增加出入库明细
                TWarehouseSurplusdetails tWarehouseSurplusdetails = new TWarehouseSurplusdetails();
                tWarehouseSurplusdetails.setProductId(detail.getProductId());
                if(sku != null){
                    tWarehouseSurplusdetails.setSn(sku.getSn());
                }
                tWarehouseSurplusdetails.setWarehouseId(tWarehousePurchaseinto.getWarehouseId());
                tWarehouseSurplusdetails.setSupplierId(tWarehousePurchaseinto.getSupplierId());
                tWarehouseSurplusdetails.setSurplusType(DictType.SURPLUSTYPE_ONE);
                tWarehouseSurplusdetails.setDetailType(DictType.DETAILTYPE_FIVE);
                tWarehouseSurplusdetails.setBak("采购入库明细");
                tWarehouseSurplusdetails.setBatchCode(detail.getBatchCode());
                tWarehouseSurplusdetails.setArriveNum(detail.getArriveNum());
                tWarehouseSurplusdetails.setPurchaseintodetailId(detail.getId());
                tWarehouseSurplusdetailsService.insertTWarehouseSurplusdetails(tWarehouseSurplusdetails);
            }
            int intoState = 1;
            if(allStatus.indexOf("no") == -1){
                //全部到货
                intoState = 3;
            }else{
                //部分到货
                intoState = 2;
            }
            if(purchaseId != null){
                TWarehousePurchase tWarehousePurchase = new TWarehousePurchase();
                tWarehousePurchase.setId(purchaseId);
                tWarehousePurchase.setIntoState(intoState);
                tWarehousePurchaseMapper.updateTWarehousePurchase(tWarehousePurchase);
            }
        }
    }
    @Override
    public List<TWarehousePurchaserecord> selectTWarehousePurchaseIntoCheckList(TWarehousePurchaseinto tWarehousePurchaseinto) {
        if(tWarehousePurchaseinto.getId() == null){
            throw new ServiceException("采购申请申请id不能为空");
        }
        TWarehousePurchaserecord tWarehousePurchaserecord = new TWarehousePurchaserecord();
        tWarehousePurchaserecord.setCheckType(DictType.CHECKTYPE_IN_WAREHOUSE);
        tWarehousePurchaserecord.setPurchaseId(tWarehousePurchaseinto.getId());
        return tWarehousePurchaserecordMapper.selectTWarehousePurchaserecordList(tWarehousePurchaserecord);
    }

}
