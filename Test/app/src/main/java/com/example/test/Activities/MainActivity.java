package com.example.test.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.test.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private TextView expenses;
    private TextView Income;
    private TextView Savings;
    private TextView Expense_List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expenses=(TextView)findViewById(R.id.expenses);
        Income=(TextView)findViewById(R.id.income);
        Savings=(TextView)findViewById(R.id.savings);
        Expense_List=(TextView)findViewById(R.id.expense_list);

        expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent expenseIntent = new Intent(MainActivity.this,Expenses_Activity.class);
                startActivity(expenseIntent);
            }
        });

        Income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent incomeIntent = new Intent(MainActivity.this,Income_Activity.class);
                startActivity(incomeIntent);
            }
        });
        Savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent savingsIntent = new Intent(MainActivity.this,Savings_Activity.class);
                startActivity(savingsIntent);
            }
        });
        Expense_List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(MainActivity.this,List_Activity.class);
                startActivity(listIntent);
            }
        });






    }
}