package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        //외부 레이아웃 파일 설정
        // 어디에 분리시켜놓은 layout 파일을 넣을지 결정!
        LinearLayout layout1 = findViewById(R.id.tabsong);
        LinearLayout layout2 = findViewById(R.id.tabArtist);
        LinearLayout layout3 = findViewById(R.id.tabAlbum);

        // 분리시켜놓은 xml(layout) 파일들을 객체화 시키자!!
        // inflation (객체화)
        View songView = View.inflate(TabActivity.this, R.layout.song, null);
        View artView = View.inflate(TabActivity.this, R.layout.art, null);
        View albumView = View.inflate(TabActivity.this, R.layout.album, null);

        // 레이아웃에 xml 파일들을 주입.
        layout1.addView(songView);
        layout2.addView(artView);
        layout3.addView(albumView);
        // xml 안에 버튼을 가져오는것 해당 객체에서 찾아와야함.
        //song xml
        Button btnChange = songView.findViewById(R.id.btbChange);
        ImageView imageView = songView.findViewById(R.id.imageView);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.pic9);
            }
        });
        // art xml
        Button btnChange2 = artView.findViewById(R.id.btnChange2);
        ImageView imageView2 = artView.findViewById(R.id.imageView2);
        TextView textView2 = artView.findViewById(R.id.text4);
        btnChange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setImageResource(R.drawable.pic9);
                String data= "바뀌었다!";
                textView2.setText(data);

            }
        });
        // album xml


        // ------------------------------------------------------------------
        //탭 하나의 단위
        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup(); // 기초적인 tab초기화!

        //각 탭별 설정
        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabsong); // 레이아웃을 넣음. (리니어 레이아웃.)
        tabHost.addTab(tabSpecSong); // 전체 탭호스트에 추가
        //2
        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("Artist").setIndicator("가수별");
        tabSpecArtist.setContent(R.id.tabArtist); //객체 주입
        tabHost.addTab(tabSpecArtist);
        //3
        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("Album").setIndicator("앨범별"); //set인디케이터 중요 실제로 보여지는 부분임.
        tabSpecAlbum.setContent(R.id.tabAlbum); //객체 주입
        tabHost.addTab(tabSpecAlbum);
        //처음 시작하는 탭을 설정해줌. index 로 위의 int 번호 사용.
        tabHost.setCurrentTab(0);





    }//oncreate
}//class