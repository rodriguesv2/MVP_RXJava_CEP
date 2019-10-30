package br.com.rubensrodrigues.mvprxjavacep.ui

import br.com.rubensrodrigues.mvprxjavacep.remote.RetrofitConfig
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CepPresenter : CepContract.Presenter{

    private var view: CepContract.View? = null
    private val disposable = CompositeDisposable()

    override fun attachView(mvpView: CepContract.View?) {
        view = mvpView
    }

    override fun detachView() {
        disposable.dispose()
        view = null
    }

    override fun aoClicarBotao(cep: String) {
        getCep(cep)
    }

    private fun getCep(cep: String){

        disposable.add(RetrofitConfig().getCepService().enderecoPorCep(cep)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { view?.mostrarEndereco(it) },
                { view?.toast("Deu ruim") })
        )

//        val call = RetrofitConfig().getCepService().enderecoPorCep(cep)
//        call.enqueue(object : Callback<Cep>{
//            override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
//                Log.i("ON RESPONSE", "PASSOU AQUI")
//                val endereco = response.body() as Cep
//                Log.i("ON RESPONSE", endereco.logradouro)
//                view?.mostrarEndereco(endereco)
//            }
//
//            override fun onFailure(call: Call<Cep>, t: Throwable) {
//                view?.toast("Falha ${t.message}")
//                Log.e("ON FAILURE", "${t.message}")
//            }
//        })
    }
}