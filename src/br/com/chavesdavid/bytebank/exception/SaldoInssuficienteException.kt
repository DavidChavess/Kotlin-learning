package br.com.chavesdavid.bytebank.exception

class SaldoInssuficienteException(
    override val message: String = "Saldo inssuficiente"
) : Exception(message)