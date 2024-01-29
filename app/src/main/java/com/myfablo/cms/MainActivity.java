package com.myfablo.cms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Toast;

import com.myfablo.cms.databinding.ActivityMainBinding;
import com.myfablo.cms.module_onboard.OnboardActivity;
import com.myfablo.cms.module_onboard.feature_ticket.OnboardTicketBottomSheet;
import com.myfablo.cms.module_order.OrderActivity;
import com.myfablo.cms.module_outlet.OutletActivity;
import com.myfablo.cms.module_outlet.adapters.OutletRecyclerAdapter;
import com.myfablo.cms.module_outlet.contracts.contract_get_all_outlets.GetAllOutletContract;
import com.myfablo.cms.module_outlet.contracts.contract_get_all_outlets.GetAllOutletInterface;
import com.myfablo.cms.module_outlet.models.OutletItem;
import com.myfablo.cms.module_outlet.models.OutletResponse;
import com.myfablo.cms.module_tickets.ManageTicketsActivity;
import com.myfablo.cms.utils.SoundAndVibrationPlayer;
import com.myfablo.cms.utils.alerts.OrderNotificationAlert;
import com.myfablo.cms.utils.prefs.OrderServicePref;
import com.myfablo.cms.utils.services.OrderService;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.suke.widget.SwitchButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setTransparentStatusBar();
        View view = binding.getRoot();
        setContentView(view);
        context = MainActivity.this;
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
        initService();
        initClick();
    }

    private void initClick() {
        binding.lvOrders.setOnClickListener(this);
        binding.lvOutlets.setOnClickListener(this);
        binding.lvTickets.setOnClickListener(this);
    }

    private void initService() {
        if (!isMyServiceRunning(OrderService.class)) {
            startOrderService();
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }


    private void startOrderService() {
        Intent serviceIntent = new Intent(context, OrderService.class);
        serviceIntent.putExtra("status", "start");
        ContextCompat.startForegroundService(context, serviceIntent);
    }

    private void stopOrderService() {
        Intent serviceIntent = new Intent(context, OrderService.class);
        serviceIntent.putExtra("status", "stop");
        ContextCompat.startForegroundService(context, serviceIntent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PNMessageResult messageResult) {
        if (messageResult != null) {
            SoundAndVibrationPlayer soundAndVibrationPlayer = new SoundAndVibrationPlayer(context);
            soundAndVibrationPlayer.playSoundWithPulseVibration();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v == binding.lvOrders) {
            Intent intent = new Intent(context, OrderActivity.class);
            startActivity(intent);
        } else if (v == binding.lvOutlets) {
            Intent intent = new Intent(context, OutletActivity.class);
            startActivity(intent);
        } else if (v == binding.lvTickets) {
            Intent intent = new Intent(context, ManageTicketsActivity.class);
            startActivity(intent);
        }
    }
}