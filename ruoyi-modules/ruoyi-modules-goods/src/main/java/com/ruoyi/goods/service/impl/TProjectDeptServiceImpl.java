package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TProjectDeptMapper;
import com.ruoyi.goods.domain.TProjectDept;
import com.ruoyi.goods.service.ITProjectDeptService;

/**
 * 项目部门关联中间Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-15
 */
@Service
public class TProjectDeptServiceImpl implements ITProjectDeptService 
{
    @Autowired
    private TProjectDeptMapper tProjectDeptMapper;

    /**
     * 查询项目部门关联中间
     * 
     * @param id 项目部门关联中间主键
     * @return 项目部门关联中间
     */
    @Override
    public TProjectDept selectTProjectDeptById(Long id)
    {
        return tProjectDeptMapper.selectTProjectDeptById(id);
    }

    /**
     * 查询项目部门关联中间列表
     * 
     * @param tProjectDept 项目部门关联中间
     * @return 项目部门关联中间
     */
    @Override
    public List<TProjectDept> selectTProjectDeptList(TProjectDept tProjectDept)
    {
        return tProjectDeptMapper.selectTProjectDeptList(tProjectDept);
    }

    /**
     * 新增项目部门关联中间
     * 
     * @param tProjectDept 项目部门关联中间
     * @return 结果
     */
    @Override
    public int insertTProjectDept(TProjectDept tProjectDept)
    {
        tProjectDept.setCreateTime(DateUtils.getNowDate());
        return tProjectDeptMapper.insertTProjectDept(tProjectDept);
    }

    /**
     * 修改项目部门关联中间
     * 
     * @param tProjectDept 项目部门关联中间
     * @return 结果
     */
    @Override
    public int updateTProjectDept(TProjectDept tProjectDept)
    {
        return tProjectDeptMapper.updateTProjectDept(tProjectDept);
    }

    /**
     * 批量删除项目部门关联中间
     * 
     * @param ids 需要删除的项目部门关联中间主键
     * @return 结果
     */
    @Override
    public int deleteTProjectDeptByIds(Long[] ids)
    {
        return tProjectDeptMapper.deleteTProjectDeptByIds(ids);
    }

    /**
     * 删除项目部门关联中间信息
     * 
     * @param id 项目部门关联中间主键
     * @return 结果
     */
    @Override
    public int deleteTProjectDeptById(Long id)
    {
        return tProjectDeptMapper.deleteTProjectDeptById(id);
    }
}
