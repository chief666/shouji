package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloworld.utils.MD5Utils;

public class RegisterActivity extends AppCompatActivity {

    //1获取界面上的控件
    //2.button的点击事件的监控
    //3.

    private EditText etUsername, etPassword, etPwdAgain;
    private Button btBos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //1
        initView();
        //2.
        btBos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //3.
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String pwdagain = etPwdAgain.getText().toString();
                //3.2
                if (TextUtils.isEmpty(username)){
                    Toast.makeText(RegisterActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(password)){
                    Toast.makeText(RegisterActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }else if (!password.equals(pwdagain)){
                    Toast.makeText(RegisterActivity.this,"再次密码一致",Toast.LENGTH_SHORT).show();
                }else {
                    savePref(username, MD5Utils.md5(password));
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    intent.putExtra("username",username);
                    startActivity(intent);
                }
            }
        });

    }

    private void savePref(String username, String password) {
        SharedPreferences sp = getSharedPreferences("userInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.apply();
    }

    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etPwdAgain = findViewById(R.id.et_repassword);
        btBos = findViewById(R.id.bt_bos);
    }
}
