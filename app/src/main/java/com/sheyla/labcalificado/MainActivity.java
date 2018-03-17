package com.sheyla.labcalificado;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private Button button;
    MediaController mediaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.videoview);
        mediaC = new MediaController(this);
//        videoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.snk));
        videoView.setMediaController(mediaC);
        mediaC.setAnchorView(videoView);
        videoView.start();

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openformularioActivity();
            }
        });
    }
        public void openformularioActivity(){
        Intent intent = new Intent(this, formularioActivity.class);
        startActivity(intent);
        }


}
