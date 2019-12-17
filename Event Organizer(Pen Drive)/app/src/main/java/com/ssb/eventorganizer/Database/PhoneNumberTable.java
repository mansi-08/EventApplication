package com.ssb.eventorganizer.Database;

import android.database.sqlite.SQLiteDatabase;

public class PhoneNumberTable {

    private String phoneNumber = "phoneNumber";
    private String tableName = "PhoneNumberTable";

    public PhoneNumberTable() {
    }

    public PhoneNumberTable(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + tableName + "(" +

                phoneNumber + " VARCHAR(50) " +
                ")";
        sqLiteDatabase.execSQL(sql);
    }

    public PhoneNumberTable(String phoneNumber) {
        this.phoneNumber=phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
