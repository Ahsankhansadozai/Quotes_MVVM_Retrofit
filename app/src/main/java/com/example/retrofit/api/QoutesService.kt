package com.example.retrofit.api

import com.example.retrofit.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface QoutesService {

    @GET("/quotes")
    suspend fun getQoutes(@Query("page") page : Int) : Response<QuoteList>
}