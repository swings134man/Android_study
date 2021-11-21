package com.app.mobile08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button startbt, endbt, datebt, timebt, nextbt;
    Chronometer chronometer2;
    TimePicker timepicker2;
    CalendarView calendarView2;

    String date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        calendarView2 = findViewById(R.id.calendarView2);
        timepicker2 = findViewById(R.id.timepicker2);
        chronometer2 = findViewById(R.id.chronometer2);
        startbt = findViewById(R.id.startbt);
        endbt = findViewById(R.id.endbt);
        datebt = findViewById(R.id.datebt);
        timebt = findViewById(R.id.timebt);
        nextbt = findViewById(R.id.nextbt);

        // 크로노 버튼 시작
        startbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer2.setBase(SystemClock.elapsedRealtime());
                chronometer2.start();
                chronometer2.setTextColor(Color.BLUE);
            }
        });
        endbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer2.stop();
                chronometer2.setTextColor(Color.RED);
            }
        });
        // 캘린더.
        calendarView2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date =  year+"년 " + (month + 1) + "월 " + dayOfMonth + "일";
                toast(date);
            }
        });// 캘린더

        // date
        datebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String message = date;
            String text = "날짜";
            alert(text, message);
            }
        });

        // 시간가져오기 버튼
        timebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timepicker2.getCurrentHour();
                int min = timepicker2.getCurrentMinute();
                time = hour + "시 " + min + "분";
                String text = "시간";
                alert(text, time);
            }
        });
        // 다음액티비티 버튼
        nextbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class );
                intent.putExtra("date", date);
                intent.putExtra("time", time);
                startActivity(intent);
            }
        });


    } // oncreate

    // 메서드
    public void toast(String text) {
        Toast.makeText(getApplicationContext()
                , text
                ,Toast.LENGTH_SHORT
        ).show();
    }

    public void  alert(String text, String message) {
        // alert
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
        alert.setIcon(R.drawable.ic_launcher_background);
        alert.setTitle(text);
        alert.setMessage(message);
        alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }

} // class