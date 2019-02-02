package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.xml.transform.Source;

public class DatabaseHelper1 extends SQLiteOpenHelper {

    public static final String Database_Name = "EXPENSE.db";
    public static final String Table_Name = "EXPENSE_TABLE";
    public static final String Col_1 = "ID";
    public static final String COl_2 = "SOURCES";
    public static final String Col_3 = "VALUE";


    public DatabaseHelper1(Context context) {
        super(context, Database_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db1) {
        db1.execSQL("create table " + Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,SOURCES TEXT,VALUE DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + Table_Name);
        onCreate(db);
    }

    public Boolean insertData(String source, double values)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl_2, source);

        contentValues.put(Col_3,values);
        long result = db.insert(Table_Name, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+Table_Name,null);
        return res;
    }

    public Cursor getAllSortedData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery( "SELECT  * FROM " + WORD_LIST_TABLE +
                " ORDER BY " + KEY_WORD + " ASC " +
                "LIMIT " + position + ",1";


        return res;
    }

    public Boolean updateData(String id,String name, double values)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,id);
        contentValues.put(COl_2,name);
        contentValues.put(Col_3,values);

        db.update(Table_Name,contentValues,"ID = ?",new String[] { id });
        return true;
    }

    public Integer DeleteData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(Table_Name,"ID = ?",new String[] { id });
    }
}
