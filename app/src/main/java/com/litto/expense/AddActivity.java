package com.litto.expense;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText edDate;
    private EditText edAmount;
    private EditText edInfo;
    private ExpenseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edDate = (EditText) findViewById(R.id.ed_date);
        edAmount = (EditText) findViewById(R.id.ed_amount);
        edInfo = (EditText) findViewById(R.id.ed_info);
        helper = new ExpenseHelper(this);
    }

    public void add(View v){
        String date = edDate.getText().toString();
        int amount = Integer.parseInt(edAmount.getText().toString());
        String info = edInfo.getText().toString();
        ContentValues values = new ContentValues();
        values.put("cdate", date);
        values.put("amount", amount);
        values.put("info", info);
        long id = helper.getWritableDatabase().insert("expense", null, values);
        if (id != -1 ){
            //TODO: if insert successful
        }
    }
}
