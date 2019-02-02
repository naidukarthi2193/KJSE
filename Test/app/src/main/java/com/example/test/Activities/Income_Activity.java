package com.example.test.Activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.DbHelpers.DatabaseHelper;
import com.example.test.R;

public class Income_Activity extends AppCompatActivity {

    private EditText sources;
    private EditText text;
    private Button savebut;
    double values;
    DatabaseHelper myDb;
    Button btnviewAll;
    double sum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_income);
        sources=(EditText)findViewById(R.id.sources);
        text=(EditText)findViewById(R.id.value);
        myDb = new DatabaseHelper(this);
        savebut=(Button)findViewById(R.id.saveButton);
        btnviewAll=(Button)findViewById(R.id.button_viewAll);
        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted = myDb.insertData(sources.getText().toString(),values=Double.parseDouble(text.getText().toString()));
                if(isInserted == true)
                    Toast.makeText(getBaseContext(),"Data is Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(),"Data is Not Inserted",Toast.LENGTH_LONG).show();
            }
        });

        viewAll();



    }


    public void viewAll()
    {
        btnviewAll.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0)
                        {
                            //show message error
                            showMessage("Error404","No Data Found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext())
                        {
                            buffer.append("Id : " + res.getString(0) + "\n");
                            buffer.append("Sources : " + res.getString(1) + "\n");
                            buffer.append("Values : " + res.getDouble(2) + "\n\n");
                            sum = sum + res.getDouble(2);
                        }
                        //show all data
                        showMessage("Data",buffer.toString());
                        Toast.makeText(getBaseContext(),"Total Value is " + sum,Toast.LENGTH_LONG).show();
                    }
                }
        );

    }

    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
