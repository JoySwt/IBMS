package com.example.myapplicationdemo01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.myapplicationdemo01.adapter.LogAdapter;
import com.example.myapplicationdemo01.data.CheckinHistory;
import com.example.myapplicationdemo01.util.DividerItemDecoration;

import java.util.List;

public class LogActivity extends AppCompatActivity {
    private RecyclerView mRecycleview;
    private List<CheckinHistory> mDatas;
    private LogAdapter mLogAdapter;
    private long id;
    private TextView tvAssId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_main);
        Intent intent = getIntent();
        id = intent.getLongExtra("id",-1);
        mDatas=CheckinHistory.getLogs(id);
        tvAssId=(TextView)findViewById(R.id.tvAssetsId) ;
        tvAssId.setText("设备ID:"+id);
        mRecycleview=(RecyclerView)findViewById(R.id.id_LogRecyclerView);
        mRecycleview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mLogAdapter = new LogAdapter(this ,mDatas);
        mRecycleview.setAdapter(mLogAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycleview.setLayoutManager(llm);
    }
}
