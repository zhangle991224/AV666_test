package com.xxoo.av666;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.Request;
import com.xxoo.av666.activity.VideoActivity;
import com.xxoo.av666.activity.WaterfallActivity;
import com.xxoo.av666.http.OkHttpClientManager;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private OkHttpClientManager clientManager;

    private TextView testText;

    private Button pull;
    private Button video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientManager = OkHttpClientManager.getInstance();

        testText = (TextView) findViewById(R.id.test);
        pull = (Button) findViewById(R.id.pull);
        video = (Button) findViewById(R.id.video);
        pull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WaterfallActivity.class));
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VideoActivity.class));
            }
        });

        httpManagerRequest();
    }

    private void httpManagerRequest(){
        Map<String,  String> requestParams = new HashMap<>();
        requestParams.put("method","post");
        requestParams.put("ip", "221.217.176.144");
        String url = "http://ip.taobao.com/service/getIpInfo2.php";

        clientManager.postAsyn(url, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                testText.setText(response);
                System.out.println("success"+response);
            }
        },requestParams);
    }
}
