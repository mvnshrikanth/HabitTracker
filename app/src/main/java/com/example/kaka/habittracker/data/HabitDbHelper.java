package com.example.kaka.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kaka.habittracker.data.HabitsContract.HabbitEntry;

/**
 * Created by Kaka on 2/13/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habits.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + HabbitEntry.TABLE_NAME + "("
                + HabbitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabbitEntry.COLUMN_HABIT_NAME + " TEXT ,"
                + HabbitEntry.COLUMN_NO_OF_TIMES_PERFORMED + " INTEGER DEFAULT 0);";

        db.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HabbitEntry.TABLE_NAME);

        onCreate(db);
    }


    public void addContact(String _habitName, String _noOfTimesPerformed) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(HabbitEntry.COLUMN_HABIT_NAME, _habitName);
        contentValues.put(HabbitEntry.COLUMN_NO_OF_TIMES_PERFORMED, _noOfTimesPerformed);

        db.insert(HabbitEntry.TABLE_NAME, null, contentValues);
        db.close();
    }

    public void updateHabit(String id, String habitName, String noOfTimesPerformed) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(HabbitEntry.COLUMN_HABIT_NAME, habitName);
        contentValues.put(HabbitEntry.COLUMN_NO_OF_TIMES_PERFORMED, noOfTimesPerformed);

        db.update(HabbitEntry.TABLE_NAME, contentValues, HabbitEntry._ID + " = ?", new String[]{id});
        db.close();
    }

    public Cursor getAllHabits() {
        String selectQuery = "SELECT * FROM " + HabbitEntry.TABLE_NAME;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        return cursor;
    }

    public void deleteAllHabit() {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("DELETE FROM " + HabbitEntry.TABLE_NAME);
        db.close();
    }

}
