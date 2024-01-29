package com.myfablo.cms.module_order.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.myfablo.cms.R;
import com.myfablo.cms.module_order.feature_get_order.models.response.Item;

import java.util.List;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Item> orderItems;

    public OrderRecyclerAdapter(Context context, List<Item> orderItems) {
        this.context = context;
        this.orderItems = orderItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_order, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item items = orderItems.get(position);
        if (items != null) {

            holder.tvOrderId.setText(items.getOrderId());

            String orderTime = items.getTiming().get(0).getDate()+", "+ items.getTiming().get(0).getTime();
            holder.tvOrderTime.setText(orderTime);

            holder.lhOutletSelector.setVisibility(View.VISIBLE);
            holder.tvOutletName.setText(items.getOutlet().getOutletName());
            holder.tvOutletArea.setText(items.getOutlet().getOutletArea());

            holder.recyclerOrderItem.setLayoutManager(new LinearLayoutManager(context));
            OrderItemRecyclerAdapter orderItemRecyclerAdapter = new OrderItemRecyclerAdapter(context, items.getProductList());
            holder.recyclerOrderItem.setAdapter(orderItemRecyclerAdapter);

        }
    }

    private String getSettlementAmount(Float total, Float discounted) {
        return getPriceWithSymbol(total-discounted);
    }

    private String getPriceWithSymbol(Float amount) {
        return "₹" + amount;
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOrderId;
        TextView tvOrderTime;
        TextView tvOutletName;
        TextView tvOutletArea;
        RecyclerView recyclerOrderItem;
        MaterialButton btnReject;
        MaterialButton btnAccept;
        LinearLayout lhAcceptRejectOrder;
        LinearLayout lhOutletSelector;
        LinearLayout lhShowOrderDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOrderId = itemView.findViewById(R.id.tvOrderId);
            tvOrderTime = itemView.findViewById(R.id.tvOrderTime);
            tvOutletName = itemView.findViewById(R.id.tvOutletName);
            tvOutletArea = itemView.findViewById(R.id.tvOutletArea);
            recyclerOrderItem = itemView.findViewById(R.id.recyclerOrderItem);
            btnReject = itemView.findViewById(R.id.btnReject);
            btnAccept = itemView.findViewById(R.id.btnAccept);
            lhAcceptRejectOrder = itemView.findViewById(R.id.lhAcceptRejectOrder);
            lhOutletSelector = itemView.findViewById(R.id.lhOutletSelector);
            lhShowOrderDetails = itemView.findViewById(R.id.lhShowOrderDetails);

        }
    }
}
