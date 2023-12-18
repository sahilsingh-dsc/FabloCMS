package com.myfablo.cms.module_outlet.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.myfablo.cms.R;
import com.myfablo.cms.module_outlet.OutletDetailsActivity;
import com.myfablo.cms.module_outlet.models.OutletItem;

import java.util.ArrayList;
import java.util.List;

public class OutletRecyclerAdapter extends RecyclerView.Adapter<OutletRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<OutletItem> outletItemList;

    public OutletRecyclerAdapter(Context context, List<OutletItem> outletItemList) {
        this.context = context;
        this.outletItemList = outletItemList;
    }

    @NonNull
    @Override
    public OutletRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_outlet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OutletRecyclerAdapter.ViewHolder holder, int position) {
        OutletItem outletItem = outletItemList.get(position);
        if (outletItem != null) {

            if (outletItem.getClosed() != null && outletItem.getClosed()) {
                holder.ivOutletImage.setBackground(context.getResources().getDrawable(R.drawable.ring_outlet_offline));
            } else {
                holder.ivOutletImage.setBackground(context.getResources().getDrawable(R.drawable.ring_outlet_online));
            }
            setTextSafe(holder.tvOutletName, outletItem.getOutletName());
            setTextSafe(holder.tvOutletArea, outletItem.getArea());

            List<String> outletImages = outletItem.getOutletImage();
            if (outletImages != null && !outletImages.isEmpty()) {
                Glide.with(context)
                        .load(outletImages.get(0))
                        .error(R.drawable.no_image) // Assuming you have a placeholder for errors
                        .into(holder.ivOutletImage);
            } else {
                holder.ivOutletImage.setImageResource(R.drawable.no_image); // Use a default image
            }

            holder.lvOutlet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, OutletDetailsActivity.class);
                    Gson gson = new Gson();
                    String outletStringJson = gson.toJson(outletItem);
                    intent.putExtra("outlet", outletStringJson);
                    context.startActivity(intent);
                }
            });

        }

    }

    private void setTextSafe(TextView textView, String text) {
        if (text != null) {
            textView.setText(text);
        } else {
            textView.setText("N/A"); // Set to a default "not available" text or keep it empty
        }
    }

    @Override
    public int getItemCount() {
        return outletItemList.size();
    }

    public void updateList(List<OutletItem> itemList){
        outletItemList = itemList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivOutletImage;
        TextView tvOutletName;
        TextView tvOutletArea;
        LinearLayout lvOutlet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivOutletImage = itemView.findViewById(R.id.ivOutletImage);
            tvOutletName = itemView.findViewById(R.id.tvOutletName);
            tvOutletArea = itemView.findViewById(R.id.tvOutletArea);
            lvOutlet = itemView.findViewById(R.id.lvOutlet);

        }
    }
}
