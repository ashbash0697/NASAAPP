package com.example.nasaapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasaapp.NASAAPPApplication
import com.example.nasaapp.NASAViewModelFactory
import com.example.nasaapp.R
import com.example.nasaapp.ui.adapters.NasaRecAdapter
import com.example.nasaapp.ui.adapters.NasaRecDtlAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NasaRecAdapter.RecItemClickListner {

    private val mainVm by lazy { ViewModelProviders.of(this, NASAViewModelFactory(application as NASAAPPApplication)).get(MainActivityViewModel::class.java) }

    lateinit var snapHelper: PagerSnapHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val imgAdapter = NasaRecAdapter(Glide.with(this), this, mainVm.jsonData)
            val layoutManager = GridLayoutManager(this, 2)
            mainRecView.layoutManager = layoutManager
            mainRecView.adapter = imgAdapter

    }

    override fun onNasaImgClick(position: Int) {

      //  val adapter = NasaRecAdapter(Glide.with(this), this, it)

        val imgDtlAdapter = NasaRecDtlAdapter(Glide.with(this), mainVm.jsonData)

        mainRecView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(mainRecView)

        mainRecView.adapter = imgDtlAdapter

        (mainRecView.layoutManager as LinearLayoutManager).scrollToPosition(position)

    }

    override fun onBackPressed() {
        if(mainRecView.layoutManager!!::class == LinearLayoutManager::class){
            val imgAdapter = NasaRecAdapter(Glide.with(this), this, mainVm.jsonData)
            mainRecView.adapter = imgAdapter
            mainRecView.layoutManager = GridLayoutManager(this, 2)
            snapHelper.attachToRecyclerView(null)
        }else{
            super.onBackPressed()
        }
    }
}
