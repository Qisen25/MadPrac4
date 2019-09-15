package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.myapplication.FactionSchema.FactionTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Maintains the overall dataset; specifically of course all the different factions.
 */
public class FactionList
{
    private List<Faction> factions = new ArrayList<>();
    private SQLiteDatabase db;
    private FactionCursor cursor;

    public FactionList() { }

    public void load(Context context)
    {
        this.db = new FactionDbHelper(context.getApplicationContext()).getWritableDatabase();
        cursor = new FactionCursor(db.query(FactionTable.NAME, null, null, null,
                null, null, null, null));
        try
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                factions.add(cursor.getFaction()); //get faction stored in database
                cursor.moveToNext();
            }
        }
        finally
        {
            cursor.close();
        }
    }

    public int size()
    {
        return factions.size();
    }

    public Faction get(int i)
    {
        return factions.get(i);
    }

    public int add(Faction newFaction)
    {
        factions.add(newFaction);

        ContentValues cv = new ContentValues();
        cv.put(FactionTable.Cols.ID, newFaction.getId());
        cv.put(FactionTable.Cols.NAME, newFaction.getName());
        cv.put(FactionTable.Cols.STRENGTH, newFaction.getStrength());
        cv.put(FactionTable.Cols.RELATIONSHIP, newFaction.getRelationship());
        db.insert(FactionTable.NAME, null, cv);

        return factions.size() - 1; // Return insertion point
    }

    public void edit(Faction newFaction)
    {
        ContentValues cv = new ContentValues();
        cv.put(FactionTable.Cols.ID, newFaction.getId());
        cv.put(FactionTable.Cols.NAME, newFaction.getName());
        cv.put(FactionTable.Cols.STRENGTH, newFaction.getStrength());
        cv.put(FactionTable.Cols.RELATIONSHIP, newFaction.getRelationship());

        String[] where = { String.valueOf(newFaction.getId()) };

        db.update(FactionTable.NAME, cv, FactionTable.Cols.ID + " = ?", where);
    }

    public void remove(Faction rmFaction)
    {
        factions.remove(rmFaction);

        String[] where = { String.valueOf(rmFaction.getId()) };
        db.delete(FactionTable.NAME, FactionTable.Cols.ID + " = ? ", where);
    }
}
