package com.wazapp.mytest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Q1Fragment extends Fragment {

    private  View _v;
    private   EditText answer;

    public Q1Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _v = inflater.inflate(R.layout.fragment_q1, container, false);
        return _v;
    }

    public boolean getAnswer() {
       answer = (EditText) _v.findViewById(R.id.answer1);
        if (answer.getText().toString().equals("42")) {
            return true;
        } else {
            return false;
        }
    }
}
