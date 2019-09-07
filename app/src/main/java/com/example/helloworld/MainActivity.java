package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText etUsername,etPassword;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   Button bt_bos = (Button) findViewById(R.id.bt_bos);
        bt_bos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ZYActivity.class);
                startActivity(i);
            }
        });*/
     initToolbar();
     initView();
     initData();

    }
    private void initToolbar(){
        Toolbar toolbar = findViewById(R.id.title_toolbar);
        toolbar.setTitle("登录");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
    }
    private void initData(){
        String username = readPref();
        if (TextUtils.isEmpty(username)){
            etUsername.setText(username);
        }
    }
    private String readPref(){
        SharedPreferences sp = getSharedPreferences("userInfo",MODE_PRIVATE);
        return sp.getString("username","");
    }
    private void initView(){
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        TextView tvRegister = findViewById(R.id.bt_bos);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}