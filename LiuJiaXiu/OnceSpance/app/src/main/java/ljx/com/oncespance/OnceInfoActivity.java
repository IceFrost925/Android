package ljx.com.oncespance;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class OnceInfoActivity extends AppCompatActivity {

    private Button btn_click;
    private EditText etName,etIp;
    private TextView tv_showIp;
    private RadioGroup rgSex;
    private RadioButton btnSex;
    private CheckBox cbJava,cbAndroid,cbEnglish,cbMath;
    String course = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_once_info);
        etName = findViewById(R.id.et_name);
        etName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP){
                    //关闭软件盘
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if(imm != null && imm .isActive()){
                        imm.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
                    }
                }
                return false;
            }
        });


        cbJava = findViewById(R.id.cb_1);
        cbAndroid = findViewById(R.id.cb_2);
        cbMath = findViewById(R.id.cb_3);
        cbEnglish = findViewById(R.id.cb_4);
        CheckedChange checkedChange = new CheckedChange();
        cbJava.setOnCheckedChangeListener(checkedChange);
        cbAndroid.setOnCheckedChangeListener(checkedChange);
        cbMath.setOnCheckedChangeListener(checkedChange);
        cbEnglish.setOnCheckedChangeListener(checkedChange);

        rgSex = findViewById(R.id.rg_sex);

        btn_click = findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rgSex.getCheckedRadioButtonId();
                String name = etName.getText().toString();
                String sex;
                if(id == R.id.rb_man){
                    sex = "男";
                }else{
                    sex = "女";
                }

                String content = "姓名为："+name + "，性别：" + sex + "，喜欢的专业：" + course;
                Toast.makeText(OnceInfoActivity.this,content,Toast.LENGTH_SHORT).show();
                Snackbar.make(getWindow().getDecorView(), content, Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(OnceInfoActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        etIp = findViewById(R.id.et_ip);
        tv_showIp = findViewById(R.id.tv_showIp);
        etIp.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getAction()){
                    case KeyEvent.ACTION_UP:
                        String ip = etIp.getText().toString();
                        String newIp = "";
                        for(int i=0;i<ip.length()/3;i++){
                            if(i*3 + 3 <ip.length()){
                                newIp += ip.substring(i*3,Math.min(i*3+3,ip.length()))+".";
                            }else{
                                newIp += ip.substring(i*3,Math.min(i*3+3,ip.length()));
                            }
                        }
                        tv_showIp.setText(newIp);
                        break;
                    case KeyEvent.ACTION_DOWN:
                        break;
                }
                return false;
            }
        });
    }

    private class CheckedChange implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            course = "";
            if(cbJava.isChecked()){
                course += " " + cbJava.getText().toString();
            }
            if(cbAndroid.isChecked()){
                course += " " + cbAndroid.getText().toString();
            }
            if(cbMath.isChecked()){
                course += " " + cbMath.getText().toString();
            }
            if(cbEnglish.isChecked()){
                course += " " + cbEnglish.getText().toString();
            }

        }
    }
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            String pos = "";
            float X = event.getX();
            float Y = event.getY();
            pos = "X轴坐标："+ X + "Y轴坐标："+ Y;
            Toast.makeText(this,pos,Toast.LENGTH_SHORT).show();
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            Toast.makeText(this,"手指抬起",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
