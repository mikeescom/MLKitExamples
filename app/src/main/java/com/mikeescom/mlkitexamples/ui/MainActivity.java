package com.mikeescom.mlkitexamples.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mikeescom.mlkitexamples.R;

public class MainActivity extends AppCompatActivity {

    private Button mImageLabelingBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListeners();
    }

    private void initView() {
        mImageLabelingBt = findViewById(R.id.image_labeling_button);
    }

    private void initListeners() {
        mImageLabelingBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageLabelingActivity.class);
                startActivity(intent);
            }
        });
    }
}
