package com.ruoyi.goods.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 物流拒收配置对象 t_shipping_reverse_config
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
public class TShippingReverseConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long reverseId;

    /** 反向签收状态 */
    @Excel(name = "反向签收状态")
    private String reverseStatus;

    /** 物流id */
    @Excel(name = "物流id")
    private Long shippingId;

    /** 是否删除 0否1是 */
    @Excel(name = "是否删除 0否1是")
    private Integer isDelete;

    public void setReverseId(Long reverseId) 
    {
        this.reverseId = reverseId;
    }

    public Long getReverseId() 
    {
        return reverseId;
    }
    public void setReverseStatus(String reverseStatus) 
    {
        this.reverseStatus = reverseStatus;
    }

    public String getReverseStatus() 
    {
        return reverseStatus;
    }
    public void setShippingId(Long shippingId) 
    {
        this.shippingId = shippingId;
    }

    public Long getShippingId() 
    {
        return shippingId;
    }
    public void setIsDelete(Integer isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("reverseId", getReverseId())
            .append("reverseStatus", getReverseStatus())
            .append("shippingId", getShippingId())
            .append("createTime", getCreateTime())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
