package com.example.kaka.habittracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);

        Log.d("Insert: ", "Inserting ...");
        databaseHandler.addContact(new Habits("Waking up in the morning.", "6"));
        databaseHandler.addContact(new Habits("Making your bed.", "3"));

        Log.d("Reading: ", "Reading all habbits ...");
        List<Habits> habitsList = databaseHandler.getAllHabits();

        for (Habits hb : habitsList) {
            String log = "ID: " + hb.get_id() + " ,Habbit Name: " + hb.get_habitName()
                    + " ,Habbit Counter: " + hb._noOfTimesPerformed;
            Log.d("Name: ", log);
        }

    }
}
