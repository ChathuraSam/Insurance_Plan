package com.amarokasia.insurance_plan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "calc_history.db";
    public  static  final String TABLE_NAME = "calc_table";
    public  static  final  String ID = "id";
    public  static  final  String INCOME = "income" ;
    public  static  final  String BILL = "bill";
    public  static  final  String RENTAL = "rental";
    public  static  final  String MEDICAL = "medical";
    public  static  final  String LOAN = "loan";
    public  static  final  String INSTALLMENT = "installment";
    public  static  final  String PLANN = "plann";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("create table "+TABLE_NAME+"("+
                ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                INCOME+" DOUBLE,"+
                BILL+" DOUBLE,"+
                RENTAL+" DOUBLE,"+
                MEDICAL+" DOUBLE,"+
                LOAN+" DOUBLE,"+
                INSTALLMENT+" DOUBLE,"+
                PLANN+" DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(double income, double bill, double rental, double medical, double loan, double installment, double plan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INCOME,income);
        contentValues.put(BILL,bill);
        contentValues.put(RENTAL,rental);
        contentValues.put(MEDICAL,medical);
        contentValues.put(LOAN,loan);
        contentValues.put(INSTALLMENT,installment);
        contentValues.put(PLANN,plan);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result==-1){
            return false;
        }else{
            return  true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+TABLE_NAME+" order by id desc limit 5 ", null);
        return  result;
    }

    public  Cursor getSpecificData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+TABLE_NAME+" where "+ID+"= "+id+" ", null);
        return  result;
    }
}
