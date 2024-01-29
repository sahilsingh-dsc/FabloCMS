package com.myfablo.cms.module_onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;
import com.myfablo.cms.R;
import com.myfablo.cms.databinding.ActivityOnboardBinding;
import com.myfablo.cms.module_digikyc.KycActivity;

import java.util.HashMap;

public class OnboardActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityOnboardBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = OnboardActivity.this;
        initView();
    }

    private void initView() {
        initClick();
    }

    private void initClick() {
        binding.ivGoBack.setOnClickListener(this);
        binding.btnKycStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == binding.ivGoBack) {
            onBackPressed();
        } else if (v == binding.btnKycStart) {
            Intent intent = new Intent(context, KycActivity.class);
            startActivity(intent);
        }
    }
}