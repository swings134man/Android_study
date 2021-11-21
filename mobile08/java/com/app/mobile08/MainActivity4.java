package com.app.mobile08;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    Button button;
    EditText name1, name2, email1, email2;
    View dialogView, toastView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //선언
        button = findViewById(R.id.button);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        email1 =findViewById(R.id.email1);
        email2 = findViewById(R.id.email2);

        //버튼
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 인플레이션
                dialogView =(View)View.inflate(MainActivity4.this, R.layout.dialog1, null);
                // alert
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity4.this);
                dialog.setTitle("사용자 정보 입력");
                dialog.setIcon(R.drawable.ic_launcher_foreground);
                // 다이얼로그에 들어갈 view
                dialog.setView(dialogView);
                //dialog.setMessage("나는 다이얼로그 창.,.");

                dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("", "확인 누름");
                        email1 = dialogView.findViewById(R.id.email1);
                        name1 = dialogView.findViewById(R.id.name1);

                        name2.setText(name1.getText().toString());
                        email2.setText(email1.getText().toString());
                    }
                }); // 확인

                dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("", "취소 누름");
                        toastView = (View) View.inflate(MainActivity4.this, R.layout.toast1, null);
                        Toast toast = new Toast(MainActivity4.this);
                        toast.setView(toastView);
                        // 토스트 뷰 객체를 클릭 메서드안에서 생성했기때문에
                        // 토스트 뷰안에 있는 텍스트 객체를 여기서 가져와야함.
                        textView = toastView.findViewById(R.id.textView);
                        textView.setText("취소했습니다.");

                        toast.show();
                    }
                }); //취소
                dialog.show();
            }
        });


    } //oncreate

}//class