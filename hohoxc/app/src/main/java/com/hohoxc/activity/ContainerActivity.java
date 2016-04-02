package com.hohoxc.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.hohoxc.R;

/**
 * Created by cloud_wang on 16/4/2.
 */
public abstract class ContainerActivity extends ToolbarActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void replaceFragment(Fragment fragment) {
        replaceFragment(fragment, false);
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        if (fragment == null || fragment == getSupportFragmentManager().findFragmentById(R.id.container))
            return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    @Override
    public int getContentViewID() {
        return R.layout.activity_hosting;
    }
}
