package com.gpillaca.exampletabs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mTabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.tabFrameLayout);

        mTabHost.addTab(mTabHost.newTabSpec("tab1")
                        .setIndicator(getTabIndicator(mTabHost.getContext(), R.string.title1, 4, android.R.drawable.star_on)),
                FragmentTab.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab2").setIndicator(getTabIndicator(mTabHost.getContext(),R.string.title2, 76, android.R.drawable.star_on)),
                FragmentTab.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("tab3").setIndicator(getTabIndicator(mTabHost.getContext(), R.string.title3, 9, android.R.drawable.star_on)),
                FragmentTab.class, null);
    }

    private View getTabIndicator(Context context, int title, int num, int icon) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout, null);
        ImageView iv = view.findViewById(R.id.imageView);
        iv.setImageResource(icon);
        TextView tv =  view.findViewById(R.id.textView);
        TextView number_tv =  view.findViewById(R.id.number_tv);
        tv.setText(title);
        number_tv.setText(String.valueOf(num));
        return view;
    }
}