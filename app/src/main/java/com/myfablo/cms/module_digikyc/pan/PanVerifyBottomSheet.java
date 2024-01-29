package com.myfablo.cms.module_digikyc.pan;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.firestore.FirebaseFirestore;
import com.myfablo.cms.databinding.BottomSheetPanVerifyBinding;
import com.myfablo.cms.module_digikyc.pan.contracts.contract_pan_verfiy.PanVerifyContract;
import com.myfablo.cms.module_digikyc.pan.contracts.contract_pan_verfiy.PanVerifyInterface;
import com.myfablo.cms.module_digikyc.pan.models.response.PanItems;
import com.myfablo.cms.module_digikyc.pan.models.response.PanVerifyResponse;
import com.myfablo.cms.module_onboard.models.seller.SellerPan;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.CustomInput;
import com.myfablo.cms.utils.alerts.FabLoading;
import com.myfablo.cms.utils.alerts.OhSnapErrorAlert;
import com.myfablo.cms.utils.alerts.SuccessAlert;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PanVerifyBottomSheet extends BottomSheetDialogFragment implements View.OnClickListener {

    private BottomSheetPanVerifyBinding binding;
    private Context context;

    private PanVerifyContract panVerifyContract;
    private FabLoading fabLoading;
    private PanItems panItemsResponse;
    private String ticketId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BottomSheetPanVerifyBinding.inflate(inflater);
        View view = binding.getRoot();
        if (getContext() != null) {
            context = getContext();
            initView();
        }
        return view;
    }

    private void initView() {
        hideResponseScreen();
        fabLoading = FabLoading.getInstance();
        initClicks();
        getIntentData();
        initTextWatcher();
        initContracts();
    }

    private void initClicks() {
        binding.btnVerifyPan.setOnClickListener(this);
        binding.btnUpdatePan.setOnClickListener(this);
    }

    private void getIntentData() {
        if (getArguments() != null) {
            ticketId = getArguments().getString("ticketId");
        }
    }

    private void initTextWatcher() {
        CustomInput.enforceFormat(binding.etPan);
        binding.etPan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.tiPan.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void initContracts() {
        panVerifyContract = new PanVerifyContract(context, new PanVerifyInterface() {
            @Override
            public void onContractProgress() {
                fabLoading.showProgress(context);
            }

            @Override
            public void onContractResponse(PanVerifyResponse panVerifyResponse) {
                fabLoading.hideProgress();
                panItemsResponse = panVerifyResponse.getItems();
            }

            @Override
            public void onContractNotFound() {
                hideResponseScreen();
                fabLoading.hideProgress();
                OhSnapErrorAlert.getInstance().showAlert(context, "PAN number provided does not match with ITD records, Please verify your PAN number.");
            }

            @Override
            public void onContractFailure() {
                hideResponseScreen();
                fabLoading.hideProgress();
                OhSnapErrorAlert.getInstance().showAlert(context, "ITD Servers not responding, Something went wrong please try again later.");
            }
        });
    }

    private void validateInput() {
        String pan = binding.etPan.getText().toString().trim();
        if (pan.isEmpty()) {
            binding.tiPan.setErrorEnabled(true);
            binding.tiPan.setError("PAN card number is required.");
            return;
        }

        if (pan.length() != 10) {
            binding.tiPan.setErrorEnabled(true);
            binding.tiPan.setError("Invalid PAN card number.");
            return;
        }

        if (!validatePanNumber(pan)) {
            binding.tiPan.setErrorEnabled(true);
            binding.tiPan.setError("Invalid PAN card number.");
            return;
        }

        binding.etPan.setEnabled(false);

        updatePan();
    }

    private boolean validatePanNumber(String pan) {
        Pattern pattern = Pattern.compile("[A-Z]{3}[ABCFGHLJPTF]{1}[A-Z]{1}[0-9]{4}[A-Z]{1}");
        Matcher matcher = pattern.matcher(pan);
        return matcher.matches();
    }

    private void showPanResponse(PanItems items) {

        binding.tvNameOnPan.setText(items.getSaveData().getName());
        binding.tvTypeOfPan.setText(items.getSaveData().getCategory());
        binding.tvAadhaarPanLink.setText(items.getSaveData().getAadhaarLinked()? "LINKED" : "NOT LINKED");
        binding.tvStatusOfPan.setText(items.getSaveData().getValid()? "VALID" : "INVALID");

        showResponseScreen();
    }

    private void showResponseScreen() {
        binding.lvCheckPan.setVisibility(View.GONE);
        binding.lvPanResponse.setVisibility(View.VISIBLE);
        binding.etPan.setEnabled(false);
    }

    private void hideResponseScreen() {
        binding.lvCheckPan.setVisibility(View.VISIBLE);
        binding.lvPanResponse.setVisibility(View.GONE);
        binding.etPan.setEnabled(true);
    }

    private void updatePan() {
        fabLoading.showProgress(context);
        String pan = binding.etPan.getText().toString().trim();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        SellerPan sellerPan = new SellerPan();

        sellerPan.setPan(pan);

        db.collection(Constant.COLLECTION_ONBOARD)
                .document(ticketId)
                .collection("pan")
                .document("data")
                .set(sellerPan)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            SuccessAlert.getInstance().showAlert(context, "PAN Updated", "Seller account has been create using pan record.", true, "PanUpdate");
                        } else {
                            OhSnapErrorAlert.getInstance().showAlert(context, "Servers not responding, Something went wrong please try again later.");
                        }
                        fabLoading.hideProgress();
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String data) {
        if (data.equals("PanUpdate")) {
            dismiss();
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
        if (v == binding.btnVerifyPan) {
            validateInput();
        } else if (v == binding.btnUpdatePan) {
            updatePan();
        }
    }
}
