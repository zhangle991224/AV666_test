package com.xxoo.av666.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xxoo.av666.R;
import com.xxoo.av666.widget.media.IRenderView;
import com.xxoo.av666.widget.media.IjkVideoView;

/**
 * Created by zhangle on 2017/5/13.
 */
public class VideoActivity  extends AppCompatActivity {
    private IjkVideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = (IjkVideoView) findViewById(R.id.video_view);
        videoView.setAspectRatio(IRenderView.AR_ASPECT_FIT_PARENT);
        videoView.setVideoURI(Uri.parse("http://192.133.81.234:8080/mp43/213595.mp4?st=DubhXAXzuvEsMrT5QLXITw&e=1494700049"));
        videoView.start();

    }

}
