package com.example.nasaapp

import android.app.Application
import com.example.nasaapp.di.components.DaggerNasaComponent
import com.example.nasaapp.di.components.NasaComponent
import com.example.nasaapp.di.modules.AppModule
import net.danlew.android.joda.JodaTimeAndroid

public class NASAAPPApplication : Application(){

    companion object{
        lateinit var nasaappApplication: NASAAPPApplication
        private set
    }

    val nasaComponent : NasaComponent by lazy {
        DaggerNasaComponent.builder()
            .appModule(AppModule(this))
            .build()
    }


    override fun onCreate() {
        super.onCreate()
        nasaappApplication = this
        JodaTimeAndroid.init(this)
    }

}