package com.example.ishaqfakhrozi.projectbri;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ishaqfakhrozi.projectbri.Fragment.QuestionFragment;

import java.util.ArrayList;
import java.util.List;

public class    MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int mfragmentIndex=0;
    private ViewPager viewPager;
    private Button back,next;

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
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(0)), "Question1");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(1)), "Question2");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(2)), "Question3");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(3)), "Question4");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(4)), "Question5");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(5)), "Question6");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(6)), "Question7");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(7)), "Question8");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(8)), "Question9");
        adapter.addFrag(QuestionFragment.newInstance(String.valueOf(9)), "Question10");
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
