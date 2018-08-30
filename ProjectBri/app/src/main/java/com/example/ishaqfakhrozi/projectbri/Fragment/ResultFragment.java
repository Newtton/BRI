package com.example.ishaqfakhrozi.projectbri.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ishaqfakhrozi.projectbri.Activity.MainActivity;
import com.example.ishaqfakhrozi.projectbri.DB.DBAdapter;
import com.example.ishaqfakhrozi.projectbri.R;
import com.example.ishaqfakhrozi.projectbri.model.Question;

import java.util.ArrayList;
import java.util.List;


public class ResultFragment extends Fragment {
    ArrayList<String> myAnsList=new ArrayList<String>();
    private List<Question> questionsList;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final DBAdapter dbAdapter = new DBAdapter(getContext());
        questionsList = dbAdapter.getAllQuestions();
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        TextView tvAnsweredInfo =view.findViewById(R.id.tvAnsweredInfo);
        TextView t=view.findViewById(R.id.textResult);

        //get score

        Bundle bundle = new Bundle();
        bundle.putInt("score", MainActivity.obtainedScore);
        bundle.putInt("totalQs", questionsList.size());
        bundle.putStringArrayList("myAnsList", myAnsList);

        int score= bundle.getInt("score");
        int totalQs= bundle.getInt("totalQs");
        myAnsList=bundle.getStringArrayList("myAnsList");
        double scr = ((double)score/totalQs*100);

        tvAnsweredInfo.setText("You have answered "+score+" of "+totalQs+" questions  correctly!");
        t.setText("Your Score : "+ scr);

//        Button btnDone=view.findViewById(R.id.btnDone);
//        btnDone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

}
