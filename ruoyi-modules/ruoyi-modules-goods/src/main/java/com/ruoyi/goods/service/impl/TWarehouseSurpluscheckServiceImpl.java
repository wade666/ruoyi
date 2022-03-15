package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.datascope.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TWarehouseSurpluscheckMapper;
import com.ruoyi.goods.domain.TWarehouseSurpluscheck;
import com.ruoyi.goods.service.ITWarehouseSurpluscheckService;

/**
 * 库存盘点Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
@Service
public class TWarehouseSurpluscheckServiceImpl implements ITWarehouseSurpluscheckService 
{
    @Autowired
    private TWarehouseSurpluscheckMapper tWarehouseSurpluscheckMapper;

    /**
     * 查询库存盘点
     * 
     * @param id 库存盘点主键
     * @return 库存盘点
     */
    @Override
    public TWarehouseSurpluscheck selectTWarehouseSurpluscheckById(Long id)
    {
        return tWarehouseSurpluscheckMapper.selectTWarehouseSurpluscheckById(id);
    }

    /**
     * 查询库存盘点列表
     * 
     * @param tWarehouseSurpluscheck 库存盘点
     * @return 库存盘点
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<TWarehouseSurpluscheck> selectTWarehouseSurpluscheckList(TWarehouseSurpluscheck tWarehouseSurpluscheck)
    {
        return tWarehouseSurpluscheckMapper.selectTWarehouseSurpluscheckList(tWarehouseSurpluscheck);
    }

    /**
     * 新增库存盘点
     * 
     * @param tWarehouseSurpluscheck 库存盘点
     * @return 结果
     */
    @Override
    public int insertTWarehouseSurpluscheck(TWarehouseSurpluscheck tWarehouseSurpluscheck)
    {
        tWarehouseSurpluscheck.setCreateTime(DateUtils.getNowDate());
        return tWarehouseSurpluscheckMapper.insertTWarehouseSurpluscheck(tWarehouseSurpluscheck);
    }

    /**
     * 修改库存盘点
     * 
     * @param tWarehouseSurpluscheck 库存盘点
     * @return 结果
     */
    @Override
    public int updateTWarehouseSurpluscheck(TWarehouseSurpluscheck tWarehouseSurpluscheck)
    {
        return tWarehouseSurpluscheckMapper.updateTWarehouseSurpluscheck(tWarehouseSurpluscheck);
    }

    /**
     * 批量删除库存盘点
     * 
     * @param ids 需要删除的库存盘点主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseSurpluscheckByIds(Long[] ids)
    {
        return tWarehouseSurpluscheckMapper.deleteTWarehouseSurpluscheckByIds(ids);
    }

    /**
     * 删除库存盘点信息
     * 
     * @param id 库存盘点主键
     * @return 结果
     */
    @Override
    public int deleteTWarehouseSurpluscheckById(Long id)
    {
        return tWarehouseSurpluscheckMapper.deleteTWarehouseSurpluscheckById(id);
    }
}
