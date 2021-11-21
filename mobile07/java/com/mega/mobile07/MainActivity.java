package com.mega.mobile07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt1, bt2;
    EditText t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.t1);
        bt1 = findViewById(R.id.b1);
        bt2 = findViewById(R.id.b2);
            // 3번 방법
//        bt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String data = t1.getText().toString();
//                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                intent.putExtra("name", data);
//
//                startActivity(intent);
//            }
//        });

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    } // oncreate end
    @Override
    public void onClick(View view){
        String who = "";
        if(view.getId() == R.id.b1) { //버튼구분! 다른 if문 사용시 다른 기능 사용가능.
            who = "GO1";
        } else if (view.getId() == R.id.b2){
            who = "GO2";
        } //else if

            String data = t1.getText().toString();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("name", data);
            intent.putExtra("who" , who);
            startActivity(intent);
    } // onClick
}//class