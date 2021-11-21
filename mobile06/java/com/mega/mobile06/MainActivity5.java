package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity5 extends AppCompatActivity {

    Button bt1, bt2;
    EditText t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        bt1 = findViewById(R.id.button);
        bt2 = findViewById(R.id.logout);
        t1 = findViewById(R.id.et1);
        t2 = findViewById(R.id.et2);

        t1.setText("");
        t2.setText("");

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String title = t1.getText().toString();
                    String content1 = t2.getText().toString();

                    Toast.makeText(getApplicationContext(),
                            "제목 " + title + " 내용은 " + content1,
                            Toast.LENGTH_SHORT
                    ).show();
                    FileOutputStream file = openFileOutput( "new "+ title +".txt",MODE_PRIVATE);
                    String data = title + "\n" + content1;
                    file.write(data.getBytes());
                    file.close();
                    t1.setText("");
                    t2.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Log.d("", "파일을 찾을수 없습니다.");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("", "파일을 읽고 쓰는 도중 에러발생.");
                }catch (Exception e){
                    e.printStackTrace();
                    Log.d("", "에러가 발생했습니다.");
                }
            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity4.class);
                Toast.makeText(getApplicationContext(),
                        "로그아웃 되었습니다.",
                        Toast.LENGTH_SHORT
                ).show();
                startActivity(intent);
            }
        });

    }
}