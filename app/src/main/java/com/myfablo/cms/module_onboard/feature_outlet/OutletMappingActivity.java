package com.myfablo.cms.module_onboard.feature_outlet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.myfablo.cms.R;
import com.myfablo.cms.databinding.ActivityOutletMappingBinding;
import com.myfablo.cms.utils.alerts.FabLoading;

public class OutletMappingActivity extends AppCompatActivity {

    private ActivityOutletMappingBinding binding;
    private Context context;
    private FabLoading fabLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOutletMappingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = OutletMappingActivity.this;
        initView();
    }

    private void initView() {
        fabLoading = FabLoading.getInstance();
        initClicks();
    }

    private void initClicks() {

    }
}