package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.util.List;

/**
 * 项目管理对象 t_project
 * 
 * @author ruoyi
 * @date 2022-03-15
 */
public class TProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目描述 */
    @Excel(name = "项目描述")
    private String projectDetail;

    /** 项目状态 1正常 2禁用 */
    @Excel(name = "项目状态 1正常 2禁用")
    private Integer projectState;

    /** 版本号 */
    private Integer version;
    /** 部门id List */
    private List<Long> deptList;
    /** 部门id */
    private Long deptId;
    /** 项目状态*/
    private String projectStateName;
    /** 部门名 List */
    private List<TProjectDept> deptNameList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectDetail(String projectDetail) 
    {
        this.projectDetail = projectDetail;
    }

    public String getProjectDetail() 
    {
        return projectDetail;
    }
    public void setProjectState(Integer projectState) 
    {
        this.projectState = projectState;
    }

    public Integer getProjectState() 
    {
        return projectState;
    }
    public void setVersion(Integer version) 
    {
        this.version = version;
    }

    public Integer getVersion() 
    {
        return version;
    }

    public List<Long> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Long> deptList) {
        this.deptList = deptList;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getProjectStateName() {
        return projectStateName;
    }

    public void setProjectStateName(String projectStateName) {
        this.projectStateName = projectStateName;
    }

    public List<TProjectDept> getDeptNameList() {
        return deptNameList;
    }

    public void setDeptNameList(List<TProjectDept> deptNameList) {
        this.deptNameList = deptNameList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectName", getProjectName())
            .append("projectDetail", getProjectDetail())
            .append("projectState", getProjectState())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .append("remark", getRemark())
            .toString();
    }
}
