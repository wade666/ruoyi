package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TWarehouseCompanyMapper;
import com.ruoyi.goods.domain.TWarehouseCompany;
import com.ruoyi.goods.service.ITWarehouseCompanyService;

/**
 * 仓库所属公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-07
 */
@Service
public class TWarehouseCompanyServiceImpl implements ITWarehouseCompanyService 
{
    @Autowired
    private TWarehouseCompanyMapper tWarehouseCompanyMapper;

    /**
     * 查询仓库所属公司
     * 
     * @param companyId 仓库所属公司主键
     * @return 仓库所属公司
     */
    @Override
    public TWarehouseCompany selectTWarehouseCompanyByCompanyId(Long companyId)
    {
        return tWarehouseCompanyMapper.selectTWarehouseCompanyByCompanyId(companyId);
    }

    /**
     * 查询仓库所属公司列表
     * 
     * @param tWarehouseCompany 仓库所属公司
     * @return 仓库所属公司
     */
    @Override
    public List<TWarehouseCompany> selectTWarehouseCompanyList(TWarehouseCompany tWarehouseCompany)
    {
        return tWarehouseCompanyMapper.selectTWarehouseCompanyList(tWarehouseCompany);
    }

    /**
     * 新增仓库所属公司
     * 
     * @param tWarehouseCompany 仓库所属公司
     * @return 结果
     */
    @Override
    public int insertTWarehouseCompany(TWarehouseCompany tWarehouseCompany)
    {
        tWarehouseCompany.setCreateTime(DateUtils.getNowDate());
        return tWarehouseCompanyMapper.insertTWarehouseCompany(tWarehouseCompany);
    }

    /**
     * 修改仓库所属公司
     * 
     * @param tWarehouseCompany 仓库所属公司
     * @return 结果
     */
    @Override
    public int updateTWarehouseCompany(TWarehouseCompany tWarehouseCompany)
    {
        tWarehouseCompany.setUpdateTime(DateUtils.getNowDate());
        return tWarehouseCompanyMapper.updateTWarehouseCompany(tWarehouseCompany);
    }

    /**
     * 批量删除仓库所属公司
     * 
     * @param companyIds 需要删除的仓库所属公司主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseCompanyByCompanyIds(Long[] companyIds)
    {
        return tWarehouseCompanyMapper.deleteTWarehouseCompanyByCompanyIds(companyIds);
    }

    /**
     * 删除仓库所属公司信息
     * 
     * @param companyId 仓库所属公司主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseCompanyByCompanyId(Long companyId)
    {
        //如果已经关联仓库，不能删除
        return tWarehouseCompanyMapper.deleteTWarehouseCompanyByCompanyId(companyId);
    }
}
