package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Expenses_Activity extends AppCompatActivity {

    private Spinner listspinner;
    ArrayAdapter<CharSequence> adapter;
    static int prio;
    static int Values;
    private EditText expenseName;
    private EditText expensevalues;
    private Button addDatabut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);
        listspinner=(Spinner)findViewById(R.id.spinnerList);
        expenseName=(EditText)findViewById(R.id.Sources);
        expensevalues=(EditText)findViewById(R.id.expenses_values);
        addDatabut=(Button)findViewById(R.id.saveButton);




        adapter=ArrayAdapter.createFromResource(this,R.array.expense_list,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listspinner.setAdapter(adapter);

        listspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prio=position;
                Toast.makeText(getBaseContext(),parent.getItemIdAtPosition(position)+"",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addDatabut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Values = Integer.parseInt(expensevalues.getText().toString());


            }
        });



    }



}
