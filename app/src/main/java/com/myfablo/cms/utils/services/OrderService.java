package com.myfablo.cms.utils.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.myfablo.cms.MainActivity;
import com.myfablo.cms.R;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.pubnub.OrderSubscriber;
import com.pubnub.api.PubNubException;

public class OrderService extends Service {

    private OrderSubscriber orderSubscriber;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        orderSubscriber = new OrderSubscriber(getApplicationContext());
        try {
            orderSubscriber.initPubNubConfig();
        } catch (PubNubException e) {
            e.printStackTrace();
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(Constant.NOTIFICATION_CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String status = intent.getStringExtra("status");
            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,
                    0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);

            Notification notification = new NotificationCompat.Builder(this, Constant.NOTIFICATION_CHANNEL_ID)
                    .setContentTitle("Looking for orders")
                    .setContentText("You will receive notification for new orders")
                    .setSmallIcon(R.drawable.baseline_app_registration_24)
                    .setContentIntent(pendingIntent)
                    .build();

            if ("start".equals(status)) {
                startForeground(1, notification);
                orderSubscriber.subscribeOrder();
            } else if ("stop".equals(status)) {
                if (orderSubscriber != null) {
                    orderSubscriber.unSubscribeOrder();
                }
                stopForeground(true);
                stopSelf();
            }
        }

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (orderSubscriber != null) {
            orderSubscriber.unSubscribeOrder();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
