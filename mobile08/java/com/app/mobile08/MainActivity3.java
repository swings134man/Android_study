package com.app.mobile08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button backbt1;
    TextView dateresult;
    String time, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        backbt1 = findViewById(R.id.backbt1);
        dateresult = findViewById(R.id.dateresult);
        backbt1 = findViewById(R.id.backbt1);

        Intent intent = getIntent();
        time = intent.getStringExtra("time");
        date = intent.getStringExtra("date");
        Toast.makeText(getApplicationContext(),
                "값은 " + time + "\n" + date,
                Toast.LENGTH_SHORT
        ).show();

        String total = "예약한 날짜는 \n" + date + "\n 시간 : " + time;
        dateresult.setText(total);

        backbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });





    }// oncreate
}//class