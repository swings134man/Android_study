package com.mega.mobile06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity4 extends AppCompatActivity {

    Button bt1;
    EditText text1, text2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        bt1 = findViewById(R.id.button1);
        text1 = findViewById(R.id.tt1);
        text2 = findViewById(R.id.tt2);
        tv1 = findViewById(R.id.result);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = text1.getText().toString();
                String pw = text2.getText().toString();

                if (id.equals("root") && pw.equals("1234")) {
                    tv1.setText("로그인 성공!!!");
                    Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                    startActivity(intent);
                }else {
                    tv1.setText("로그인 실패!!!");
                    text1.setText("");
                    text2.setText("");
                }


            }
        });


    }
}