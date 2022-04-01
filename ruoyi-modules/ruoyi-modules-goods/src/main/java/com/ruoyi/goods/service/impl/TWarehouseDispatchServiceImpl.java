package com.ruoyi.goods.service.impl;

import java.util.List;

import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.SnowFlakeGenerateIdWorker;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.goods.domain.TWarehouseDispatchdetail;
import com.ruoyi.goods.mapper.TWarehouseDispatchdetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TWarehouseDispatchMapper;
import com.ruoyi.goods.domain.TWarehouseDispatch;
import com.ruoyi.goods.service.ITWarehouseDispatchService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 调拨单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
@Service
public class TWarehouseDispatchServiceImpl implements ITWarehouseDispatchService 
{
    @Resource
    private TWarehouseDispatchMapper tWarehouseDispatchMapper;
    @Resource
    private TWarehouseDispatchdetailMapper tWarehouseDispatchdetailMapper;

    /**
     * 查询调拨单
     * 
     * @param id 调拨单主键
     * @return 调拨单
     */
    @Override
    public TWarehouseDispatch selectTWarehouseDispatchById(Long id)
    {
        return tWarehouseDispatchMapper.selectTWarehouseDispatchById(id);
    }

    /**
     * 查询调拨单列表
     * 
     * @param tWarehouseDispatch 调拨单
     * @return 调拨单
     */
    @Override
    public List<TWarehouseDispatch> selectTWarehouseDispatchList(TWarehouseDispatch tWarehouseDispatch)
    {
        //出入库关联调拨单
        if(tWarehouseDispatch.getIntoType() != null && tWarehouseDispatch.getIntoType() ==1){
            tWarehouseDispatch.setDispatchState(2);
        }
        if(tWarehouseDispatch.getIntoType() != null && tWarehouseDispatch.getIntoType() ==2){
            tWarehouseDispatch.setDispatchState(1);
        }
        tWarehouseDispatch.setDelFlag(1);
        return tWarehouseDispatchMapper.selectTWarehouseDispatchList(tWarehouseDispatch);
    }

    /**
     * 新增调拨单
     * 
     * @param tWarehouseDispatch 调拨单
     * @return 结果
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public int insertTWarehouseDispatch(TWarehouseDispatch tWarehouseDispatch)
    {
        if(tWarehouseDispatch.getFromWarehouseId().equals(tWarehouseDispatch.getToWarehouseId())){
            throw new ServiceException("发货仓与收货仓不能相同");
        }
        SnowFlakeGenerateIdWorker idWorker = new SnowFlakeGenerateIdWorker(0L,0L);
        tWarehouseDispatch.setDispatchNo(idWorker.nextId());
        tWarehouseDispatch.setCreateTime(DateUtils.getNowDate());
        tWarehouseDispatch.setCreateUserId(SecurityUtils.getUserId());
        tWarehouseDispatch.setCreateBy(SecurityUtils.getUsername());
        List<TWarehouseDispatchdetail> detailList = tWarehouseDispatch.getDetailList();
        if(detailList != null && detailList.size()>0){
            for(TWarehouseDispatchdetail detail : detailList){
                detail.setDispatchNo(tWarehouseDispatch.getDispatchNo());
                tWarehouseDispatchdetailMapper.insertTWarehouseDispatchdetail(detail);
            }
        }
        return tWarehouseDispatchMapper.insertTWarehouseDispatch(tWarehouseDispatch);
    }

    /**
     * 修改调拨单
     * 
     * @param tWarehouseDispatch 调拨单
     * @return 结果
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public int updateTWarehouseDispatch(TWarehouseDispatch tWarehouseDispatch)
    {
        if(tWarehouseDispatch.getFromWarehouseId().equals(tWarehouseDispatch.getToWarehouseId())){
            throw new ServiceException("发货仓与收货仓不能相同");
        }
        List<TWarehouseDispatchdetail> detailList = tWarehouseDispatch.getDetailList();
        if(detailList != null && detailList.size()>0){
            for(TWarehouseDispatchdetail detail : detailList){
                tWarehouseDispatchdetailMapper.updateTWarehouseDispatchdetail(detail);
            }
        }
        tWarehouseDispatch.setUpdateTime(DateUtils.getNowDate());
        return tWarehouseDispatchMapper.updateTWarehouseDispatch(tWarehouseDispatch);
    }

    /**
     * 批量删除调拨单
     * 
     * @param ids 需要删除的调拨单主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseDispatchByIds(Long[] ids)
    {
        return tWarehouseDispatchMapper.deleteTWarehouseDispatchByIds(ids);
    }

    /**
     * 删除调拨单信息
     * 
     * @param id 调拨单主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseDispatchById(Long id)
    {
        return tWarehouseDispatchMapper.deleteTWarehouseDispatchById(id);
    }
}
