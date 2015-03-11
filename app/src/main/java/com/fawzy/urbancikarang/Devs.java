package com.fawzy.urbancikarang;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;


public class Devs extends ActionBarActivity {
    ImageView imageView;
    ImageLoader imgloader;
    String imgurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_list);
        setTitle("The Developers & Contributors");

        int loader = R.mipmap.ic_launcher;
        imageView = (ImageView) findViewById(R.id.imageView1);
        imgurl = ("https://pbs.twimg.com/profile_images/571856361047085056/d9sdMiVz.png");
        imgloader = new ImageLoader(getApplicationContext());
        imgloader.DisplayImage(imgurl, loader, imageView);

        loader = R.mipmap.ic_launcher;
        imageView = (ImageView) findViewById(R.id.imageView2);
        imgurl = ("https://pbs.twimg.com/profile_images/564724879417569280/jlkOhxgn.jpeg");
        imgloader = new ImageLoader(getApplicationContext());
        imgloader.DisplayImage(imgurl, loader, imageView);

        loader = R.mipmap.ic_launcher;
        imageView = (ImageView) findViewById(R.id.imageView3);
        imgurl = ("https://pbs.twimg.com/profile_images/516166443872706561/b3uDjWih.jpeg");
        imgloader = new ImageLoader(getApplicationContext());
        imgloader.DisplayImage(imgurl, loader, imageView);

        loader = R.mipmap.ic_launcher;
        imageView = (ImageView) findViewById(R.id.imageView4);
        imgurl = ("https://pbs.twimg.com/profile_images/556025895475900416/-A6Gc_ko.jpeg");
        imgloader = new ImageLoader(getApplicationContext());
        imgloader.DisplayImage(imgurl, loader, imageView);

    }
}
