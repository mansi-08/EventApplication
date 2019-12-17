package com.ssb.eventorganizer.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String dataBaseName = "RealEstate";
    private static DatabaseHelper databaseHelper;
    public DatabaseHelper(Context context) {
        super(context, dataBaseName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        new PhoneNumberTable(sqLiteDatabase);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static DatabaseHelper getInstance(Context context)
    {
        if(databaseHelper==null)
        {
            databaseHelper = new DatabaseHelper(context);
            return databaseHelper;
        }
        else
            return databaseHelper;
    }

    public boolean AddPhoneNumber(PhoneNumberTable phoneNumberTable) {
        try {
            PhoneNumberTable keyPhoneNumberTable = new PhoneNumberTable();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            // contentValues.put(keyUserName.getId,userTable.getId());
            contentValues.put(keyPhoneNumberTable.getPhoneNumber(), phoneNumberTable.getPhoneNumber());

            sqLiteDatabase.insert(keyPhoneNumberTable.getTableName(), null, contentValues);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public Cursor getPhoneNumberfromCustomer() {
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM PhoneNumberTable",null);
    }
}
