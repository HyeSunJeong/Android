
package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Button btn_Start,btn_Stop;
    Chronometer chronometer1;
    RadioButton rdo_Cal, rdo_Time;
    CalendarView calendarView;
    TimePicker timePicker;
    TextView txt_Year, txt_Month,txt_Hour,txt_Minute, txt_Date;
    Integer cal_Year, cal_Month, cal_Date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Start = (Button) findViewById(R.id.btn_Start);
        btn_Stop = (Button) findViewById(R.id.btn_Stop);
        chronometer1 = (Chronometer) findViewById(R.id.chronometer1);
        rdo_Cal = (RadioButton) findViewById(R.id.rdo_Cal);
        rdo_Time = (RadioButton) findViewById(R.id.rdo_Time);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        txt_Year = (TextView) findViewById(R.id.txt_Year);
        txt_Month = (TextView) findViewById(R.id.txt_Month);
        txt_Hour = (TextView) findViewById(R.id.txt_Hour);
        txt_Date = (TextView)findViewById(R.id.txt_Date);
        txt_Minute = (TextView) findViewById(R.id.txt_Minute);

        timePicker.setVisibility(View.INVISIBLE);
        calendarView.setVisibility(View.INVISIBLE);

        rdo_Cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });
        rdo_Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });

        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.start();
            }
        });
        btn_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer1.stop();

                txt_Year.setText(Integer.toString(cal_Year));
                txt_Month.setText(Integer.toString(cal_Month));
                txt_Date.setText(Integer.toString(cal_Date));
                txt_Hour.setText(Integer.toString(timePicker.getCurrentHour()));
                txt_Minute.setText(Integer.toString(timePicker.getCurrentMinute()));
            }
        });


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int date) {
                cal_Year=year;
                cal_Month=month;
                cal_Date=date;
            }
        });
    }
}