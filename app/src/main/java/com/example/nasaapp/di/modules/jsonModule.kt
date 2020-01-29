package com.example.nasaapp.di.modules

import android.app.Application
import android.util.Log
import com.example.nasaapp.model.DataModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class jsonModule{

    private val FILE_NAME = "data.json"

    @Provides
    @Singleton
    fun providesJsonData(context: Application) : Array<DataModel>{
        val jsonFile : String = context.assets.open("data.json").bufferedReader().use { it.readText() }

        val arrayDataType = object : TypeToken<Array<DataModel>>() {}.type
        var json = Gson().fromJson<Array<DataModel>>(jsonFile, arrayDataType)
        Log.e("json Data", json[0].title)
        return json
    }


}