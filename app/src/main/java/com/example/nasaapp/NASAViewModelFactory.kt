package com.example.nasaapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nasaapp.di.components.NasaComponent

class NASAViewModelFactory (val application: NASAAPPApplication): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val t:T = super.create(modelClass)
        if (t is NasaComponent.Injectable){
            t.inject(application.nasaComponent)
        }
        return t
    }
}