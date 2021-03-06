package siddhu.test.com.mysqlliteapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by admin on 8/7/2016.
 */

public class MyOpenHealper extends SQLiteOpenHelper {
    public interface Tables {
        String USER = "user";
    }

    public interface User {
        String name = "name";
        String email = "email";
    }

    final String CREATE_USER_TABLE = "create table " + Tables.USER + "(" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + User.email + " TEXT,"
            + User.name + " TEXT);";

    public static final String DATABASE_NAME = "vodafonedb";

    public static final int CURRENT_VERSION = 1;

    public MyOpenHealper(Context context) {
        super(context, DATABASE_NAME, null, CURRENT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
