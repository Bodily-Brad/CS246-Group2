package edu.byui.cs246.cs246_09_04;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bradb on 11/9/2015.
 */
public class CounterOpenHelper extends SQLiteOpenHelper {
    // CONSTANTS & SETTINGS
    private static final int DATABASE_VERSION = 1;
    private static final String DICTIONARY_TABLE_NAME = "count";
    private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + DICTIONARY_TABLE_NAME + " (" +
                    "COUNT" + " INT NOT NULL);";

    // CONSTRUCTORS
    public CounterOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // METHODS
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Doesn't do anything at the moment
    }
}
