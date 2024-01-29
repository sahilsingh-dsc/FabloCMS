package com.myfablo.cms.module_digikyc.tax;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.firebase.firestore.FirebaseFirestore;
import com.myfablo.cms.databinding.BottomSheetTaxBinding;
import com.myfablo.cms.module_digikyc.gst.contracts.contract_gst_verify.GstVerifyContract;
import com.myfablo.cms.module_digikyc.gst.contracts.contract_gst_verify.GstVerifyInterface;
import com.myfablo.cms.module_digikyc.gst.models.response.GstVerifyResponse;
import com.myfablo.cms.module_digikyc.gst.models.response.SaveGstData;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.alerts.FabLoading;
import com.myfablo.cms.utils.alerts.OhSnapErrorAlert;
import com.myfablo.cms.utils.alerts.SuccessAlert;

import org.apache.commons.lang3.RandomStringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxBottomSheet extends BottomSheetDialogFragment implements View.OnClickListener {

    private BottomSheetTaxBinding binding;
    private Context context;
    private GstVerifyContract gstVerifyContract;
    private FabLoading fabLoading;
    private String ticketId;

    private boolean gstStatus = true;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BottomSheetTaxBinding.inflate(inflater);
        View view = binding.getRoot();
        if (getContext() != null) {
            context = getContext();
            initView();
        }
        return view;
    }

    private void initView() {
        fabLoading = FabLoading.getInstance();
        getIntentData();
        initGstCategory();
        initClicks();
        initContracts();
    }

    private void initClicks() {
        binding.btnVerifyGst.setOnClickListener(this);
        binding.checkBoxGst.addOnCheckedStateChangedListener(new MaterialCheckBox.OnCheckedStateChangedListener() {
            @Override
            public void onCheckedStateChangedListener(@NonNull MaterialCheckBox checkBox, int state) {
                if (state == 1) {
                    gstStatus = false;
                    binding.tiGst.setVisibility(View.GONE);
                    binding.tiGstCategory.setVisibility(View.GONE);
                } else {
                    gstStatus = true;
                    binding.tiGst.setVisibility(View.VISIBLE);
                    binding.tiGstCategory.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void getIntentData() {
        if (getArguments() != null) {
            ticketId = getArguments().getString("ticketId");
        }
    }

    private void initContracts() {
        gstVerifyContract = new GstVerifyContract(context, new GstVerifyInterface() {
            @Override
            public void onContractProgress() {
                fabLoading.showProgress(context);
            }

            @Override
            public void onContractResponse(GstVerifyResponse gstVerifyResponse) {
                fabLoading.hideProgress();
                updateGst(gstVerifyResponse.getItems().getSaveData());
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

    private void initGstCategory() {
        String[] gstCategoryItems = {"Category 1 - Cooked", "Category 2 - Packed", "Category 3 - Mixed"};
        ArrayAdapter<String> gstCategoryAdapter = new ArrayAdapter<>(context, com.onesignal.R.layout.support_simple_spinner_dropdown_item, gstCategoryItems);
        binding.atvGstCategory.setAdapter(gstCategoryAdapter);
    }

    private int getGstCategory() {
        String category = binding.atvGstCategory.getText().toString();
        switch (category) {
            case "Category 1 - Cooked":
                return 1;
            case "Category 2 - Packed":
                return 2;
            case "Category 3 - Mixed":
                return 3;
            default:
                return 0;
        }
    }

    private void updateGst(SaveGstData saveData) {
        String gst = binding.etGst.getText().toString();
        fabLoading.showProgress(context);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        String randonString = RandomStringUtils.randomAlphanumeric(10).toUpperCase();

        TaxDetails taxDetails = new TaxDetails();
        taxDetails.setTaxId(randonString);
        taxDetails.setTicketId(ticketId);
        taxDetails.setGstStatus(gstStatus);
        taxDetails.setGstNumber(gst);
        taxDetails.setGstCategory(getGstCategory());
        taxDetails.setGstData(saveData);


        db.collection(Constant.COLLECTION_ONBOARD)
                .document(ticketId)
                .collection("gst")
                .document("data")
                .set(taxDetails)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            SuccessAlert.getInstance().showAlert(context, "GST Verified", "GST has been verified and tax details are updated.", true, "TaxUpdate");
                        } else {
                            OhSnapErrorAlert.getInstance().showAlert(context, "Servers not responding, Something went wrong please try again later.");
                        }
                        fabLoading.hideProgress();
                    }
                });
    }

    private void validateInput() {
        String gst = binding.etGst.getText().toString().trim();
        if (gst.isEmpty()) {
            binding.etGst.requestFocus();
            binding.tiGst.setErrorEnabled(true);
            binding.tiGst.setError("GST number is required.");
            return;
        }

        if (gst.length() != 15) {
            binding.etGst.requestFocus();
            binding.tiGst.setErrorEnabled(true);
            binding.tiGst.setError("Invalid GST number.");
            return;
        }

        if (!isValidGSTNo(gst)) {
            binding.etGst.requestFocus();
            binding.tiGst.setErrorEnabled(true);
            binding.tiGst.setError("Invalid GST number.");
            return;
        }

        binding.etGst.setEnabled(false);

        gstVerifyContract.verifyGst(gst);
    }

    private boolean isValidGSTNo(String str) {
        String regex = "^[0-9]{2}[A-Z]{5}[0-9]{4}" + "[A-Z]{1}[1-9A-Z]{1}" + "Z[0-9A-Z]{1}$";
        Pattern patternRegex = Pattern.compile(regex);
        if (str == null) {
            return false;
        }
        Matcher m = patternRegex.matcher(str);
        return m.matches();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String data) {
        if (data.equals("TaxUpdate")) {
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
        if (v == binding.btnVerifyGst) {
            if (gstStatus) {
                validateInput();
            } else {
                updateGst(new SaveGstData());
            }

        }
    }
}
