package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.TProject;

/**
 * 项目管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-15
 */
public interface TProjectMapper 
{
    /**
     * 查询项目管理
     * 
     * @param id 项目管理主键
     * @return 项目管理
     */
    public TProject selectTProjectById(Long id);

    /**
     * 查询项目管理列表
     * 
     * @param tProject 项目管理
     * @return 项目管理集合
     */
    public List<TProject> selectTProjectList(TProject tProject);

    /**
     * 新增项目管理
     * 
     * @param tProject 项目管理
     * @return 结果
     */
    public int insertTProject(TProject tProject);

    /**
     * 修改项目管理
     * 
     * @param tProject 项目管理
     * @return 结果
     */
    public int updateTProject(TProject tProject);

    /**
     * 删除项目管理
     * 
     * @param id 项目管理主键
     * @return 结果
     */
    public int deleteTProjectById(Long id);

    /**
     * 批量删除项目管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProjectByIds(Long[] ids);
}
