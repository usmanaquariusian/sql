package com.example.usmanahmed.innovaday6sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usman Ahmed on 23/10/2017.
 */

public class DatabaseClass extends SQLiteOpenHelper
{
    static final String Database_name="myDatabase.db";
    static final String table_Name="mytable";

    public DatabaseClass(Context context) {
        super(context, Database_name, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase object)
    {
        object.execSQL("create table "+table_Name+" (id int,username text,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase object, int oldVersion, int newVersion) {
        object.execSQL("drop table if exists"+table_Name+";");

        onCreate(object);

    }

    public  long insertData(int id, String username, String password)
    {
        SQLiteDatabase myobject=this.getWritableDatabase();
        ContentValues values=new ContentValues();
                values.put("id",id);
                values.put("username",username);
                values.put("password",password);
        long result=myobject.insert(table_Name,null,values);

        return result;
    }//insert data here
    public boolean checkCredentials(String username,String password)
    {
        SQLiteDatabase databaseobject=this.getReadableDatabase();

        Cursor res= databaseobject.rawQuery("select* from "+table_Name+" where username='"+username+"' and password='"+password+"'",null);
       int noOfRecords=0;
        res.moveToFirst();
        while (res.isAfterLast()==false)
        {
            noOfRecords++;
            res.moveToNext();
        }
        databaseobject.close();
        boolean result=false;
        if (noOfRecords>0)
            result=true;
        else
            result=false;
        return result;
    }//get data
    public String getAllUserData()
    {
        SQLiteDatabase databaseobject=this.getReadableDatabase();

        Cursor res= databaseobject.rawQuery("select* from "+table_Name,null);
        String allRecords="";
        res.moveToFirst();
        while (res.isAfterLast()==false)
        {
            allRecords+="\n ID:"+res.getString(res.getColumnIndex("id"));
            allRecords+="\n Username:"+res.getString(res.getColumnIndex("username"));
            allRecords+="\n Password:"+res.getString(res.getColumnIndex("password"));
            res.moveToNext();
        }
        databaseobject.close();


        return allRecords;
    }//get data
}
