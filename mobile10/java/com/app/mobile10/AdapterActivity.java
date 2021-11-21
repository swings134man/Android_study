package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        setTitle("리스트뷰 테스트");

        // 많은 양의 데이터를 view에 넣어주는 것을 adapter라고 부른다.
        // 많은 양의 데이터 : mid
        ArrayList<String> mid = new ArrayList<>();
        // add to array
        mid.add("히어로즈");
        mid.add("24시");
        mid.add("로스트");
        mid.add("빅뱅이론");

        // view 를 준비, listView
        ListView listview = findViewById(R.id.listView1);

        // adapter 부품 필요
        //데이터를 어떤식으로 넣을지 파라메터 생성자에 넣어줘야함(simple_list 옵션 바꿔볼것)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mid);

        // listView에 adapter를 셋팅
        listview.setAdapter(adapter);

        // 버튼
        // 클릭시 입력한 값 list에 추가
        EditText editText = findViewById(R.id.EditText1);
        Button bt1 = findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                mid.add(data);
                // 어댑터를 리프레쉬 해줘야함. 값을 넣고 refresh 해줘야 리스트에 뜸.
                adapter.notifyDataSetChanged();
            }
        }); // button end

        // 리스트뷰 각 객체당 이벤트
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                String data = mid.get(index);
                Toast.makeText(getApplicationContext(), data+ " " + id, Toast.LENGTH_SHORT).show();

            }
        });



    }// oncreate
}// class