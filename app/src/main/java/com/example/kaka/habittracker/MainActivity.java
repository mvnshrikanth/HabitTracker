package com.example.kaka.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.kaka.habittracker.data.HabitDbHelper;
import com.example.kaka.habittracker.data.HabitsContract;

public class MainActivity extends AppCompatActivity {
    HabitDbHelper habitDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        habitDbHelper = new HabitDbHelper(this);

        Log.d("Adding: ", "Adding dummy data ...");
        addData();
        Log.d("Reading: ", "Reading all habbits after adding dummy data ...");
        readData();

        Log.d("Updating data: ", "Updating habit #1...");
        habitDbHelper.updateHabit("1", "Testing an update", "3");
        Log.d("Reading: ", "Reading all habbits after update ...");
        readData();
        Log.d("Deleting: ", "Deleting all habbits ...");
        habitDbHelper.deleteAllHabit();
    }

    private void readData() {
        habitDbHelper = new HabitDbHelper(this);
        Log.d("Reading: ", "Reading all habbits ...");
        Cursor cursorHabits = habitDbHelper.getAllHabits();

        while (cursorHabits.moveToNext()) {
            String log = "ID: " + cursorHabits.getString(cursorHabits.getColumnIndex(HabitsContract.HabbitEntry._ID))
                    + " ,Habbit Name: " + cursorHabits.getString(cursorHabits.getColumnIndex(HabitsContract.HabbitEntry.COLUMN_HABIT_NAME))
                    + " ,Habbit Counter: " + cursorHabits.getString(cursorHabits.getColumnIndex(HabitsContract.HabbitEntry.COLUMN_NO_OF_TIMES_PERFORMED));
            Log.d("Name: ", log);
        }
        cursorHabits.close();
    }

    public void addData() {
        habitDbHelper = new HabitDbHelper(this);

        Log.d("Insert: ", "Inserting ...");
        habitDbHelper.addContact("Waking up in the morning.", "6");
        habitDbHelper.addContact("Making your bed.", "3");
    }

}
