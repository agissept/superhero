package com.example.superhero

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {
    @GET("{id}")
    fun getSuperHeroData(@Path("id") id: String): Call<SuperHero>
}
