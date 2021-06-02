package com.example.fracku.samplesqldatabase;

public class sqldata1 {

    //Input table columns

    private int _id;
    private String _label1;

    public sqldata1(){}

    public sqldata1(String label1) {
        this._label1 = label1;
    }
    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }
    public String get_label1() {
        return _label1;
    }
    public void set_label1(String _label1) {
        this._label1 = _label1;
    }


}
