package com.example.ishaqfakhrozi.projectbri.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.ishaqfakhrozi.projectbri.R;

public class PDFreader extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfreader);
        webView =findViewById(R.id.webview);
        progressBar = findViewById(R.id.progressbar);
        webView.getSettings().setJavaScriptEnabled(true);
        String filename = "https://web.cse.ohio-state.edu/~champion.17/4471/JavaAndroidProgramming.pdf";
        webView.loadUrl("http://docs.google.com/gview?embedded=true&url="+filename);

        webView.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url ){
                progressBar.setVisibility(View.GONE);
            }

        });
    }
}
