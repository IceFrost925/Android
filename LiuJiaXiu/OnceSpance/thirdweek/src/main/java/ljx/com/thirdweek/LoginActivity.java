package ljx.com.thirdweek;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Drawable drawable_user = getResources().getDrawable(R.drawable.ico_user);
        drawable_user.setBounds(0, 0, 50, 50);
        username = findViewById(R.id.info_username);
        username.setCompoundDrawables(drawable_user,null,null,null);


        Drawable drawable_password = getResources().getDrawable(R.drawable.ico_password);
        drawable_password.setBounds(0, 0, 50, 50);
        password = findViewById(R.id.info_password);
        password.setCompoundDrawables(drawable_password,null,null,null);
    }
}
