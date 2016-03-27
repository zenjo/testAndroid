package com.wazapp.mytest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Q2Fragment extends Fragment {

    private ListView _viewlist;
    private View _view;
    private List<String>     _someAnswersBis;
    private List<String>   _playersAnswers;
    private List<listItem>     _someAnswers;
    //    private ItemAdapter adapter;
    private ArrayAdapter<String> adapter;

    public Q2Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        _view = inflater.inflate(R.layout.fragment_q2, container, false);
        _viewlist = (ListView) _view.findViewById(R.id.listAnswers2);
        _playersAnswers = new ArrayList<String>();
        initListItem();
        setListView();

        _viewlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                //_viewlist.getChildAt(position).setBackgroundColor(Color.GRAY);
                if (_someAnswers.get(position).changeNGetSelection()) {
                    _playersAnswers.add(_someAnswers.get(position).get_msg());
                    v.setBackgroundColor(Color.GRAY);
                }
                else {
                    _playersAnswers.remove(_someAnswers.get(position).get_msg());
                    v.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });
        return _view;
    }

    public void initListItem() {
        _someAnswers = new ArrayList<listItem>();
        _someAnswersBis = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            _someAnswersBis.add("Mauvaise Réponse no " + i);
            _someAnswers.add(new listItem("Mauvaise Réponse no " + i));
        }
        _someAnswers.add(new listItem("Bonne Réponse"));
        _someAnswersBis.add("Bonne Réponse");
        for (int i = 0; i < 5; i++) {
            _someAnswersBis.add("Mauvaise Réponse no " + (i + 5));
            _someAnswers.add(new listItem("Mauvaise Réponse no " + (i + 5)));
        }

    }

    public void setListView() {
        //adapter = new ItemAdapter(getContext(), _someAnswers);
        adapter = new ArrayAdapter<String> (getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, _someAnswersBis);
        _viewlist.setAdapter(adapter);
    }

    public boolean getAnswer() {
        boolean ret;
        if (_playersAnswers.size() == 1 && _playersAnswers.get(0).equals("Bonne Réponse"))
            ret = true;
        else {
            ret = false;
            _playersAnswers = new ArrayList<String>();
            initListItem();
            setListView();
        }
        return ret;
    }
}