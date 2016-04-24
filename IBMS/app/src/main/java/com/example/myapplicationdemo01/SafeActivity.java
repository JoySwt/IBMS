package com.example.myapplicationdemo01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SafeActivity extends AppCompatActivity {
    private TextView safeTip;
    private Switch safeSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safe_main);
        safeTip=(TextView)findViewById(R.id.safeTip);
        safeSwitch=(Switch)findViewById(R.id.safeSwitch);
        safeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //设防
                    Toast.makeText(SafeActivity.this, "已经设防！", Toast.LENGTH_SHORT).show();
                } else {
                    //撤防
                    Toast.makeText(SafeActivity.this, "已经撤防！", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
