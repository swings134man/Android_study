package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity3 extends AppCompatActivity {

    Button b1;
    EditText text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //선언
        b1 = findViewById(R.id.bt1);
        text1 = findViewById(R.id.t1);
        text2 = findViewById(R.id.t2);



        // 버튼
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = text1.getText().toString();
                String content = text2.getText().toString();

                // 값확인
                Toast.makeText(getApplicationContext(),
                        "날짜는 " + date + " 내용은 " + content,
                        Toast.LENGTH_SHORT
                        ).show();

                // 파일에 저장 파트.

                try {
                    FileOutputStream file = openFileOutput(date+".txt", MODE_PRIVATE);
                    //String data = "i am a andriod programmer";
                    String data = date + "\n" + content;
                    file.write(data.getBytes());
                    file.close(); //스트림 close 필수.
                    text1.setText("");
                    text2.setText("");

                } catch (FileNotFoundException e) { // File not Found
                    e.printStackTrace();
                    Log.d("", "파일이 존재하지 않습니다.");
                } catch (IOException e) { //write, read exception catch
                    e.printStackTrace();
                    Log.d("", "파일을 읽고 쓰는중에 에러가 발생했습니다.");
                }catch (Exception e){
                    e.printStackTrace();
                    Log.d("", "에러가 발생했습니다.");
                }//try/catch


            }
        });

    }//create
}//class