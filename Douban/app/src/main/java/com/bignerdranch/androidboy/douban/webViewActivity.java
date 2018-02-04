package com.bignerdranch.androidboy.douban;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by androidboy on 18-2-3.
 */

public class webViewActivity extends AppCompatActivity {
    private WebView mWebView;
    private String WebUrl;
    private ProgressBar mProgressBar;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        mProgressBar=(ProgressBar)findViewById(R.id.progressBar2);
        mProgressBar.setMax(100);

        WebUrl=getIntent().getStringExtra("webURL");
        mWebView=findViewById(R.id.web_view);
        mWebView.getSettings().setJavaScriptEnabled(true);


        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
           public void onProgressChanged(WebView webView,int newProgress){
               if(newProgress==100){
                   mProgressBar.setVisibility(View.GONE);

               }else {mProgressBar.setVisibility(View.VISIBLE);
               mProgressBar.setProgress(newProgress);
           } }
           @Override
           public void onReceivedTitle(WebView webView,String title){
              webViewActivity.this.getSupportActionBar().setSubtitle(title);
           }
        });
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(WebUrl);
    }

    public static Intent newIntent(Context context,String url){
        Intent intent=new Intent(context,webViewActivity.class);
        intent.putExtra("webURL",url);

        return intent;
    }
}
