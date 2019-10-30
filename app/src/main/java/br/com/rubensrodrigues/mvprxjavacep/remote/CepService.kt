package br.com.rubensrodrigues.mvprxjavacep.remote

import br.com.rubensrodrigues.mvprxjavacep.model.Cep
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {

//    @GET("ws/{cep}/json/")
//    fun enderecoPorCep(@Path("cep") cep: String): Single<Cep>

    @GET("ws/{cep}/json/")
    fun enderecoPorCep(@Path("cep") cep: String): Single<Cep>
}