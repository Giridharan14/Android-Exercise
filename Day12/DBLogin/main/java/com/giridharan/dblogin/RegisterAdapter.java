package com.giridharan.dblogin;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;

import java.sql.SQLException;

public class RegisterAdapter extends AbstractAdapter implements BaseColumns {

    public RegisterAdapter(Context ctx) {
        super(ctx);
    }

    public static final String TABLENAME = "EmployeeREG";
    public static final String UName = "Name";
    public static final String Passwordi= "Password";



    Cursor mCursor;

    public long insert(String Name,String Password) {
        ContentValues args = new ContentValues();

        args.put(UName, Name);
        args.put(Passwordi, Password);
        return mDb.insert(TABLENAME, null, args);

    }

    public Cursor fetch() throws SQLException {

        String selectquery = "Select * from " + TABLENAME + ";";

        mCursor = mDb.rawQuery(selectquery, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;


    }


}
