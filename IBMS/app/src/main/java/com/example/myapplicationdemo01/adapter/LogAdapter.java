package com.example.myapplicationdemo01.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplicationdemo01.R;
import com.example.myapplicationdemo01.data.CheckinHistory;

import java.util.Date;
import java.util.List;

/**
 * Created by Joy on 2016/4/23.
 */
public class LogAdapter extends RecyclerView.Adapter<LogViewHolder>{
    private LayoutInflater mInflater;
    private Context mContext;
    private List<CheckinHistory> mDatas;
    public LogAdapter(Context context, List<CheckinHistory> datas) {
        this.mContext=context;
        this.mDatas=datas;
        mInflater= LayoutInflater.from(context);
    }

    @Override
    public LogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.log_item,parent,false);
        LogViewHolder viewholder = new LogViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(LogViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position).getUserName());
        Date tmp = mDatas.get(position).getCheckTime();
        String time = DateFormat.format("yyyy-MM-dd kk:mm:ss", tmp).toString();
        holder.tv1.setText(time);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
class LogViewHolder extends RecyclerView.ViewHolder{
    TextView tv,tv1;
    public LogViewHolder(View itemView) {
        super(itemView);
        tv=(TextView)itemView.findViewById(R.id.tvUserName);
        tv1=(TextView)itemView.findViewById(R.id.tvCheckinTime) ;
    }
}