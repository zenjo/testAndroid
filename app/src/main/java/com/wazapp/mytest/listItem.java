package com.wazapp.mytest;

public class listItem {
    String _msg;
    boolean _selected;
    public listItem(String msg) {
        _msg = msg;
        _selected = false;
    }

    public boolean changeNGetSelection() {
        if (_selected)
            _selected = false;
        else
            _selected = true;
        return _selected;
    }

    public String get_msg() {
        return _msg;
    }

}
