package com.wendergalan.captchaexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.are_you_human_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamarCaptacha();
            }
        });

    }

    void chamarCaptacha(){
        SafetyNetClient safetyNetClient = SafetyNet.getClient(this);

        safetyNetClient.verifyWithRecaptcha("6LcpcXUUAAAAAGUqujmwup-VCntXozIY6TFQnJ3z").addOnSuccessListener(this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
            @Override
            public void onSuccess(SafetyNetApi.RecaptchaTokenResponse recaptchaTokenResponse) {
                if (!recaptchaTokenResponse.getTokenResult().isEmpty()) {
                    //poderia validar o token na API da google ou apenas prosseguir
                    //URL: https://www.google.com/recaptcha/api/siteverify
                    //PARAMS
                    //secret (required)	6LcpcXUUAAAAABXeH5rKFQIg0f0rQYoCWn0mhy2K
                    //response (required)	The value of SafetyNetApi.RecaptchaTokenResponse.getTokenResult() method.
                    //remoteip	The end user's ip address.
                }
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ApiException) {
                    ApiException apiException = (ApiException) e;
                    Log.d("TAG", "Error message: " +
                            CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                } else {
                    Log.d("TAG", "Unknown type of error: " + e.getMessage());
                }
            }
        });
    }

}
