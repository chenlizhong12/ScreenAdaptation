package com.company.screenadaptation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import com.company.screenadaptation.UIUtils.MetricsUtils;
import com.company.screenadaptation.UIUtils.ViewCalculateUtil;

public class MainActivity extends AppCompatActivity {

    private TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv1 = findViewById(R.id.tvText3);
        MetricsUtils.getInstance(this);
        ViewCalculateUtil.setViewRelativeLayoutParams(mTv1, 500, 100, 10,2,3,4);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MetricsUtils.notifyInstance(this);
    }
}
