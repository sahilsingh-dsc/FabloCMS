package com.myfablo.cms.module_order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.myfablo.cms.databinding.ActivityOrderBinding;
import com.myfablo.cms.module_order.adapters.OrderRecyclerAdapter;
import com.myfablo.cms.module_order.feature_get_order.contracts.GetOrderContract;
import com.myfablo.cms.module_order.feature_get_order.contracts.GetOrderInterface;
import com.myfablo.cms.module_order.feature_get_order.models.response.Item;
import com.myfablo.cms.module_order.feature_get_order.models.response.OrderResponse;

import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private ActivityOrderBinding binding;
    private Context context;

    private GetOrderContract getOrderContract;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = OrderActivity.this;
        initView();
    }

    private void initView() {
        initClick();
        initRecycler();
        initContracts();
    }

    private void initClick() {

    }

    private void initRecycler() {
        binding.recyclerOrder.setLayoutManager(new LinearLayoutManager(context));
    }

    private void initContracts() {
        getOrderContract = new GetOrderContract(context, new GetOrderInterface() {
            @Override
            public void onContractProgress() {

            }

            @Override
            public void onContractResponse(OrderResponse body) {
                showOrders(body.getItems());
            }

            @Override
            public void onContractNotFound() {

            }

            @Override
            public void onContractFailure() {

            }
        });
    }

    private void showOrders(List<Item> items) {
        OrderRecyclerAdapter orderRecyclerAdapter = new OrderRecyclerAdapter(context, items);
        binding.recyclerOrder.setAdapter(orderRecyclerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getOrderContract.getOrders("all");
    }
}