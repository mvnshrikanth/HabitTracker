package com.example.kaka.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Kaka on 2/13/2017.
 */

public class HabitsContract {

    private HabitsContract() {
    }

    public static final class HabbitEntry implements BaseColumns {
        public final static String TABLE_NAME = "habits";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT_NAME = "name";
        public final static String COLUMN_NO_OF_TIMES_PERFORMED = "no_of_times_performed";
    }
}
