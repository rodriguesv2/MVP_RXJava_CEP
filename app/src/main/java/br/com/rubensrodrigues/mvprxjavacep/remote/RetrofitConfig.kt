package br.com.rubensrodrigues.mvprxjavacep.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitConfig {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://viacep.com.br/")
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getClientHttp())
            .build()
    }

    private fun getClientHttp() =
        OkHttpClient
            .Builder()
            .addInterceptor(getLogging())
            .build()

    private fun getLogging() =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    fun getCepService() : CepService{
        return this.retrofit.create(CepService::class.java)
    }
}