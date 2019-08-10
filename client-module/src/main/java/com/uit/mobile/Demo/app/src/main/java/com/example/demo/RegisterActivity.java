package com.example.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.topfactors.common.ApiConstant;
import com.topfactors.common.AppUtils;
import com.topfactors.common.ResponseCode;
import com.topfactors.dto.ApiResponse;
import com.topfactors.dto.RegisterDto;
import com.topfactors.form.RegisterArgs;

public class RegisterActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCfrPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextCfrPassword = (EditText) findViewById(R.id.edittext_cfr_password);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mTextViewLogin = (TextView) findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                registerNewCandidate(v);
            }
        });
    }

    private void registerNewCandidate(View v){
        Gson gson = new Gson();

        String url = ApiConstant.registerAPI;

        RegisterArgs args = new RegisterArgs("CuongVM123", "Vu Manh Cuong", "CuongVM123", "01234567823");

        Log.i("Register Args: ", args.toString());

        String params = gson.toJson(args);
        Log.i("Params: ", params);

        ApiResponse apiResponse = AppUtils.sendPostRequest(url, "", params);

        if(apiResponse.getCode() == ResponseCode.SUCCESS){
            // do something
            String message = apiResponse.getMessage();
            RegisterDto dto = gson.fromJson(message, RegisterDto.class);

            Log.i("Register: ", dto.toString());

        }else if(apiResponse.getCode() == ResponseCode.BAD_REQUEST){
            // do something
        }

    }
}
