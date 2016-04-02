package com.hohoxc.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hohoxc.activity.BaseActivity;
import com.hohoxc.activity.ToolbarActivity;

import butterknife.ButterKnife;

/**
 * Created by cloud_wang on 16/4/2.
 */
public abstract class BaseFragment extends Fragment {
    private View rootView;
    private boolean wantToDoSomethingWhenBackPressed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getFragmentLayoutID(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    public View getRootView() {
        return rootView;
    }

    /**
     * set the toolbar title of the hosting activity
     */
    public void setToolbarTitle(String title) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
    }

    public ActionBar getToolbar() {
        return ((AppCompatActivity) getActivity()).getSupportActionBar();
    }


    /**
     * @return the layout resource of fragment layout
     */
    public abstract int getFragmentLayoutID();

    public void removeAppBarShadow() {
        ToolbarActivity activity = ((ToolbarActivity) getActivity());
        if (activity != null) {
            activity.removeAppBarShadow();
        }
    }

    public void startActivity(Class clazz) {
        ((BaseActivity) getActivity()).startActivity(clazz);
    }

    public void startActivityAndClearStack(Class clazz) {
        ((BaseActivity) getActivity()).startActivityAndClearStack(clazz);
    }

    public void onBackPressed(){

    }

    public boolean reallyWantToDoSomethingWhenBackPressed() {
        return wantToDoSomethingWhenBackPressed;
    }

    public void setWantToDoSomethingWhenBackPressed(boolean wantToDoSomethingWhenBackPressed) {
        this.wantToDoSomethingWhenBackPressed = wantToDoSomethingWhenBackPressed;
    }

    public int getColor(int color){
        return getResources().getColor(color);
    }
}
