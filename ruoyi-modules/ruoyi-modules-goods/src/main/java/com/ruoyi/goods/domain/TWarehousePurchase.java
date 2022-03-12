package com.ruoyi.goods.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 采购申请对象 t_warehouse_purchase
 * 
 * @author ruoyi
 * @date 2022-03-10
 */
public class TWarehousePurchase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
    private Long productId;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long warehouseId;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Integer applyNum;

    /** 采购价格 */
    @Excel(name = "采购价格")
    private BigDecimal applyPrice;

    /** 采购时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采购时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyTime;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Integer realNum;

    /** 审核状态（1待审核 2通过 3拒绝 4完成） */
    @Excel(name = "审核状态", readConverterExp = "1=待审核,2=通过,3=拒绝,4=完成")
    private Integer applyState;

    /** 审核状态*/
    private String applyStateName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }
    public void setApplyNum(Integer applyNum) 
    {
        this.applyNum = applyNum;
    }

    public Integer getApplyNum() 
    {
        return applyNum;
    }
    public void setApplyPrice(BigDecimal applyPrice) 
    {
        this.applyPrice = applyPrice;
    }

    public BigDecimal getApplyPrice() 
    {
        return applyPrice;
    }
    public void setApplyTime(Date applyTime) 
    {
        this.applyTime = applyTime;
    }

    public Date getApplyTime() 
    {
        return applyTime;
    }
    public void setRealNum(Integer realNum) 
    {
        this.realNum = realNum;
    }

    public Integer getRealNum() 
    {
        return realNum;
    }
    public void setApplyState(Integer applyState) 
    {
        this.applyState = applyState;
    }

    public Integer getApplyState() 
    {
        return applyState;
    }

    public String getApplyStateName() {
        return applyStateName;
    }

    public void setApplyStateName(String applyStateName) {
        this.applyStateName = applyStateName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("warehouseId", getWarehouseId())
            .append("applyNum", getApplyNum())
            .append("applyPrice", getApplyPrice())
            .append("applyTime", getApplyTime())
            .append("realNum", getRealNum())
            .append("applyState", getApplyState())
            .append("remark", getRemark())
            .toString();
    }
}
