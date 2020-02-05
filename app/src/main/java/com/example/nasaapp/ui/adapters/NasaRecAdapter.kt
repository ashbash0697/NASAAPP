package com.example.nasaapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.nasaapp.R
import com.example.nasaapp.model.DataModel
import kotlinx.android.synthetic.main.nasa_list_item.view.*

class NasaRecAdapter(
    val glide: RequestManager,
    val listner: RecItemClickListner,
    val imgList: Array<DataModel>
):
    RecyclerView.Adapter<NasaRecAdapter.NasaImgVH>() {

    interface RecItemClickListner{

        fun onNasaImgClick(position: Int)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaImgVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nasa_list_item, parent, false)
        return NasaImgVH(view)
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    override fun onBindViewHolder(holder: NasaImgVH, position: Int) {
        val item = imgList[position]
        glide.load(item.url).into(holder.itemView.nasaImageView)
        holder.itemView.nasaTitleTxt.text = item.title
        holder.itemView.setOnClickListener { listner.onNasaImgClick(position) }
    }



    class  NasaImgVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}