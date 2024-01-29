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
        return "Bearer eyJhbGciOiJQUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI0MjdjNTUzMiIsInJvbGVJZCI6Ijg0YWJiNmQ5Iiwicm9sZSI6Mywic3ViUm9sZSI6Nzc3LCJpYXQiOjE3MDU1OTAyOTYsImV4cCI6MTcwODE4MjI5Nn0.L9iYkliBhT-RVMnB0LSpb9bTmhrgOu0sUFKfw9xLf9jFb7k-wWkcJ3dpkunFgAtW3T0erhjNCw_8sBIytT-w3XlHT5FWy3J1BAYWQX3CZu1btspaBTsJ9eQMQRqHPX4I_Dii5sxLywROGDm_BMuGgOUQLC_VjT121GgAU2sKaTU3AsMXc31ulfBburFoBOsKCSD-l59Do29NthAxlKa4R9sbsyLORj85DIiisVriyRqAE_S10TPY_MiVC0igzg0WsFwcHLCBAVsp30TOuY3lvCWWp-Uf7YrdJTpq2VFZr7m8sGfXiHZ6CwDJlFgePO5a7ebTz9fMELSGSOFXTOtCpTI-aRdvVCPghuHG7wDDTsFgjD_YXS-ZGATKMsMml0p3SQRhImXRwqlJcngHUtCtF0kKoNi_q25cHjohOdurIZI8eqNV65sPZa2XZM6v2294CeXWlRScepewLjqiVs2tFzfAE-6YDM4b5VtlDZhepZda9zPx7yIsbxp4o3QryNMTtvwhtp9T-jw7QKzXo0eY5y2u9B_aiEvXvxbHTEmDAagvnxP1OoxTMuqIvv5RTvtd7GS5BtQik4enGuDOsf6bYN53KyvAOMocuTGI3NCmC-XigFM0dx_kqxqzsiNCivqWEou-muvXPAI6dORjPHqtjVwl1KWkP-AI2TscKuiPNp0";
    }

    public String getToken() {
        SharedPreferences preferences = context.getSharedPreferences(Constant.PREF_AUTH, Context.MODE_PRIVATE);
        return "eyJhbGciOiJQUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI0MjdjNTUzMiIsInJvbGVJZCI6Ijg0YWJiNmQ5Iiwicm9sZSI6Mywic3ViUm9sZSI6Nzc3LCJpYXQiOjE3MDI2NTIxNDksImV4cCI6MTcwNTI0NDE0OX0.MmL8nbJStUEVPhZaoXDCl-fUTEjIh68XtnpREh_sskgBNL_tnDNReQPp7k5dCbuXeHu2QzvuPLcuh4h3Qz1TK7DH6sGtuvTgAKRJr_P1l6k4HMvUzLCdJCQZWelOgGBopaOgH56mHJoiJ5SWgOU8XDGfA9erSbL-Le0HLPYEcEM_P6GQ2mIxb7kj7y8X6AsbT22lxQSJaDKadq_s0UERQ7DTPqtdCs1lqO4o2Uc2v3hCtAIgYFeA_o1D9bL2XGrDQFZltEOCH2vF7XD1UBH-s263_WHMQKGvZYa6plv-qXxuABYg-eh75g4zuv2vnrfLeLwD2V3p-9r5VAvgcyUdY82qDX3BGu7p61XYx8qvKdjc-YcQW47oQjN3bcnkCeong6d4Pfad-GfM2D-NclDusYrda5igJrzsY4MnzjuEz9ubVPzYvIcqFbYSoNjTei43VfKS-EFDIAA03SrWiAKnntwTJx3K6FKo3c_gkkdPcVYQtM4doT3wp3NAhN6HP3tjXXOEgBzbrp68oLvoWn3ftsucQY9bYMBhczVRoyG6kJABOlMpiG7inGNxTrp3OjwHxrIgVclbsQcIrtOahwFPC7JDLp8Zl_tih0-U1AlWfRhmGALI3NLcS49f5g4uGA2yDlf9knQwBHziAc2s6XZu2nlTiIaPP5TXbGgetaCrw1I";
    }

}
