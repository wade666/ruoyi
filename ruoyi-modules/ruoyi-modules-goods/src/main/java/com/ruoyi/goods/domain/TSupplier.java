package com.ruoyi.goods.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 供货商对象 t_supplier
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
public class TSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 供货商编码 */
    @Excel(name = "供货商编码")
    private String supplierCode;

    /** 供货商名称 */
    @Excel(name = "供货商名称")
    private String supplierName;

    /** 网站网址 */
    @Excel(name = "网站网址")
    private String website;

    /** 期初应付款 */
    @Excel(name = "期初应付款")
    private BigDecimal startPay;

    /** 省 */
    @Excel(name = "省")
    private Long provinceCode;

    /** 市 */
    @Excel(name = "市")
    private Long cityCode;

    /** 区 */
    @Excel(name = "区")
    private Long areaCode;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 邮编 */
    @Excel(name = "邮编")
    private Integer postalCode;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactName;

    /** 手机号 */
    @Excel(name = "手机号")
    private String contactPhone;

    /** 固话 */
    @Excel(name = "固话")
    private String fixedTel;

    /** 税号 */
    @Excel(name = "税号")
    private String taxNum;

    /** 开户行 */
    @Excel(name = "开户行")
    private String bankName;

    /** 开户账号 */
    @Excel(name = "开户账号")
    private String bankAccount;

    /** 欠款额度 */
    @Excel(name = "欠款额度")
    private BigDecimal arrears;

    /** 供货商状态 1正常 2禁用 */
    @Excel(name = "供货商状态 1正常 2禁用")
    private Integer supplierState;

    /** 版本号 */
    @Excel(name = "版本号")
    private Integer version;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSupplierCode(String supplierCode) 
    {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() 
    {
        return supplierCode;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setWebsite(String website) 
    {
        this.website = website;
    }

    public String getWebsite() 
    {
        return website;
    }
    public void setStartPay(BigDecimal startPay) 
    {
        this.startPay = startPay;
    }

    public BigDecimal getStartPay() 
    {
        return startPay;
    }
    public void setProvinceCode(Long provinceCode) 
    {
        this.provinceCode = provinceCode;
    }

    public Long getProvinceCode() 
    {
        return provinceCode;
    }
    public void setCityCode(Long cityCode) 
    {
        this.cityCode = cityCode;
    }

    public Long getCityCode() 
    {
        return cityCode;
    }
    public void setAreaCode(Long areaCode) 
    {
        this.areaCode = areaCode;
    }

    public Long getAreaCode() 
    {
        return areaCode;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPostalCode(Integer postalCode) 
    {
        this.postalCode = postalCode;
    }

    public Integer getPostalCode() 
    {
        return postalCode;
    }
    public void setContactName(String contactName) 
    {
        this.contactName = contactName;
    }

    public String getContactName() 
    {
        return contactName;
    }
    public void setContactPhone(String contactPhone) 
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() 
    {
        return contactPhone;
    }
    public void setFixedTel(String fixedTel) 
    {
        this.fixedTel = fixedTel;
    }

    public String getFixedTel() 
    {
        return fixedTel;
    }
    public void setTaxNum(String taxNum) 
    {
        this.taxNum = taxNum;
    }

    public String getTaxNum() 
    {
        return taxNum;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }
    public void setBankAccount(String bankAccount) 
    {
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() 
    {
        return bankAccount;
    }
    public void setArrears(BigDecimal arrears) 
    {
        this.arrears = arrears;
    }

    public BigDecimal getArrears() 
    {
        return arrears;
    }
    public void setSupplierState(Integer supplierState) 
    {
        this.supplierState = supplierState;
    }

    public Integer getSupplierState() 
    {
        return supplierState;
    }
    public void setVersion(Integer version) 
    {
        this.version = version;
    }

    public Integer getVersion() 
    {
        return version;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplierCode", getSupplierCode())
            .append("supplierName", getSupplierName())
            .append("website", getWebsite())
            .append("startPay", getStartPay())
            .append("provinceCode", getProvinceCode())
            .append("cityCode", getCityCode())
            .append("areaCode", getAreaCode())
            .append("address", getAddress())
            .append("postalCode", getPostalCode())
            .append("contactName", getContactName())
            .append("contactPhone", getContactPhone())
            .append("fixedTel", getFixedTel())
            .append("taxNum", getTaxNum())
            .append("bankName", getBankName())
            .append("bankAccount", getBankAccount())
            .append("arrears", getArrears())
            .append("supplierState", getSupplierState())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("version", getVersion())
            .append("remark", getRemark())
            .toString();
    }
}
