package com.app.mobile10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class StarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        //탭
        TabHost tabHost = findViewById(R.id.tabhost2);
        tabHost.setup(); //기초 탭 초기화.

        //각탭 설정
        TabHost.TabSpec tabSpecHome = tabHost.newTabSpec("HOME").setIndicator("홈");
        tabSpecHome.setContent(R.id.home);
        tabHost.addTab(tabSpecHome);
        //2
        TabHost.TabSpec tabSpecCategory = tabHost.newTabSpec("category").setIndicator("카테고리");
        tabSpecCategory.setContent(R.id.category);
        tabHost.addTab(tabSpecCategory);
        //3
        TabHost.TabSpec tabSpecGift = tabHost.newTabSpec("gift").setIndicator("선물");
        tabSpecGift.setContent(R.id.gift);
        tabHost.addTab(tabSpecGift);
        //첫시작 탭
        tabHost.setCurrentTab(0);


    } //oncreate
}//class