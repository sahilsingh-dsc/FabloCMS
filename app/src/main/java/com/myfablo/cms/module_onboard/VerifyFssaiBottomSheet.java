package com.myfablo.cms.module_onboard;

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
import com.google.firebase.firestore.FirebaseFirestore;
import com.myfablo.cms.databinding.BottomSheetFssaiVerifyBinding;
import com.myfablo.cms.module_digikyc.fssai.contracts.FssaiVerifyContract;
import com.myfablo.cms.module_digikyc.fssai.contracts.FssaiVerifyInterface;
import com.myfablo.cms.module_digikyc.fssai.models.FssaiDetails;
import com.myfablo.cms.module_digikyc.fssai.models.response.FssaiItems;
import com.myfablo.cms.module_digikyc.fssai.models.response.FssaiVerifyResponse;
import com.myfablo.cms.module_digikyc.pan.contracts.contract_pan_verfiy.PanVerifyContract;
import com.myfablo.cms.module_digikyc.pan.models.response.PanItems;
import com.myfablo.cms.module_digikyc.tax.TaxDetails;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.CustomInput;
import com.myfablo.cms.utils.alerts.FabLoading;
import com.myfablo.cms.utils.alerts.OhSnapErrorAlert;
import com.myfablo.cms.utils.alerts.SuccessAlert;

import org.apache.commons.lang3.RandomStringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class VerifyFssaiBottomSheet extends BottomSheetDialogFragment implements View.OnClickListener {

    private BottomSheetFssaiVerifyBinding binding;
    private Context context;
    private FssaiVerifyContract fssaiVerifyContract;
    private FabLoading fabLoading;
    private FssaiItems fssaiItemsData;
    private String ticketId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BottomSheetFssaiVerifyBinding.inflate(inflater);
        View view = binding.getRoot();

        if (getContext() != null) {
            context = getContext();
            initView();
        }

        return view;
    }

    private void initView() {
        fabLoading = FabLoading.getInstance();
        initClicks();
        getIntentData();
        initTextWatcher();
        initContracts();
    }

    private void initClicks() {
        binding.btnVerify.setOnClickListener(this);
    }

    private void getIntentData() {
        if (getArguments() != null) {
            ticketId = getArguments().getString("ticketId");
        }
    }


    private void initTextWatcher() {
        binding.etFssai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.tiFssai.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void initContracts() {
        fssaiVerifyContract = new FssaiVerifyContract(context, new FssaiVerifyInterface() {
            @Override
            public void onContractProgress() {
                fabLoading.showProgress(context);
            }

            @Override
            public void onContractResponse(FssaiVerifyResponse fssaiVerifyResponse) {
                fabLoading.hideProgress();
                fssaiItemsData = fssaiVerifyResponse.getItems();
                updateFssai();
            }

            @Override
            public void onContractNotFound() {
                fabLoading.hideProgress();
            }

            @Override
            public void onContractFailure() {
                fabLoading.hideProgress();
            }
        });
    }

    private void updateFssai() {
        String fssai = binding.etFssai.getText().toString();
        fabLoading.showProgress(context);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        String randonString = RandomStringUtils.randomAlphanumeric(10).toUpperCase();


        FssaiDetails fssaiDetails = new FssaiDetails();
        fssaiDetails.setLicenceId(randonString);
        fssaiDetails.setTicketId(ticketId);
        fssaiDetails.setLicenceNo(fssai);
        fssaiDetails.setSaveFssaiData(fssaiItemsData.getSaveData());


        db.collection(Constant.COLLECTION_ONBOARD)
                .document(ticketId)
                .collection("fssai")
                .document("data")
                .set(fssaiDetails)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            SuccessAlert.getInstance().showAlert(context, "FSSAI Verified", "FSSAI has been verified and updated.", true, "FssaiUpdate");
                        } else {
                            OhSnapErrorAlert.getInstance().showAlert(context, "Servers not responding, Something went wrong please try again later.");
                        }
                        fabLoading.hideProgress();
                    }
                });
    }

    private void validateInput() {
        String fssai = binding.etFssai.getText().toString().trim();
        if (fssai.isEmpty()) {
            binding.etFssai.requestFocus();
            binding.tiFssai.setErrorEnabled(true);
            binding.tiFssai.setError("FSSAI Reg. number is required.");
            return;
        }

        if (fssai.length() != 14) {
            binding.etFssai.requestFocus();
            binding.tiFssai.setErrorEnabled(true);
            binding.tiFssai.setError("Valid FSSAI Reg. number is required.");
            return;
        }

        if (!TextUtils.isDigitsOnly(fssai)) {
            binding.etFssai.requestFocus();
            binding.tiFssai.setErrorEnabled(true);
            binding.tiFssai.setError("Valid FSSAI Reg. number is required.");
            return;
        }

        binding.etFssai.setEnabled(false);

        fssaiVerifyContract.verifyFssai(fssai);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String data) {
        if (data.equals("FssaiUpdate")) {
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
        if (v == binding.btnVerify) {
            validateInput();
        }
    }
}
