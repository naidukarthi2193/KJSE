package com.example.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Income_Activity extends AppCompatActivity {

    private EditText sources;
    private EditText text;
    private Button savebut;
    double values;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_income);
        sources=(EditText)findViewById(R.id.sources);
        text=(EditText)findViewById(R.id.value);
        myDb = new DatabaseHelper(this);
        savebut=(Button)findViewById(R.id.saveButton);

        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"hello",Toast.LENGTH_LONG).show();
                boolean isInserted = myDb.insertData(sources.getText().toString(),values=Double.parseDouble(text.getText().toString()));
                if(isInserted == true)
                    Toast.makeText(getBaseContext(),"Data is Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(),"Data is Not Inserted",Toast.LENGTH_LONG).show();
            }
        });





    }
}
