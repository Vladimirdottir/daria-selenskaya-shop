package com.example.daria_selenskaya_shop

import android.app.Application
import android.content.Context
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

lateinit var di: Kodein

class App: Application(){

    override fun onCreate(){
        super.onCreate()

        val di = Kodein{
            fun getRequestMaker(context: Context): RequestMaker = OkHttpRequestMaker(context)
            bind<Context>() with singleton {this@App}
            bind<RequestMaker>() with singleton {OkHttpRequestMaker(instance())}
        }
    }
}
