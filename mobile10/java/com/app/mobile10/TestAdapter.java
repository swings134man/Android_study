package com.app.mobile10;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

//BaseAdapter 같은 상속받은 곳 에서 무언가를 해주어야 완벽하게 사용할 수 있는
//BaseAdapter 자체로는 불완전한 클래스를 추상클래스 라고 한다.
//클래스에 추상이라는 단어가 붙으면 불완전하다는 의미
//추상붙은 것들(인터페이스, 추상클래스)는 객체를 생성해서 쓸 수 없다.
public class TestAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 0;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
