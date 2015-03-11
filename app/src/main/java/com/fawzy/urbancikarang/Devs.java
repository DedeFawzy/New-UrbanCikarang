package com.fawzy.urbancikarang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;


public class Devs extends ActionBarActivity {
    ImageButton imageView;
    ImageLoader imgloader;
    String imgurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_list);
        setTitle("The Developers & Contributors");

        int loader = R.mipmap.ic_launcher;
        imageView = (ImageButton) findViewById(R.id.dp_urban);
        imgurl = ("https://pbs.twimg.com/profile_images/571856361047085056/d9sdMiVz.png");
        imgloader = new ImageLoader(getApplicationContext());
        imgloader.DisplayImage(imgurl, loader, imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://twitter.com/UrbanCikarang"));
                startActivity(intent);
            }
        });

        loader = R.mipmap.ic_launcher;
        imageView = (ImageButton) findViewById(R.id.dp_bais);
        imgurl = ("https://pbs.twimg.com/profile_images/556671565471834112/D_Rd0vOL.jpeg");
        imgloader = new ImageLoader(getApplicationContext());
        imgloader.DisplayImage(imgurl, loader, imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://twitter.com/linimasaku"));
                startActivity(intent);
            }
        });

        loader = R.mipmap.ic_launcher;
        imageView = (ImageButton) findViewById(R.id.dp_aing);
        imgurl = ("https://pbs.twimg.com/profile_images/564724879417569280/jlkOhxgn.jpeg");
        imgloader = new ImageLoader(getApplicationContext());
        imgloader.DisplayImage(imgurl, loader, imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://twitter.com/FawzyDede"));
                startActivity(intent);
            }
        });

        loader = R.mipmap.ic_launcher;
        imageView = (ImageButton) findViewById(R.id.dp_vikar);
        imgurl = ("https://pbs.twimg.com/profile_images/516166443872706561/b3uDjWih.jpeg");
        imgloader = new ImageLoader(getApplicationContext());
        imgloader.DisplayImage(imgurl, loader, imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://twitter.com/VikarELMahdi"));
                startActivity(intent);
            }
        });

        loader = R.mipmap.ic_launcher;
        imageView = (ImageButton) findViewById(R.id.dp_gentong);
        imgurl = ("https://pbs.twimg.com/profile_images/556025895475900416/-A6Gc_ko.jpeg");
        imgloader = new ImageLoader(getApplicationContext());
        imgloader.DisplayImage(imgurl, loader, imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://twitter.com/Gentong90"));
                startActivity(intent);
            }
        });

    }
}
