package com.mega.mobile07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button bt6, bt7;
    EditText t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3); // 인플레이션(증대)

        bt6 = findViewById(R.id.b6);
        bt7 = findViewById(R.id.b7);
        t3 = findViewById(R.id.t3);
        // 앞에서 입력한 데이터를 받아오세요.
        // 받아오자마자 toast로 확인
        // 받아온 데이터를 가지고, 대표적인 사이트로 연결! (goSite 함수 호출)
        // 입력란을 만들어서, 해당 사이트로 연결!(goSite 함수 호출)
        // goSite 함수 안에는 넘어갑니다.

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        toast(name); // 토스트

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String name = intent.getStringExtra("name");

                goSite(name);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = t3.getText().toString();
                goSite(name);
            }
        });
    } // oncreate

    public void toast(String name) {
        Toast.makeText(getApplicationContext(),"확인값 >> " + name  ,Toast.LENGTH_SHORT).show();
    }// toast end

    public void goSite(String name) {
        String name2="";
        if (name.equals("서울")){
            name2 = "seoul";
        }else if (name.equals("부산")) {
            name2 = "busan";
        }else if(name.equals("대전")){
            name2 = "daejeon";
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www." + name2 +".go.kr"));
        String name1 = "넘어갑니다~~~";
        toast(name1);
        startActivity(intent);
    } //goSite end
} // class