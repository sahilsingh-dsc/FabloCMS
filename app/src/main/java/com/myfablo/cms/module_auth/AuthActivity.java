package com.myfablo.cms.module_auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ArrayAdapter;

import com.myfablo.cms.MainActivity;
import com.myfablo.cms.databinding.ActivityAuthBinding;
import com.myfablo.cms.module_auth.contracts.contract_generate_token.GenerateTokenContract;
import com.myfablo.cms.module_auth.contracts.contract_generate_token.GenerateTokenInterface;
import com.myfablo.cms.module_auth.models.auth.request.AuthRequest;
import com.myfablo.cms.module_auth.models.auth.response.AuthResponse;
import com.myfablo.cms.utils.alerts.FabLoading;
import com.myfablo.cms.utils.alerts.OhSnapErrorAlert;
import com.myfablo.cms.utils.alerts.OhSnapErrorTitleAlert;
import com.myfablo.cms.utils.alerts.SuccessAlert;
import com.myfablo.cms.utils.prefs.AuthPref;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private ActivityAuthBinding binding;
    private GenerateTokenContract generateTokenContract;
    private FabLoading fabLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setTransparentStatusBar();
        View view = binding.getRoot();
        setContentView(view);
        context = AuthActivity.this;
        initView();
    }

    private void setTransparentStatusBar() {
        View decorView = getWindow().getDecorView();
        decorView.setOnApplyWindowInsetsListener((v, insets) -> {
            WindowInsets defaultInsets = v.onApplyWindowInsets(insets);
            return defaultInsets.replaceSystemWindowInsets(
                    defaultInsets.getSystemWindowInsetLeft(),
                    0,
                    defaultInsets.getSystemWindowInsetRight(),
                    defaultInsets.getSystemWindowInsetBottom());
        });
        ViewCompat.requestApplyInsets(decorView);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));
    }

    private void initView() {
        fabLoading = FabLoading.getInstance();
        initLoginType();
        initClick();
        initTextWatcher();
        initContracts();
    }

    private void initLoginType() {
        String[] loginTypeItems = {"Admin", "Marketing", "Operations"};
        ArrayAdapter<String> loginTypeAdapter = new ArrayAdapter<>(context, com.onesignal.R.layout.support_simple_spinner_dropdown_item, loginTypeItems);
        binding.atvLoginType.setAdapter(loginTypeAdapter);
    }

    private void initClick() {
        binding.btnLogin.setOnClickListener(this);
    }

    private void initTextWatcher() {
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

        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.tiPassword.setErrorEnabled(false);
            }
        });
    }

    private void initContracts() {
        generateTokenContract = new GenerateTokenContract(context, new GenerateTokenInterface() {
            @Override
            public void onContractProgress() {
                fabLoading.showProgress(context);
            }

            @Override
            public void onContractResponse(AuthResponse authResponse) {
                fabLoading.hideProgress();
//                if (authResponse.getStatus()) {
//                    AuthPref authPref = new AuthPref(context);
//                    authPref.setToken(authResponse.getAuthItems().getToken());
//                    openMain();
//                }
            }

            @Override
            public void onContractNotFound() {
                fabLoading.hideProgress();
                OhSnapErrorTitleAlert.getInstance().showAlert(context, "Login Failed", "Please provide correct login credentials.");
            }

            @Override
            public void onContractFailure() {
                fabLoading.hideProgress();
                OhSnapErrorAlert.getInstance().showAlert(context, "Login Failed, Please try contacting system admin.");
            }
        });
    }

    private void validateInput() {
        fabLoading.showProgress(context);
        String email = binding.etEmail.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            binding.etEmail.requestFocus();
            binding.tiEmail.setErrorEnabled(true);
            binding.tiEmail.setError("Please provide your email");
            return;
        }

        if (password.isEmpty()) {
            binding.etPassword.requestFocus();
            binding.tiPassword.setErrorEnabled(true);
            binding.tiPassword.setError("Please provide your email");
            return;
        }

        requestAuthToken(email, password);
    }

    private void requestAuthToken(String email, String password) {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail(email);
        authRequest.setPassword(password);
        generateTokenContract.generateToken(authRequest);
    }

    private void openMain() {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.btnLogin) {
            validateInput();
        }
    }
}