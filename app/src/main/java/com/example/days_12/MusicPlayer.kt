package com.example.days_12

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar

class MusicPlayer : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var volSeekBar: SeekBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)

        volSeekBar = findViewById(R.id.volSeekBar)


        //mediaPlayer = MediaPlayer.create(this,R.raw.music)
        val url = "https://samplelib.com/lib/preview/mp3/sample-9s.mp3"
        mediaPlayer = MediaPlayer.create(this, Uri.parse(url))
        mediaPlayer.start()


        //seekbarın default değeri ile müziğin ses düzey değeri aynı olmalı
        mediaPlayer.setVolume(0.5f, 0.5f)
        volSeekBar.progress = 50


        volSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                val f1 = p1.toFloat() / 100
                mediaPlayer.setVolume(f1, f1)//sağ ve sol hoparlör için 2 defa f1 yaptık
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

    }

    override fun onBackPressed() {

        mediaPlayer.stop()
        finish()
    }
}