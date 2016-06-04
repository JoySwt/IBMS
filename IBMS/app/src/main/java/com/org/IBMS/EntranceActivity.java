package com.org.IBMS;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.org.IBMS.adapter.EntranceAdapter;
import com.org.IBMS.data.EntranceStatusData;
import com.org.IBMS.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import static com.org.IBMS.data.EntranceStatusData.getEntranceDatas;

public class EntranceActivity extends AppCompatActivity {
    private MenuItem item1, item2, item3;
    private RecyclerView rv;
    private List<EntranceStatusData> datas;
    private TextView tvFloor;
    private EntranceAdapter ea;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrance_main);
        //
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        item1 = (MenuItem) findViewById(R.id.setting_1);
        item2 = (MenuItem) findViewById(R.id.setting_2);
        item3 = (MenuItem) findViewById(R.id.setting_3);
        tvFloor = (TextView) findViewById(R.id.tvFloor);
        onCreateRecyclerView();
    }

    private void onCreateRecyclerView() {
        datas = new ArrayList<>();
        rv = (RecyclerView) findViewById(R.id.id_recyclerview);
        ea = new EntranceAdapter(this, datas);
        rv.setAdapter(ea);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        ea.setOnItemClickListener(new EntranceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.setClass(EntranceActivity.this, LogActivity.class);
                intent.putExtra("id",datas.get(position).getId());
                startActivity(intent);
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(EntranceActivity.this, "请先选择楼层，然后再刷新！", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void refreshData(final int floor){
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                datas.clear();
                datas.addAll(getEntranceDatas(floor));
                ea.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        /**
         * 在onCreateOptionsMenu执行后，菜单被显示前调用；如果菜单已经被创建，则在菜单显示前被调用。 同样的，
         * 返回true则显示该menu,false 则不显示; （可以通过此方法动态的改变菜单的状态，比如加载不同的菜单等）
         * TODO
         * Auto-generated method stub
         */
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        /**
         * 每次菜单被关闭时调用. （菜单被关闭有三种情形，menu按钮被再次点击、back按钮被点击或者用户选择了某一个菜单项）
         * TODO
         * Auto-generated method stub
         */
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting_1:
                Toast.makeText(EntranceActivity.this, "正在获取门禁信息，请稍后", Toast.LENGTH_SHORT).show();
                tvFloor.setText("第一层");
                datas.clear();
                datas.addAll(getEntranceDatas(1));
                ea.notifyDataSetChanged();
//                refreshData(1);下面一行测试时候用
                refreshData(2);
                break;
            case R.id.setting_2:
                Toast.makeText(EntranceActivity.this, "正在获取门禁信息，请稍后", Toast.LENGTH_SHORT).show();
                tvFloor.setText("第二层");
                datas.clear();
                datas.addAll(getEntranceDatas(2));
                ea.notifyDataSetChanged();
                refreshData(2);
                break;
            case R.id.setting_3:
                Toast.makeText(EntranceActivity.this, "正在获取门禁信息，请稍后", Toast.LENGTH_SHORT).show();
                tvFloor.setText("第三层");
                datas.clear();
                datas.addAll(getEntranceDatas(3));
                ea.notifyDataSetChanged();
                refreshData(3);
                break;
        }
        return false;
    }


}
