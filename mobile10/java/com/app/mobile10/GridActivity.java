package com.app.mobile10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridActivity<PerfectAdapter2> extends AppCompatActivity {
    //x투표
    int[] vote = new int[9];
    int[] posterID2 = {
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

    String[] title2 = {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.pici_icon);
        setTitle("그리드뷰 명화");

        //그리드 뷰에, 데이터들을 넣어보자.
        // 그리드 뷰 id
        GridView gv = findViewById(R.id.gridView1);

        // 그리드뷰에 넣어줄 adapter 즉 반복될 형식. -> 레이아웃은 one.xml 임.

//        MyGridAdapter gridAdapter = new MyGridAdapter(this);
//        gv.setAdapter(gridAdapter);
        PerfectAdapter perfectAdapter = new PerfectAdapter(this);
        gv.setAdapter(perfectAdapter);
//        pa pa = new pa(this); //이너클래스
//        gv.setAdapter(pa);    //이너클래스를 그리드뷰에 삽입.

        //기본 adapter 는 arraylist, array의 데이터를 순서대로 넣어주는 기능만 있음.
        // 데이터 하나하나의 배치 모양을 내가 정해서 어댑팅할 수 있음.


        // 그리드뷰 클릭이벤트
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
//                vote[index]++;
//                Toast.makeText(getApplicationContext(),  vote[index] + " 표 획득! "+ index + "값 이 클릭됨!", Toast.LENGTH_SHORT).show();
//                //alertDialog
                // alert 다이얼로그 설정 부분
                AlertDialog.Builder ad = new AlertDialog.Builder(GridActivity.this); // Alert 다이얼로그 객체.
                ad.setIcon(R.drawable.ic_launcher_foreground); // 아이콘
                ad.setTitle("상세 페이지!");                     // 제목
                // 인플레이션
                View one2 = View.inflate(getApplicationContext(), R.layout.one2, null); // one2.xml 을 one2변수에 저장.
                // 뷰 set

                // id get
                ImageView alimg = one2.findViewById(R.id.alertimg); //이미지
                TextView alnum = one2.findViewById(R.id.alnum); //숫자
                TextView altitle = one2.findViewById(R.id.altitle); //제목
                EditText altext = one2.findViewById(R.id.alertEdit); // 입력
                Button albt = one2.findViewById(R.id.albt); //버튼

                // 시작시 set
                int number = vote[index]; //배열의 해당 index의 값 저장.
                alimg.setImageResource(posterID2[index]); // 이미지 배열에 넣어줌.
                alnum.setText(number + " 표 획득!"); // 추천 개수 표시
                altitle.setText(title2[index]); // 제목 set
                // alert start
                ad.setNegativeButton("확인",null);
                ad.setView(one2);
                ad.show();

                // button click
                albt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vote[index] = vote[index] + Integer.parseInt(altext.getText().toString());
                        Toast.makeText(getApplicationContext(),  vote[index] + " 표 획득! ", Toast.LENGTH_SHORT).show();
                        alnum.setText(vote[index] + " 표");
                    }
                }); // button click end
            }
        }); //그리드뷰 클릭 end
    }//oncreate

    //inner class 생성
    public class pa extends BaseAdapter{

        Context context;
        pa(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return posterID2.length;
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


            return null;
        }
    } // inner class end





}//class