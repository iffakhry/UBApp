package net.crevion.fakhry.ubapp2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    private String webUrl = "https://filkom.ub.ac.id/";
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = (WebView) findViewById(R.id.webView);
        WebSettings webSetting = webView.getSettings();
//        webView.setWebChromeClient(new WebChromeClient();

        webSetting.setJavaScriptEnabled(true);
//        webSetting.setDomStorageEnabled(true);
//        final Activity activity = this;
//        webView.setWebChromeClient(new WebChromeClient(){
//            public void onProgressChanged(WebView view, int progress){
//                activity.setProgress(progress * 1000);
//            }
//        });
//        webView.setWebViewClient(new WebViewClient(){
//            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
//            }
//
//        });
        webView.setWebViewClient(new WebViewClient());
//        webView.clearCache(true);
//        webView.clearHistory();
        webView.loadUrl(webUrl);

    }

}


