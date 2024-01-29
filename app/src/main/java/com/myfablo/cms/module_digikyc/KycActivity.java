package com.myfablo.cms.module_digikyc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.myfablo.cms.databinding.ActivityKycBinding;
import com.myfablo.cms.module_digikyc.pan.PanVerifyActivity;

public class KycActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityKycBinding binding;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKycBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = KycActivity.this;
        initView();
    }

    private void initView() {
        initClickListener();
    }

    private void initClickListener() {
        binding.btnStartPan.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == binding.btnStartPan) {
            Intent intent = new Intent(context, PanVerifyActivity.class);
            startActivity(intent);
        }
    }
}