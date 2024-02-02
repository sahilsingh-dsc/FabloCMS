package com.myfablo.cms.module_tickets;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.myfablo.cms.R;
import com.myfablo.cms.databinding.ActivityUploadDocumentsBinding;

import java.util.ArrayList;
import java.util.List;

import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;

public class UploadDocumentsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CUSTOM_REQUEST_CODE = 10;
    private ActivityUploadDocumentsBinding binding;
    private Context context;
    private List<Uri> photoPaths;
    private List<Uri> docPaths;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadDocumentsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();
    }

    private void initView() {
        initClick();
    }

    private void initClick() {
        binding.ivGoBack.setOnClickListener(this);
        binding.ivPanCard.setOnClickListener(this);
        binding.ivFssaiLicence.setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case FilePickerConst.REQUEST_CODE_PHOTO:
                if (resultCode == Activity.RESULT_OK && data != null) {
                    photoPaths = new ArrayList<>();
                    photoPaths.addAll(data.getParcelableArrayListExtra(FilePickerConst.KEY_SELECTED_MEDIA));
                    uploadFilesToFirebaseStorage(photoPaths, docPaths);
                }
                break;
            case FilePickerConst.REQUEST_CODE_DOC:
                if (resultCode == Activity.RESULT_OK && data != null) {
                    docPaths = new ArrayList<>();
                    docPaths.addAll(data.getParcelableArrayListExtra(FilePickerConst.KEY_SELECTED_DOCS));
                    uploadFilesToFirebaseStorage(photoPaths, docPaths);
                }
                break;
        }
//        addThemToView(photoPaths, docPaths);
    }

    private void uploadFilesToFirebaseStorage(List<Uri> photoPaths, List<Uri> docPaths) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        for (Uri fileUri : photoPaths) {
            uploadFile(storageRef, fileUri, "photos/");
        }

        for (Uri fileUri : docPaths) {
            uploadFile(storageRef, fileUri, "docs/");
        }
    }

    private void uploadFile(StorageReference storageRef, Uri fileUri, String folder) {
        StorageReference fileRef = storageRef.child(folder + fileUri.getLastPathSegment());
        UploadTask uploadTask = fileRef.putFile(fileUri);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // Handle successful upload
                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Handle failed upload
                Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v == binding.ivGoBack) {
            onBackPressed();
        } else if (v == binding.ivPanCard) {
            FilePickerBuilder.getInstance()
                    .setMaxCount(5) //optional
                    .pickPhoto(this);
        } else if (v == binding.ivFssaiLicence) {
            FilePickerBuilder.getInstance()
                    .setMaxCount(1) //optional
                    .pickFile(this);
        }
    }
}