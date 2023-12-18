package com.myfablo.cms.module_menu_sync.models.category.get;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable {

    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("categoryImage")
    @Expose
    private String categoryImage;
    @SerializedName("hasSubCategory")
    @Expose
    private Boolean hasSubCategory;
    @SerializedName("hasProduct")
    @Expose
    private Boolean hasProduct;
    @SerializedName("subCategoriesCount")
    @Expose
    private Integer subCategoriesCount;
    @SerializedName("totalProductsCount")
    @Expose
    private Integer totalProductsCount;
    @SerializedName("availableProductsCount")
    @Expose
    private Integer availableProductsCount;
    @SerializedName("outOfStockProductsCount")
    @Expose
    private Integer outOfStockProductsCount;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param outOfStockProductsCount
     * @param totalProductsCount
     * @param categoryImage
     * @param hasProduct
     * @param hasSubCategory
     * @param subCategoriesCount
     * @param availableProductsCount
     * @param categoryName
     * @param categoryId
     */
    public Item(String categoryId, String categoryName, String categoryImage, Boolean hasSubCategory, Boolean hasProduct, Integer subCategoriesCount, Integer totalProductsCount, Integer availableProductsCount, Integer outOfStockProductsCount) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.hasSubCategory = hasSubCategory;
        this.hasProduct = hasProduct;
        this.subCategoriesCount = subCategoriesCount;
        this.totalProductsCount = totalProductsCount;
        this.availableProductsCount = availableProductsCount;
        this.outOfStockProductsCount = outOfStockProductsCount;
    }

    protected Item(Parcel in) {
        categoryId = in.readString();
        categoryName = in.readString();
        categoryImage = in.readString();
        byte tmpHasSubCategory = in.readByte();
        hasSubCategory = tmpHasSubCategory == 0 ? null : tmpHasSubCategory == 1;
        byte tmpHasProduct = in.readByte();
        hasProduct = tmpHasProduct == 0 ? null : tmpHasProduct == 1;
        if (in.readByte() == 0) {
            subCategoriesCount = null;
        } else {
            subCategoriesCount = in.readInt();
        }
        if (in.readByte() == 0) {
            totalProductsCount = null;
        } else {
            totalProductsCount = in.readInt();
        }
        if (in.readByte() == 0) {
            availableProductsCount = null;
        } else {
            availableProductsCount = in.readInt();
        }
        if (in.readByte() == 0) {
            outOfStockProductsCount = null;
        } else {
            outOfStockProductsCount = in.readInt();
        }
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public Boolean getHasSubCategory() {
        return hasSubCategory;
    }

    public void setHasSubCategory(Boolean hasSubCategory) {
        this.hasSubCategory = hasSubCategory;
    }

    public Boolean getHasProduct() {
        return hasProduct;
    }

    public void setHasProduct(Boolean hasProduct) {
        this.hasProduct = hasProduct;
    }

    public Integer getSubCategoriesCount() {
        return subCategoriesCount;
    }

    public void setSubCategoriesCount(Integer subCategoriesCount) {
        this.subCategoriesCount = subCategoriesCount;
    }

    public Integer getTotalProductsCount() {
        return totalProductsCount;
    }

    public void setTotalProductsCount(Integer totalProductsCount) {
        this.totalProductsCount = totalProductsCount;
    }

    public Integer getAvailableProductsCount() {
        return availableProductsCount;
    }

    public void setAvailableProductsCount(Integer availableProductsCount) {
        this.availableProductsCount = availableProductsCount;
    }

    public Integer getOutOfStockProductsCount() {
        return outOfStockProductsCount;
    }

    public void setOutOfStockProductsCount(Integer outOfStockProductsCount) {
        this.outOfStockProductsCount = outOfStockProductsCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(categoryId);
        parcel.writeString(categoryName);
        parcel.writeString(categoryImage);
        parcel.writeByte((byte) (hasSubCategory == null ? 0 : hasSubCategory ? 1 : 2));
        parcel.writeByte((byte) (hasProduct == null ? 0 : hasProduct ? 1 : 2));
        if (subCategoriesCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(subCategoriesCount);
        }
        if (totalProductsCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(totalProductsCount);
        }
        if (availableProductsCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(availableProductsCount);
        }
        if (outOfStockProductsCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(outOfStockProductsCount);
        }
    }
}