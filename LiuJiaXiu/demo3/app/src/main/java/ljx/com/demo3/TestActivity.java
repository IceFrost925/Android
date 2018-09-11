package ljx.com.demo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    private EditText username;
    private Button btnLogin,btnTextView,mBtnButton,mBtnEditor,btnRadio,btnCheckBox,btnImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_test);
        //获得组件
        username = findViewById(R.id.et_username);
        btnLogin = findViewById(R.id.btn_login);

        //设置button监听
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //处理button的监听
                String name = username.getText().toString();
                //将输入的用户名弹出来显示
                Toast.makeText(TestActivity.this,"输入的用户名为：" + name,Toast.LENGTH_SHORT).show();
            }
        });

        btnTextView = findViewById(R.id.btn_1);

        mBtnButton = findViewById(R.id.btn_button);

        mBtnEditor = findViewById(R.id.btn_editor);

        btnRadio = findViewById(R.id.radio_btn);

        btnCheckBox = findViewById(R.id.check_btn);

        btnImageView = findViewById(R.id.iv_btn);
       setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        btnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditor.setOnClickListener(onClick);
        btnRadio.setOnClickListener(onClick);
        btnCheckBox.setOnClickListener(onClick);
        btnCheckBox.setOnClickListener(onClick);
        btnImageView.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_1:
                    intent = new Intent(TestActivity.this,TextViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_button:
                    intent = new Intent(TestActivity.this,ButtonActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_editor:
                    intent = new Intent(TestActivity.this,EditorViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.radio_btn:
                    intent = new Intent(TestActivity.this,RadioButtonActivity.class);
                    startActivity(intent);
                    break;
                case R.id.check_btn:
                    intent = new Intent(TestActivity.this,CheckBoxActivity.class);
                    startActivity(intent);
                    break;
                case R.id.iv_btn:
                    intent = new Intent(TestActivity.this,ImageViewActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    }
}
