package com.example.whatsapptest.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.whatsapptest.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginPagePhoneNum extends AppCompatActivity {
    EditText phoneNum , code ;
    Button sendCode , verify ;
    FirebaseAuth auth ;
    String verificationId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page_phone_num);
        unitUi();
        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(phoneNum.getText().toString()))
                    Toast.makeText(LoginPagePhoneNum.this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
                else {
                    String number = phoneNum.getText().toString();
                    Toast.makeText(LoginPagePhoneNum.this, "", Toast.LENGTH_SHORT).show();
                    sendVerifyCode(number);
                }
            }
        });

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(code.getText().toString()))
                    Toast.makeText(LoginPagePhoneNum.this, "No Code Entered ", Toast.LENGTH_SHORT).show();
                else
                    verifyCode(code.getText().toString());
            }
        });
    }

    private void unitUi() {
        phoneNum = findViewById(R.id.enterPhoneNumber);
        code = findViewById(R.id.enterCode);
        sendCode = findViewById(R.id.search);
        verify = findViewById(R.id.verify);
        auth = FirebaseAuth.getInstance();
    }
    private void sendVerifyCode (String number){
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber("+20"+number)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }

private final PhoneAuthProvider.OnVerificationStateChangedCallbacks

     mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
            final String code =credential.getSmsCode();
            if (code != null )
                verifyCode(code);


        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(LoginPagePhoneNum.this, "Verification Failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s,
                @NonNull PhoneAuthProvider.ForceResendingToken token) {
            super.onCodeSent(s,token);
            verificationId = s ;


        }
    };
    private void verifyCode (String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId ,code);
        signInByCredential(credential);

    }

    private void signInByCredential(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginPagePhoneNum.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginPagePhoneNum.this,MainActivity.class));
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser =FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null ){
            startActivity(new Intent(LoginPagePhoneNum.this,MainActivity.class));
            finish();
        }
    }
}