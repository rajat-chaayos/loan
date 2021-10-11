package com.rapipay.loan.Products;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Table;

@Table
public class products {
    
    private Integer productId;
    private String productName;
    private BigDecimal principleAmount;
    private Integer tenure;
    private BigDecimal roi;
    private Boolean isActive;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;

    // constructor
    public products() {
    }
    
    public products(Integer productId, String productName, BigDecimal principleAmount, Integer tenure, BigDecimal roi, Boolean isActive, String createdBy, Date createdOn, String updatedBy, Date updatedOn) {
        this.productId = productId;
        this.productName = productName;
        this.principleAmount = principleAmount;
        this.tenure = tenure;
        this.roi = roi;
        this.isActive = isActive;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
    }


    public Integer getProductId() {
        return productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(BigDecimal principleAmount) {
        this.principleAmount = principleAmount;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "products [productId=" + productId + ", productName=" + productName + ", principleAmount=" + principleAmount + ", tenure=" + tenure + ", roi=" + roi + ", isActive=" + isActive + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
    }
}
