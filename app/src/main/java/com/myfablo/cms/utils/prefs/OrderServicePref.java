package com.myfablo.cms.utils.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.myfablo.cms.utils.Constant;

public class OrderServicePref {

    private Context context;

    public OrderServicePref(Context context) {
        this.context = context;
    }

    public void setServiceStatus(boolean status) {
        SharedPreferences preferences = context.getSharedPreferences(Constant.PREF_ORDER_SERVICE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("status", status);
        editor.apply();
    }

    public boolean getServiceStatus() {
        SharedPreferences preferences = context.getSharedPreferences(Constant.PREF_ORDER_SERVICE, Context.MODE_PRIVATE);
        return preferences.getBoolean("status", false);
    }

    public void clearData() {
        SharedPreferences preferences = context.getSharedPreferences(Constant.PREF_ORDER_SERVICE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

}
