package ljx.com.weatherapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import ljx.com.weatherapp.R;


public class CityAdapter extends CursorAdapter {

    public CityAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    // 加载ListView的每个子项item_city.xml
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_city, viewGroup, false);
    }

    // 绑定cursor
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // 1. 根据view获取item_student.xml中的每个控件
        TextView name = view.findViewById(R.id.name_city);

        // 2. 给每个控件赋值，数据来源为cursor
        name.setText(cursor.getString(cursor.getColumnIndex("province"))+"-"+cursor.getString(cursor.getColumnIndex("city")));
    }
}
