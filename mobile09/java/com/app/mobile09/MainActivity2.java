package com.app.mobile09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pici_icon);
        setTitle("명화 선호도 투표");

        // 각 명화당 얼마나 투표수를 받았는지 저장하려고 함.
        int[] voteCount = new int[9];

        // 이미지뷰 여러개를 한번에 가져오는 방법.
        // 이미지뷰(ImageView) 객체 여러개 저장할 공간있어야 함.
        ImageView[] image = new ImageView[9];

        // findViewById()
        int[] imageId = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};

        // 이미지 이름
        String imgName[] = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서" };
        // for
        for (int i = 0; i < image.length; i++){
            // 메모리 문제로 final 사용해서 onclick 안에 변수 주입.
            final int i2 = i;
            image[i] = findViewById(imageId[i]);
            image[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[i2]++;
                    Toast.makeText(getApplicationContext(), "제목 : " + imgName[i2] + " 총 현재 " + voteCount[i2] + " 표 획득함.", Toast.LENGTH_SHORT).show();
                } // onclick
            });
        } //for

        // 버튼
        Button button = findViewById(R.id.btnResult);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, ResultActivity.class);
                //voteCount, imgName
                intent.putExtra("voteCount", voteCount);
                intent.putExtra("imgName", imgName);
                startActivity(intent);
            }
        });




    } // oncreate
}// class