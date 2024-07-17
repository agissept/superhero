package com.example.superhero

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.superhero.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getDataFromSuperHeroApi()
    }

    private fun getDataFromSuperHeroApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://superheroapi.com/api/0cedfb4197d6ad5bf3b6767bd7c2eb06/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SuperHeroService::class.java)
        val call = service.getSuperHeroData("201")
        call.enqueue(object : Callback<SuperHero> {
            override fun onResponse(call: Call<SuperHero>, response: Response<SuperHero>) {
                if (response.isSuccessful) {
                    val superHero = response.body()
                    setDataToView(superHero!!)
                    Log.d("SuperHero", "SuperHero: $superHero")
                }
            }

            override fun onFailure(call: Call<SuperHero>, t: Throwable) {
                Log.e("SuperHero", "Error: ${t.message}")
            }
        })
    }

    private fun setDataToView(superHero: SuperHero) {
        with(binding) {
            progressBar.visibility = android.view.View.GONE

            Glide.with(applicationContext)
                .load(superHero.image.url)
                .into(imageView)

            name.text = superHero.name
            fullname.text = superHero.biography.fullName
            publisher.text = superHero.biography.publisher
            alignment.text = superHero.biography.alignment
            placeOfBirth.text = superHero.biography.placeOfBirth
            firstAppearance.text = superHero.biography.firstAppearance
        }

    }
}