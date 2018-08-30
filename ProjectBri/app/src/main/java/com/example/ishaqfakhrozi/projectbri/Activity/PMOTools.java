package com.example.ishaqfakhrozi.projectbri.Activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ishaqfakhrozi.projectbri.Helper.FileDownloader;
import com.example.ishaqfakhrozi.projectbri.R;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;

public class PMOTools extends AppCompatActivity {
    private TextView textView,txtvideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmotools);
        textView = findViewById(R.id.tv1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PDFreader.class);
                startActivity(intent);
            }
        });
        txtvideo =findViewById(R.id.txtvideo);
        txtvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}
