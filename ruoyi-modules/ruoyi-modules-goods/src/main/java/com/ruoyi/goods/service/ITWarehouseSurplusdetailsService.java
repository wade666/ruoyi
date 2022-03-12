package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TWarehouseSurplusdetails;

/**
 * 出入库明细Service接口
 * 
 * @author ruoyi
 * @date 2022-03-08
 */
public interface ITWarehouseSurplusdetailsService 
{
    /**
     * 查询出入库明细
     * 
     * @param id 出入库明细主键
     * @return 出入库明细
     */
    public TWarehouseSurplusdetails selectTWarehouseSurplusdetailsById(Long id);

    /**
     * 查询出入库明细列表
     * 
     * @param tWarehouseSurplusdetails 出入库明细
     * @return 出入库明细集合
     */
    public List<TWarehouseSurplusdetails> selectTWarehouseSurplusdetailsList(TWarehouseSurplusdetails tWarehouseSurplusdetails);

    /**
     * 新增出入库明细
     * 
     * @param tWarehouseSurplusdetails 出入库明细
     * @return 结果
     */
    public int insertTWarehouseSurplusdetails(TWarehouseSurplusdetails tWarehouseSurplusdetails);

    /**
     * 修改出入库明细
     * 
     * @param tWarehouseSurplusdetails 出入库明细
     * @return 结果
     */
    public int updateTWarehouseSurplusdetails(TWarehouseSurplusdetails tWarehouseSurplusdetails);

    /**
     * 批量删除出入库明细
     * 
     * @param ids 需要删除的出入库明细主键集合
     * @return 结果
     */
    public int deleteTWarehouseSurplusdetailsByIds(Long[] ids);

    /**
     * 删除出入库明细信息
     * 
     * @param id 出入库明细主键
     * @return 结果
     */
    public int deleteTWarehouseSurplusdetailsById(Long id);
}
