package com.amarokasia.insurance_plan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;


public class HistoryActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        registerClickCallback();
        myDb = new DatabaseHelper(this);
        getAllData();
    }


    public void getAllData(){
        Cursor result = myDb.getAllData();
        ArrayList<String> historyList = new ArrayList<>();
        ListView listView = findViewById(R.id.ListView);


        if (result.getCount() == 0){
            //no data inside the table
            showMessage("Error", "No Data found");

            return;
        }else{
            StringBuffer buffer = new StringBuffer();
            while (result.moveToNext()){
                historyList.add(result.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,historyList);
                listView.setAdapter(listAdapter);
            }
        }
    }

    public void showMessage(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

    private void registerClickCallback(){
        ListView listView = findViewById(R.id.ListView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                String msg = "Clicked on "+position+" ID :"+textView.getText();

                Cursor result = myDb.getSpecificData(textView.getText().toString());

                if (result.getCount() == 0){
                    //no data inside the table
                    showMessage("Error", "No Data found");

                    return;
                }else{
                    StringBuffer buffer = new StringBuffer();
                    while (result.moveToNext()){
                        buffer.append("ID : "+result.getString(0)+"\n");
                        buffer.append("Income : "+result.getString(1)+"\n");
                        buffer.append("Bill : "+result.getString(2)+"\n");
                        buffer.append("Rental : "+result.getString(3)+"\n");
                        buffer.append("Medical : "+result.getString(4)+"\n");
                        buffer.append("Loan : "+result.getString(5)+"\n");
                        buffer.append("Installment : "+result.getString(6)+"\n");
                        buffer.append("Plan : "+result.getString(7));
                    }
                    showMessage("Data",buffer.toString());
                }


            }
        });
    }

}
