package com.example.ishaqfakhrozi.projectbri.Activity;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ishaqfakhrozi.projectbri.DB.DBAdapter;
import com.example.ishaqfakhrozi.projectbri.Fragment.QuestionFragment;
import com.example.ishaqfakhrozi.projectbri.R;
import com.example.ishaqfakhrozi.projectbri.model.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class    MainActivity extends AppCompatActivity implements View.OnClickListener, QuestionFragment.OnRadioGroupSelectedListener {
    private int mfragmentIndex=0;
    private ViewPager viewPager;
    private Button back,next;
    private Question currentQuestion;
    private int obtainedScore=0;
    private HashMap<String,Object> hashMap;
    private QuestionFragment questionFragment1;
    private QuestionFragment questionFragment2;
    private QuestionFragment questionFragment3;
    private QuestionFragment questionFragment4;
    private QuestionFragment questionFragment5;
    private QuestionFragment questionFragment6;
    private QuestionFragment questionFragment7;
    private QuestionFragment questionFragment8;
    private QuestionFragment questionFragment9;
    private QuestionFragment questionFragment10;
    QuestionFragment.OnRadioGroupSelectedListener mCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        back = findViewById(R.id.btnBack);
        next = findViewById(R.id.btnNext);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        questionFragment1 = QuestionFragment.newInstance(String.valueOf(0));
        questionFragment2 = QuestionFragment.newInstance(String.valueOf(1));
        questionFragment3 = QuestionFragment.newInstance(String.valueOf(2));
        questionFragment4 = QuestionFragment.newInstance(String.valueOf(3));
        questionFragment5 = QuestionFragment.newInstance(String.valueOf(4));
        questionFragment6 = QuestionFragment.newInstance(String.valueOf(5));
        questionFragment7 = QuestionFragment.newInstance(String.valueOf(6));
        questionFragment8 = QuestionFragment.newInstance(String.valueOf(7));
        questionFragment9 = QuestionFragment.newInstance(String.valueOf(8));
        questionFragment10 = QuestionFragment.newInstance(String.valueOf(9));
        adapter.addFrag(questionFragment1, "1");
        adapter.addFrag(questionFragment2, "2");
        adapter.addFrag(questionFragment3, "3");
        adapter.addFrag(questionFragment4, "4");
        adapter.addFrag(questionFragment5, "5");
        adapter.addFrag(questionFragment6, "6");
        adapter.addFrag(questionFragment7, "7");
        adapter.addFrag(questionFragment8, "8");
        adapter.addFrag(questionFragment9, "9");
        adapter.addFrag(questionFragment10, "10");
        viewPager.setOffscreenPageLimit(adapter.getCount());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if(view == back){
            mfragmentIndex--;
            viewPager.setCurrentItem(mfragmentIndex);


        }else if(view == next) {
                mfragmentIndex++;
                viewPager.setCurrentItem(mfragmentIndex);

        }
    }


    public HashMap<String,Object> getHashMap(){
        return this.hashMap;
    }

    @Override
    public void onButtonSelected(int mfragmentIndex) {
//        if (mCallback.equals(mfragmentIndex)){
//            obtainedScore++;
//        }
//        else{
//            Log.d("message","ga ada data");
//        }
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
