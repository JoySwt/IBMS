package com.org.IBMS.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.org.IBMS.R;
import com.org.IBMS.data.EntranceStatusData;

import java.util.List;

/**
 * Created by Joy on 2016/4/22.
 */
public class EntranceAdapter extends RecyclerView.Adapter<EntranceViewHolder> {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<EntranceStatusData> mDatas;

    public EntranceAdapter(Context mContext, List<EntranceStatusData> mDatas) {
        mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    public interface OnItemClickListener{
        void onItemClick(View view ,int position);
    }

    private OnItemClickListener ocl;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.ocl=listener;
    }
    @Override
    public EntranceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.entrance_item, parent, false);
        EntranceViewHolder ev = new EntranceViewHolder(view);
        return ev;

    }

    @Override
    public void onBindViewHolder(final EntranceViewHolder holder, final int position) {
        holder.tv.setText(Long.toString(mDatas.get(position).getId()));
        holder.tv1.setText(mDatas.get(position).getName());
        holder.tv2.setText(mDatas.get(position).getAssetsStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ocl!=null){
                    ocl.onItemClick(holder.itemView,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class EntranceViewHolder extends RecyclerView.ViewHolder {
    TextView tv, tv1, tv2;

    public EntranceViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tvId);
        tv1 = (TextView) itemView.findViewById(R.id.tvName);
        tv2 = (TextView) itemView.findViewById(R.id.tvassetsStatus);
    }


}