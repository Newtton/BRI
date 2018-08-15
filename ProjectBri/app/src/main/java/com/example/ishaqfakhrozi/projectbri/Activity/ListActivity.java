package com.example.ishaqfakhrozi.projectbri.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ishaqfakhrozi.projectbri.R;

public class ListActivity extends AppCompatActivity {
    private TextView tvQuiz,tvTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        tvQuiz = findViewById(R.id.textQuiz);
        tvQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
         tvTool = findViewById(R.id.textPO);
        tvTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PMOTools.class);
                startActivity(intent);
            }
        });
    }
}
