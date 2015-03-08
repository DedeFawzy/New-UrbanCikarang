package com.fawzy.urbancikarang;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class Changelog extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changelog_viewer);

        try {
            final PackageManager packageManager = getPackageManager();
            PackageInfo pinfo = packageManager.getPackageInfo(getPackageName(), 0);
            setTitle("Current Version: " + pinfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("NameNotFoundException", e.getMessage());
        }

        WebView mChangelog = (WebView) findViewById(R.id.changelogView);
        WebSettings webSettings = mChangelog.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mChangelog.loadUrl("file:///android_asset/changelog.html");
    }
}