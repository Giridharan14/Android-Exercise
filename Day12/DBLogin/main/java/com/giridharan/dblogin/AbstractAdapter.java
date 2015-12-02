package com.giridharan.dblogin;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class AbstractAdapter {
    protected static final String TAG = "Adapter";
    protected DatabaseHelper mDbHelper;
    protected SQLiteDatabase mDb;
    protected static final String DATABASE_NAME = "Sample.db";
    protected static final int DATABASE_VERSION = 1;

    protected final Context mCtx;

    protected static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String EmpRegister = "CREATE TABLE IF NOT EXISTS "
                + RegisterAdapter.TABLENAME
                + "(" + RegisterAdapter.UName + " TEXT,"
                 + RegisterAdapter.Passwordi + " TEXT);";

       /* private static final String STUDREgister = "CREATE TABLE IF NOT EXISTS "
                + StudRegAdapter.TABLENAME
                + "("
                + StudRegAdapter.SNAME
                + " TEXT,"
                + StudRegAdapter.SPHONE
                + " TEXT,"
                + StudRegAdapter.SMAIL + " TEXT);";  */

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(EmpRegister);

            //     db.execSQL(STUDREgister);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS routes");
            onCreate(db);
        }
    }

    public AbstractAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public AbstractAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

}
