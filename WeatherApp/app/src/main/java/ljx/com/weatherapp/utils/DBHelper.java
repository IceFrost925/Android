package ljx.com.weatherapp.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


// SQLite创建数据库及表的辅助类
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, int version) {
        super(context, "city.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 1. 定义个字符串 - 创建表(_id 整型 主键 自增）
        String sql = "create table city(" +
                "_id integer primary key AUTOINCREMENT," +
                "province varchar(20)," +
                "city varchar(20)," +
                "number varchar(20)," +
                "allpy varchar(20)," +
                "allfirstpy varchar(20)," +
                "firstpy varchar(20)" + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 删除student表
        String sql = "drop table if exists City";
        onCreate(db);
    }
}
