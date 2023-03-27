package br.com.chavesdavid.bytebank

import br.com.chavesdavid.bytebank.model.Cliente
import br.com.chavesdavid.bytebank.model.ContaCorrente
import br.com.chavesdavid.bytebank.model.SistemaInternoV2

fun main() {
    //testaSistemaInternoReceiver()
    testaSistemaInternoComFuncoesDeEscopo()
}

fun testaSistemaInternoReceiver() {
    val fran = Cliente(nome = "Fran", cpf = "000.000.000-00", senha = 123)
    val conta = ContaCorrente(titular = fran, numero = 1)
    val sistemaInterno = SistemaInternoV2(conta)

    // entra com receiver (this)
    sistemaInterno.entraReceiver(senha = 123, autenticado = {
        pagamento(salario = 1000.0)
    })

    println("saldo ${conta.saldo}")
}

fun testaSistemaInternoComFuncoesDeEscopo() {
    Cliente(nome = "Fran", cpf = "000.000.000-00", senha = 123)
        .let { fran ->
            ContaCorrente(titular = fran, numero = 1)
        }
        .let { conta ->
            SistemaInternoV2(conta)
        }
        .run {
            entra(123, autenticado = {
                pagamento(salario = 1000.0)
            })
            conta.saldo
        }
        .let(::println)
}
