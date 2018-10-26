package com.example.administrator.crisisrelief;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DescriptionActivity extends AppCompatActivity {

    private WebView simpleWebView;

    private static final String TAG = "DescriptionActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        simpleWebView =(WebView) findViewById(R.id.desWebView);
        simpleWebView.setWebViewClient(new WebViewClient());


        Bundle extras = getIntent().getExtras();

        if (!extras.equals(null)){

            String data = extras.getString("titles");

            Log.e(TAG, "onCreate: the data is "+data);





            String url = "file:///android_asset/"+data+".html";

            simpleWebView.loadUrl(url);

        }

        WebSettings webSettings = simpleWebView.getSettings();

        webSettings.setBuiltInZoomControls(true);

        webSettings.setDisplayZoomControls(false);

        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (simpleWebView.canGoBack()){

            simpleWebView.goBack();
        }

        else {

            super.onBackPressed();
        }
    }
}