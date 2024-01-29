package com.myfablo.cms.module_order.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.myfablo.cms.R;
import com.myfablo.cms.module_order.feature_get_order.models.response.Product;
import com.myfablo.cms.utils.ExtraUtils;

import java.util.List;

public class OrderItemRecyclerAdapter extends RecyclerView.Adapter<OrderItemRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Product> productList;

    public OrderItemRecyclerAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ordered_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        if (product != null) {
            holder.tvProductName.setText(product.getProductName());
            holder.tvProductQty.setText(getProductQty(product.getQuantity()));
            if (product.getIsVeg()) {
                holder.ivServingType.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_food_type_veg, null));
            } else {
                holder.ivServingType.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_food_type_non_veg, null));
            }
            if (product.getVariationName() != null && !product.getVariationName().isEmpty()) {
                if (!product.getAddOnName().isEmpty()) {
                    holder.tvCustomization.setText(new ExtraUtils(context).getCustomName(product.getVariationName(), product.getAddOnName()));
                } else {
                    holder.tvCustomization.setText(product.getVariationName());
                }
                holder.tvCustomization.setVisibility(View.VISIBLE);
            } else {
                holder.tvCustomization.setVisibility(View.GONE);
            }

        }
    }

    private String getProductQty(Integer qty) {
        return "x"+qty;
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivServingType;
        TextView tvProductName;
        TextView tvCustomization;
        TextView tvProductQty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivServingType = itemView.findViewById(R.id.ivServingType);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvCustomization = itemView.findViewById(R.id.tvCustomization);
            tvProductQty = itemView.findViewById(R.id.tvProductQty);
        }
    }
}
