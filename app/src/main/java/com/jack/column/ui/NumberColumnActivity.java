package com.jack.column.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jack.column.R;
import com.jack.column.views.NumberColumnView;

public class NumberColumnActivity extends AppCompatActivity implements View.OnClickListener {
    private NumberColumnView pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tvUp = findViewById(R.id.tv_up);
        NumberColumnView pa = findViewById(R.id.pp_a);
        pb = findViewById(R.id.pp_b);
        NumberColumnView pc = findViewById(R.id.pp_c);
        NumberColumnView pd = findViewById(R.id.pp_d);
        NumberColumnView pe = findViewById(R.id.pp_e);
        NumberColumnView pf = findViewById(R.id.pp_f);
        pa.setData(20, 50);
        pc.setData(28, 30);
        pd.setData(8, 69);
        pe.setData(78, 100);
        pf.setData(21, 80);
        tvUp.setOnClickListener(this);
    }

    int value = 3;

    @Override
    public void onClick(View v) {
        value += 3;
        pb.setData(value);
    }
}
