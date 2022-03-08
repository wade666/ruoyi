package com.ruoyi.goods.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 配送方式对象 t_shipping_method
 * 
 * @author ruoyi
 * @date 2022-02-15
 */
public class TShippingMethod extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 首重 */
    @Excel(name = "首重")
    private BigDecimal firstWeight;

    /** 续重量 */
    @Excel(name = "续重量")
    private BigDecimal continueWeight;

    /** 默认首重价格 */
    @Excel(name = "默认首重价格")
    private BigDecimal defaultFirstPrice;

    /** 默认续重价格 */
    @Excel(name = "默认续重价格")
    private BigDecimal defaultContinuePrice;

    /** 介绍 */
    @Excel(name = "介绍")
    private String description;

    /** 代码用于阿里快递查询编码 */
    private String code;

    /** 冗余支付宝订单中心编码如果做支付宝订单中心需要此字段 */
    private String alipayCode;

    /** 快递助手物流编码 */
    @Excel(name = "快递助手物流编码")
    private String courierCode;

    /** 版本号 */
    private Integer version;

    /** 排序 */
    private Integer orders;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setFirstWeight(BigDecimal firstWeight) 
    {
        this.firstWeight = firstWeight;
    }

    public BigDecimal getFirstWeight() 
    {
        return firstWeight;
    }
    public void setContinueWeight(BigDecimal continueWeight) 
    {
        this.continueWeight = continueWeight;
    }

    public BigDecimal getContinueWeight() 
    {
        return continueWeight;
    }
    public void setDefaultFirstPrice(BigDecimal defaultFirstPrice) 
    {
        this.defaultFirstPrice = defaultFirstPrice;
    }

    public BigDecimal getDefaultFirstPrice() 
    {
        return defaultFirstPrice;
    }
    public void setDefaultContinuePrice(BigDecimal defaultContinuePrice) 
    {
        this.defaultContinuePrice = defaultContinuePrice;
    }

    public BigDecimal getDefaultContinuePrice() 
    {
        return defaultContinuePrice;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setAlipayCode(String alipayCode) 
    {
        this.alipayCode = alipayCode;
    }

    public String getAlipayCode() 
    {
        return alipayCode;
    }
    public void setCourierCode(String courierCode) 
    {
        this.courierCode = courierCode;
    }

    public String getCourierCode() 
    {
        return courierCode;
    }
    public void setVersion(Integer version) 
    {
        this.version = version;
    }

    public Integer getVersion() 
    {
        return version;
    }
    public void setOrders(Integer orders) 
    {
        this.orders = orders;
    }

    public Integer getOrders() 
    {
        return orders;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("firstWeight", getFirstWeight())
            .append("continueWeight", getContinueWeight())
            .append("defaultFirstPrice", getDefaultFirstPrice())
            .append("defaultContinuePrice", getDefaultContinuePrice())
            .append("description", getDescription())
            .append("code", getCode())
            .append("alipayCode", getAlipayCode())
            .append("courierCode", getCourierCode())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .append("orders", getOrders())
            .toString();
    }
}
