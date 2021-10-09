package com.example.retrofit.repositery
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.api.QoutesService
import com.example.retrofit.db.QuoteDatabase
import com.example.retrofit.model.QuoteList

class QuotesRepo(private val quotesService:QoutesService , private val quoteDatabase :QuoteDatabase) {

    private val quotesLiveData = MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList>
    get() = quotesLiveData
    suspend fun  getQuotes(page: Int){
        val result = quotesService.getQoutes(page)
        if(result?.body() != null){
            quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
            quotesLiveData.postValue(result.body())
        }
    }
}