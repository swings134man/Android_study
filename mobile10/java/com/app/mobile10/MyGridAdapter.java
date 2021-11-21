package com.app.mobile10;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridAdapter extends BaseAdapter {

    Context context; //액티비티를 값이 들어갈 객체!

    MyGridAdapter(Context context1){
        context = context1;
    }//생성자
    // 그림 목록(drawable)
    int[] posterID = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
            R.drawable.pic8,
            R.drawable.pic9,
    };

    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        // 이미지
        // gridView에 들어갈 하나하나의 layout을 만들어주는 메서드!
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(posterID[i]);
        return imageView;
        //텍스트뷰
//        TextView textView = new TextView(context);
//        textView.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
//        textView.setPadding(5,5,5,5);
//        textView.setText("나 반복 " + i);
//        return textView;
        // 버튼
//        Button button = new Button(context);
//        button.setLayoutParams(new ViewGroup.LayoutParams(300,300));
//        button.setPadding(5,5,5,5);
//        button.setText("나는 버튼 " + i );
//        return button;
    }
    //기본 어댑터의 기능들을 내가 임의로 재정의해서 사용가능하다.
}
