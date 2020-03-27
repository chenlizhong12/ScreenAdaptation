package com.company.screenadaptation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.company.screenadaptation.UIUtils.DensityUtils;

import java.util.HashMap;
import java.util.Map;

public class DensityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DensityUtils.setDensity(getApplication(), this);
        setContentView(R.layout.activity_density);
    }
}
