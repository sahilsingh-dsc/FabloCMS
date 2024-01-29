package com.myfablo.cms.module_order.feature_get_order.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("variationName")
    @Expose
    private String variationName;
    @SerializedName("productPrice")
    @Expose
    private Float productPrice;
    @SerializedName("isVeg")
    @Expose
    private Boolean isVeg;
    @SerializedName("quantityPrice")
    @Expose
    private Float quantityPrice;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("addOnName")
    @Expose
    private String addOnName;
    @SerializedName("addOnIdList")
    @Expose
    private List<String> addOnIdList;

    /**
     * No args constructor for use in serialization
     */
    public Product() {
    }

    /**
     * @param variationName
     * @param isVeg
     * @param quantity
     * @param productId
     * @param quantityPrice
     * @param addOnIdList
     * @param productName
     * @param productPrice
     * @param addOnName
     */
    public Product(String productId, String productName, String variationName, Float productPrice, Boolean isVeg, Float quantityPrice, Integer quantity, String addOnName, List<String> addOnIdList) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.variationName = variationName;
        this.productPrice = productPrice;
        this.isVeg = isVeg;
        this.quantityPrice = quantityPrice;
        this.quantity = quantity;
        this.addOnName = addOnName;
        this.addOnIdList = addOnIdList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getVariationName() {
        return variationName;
    }

    public void setVariationName(String variationName) {
        this.variationName = variationName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Boolean getIsVeg() {
        return isVeg;
    }

    public void setIsVeg(Boolean isVeg) {
        this.isVeg = isVeg;
    }

    public Float getQuantityPrice() {
        return quantityPrice;
    }

    public void setQuantityPrice(Float quantityPrice) {
        this.quantityPrice = quantityPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAddOnName() {
        return addOnName;
    }

    public void setAddOnName(String addOnName) {
        this.addOnName = addOnName;
    }

    public List<String> getAddOnIdList() {
        return addOnIdList;
    }

    public void setAddOnIdList(List<String> addOnIdList) {
        this.addOnIdList = addOnIdList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Product.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("productId");
        sb.append('=');
        sb.append(((this.productId == null) ? "<null>" : this.productId));
        sb.append(',');
        sb.append("productName");
        sb.append('=');
        sb.append(((this.productName == null) ? "<null>" : this.productName));
        sb.append(',');
        sb.append("variationName");
        sb.append('=');
        sb.append(((this.variationName == null) ? "<null>" : this.variationName));
        sb.append(',');
        sb.append("productPrice");
        sb.append('=');
        sb.append(((this.productPrice == null) ? "<null>" : this.productPrice));
        sb.append(',');
        sb.append("isVeg");
        sb.append('=');
        sb.append(((this.isVeg == null) ? "<null>" : this.isVeg));
        sb.append(',');
        sb.append("quantityPrice");
        sb.append('=');
        sb.append(((this.quantityPrice == null) ? "<null>" : this.quantityPrice));
        sb.append(',');
        sb.append("quantity");
        sb.append('=');
        sb.append(((this.quantity == null) ? "<null>" : this.quantity));
        sb.append(',');
        sb.append("addOnName");
        sb.append('=');
        sb.append(((this.addOnName == null) ? "<null>" : this.addOnName));
        sb.append(',');
        sb.append("addOnIdList");
        sb.append('=');
        sb.append(((this.addOnIdList == null) ? "<null>" : this.addOnIdList));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}