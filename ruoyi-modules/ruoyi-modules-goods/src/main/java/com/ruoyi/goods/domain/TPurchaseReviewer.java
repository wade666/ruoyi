package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 采购审核人配置对象 t_purchase_reviewer
 * 
 * @author ruoyi
 * @date 2022-03-19
 */
public class TPurchaseReviewer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 审核等级 1,2,3,等级越高,审核越靠后 */
    @Excel(name = "审核等级")
    private Integer checkLevel;

    /** 审核类型 1采购审核 2入库审核 */
    @Excel(name = "审核类型 1采购审核 2入库审核")
    private Integer checkType;

    /** 审核角色 */
    @Excel(name = "审核角色")
    private String checkRole;

    /** 审核人id */
    @Excel(name = "审核人id")
    private Long checkUserId;

    /** 打回等级 */
    @Excel(name = "打回等级")
    private Integer refuseLevel;

    /** 版本号 */
    private Integer version;

    /** 审核人账号 */
    private String userName;
    /** 审核人昵称 */
    private String nickName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCheckLevel(Integer checkLevel) 
    {
        this.checkLevel = checkLevel;
    }

    public Integer getCheckLevel() 
    {
        return checkLevel;
    }
    public void setCheckRole(String checkRole) 
    {
        this.checkRole = checkRole;
    }

    public String getCheckRole() 
    {
        return checkRole;
    }
    public void setCheckUserId(Long checkUserId) 
    {
        this.checkUserId = checkUserId;
    }

    public Long getCheckUserId() 
    {
        return checkUserId;
    }
    public void setRefuseLevel(Integer refuseLevel) 
    {
        this.refuseLevel = refuseLevel;
    }

    public Integer getRefuseLevel() 
    {
        return refuseLevel;
    }
    public void setVersion(Integer version) 
    {
        this.version = version;
    }

    public Integer getVersion() 
    {
        return version;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("checkLevel", getCheckLevel())
            .append("checkType", getCheckType())
            .append("checkRole", getCheckRole())
            .append("checkUserId", getCheckUserId())
            .append("refuseLevel", getRefuseLevel())
            .append("createTime", getCreateTime())
            .append("version", getVersion())
            .append("remark", getRemark())
            .toString();
    }
}
