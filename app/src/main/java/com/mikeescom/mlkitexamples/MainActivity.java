package com.mikeescom.mlkitexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mikeescom.mlkitexamples.imageLabeling.ImageLabelingActivity;
import com.mikeescom.mlkitexamples.smartReply.SmartReplyActivity;

public class MainActivity extends AppCompatActivity {

    private Button mImageLabelingBt;
    private Button mSmartReplyBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListeners();
    }

    private void initView() {
        mImageLabelingBt = findViewById(R.id.image_labeling_button);
        mSmartReplyBt = findViewById(R.id.smart_reply_button);
    }

    private void initListeners() {
        mImageLabelingBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImageLabelingActivity.class);
                startActivity(intent);
            }
        });
        mSmartReplyBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SmartReplyActivity.class);
                startActivity(intent);
            }
        });
    }
}
