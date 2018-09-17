package ljx.com.oncespance;

import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ToolbarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        toolbar = findViewById(R.id.my_toolbar);
        toolbar.setTitle("详情页");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setLogo(R.mipmap.ic_notifications);
        //方法一： 给toolbar加载菜单
        setSupportActionBar(toolbar);   //重写onCreateOptionMenu和onOptionItemsSeleted方法

        //方法二：
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.inflateMenu(R.menu.demo); //需要设置菜单选择的事件监听
        }
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_search:
                        Snackbar.make(toolbar,"toolbar search",Snackbar.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.demo,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_search:
                Snackbar.make(toolbar,"toolbar",Snackbar.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
