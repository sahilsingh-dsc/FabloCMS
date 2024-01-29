package com.myfablo.cms.module_outlet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.myfablo.cms.R;
import com.myfablo.cms.databinding.ActivityOutletDetailsBinding;
import com.myfablo.cms.module_menu_sync.SyncSwiggyActivity;
import com.myfablo.cms.module_menu_sync.contract_add_category.AddCategoryContract;
import com.myfablo.cms.module_menu_sync.contract_add_category.AddCategoryInterface;
import com.myfablo.cms.module_menu_sync.contract_add_product.AddProductContract;
import com.myfablo.cms.module_menu_sync.contract_add_product.AddProductInterface;
import com.myfablo.cms.module_menu_sync.contract_add_sub_category.AddSubCategoryContract;
import com.myfablo.cms.module_menu_sync.contract_add_sub_category.AddSubCategoryInterface;
import com.myfablo.cms.module_menu_sync.models.category.add.AddCategoryRequest;
import com.myfablo.cms.module_menu_sync.models.product.add.AddProductRequest;
import com.myfablo.cms.module_menu_sync.models.sub_category.add.AddSubCategoryRequest;
import com.myfablo.cms.module_menu_sync.models.upload_swiggy.Dish;
import com.myfablo.cms.module_menu_sync.models.upload_swiggy.Item;
import com.myfablo.cms.module_menu_sync.models.upload_swiggy.Menu;
import com.myfablo.cms.module_menu_sync.models.upload_swiggy.MenuUploadResponse;
import com.myfablo.cms.module_outlet.models.OutletItem;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.FileUploadHelper;
import com.myfablo.cms.utils.common_req_res.BasicResponse;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OutletDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_CODE = 111;
    private ActivityOutletDetailsBinding binding;
    private Context context;

    private AddCategoryContract addCategoryContract;
    private AddSubCategoryContract addSubCategoryContract;
    private AddProductContract addProductContract;

    private String outletId;
    private String parentCategoryId;
    private String subCategoryId;

    private MenuUploadResponse menuUploadResponseData;

    private static final String TAG = "OutletDetailsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOutletDetailsBinding.inflate(getLayoutInflater());
        setTransparentStatusBar();
        View view = binding.getRoot();
        setContentView(view);
        context = OutletDetailsActivity.this;
        initView();
    }

    private void setTransparentStatusBar() {
        View decorView = getWindow().getDecorView();
        decorView.setOnApplyWindowInsetsListener((v, insets) -> {
            WindowInsets defaultInsets = v.onApplyWindowInsets(insets);
            return defaultInsets.replaceSystemWindowInsets(
                    defaultInsets.getSystemWindowInsetLeft(),
                    0,
                    defaultInsets.getSystemWindowInsetRight(),
                    defaultInsets.getSystemWindowInsetBottom());
        });
        ViewCompat.requestApplyInsets(decorView);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));
    }


    private void initView() {
//        binding.btnUploadMenu.setOnClickListener(this);

        String outletStringJson = getIntent().getStringExtra("outlet");
        Gson gson = new Gson();
        OutletItem outletItem = gson.fromJson(outletStringJson, OutletItem.class);
        outletId = outletItem.getOutletId();
        setOutletDetails(outletItem);
        AuthPref authPref = new AuthPref(context);
        authPref.setOutletId(outletId);
    }

    private void selectFile() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // Set the desired file type (e.g., "image/*" for images)
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            String path = getPath(uri); // Method to get the file path from URI
            uploadFile(uri);
        }
    }

    private void uploadFile(Uri uri) {
        FileUploadHelper fileUploadHelper = new FileUploadHelper(context);
        fileUploadHelper.uploadFile(uri, new Callback<MenuUploadResponse>() {
            @Override
            public void onResponse(Call<MenuUploadResponse> call, Response<MenuUploadResponse> response) {
                if (response.body() != null) {
                    Gson gson = new Gson();
                    String swiggyMenuJson = gson.toJson(response.body());
                    Intent intent = new Intent(context, SyncSwiggyActivity.class);
                    intent.putExtra("menu", swiggyMenuJson);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<MenuUploadResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
                Toast.makeText(context, "Upload Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void processMenu() {
        if (menuUploadResponseData != null) {
            for (Menu menu : menuUploadResponseData.getMenu()) {


                Log.e(TAG, "Category -----: " + menu.getType() + "  :::::  " + menu.getTitle());
                AddCategoryRequest addCategoryRequest = new AddCategoryRequest();
                addCategoryRequest.setOutletId(outletId);
                addCategoryRequest.setCategoryName(menu.getTitle());

                AuthPref authPref = new AuthPref(context);
                MenuInterface menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
                Call<BasicResponse> call = menuInterface.addProductCategory(authPref.getBearerToken(), addCategoryRequest);
                call.enqueue(new Callback<BasicResponse>() {

                    @Override
                    public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                        if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                            if (response.body() != null) {
                                if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                                    parentCategoryId = response.body().getItems();
                                    Log.e(TAG, "onResponse: Category Created:  "+addCategoryRequest.getCategoryName() );
                                } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                                    // client error
                                }
                            }
                        } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                            // server error
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                        // call error
                    }
                });

                if (menu.getItems() != null) {
                    for (Item item : menu.getItems()) {

                        // Check if the item itself is a direct product
                        if (item.getName() != null && !item.getName().isEmpty()) {
                            Log.e(TAG, "parentCatId: "+parentCategoryId);
                            AddProductRequest addProductRequest = new AddProductRequest();
                            addProductRequest.setParentCategoryId(parentCategoryId);
                            addProductRequest.setProductName(item.getName());
                            addProductRequest.setProductPrice(Double.valueOf(item.getPrice()));
                            addProductRequest.setProductDesc(item.getDescription());
                            addProductRequest.setProductImage(item.getImage());
                            addProductRequest.setIsVeg(item.getIsVeg());


                            Call<BasicResponse> callBR = menuInterface.addProduct(authPref.getBearerToken(), addProductRequest);
                            callBR.enqueue(new Callback<BasicResponse>() {
                                @Override
                                public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                                    if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                                        if (response.body() != null) {
                                            if (response.body().getSubCode() ==  Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                                                Log.e(TAG, "onResponse: Product Created:  "+addProductRequest.getProductName());
                                            } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                                                //
                                            }
                                        }
                                    } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                                        //
                                    }
                                }

                                @Override
                                public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                                    //
                                }
                            });

                        }

                        // check for sub category
                        if (item.getDishes() != null && !item.getDishes().isEmpty()) {
                           // sub category
                            AddSubCategoryRequest addSubCategoryRequest = new AddSubCategoryRequest();
                            addSubCategoryRequest.setParentCategoryId(parentCategoryId);
                            addSubCategoryRequest.setCategoryName(menu.getTitle());

                            Call<BasicResponse> callBRC = menuInterface.addProductSubCategoryCategory(authPref.getBearerToken(), addSubCategoryRequest);
                            callBRC.enqueue(new Callback<BasicResponse>() {

                                @Override
                                public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                                    if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                                        if (response.body() != null) {
                                            if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                                                subCategoryId = response.body().getItems();
                                                Log.e(TAG, "onResponse: Sub Category Created : "+addSubCategoryRequest.getCategoryName());
                                            } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                                                //
                                            }
                                        }
                                    } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                                        //
                                    }
                                }

                                @Override
                                public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                                    //
                                }
                            });


                            for (Dish dish : item.getDishes()) {
                                Log.e(TAG, "subCatId: "+subCategoryId);
                                AddProductRequest addProductRequest = new AddProductRequest();
                                addProductRequest.setParentCategoryId(subCategoryId);
                                addProductRequest.setProductName(dish.getName());
                                addProductRequest.setProductPrice(Double.valueOf(dish.getPrice()));
                                addProductRequest.setProductDesc(dish.getDescription());
                                addProductRequest.setProductImage(dish.getImage());
                                addProductRequest.setIsVeg(dish.getIsVeg());

                                Call<BasicResponse> callBRCD = menuInterface.addProduct(authPref.getBearerToken(), addProductRequest);
                                callBRCD.enqueue(new Callback<BasicResponse>() {
                                    @Override
                                    public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                                        if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                                            if (response.body() != null) {
                                                if (response.body().getSubCode() ==  Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                                                    Log.e(TAG, "onResponse: Product Created:  "+addProductRequest.getProductName());
                                                } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                                                    //
                                                }
                                            }
                                        } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                                            //
                                        }
                                    }

                                    @Override
                                    public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                                        //
                                    }
                                });

                            }
                        }
                    }
                }
            }
        }
    }

    public String getPath(Uri uri) {
        String path = null;
        String[] projection = { MediaStore.Files.FileColumns.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);
                path = cursor.getString(columnIndex);
            }
            cursor.close();
        }
        return path;
    }

    private void setOutletDetails(OutletItem outletItem) {
        if (outletItem.getClosed() != null && outletItem.getClosed()) {
            binding.ivOutletImage.setBackground(context.getResources().getDrawable(R.drawable.ring_outlet_offline));
        } else {
            binding.ivOutletImage.setBackground(context.getResources().getDrawable(R.drawable.ring_outlet_online));
        }
        setTextSafe(binding.tvOutletName, outletItem.getOutletName());
        setTextSafe(binding.tvOutletArea, outletItem.getArea());

        List<String> outletImages = outletItem.getOutletImage();
        if (outletImages != null && !outletImages.isEmpty()) {
            Glide.with(context)
                    .load(outletImages.get(0))
                    .error(R.drawable.no_image) // Assuming you have a placeholder for errors
                    .into(binding.ivOutletImage);
        } else {
            binding.ivOutletImage.setImageResource(R.drawable.no_image); // Use a default image
        }
    }

    private void setTextSafe(TextView textView, String text) {
        if (text != null) {
            textView.setText(text);
        } else {
            textView.setText("N/A"); // Set to a default "not available" text or keep it empty
        }
    }

    private void syncMenuCreateCategory(AddCategoryRequest addCategoryRequest) {
        addCategoryContract.addCategory(addCategoryRequest);
    }

    private void syncMenuCreateSubCategory(AddSubCategoryRequest addSubCategoryRequest) {
        addSubCategoryContract.addCategory(addSubCategoryRequest);
    }

    private void syncMenuCreateProduct(AddProductRequest addProductRequest) {
        addProductContract.addProduct(addProductRequest);
    }


    @Override
    public void onClick(View view) {
//        if (view == binding.btnUploadMenu) {
//            selectFile();
//        }
    }
}