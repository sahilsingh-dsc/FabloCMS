package com.myfablo.cms.module_menu_sync.models.menu_items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MenuItem {

    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("hasSubCategory")
    @Expose
    private Boolean hasSubCategory;
    @SerializedName("hasProduct")
    @Expose
    private Boolean hasProduct;
    @SerializedName("categoryImage")
    @Expose
    private String categoryImage;
    @SerializedName("subCategory")
    @Expose
    private List<SubCategory> subCategory;
    @SerializedName("products")
    @Expose
    private List<Product> products;
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
    public MenuItem() {
    }

    /**
     * @param outOfStockProductsCount
     * @param subCategory
     * @param totalProductsCount
     * @param hasProduct
     * @param categoryImage
     * @param hasSubCategory
     * @param subCategoriesCount
     * @param availableProductsCount
     * @param categoryName
     * @param categoryId
     * @param products
     */
    public MenuItem(String categoryId, String categoryName, Boolean hasSubCategory, Boolean hasProduct, String categoryImage, List<SubCategory> subCategory, List<Product> products, Integer subCategoriesCount, Integer totalProductsCount, Integer availableProductsCount, Integer outOfStockProductsCount) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.hasSubCategory = hasSubCategory;
        this.hasProduct = hasProduct;
        this.categoryImage = categoryImage;
        this.subCategory = subCategory;
        this.products = products;
        this.subCategoriesCount = subCategoriesCount;
        this.totalProductsCount = totalProductsCount;
        this.availableProductsCount = availableProductsCount;
        this.outOfStockProductsCount = outOfStockProductsCount;
    }

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

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public List<SubCategory> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<SubCategory> subCategory) {
        this.subCategory = subCategory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

}