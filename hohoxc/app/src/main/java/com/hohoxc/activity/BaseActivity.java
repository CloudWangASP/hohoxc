package com.hohoxc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by cloud_wang on 16/4/2.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewID());
        ButterKnife.bind(this);
        checkIntent();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void checkIntent() {
        onIntentFetched(getIntent());
    }

    public void onIntentFetched(Intent intent) {

    }

    public void startActivity(Class clazz) {
        startActivity(clazz, null);
    }

    public void startActivityThenFinish(Class clazz) {
        startActivity(clazz, null);
        finish();
    }

    public void startActivity(Class clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startActivityAndClearStack(Class clazz) {
        Intent intent = new Intent(this, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public abstract int getContentViewID();
}
