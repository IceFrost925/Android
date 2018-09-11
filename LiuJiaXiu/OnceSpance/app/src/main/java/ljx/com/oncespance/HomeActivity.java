package ljx.com.oncespance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_home);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.item_info_maintain:
                Toast.makeText(HomeActivity.this,"个人信息维护",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_setting:
                Toast.makeText(HomeActivity.this,"个人信息维护",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_questionnaire:
                Toast.makeText(HomeActivity.this,"个人信息维护",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_about:
                Toast.makeText(HomeActivity.this,"个人信息维护",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
