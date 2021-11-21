package com.app.mobile09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_result);
        setTitle("투표결과");

        Intent intent = getIntent();
        String[] mName = intent.getStringArrayExtra("mName");
        int[] imgName = intent.getIntArrayExtra("imgName");
        int[] vote = intent.getIntArrayExtra("vote");

        // 변수 생성
        // 텍스트 뷰
        TextView[] tv = new TextView[mName.length];
        int[] tvN = {
                R.id.mTitle1,
                R.id.mTitle2,
                R.id.mTitle3,
                R.id.mTitle4,
                R.id.mTitle5,
                R.id.mTitle6,
                R.id.bestName
        };
        // 1등 사진
        int idx = 0;
        int max = vote[0];
        for (int i = 0; i < mName.length; i++){
            if (vote[i] > max){
                max = vote[i];
                idx = i;
            }
        }
        TextView bn;
        ImageView iv1;
        bn = findViewById(R.id.bestName);
        iv1 = findViewById(R.id.bestImg);

        // 텍스트뷰 배열에 아이디 넣어줌.
        for (int i = 0; i < mName.length; i++){
            tv[i] = findViewById(tvN[i]);
            tv[i].setText(mName[i] + " : " + vote[i]);
            bn.setText(mName[idx] + " : " + vote[idx]);
        }

        //이미지뷰
        ImageView[] iv = new ImageView[mName.length];
        int[] imgv = {
                R.id.img1,
                R.id.img2,
                R.id.img3,
                R.id.img4,
                R.id.img5,
                R.id.img6,
                R.id.bestImg
        };
        //이미지 설정
        for (int i = 0; i < mName.length; i++) {
            iv[i] = findViewById(imgv[i]);
            iv[i].setImageResource(imgName[i]);
            iv1.setImageResource(imgName[idx]);
        }


    }//oncreate
}//clas