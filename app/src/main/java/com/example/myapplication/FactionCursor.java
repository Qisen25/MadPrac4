package com.example.myapplication;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.example.myapplication.FactionSchema.FactionTable;

public class FactionCursor extends CursorWrapper
{
    public FactionCursor(Cursor cursor)
    {
        super(cursor);
    }

    public Faction getFaction()
    {
        int id = getInt(getColumnIndex(FactionTable.Cols.ID));
        String name = getString(getColumnIndex(FactionTable.Cols.NAME));
        int strength = getInt(getColumnIndex(FactionTable.Cols.STRENGTH));
        int relation = getInt(getColumnIndex(FactionTable.Cols.RELATIONSHIP));

        return new Faction(id, name, strength, relation);
    }
}
