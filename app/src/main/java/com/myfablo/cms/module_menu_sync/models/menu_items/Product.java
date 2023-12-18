package com.myfablo.cms.module_menu_sync.models.menu_items;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product implements Parcelable {

    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("parentCategoryId")
    @Expose
    private String parentCategoryId;
    @SerializedName("outletId")
    @Expose
    private String outletId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productDesc")
    @Expose
    private String productDesc;
    @SerializedName("productImage")
    @Expose
    private String productImage;
    @SerializedName("productPrice")
    @Expose
    private Float productPrice;
    @SerializedName("isVeg")
    @Expose
    private Boolean isVeg;
    @SerializedName("inStock")
    @Expose
    private Boolean inStock;
    @SerializedName("displayPrice")
    @Expose
    private Float displayPrice;
    @SerializedName("hasCustomization")
    @Expose
    private Boolean hasCustomization;
    @SerializedName("hasAddOn")
    @Expose
    private Boolean hasAddOn;
    @SerializedName("addOnList")
    @Expose
    private List<Object> addOnList;

    /**
     * No args constructor for use in serialization
     */
    public Product() {
    }

    /**
     * @param productId
     * @param hasCustomization
     * @param outletId
     * @param addOnList
     * @param productName
     * @param productDesc
     * @param hasAddOn
     * @param productImage
     * @param isVeg
     * @param displayPrice
     * @param parentCategoryId
     * @param inStock
     * @param productPrice
     */
    public Product(String productId, String parentCategoryId, String outletId, String productName, String productDesc, String productImage, Float productPrice, Boolean isVeg, Boolean inStock, Float displayPrice, Boolean hasCustomization, Boolean hasAddOn, List<Object> addOnList) {
        super();
        this.productId = productId;
        this.parentCategoryId = parentCategoryId;
        this.outletId = outletId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.isVeg = isVeg;
        this.inStock = inStock;
        this.displayPrice = displayPrice;
        this.hasCustomization = hasCustomization;
        this.hasAddOn = hasAddOn;
        this.addOnList = addOnList;
    }

    protected Product(Parcel in) {
        productId = in.readString();
        parentCategoryId = in.readString();
        outletId = in.readString();
        productName = in.readString();
        productDesc = in.readString();
        productImage = in.readString();
        if (in.readByte() == 0) {
            productPrice = null;
        } else {
            productPrice = in.readFloat();
        }
        byte tmpIsVeg = in.readByte();
        isVeg = tmpIsVeg == 0 ? null : tmpIsVeg == 1;
        byte tmpInStock = in.readByte();
        inStock = tmpInStock == 0 ? null : tmpInStock == 1;
        if (in.readByte() == 0) {
            displayPrice = null;
        } else {
            displayPrice = in.readFloat();
        }
        byte tmpHasCustomization = in.readByte();
        hasCustomization = tmpHasCustomization == 0 ? null : tmpHasCustomization == 1;
        byte tmpHasAddOn = in.readByte();
        hasAddOn = tmpHasAddOn == 0 ? null : tmpHasAddOn == 1;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
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

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
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

    public Boolean getHasAddOn() {
        return hasAddOn;
    }

    public void setHasAddOn(Boolean hasAddOn) {
        this.hasAddOn = hasAddOn;
    }

    public List<Object> getAddOnList() {
        return addOnList;
    }

    public void setAddOnList(List<Object> addOnList) {
        this.addOnList = addOnList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(productId);
        parcel.writeString(parentCategoryId);
        parcel.writeString(outletId);
        parcel.writeString(productName);
        parcel.writeString(productDesc);
        parcel.writeString(productImage);
        if (productPrice == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(productPrice);
        }
        parcel.writeByte((byte) (isVeg == null ? 0 : isVeg ? 1 : 2));
        parcel.writeByte((byte) (inStock == null ? 0 : inStock ? 1 : 2));
        if (displayPrice == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(displayPrice);
        }
        parcel.writeByte((byte) (hasCustomization == null ? 0 : hasCustomization ? 1 : 2));
        parcel.writeByte((byte) (hasAddOn == null ? 0 : hasAddOn ? 1 : 2));
    }
}