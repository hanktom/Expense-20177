package com.litto.expense;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
//    private Context context;

    public ExpenseHelper(Context context) {
        super(context, DB_NAME, null , DB_VERSION);
//        this.context = context;
        resources = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EXPENSE_SQL);
        Log.d(TAG, "onCreate: ");
        readExpensesFromResources(db);
    }

    private void readExpensesFromResources(SQLiteDatabase db) {
//        resources.raw
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
