package com.login_page.hp.calllog;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Call log";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    Integer phone_number, duration_of_call, date_of_call, type_of_call;
    String number,type,duration,dateString,date ;
    String call_type = "";
    Date d;

    callLog call_log;
    ArrayList<callLog> al = new ArrayList<callLog>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        Cursor cursor = managedQuery(CallLog.Calls.CONTENT_URI,
                null,null,null,null);

        phone_number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
        type_of_call = cursor.getColumnIndex(CallLog.Calls.TYPE);
        duration_of_call = cursor.getColumnIndex(CallLog.Calls.DURATION);
        date_of_call = cursor.getColumnIndex(CallLog.Calls.DATE);
        Date d=new Date(date_of_call);


        while (cursor.moveToNext()){

            number = cursor.getString(phone_number);
            type = cursor.getString(type_of_call);
            dateString = cursor.getString(date_of_call);
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "dd-MMM-yyyy HH:mm");
            date = formatter.format(new Date(Long
                    .parseLong(dateString)));
            Log.e("AAAAAAa",""+date);
            duration = cursor.getString(duration_of_call);


            switch (parseInt(type)){
                case CallLog.Calls.OUTGOING_TYPE:
                    call_type = "OUTGOING CALL";
                    break;

                case CallLog.Calls.INCOMING_TYPE:
                    call_type = "INCOMING CALL";
                    break;

                case CallLog.Calls.MISSED_TYPE:
                    call_type = "MISSED CALL";
                    break;

            }

            call_log = new callLog(number,call_type,date,duration);
            al.add(call_log);
        }

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new RecyclerAdapter(al,getApplicationContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
   }
}
