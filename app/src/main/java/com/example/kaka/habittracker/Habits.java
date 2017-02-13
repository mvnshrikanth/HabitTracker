package com.example.kaka.habittracker;

/**
 * Created by Kaka on 2/12/2017.
 */

public class Habits {

    int _id;
    String _habitName;
    String _noOfTimesPerformed;

    public Habits() {
    }

    public Habits(int _id,
                  String _habitName,
                  String _noOfTimesPerformed) {
        this._id = _id;
        this._habitName = _habitName;
        this._noOfTimesPerformed = _noOfTimesPerformed;
    }

    public Habits(String _habitName,
                  String _noOfTimesPerformed) {
        this._habitName = _habitName;
        this._noOfTimesPerformed = _noOfTimesPerformed;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_noOfTimesPerformed() {
        return _noOfTimesPerformed;
    }

    public void set_noOfTimesPerformed(String _noOfTimesPerformed) {
        this._noOfTimesPerformed = _noOfTimesPerformed;
    }

    public String get_habitName() {
        return _habitName;
    }

    public void set_habitName(String _habitName) {
        this._habitName = _habitName;
    }
}
