package com.myfablo.cms.module_outlet.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscountDetails {

    @SerializedName("discountPercent")
    @Expose
    private String discountPercent;
    @SerializedName("isFlatDiscount")
    @Expose
    private Boolean isFlatDiscount;
    @SerializedName("maxDiscount")
    @Expose
    private String maxDiscount;
    @SerializedName("minAmount")
    @Expose
    private String minAmount;

    /**
     * No args constructor for use in serialization
     */
    public DiscountDetails() {
    }

    /**
     * @param minAmount
     * @param discountPercent
     * @param isFlatDiscount
     * @param maxDiscount
     */
    public DiscountDetails(String discountPercent, Boolean isFlatDiscount, String maxDiscount, String minAmount) {
        super();
        this.discountPercent = discountPercent;
        this.isFlatDiscount = isFlatDiscount;
        this.maxDiscount = maxDiscount;
        this.minAmount = minAmount;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Boolean getIsFlatDiscount() {
        return isFlatDiscount;
    }

    public void setIsFlatDiscount(Boolean isFlatDiscount) {
        this.isFlatDiscount = isFlatDiscount;
    }

    public String getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(String maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public String getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(String minAmount) {
        this.minAmount = minAmount;
    }

}