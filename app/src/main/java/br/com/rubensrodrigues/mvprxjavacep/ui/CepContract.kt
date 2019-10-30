package br.com.rubensrodrigues.mvprxjavacep.ui

import br.com.rubensrodrigues.mvprxjavacep.model.Cep

interface CepContract {

    interface View{
        fun mostrarEndereco(cep: Cep)
        fun toast(mensagem: String)
    }

    interface Presenter{
        fun attachView(mvpView: View?)
        fun detachView()
        fun aoClicarBotao(cep: String)
    }
}