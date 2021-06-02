package com.example.fracku.samplesqldatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText inPut;
    Button addBut, delBut;
    Handler Handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inPut = findViewById(R.id.inPut);
        addBut = findViewById(R.id.addBut);
        delBut = findViewById(R.id.delBut);
        Handler = new Handler(this, null, null, 1);
        printDatabase();
    }

    public void printDatabase(){
        String dbString = Handler.dbtostring();
        inPut.setText(dbString);
    }
    public void adentry(View view){
        sqldata1 entry = new sqldata1(inPut.getText().toString());
        Handler.addentry(entry);
        printDatabase();
    }
    public void deentry(View view){
        String outPut = inPut.getText().toString();
        Handler.delentry(outPut);
        printDatabase();
    }
}
