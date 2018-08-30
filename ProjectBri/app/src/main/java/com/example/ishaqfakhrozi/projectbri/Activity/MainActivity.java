package com.example.ishaqfakhrozi.projectbri.Activity;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ishaqfakhrozi.projectbri.DB.DBAdapter;
import com.example.ishaqfakhrozi.projectbri.Fragment.QuestionFragment;
import com.example.ishaqfakhrozi.projectbri.Fragment.ResultFragment;
import com.example.ishaqfakhrozi.projectbri.R;
import com.example.ishaqfakhrozi.projectbri.model.Question;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener, QuestionFragment.OnRadioGroupSelectedListener {
    private int mfragmentIndex=0;
    private ViewPager viewPager;
    private Button back,next;
    public static int obtainedScore=0;
    private Question currentQuestion;
    private List<Question> questionsList;
    private HashMap<String,Object> hashMap;
    QuestionFragment.OnRadioGroupSelectedListener mCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBAdapter dbAdapter = new DBAdapter(this);
        questionsList = dbAdapter.getAllQuestions();

        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);
        back = findViewById(R.id.btnBack);
        next = findViewById(R.id.btnNext);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(0)), "1");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(1)), "2");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(2)), "3");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(3)), "4");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(4)), "5");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(5)), "6");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(6)), "7");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(7)), "8");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(8)), "9");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(9)), "10");
        viewPager.setOffscreenPageLimit(adapter.getCount());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
            if (view == back) {
                mfragmentIndex--;
                viewPager.setCurrentItem(mfragmentIndex);


            } else if (view == next) {
                if (mfragmentIndex==11){
                    Intent intent = new Intent(this, HasilActivity.class);
                    intent.putExtra("score",obtainedScore);
                    intent.putExtra("total",questionsList.size());
                    obtainedScore=0;
                    startActivity(intent);
                }else {
                    mfragmentIndex++;
                    viewPager.setCurrentItem(mfragmentIndex);
                }


            }

    }


//    public HashMap<String,Object> getHashMap(){
//        return this.hashMap;
//    }

    @Override
    public void onButtonSelected(String selectedRadioButtonValue) {
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFrag(Fragment fragment,String title){
            mFragmentList.add(fragment);
            mFragmentTitle.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }

}
