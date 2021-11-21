package com.app.mobile08;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnstart, btnend;
    RadioButton rdocal, rdotime;
    CalendarView calview;
    TextView result;
    TimePicker tPicker;

    String timeTotal,dateTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("날짜, 시간 예약");
        chrono = findViewById(R.id.chronometer1);
        btnstart = findViewById(R.id.btnstart);
        btnend = findViewById(R.id.btnend);
        rdocal = findViewById(R.id.rdoCal);
        rdotime = findViewById(R.id.rdoTime);
        result = findViewById(R.id.result);
        tPicker = findViewById(R.id.timepicker1);
        calview = findViewById(R.id.calendarView1);
        // 전역변수 선언 지역.



        // 처음에 캘린더, 시계 둘다 INVISIBLE
        calview.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);

        // 라디오 클릭시
        rdocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calview.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });
        rdotime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calview.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        }); //radio end

        // 크로노 미터
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 크로노미터는 버튼을 눌렀을 때를 기준으로(Base) 해서 시작하게 해야한다.
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.BLUE);

            }
        });
        btnend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.RED);
                // 현재시각
                int hour = tPicker.getCurrentHour();
                int min = tPicker.getCurrentMinute();
                timeTotal = hour + "시 " + min + "분";
                toast("현재시각 : " + timeTotal);
                result.setText("예약한 시간 : " + dateTotal + " "+ timeTotal);
            }
        }); // btn End

        // 캘린더뷰 이벤트
        calview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                dateTotal = year+"년 " + (month + 1) + "월 " + dayOfMonth + "일";
                toast("가지고온 날짜는 " + dateTotal);

            }
        }); //calView End



    }// oncreate

    public void toast(String text) {
        Toast.makeText(getApplicationContext()
                , text
                ,Toast.LENGTH_SHORT
        ).show();
    }

}// class