package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TWarehouseSurpluswarn;

/**
 * 库存预警设置Service接口
 * 
 * @author ruoyi
 * @date 2022-03-09
 */
public interface ITWarehouseSurpluswarnService 
{
    /**
     * 查询库存预警设置
     * 
     * @param id 库存预警设置主键
     * @return 库存预警设置
     */
    public TWarehouseSurpluswarn selectTWarehouseSurpluswarnById(Long id);

    /**
     * 查询库存预警设置列表
     * 
     * @param tWarehouseSurpluswarn 库存预警设置
     * @return 库存预警设置集合
     */
    public List<TWarehouseSurpluswarn> selectTWarehouseSurpluswarnList(TWarehouseSurpluswarn tWarehouseSurpluswarn);

    /**
     * 新增库存预警设置
     * 
     * @param tWarehouseSurpluswarn 库存预警设置
     * @return 结果
     */
    public int insertTWarehouseSurpluswarn(TWarehouseSurpluswarn tWarehouseSurpluswarn);

    /**
     * 修改库存预警设置
     * 
     * @param tWarehouseSurpluswarn 库存预警设置
     * @return 结果
     */
    public int updateTWarehouseSurpluswarn(TWarehouseSurpluswarn tWarehouseSurpluswarn);

    /**
     * 批量删除库存预警设置
     * 
     * @param ids 需要删除的库存预警设置主键集合
     * @return 结果
     */
    public int deleteTWarehouseSurpluswarnByIds(Long[] ids);

    /**
     * 删除库存预警设置信息
     * 
     * @param id 库存预警设置主键
     * @return 结果
     */
    public int deleteTWarehouseSurpluswarnById(Long id);
}
