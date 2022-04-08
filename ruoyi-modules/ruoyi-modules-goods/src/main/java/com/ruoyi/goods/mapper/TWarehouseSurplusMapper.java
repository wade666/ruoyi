package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TWarehouseSurplus;

/**
 * 库存Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-08
 */
public interface TWarehouseSurplusMapper 
{
    /**
     * 查询库存
     * 
     * @param surplusId 库存主键
     * @return 库存
     */
    public TWarehouseSurplus selectTWarehouseSurplusBySurplusId(Long surplusId);

    /**
     * 查询库存列表
     * 
     * @param tWarehouseSurplus 库存
     * @return 库存集合
     */
    public List<TWarehouseSurplus> selectTWarehouseSurplusList(TWarehouseSurplus tWarehouseSurplus);

    /**
     * 新增库存
     * 
     * @param tWarehouseSurplus 库存
     * @return 结果
     */
    public int insertTWarehouseSurplus(TWarehouseSurplus tWarehouseSurplus);

    /**
     * 修改库存
     * 
     * @param tWarehouseSurplus 库存
     * @return 结果
     */
    public int updateTWarehouseSurplus(TWarehouseSurplus tWarehouseSurplus);

    /**
     * 删除库存
     * 
     * @param surplusId 库存主键
     * @return 结果
     */
    public int deleteTWarehouseSurplusBySurplusId(Long surplusId);

    /**
     * 批量删除库存
     * 
     * @param surplusIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTWarehouseSurplusBySurplusIds(Long[] surplusIds);
    /**
     * 查询累计入库数
     */
    int selectSumSurplus(TWarehouseSurplus tWarehouseSurplus);
    /**
     * 根据仓库id查询商品库存
     */
    public List<TWarehouseSurplus> selectTWarehouseSurplusByWarehouseId(TWarehouseSurplus tWarehouseSurplus);
}
