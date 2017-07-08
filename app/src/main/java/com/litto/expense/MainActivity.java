package com.litto.expense;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ADD = 100;
    private SimpleCursorAdapter adapter;
    private ExpenseHelper helper;
    private ListView list;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(
                        new Intent(MainActivity.this, AddActivity.class),
                        REQUEST_ADD);
            }
        });
        helper = new ExpenseHelper(this);
        Cursor cursor = helper.getReadableDatabase().query(
                ExpenseContract.TABLE_EXPENSE,
                null, null, null, null, null, null);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter();
//        setupListView(cursor);
    }

    private void setupListView(Cursor cursor) {
        list = (ListView) findViewById(R.id.list);
        adapter = new SimpleCursorAdapter(
                this,
//                android.R.layout.simple_list_item_2,
                R.layout.expense_row,
                cursor,
                new String[]{"cdate", "info"},
//                new int[]{android.R.id.text1, android.R.id.text2}
                new int[]{R.id.col_cdate, R.id.col_info}
                , 1);
        list.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO: problem
        /*
        Cursor cursor = helper.getReadableDatabase().query(
                ExpenseContract.TABLE_EXPENSE,
                null, null, null, null, null, null);
        adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                cursor,
                new String[]{"cdate", "info"},
                new int[]{android.R.id.text1, android.R.id.text2}
                , 1);
        list.setAdapter(adapter);
        */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }

    }
}
