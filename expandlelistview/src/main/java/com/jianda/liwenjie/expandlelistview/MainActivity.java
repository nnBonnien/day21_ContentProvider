package com.jianda.liwenjie.expandlelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ExpandableListView;

import com.jianda.liwenjie.expandlelistview.adapters.TeachAdapter;
import com.jianda.liwenjie.expandlelistview.model.Child;
import com.jianda.liwenjie.expandlelistview.model.Father;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private List<Father> data;
    private TeachAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        listView = (ExpandableListView) findViewById(R.id.expand_list_view);
        adapter = new TeachAdapter(getData(),this);
        listView.setAdapter(adapter);
    }

    public List<Father> getData() {
        List<Father> data = new ArrayList<Father>();
        for (int i = 0; i < 5; i++) {
            Father father = new Father();
            father.setName("father"+i);
            List<Child> childs = new ArrayList<Child>();
            for (int j = 0; j < 8; j++) {
                Child child = new Child();
                child.setName("child"+i);
                childs.add(child);
            }
            father.setChildren(childs);
            data.add(father);
        }

        return data;
    }
}
