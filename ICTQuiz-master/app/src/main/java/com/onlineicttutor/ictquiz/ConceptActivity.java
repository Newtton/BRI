package com.onlineicttutor.ictquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.onlineicttutor.ictquiz.db.DBAdapter;
import com.onlineicttutor.ictquiz.model.Question;

import java.util.ArrayList;
import java.util.List;

public class ConceptActivity extends AppCompatActivity {

   private List<Question> questionsList;
   private Question currentQuestion;

    private TextView txtQuestion,tvNoOfQs;
    private RadioButton rbtnA, rbtnB, rbtnC,rbtnD;
    private Button btnNext, btnBack;

    private int obtainedScore=0;
    private int questionId=0;

    private int answeredQsNo=0;

    ArrayList<String> myAnsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concept);

        final RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
        //Initialize the view
        pertanyaan();

        //Initialize the database
        final DBAdapter dbAdapter=new DBAdapter(this);
        questionsList= dbAdapter.getAllQuestions();
        currentQuestion=questionsList.get(questionId);

        //Set question
        setPertanyaan();

        //Check and Next
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());



                    if(currentQuestion.getANSWER().equals(answer.getText())){
                        obtainedScore++;

                    }else{
                        Log.e("comments", "Wrong Answer");
                    }
                    if(questionId<dbAdapter.rowCount()){
                        questionId++;
                        currentQuestion=questionsList.get(questionId);
                        setPertanyaan();
                        grp.clearCheck();
                    }else{
                        Intent intent = new Intent(ConceptActivity.this, ResultActivity.class);

                        Bundle b = new Bundle();
                        b.putInt("score", obtainedScore);
                        b.putInt("totalQs", questionsList.size());
                        b.putStringArrayList("myAnsList", myAnsList);
                        intent.putExtras(b);
                        startActivity(intent);

                    }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionId>dbAdapter.rowCount()) {
                    questionId--;
                    currentQuestion=questionsList.get(questionId);
                    setPertanyaan();
                    grp.clearCheck();
                }
                    else {
                    btnBack.setEnabled(false);
                }
            }
        });
    }

    public void pertanyaan(){
        tvNoOfQs=(TextView)findViewById(R.id.tvNumberOfQuestions);
        txtQuestion=(TextView)findViewById(R.id.tvQuestion);
        rbtnA=(RadioButton)findViewById(R.id.radio0);
        rbtnB=(RadioButton)findViewById(R.id.radio1);
        rbtnC=(RadioButton)findViewById(R.id.radio2);
        rbtnD=(RadioButton)findViewById(R.id.radio3);

        btnNext=(Button)findViewById(R.id.btnNext);
        btnBack= (Button)findViewById(R.id.btnBack);

        myAnsList = new ArrayList<String>();
    }


    private void setPertanyaan()
    {
        rbtnA.setChecked(false);
        rbtnB.setChecked(false);
        rbtnC.setChecked(false);
        rbtnD.setChecked(false);

        answeredQsNo=questionId+1;
        tvNoOfQs.setText(+answeredQsNo+"/"+questionsList.size());

        txtQuestion.setText(currentQuestion.getQUESTION());
        rbtnA.setText(currentQuestion.getOptionA());
        rbtnB.setText(currentQuestion.getOptionB());
        rbtnC.setText(currentQuestion.getOptionC());
        rbtnD.setText(currentQuestion.getOptionD());


    }
}
