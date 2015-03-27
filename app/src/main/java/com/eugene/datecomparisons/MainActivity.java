package com.eugene.datecomparisons;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;


public class MainActivity extends ActionBarActivity {

    private Date mDate = new Date(); // Returns Current Date

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsById();
        handleDateChanges(mDate); // called to set text to current date

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDateChanges(DateCompare.previousDate(mDate)); // Date -1
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDateChanges(DateCompare.nextDate(mDate)); //Date +1
            }
        });
    }

    private TextView txtDateChange, txtToday;
    private Button btnPrevious, btnNext;

    private void findViewsById() {
        txtDateChange = (TextView) findViewById(R.id.txtDateChange);
        txtToday = (TextView) findViewById(R.id.txtToday);
        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnNext = (Button) findViewById(R.id.btnNext);
    }

    private void handleDateChanges(Date date) {
        txtToday.setText("Current Date: " + DateFormat.format("MMM d, EE", mDate)); // Displays Current Date, doesn't change

        if (DateCompare.areDatesEqual(mDate, date)) { // Are Dates Equal Today
            txtDateChange.setText("Today  " + DateFormat.format("MMM d, EE", date));
        } else if (DateCompare.areDatesEqualYesterday(mDate, date)) {  // Are Dates Equal Yesterday
            txtDateChange.setText("Yesterday  " + DateFormat.format("MMM d, EE", date));
        } else if (DateCompare.areDatesEqualTomorrow(mDate, date)) {  // Are Dates Equal Yesterday
            txtDateChange.setText("Tomorrow  " + DateFormat.format("MMM d, EE", date));
        } else {
            txtDateChange.setText(DateFormat.format("MMM d, EE", date));
        }
    }
    // MMMM = Month(long); October
    // MMM = Month(short); Oct
    // d = day of month; 21
    // EE = day of week(short) Mon
    // EEE = Month(long); Monday
}
