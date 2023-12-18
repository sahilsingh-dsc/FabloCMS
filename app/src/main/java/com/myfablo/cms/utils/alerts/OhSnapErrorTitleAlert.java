package com.myfablo.cms.utils.alerts;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.myfablo.cms.R;

public class OhSnapErrorTitleAlert {

    public static OhSnapErrorTitleAlert ohSnapErrorAlert = null;
    private Dialog mDialog;

    public static OhSnapErrorTitleAlert getInstance() {
        if (ohSnapErrorAlert == null) {
            ohSnapErrorAlert = new OhSnapErrorTitleAlert();
        }
        return ohSnapErrorAlert;
    }

    public void showAlert(Context context, String title, String notice) {
        mDialog = new Dialog(context);
        context.setTheme(R.style.Theme_FabloCMS);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_alert_oh_snap_title);
        MaterialButton btnDismiss = mDialog.findViewById(R.id.btnDismiss);
        TextView tvNotice = mDialog.findViewById(R.id.tvNotice);
        TextView tvErrorTitle = mDialog.findViewById(R.id.tvErrorTitle);

        tvNotice.setText(notice);
        tvErrorTitle.setText(title);

        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideAlert();
            }
        });

        mDialog.show();
    }

    public void hideAlert() {
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

}
