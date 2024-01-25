package com.example.cryptoapp_teste.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiUtilities {

    companion object {
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
