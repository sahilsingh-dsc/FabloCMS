package com.myfablo.cms.module_outlet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowInsets;

import com.myfablo.cms.R;
import com.myfablo.cms.databinding.ActivityOutletBinding;
import com.myfablo.cms.module_outlet.adapters.OutletRecyclerAdapter;
import com.myfablo.cms.module_outlet.contracts.contract_get_all_outlets.GetAllOutletContract;
import com.myfablo.cms.module_outlet.contracts.contract_get_all_outlets.GetAllOutletInterface;
import com.myfablo.cms.module_outlet.models.OutletItem;
import com.myfablo.cms.module_outlet.models.OutletResponse;

import java.util.ArrayList;
import java.util.List;

public class OutletActivity extends AppCompatActivity {

    private ActivityOutletBinding binding;
    private Context context;
    private GetAllOutletContract getAllOutletContract;
    private OutletRecyclerAdapter outletRecyclerAdapter;
    private List<OutletItem> outletItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOutletBinding.inflate(getLayoutInflater());
        setTransparentStatusBar();
        View view = binding.getRoot();
        setContentView(view);
        context = OutletActivity.this;
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
        outletItemList = new ArrayList<>();
        outletRecyclerAdapter = new OutletRecyclerAdapter(context, outletItemList);
        initRecycler();
        initContracts();
        initTextChangeListener();

        getAllOutletContract.getAllOutlets();
    }

    private void initTextChangeListener() {
        binding.etSearchOutlet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                filterOutlet(editable.toString());
            }
        });
    }

    private void initRecycler() {
        binding.recyclerOutlets.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerOutlets.setAdapter(outletRecyclerAdapter);
    }

    private void initContracts() {
        getAllOutletContract = new GetAllOutletContract(context, new GetAllOutletInterface() {
            @Override
            public void onContractProgress() {

            }

            @Override
            public void onContractResponse(OutletResponse outletResponse) {
                showOutlets(outletResponse.getItems());
            }

            @Override
            public void onContractNotFound() {

            }

            @Override
            public void onContractFailure() {

            }
        });
    }

    private void filterOutlet(String queryString) {
        List<OutletItem> tempItemList = new ArrayList<>();
        for (OutletItem outlet : outletItemList) {
            if (outlet.getOutletName().toLowerCase().contains(queryString)) {
                tempItemList.add(outlet);
            }
        }
        outletRecyclerAdapter.updateList(tempItemList);
    }

    private void showOutlets(List<OutletItem> items) {
        outletItemList.clear();
        outletItemList.addAll(items);
        outletRecyclerAdapter.notifyDataSetChanged();
    }
}