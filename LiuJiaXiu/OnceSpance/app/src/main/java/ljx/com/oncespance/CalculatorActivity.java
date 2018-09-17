package ljx.com.oncespance;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnC, btnDel, btnDivision, btnMultip, btnSub, btnAdd, btnResult,
            btnPoint, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textView = findViewById(R.id.show_result);
        editText = findViewById(R.id.et_input);

        btnC = findViewById(R.id.btn_c);
        btnC.setOnClickListener(this);

        btnDel = findViewById(R.id.btn_delete);
        btnDel.setOnClickListener(this);

        btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.btn_3);
        btn3.setOnClickListener(this);

        btn4 = findViewById(R.id.btn_4);
        btn4.setOnClickListener(this);

        btn5 = findViewById(R.id.btn_5);
        btn5.setOnClickListener(this);

        btn6 = findViewById(R.id.btn_6);
        btn6.setOnClickListener(this);

        btn7 = findViewById(R.id.btn_7);
        btn7.setOnClickListener(this);

        btn8 = findViewById(R.id.btn_8);
        btn8.setOnClickListener(this);

        btn9 = findViewById(R.id.btn_9);
        btn9.setOnClickListener(this);

        btn0 = findViewById(R.id.btn_0);
        btn0.setOnClickListener(this);

        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);

        btnDivision = findViewById(R.id.btn_division);
        btnDivision.setOnClickListener(this);

        btnMultip = findViewById(R.id.btn_multip);
        btnMultip.setOnClickListener(this);

        btnSub = findViewById(R.id.btn_subtraction);
        btnSub.setOnClickListener(this);

        btnPoint = findViewById(R.id.btn_point);
        btnPoint.setOnClickListener(this);

        btnResult = findViewById(R.id.btn_result);
        btnResult.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String content = editText.getText().toString();
        switch (v.getId()) {
            case R.id.btn_delete:
                if (TextUtils.isEmpty(content)) {
                    content = "";
                } else {
                    content = content.substring(0, content.length() - 1);
                    editText.setText(content);
                    editText.setSelection(content.length());
                }

                break;
            case R.id.btn_c:
                content = "";
                editText.setText(content);
                break;
            case R.id.btn_result:
                if (content.matches("^(-)?[0-9]+(.\\d+)?[+\\-*/]\\d+(.\\d+)?") && !TextUtils.isEmpty(content)) {
                    try {
                        Symbols symbols = new Symbols();
                        double res = 0;
                        res = symbols.eval(content);
                        textView.setText(String.valueOf(res));
                        editText.setText("");
                        content = "";
                    } catch (SyntaxException e) {
                        e.printStackTrace();
                        Toast.makeText(CalculatorActivity.this, "语法错误", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(CalculatorActivity.this, "输入格式错误", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                content += ((Button) v).getText().toString();
                editText.setText(content);
                break;
        }
    }


}
