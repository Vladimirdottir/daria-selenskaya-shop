package com.example.daria_selenskaya_shop

import android.content.Context

fun getRequestMaker(context: Context): RequestMaker = OkHttpRequestMaker(context)