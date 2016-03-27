package com.wazapp.mytest;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Q1Fragment q1;
    private Q2Fragment q2;
    private  WinScreen win;
    private  FragmentTransaction _ft;
    private  FloatingActionButton _fab;
    private int step = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        q1 = new Q1Fragment();
        q2 = new Q2Fragment();
        win = new WinScreen();

        _ft = getSupportFragmentManager().beginTransaction();
        _ft.add(R.id.fragment_container, q1);
        _ft.commit();

        _fab = (FloatingActionButton) findViewById(R.id.fab);
        if (_fab != null) {
            _fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (step == 1) {
                        if (q1.getAnswer()) {
                            changeFrag(q2, q1, view);
                        } else
                            setFabToFalse(view);
                    }
                    else if (step == 2) {
                        if (q2.getAnswer()) {
                            changeFrag(win, q2, view);
                        } else
                            setFabToFalse(view);
                    }
                    else {
                        finish();
                    }
                }
            });
        }
    }

    public void changeFrag(Fragment f, Fragment to_hide, View v) {
        setFabToTrue(v);
        _ft = getSupportFragmentManager().beginTransaction();
        _ft.add(R.id.fragment_container, f);
        _ft.hide(to_hide);
        _ft.commit();
        step++;
    }

    public void setFabToTrue(View v) {
        Snackbar.make(v, "Bonne réponse !", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void setFabToFalse(View v) {
        Snackbar.make(v, "Nope ...", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}