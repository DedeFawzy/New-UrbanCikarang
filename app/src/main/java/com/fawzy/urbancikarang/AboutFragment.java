package com.fawzy.urbancikarang;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AboutFragment extends Fragment {
    View rootview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.about, container, false);

        Button creditButton = (Button) rootview.findViewById(R.id.creditButton);
        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creditList();
            }
        });

        Button changelogButton = (Button) rootview.findViewById(R.id.changelogButton);
        changelogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changelog();
            }
        });

        return rootview;

    }

    protected void creditList() {
        Intent intent = new Intent(getActivity(), Devs.class);
        AboutFragment.this.startActivity(intent);
    }

    protected void changelog() {
        Intent intent = new Intent(getActivity(), Changelog.class);
        AboutFragment.this.startActivity(intent);
    }


}