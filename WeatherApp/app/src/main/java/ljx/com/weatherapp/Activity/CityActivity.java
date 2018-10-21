package ljx.com.weatherapp.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import ljx.com.weatherapp.R;
import ljx.com.weatherapp.adapter.CityAdapter;
import ljx.com.weatherapp.dao.CityDao;

public class CityActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, View.OnClickListener {
    private Toolbar toolbar;
    private String city;
    private ListView listView;
    private CityDao cityDao;
    private CityAdapter cityAdapter;
    private Button btnQuery;
    private EditText editTextCity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        // 1. 设置toolbar
        initToolbar();
        listView = findViewById(R.id.list_city);
        // 2. 设置ListView的Adapter
        initListView();

        btnQuery = findViewById(R.id.btn_city_query);
        editTextCity = findViewById(R.id.select_city_et);

        btnQuery.setOnClickListener(this);

    }

    private void initListView() {
        cityDao = new CityDao(this);
        Cursor cursor = cityDao.getCursor();
        if(cursor != null) {
            cityAdapter = new CityAdapter(this, cursor);
            listView.setAdapter(cityAdapter);
        }
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    private void initToolbar() {
        city = "南京";
        toolbar = findViewById(R.id.my_toolbar);
        toolbar.setTitle("当前城市：" + city);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case 101:
                    // 刷新Adapter，更新ListView
                    Cursor cursor = cityDao.getCursor();
                    if (cursor != null) {
                        cityAdapter.changeCursor(cursor);
                    }
                    break;
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 获取选中item的student对象
        Cursor cursor = (Cursor) parent.getItemAtPosition(position);
        if(cursor != null) {
            Intent intent = new Intent(CityActivity.this,MainActivity.class);
            String number = cursor.getString(cursor.getColumnIndex("number"));
            String city = cursor.getString(cursor.getColumnIndex("city"));
            SharedPreferences.Editor editor = getSharedPreferences("cityLocalPref",MODE_PRIVATE).edit();
            editor.putString("cityName",city);
            editor.putString("number",number);
            editor.apply();
            startActivity(intent);
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    @Override
    public void onClick(View v) {
        String query = editTextCity.getText().toString();
        if(!query.equals("")){
            Cursor cursor2 = cityDao.getFuzzyCursor(query);
            if(cursor2 != null) {
                cityAdapter = new CityAdapter(this, cursor2);
                listView.setAdapter(cityAdapter);
            }
            listView.setOnItemClickListener(this);
            listView.setOnItemLongClickListener(this);
        }else{
            initListView();
        }
    }
}
