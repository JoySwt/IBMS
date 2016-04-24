package com.example.myapplicationdemo01;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
            boolean fitstIn=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view entrance_item clicks here.
        int id = item.getItemId();

        if (id == R.id.welcome) {
            if(fitstIn) {
                TextView tvHint = (TextView)findViewById(R.id.tvHint);
                tvHint.setText("如何使用:");
                tvHint.setTextSize(20);
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.howToUse);
                TextView t1 = new TextView(this);
                StringBuffer sb=new StringBuffer();
                sb.append("\n");
                sb.append("    1.请先将网络连接至电子楼局域网。");
                sb.append("\n\n");
                sb.append("    2.点击左侧的导航按钮可以看到导航界面，根据提示可以选择查看" +
                        "门禁信息，或者布防及撤防。");
                t1.setText(sb);
                t1.setTextSize(20);
                relativeLayout.addView(t1);
            }
        } else if (id == R.id.entrance) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, EntranceActivity.class);
            MainActivity.this.startActivity(intent);
        } else if (id == R.id.safe) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SafeActivity.class);
            MainActivity.this.startActivity(intent);
//            Intent intent = new Intent();
//            intent.setClass(MainActivity.this, LogActivity.class);
//            MainActivity.this.startActivity(intent);
        } else if (id == R.id.about) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, AboutActivity.class);
            MainActivity.this.startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
