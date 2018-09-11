package ljx.com.demo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditorViewActivity extends AppCompatActivity {
    private Button mBtnLogin;
    private EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_view);
        mBtnLogin = findViewById(R.id.bt_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditorViewActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
            }
        });
        username = findViewById(R.id.et_1);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("editText",s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
