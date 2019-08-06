package com.example.testapi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.testapi.common.AppUtils;
import com.example.testapi.common.ResponseCode;
import com.example.testapi.dto.ApiResponse;
import com.example.testapi.dto.LoginArgs;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private Button btnGetButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.init();

        setContentView(R.layout.content_main);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }

    private void init(){
        this.btnGetButton = findViewById(R.id.btnGetAPI);
        this.btnGetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                testGetApi(v);
            }
        });
    }

    private void testGetApi(View v) {
        Gson gson = new Gson();
        LoginArgs loginArgs = new LoginArgs("AnhPmcl2015", "AnhPmcl2015");
        String params = gson.toJson(loginArgs, LoginArgs.class);

        ApiResponse resp = AppUtils.sendPostRequest("http://localhost:8080/api/auth/ung-vien/dang-nhap", "", params);
        if(resp.getCode() == ResponseCode.SUCCESS){
            Log.i("Thành công", resp.getMessage());
            Snackbar.make(v, "Thành công rồi nha <3", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        }else{

            Log.e("Lỗi", resp.getMessage());
            Snackbar.make(v, resp.getMessage(), Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

}
