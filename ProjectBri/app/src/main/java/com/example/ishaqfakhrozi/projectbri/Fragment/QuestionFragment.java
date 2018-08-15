package com.example.ishaqfakhrozi.projectbri.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    private static final String ARG_QUESTION_ID = "question_id";
    private List<Question> questionsList;
    private Question currentQuestion;
    private int obtainedScore=0;
    private int questionId=0;

    private int answeredQsNo=0;

    private TextView txtQuestion,tvNoOfQs;
    private RadioButton rbtnA, rbtnB, rbtnC,rbtnD;
    private static MainActivity parentActivity;
    static RadioGroup grp;


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
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        final RadioGroup grp=view.findViewById(R.id.radioGroup1);

        txtQuestion=view.findViewById(R.id.tvQuestion);
        rbtnA=view.findViewById(R.id.radio0);
        rbtnB=view.findViewById(R.id.radio1);
        rbtnC=view.findViewById(R.id.radio2);
        rbtnD=view.findViewById(R.id.radio3);
        setPertanyaan();

        myAnsList = new ArrayList<String>();
        return view;
    }
    private void setPertanyaan()
    {

//        answeredQsNo=questionId+1;
//        tvNoOfQs.setText(+answeredQsNo+"/"+questionsList.size());

        txtQuestion.setText(currentQuestion.getQUESTION());
        rbtnA.setText(currentQuestion.getOptionA());
        rbtnB.setText(currentQuestion.getOptionB());
        rbtnC.setText(currentQuestion.getOptionC());
        rbtnD.setText(currentQuestion.getOptionD());
    }

    public static boolean setJawaban(){
        HashMap<String,Object> hashMap = parentActivity.getHashMap();
        int radiobuttonID = grp.getCheckedRadioButtonId();
        View radioButton = grp.findViewById(radiobuttonID);
        int idx = grp.indexOfChild(radioButton);
        RadioButton r = (RadioButton) grp.getChildAt(idx);
        hashMap.put("answer", r.getText().toString());

        return true;
    }


}
