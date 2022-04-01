package com.ruoyi.goods.service.impl;

import java.util.List;

import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.SnowFlakeGenerateIdWorker;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.goods.domain.TWarehouseDispatch;
import com.ruoyi.goods.domain.TWarehouseDispatchdetail;
import com.ruoyi.goods.mapper.TWarehouseDispatchMapper;
import com.ruoyi.goods.mapper.TWarehouseDispatchdetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TWarehouseDispatchintoMapper;
import com.ruoyi.goods.domain.TWarehouseDispatchinto;
import com.ruoyi.goods.service.ITWarehouseDispatchintoService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 调拨出入库单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-30
 */
@Service
public class TWarehouseDispatchintoServiceImpl implements ITWarehouseDispatchintoService 
{
    @Resource
    private TWarehouseDispatchintoMapper tWarehouseDispatchintoMapper;
    @Resource
    private TWarehouseDispatchdetailMapper tWarehouseDispatchdetailMapper;
    @Resource
    private TWarehouseDispatchMapper tWarehouseDispatchMapper;


    /**
     * 查询调拨出入库单
     * 
     * @param id 调拨出入库单主键
     * @return 调拨出入库单
     */
    @Override
    public TWarehouseDispatchinto selectTWarehouseDispatchintoById(Long id)
    {
        return tWarehouseDispatchintoMapper.selectTWarehouseDispatchintoById(id);
    }

    /**
     * 查询调拨出入库单列表
     * 
     * @param tWarehouseDispatchinto 调拨出入库单
     * @return 调拨出入库单
     */
    @Override
    public List<TWarehouseDispatchinto> selectTWarehouseDispatchintoList(TWarehouseDispatchinto tWarehouseDispatchinto)
    {
        tWarehouseDispatchinto.setDelFlag(1);
        return tWarehouseDispatchintoMapper.selectTWarehouseDispatchintoList(tWarehouseDispatchinto);
    }

    /**
     * 新增调拨出入库单
     * 
     * @param tWarehouseDispatchinto 调拨出入库单
     * @return 结果
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public int insertTWarehouseDispatchinto(TWarehouseDispatchinto tWarehouseDispatchinto)
    {
        if(tWarehouseDispatchinto.getDispatchNo() == null){
            throw new ServiceException("关联调拨单号不能为空");
        }
        if(tWarehouseDispatchinto.getIntoType() == null){
            throw new ServiceException("调拨类型不能为空");
        }
        SnowFlakeGenerateIdWorker idWorker = new SnowFlakeGenerateIdWorker(0L,0L);
        tWarehouseDispatchinto.setDispatchintoNo(idWorker.nextId());
        tWarehouseDispatchinto.setCreateUserId(SecurityUtils.getUserId());
        tWarehouseDispatchinto.setCreateBy(SecurityUtils.getUsername());
        tWarehouseDispatchinto.setCreateTime(DateUtils.getNowDate());
        List<TWarehouseDispatchdetail> detailList = tWarehouseDispatchinto.getDetailList();
        if(detailList != null && detailList.size()>0){
            for(TWarehouseDispatchdetail detail : detailList){
                detail.setDispatchNo(tWarehouseDispatchinto.getDispatchintoNo());
                tWarehouseDispatchdetailMapper.insertTWarehouseDispatchdetail(detail);
            }
        }
        int count = tWarehouseDispatchintoMapper.insertTWarehouseDispatchinto(tWarehouseDispatchinto);
        TWarehouseDispatch tWarehouseDispatch = new TWarehouseDispatch();
        if(tWarehouseDispatchinto.getIntoType() != null && tWarehouseDispatchinto.getIntoType() == 1){

            //加库存
        }
        if(tWarehouseDispatchinto.getIntoType() != null && tWarehouseDispatchinto.getIntoType() == 2){

            //减库存
        }
//        tWarehouseDispatch.setDispatchState();
        tWarehouseDispatch.setDispatchNo(tWarehouseDispatchinto.getDispatchNo());
        tWarehouseDispatchMapper.updateTWarehouseDispatchByDispatchNo(tWarehouseDispatch);
        return count;
    }

    /**
     * 修改调拨出入库单
     * 
     * @param tWarehouseDispatchinto 调拨出入库单
     * @return 结果
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public int updateTWarehouseDispatchinto(TWarehouseDispatchinto tWarehouseDispatchinto)
    {
        List<TWarehouseDispatchdetail> detailList = tWarehouseDispatchinto.getDetailList();
        if(detailList != null && detailList.size()>0){
            for(TWarehouseDispatchdetail detail : detailList){
                tWarehouseDispatchdetailMapper.updateTWarehouseDispatchdetail(detail);
            }
        }
        tWarehouseDispatchinto.setUpdateTime(DateUtils.getNowDate());
        return tWarehouseDispatchintoMapper.updateTWarehouseDispatchinto(tWarehouseDispatchinto);
    }

    /**
     * 批量删除调拨出入库单
     * 
     * @param ids 需要删除的调拨出入库单主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseDispatchintoByIds(Long[] ids)
    {
        return tWarehouseDispatchintoMapper.deleteTWarehouseDispatchintoByIds(ids);
    }

    /**
     * 删除调拨出入库单信息
     * 
     * @param id 调拨出入库单主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseDispatchintoById(Long id)
    {
        return tWarehouseDispatchintoMapper.deleteTWarehouseDispatchintoById(id);
    }
}
