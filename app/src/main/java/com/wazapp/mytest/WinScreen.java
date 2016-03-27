package com.wazapp.mytest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WinScreen extends Fragment {

    View _v;

    public WinScreen() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _v = inflater.inflate(R.layout.fragment_win, container, false);
        return _v;
    }
}
