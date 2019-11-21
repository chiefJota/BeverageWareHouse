package com.jthissel.beveragewarehouse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jthissel.beveragewarehouse.alcBevDbSchema.alcBeverageTable;


public class alcoholBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "beverages.db";

    public alcoholBaseHelper (Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + alcBeverageTable.NAME + "(" +
                        "_id integer primary key autoincrement," +
                        alcBeverageTable.Cols.UUID + ", " +
                        alcBeverageTable.Cols.NAME + "," +
                        alcBeverageTable.Cols.FILENAME + "," +
                        alcBeverageTable.Cols.MANUFACTURERORIGIN + "," +
                        alcBeverageTable.Cols.ALCCONTENT + "," +
                        alcBeverageTable.Cols.PRICE + "," +
                        alcBeverageTable.Cols.DESCRIPTION + ")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }


}

