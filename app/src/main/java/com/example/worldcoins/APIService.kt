package com.example.worldcoins

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    fun getCoinsByCountry(@Url url:String):Response<CoinsResponse>
}