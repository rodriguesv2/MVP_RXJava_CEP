package br.com.rubensrodrigues.mvprxjavacep.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.rubensrodrigues.mvprxjavacep.R
import br.com.rubensrodrigues.mvprxjavacep.model.Cep
import kotlinx.android.synthetic.main.activity_cep.*

class CepActivity : AppCompatActivity(), CepContract.View {

    private val presenter by lazy{
        CepPresenter().apply{attachView(this@CepActivity)}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cep)

        cliqueBotao()
    }

    private fun cliqueBotao() {
        botaoCep.setOnClickListener {
            presenter.aoClicarBotao(campoCep.text.toString())
        }
    }

    override fun mostrarEndereco(cep: Cep) {
        Log.i("VIEW INFLATE", "FORA DO APPLY")
        cep.apply {
            Log.i("VIEW INFLATE", "ENTROU AQUI")
            enderecoCep.text = logradouro
            complementoCep.text = complemento
            bairroCep.text = bairro
            cidadeCep.text = localidade
            ufCep.text = " - $uf"
        }
    }

    override fun toast(mensagem: String) {
        Toast.makeText(this, mensagem,Toast.LENGTH_LONG).show()
    }
}
