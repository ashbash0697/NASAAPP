package com.example.nasaapp.di.components

import com.example.nasaapp.di.modules.AppModule
import com.example.nasaapp.di.modules.jsonModule
import com.example.nasaapp.ui.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, jsonModule::class))
interface NasaComponent{

    fun inject(mainActivityViewModel: MainActivityViewModel)

    interface Injectable{
        fun inject(nasaComponent: NasaComponent)
    }
}