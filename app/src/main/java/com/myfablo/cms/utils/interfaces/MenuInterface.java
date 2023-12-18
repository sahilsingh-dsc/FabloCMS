package com.myfablo.cms.utils.interfaces;

import com.myfablo.cms.module_menu_sync.models.addons.product.ProductAddonsResponse;
import com.myfablo.cms.module_menu_sync.models.category.add.AddCategoryRequest;
import com.myfablo.cms.module_menu_sync.models.category.get.MenuCategoryResponse;
import com.myfablo.cms.module_menu_sync.models.menu_items.MenuItemsResponse;
import com.myfablo.cms.module_menu_sync.models.product.MenuProductResponse;
import com.myfablo.cms.module_menu_sync.models.product.add.AddProductRequest;
import com.myfablo.cms.module_menu_sync.models.sub_category.add.AddSubCategoryRequest;
import com.myfablo.cms.module_menu_sync.models.sub_category.get.MenuSubCategoryResponse;
import com.myfablo.cms.module_menu_sync.models.variants.ProductVariantResponse;
import com.myfablo.cms.utils.common_req_res.BasicResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MenuInterface {

    @GET("menu/category/{outletId}")
    Call<MenuCategoryResponse>
    getCategory(@Header("Authorization") String token,
                @Path("outletId") String outletId,
                @Query("type") String type);

    @GET("menu/sub-category/{categoryId}")
    Call<MenuSubCategoryResponse>
    getSubCategory(@Header("Authorization") String token,
                   @Path("categoryId") String categoryId);

    @GET("menu/prod/{categoryId}")
    Call<MenuProductResponse>
    getProduct(@Header("Authorization") String token,
               @Path("categoryId") String categoryId);

    @GET("menu/category/full/{categoryId}")
    Call<MenuItemsResponse>
    getMenuItemsFull(@Header("Authorization") String token,
                     @Path("categoryId") String categoryId);

    @GET("menu/product/addOn/{productId}")
    Call<ProductAddonsResponse>
    getProductAddons(@Header("Authorization") String token,
                     @Path("productId") String productId);

    @GET("menu/customization/{productId}")
    Call<ProductVariantResponse>
    getProductVariant(@Header("Authorization") String token,
                      @Path("productId") String productId);

    @POST("menu/category")
    Call<BasicResponse>
    addProductCategory(@Header("Authorization") String token,
                       @Body AddCategoryRequest addCategoryRequest);

    @POST("menu/category")
    Call<BasicResponse>
    addProductSubCategoryCategory(@Header("Authorization") String token,
                       @Body AddSubCategoryRequest addSubCategoryRequest);

    @POST("menu/product")
    Call<BasicResponse>
    addProduct(@Header("Authorization") String token,
               @Body AddProductRequest addProductRequest);

    @GET("menu/stock/{productId}")
    Call<BasicResponse>
    changeProductStock(@Header("Authorization") String token,
                       @Path("productId") String productId);


}
