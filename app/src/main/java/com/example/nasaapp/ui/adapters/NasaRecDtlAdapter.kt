package com.example.nasaapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.nasaapp.R
import com.example.nasaapp.model.DataModel
import kotlinx.android.synthetic.main.nasa_list_dtl_item.view.*

class NasaRecDtlAdapter(val glide: RequestManager, val imgList: Array<DataModel>) :
    RecyclerView.Adapter<NasaRecDtlAdapter.NasaDtlVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaDtlVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nasa_list_dtl_item, parent, false)
        return NasaDtlVH(view)
    }

    override fun getItemCount(): Int {
       return imgList.size
    }

    override fun onBindViewHolder(holder: NasaDtlVH, position: Int) {
        val item = imgList[position]
        glide.load(item.url).into(holder.itemView.nasaDtlImage)
        holder.itemView.nasaTitle.text = item.title
        holder.itemView.nasaDesc.text = item.explanation
        holder.itemView.nasaDate.text = item.date
    }


    class NasaDtlVH(itemView: View) : RecyclerView.ViewHolder(itemView)

}