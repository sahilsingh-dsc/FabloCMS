package com.myfablo.cms.utils.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.myfablo.cms.utils.Constant;

public class AuthPref {

    private Context context;

    public AuthPref(Context context) {
        this.context = context;
    }

    public void setToken(String token) {
        SharedPreferences preferences = context.getSharedPreferences(Constant.PREF_AUTH, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token", token);
        editor.apply();
    }

    public void setOutletId(String outletId) {
        SharedPreferences preferences = context.getSharedPreferences(Constant.PREF_OUTLET, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("outletId", outletId);
        editor.apply();
    }

    public String getOutletId() {
        SharedPreferences preferences = context.getSharedPreferences(Constant.PREF_OUTLET, Context.MODE_PRIVATE);
        return preferences.getString("outletId", "none");
    }


    public String getBearerToken() {
        SharedPreferences preferences = context.getSharedPreferences(Constant.PREF_AUTH, Context.MODE_PRIVATE);
        return "Bearer eyJhbGciOiJQUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI0MjdjNTUzMiIsInJvbGVJZCI6Ijg0YWJiNmQ5Iiwicm9sZSI6Mywic3ViUm9sZSI6Nzc3LCJpYXQiOjE3MDI2NTIxNDksImV4cCI6MTcwNTI0NDE0OX0.MmL8nbJStUEVPhZaoXDCl-fUTEjIh68XtnpREh_sskgBNL_tnDNReQPp7k5dCbuXeHu2QzvuPLcuh4h3Qz1TK7DH6sGtuvTgAKRJr_P1l6k4HMvUzLCdJCQZWelOgGBopaOgH56mHJoiJ5SWgOU8XDGfA9erSbL-Le0HLPYEcEM_P6GQ2mIxb7kj7y8X6AsbT22lxQSJaDKadq_s0UERQ7DTPqtdCs1lqO4o2Uc2v3hCtAIgYFeA_o1D9bL2XGrDQFZltEOCH2vF7XD1UBH-s263_WHMQKGvZYa6plv-qXxuABYg-eh75g4zuv2vnrfLeLwD2V3p-9r5VAvgcyUdY82qDX3BGu7p61XYx8qvKdjc-YcQW47oQjN3bcnkCeong6d4Pfad-GfM2D-NclDusYrda5igJrzsY4MnzjuEz9ubVPzYvIcqFbYSoNjTei43VfKS-EFDIAA03SrWiAKnntwTJx3K6FKo3c_gkkdPcVYQtM4doT3wp3NAhN6HP3tjXXOEgBzbrp68oLvoWn3ftsucQY9bYMBhczVRoyG6kJABOlMpiG7inGNxTrp3OjwHxrIgVclbsQcIrtOahwFPC7JDLp8Zl_tih0-U1AlWfRhmGALI3NLcS49f5g4uGA2yDlf9knQwBHziAc2s6XZu2nlTiIaPP5TXbGgetaCrw1I";
    }

    public String getToken() {
        SharedPreferences preferences = context.getSharedPreferences(Constant.PREF_AUTH, Context.MODE_PRIVATE);
        return "eyJhbGciOiJQUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI0MjdjNTUzMiIsInJvbGVJZCI6Ijg0YWJiNmQ5Iiwicm9sZSI6Mywic3ViUm9sZSI6Nzc3LCJpYXQiOjE3MDI2NTIxNDksImV4cCI6MTcwNTI0NDE0OX0.MmL8nbJStUEVPhZaoXDCl-fUTEjIh68XtnpREh_sskgBNL_tnDNReQPp7k5dCbuXeHu2QzvuPLcuh4h3Qz1TK7DH6sGtuvTgAKRJr_P1l6k4HMvUzLCdJCQZWelOgGBopaOgH56mHJoiJ5SWgOU8XDGfA9erSbL-Le0HLPYEcEM_P6GQ2mIxb7kj7y8X6AsbT22lxQSJaDKadq_s0UERQ7DTPqtdCs1lqO4o2Uc2v3hCtAIgYFeA_o1D9bL2XGrDQFZltEOCH2vF7XD1UBH-s263_WHMQKGvZYa6plv-qXxuABYg-eh75g4zuv2vnrfLeLwD2V3p-9r5VAvgcyUdY82qDX3BGu7p61XYx8qvKdjc-YcQW47oQjN3bcnkCeong6d4Pfad-GfM2D-NclDusYrda5igJrzsY4MnzjuEz9ubVPzYvIcqFbYSoNjTei43VfKS-EFDIAA03SrWiAKnntwTJx3K6FKo3c_gkkdPcVYQtM4doT3wp3NAhN6HP3tjXXOEgBzbrp68oLvoWn3ftsucQY9bYMBhczVRoyG6kJABOlMpiG7inGNxTrp3OjwHxrIgVclbsQcIrtOahwFPC7JDLp8Zl_tih0-U1AlWfRhmGALI3NLcS49f5g4uGA2yDlf9knQwBHziAc2s6XZu2nlTiIaPP5TXbGgetaCrw1I";
    }

}
