package com.litto.expense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText edDate;
    private EditText edAmount;
    private EditText edInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edDate = (EditText) findViewById(R.id.ed_date);
        edAmount = (EditText) findViewById(R.id.ed_amount);
        edInfo = (EditText) findViewById(R.id.ed_info);
    }

    public void add(View v){
        String date = edDate.getText().toString();
        int amount = Integer.parseInt(edAmount.getText().toString());
        String info = edInfo.getText().toString();

    }
}
