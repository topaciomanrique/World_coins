package com.example.worldcoins

import com.google.gson.annotations.SerializedName

data class CoinsResponse (
    @SerializedName("name") var Nombre: String,
    @SerializedName("region") var Region: String,
    @SerializedName("altSpellings") var altSpellings: List<String>,

        )