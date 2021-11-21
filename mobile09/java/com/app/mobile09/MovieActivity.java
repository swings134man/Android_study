package com.app.mobile09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setTitle("Movie");

        // 투표 배열
        int[] vote = new int[6];
        //이미지 배열
        ImageView[] image = new ImageView[6];
        //이미지 아이디
        int[] imgId = {R.id.mimg1,R.id.mimg2,R.id.mimg3,R.id.mimg4,R.id.mimg5,R.id.mimg6};
        //이미지명
        int[] imgName = {R.drawable.corona, R.drawable.thismovie, R.drawable.joker, R.drawable.god,R.drawable.lalaland,R.drawable.parasite};
        //영화 제목
        String[]  mName = {"코로나", "디스이즈잇", "조커","신과함께","라라랜드","기생충"};

        // 이미지 아이디 주입
        for (int i = 0; i < image.length; i++) {
            final int i2 = i;
            image[i] = findViewById(imgId[i]);
            image[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                vote[i2]++;

                }
            });//click
        }

        // 버튼
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MovieActivity.this, MovieResult.class);
                intent.putExtra("vote", vote);
                intent.putExtra("mName", mName);
                intent.putExtra("imgName", imgName);
                startActivity(intent);
            }
        });



    }//oncreate
}//class