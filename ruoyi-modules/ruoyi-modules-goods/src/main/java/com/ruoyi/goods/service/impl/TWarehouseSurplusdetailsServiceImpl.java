package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.datascope.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TWarehouseSurplusdetailsMapper;
import com.ruoyi.goods.domain.TWarehouseSurplusdetails;
import com.ruoyi.goods.service.ITWarehouseSurplusdetailsService;

/**
 * 出入库明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-08
 */
@Service
public class TWarehouseSurplusdetailsServiceImpl implements ITWarehouseSurplusdetailsService 
{
    @Autowired
    private TWarehouseSurplusdetailsMapper tWarehouseSurplusdetailsMapper;

    /**
     * 查询出入库明细
     * 
     * @param id 出入库明细主键
     * @return 出入库明细
     */
    @Override
    public TWarehouseSurplusdetails selectTWarehouseSurplusdetailsById(Long id)
    {
        return tWarehouseSurplusdetailsMapper.selectTWarehouseSurplusdetailsById(id);
    }

    /**
     * 查询出入库明细列表
     * 
     * @param tWarehouseSurplusdetails 出入库明细
     * @return 出入库明细
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<TWarehouseSurplusdetails> selectTWarehouseSurplusdetailsList(TWarehouseSurplusdetails tWarehouseSurplusdetails)
    {
        return tWarehouseSurplusdetailsMapper.selectTWarehouseSurplusdetailsList(tWarehouseSurplusdetails);
    }

    /**
     * 新增出入库明细
     * 
     * @param tWarehouseSurplusdetails 出入库明细
     * @return 结果
     */
    @Override
    public int insertTWarehouseSurplusdetails(TWarehouseSurplusdetails tWarehouseSurplusdetails)
    {
        tWarehouseSurplusdetails.setCreateTime(DateUtils.getNowDate());
        return tWarehouseSurplusdetailsMapper.insertTWarehouseSurplusdetails(tWarehouseSurplusdetails);
    }

    /**
     * 修改出入库明细
     * 
     * @param tWarehouseSurplusdetails 出入库明细
     * @return 结果
     */
    @Override
    public int updateTWarehouseSurplusdetails(TWarehouseSurplusdetails tWarehouseSurplusdetails)
    {
        return tWarehouseSurplusdetailsMapper.updateTWarehouseSurplusdetails(tWarehouseSurplusdetails);
    }

    /**
     * 批量删除出入库明细
     * 
     * @param ids 需要删除的出入库明细主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseSurplusdetailsByIds(Long[] ids)
    {
        return tWarehouseSurplusdetailsMapper.deleteTWarehouseSurplusdetailsByIds(ids);
    }

    /**
     * 删除出入库明细信息
     * 
     * @param id 出入库明细主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseSurplusdetailsById(Long id)
    {
        return tWarehouseSurplusdetailsMapper.deleteTWarehouseSurplusdetailsById(id);
    }
}
