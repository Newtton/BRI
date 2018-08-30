package com.example.ishaqfakhrozi.projectbri.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ishaqfakhrozi.projectbri.DB.DBAdapter;
import com.example.ishaqfakhrozi.projectbri.Fragment.QuestionFragment;
import com.example.ishaqfakhrozi.projectbri.R;
import com.example.ishaqfakhrozi.projectbri.model.Question;

import java.util.ArrayList;
import java.util.List;

public class HasilActivity extends AppCompatActivity {
    ArrayList<String> myAnsList=new ArrayList<String>();
    private List<Question> questionsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        final DBAdapter dbAdapter = new DBAdapter(this);
        questionsList = dbAdapter.getAllQuestions();

        TextView tvAnsweredInfo =findViewById(R.id.tvAnsweredInfo);
        TextView t=findViewById(R.id.textResult);

      //get score
        Bundle bundle = getIntent().getExtras();
        int score= bundle.getInt("score");
        int totalQs= bundle.getInt("total");
        myAnsList=bundle.getStringArrayList("myAnsList");
        double scr = ((double)score/totalQs*100);

        tvAnsweredInfo.setText("You have answered "+score+" of "+totalQs+" questions  correctly!");
        t.setText("Your Score : "+ scr);
//
        Button btnDone=findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TabMenu.class);
                startActivity(i);
                finish();
            }
        });
    }
}
