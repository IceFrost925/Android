package ljx.com.weatherapp.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import ljx.com.weatherapp.utils.DBHelper;

public class CityDao {
    private DBHelper helper;

    // 构造方法，初始化DBHelper对象
    public CityDao(Context context) {
        helper = new DBHelper(context, 1);
    }
    // 1. 查询所有的记录，给CursorAdapter使用
    public Cursor getCursor() {
        // 1. 获取SQLiteDatabse对象db
        SQLiteDatabase db = helper.getReadableDatabase();
        // 2. 执行db.query()方法获取Cursor对象，
        // 相当于sql：select * from student
        Cursor cursor = db.query("city", null, null, null,
                null, null, null);
//        Cursor cursor = db.rawQuery("select * from student", null);
        return  cursor;
    }

    // 1. 查询所有的记录，给CursorAdapter使用
    public Cursor getFuzzyCursor(String city) {
        // 1. 获取SQLiteDatabse对象db
        SQLiteDatabase db = helper.getReadableDatabase();
        // 2. 执行db.query()方法获取Cursor对象，
        // 相当于sql：select * from student
        String[] selectionArgs = new String[]{city};
        String selection = "city=?";
        Cursor cursor = db.query("city",null, selection, selectionArgs,
                null, null, null);
//        Cursor cursor = db.rawQuery("select * from student", null);
        return  cursor;
    }
}
