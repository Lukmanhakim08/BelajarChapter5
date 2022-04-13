package com.example.belajarchapter5.PertemuanKedua.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.belajarchapter5.PertemuanKedua.Adapter.AdapterFilm.*
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllFilmResponseItem
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.item_filem.view.*

data class AdapterFilm(private var datafilm : List<GetAllFilmResponseItem>, private var onclick : (GetAllFilmResponseItem)->Unit) : RecyclerView.Adapter<ViewHolder>(){

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.text_judulfilm.text = datafilm[position].name
        holder.itemView.text_tglfilm.text = datafilm[position].date
        holder.itemView.text_sutradara.text = datafilm[position].director

        //get data dan menampilkan gambar
        Glide.with(holder.itemView.context)
            .load(datafilm[position].image)
            .into(holder.itemView.img_film)

        holder.itemView.card_film.setOnClickListener {
            onclick(datafilm[position])
        }
    }

    override fun getItemCount(): Int {
        return datafilm.size
    }

}
