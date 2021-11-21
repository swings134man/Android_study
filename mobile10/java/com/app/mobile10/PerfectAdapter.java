package com.app.mobile10;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfectAdapter extends BaseAdapter {

    Context context;    // GridActivity

    PerfectAdapter(Context c){  // GridActivity 에서의 this 라서 위치지정해준것.
        context = c;
    }

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

    String[] title = {
           "그림1",
           "그림2",
           "그림3",
           "그림4",
           "그림5",
           "그림6",
           "그림7",
           "그림8",
           "그림9"
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
    public View getView(int index, View convertView, ViewGroup parent) {
        // 반복되는 하나의 View 객체를 만들어주어야 함.
        // 버튼이 어디에 들어가야 할지 파라메터로 꼭 지정해주어야함.
//        Button button = new Button(context);
//        button.setText("버튼버튼");
        View one = View.inflate(context, R.layout.one,null);
        TextView top = one.findViewById(R.id.topText);
        ImageView iv = one.findViewById(R.id.imageView7);

        top.setText(title[index]);
        iv.setImageResource(posterID[index]);
        one.setPadding(5,5,5,5);

        return one;
    }
}
