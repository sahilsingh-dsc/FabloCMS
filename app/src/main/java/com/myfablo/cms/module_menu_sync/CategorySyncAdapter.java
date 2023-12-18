package com.myfablo.cms.module_menu_sync;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.myfablo.cms.R;
import com.myfablo.cms.module_menu_sync.models.upload_swiggy.Menu;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class CategorySyncAdapter extends RecyclerView.Adapter<CategorySyncAdapter.ViewHolder> {

    private Context context;
    private List<Menu> menuList;

    private static final String TAG = "CategorySyncAdapter";

    public CategorySyncAdapter(Context context, List<Menu> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public CategorySyncAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_category_sync, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorySyncAdapter.ViewHolder holder, int position) {
        Menu menu = menuList.get(position);
        if (menu != null) {
            holder.tvCategoryName.setText(menu.getTitle());
            holder.btnSync.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventBus.getDefault().post(menu);
                    menuList.remove(menu);
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvCategoryName;
        MaterialButton btnSync;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoryName = itemView.findViewById(R.id.tvCategoryName);
            btnSync = itemView.findViewById(R.id.btnSync);
        }
    }
}
