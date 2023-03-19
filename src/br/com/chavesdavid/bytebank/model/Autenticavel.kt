package br.com.chavesdavid.bytebank.model

interface Autenticavel {

    fun autentica(senha: Int): Boolean

}