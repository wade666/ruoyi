package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TWarehouseCompany;

/**
 * 仓库所属公司Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-07
 */
public interface TWarehouseCompanyMapper 
{
    /**
     * 查询仓库所属公司
     * 
     * @param companyId 仓库所属公司主键
     * @return 仓库所属公司
     */
    public TWarehouseCompany selectTWarehouseCompanyByCompanyId(Long companyId);

    /**
     * 查询仓库所属公司列表
     * 
     * @param tWarehouseCompany 仓库所属公司
     * @return 仓库所属公司集合
     */
    public List<TWarehouseCompany> selectTWarehouseCompanyList(TWarehouseCompany tWarehouseCompany);

    /**
     * 新增仓库所属公司
     * 
     * @param tWarehouseCompany 仓库所属公司
     * @return 结果
     */
    public int insertTWarehouseCompany(TWarehouseCompany tWarehouseCompany);

    /**
     * 修改仓库所属公司
     * 
     * @param tWarehouseCompany 仓库所属公司
     * @return 结果
     */
    public int updateTWarehouseCompany(TWarehouseCompany tWarehouseCompany);

    /**
     * 删除仓库所属公司
     * 
     * @param companyId 仓库所属公司主键
     * @return 结果
     */
    public int deleteTWarehouseCompanyByCompanyId(Long companyId);

    /**
     * 批量删除仓库所属公司
     * 
     * @param companyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWarehouseCompanyByCompanyIds(Long[] companyIds);
}
