package com.example.retrofit

import android.app.Application
import com.example.retrofit.api.QoutesService
import com.example.retrofit.api.RetrofitHelper
import com.example.retrofit.db.QuoteDatabase
import com.example.retrofit.repositery.QuotesRepo

class QuoteApplication : Application() {
    lateinit var quotesRepo: QuotesRepo

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteSerive = RetrofitHelper.getInstance().create(QoutesService::class.java)
        val database = QuoteDatabase.getQuoteDateBase(applicationContext)
        val repo = QuotesRepo(quoteSerive ,database)
    }
}