package com.myfablo.cms.module_tickets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myfablo.cms.R;
import com.myfablo.cms.module_onboard.feature_ticket.OnboardTicket;

import java.util.List;

public class TicketRecyclerAdapter extends RecyclerView.Adapter<TicketRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<OnboardTicket> onboardTicketList;

    public TicketRecyclerAdapter(Context context, List<OnboardTicket> onboardTicketList) {
        this.context = context;
        this.onboardTicketList = onboardTicketList;
    }

    @NonNull
    @Override
    public TicketRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tickets, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketRecyclerAdapter.ViewHolder holder, int position) {
        OnboardTicket onboardTicket = onboardTicketList.get(position);
        if (onboardTicket != null) {
            holder.tvTicketId.setText(onboardTicket.getTicketId());
            holder.tvOutletName.setText(onboardTicket.getOutletName());
            holder.tvPhone.setText(onboardTicket.getPhone());
            holder.tvEmployeeId.setText(onboardTicket.getEmployeeId());
            holder.tvTicketStatus.setText(getCurrentPendingStatus(onboardTicket));

            holder.lhShowOrderDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TicketDetailsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("ticket", onboardTicket);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });

        }
    }

    public String getCurrentPendingStatus(OnboardTicket onboardTicket) {
        if (!onboardTicket.isSellerPan()) return "PAN Pending";
        if (!onboardTicket.isSellerDetails()) return "Details Pending";
        if (!onboardTicket.isOutletMapping()) return "Mapping Pending";
        if (!onboardTicket.isOutletFssai()) return "FSSAI Pending";
        if (!onboardTicket.isTaxPolicy()) return "GST Pending";
        if (!onboardTicket.isOutletMenu()) return "Menu Pending";
        if (!onboardTicket.isSellerTraining()) return "Training Pending";
        if (!onboardTicket.isOutletLive()) return "Going Live Pending";
        if (!onboardTicket.isOnboardStatus()) return "Onboarding Pending";
        return "Closed";
    }

    @Override
    public int getItemCount() {
        return onboardTicketList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout lhShowOrderDetails;
        TextView tvTicketId;
        TextView tvOutletName;
        TextView tvPhone;
        TextView tvTicketStatus;
        TextView tvEmployeeId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lhShowOrderDetails = itemView.findViewById(R.id.lhShowOrderDetails);
            tvTicketId = itemView.findViewById(R.id.tvTicketId);
            tvOutletName = itemView.findViewById(R.id.tvOutletName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvTicketStatus = itemView.findViewById(R.id.tvTicketStatus);
            tvEmployeeId = itemView.findViewById(R.id.tvEmployeeId);

        }
    }
}
