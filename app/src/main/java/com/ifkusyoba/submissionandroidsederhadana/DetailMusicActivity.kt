package com.ifkusyoba.submissionandroidsederhadana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailMusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_music)

        val music = intent.getParcelableExtra<Music>("key_music")

        val imgMusic = findViewById<ImageView>(R.id.iv_item_photo)
        val nameMusic = findViewById<TextView>(R.id.tv_item_name)
        val descMusic = findViewById<TextView>(R.id.tv_item_description)
        val historyMusic = findViewById<TextView>(R.id.tv_item_history)

        imgMusic.setImageResource(music?.photo!!)
        nameMusic.text = music.name
        descMusic.text = music.description
        historyMusic.text = music.history
    }
}