package com.example.ishaqfakhrozi.projectbri.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ishaqfakhrozi.projectbri.Activity.MainActivity;
import com.example.ishaqfakhrozi.projectbri.Activity.PMOTools;
import com.example.ishaqfakhrozi.projectbri.R;

public class Tab0Activit extends Fragment {
    private TextView tvQuiz,tvTool;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);
        tvQuiz = rootView.findViewById(R.id.textQuiz);
        tvQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        tvTool = rootView.findViewById(R.id.textPO);
        tvTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PMOTools.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}

