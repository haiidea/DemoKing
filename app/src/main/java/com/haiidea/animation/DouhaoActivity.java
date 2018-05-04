package com.haiidea.animation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2018/5/3.
 */

public class DouhaoActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.douhao_layout);
        DuiGouToAddView view = findViewById(R.id.duigou_dougouview);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("", "onClick=");
            }
        });
    }
}
