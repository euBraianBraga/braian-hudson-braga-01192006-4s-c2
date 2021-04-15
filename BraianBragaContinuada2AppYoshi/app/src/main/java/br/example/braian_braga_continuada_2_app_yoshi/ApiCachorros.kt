package br.example.braian_braga_continuada_2_app_yoshi

import retrofit2.Call
import retrofit2.http.*

interface ApiCachorros {

    @GET("cachorros")
    fun get(): Call<List<Cachorros>>

    @GET("cachorros/{id}")
    fun get(@Path("id")id:String): Call<Cachorros>
}