package com.example.worldcoins

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.worldcoins.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://apisprueba.herokuapp.com/country/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByCoin(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call:Response<CoinsResponse> = getRetrofit().create(APIService::class.java).getCoinsByCountry("$query/altSpellings")
            val coins:CoinsResponse? = call.body()
            if(call.isSuccessful){
                //show recyclerview
            }else{
                //show error
            }
        }
    }
}