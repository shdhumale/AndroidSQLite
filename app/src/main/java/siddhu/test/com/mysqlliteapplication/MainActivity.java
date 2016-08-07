package siddhu.test.com.mysqlliteapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button insert;
    Button query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = (Button) findViewById(R.id.activity_main_insert);
        query = (Button) findViewById(R.id.activity_main_query);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertSomethingIntoDatabase();
                Toast.makeText(MainActivity.this, "Insertedls", Toast.LENGTH_SHORT).show();
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query();
                Toast.makeText(MainActivity.this, "Query", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void insertSomethingIntoDatabase()
    {
        MyOpenHealper myOpenHealper = new MyOpenHealper(this);
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyOpenHealper.User.name,"shdhumale");
        contentValues.put(MyOpenHealper.User.email,"shdhumale@gmail.com");
        SQLiteDatabase sqLiteDatabase = myOpenHealper.getWritableDatabase();
        sqLiteDatabase.insert(MyOpenHealper.Tables.USER,null,contentValues);

    }

    public void query()
    {
        MyOpenHealper myOpenHealper = new MyOpenHealper(this);
        SQLiteDatabase sqliteDatabase = myOpenHealper.getReadableDatabase();
        Cursor cursor = sqliteDatabase.query(MyOpenHealper.Tables.USER,null,null,null,null,null,null);

        if(cursor.moveToFirst())
        {
            do{
                int _id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID));
                String name = cursor.getString(cursor.getColumnIndex(MyOpenHealper.User.name));
                String email = cursor.getString(cursor.getColumnIndex(MyOpenHealper.User.email));
                System.out.println("Row ," +_id + ", " + name + ", "+  email);
                Log.d("MainActivity", "Row ," +_id + ", " + name + ", "+  email);
            }while(cursor.moveToNext());
        }
    }
}
