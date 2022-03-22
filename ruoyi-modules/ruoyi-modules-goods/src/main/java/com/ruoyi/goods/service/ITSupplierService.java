package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TSupplier;

/**
 * 供货商Service接口
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
public interface ITSupplierService 
{
    /**
     * 查询供货商
     * 
     * @param id 供货商主键
     * @return 供货商
     */
    public TSupplier selectTSupplierById(Long id);

    /**
     * 查询供货商列表
     * 
     * @param tSupplier 供货商
     * @return 供货商集合
     */
    public List<TSupplier> selectTSupplierList(TSupplier tSupplier);

    /**
     * 新增供货商
     * 
     * @param tSupplier 供货商
     * @return 结果
     */
    public int insertTSupplier(TSupplier tSupplier);

    /**
     * 修改供货商
     * 
     * @param tSupplier 供货商
     * @return 结果
     */
    public int updateTSupplier(TSupplier tSupplier);

    /**
     * 批量删除供货商
     * 
     * @param ids 需要删除的供货商主键集合
     * @return 结果
     */
    public int deleteTSupplierByIds(Long[] ids);

    /**
     * 删除供货商信息
     * 
     * @param id 供货商主键
     * @return 结果
     */
    public int deleteTSupplierById(Long id);
}
