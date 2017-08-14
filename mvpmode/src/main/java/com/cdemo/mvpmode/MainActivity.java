package com.cdemo.mvpmode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cdemo.mvpmode.bean.User;
import com.cdemo.mvpmode.presenter.Presenter;
import com.cdemo.mvpmode.view.IUserLoginView;

/**
 * MVP模式中的View层
 */
public class MainActivity extends AppCompatActivity implements IUserLoginView{

    private EditText userNameEt, userPasswordEt;
    private Button loginButton, clearButton;
    private ProgressBar progressBar;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }


    private void initView() {

        // TODO 可通过注解方式初始化控件
        userNameEt = (EditText) findViewById(R.id.username);
        userPasswordEt = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login);
        clearButton = (Button) findViewById(R.id.clear);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        // 初始化Presenter
        presenter = new Presenter(this);
        
        loginButton.setOnClickListener(loginButtonClick);
        clearButton.setOnClickListener(clearButtonClick);


    }

    View.OnClickListener loginButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.login();
        }
    };
    
    
    View.OnClickListener clearButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            presenter.clear();
        }
    };

    @Override
    public String getUserName() {
        return userNameEt.getText().toString();
    }

    @Override
    public String getPassWord() {
        return userPasswordEt.getText().toString();
    }

    @Override
    public void clearPassWord() {
        userPasswordEt.setText("");
    }

    @Override
    public void clearUserName() {
        userNameEt.setText("");
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
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUserName() +
                ", login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }
}
