package com.wazapp.mytest;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<listItem> {

    List<listItem> _answers;
    List<Integer> clicked;

    public ItemAdapter(Context context, List<listItem> list) {
        super(context,R.layout.fragment_q2, list);
         _answers = list;
        clicked = new ArrayList<Integer>();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itemforlistview,parent, false);
        }

        ItemViewHolder viewHolder = (ItemViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ItemViewHolder();
            viewHolder.answer = (TextView) convertView.findViewById(R.id.answer);
            viewHolder.checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);

            convertView.setTag(viewHolder);
        }

        listItem it = getItem(position);
        viewHolder.answer.setText(it.get_msg());
        return convertView;
    }

    public List<Integer> getClicked() {
        return clicked;
    }

    public class ItemViewHolder {
        public TextView answer;
        public CheckBox checkbox;
    }
}