package com.example.milton.lavid_player;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*String VideoURL = ("udp://192.168.0.3:1234");
        //String VideoURL = ("https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4");
        //String VideoURL = ("rtp://192.168.0.3:5004");
        VideoView video = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video);

        Uri v = Uri.parse(VideoURL);

        video.setMediaController(mediaController);
        video.setVideoURI(v);
        video.start();*/
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    //Your code goes here
                    ClienteAndroid android = new ClienteAndroid(8080, "192.168.0.4", "Preciso de dados");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }
}
