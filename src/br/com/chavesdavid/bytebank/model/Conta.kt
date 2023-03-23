package br.com.chavesdavid.bytebank.model

import br.com.chavesdavid.bytebank.exception.FalhaAutenticacaoException
import br.com.chavesdavid.bytebank.exception.SaldoInssuficienteException

abstract class Conta(
    var titular: Cliente,
    val numero: Int
) : Autenticavel {

    companion object {
        var totalAccount = 0
            private set
    }

    init {
        println("Criando conta")
        totalAccount++
    }

    var saldo = 0.0
        protected set

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun saca(valor: Double)

    fun transfere(valor: Double, destino: Conta, senha: Int) {
        if (saldo < valor)
            throw SaldoInssuficienteException(message = "Saldo inssuficiente, saldo = $saldo, valor da transferência = $valor")

        if (!autentica(senha))
            throw FalhaAutenticacaoException()

        saldo -= valor
        destino.deposita(valor)
    }

    override fun autentica(senha: Int): Boolean {
        return titular.autentica(senha)
    }
}

class ContaCorrente(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        val valorComTaxa = valor + 0.1
        if (this.saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa
        }
    }
}

class ContaPoupanca(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        }
    }
}