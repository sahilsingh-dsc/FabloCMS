package com.myfablo.cms.module_menu_sync;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.myfablo.cms.databinding.ActivitySyncSwiggyBinding;
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
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.common_req_res.BasicResponse;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SyncSwiggyActivity extends AppCompatActivity {

    private ActivitySyncSwiggyBinding binding;
    private Context context;
    private AddCategoryContract addCategoryContract;
    private AddSubCategoryContract addSubCategoryContract;
    private AddProductContract addProductContract;
    private String outletId;
    private Menu menu;
    private ProgressDialog progressDialog;
    private boolean isDirect = true;

    private static final String TAG = "SyncSwiggyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySyncSwiggyBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = SyncSwiggyActivity.this;
        initView();
    }

    private void initView() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Syncing...");
        initContracts();
        initRecycler();
        showMenu();

    }

    private void initContracts() {
        addCategoryContract = new AddCategoryContract(context, new AddCategoryInterface() {
            @Override
            public void onContractProgress() {

            }

            @Override
            public void onContractResponse(BasicResponse basicResponse) {
                String parentCategoryId = basicResponse.getItems();
                if (menu.getItems().get(0).getTitle() == null) {
                    addDirectProduct(parentCategoryId);
                } else {
                    addSubCategoryAndProduct(parentCategoryId);
                }
            }

            @Override
            public void onContractNotFound() {

            }

            @Override
            public void onContractFailure() {

            }
        });

        addSubCategoryContract = new AddSubCategoryContract(context, new AddSubCategoryInterface() {
            @Override
            public void onContractProgress() {

            }

            @Override
            public void onContractResponse(BasicResponse basicResponse) {

            }

            @Override
            public void onContractNotFound() {

            }

            @Override
            public void onContractFailure() {

            }
        });


        addProductContract = new AddProductContract(context, new AddProductInterface() {
            @Override
            public void onContractProgress() {

            }

            @Override
            public void onContractResponse(BasicResponse basicResponse) {

            }

            @Override
            public void onContractNotFound() {

            }

            @Override
            public void onContractFailure() {

            }
        });

    }

    private void initRecycler() {
        binding.recyclerMenu.setLayoutManager(new LinearLayoutManager(context));
    }

    private void showMenu() {
        String swiggyMenuJson = getIntent().getStringExtra("menu");
        Gson gson = new Gson();
        MenuUploadResponse menuUploadResponse = gson.fromJson(swiggyMenuJson, MenuUploadResponse.class);
        if (menuUploadResponse != null) {
            CategorySyncAdapter categorySyncAdapter = new CategorySyncAdapter(context, menuUploadResponse.getMenu());
            binding.recyclerMenu.setAdapter(categorySyncAdapter);
        }
    }

    private void createCategory() {
        progressDialog.show();
        AuthPref authPref = new AuthPref(context);
        AddCategoryRequest addCategoryRequest = new AddCategoryRequest();
        addCategoryRequest.setOutletId(authPref.getOutletId());
        addCategoryRequest.setCategoryName(menu.getTitle());
        addCategoryContract.addCategory(addCategoryRequest);
    }

    private void addDirectProduct(String parentCategoryId) {
        if (menu != null) {
            if (menu.getItems() != null) {
                if (menu.getItems().get(0).getTitle() == null) {
                    for (Item item : menu.getItems()) {
                        AddProductRequest addProductRequest = new AddProductRequest();
                        addProductRequest.setParentCategoryId(parentCategoryId);
                        addProductRequest.setProductName(item.getName());
                        addProductRequest.setProductPrice(Double.valueOf(item.getPrice()));
                        addProductRequest.setProductDesc(item.getDescription());
                        addProductRequest.setProductImage(item.getImage());
                        addProductRequest.setIsVeg(item.getIsVeg());

                        MenuInterface menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);

                        AuthPref authPref = new AuthPref(context);
                        Call<BasicResponse> call = menuInterface.addProduct(authPref.getBearerToken(), addProductRequest);
                        call.enqueue(new Callback<BasicResponse>() {
                            @Override
                            public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                                    if (response.body() != null) {
                                        if (response.body().getSubCode() ==  Constant.SERVICE_RESPONSE_CODE_SUCCESS) {

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
        progressDialog.cancel();
    }

    private void addSubCategoryAndProduct(String parentCategoryId) {
        if (menu != null) {
            if (menu.getItems() != null) {
                    for (Item item : menu.getItems()) {

                        AddSubCategoryRequest addSubCategoryRequest = new AddSubCategoryRequest();
                        addSubCategoryRequest.setParentCategoryId(parentCategoryId);
                        addSubCategoryRequest.setCategoryName(item.getTitle());

                        MenuInterface menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);

                        AuthPref authPref = new AuthPref(context);
                        Call<BasicResponse> call = menuInterface.addProductSubCategoryCategory(authPref.getBearerToken(), addSubCategoryRequest);
                        call.enqueue(new Callback<BasicResponse>() {

                            @Override
                            public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                                    if (response.body() != null) {
                                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                                            String subCategoryId = response.body().getItems();
                                            for (Dish dish : item.getDishes()) {

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
        progressDialog.cancel();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Menu menuData) {
        if (menuData != null) {
            menu = menuData;
            createCategory();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

}