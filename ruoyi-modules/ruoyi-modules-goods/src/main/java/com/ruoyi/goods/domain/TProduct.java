package com.ruoyi.goods.domain;

import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品对象 t_product
 *
 * @author ruoyi
 * @date 2022-01-22
 */
public class TProduct extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 商品标号
     */
    @Excel(name = "商品标号")
    private String sn;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称",required = true)
    @Excel(name = "商品名称")
    private String productName;

    /**
     * 轮播图json保存多中类型大图中图小图原图
     */
    @Excel(name = "轮播图")
    private String productImages;

    /**
     * 商品主图
     */
    @ApiModelProperty(value = "商品主图",required = true)
    @Excel(name = "商品主图")
    private String image;

    /**
     * 商品销售价
     */
    @Excel(name = "商品销售价")
    private BigDecimal price;

    /**
     * 会员价格后续扩展，暂时冗余不需要使用
     */
    @Excel(name = "会员价格")
    private BigDecimal vipPrice;

    /**
     * 关联商品分类
     */
    @Excel(name = "关联商品分类")
    private Long productCategoryId;

    /**
     * 单位名
     */
    @Excel(name = "单位名")
    private String unit;

    /**
     * 排序正序
     */
    @Excel(name = "排序正序")
    private Integer sort;

    /**
     * 销量
     */
    @Excel(name = "销量")
    private Integer sales;

    /**
     * 产品描述
     */
    @Excel(name = "产品描述")
    private String introduction;

    /**
     * 是否删除,0是1否
     */
    private Integer isDel;

    /**
     * 副标题
     */
    @Excel(name = "副标题")
    private String caption;

    /**
     * 市场价
     */
    @Excel(name = "市场价")
    private BigDecimal marketPrice;

    /**
     * 是否上架
     */
    @Excel(name = "是否上架")
    private Integer isMarketable;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String memo;

    /**
     * 冗余
     */
    private String seoTitle;

    /**
     * 搜索关键词
     */
    private String keyword;

    /**
     * 品牌id
     */
    @Excel(name = "品牌id")
    private Long brandId;

    /**
     * 参数值json-暂时保留字段目前不需要使用
     */
    private String parameterValues;

    /**
     * 规格项 json
     */
    @Excel(name = "规格项 json")
    private String specificationItems;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 商品类型见枚举
     */
    @Excel(name = "商品类型见枚举")
    private Integer productType;

    /**
     * 配送方式
     */
    @Excel(name = "配送方式")
    private Long shippingMethodId;

    /**
     * 仓库id
     */
    @Excel(name = "仓库id")
    private Long warehouseId;

    /**
     * 项目id
     */
    @Excel(name = "项目id")
    private Long projectId;
    /**
     * sku列表
     */
    private List<TSku> skuList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public String getProductImages() {
        return productImages;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setVipPrice(BigDecimal vipPrice) {
        this.vipPrice = vipPrice;
    }

    public BigDecimal getVipPrice() {
        return vipPrice;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getSales() {
        return sales;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setIsMarketable(Integer isMarketable) {
        this.isMarketable = isMarketable;
    }

    public Integer getIsMarketable() {
        return isMarketable;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setParameterValues(String parameterValues) {
        this.parameterValues = parameterValues;
    }

    public String getParameterValues() {
        return parameterValues;
    }

    public void setSpecificationItems(String specificationItems) {
        this.specificationItems = specificationItems;
    }

    public String getSpecificationItems() {
        return specificationItems;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setShippingMethodId(Long shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
    }

    public Long getShippingMethodId() {
        return shippingMethodId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public List<TSku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<TSku> skuList) {
        this.skuList = skuList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("sn", getSn())
                .append("productName", getProductName())
                .append("productImages", getProductImages())
                .append("image", getImage())
                .append("price", getPrice())
                .append("vipPrice", getVipPrice())
                .append("productCategoryId", getProductCategoryId())
                .append("unit", getUnit())
                .append("sort", getSort())
                .append("sales", getSales())
                .append("introduction", getIntroduction())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDel", getIsDel())
                .append("caption", getCaption())
                .append("marketPrice", getMarketPrice())
                .append("isMarketable", getIsMarketable())
                .append("memo", getMemo())
                .append("seoTitle", getSeoTitle())
                .append("keyword", getKeyword())
                .append("brandId", getBrandId())
                .append("parameterValues", getParameterValues())
                .append("specificationItems", getSpecificationItems())
                .append("version", getVersion())
                .append("productType", getProductType())
                .append("shippingMethodId", getShippingMethodId())
                .append("warehouseId", getWarehouseId())
                .append("projectId", getProjectId())
                .toString();
    }
}
