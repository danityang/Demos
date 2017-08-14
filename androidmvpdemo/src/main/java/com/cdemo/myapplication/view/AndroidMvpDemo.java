package com.cdemo.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cdemo.myapplication.R;
import com.cdemo.myapplication.presenter.Presenter;

public class AndroidMvpDemo extends AppCompatActivity implements ILoginView{
    Presenter mPresenter;
    private Button loginBtn, clearBtn;
    private EditText uesrNameEt, userPasswordEt;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        uesrNameEt = (EditText) findViewById(R.id.username);
        userPasswordEt = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.login);
        clearBtn = (Button) findViewById(R.id.clear);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        // 初始化Presenter
        mPresenter = new Presenter(this);

        loginBtn.setOnClickListener(loginButtonClick);
        clearBtn.setOnClickListener(clearButtonClick);

    }


    View.OnClickListener loginButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPresenter.doLogin();
        }
    };


    View.OnClickListener clearButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPresenter.clearText();
        }
    };

    @Override
    public String getUserName() {
        return uesrNameEt.getText().toString();
    }

    @Override
    public String getPassWord() {
        return userPasswordEt.getText().toString();
    }

    @Override
    public void clearUserName() {
        uesrNameEt.setText("");

    }

    @Override
    public void clearPassWord() {
        userPasswordEt.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void loginSussecc() {
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }
}
