package com.myfablo.cms.module_tickets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.myfablo.cms.R;
import com.myfablo.cms.databinding.ActivityTicketDetailsBinding;
import com.myfablo.cms.module_digikyc.pan.PanVerifyActivity;
import com.myfablo.cms.module_digikyc.pan.PanVerifyBottomSheet;
import com.myfablo.cms.module_digikyc.tax.TaxBottomSheet;
import com.myfablo.cms.module_onboard.VerifyFssaiBottomSheet;
import com.myfablo.cms.module_onboard.feature_ticket.OnboardTicket;
import com.myfablo.cms.module_seller.SellerDetailsBottomSheet;
import com.myfablo.cms.utils.alerts.FabLoading;

public class TicketDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityTicketDetailsBinding binding;
    private Context context;
    private FabLoading fabLoading;
    private OnboardTicket onboardTicket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTicketDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = TicketDetailsActivity.this;
        initView();
    }

    private void initView() {
        fabLoading = FabLoading.getInstance();
        initClick();
        getIntentData();
    }

    private void getIntentData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            onboardTicket = bundle.getParcelable("ticket");
        }
        showTicketDetails();
    }

    private void showTicketDetails() {
        binding.tvTicketId.setText(onboardTicket.getTicketId());
        binding.tvOutletName.setText(onboardTicket.getOutletName());
        binding.tvPhone.setText(onboardTicket.getPhone());
        binding.tvEmployeeId.setText(onboardTicket.getEmployeeId());
        binding.tvTicketStatus.setText(getCurrentPendingStatus(onboardTicket));
    }

    public String getCurrentPendingStatus(OnboardTicket onboardTicket) {
        manageUi(onboardTicket);
        if (!onboardTicket.isSellerPan()) return "PAN Pending";
        if (!onboardTicket.isSellerDetails()) return "Details Pending";
        if (!onboardTicket.isOutletMapping()) return "Mapping Pending";
        if (!onboardTicket.isOutletFssai()) return "FSSAI Pending";
        if (!onboardTicket.isTaxPolicy()) return "GST Pending";
        if (!onboardTicket.isOutletMenu()) return "Menu Pending";
        if (!onboardTicket.isSellerTraining()) return "Training Pending";
        if (!onboardTicket.isOutletLive()) return "Going Live Pending";
        if (!onboardTicket.isOnboardStatus()) return "Onboarding Pending";
        return "Closed";
    }

    private void manageUi(OnboardTicket onboardTicket) {
        uiPan(onboardTicket.isSellerPan());
        uiSellerDetail(onboardTicket.isSellerDetails());
        uiTaxPolicy(onboardTicket.isTaxPolicy());
        uiFssaiDetails(onboardTicket.isOutletFssai());
        uiOutletMapping(onboardTicket.isOutletMapping());
        uiOutletMenu(onboardTicket.isOutletMenu());
        uiOutletTraining(onboardTicket.isSellerTraining());
        uiLive(onboardTicket.isOutletLive());
    }

    private void uiPan(boolean status) {
        if (status) {
            binding.ivStatusPan.setImageDrawable(getResources().getDrawable(R.drawable.baseline_check_circle_24));
            binding.btnPanVerify.setEnabled(false);
            binding.btnPanVerify.setVisibility(View.INVISIBLE);
        } else {
            binding.ivStatusPan.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_kyc_state_pending));
            binding.btnPanVerify.setEnabled(true);
            binding.btnPanVerify.setVisibility(View.VISIBLE);
        }
    }

    private void uiSellerDetail(boolean status) {
        if (status) {
            binding.ivStatusSellerDetails.setImageDrawable(getResources().getDrawable(R.drawable.baseline_check_circle_24));
            binding.btnSellerDetails.setEnabled(false);
            binding.btnSellerDetails.setVisibility(View.INVISIBLE);
        } else {
            binding.ivStatusSellerDetails.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_kyc_state_pending));
            binding.btnSellerDetails.setEnabled(true);
            binding.btnSellerDetails.setVisibility(View.VISIBLE);
        }
    }

    private void uiTaxPolicy(boolean status) {
        if (status) {
            binding.ivStatusTax.setImageDrawable(getResources().getDrawable(R.drawable.baseline_check_circle_24));
            binding.btnTaxDetails.setEnabled(false);
            binding.btnTaxDetails.setVisibility(View.INVISIBLE);
        } else {
            binding.ivStatusTax.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_kyc_state_pending));
            binding.btnTaxDetails.setEnabled(true);
            binding.btnTaxDetails.setVisibility(View.VISIBLE);
        }
    }

    private void uiFssaiDetails(boolean status) {
        if (status) {
            binding.ivStatusLicence.setImageDrawable(getResources().getDrawable(R.drawable.baseline_check_circle_24));
            binding.btnVerifyFssai.setEnabled(false);
            binding.btnVerifyFssai.setVisibility(View.INVISIBLE);
        } else {
            binding.ivStatusLicence.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_kyc_state_pending));
            binding.btnVerifyFssai.setEnabled(true);
            binding.btnVerifyFssai.setVisibility(View.VISIBLE);
        }
    }

    private void uiOutletMapping(boolean status) {
        if (status) {
            binding.ivStatusMapping.setImageDrawable(getResources().getDrawable(R.drawable.baseline_check_circle_24));
        } else {
            binding.ivStatusMapping.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_kyc_state_pending));
        }
    }

    private void uiOutletMenu(boolean status) {
        if (status) {
            binding.ivStatusMenu.setImageDrawable(getResources().getDrawable(R.drawable.baseline_check_circle_24));
        } else {
            binding.ivStatusMenu.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_kyc_state_pending));
        }
    }

    private void uiOutletTraining(boolean status) {
        if (status) {
            binding.ivStatusTraining.setImageDrawable(getResources().getDrawable(R.drawable.baseline_check_circle_24));
        } else {
            binding.ivStatusTraining.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_kyc_state_pending));
        }
    }

    private void uiLive(boolean status) {
        if (status) {
            binding.ivStatusLive.setImageDrawable(getResources().getDrawable(R.drawable.baseline_check_circle_24));
        } else {
            binding.ivStatusLive.setImageDrawable(getResources().getDrawable(R.drawable.ic_fab_kyc_state_pending));
        }
    }

    private void initClick() {
        binding.btnPanVerify.setOnClickListener(this);
        binding.btnSellerDetails.setOnClickListener(this);
        binding.btnTaxDetails.setOnClickListener(this);
        binding.btnVerifyFssai.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == binding.btnPanVerify) {
            Bundle bundle = new Bundle();
            bundle.putString("ticketId", onboardTicket.getTicketId());
            PanVerifyBottomSheet panVerifyBottomSheet = new PanVerifyBottomSheet();
            panVerifyBottomSheet.setArguments(bundle);
            panVerifyBottomSheet.show(getSupportFragmentManager(), "PanVerify");
        } else if (v == binding.btnSellerDetails) {
            Bundle bundle = new Bundle();
            bundle.putString("ticketId", onboardTicket.getTicketId());
            SellerDetailsBottomSheet sellerDetailsBottomSheet = new SellerDetailsBottomSheet();
            sellerDetailsBottomSheet.setArguments(bundle);
            sellerDetailsBottomSheet.show(getSupportFragmentManager(), "sellerDetails");
        } else if (v == binding.btnTaxDetails) {
            Bundle bundle = new Bundle();
            bundle.putString("ticketId", onboardTicket.getTicketId());
            TaxBottomSheet taxBottomSheet = new TaxBottomSheet();
            taxBottomSheet.setArguments(bundle);
            taxBottomSheet.show(getSupportFragmentManager(), "taxDetails");
        } else if (v == binding.btnVerifyFssai) {
            Bundle bundle = new Bundle();
            bundle.putString("ticketId", onboardTicket.getTicketId());
            VerifyFssaiBottomSheet verifyFssaiBottomSheet = new VerifyFssaiBottomSheet();
            verifyFssaiBottomSheet.setArguments(bundle);
            verifyFssaiBottomSheet.show(getSupportFragmentManager(), "fssaiDetails");
        }
    }
}