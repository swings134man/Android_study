package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        // data
        String name = intent.getStringExtra("name"); // "honggildong"
        int age = intent.getIntExtra("age", 0);
        double height = intent.getDoubleExtra("height", 0);

        // 어레이리스트.
        ArrayList<String> subject = intent.getStringArrayListExtra("subject");
        Log.d("확인", subject.toString());

        // array
        String[] play = intent.getStringArrayExtra("play");
        String list = "";
        for (String a : play) {
            list += a + "  ";
        }

        // 토스트 출력.
        Toast.makeText(getApplicationContext(),
                "받은 이름은 " + name+ " " + age +" " + height + "\n" + subject +"\n" + list,
                Toast.LENGTH_SHORT
                ).show();


    }//create
}//class