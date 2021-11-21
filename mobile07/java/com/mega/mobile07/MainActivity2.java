package com.mega.mobile07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button bt3, bt4, bt5;
    EditText t2;
    ImageView i1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bt3 = findViewById(R.id.b3);
        bt4 = findViewById(R.id.b4);
        bt5 = findViewById(R.id.b5);
        t2 = findViewById(R.id.t2);
        i1 = findViewById(R.id.imageView);

        // 액티비티1 에서 값 가져옴.
        Intent intent = getIntent();
        String tourName = intent.getStringExtra("name");
        String who = intent.getStringExtra("who");
        String text = "받은 여행지는 " + tourName + " 누구? " + who;
        toast(text);

        //이미지 선택 1번(리팩토링 )
//        String name = "";
//        if (tourName.equals("부산")){
//            name = "busan.png";
//            // 이미지에 넣기
//            i1.setImageResource(R.drawable.busan);
//        }else if (tourName.equals("서울")) {
//            name = "seoul.png";
//            i1.setImageResource(R.drawable.seoul);
//        }else {
//            name = "daejeon.png";
//            i1.setImageResource(R.drawable.daejeon);
//        }
//        toast(name);

        //리팩토링후
        select(tourName);

        // 검색 버튼
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tourName = t2.getText().toString();
                select(tourName);
            }
        });

        // 메인으로 가는 버튼
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent1);
            } //bt4
        });// Click
        //버튼 5
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = t2.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });


    }// onCreate

    //메서드
    public void toast(String name) {
        Toast.makeText(getApplicationContext(),"확인값 >> " + name  ,Toast.LENGTH_SHORT).show();
    } //toast end

    public void select(String tourName) {
        String name = "";
        if (tourName.equals("부산")){
            name = "busan.png";
            // 이미지에 넣기
            i1.setImageResource(R.drawable.busan);
        }else if (tourName.equals("서울")) {
            name = "seoul.png";
            i1.setImageResource(R.drawable.seoul);
        }else {
            name = "daejeon.png";
            i1.setImageResource(R.drawable.daejeon);
        }
        toast(name);
    } // select end
}//class