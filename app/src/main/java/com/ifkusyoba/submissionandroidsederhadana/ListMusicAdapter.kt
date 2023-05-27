package com.ifkusyoba.submissionandroidsederhadana

import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListMusicAdapter(private val listMusic : ArrayList<Music>) : RecyclerView.Adapter<ListMusicAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_music, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMusic.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback{
        fun onItemClicked(data: Music)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listMusic[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listMusic[holder.adapterPosition]) }

        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, DetailMusicActivity::class.java)
            intentDetail.putExtra("key_music", listMusic[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}