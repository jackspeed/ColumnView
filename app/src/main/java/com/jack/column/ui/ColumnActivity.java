package com.jack.column.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jack.column.R;
import com.jack.column.views.ColumnView;

public class ColumnActivity extends AppCompatActivity implements View.OnClickListener {
    private ColumnView pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tvUp = findViewById(R.id.tv_up);
        ColumnView pa = findViewById(R.id.pp_a);
        pb = findViewById(R.id.pp_b);
        ColumnView pc = findViewById(R.id.pp_c);
        ColumnView pd = findViewById(R.id.pp_d);
        ColumnView pe = findViewById(R.id.pp_e);
        ColumnView pf = findViewById(R.id.pp_f);
        pa.setData(20, 50);
        pc.setData(28, 30);
        pe.setData(78, 100);
        pf.setData(21, 80);
        tvUp.setOnClickListener(this);



    }

    int value = 10;

    @Override
    public void onClick(View v) {
        value += 5;
        pb.setData(value);
    }
}
