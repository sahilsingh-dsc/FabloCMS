package com.myfablo.cms.module_digikyc.fssai;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.myfablo.cms.databinding.ActivityFssaiVerifyBinding;

public class FssaiVerifyActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityFssaiVerifyBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFssaiVerifyBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = FssaiVerifyActivity.this;
        initView();
    }

    private void initView() {
        initClickListener();
    }

    private void initClickListener() {
        binding.ivGoBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.ivGoBack) {
            onBackPressed();
        }
    }
}