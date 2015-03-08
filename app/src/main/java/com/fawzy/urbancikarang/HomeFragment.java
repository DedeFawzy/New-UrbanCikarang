package com.fawzy.urbancikarang;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class HomeFragment extends Fragment {
    View rootView;

    private WebView urbanWeb;
    private ProgressBar progressBar;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:{
                    webViewGoBack();
                }break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home, container, false);
        urbanWeb = (WebView) rootView.findViewById(R.id.activity_master_webview);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);


        WebSettings webSettings = urbanWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        urbanWeb.loadUrl("http://www.urbancikarang.com/v2/");
        urbanWeb.setWebViewClient(new mWebViewClient());
        urbanWeb.getSettings().setSupportZoom(true);
        urbanWeb.getSettings().setBuiltInZoomControls(true);
        urbanWeb.getSettings().setUseWideViewPort(true);
        urbanWeb.getSettings().setLoadWithOverviewMode(true);
        urbanWeb.setOnKeyListener(new View.OnKeyListener(){

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && urbanWeb.canGoBack()) {
                    handler.sendEmptyMessage(1);
                    return true;
                }
                return false;
            }

        });

        return rootView;
    }

    private void webViewGoBack()
    {
        if
                (urbanWeb.canGoBack()){
            urbanWeb.goBack();
        }
    }

    public class mWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }
}
