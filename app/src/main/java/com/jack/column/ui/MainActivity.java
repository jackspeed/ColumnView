package com.jack.column.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jack.column.R;
import com.jack.column.utils.ScreenUtils;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScreenUtils.init(this);
    }

    public void onClick(View v) {
        startActivity(new Intent(this, ColumnActivity.class));
    }

    public void onClick2(View v) {
        startActivity(new Intent(this, NumberColumnActivity.class));
    }
}
