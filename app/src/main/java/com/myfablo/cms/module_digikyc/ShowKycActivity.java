package com.myfablo.cms.module_digikyc;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.myfablo.cms.databinding.ActivityShowKycBinding;
import com.myfablo.cms.module_digikyc.fssai.models.response.FssaiVerifyResponse;
import com.myfablo.cms.module_digikyc.pan.models.response.PanVerifyResponse;

public class ShowKycActivity extends AppCompatActivity {

    private ActivityShowKycBinding binding;
    private Context context;

    private FssaiVerifyResponse fssaiVerifyResponse;
    private PanVerifyResponse panVerifyResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowKycBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = ShowKycActivity.this;
        initView();
    }

    private void initView() {
        String panJson = getIntent().getStringExtra("pan");
        String fssaiJson = getIntent().getStringExtra("fssai");
        Gson gson = new Gson();
        fssaiVerifyResponse = gson.fromJson(fssaiJson, FssaiVerifyResponse.class);
        panVerifyResponse = gson.fromJson(panJson, PanVerifyResponse.class);

        binding.tvSellerName.setText(fssaiVerifyResponse.getItems().getSaveData().getEntity());
        binding.tvLicenceUid.setText(fssaiVerifyResponse.getItems().getSaveData().getUuid());
        binding.tvCategory.setText(fssaiVerifyResponse.getItems().getSaveData().getCategory());
        binding.tvAddress.setText(fssaiVerifyResponse.getItems().getSaveData().getAddress());
        binding.tvState.setText(fssaiVerifyResponse.getItems().getSaveData().getState());
        binding.tvPinCode.setText(""+fssaiVerifyResponse.getItems().getSaveData().getZip());
        binding.tvLicenceNo.setText(fssaiVerifyResponse.getItems().getSaveData().getReg());

    }
}