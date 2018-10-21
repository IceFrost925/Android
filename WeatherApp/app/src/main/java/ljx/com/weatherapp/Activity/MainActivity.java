package ljx.com.weatherapp.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ljx.com.weatherapp.R;
import ljx.com.weatherapp.adapter.MainPagerAdapter;
import ljx.com.weatherapp.model.Futures;
import ljx.com.weatherapp.model.Now;
import ljx.com.weatherapp.request.WeatherRequest;
import ljx.com.weatherapp.utils.ViewPagerIndicator;
import ljx.com.weatherapp.utils.WeekUtil;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.show_city)
    TextView showCity;
    @BindView(R.id.update_time)
    TextView updateTime;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_temp)
    TextView tvTemp;
    @BindView(R.id.tv_statue)
    TextView tvStatue;
    @BindView(R.id.tv_wind)
    TextView tvWind;
    @BindView(R.id.day_weather_hum)
    TextView dayWeatherHum;
    @BindView(R.id.day_weather_pm25)
    TextView dayWeatherPm25;
    @BindView(R.id.top_img)
    ImageView topImg;
    @BindView(R.id.day_weather_img)
    ImageView dayWeatherImg;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private LinearLayout dotLayout;
    private WeatherRequest weatherRequest;
    private String city_name;
    private  Now now = new Now();
    private  List<Futures> futuresList = new ArrayList<>();
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager = findViewById(R.id.view_page);
        //初始化toolbar
        initToolbar();

        SharedPreferences preferences = getSharedPreferences("cityLocalPref", MODE_PRIVATE);
        city_name = preferences.getString("cityName", "北京");
        //WeatherRequest
        weatherRequest = new WeatherRequest(MainActivity.this);

        new Thread(runnable).start();


    }
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            now = (Now) data.getSerializable("value");
            futuresList = (List<Futures>) data.getSerializable("futures");
            initHomeInfo();
            initViewPage();
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // TODO: http request.
            try {
                Now now = weatherRequest.getNow("https://free-api.heweather.com/s6/weather", city_name);
                List<Futures> list =  weatherRequest.getFuuresWeather("https://free-api.heweather.com/s6/weather/forecast",city_name);
                Message msg = new Message();
                Bundle data = new Bundle();
                data.putSerializable("value", now);
                data.putSerializable("futures", (Serializable) list);
                msg.setData(data);
                handler.sendMessage(msg);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    private void initHomeInfo() {
        showCity.setText(city_name);
        updateTime.setText(now.getUpdateTime().substring(10)+"发布");
        dayWeatherHum.setText("相对湿度："+now.getHum()+"%");
        WeekUtil weekUtil = new WeekUtil();
        String day = now.getUpdateTime().substring(8,10);
        String week = weekUtil.getWeek(now.getUpdateTime().substring(0,10));
        tvDate.setText(day+"日/"+week);
        tvTemp.setText(now.getTmp_min()+"℃ ~ " + now.getTmp_max()+"℃");
        tvStatue.setText(now.getCond_txt());
        tvWind.setText("风力"+now.getWind_sc()+"级");
        String status = now.getCond_status();
        int resID = getResources().getIdentifier(status, "drawable","ljx.com.weatherapp");
        dayWeatherImg.setImageResource(resID);
        dayWeatherPm25.setText(String.valueOf(now.getPM25()));
        if (now.getPM25()>300 ){
            topImg.setImageResource(R.drawable.biz_plugin_weather_greater_300);
        }else if(201 <= now.getPM25()&& now.getPM25() <= 300){
            topImg.setImageResource(R.drawable.biz_plugin_weather_201_300);
        }else if(151 <= now.getPM25()&& now.getPM25() <= 200){
            topImg.setImageResource(R.drawable.biz_plugin_weather_151_200);
        }else if(101 <= now.getPM25()&& now.getPM25() <= 150){
            topImg.setImageResource(R.drawable.biz_plugin_weather_101_150);
        }else if(51 <= now.getPM25()&& now.getPM25() <= 100){
            topImg.setImageResource(R.drawable.biz_plugin_weather_51_100);
        }else {
            topImg.setImageResource(R.drawable.biz_plugin_weather_0_50);
        }
    }

    private void initViewPage() {
        List<View> list = new ArrayList<>();
        LayoutInflater lf = getLayoutInflater();
        list.add(lf.inflate(R.layout.viewpage1_home, null));
        list.add(lf.inflate(R.layout.viewpage2_home, null));

        List<Integer> list2 = new ArrayList<>();
        list2.add(R.layout.viewpage1_home);
        list2.add(R.layout.viewpage2_home);

        MainPagerAdapter mainPageAdapter = new MainPagerAdapter(MainActivity.this, list, list2, futuresList);
        viewPager.setAdapter(mainPageAdapter);
        mainPageAdapter.notifyDataSetChanged();
        dotLayout = findViewById(R.id.layout_point);
        viewPager.setOnPageChangeListener(new ViewPagerIndicator(this, viewPager, dotLayout, 2));
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

}
