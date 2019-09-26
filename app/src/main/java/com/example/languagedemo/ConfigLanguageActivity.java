package com.example.languagedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ConfigLanguageActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private MyAdapter mAdapter;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_language);
        mRv=findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));

        mData=getData();
        mAdapter=new MyAdapter(mData);
        mAdapter.setOnItemClick(new MyAdapter.OnItemClick() {
            @Override
            public void onItemClick(int pos) {
                showToast(""+pos);
            }
        });
        mRv.setAdapter(mAdapter);
    }

    private void showToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    private List<String> getData() {
        List<String> list=new ArrayList<>();
        list.add("跟随系统");
        list.add("简体中文");
        list.add("English");
        return list;
    }
}
