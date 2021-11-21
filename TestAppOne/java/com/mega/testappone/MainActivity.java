package com.mega.testappone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button bt1;
    TextView textView;
    String number, text;

    int rere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.viewText);
        bt1 = findViewById(R.id.bt1);
        //랜덤
        Random r = new Random();

        ArrayList<Integer> arr = new ArrayList<>();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = "start";
                String re = "restart";

                if (bt1.getText().toString().equals(st)){

                            rere = r.nextInt(7);
                            number = Integer.toString(rere); // to String
                            arr.add(rere); //배열에 int add
                            textView.setText(number); // 텍스트뷰 set
                            bt1.setText("stop");
                }else if(bt1.getText().toString().equals("stop")){
                                for (int i = 0; i < arr.size(); i++){
                                    if (arr.get(i) == null){
                                        arr.add(rere);
                                    }//if
                                }//for
                    Log.d("name", "어레이 값 : " + arr.toString());
                                bt1.setText("start");

                                if (arr.size() == 4){
                                    bt1.setText("restart");
                                    int resultNum = 0;
                                    for (int i =0; i < arr.size(); i++){
                                        resultNum += arr.get(i);
                                        text = Integer.toString(resultNum);
                                    }//for
                                    textView.setText(text);

                                }
                } else if(bt1.getText().toString().equals("restart")) {
                    arr.clear();
                    Log.d("name", "array 초기화 : " + arr.toString());
                    textView.setText("다시 시작");
                    rere = r.nextInt(7);
                    number = Integer.toString(rere); // to String
                    arr.add(rere); //배열에 int add
                    textView.setText(number); // 텍스트뷰 set
                    bt1.setText("stop");
                } ;

            } //click
        });




    } //main


}//class