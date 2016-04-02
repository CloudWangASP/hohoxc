package com.hohoxc.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.hohoxc.R;
import com.hohoxc.fragment.HomeFragment;

public class HomeActivity extends ContainerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFragment(new HomeFragment());
    }

    @Override
    public int getContentViewID() {
        return R.layout.activity_home;
    }

    @Override
    public void initToolbar(ActionBar toolbar) {
    }
}
