package com.example.gopi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.*;


public class database extends SQLiteOpenHelper {
    SQLiteDatabase sqLiteDatabase;
    public database(Context context) {
        super(context, "test", null, 1);                                               //database name
        sqLiteDatabase=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table ttable(name text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long savee(String s1)
    {
        ContentValues cv=new ContentValues();
        cv.put("name",s1);
        long a =sqLiteDatabase.insert("ttable",null,cv);
        return a;
    }

    public void getdata(String name){
//        String s;
//
//        Cursor c=sqLiteDatabase.query("ttable","name","name=?",new String[ ] {name},null,null);
//        if (c.getCount() < 1) {
//            return "not exist";
//        }
//        c.moveToFirst();
//        s=c.getColumnIndex("name");
//        return s;
    }
    public List<String>   getAllNote(){
        List<String> notes=new ArrayList<>();

        //select all query
        String selectQuery="select name from ttable ";
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);

        //looping through all the rows and adding too list
        if(cursor.moveToFirst()){
            do{
                String note=new String();
                note=cursor.getString(cursor.getColumnIndex("name"));
                notes.add(note);


            }while (cursor.moveToNext());
        }
sqLiteDatabase.close();
return notes;


    }

}
