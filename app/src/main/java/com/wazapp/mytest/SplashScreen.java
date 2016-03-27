package com.wazapp.mytest;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SplashScreen extends Activity {

    View _v;
    TextView version;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        version = (TextView) findViewById(R.id.version);
        try {
            String v = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            version.setText("version : " + v);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("tag", e.getMessage());
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
