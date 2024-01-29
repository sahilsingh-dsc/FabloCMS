package com.myfablo.cms.module_onboard.feature_ticket;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.myfablo.cms.databinding.BottomSheetOnboardTicketBinding;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.SoundAndVibrationPlayer;
import com.myfablo.cms.utils.alerts.FabLoading;
import com.myfablo.cms.utils.alerts.SuccessAlert;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;

import org.apache.commons.lang3.RandomStringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class OnboardTicketBottomSheet extends BottomSheetDialogFragment implements View.OnClickListener {

    private Context context;
    private BottomSheetOnboardTicketBinding binding;
    private FabLoading fabLoading;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BottomSheetOnboardTicketBinding.inflate(inflater);
        View view = binding.getRoot();
        if (getContext() != null) {
            context = getContext();
            initView();
        }
        return view;
    }

    private void initView() {
        fabLoading = FabLoading.getInstance();
        initTextWatcher();
        initClick();
    }

    private void initClick() {
        binding.btnCreateTicket.setOnClickListener(this);
    }

    private void initTextWatcher() {
        binding.etEmployeeId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.tiEmployeeId.setErrorEnabled(false);
            }
        });

        binding.etOutletName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.tiOutletName.setErrorEnabled(false);
            }
        });

        binding.etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.tiPhone.setErrorEnabled(false);
            }
        });
    }

    private void validateInput() {
        String employeeId = binding.etEmployeeId.getText().toString().trim();
        String outletName = binding.etOutletName.getText().toString().trim();
        String phone = binding.etPhone.getText().toString().trim();

        if (employeeId.isEmpty()) {
            binding.etEmployeeId.requestFocus();
            binding.tiEmployeeId.setErrorEnabled(true);
            binding.tiEmployeeId.setError("Please provide your Employee ID");
            return;
        }

        if (outletName.isEmpty()) {
            binding.etOutletName.requestFocus();
            binding.tiOutletName.setErrorEnabled(true);
            binding.tiOutletName.setError("Please provide Outlet Name");
            return;
        }

        if (phone.isEmpty()) {
            binding.etPhone.requestFocus();
            binding.tiPhone.setErrorEnabled(true);
            binding.tiPhone.setError("Please provide contact person phone");
            return;
        }

        if (!TextUtils.isDigitsOnly(phone) || phone.length() != 10) {
            binding.etPhone.requestFocus();
            binding.tiPhone.setErrorEnabled(true);
            binding.tiPhone.setError("Please provide valid 10 digit phone number");
            return;
        }

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = db.collection("ticket");

        String randonString = RandomStringUtils.randomAlphanumeric(8).toUpperCase();

        createTicket(
                new OnboardTicket(
                        randonString,
                        employeeId,
                        outletName,
                        phone,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false));
    }

    private void createTicket(OnboardTicket onboardTicket) {
        fabLoading.showProgress(context);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(Constant.COLLECTION_ONBOARD).document(onboardTicket.getTicketId())
                .set(onboardTicket)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            fabLoading.hideProgress();
                            SuccessAlert.getInstance().showAlert(context, "Ticket Created", "Your onboarding ticket has been created with ref no. "+onboardTicket.getTicketId(), true, "createTicket");
                        }
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String data) {
        if (data.equals("createTicket")) {
            dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == binding.btnCreateTicket) {
            validateInput();
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

}
