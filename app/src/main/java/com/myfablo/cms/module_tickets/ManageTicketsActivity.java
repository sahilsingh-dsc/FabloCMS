package com.myfablo.cms.module_tickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.myfablo.cms.databinding.ActivityManageTicketsBinding;
import com.myfablo.cms.module_onboard.feature_ticket.OnboardTicket;
import com.myfablo.cms.module_onboard.feature_ticket.OnboardTicketBottomSheet;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.alerts.FabLoading;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class ManageTicketsActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityManageTicketsBinding binding;
    private Context context;
    private FabLoading fabLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityManageTicketsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = ManageTicketsActivity.this;
        initView();
    }

    private void initView() {
        fabLoading = FabLoading.getInstance();
        initClicks();
        initRecycler();
        getTickets();
    }

    private void initClicks() {
        binding.ivGoBack.setOnClickListener(this);
        binding.btnContinue.setOnClickListener(this);
    }

    private void initRecycler() {
        binding.recyclerTicket.setLayoutManager(new LinearLayoutManager(context));
    }

    private void getTickets() {
        fabLoading.showProgress(context);
        List<OnboardTicket> onboardTicketList = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(Constant.COLLECTION_ONBOARD)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult() != null) {
                                onboardTicketList.clear();
                                for (DocumentSnapshot snapshot : task.getResult().getDocuments()) {
                                    OnboardTicket onboardTicket = snapshot.toObject(OnboardTicket.class);
                                    if (onboardTicket != null) {
                                        onboardTicketList.add(onboardTicket);
                                    }
                                }
                                showTickets(onboardTicketList);
                            }
                        }

                        fabLoading.hideProgress();
                    }
                });
    }

    private void showTickets(List<OnboardTicket> onboardTicketList) {
        TicketRecyclerAdapter ticketRecyclerAdapter = new TicketRecyclerAdapter(context, onboardTicketList);
        binding.recyclerTicket.setAdapter(ticketRecyclerAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String data) {
        if (data.equals("createTicket")) {
            getTickets();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        if (v == binding.ivGoBack) {
            onBackPressed();
        } else if (v == binding.btnContinue) {
            OnboardTicketBottomSheet onboardTicketBottomSheet = new OnboardTicketBottomSheet();
            onboardTicketBottomSheet.show(getSupportFragmentManager(), "ticket");
        }
    }
}