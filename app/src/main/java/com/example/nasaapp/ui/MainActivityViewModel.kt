package com.example.nasaapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.nasaapp.di.components.NasaComponent
import com.example.nasaapp.di.modules.jsonModule
import com.example.nasaapp.model.DataModel
import javax.inject.Inject

class MainActivityViewModel : ViewModel(), NasaComponent.Injectable{
    override fun inject(nasaComponent: NasaComponent) {
        nasaComponent.inject(this)
    }

    @Inject
    lateinit var jsonData: Array<DataModel>

    fun getJsonData(){
        Log.e("jsondata", jsonData[0].title)
    }





}