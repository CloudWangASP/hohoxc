package com.hohoxc.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hohoxc.R;
import com.hohoxc.fragment.BaseFragment;

/**
 * Created by cloud_wang on 16/4/2.
 */
public abstract class ToolbarActivity extends BaseActivity {
    public Toolbar toolbar;
    public AppBarLayout appBar;

    private boolean navigationBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initToolbar(getSupportActionBar());
    }

    public void setNavigationBackEnabled(ActionBar toolbar) {
        toolbar.setDisplayShowHomeEnabled(true);
        toolbar.setDisplayHomeAsUpEnabled(true);
        navigationBack = true;
    }

    public void setTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (navigationBack && item.getItemId() == android.R.id.home) {
            backPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void removeAppBarShadow() {
        setAppBarElevation(0f);
    }

    public void showAppBarShadow() {
        setAppBarElevation(8f);
    }

    private void setAppBarElevation(float elevation) {
        if (appBar == null) {
            appBar = (AppBarLayout) findViewById(R.id.app_bar);
        }
        if (Build.VERSION.SDK_INT >= 21 && appBar != null) {
            appBar.setElevation(elevation);
        }
    }

    public abstract void initToolbar(ActionBar toolbar);

    @Override
    public void onBackPressed() {
        backPressed();
    }

    public void backPressed() {
        BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment == null || !fragment.reallyWantToDoSomethingWhenBackPressed()) {
            super.onBackPressed();
        } else {
            fragment.onBackPressed();
        }
    }
}
