package com.ruoyi.goods.service;

import java.util.List;
import com.ruoyi.goods.domain.TProjectDept;

/**
 * 项目部门关联中间Service接口
 * 
 * @author ruoyi
 * @date 2022-03-15
 */
public interface ITProjectDeptService 
{
    /**
     * 查询项目部门关联中间
     * 
     * @param id 项目部门关联中间主键
     * @return 项目部门关联中间
     */
    public TProjectDept selectTProjectDeptById(Long id);

    /**
     * 查询项目部门关联中间列表
     * 
     * @param tProjectDept 项目部门关联中间
     * @return 项目部门关联中间集合
     */
    public List<TProjectDept> selectTProjectDeptList(TProjectDept tProjectDept);

    /**
     * 新增项目部门关联中间
     * 
     * @param tProjectDept 项目部门关联中间
     * @return 结果
     */
    public int insertTProjectDept(TProjectDept tProjectDept);

    /**
     * 修改项目部门关联中间
     * 
     * @param tProjectDept 项目部门关联中间
     * @return 结果
     */
    public int updateTProjectDept(TProjectDept tProjectDept);

    /**
     * 批量删除项目部门关联中间
     * 
     * @param ids 需要删除的项目部门关联中间主键集合
     * @return 结果
     */
    public int deleteTProjectDeptByIds(Long[] ids);

    /**
     * 删除项目部门关联中间信息
     * 
     * @param id 项目部门关联中间主键
     * @return 结果
     */
    public int deleteTProjectDeptById(Long id);
}
