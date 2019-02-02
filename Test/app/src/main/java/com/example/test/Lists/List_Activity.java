package com.example.test.Lists;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.test.Adapters.Income_adapter;
import com.example.test.DbHelpers.DatabaseHelper;
import com.example.test.Model.Income_Model;
import com.example.test.R;

import java.util.ArrayList;

public class List_Activity extends AppCompatActivity {
    private static Double sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);
        DatabaseHelper myDb;
        sum=0.0;
        myDb = new DatabaseHelper(this);

        Cursor res = myDb.getAllData();

        ArrayList<Income_Model>income_model=new ArrayList<Income_Model>();

        while(res.moveToNext())
        {
            income_model.add(new Income_Model(res.getString(0),res.getString(1),res.getDouble(2)));
            sum = sum + res.getDouble(2);
        }
        Income_adapter inc_adpt = new Income_adapter(this,income_model);
        ListView listView = (ListView)findViewById(R.id.income_ListView);
        listView.setAdapter(inc_adpt);

        TextView totexp= (TextView)findViewById(R.id.total_Exp);
        totexp.setText(String.valueOf(sum));
    }
}
