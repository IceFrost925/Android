package ljx.com.weatherapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ljx.com.weatherapp.R;
import ljx.com.weatherapp.adapter.MainPagerAdapter;
import ljx.com.weatherapp.utils.ViewPagerIndicator;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private LinearLayout dotLayout;
    private LinearLayout weatherLayout;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_page);
        //初始化toolbar
        initToolbar();
        //初始化viewPage控件
        initViewPage();
        //初始化viewPage数据
        initViewPageData();
        Intent intent = getIntent();
        int flag = intent.getIntExtra("flag", 1);
        switch (flag) {
            case 1:
                break;
            case 2:
                Bundle bundle = intent.getExtras();
                String city_number = bundle.getString("city_number");
                String city_name = bundle.getString("cityName");
                Toast.makeText(MainActivity.this, city_name + "-" + city_number, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initViewPageData() {
        LayoutInflater inflater = this.getLayoutInflater();
        weatherLayout = findViewById(R.id.day_weather_layout);
        ViewHolde dayView;
        View view = null;
        for (int i = 0;i< 3;i++){
            view = inflater.inflate(R.layout.day_weather_info,null);
            dayView = new ViewHolde();
            dayView.textViewDate = findViewById(R.id.day_weather_date);
            dayView.textViewTemp = findViewById(R.id.day_weather_temp);
            dayView.textViewWind = findViewById(R.id.day_weather_wind);
            dayView.textViewStatus = findViewById(R.id.day_weather_status);
            //给viewHoder赋值
            dayView.imageView.setImageResource(R.drawable.biz_plugin_weather_qing);
            dayView.textViewTemp.setText("22℃~29℃");
            dayView.textViewWind.setText("风力3级");
            dayView.textViewStatus.setText("阴");
            view.setTag(dayView);
        }
        weatherLayout.addView(view);
    }

    private void initViewPage() {

        List<View> list = new ArrayList<>();
        LayoutInflater lf = getLayoutInflater();
        list.add(lf.inflate(R.layout.viewpage1_home, null));
        list.add(lf.inflate(R.layout.viewpage2_home, null));

        MainPagerAdapter mainPageAdapter = new MainPagerAdapter(list);
        viewPager.setAdapter(mainPageAdapter);
        dotLayout = findViewById(R.id.layout_point);
        viewPager.setOnPageChangeListener(new ViewPagerIndicator(this,viewPager,dotLayout,2));

    }

    private void initToolbar() {
        toolbar = findViewById(R.id.my_toolbar);
        toolbar.inflateMenu(R.menu.toolbar);
        //右侧菜单
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_search:
                        Snackbar.make(toolbar, "toolbar search", Snackbar.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
        //navigationIcon
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                startActivity(intent);
            }
        });
    }
    class ViewHolde{
        TextView textViewDate;
        TextView textViewTemp;
        TextView textViewStatus;
        TextView textViewWind;
        ImageView imageView;
    }
}
