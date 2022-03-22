package com.ruoyi.goods.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.exception.ServiceException;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.goods.domain.TProjectDept;
import com.ruoyi.goods.mapper.TProjectDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.TProjectMapper;
import com.ruoyi.goods.domain.TProject;
import com.ruoyi.goods.service.ITProjectService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 项目管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-15
 */
@Service
public class TProjectServiceImpl implements ITProjectService 
{
    @Autowired
    private TProjectMapper tProjectMapper;
    @Autowired
    private TProjectDeptMapper tProjectDeptMapper;

    /**
     * 查询项目管理
     * 
     * @param id 项目管理主键
     * @return 项目管理
     */
    @Override
    public TProject selectTProjectById(Long id)
    {
        TProject project = tProjectMapper.selectTProjectById(id);
        List<Long> deptList = tProjectDeptMapper.selectDeptIdByProjectId(id);
        project.setDeptId(deptList.get(0));
        project.setDeptList(deptList);
        return project;
    }

    /**
     * 查询项目管理列表
     * 
     * @param tProject 项目管理
     * @return 项目管理
     */
    @Override
    public List<TProject> selectTProjectList(TProject tProject)
    {
        return tProjectMapper.selectTProjectList(tProject);
    }

    /**
     * 新增项目管理
     * @param tProject 项目管理
     * @return 结果
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public int insertTProject(TProject tProject)
    {
        tProject.setCreateTime(DateUtils.getNowDate());
        tProject.setCreateBy(SecurityUtils.getUsername());
        int count = tProjectMapper.insertTProject(tProject);
        if(count < 0){
            throw new ServiceException("创建项目失败!");
        }
        saveProjectDept(tProject);
        return count;
    }

    /**
     * 修改项目管理
     * @param tProject 项目管理
     * @return 结果
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    public int updateTProject(TProject tProject)
    {
        tProject.setUpdateTime(DateUtils.getNowDate());
        int count = tProjectMapper.updateTProject(tProject);
        if(count < 0){
            throw new ServiceException("修改项目失败!");
        }
        tProjectDeptMapper.deleteTProjectDeptByProjectId(tProject.getId());
        saveProjectDept(tProject);
        return count;
    }
    public void saveProjectDept(TProject tProject){
        List<Long> deptList = new ArrayList<>();
        deptList.add(tProject.getDeptId());
        for(Long deptId : deptList){
            TProjectDept tProjectDept = new TProjectDept();
            tProjectDept.setProjectId(tProject.getId());
            tProjectDept.setDeptId(deptId);
            tProjectDept.setCreateBy(SecurityUtils.getUsername());
            tProjectDept.setCreateTime(DateUtils.getNowDate());
            int countB = tProjectDeptMapper.insertTProjectDept(tProjectDept);
            if(countB < 0){
                throw new ServiceException("保存项目失败");
            }
        }
    }
    /**
     * 批量删除项目管理
     * 
     * @param ids 需要删除的项目管理主键
     * @return 结果
     */
    @Override
    public int deleteTProjectByIds(Long[] ids)
    {
        return tProjectMapper.deleteTProjectByIds(ids);
    }

    /**
     * 删除项目管理信息
     * 
     * @param id 项目管理主键
     * @return 结果
     */
    @Override
    public int deleteTProjectById(Long id)
    {
        return tProjectMapper.deleteTProjectById(id);
    }
}
