package com.app.mobile09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pici_icon);
        setTitle("투표 결과");

        // 값 get
        Intent intent = getIntent();
        String[] imgName = intent.getStringArrayExtra("imgName");
        int [] voteCount = intent.getIntArrayExtra("voteCount");
        // 변수 배열 생성.
        TextView[] tv = new TextView[imgName.length];
        RatingBar[] rbar = new RatingBar[imgName.length];
        int[] tvId = {
                R.id.tv1,
                R.id.tv2,
                R.id.tv3,
                R.id.tv4,
                R.id.tv5,
                R.id.tv6,
                R.id.tv7,
                R.id.tv8,
                R.id.tv9
        }; //findViewById 반복문
        int[] rbatId = {
                R.id.rbat1,
                R.id.rbat2,
                R.id.rbat3,
                R.id.rbat4,
                R.id.rbat5,
                R.id.rbat6,
                R.id.rbat7,
                R.id.rbat8,
                R.id.rbat9,
        };
        // 변수 배열 tv[]에 ID 대입헤서 넣어줌.
        for (int i = 0; i < imgName.length; i++) {
          tv[i] = findViewById(tvId[i]);
          rbar[i] = findViewById(rbatId[i]);
        } //반복문으로 변수저장해줌.

        // 텍스트 변환 + rating
        for(int i = 0; i < imgName.length; i++) {
            tv[i].setText(imgName[i]);
            rbar[i].setRating(voteCount[i]);
        }

        // 버튼
        Button bt = findViewById(R.id.btnReturn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });





    }// oncreate
}// class