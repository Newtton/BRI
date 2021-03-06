package com.example.ishaqfakhrozi.projectbri.Fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ishaqfakhrozi.projectbri.DB.DBAdapter;
import com.example.ishaqfakhrozi.projectbri.Activity.MainActivity;
import com.example.ishaqfakhrozi.projectbri.R;
import com.example.ishaqfakhrozi.projectbri.model.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment  {
    private static final String ARG_QUESTION_ID = "question_id";
    private List<Question> questionsList;
    private Question currentQuestion;

    private int answeredQsNo=0;

    private TextView txtQuestion,tvNumberOfQuestions;
    private RadioButton rbtnA, rbtnB, rbtnC,rbtnD;
    OnRadioGroupSelectedListener mCallback;


    ArrayList<String> myAnsList;


    public QuestionFragment() {
        // Required empty public constructor
    }


    public static QuestionFragment newInstance(String questionId1) {
        final QuestionFragment fragment = new QuestionFragment();
        final Bundle args = new Bundle();
        args.putString(ARG_QUESTION_ID,questionId1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final String question1 = getArguments().getString(ARG_QUESTION_ID);
        final DBAdapter dbAdapter = new DBAdapter(getContext());
        questionsList = dbAdapter.getAllQuestions();
        currentQuestion = questionsList.get(Integer.parseInt(question1));
        answeredQsNo=Integer.parseInt(question1)+1;


        View view = inflater.inflate(R.layout.fragment_question, container, false);

        tvNumberOfQuestions = view.findViewById(R.id.tvNumberOfQuestions);
        txtQuestion=view.findViewById(R.id.tvQuestion);
        rbtnA=view.findViewById(R.id.radio0);
        rbtnB=view.findViewById(R.id.radio1);
        rbtnC=view.findViewById(R.id.radio2);
        rbtnD=view.findViewById(R.id.radio3);

        //set Question dan check RadioGruop
        setPertanyaan();
        RadioGroup radioGroup=view.findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                mCallback.onButtonSelected(String.valueOf(radioButton.getText()));
                if(currentQuestion.getANSWER().equals(radioButton.getText())){
                    MainActivity.obtainedScore++;
                    Log.e("comments", String.valueOf(MainActivity.obtainedScore));
                }else{
                    Log.e("comments", "Wrong Answer");
                }

            }



        });



        return view;
    }
    private void setPertanyaan()
    {
//        rbtnA.setChecked(false);
//        rbtnB.setChecked(false);
//        rbtnC.setChecked(false);
//        rbtnD.setChecked(false);


        tvNumberOfQuestions.setText(+answeredQsNo+"/"+questionsList.size());
        txtQuestion.setText(currentQuestion.getQUESTION());
        rbtnA.setText(currentQuestion.getOptionA());
        rbtnB.setText(currentQuestion.getOptionB());
        rbtnC.setText(currentQuestion.getOptionC());
        rbtnD.setText(currentQuestion.getOptionD());
    }

    public static void setJawaban(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;

        if (context instanceof Activity) {
            activity = (Activity) context;

            try {
                mCallback = (OnRadioGroupSelectedListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnRadioGroupSelectedListener");
            }
        }

    }

    public interface OnRadioGroupSelectedListener {
        public void onButtonSelected(String Value);

    }
}
