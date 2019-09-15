package com.example.myapplication;

import com.example.myapplication.FactionSchema.FactionTable;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FactionDbHelper extends SQLiteOpenHelper
{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "factions.db";

    public FactionDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + FactionTable.NAME + "(" +
                FactionTable.Cols.ID + " INTEGER, " +
                FactionTable.Cols.NAME + " TEXT, " +
                FactionTable.Cols.STRENGTH + " INTEGER, " +
                FactionTable.Cols.RELATIONSHIP + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
