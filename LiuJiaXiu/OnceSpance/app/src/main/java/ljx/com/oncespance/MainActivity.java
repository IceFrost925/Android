package ljx.com.oncespance;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.util.EthiopicCalendar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin,btnExit,btnImage,btnDialog,btnToolbar,btnCalculator;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable_user = getResources().getDrawable(R.drawable.ico_user);
        drawable_user.setBounds(0, 0, 50, 50);
        username = findViewById(R.id.info_username);
        username.setCompoundDrawables(drawable_user,null,null,null);


        Drawable drawable_password = getResources().getDrawable(R.drawable.ico_password);
        drawable_password.setBounds(0, 0, 50, 50);
        password = findViewById(R.id.info_password);
        password.setCompoundDrawables(drawable_password,null,null,null);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = username.getText().toString();
                String mPassword = password.getText().toString();

                if(name.equals("1602343113")&& mPassword.equals("123456")){
                    Intent intent = new Intent(MainActivity.this,OnceInfoActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"用户名或密码错误！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnExit = findViewById(R.id.btn_back);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder quitDia = new AlertDialog.Builder(MainActivity.this);
                quitDia.setIcon(R.mipmap.ic_launcher);
                quitDia.setTitle("提示");
                quitDia.setMessage("退出？");
                quitDia.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                quitDia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                quitDia.create().show();
            }
        });

        btnImage = findViewById(R.id.btn_img);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TouchActivity.class);
                startActivity(intent);
            }
        });

        btnDialog = findViewById(R.id.btn_dialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });

        btnToolbar = findViewById(R.id.btn_toolbar);
        btnToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ToolbarActivity.class);
                startActivity(intent);
            }
        });

        btnCalculator = findViewById(R.id.btn_calculator);
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CalculatorActivity.class);
                startActivity(intent);
            }
        });

    }
}
