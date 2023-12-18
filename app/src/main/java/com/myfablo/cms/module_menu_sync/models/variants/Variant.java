package com.myfablo.cms.module_menu_sync.models.variants;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Variant {

    @SerializedName("variantId")
    @Expose
    private String variantId;
    @SerializedName("variantName")
    @Expose
    private String variantName;
    @SerializedName("displayPrice")
    @Expose
    private Float displayPrice;
    @SerializedName("hasCustomization")
    @Expose
    private Boolean hasCustomization;

    /**
     * No args constructor for use in serialization
     */
    public Variant() {
    }

    /**
     * @param displayPrice
     * @param hasCustomization
     * @param variantId
     * @param variantName
     */
    public Variant(String variantId, String variantName, Float displayPrice, Boolean hasCustomization) {
        super();
        this.variantId = variantId;
        this.variantName = variantName;
        this.displayPrice = displayPrice;
        this.hasCustomization = hasCustomization;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public Float getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(Float displayPrice) {
        this.displayPrice = displayPrice;
    }

    public Boolean getHasCustomization() {
        return hasCustomization;
    }

    public void setHasCustomization(Boolean hasCustomization) {
        this.hasCustomization = hasCustomization;
    }

}