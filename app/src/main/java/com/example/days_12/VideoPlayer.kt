package com.example.days_12

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class VideoPlayer : AppCompatActivity() {

    lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        videoView = findViewById(R.id.videoView)

        val videoController = MediaController(this)
        videoController.setMediaPlayer(videoView)
        videoView.setMediaController(videoController)

       //val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video)
        val uri = Uri.parse("https://file-examples.com/storage/fea9880a616463cab9f1575/2017/04/file_example_MP4_1280_10MG.mp4")

        videoView.setVideoURI(uri)
        videoView.start()
    }
}