package com.ifkusyoba.submissionandroidsederhadana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMusic: RecyclerView
    private val list = ArrayList<Music>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMusic = findViewById(R.id.rv_music)
        rvMusic.hasFixedSize()

        list.addAll(getListMusic())
        showRecyclerList()
    }

    private fun getListMusic(): ArrayList<Music> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataHistory = resources.getStringArray(R.array.data_history)
        val listMusic = ArrayList<Music>()
        for (i in dataName.indices) {
            val music = Music(dataName[i], dataDescription[i],  dataPhoto.getResourceId(i, -1), dataHistory[i])
            listMusic.add(music)
        }
        return listMusic
    }

    private fun showRecyclerList() {
        rvMusic.layoutManager = LinearLayoutManager(this)
        val listMusicAdapter = ListMusicAdapter(list)
        rvMusic.adapter = listMusicAdapter
    }
    //Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about_me -> {
                val moveAbout = Intent(this@MainActivity, AboutUsActivity::class.java)
                startActivity(moveAbout)
            }
        }
        return true
    }
}