package com.example.test.Lists;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.Adapters.Expense_Adapters;
import com.example.test.Adapters.Income_adapter;
import com.example.test.DbHelpers.DatabaseHelper1;
import com.example.test.Model.Expense_Model;
import com.example.test.Model.Income_Model;
import com.example.test.R;

import java.util.ArrayList;

public class Expenses_List extends AppCompatActivity {

    private static double sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses__list);

        DatabaseHelper1 myDb1;
        sum=0.0;
        myDb1=new DatabaseHelper1(this);
        Cursor res1 = myDb1.getAllData();

        ArrayList<Expense_Model> expense_model=new ArrayList<Expense_Model>();

        while(res1.moveToNext())
        {
            expense_model.add(new Expense_Model(res1.getString(0),res1.getString(1),
                    res1.getDouble(2),res1.getInt(3)));
            sum=sum+res1.getDouble(2);


        }
        Expense_Adapters exp_adpt = new Expense_Adapters(this,expense_model);
        ListView listView = (ListView)findViewById(R.id.expenses_list_1);

        listView.setAdapter(exp_adpt);

        Toast.makeText(getBaseContext(),String.valueOf(sum),Toast.LENGTH_LONG).show();
        TextView totalexp = (TextView)findViewById(R.id.total_Exp);
        totalexp.setText(String.valueOf(sum));


    }
}
