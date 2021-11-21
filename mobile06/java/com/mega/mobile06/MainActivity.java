package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // 부모클래스의 메서드를 호출할때 super 이용. 부모의 메서드와 자식 메서드의 이름이 다를땐 이름만으로 호출가능
        // 액티비티의 기본틀 설정, 제목 넣고, 기본색 설정.
        setContentView(R.layout.activity_main);

        // 버튼1
        bt1 = findViewById(R.id.b1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 액티비티 넘기려고 함.
                // 넘기는 데이터를 함께 보내려고 함.
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", "honggilldong");
                intent.putExtra("age", 100);
                intent.putExtra("height", 199.4);

                //array List
                ArrayList<String> subject = new ArrayList<>();
                subject.add("컴퓨터");
                subject.add("수학");
                subject.add("과학");
                subject.add("국어");
                intent.putExtra("subject", subject);

                // array
                String[] play = {"게임", "영화"};
                intent.putExtra("play", play);


                startActivity(intent);
            }
        }); //click





    }//create
}//class