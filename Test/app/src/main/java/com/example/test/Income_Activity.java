package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Income_Activity extends AppCompatActivity {

    private EditText sources;
    private EditText text;
    private Button savebut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        sources=(EditText)findViewById(R.id.sources);
        text=(EditText)findViewById(R.id.value);
        savebut=(Button)findViewById(R.id.saveButton);

        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),sources.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });





    }
}
