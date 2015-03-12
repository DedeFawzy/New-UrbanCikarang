package com.fawzy.urbancikarang;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CommunityFragment extends Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.komunitas, container, false);

        Button submitButton = (Button) rootview.findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitCommunity();
            }
        });


        return rootview;

    }

    protected void submitCommunity() {
        Intent fawzyIntent = new Intent(android.content.Intent.ACTION_SEND);
        String DedeFawzyEmailList[] = {"dede.fawzy@gmail.com"};
        fawzyIntent.putExtra(Intent.EXTRA_EMAIL, DedeFawzyEmailList);
        fawzyIntent.putExtra(Intent.EXTRA_SUBJECT, "Submit Community");
        fawzyIntent.putExtra(Intent.EXTRA_TEXT, "Describe your community including twitter account & Site (optional)");
        fawzyIntent.setType("plain/text");
        startActivity(Intent.createChooser(fawzyIntent, (getString(R.string.aksi))));
    }
}