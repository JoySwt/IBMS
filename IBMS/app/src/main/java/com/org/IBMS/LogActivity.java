package com.org.IBMS;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.org.IBMS.adapter.LogAdapter;
import com.org.IBMS.data.CheckinHistory;
import com.org.IBMS.util.DividerItemDecoration;

import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

public class LogActivity extends AppCompatActivity {
    private RecyclerView mRecycleview;
    private List<CheckinHistory> mDatas;
    private LogAdapter mLogAdapter;
    private long id;
    private TextView tvAssId;
    private MenuItem openDoor;
    private String ip;
    private int port;
    private Socket socket;
    private PrintStream output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_main);
        Intent intent = getIntent();
        id = intent.getLongExtra("id",-1);
        openDoor = (MenuItem)findViewById(R.id.setting_opendoor);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.opendoor, menu);
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
        switch (item.getItemId()){
            case R.id.setting_opendoor:
                ip="192.168.1.134";
                port = 5555;
                clientWork(ip,port);
                break;
        }
        return false;
    }

    private void clientWork(String ip, int port) {
        try{
            socket = new Socket(ip,port);
            output = new PrintStream(socket.getOutputStream());
            output.print("2");
            socket.close();
            Toast.makeText(LogActivity.this, "门已打开！", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(LogActivity.this, "开门失败，请确认网络连接正常！", Toast.LENGTH_SHORT).show();
        }
    }
}
