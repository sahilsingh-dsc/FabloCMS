package com.myfablo.cms.module_seller;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.myfablo.cms.databinding.BottomSheetOnboardTicketBinding;
import com.myfablo.cms.databinding.BottomSheetSellerDetailsBinding;
import com.myfablo.cms.module_onboard.feature_ticket.OnboardTicket;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.alerts.FabLoading;
import com.myfablo.cms.utils.alerts.SuccessAlert;

import org.apache.commons.lang3.RandomStringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SellerDetailsBottomSheet extends BottomSheetDialogFragment implements View.OnClickListener {

    private Context context;
    private BottomSheetSellerDetailsBinding binding;
    private FabLoading fabLoading;

    private String ticketId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BottomSheetSellerDetailsBinding.inflate(inflater);
        View view = binding.getRoot();
        if (getContext() != null) {
            context = getContext();
            initView();
        }
        return view;
    }

    private void initView() {
        fabLoading = FabLoading.getInstance();
        getArgumentData();
        initTextWatcher();
        initClick();
    }

    private void getArgumentData() {
        if (getArguments() != null) {
            ticketId = getArguments().getString("ticketId");
        }
    }

    private void initClick() {
        binding.btnSubmit.setOnClickListener(this);
    }

    private void initTextWatcher() {
        binding.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.tiName.setErrorEnabled(false);
            }
        });

        binding.etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.tiEmail.setErrorEnabled(false);
            }
        });

        binding.etMobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.tiMobileNumber.setErrorEnabled(false);
            }
        });

        binding.etSellerWhatsapp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.tiSellerWhatsapp.setErrorEnabled(false);
            }
        });
    }

    private void validateInput() {
        String name = binding.etName.getText().toString().trim();
        String email = binding.etEmail.getText().toString().trim();
        String mobile = binding.etMobileNumber.getText().toString().trim();
        String whatsapp = binding.etSellerWhatsapp.getText().toString().trim();

        if (name.isEmpty()) {
            binding.etName.requestFocus();
            binding.tiName.setErrorEnabled(true);
            binding.tiName.setError("Please provide seller name");
            return;
        }

        if (email.isEmpty()) {
            binding.etEmail.requestFocus();
            binding.tiEmail.setErrorEnabled(true);
            binding.tiEmail.setError("Please provide seller email");
            return;
        }

        if (mobile.isEmpty()) {
            binding.etMobileNumber.requestFocus();
            binding.tiMobileNumber.setErrorEnabled(true);
            binding.tiMobileNumber.setError("Please provide seller mobile number");
            return;
        }

        if (!TextUtils.isDigitsOnly(mobile) || mobile.length() != 10) {
            binding.etMobileNumber.requestFocus();
            binding.tiMobileNumber.setErrorEnabled(true);
            binding.tiMobileNumber.setError("Please provide valid 10 digit mobile number");
            return;
        }

        if (whatsapp.isEmpty()) {
            binding.etSellerWhatsapp.requestFocus();
            binding.tiSellerWhatsapp.setErrorEnabled(true);
            binding.tiSellerWhatsapp.setError("Please provide seller whatsapp number");
            return;
        }

        if (!TextUtils.isDigitsOnly(whatsapp) || whatsapp.length() != 10) {
            binding.etSellerWhatsapp.requestFocus();
            binding.tiSellerWhatsapp.setErrorEnabled(true);
            binding.tiSellerWhatsapp.setError("Please provide valid 10 digit whatsapp number");
            return;
        }
        String randonString = RandomStringUtils.randomAlphanumeric(8).toUpperCase();

        submitSellerDetails(
                new SellerDetails(
                        randonString,
                        ticketId,
                        name,
                        email,
                        mobile,
                        whatsapp
                        ));
    }

    private void submitSellerDetails(SellerDetails sellerDetails) {
        fabLoading.showProgress(context);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection(Constant.COLLECTION_ONBOARD).document(sellerDetails.getTicketId()).collection("details").document("data")
                .set(sellerDetails)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            fabLoading.hideProgress();
                            SuccessAlert.getInstance().showAlert(context, "Details Submitted", "Seller details has been updated.", true, "sellerDetails");
                        }
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String data) {
        if (data.equals("sellerDetails")) {
            dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == binding.btnSubmit) {
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
