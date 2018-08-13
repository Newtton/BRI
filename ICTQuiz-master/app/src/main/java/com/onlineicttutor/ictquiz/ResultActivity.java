package com.onlineicttutor.ictquiz;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    ArrayList<String> myAnsList=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

//        AdView mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build();
//        mAdView.loadAd(adRequest);

        //get rating bar object
//        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//        bar.setNumStars(5);
//        bar.setStepSize(0.5f);

        //get text view
        TextView tvAnsweredInfo =(TextView)findViewById(R.id.tvAnsweredInfo);
        TextView t=(TextView)findViewById(R.id.textResult);

        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        int totalQs= b.getInt("totalQs");
        myAnsList=b.getStringArrayList("myAnsList");

        //display score
//        bar.setRating(score);

        tvAnsweredInfo.setText("You have answered "+score+" of "+totalQs+" questions  correctly!");
        t.setText("Your Score : "+ score*3);
//        float percentage=(score*100)/totalQs;
//
//        if (percentage>=80 && percentage<=100){
//            t.setText("Score is Excellent !");
//        }else if(percentage>=70 && percentage<=79){
//            t.setText("Score is Best");
//        }else if(percentage>=60 && percentage<=69){
//            t.setText("Score is Good");
//        }else if(percentage>=50 && percentage<=59){
//            t.setText("Score is Average!");
//        }else if(percentage>=33 && percentage<=49){
//            t.setText("Score is  Below Average!");
//        }else{
//            t.setText("Score is Poor! You need to practice more!");
//        }


        Button btnDone=(Button)findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
