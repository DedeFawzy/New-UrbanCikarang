package com.fawzy.urbancikarang;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class TwitFragment extends Fragment {
    View rootview;
    private WebView urbanTwit;
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

    private static final String baseURl = "https://twitter.com";

    private static final String widgetInfo =
            "<a class=\"twitter-timeline\"  href=\"https://twitter.com/UrbanCikarang\" data-widget-id=\"558178304138555392\">Loading Tweets by \"@UrbanCikarang...\"</a> " +
                    "<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+\"://platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");</script>";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.twit, container, false);

        load_background_color();

        urbanTwit = (WebView) rootview.findViewById(R.id.activity_twit_webview);
        urbanTwit.getSettings().setDomStorageEnabled(true);
        urbanTwit.getSettings().setJavaScriptEnabled(true);
        urbanTwit.setWebViewClient(new WebViewClient());

        urbanTwit.loadDataWithBaseURL(baseURl, widgetInfo, "text/html", "UTF-8", null);

        urbanTwit.setOnKeyListener(new View.OnKeyListener(){

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && urbanTwit.canGoBack()) {
                    handler.sendEmptyMessage(1);
                    return true;
                }
                return false;
            }

        });

        return rootview;

    }

    private void webViewGoBack(){
        urbanTwit.goBack();
    }

    private void load_background_color() {
        urbanTwit = (WebView) rootview.findViewById(R.id.activity_twit_webview);
        urbanTwit.setBackgroundColor(0);
    }
}
