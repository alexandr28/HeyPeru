package com.acampdev.heyperu;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.acampdev.heyperu.Helpers.DBHelper;
import com.acampdev.heyperu.Models.User;
import com.acampdev.heyperu.SQLConstants;

public class Data {
    Context context;
    SQLiteDatabase database;
    SQLiteOpenHelper openHelper;

    public Data(Context context){
        this.context = context;
        openHelper= new DBHelper(context);
        database=openHelper.getWritableDatabase();
    }

    public void open(){
        database=openHelper.getWritableDatabase();
    }
    public void close(){
        openHelper.close();
    }

    public long  getItemsCounts(){
        return DatabaseUtils.queryNumEntries(database,SQLConstants.UserTable);
    }

    public void insertUser(User user){
        ContentValues contentValues = user.toValues();
        database.insert(SQLConstants.UserTable,null,contentValues);
        database.close();
    }
}
