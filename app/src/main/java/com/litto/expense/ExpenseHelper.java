package com.litto.expense;

import android.content.Context;
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

    public ExpenseHelper(Context context) {
        super(context, DB_NAME, null , DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE main.expense " +
                "(_id INTEGER PRIMARY KEY, " +
                "cdate DATETIME NOT NULL, " +
                "info VARCHAR, " +
                "amount INTEGER)");
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
