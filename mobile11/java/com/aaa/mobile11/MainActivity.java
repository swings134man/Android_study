package com.aaa.mobile11;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtNumber, edtNameResult, edtNumberResult;
    Button btnInit, btnInsert, btnSelect, btnDelete, btnUpdate;
    MyDBHelper myDBHelper;
    Layout viewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //edit 텍스
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.editNumber);
        edtNameResult = findViewById(R.id.edtNameResult);
        edtNumberResult = findViewById(R.id.edtNumberResult);
        //버튼
        btnInit = findViewById(R.id.btnInit);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        //레이아웃


        //MyDBHelper 객체
        myDBHelper = new MyDBHelper(this);


        //초기화
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase(); // DB랑 연결 + 쓸수있다 -> Stream을 열어줌.
                myDBHelper.onUpgrade(sqlDB, 1, 2); //어디 DB 로 보낼건지-> sqlDB(그룹DB임)
                Log.d("sqlite3DDL" , "DDL 호출함 !!!!");
                sqlDB.close(); //Stream 닫아줌.
            }
        });
        //데이터삽입
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                String name = edtName.getText().toString();
                String number = edtNumber.getText().toString();
                sqlDB.execSQL("insert into groupTBL values ('"+ name +"', '"+ number +"');");
                Log.d("sqlite3DML" , "데이터 삽입 성공,,,!!!");
                sqlDB.close();
                Log.d("sqlite3DML" , "데이터 베이스 closed,,,!!!");
            }
        });
        //조회
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // DML => SQLiteDatabase 를 통해서 실행함.
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
//                String name = edtName.getText().toString();                           //부분검색
//                String sql = "select * from groupTBL where gName = '" + name + "'";   //부분검색
                String sql = "select * from groupTBL"; //전체검색.
                // 커서
                Cursor cursor = sqlDB.rawQuery(sql, null);
                //
                String result2 = "";
                String name1 = "그룹이름" + "\r\n" + "--------" + "\r\n";
                String number1 = "인원" + "\r\n" + "--------" + "\r\n";

                // -------------------------------------------------------------------------------------
                    // 리스트뷰 어레이 리스트
                    ArrayList<String> nameList = new ArrayList<>();
                    ArrayList<Integer> numberList = new ArrayList<>();

                    // 외부 레이아웃 (리스트뷰) inflate
                    LinearLayout viewMain = findViewById(R.id.viewMain); //MainActivity
                    View view1 = View.inflate(MainActivity.this, R.layout.listview1, null); //외부 레이아웃 inflate
                // -------------------------------------------------------------------------------------

                while (cursor.moveToNext()){

                    //cursor.moveToNext() 첫 번째 row(행)을 가르키면서 있는지 없는지 체크
                    //있으면 true 리턴
                    //각 열에 있는 값들을 인덱스로 꺼내와라. index는 0부터 시작
                    //String result = cursor.getString(0) + ": " + cursor.getString(1);
                    name1 += cursor.getString(0) + "\r\n";
                    number1 += cursor.getString(1) + "\r\n";
                    // 검색
                    String result = name1 + ": " + number1; // 결과
                    result2 += result + " ";// 결과
                    //검색결과 set
                    edtNameResult.setText(name1);
                    edtNumberResult.setText(number1);

                    // array
                    nameList.add(cursor.getString(0)); // 어레이리스트 추
                    numberList.add(cursor.getInt(1));
                } //while
                Log.d("sqlite3DML", result2); //기록 logcat

                // 어레이 어댑터 : 리스트뷰에 어레이리스트 연결 시켜줄.
                ArrayAdapter<String> nameAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,nameList);
                ArrayAdapter<Integer> numberAdapter = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1,numberList);
                // 리스트뷰.xml에 각 객체 id
                ListView l1 = view1.findViewById(R.id.li1);
                ListView l2 = view1.findViewById(R.id.li2);
                // 리스트뷰에 어댑터set
                l1.setAdapter(nameAdapter);
                l2.setAdapter(numberAdapter);
                // 리니어 레이아웃에 listView.xml 주입.
                viewMain.addView(view1);
                // DB end
                cursor.close();
                sqlDB.close();
            }
        });
        //삭제
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                String name = edtName.getText().toString();
                sqlDB.execSQL("delete from groupTBL where gName = '"+name+"'");
                Log.d("sqlite3DML" , "삭제 호출!!!");
                sqlDB.close();
            }
        });
        //수정
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase sqlDB = myDBHelper.getWritableDatabase();
                String name = edtName.getText().toString();
                String number = edtNumber.getText().toString();
                sqlDB.execSQL("update groupTBL set gNumber ='"+number+"'where gName = '"+name+"'");
                Log.d("sqlite3DML" , "수정 호출함,,,!!!");
                sqlDB.close();
            }
        });

    } // oncreate
}//class