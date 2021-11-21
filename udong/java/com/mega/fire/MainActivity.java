package com.mega.fire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference database;
    EditText et_user_id, et_user_name, et_user_email;
    Button btn_save, btn_read;
    TextView read_data;
    ListView listview;
    int i = 1;

    ArrayList<User2> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_user_email = findViewById(R.id.et_user_email);
        et_user_id = findViewById(R.id.et_user_id);
        et_user_name = findViewById(R.id.et_user_name);
        read_data = findViewById(R.id.read_data);
        btn_read = findViewById(R.id.btn_read);
        btn_save = findViewById(R.id.btn_save);
        listview = findViewById(R.id.listView);


        // 파이어베이스 "User" 연결 및 객체 저장.
        database = FirebaseDatabase.getInstance().getReference("User");
        Log.d("파이어베이스>>", database + " ");
        // User 의 데이터를 담기위한 리스트.
        arr = new ArrayList(); // 전체목록 어레이리스트
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("파이어베이스>>", "user아래의 자식들의 개수 : " + snapshot.getChildrenCount());

                arr.clear(); // 기존 배열 초기화.
                Log.d("파이어베이스>>", "전체 json 목록 가지고 온 것 : " + snapshot.getChildren());
                // 전체 목록을 가져오기 위한 for 문
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Log.d("파이어베이스>>", "하나의 스냅샷 : " + snapshot1);
                    Log.d("파이어베이스>>", "하나의 스냅샷 밸류 : " + snapshot1.getValue());
                    User2 user2 = snapshot1.getValue(User2.class); //DTO에 SET메서드 자동으로 해줌.
                    Log.d("파이어베이스>>", "user 1명 : " + user2);
                    arr.add(user2); //get.set을 이용하여 어레이리스트에 저장.
                }//for

                Log.d("파이어베이스>>", "전체 어레이 전체 : " + arr); // 어레이 전체 목록.
                Log.d("파이어베이스>>", "어레이 목록 개수 : " + arr.size()); // 어레이 전체 개수.
//              i = arr.size(); // 어레이 리스트 사이즈

                //btn_save 버튼
                btn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name1 = et_user_name.getText().toString();
                        String email1 = et_user_email.getText().toString();
                        String i = et_user_id.getText().toString();
                        //i++;

                        // 에디트 텍스트에 값들 DTO 생성자에 SET.
                        User2 user2 = new User2(name1, email1); // 밸류값
                        // 데이터 넣기 -> 스트링 밸류오브i 는 키값. 셋밸류(User2)는 위에서 넣어둔 밸류값.
                        database.child(String.valueOf(i)).setValue(user2).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getApplicationContext(), "저장을 완료했습니다. ", Toast.LENGTH_SHORT).show();
                            }// 성공시
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "저장 실패!!!! ", Toast.LENGTH_SHORT).show();
                            }
                        }); // 실패시.
                    }
                }); //btn_save

                //btn_read 버튼
                btn_read.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String userId = et_user_id.getText().toString(); // 아이디값

                        database.child(userId).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                User2 user2 = snapshot.getValue(User2.class);
                                Log.d("파이어베이스>>", "전체 어레이 전체 : " + user2); // 검색 결과
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                    }
                });





            } //ondata

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


    }//oncreate
}//class