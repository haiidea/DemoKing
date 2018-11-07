package haiidea.com.demohaiidea.animation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import haiidea.com.demohaiidea.R;

/**
 * Created by Administrator on 2018/5/3.
 */

public class DouhaoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
