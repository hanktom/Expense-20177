package com.litto.expense;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hank on 2017/7/1.
 */

public class ExpenseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "expense.db";
    private static final int DB_VERSION = 1;
    private static final String TAG = ExpenseHelper.class.getSimpleName();
    public static final String CREATE_EXPENSE_SQL = "CREATE TABLE " + ExpenseContract.TABLE_EXPENSE +
            "(" + ExpenseContract.COL_ID + " INTEGER PRIMARY KEY, " +
            ExpenseContract.COL_DATE + " DATETIME NOT NULL, " +
            ExpenseContract.COL_INFO + " VARCHAR, " +
            ExpenseContract.COL_AMOUNT + " INTEGER)";
    private Resources resources;
    private Context context;

    public ExpenseHelper(Context context) {
        super(context, DB_NAME, null , DB_VERSION);
        this.context = context;
        resources = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EXPENSE_SQL);
        Log.d(TAG, "onCreate: ");
        readExpensesFromResources(db);
    }

    private void readExpensesFromResources(SQLiteDatabase db) {
        InputStream inputStream = resources.openRawResource(R.raw.expenses);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        try {
            String line = in.readLine();
            while( line != null){
                sb.append(line);
                line = in.readLine();
            }
            // collected all json string
            Log.d(TAG, "readExpensesFromResources: " + sb.toString());
            JSONObject json = new JSONObject(sb.toString());
            JSONArray expenses = json.getJSONArray(context.getString(R.string.key_expenses));
            for (int i=0; i<expenses.length(); i++){
                JSONObject exp = expenses.getJSONObject(i);
                String cdate = exp.getString(context.getString(R.string.key_cdate));
                String info = exp.getString(context.getString(R.string.key_info));
                int amount = exp.getInt(context.getString(R.string.key_amount));
                // put them into ContentValues
                ContentValues values = new ContentValues();
                values.put(ExpenseContract.COL_DATE, cdate);
                values.put(ExpenseContract.COL_INFO, info);
                values.put(ExpenseContract.COL_AMOUNT, amount);
                long id = db.insert(
                        ExpenseContract.TABLE_EXPENSE, null, values);
                if (id != -1){

                }else{

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
