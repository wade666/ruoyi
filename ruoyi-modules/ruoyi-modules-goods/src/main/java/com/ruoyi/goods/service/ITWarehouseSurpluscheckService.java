package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TWarehouseSurpluscheck;

/**
 * 库存盘点Service接口
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
public interface ITWarehouseSurpluscheckService 
{
    /**
     * 查询库存盘点
     * 
     * @param id 库存盘点主键
     * @return 库存盘点
     */
    public TWarehouseSurpluscheck selectTWarehouseSurpluscheckById(Long id);

    /**
     * 查询库存盘点列表
     * 
     * @param tWarehouseSurpluscheck 库存盘点
     * @return 库存盘点集合
     */
    public List<TWarehouseSurpluscheck> selectTWarehouseSurpluscheckList(TWarehouseSurpluscheck tWarehouseSurpluscheck);

    /**
     * 新增库存盘点
     * 
     * @param tWarehouseSurpluscheck 库存盘点
     * @return 结果
     */
    public int insertTWarehouseSurpluscheck(TWarehouseSurpluscheck tWarehouseSurpluscheck);

    /**
     * 修改库存盘点
     * 
     * @param tWarehouseSurpluscheck 库存盘点
     * @return 结果
     */
    public int updateTWarehouseSurpluscheck(TWarehouseSurpluscheck tWarehouseSurpluscheck);

    /**
     * 批量删除库存盘点
     * 
     * @param ids 需要删除的库存盘点主键集合
     * @return 结果
     */
    public int deleteTWarehouseSurpluscheckByIds(Long[] ids);

    /**
     * 删除库存盘点信息
     * 
     * @param id 库存盘点主键
     * @return 结果
     */
    public int deleteTWarehouseSurpluscheckById(Long id);
}
