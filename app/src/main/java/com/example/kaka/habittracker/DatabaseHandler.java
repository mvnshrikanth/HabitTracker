package com.example.kaka.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaka on 2/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "habitTracker";

    private static final String TABLE_HABITS = "habits";

    private static final String KEY_ID = "id";
    private static final String KEY_HABIT_NAME = "habitName";
    private static final String KEY_NOOFTIMESPERFORMED = "noOfTimesPerformed";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_HABIT_TABLE = "CREATE TABLE " + TABLE_HABITS + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_HABIT_NAME
                + " TEXT ," + KEY_NOOFTIMESPERFORMED + " INTEGER " + ")";

        db.execSQL(CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HABITS);

        onCreate(db);
    }

    public void addContact(Habits habits) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_HABIT_NAME, habits._habitName);
        contentValues.put(KEY_NOOFTIMESPERFORMED, habits._noOfTimesPerformed);

        db.insert(TABLE_HABITS, null, contentValues);
        db.close();
    }

    public int updateHabit(Habits habits) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_HABIT_NAME, habits.get_habitName());
        contentValues.put(KEY_NOOFTIMESPERFORMED, habits.get_noOfTimesPerformed());

        return db.update(TABLE_HABITS, contentValues, KEY_ID + " = ?", new String[]{String.valueOf(habits.get_id())});
    }

    public List<Habits> getAllHabits() {
        List<Habits> habitsList = new ArrayList<Habits>();

        String selectQuery = "SELECT * FROM " + TABLE_HABITS;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Habits habits = new Habits();
                habits.set_id(Integer.parseInt(cursor.getString(0)));
                habits.set_habitName(cursor.getString(1));
                habits.set_noOfTimesPerformed(cursor.getString(2));
                habitsList.add(habits);
            } while (cursor.moveToNext());
        }
        return habitsList;
    }

    public void deleteHabit(Habits habits) {
        SQLiteDatabase db = getWritableDatabase();

        db.delete(TABLE_HABITS, KEY_ID + " = ?", new String[]{String.valueOf(habits.get_id())});
    }

}
