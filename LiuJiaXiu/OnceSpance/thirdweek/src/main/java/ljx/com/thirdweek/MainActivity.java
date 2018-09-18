package ljx.com.thirdweek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin,btnInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        btnInfo = findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_login:
                intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_info:
                intent = new Intent(MainActivity.this,OnceInfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
