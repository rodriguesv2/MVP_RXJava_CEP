package br.com.rubensrodrigues.mvprxjavacep.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("unidade", "ibge", "gia")
class Cep {

    lateinit var cep: String
    lateinit var logradouro: String
    lateinit var complemento: String
    lateinit var bairro: String
    lateinit var localidade: String
    lateinit var uf: String
}