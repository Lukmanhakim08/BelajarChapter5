package com.example.belajarchapter5.PertemuanKedua.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarchapter5.PertemuanKedua.Model.GetAllUserItem
import com.example.belajarchapter5.R
import kotlinx.android.synthetic.main.item_user.view.*

data class AdapterUser(private var datauser : List<GetAllUserItem>) : RecyclerView.Adapter<AdapterUser.ViewHolder>(){
    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterUser.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return AdapterUser.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterUser.ViewHolder, position: Int) {
        holder.itemView.text_nama.text = datauser[position].name
        holder.itemView.text_alamat.text = datauser[position].address
        holder.itemView.text_umur.text = datauser[position].umur.toString()
    }

    override fun getItemCount(): Int {
        return datauser.size
    }

}
