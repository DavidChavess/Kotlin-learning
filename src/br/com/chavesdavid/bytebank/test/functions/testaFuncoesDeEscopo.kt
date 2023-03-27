package br.com.chavesdavid.bytebank.test.functions

import br.com.chavesdavid.bytebank.model.Cliente
import br.com.chavesdavid.bytebank.model.ContaCorrente
import br.com.chavesdavid.bytebank.model.Endereco

fun testaFuncoesDeEscopo() {
    // run = faz alguma coisa utilizando o contexto (this) e devolve algo
    Endereco(logradouro = "endereço em minusculo")
        .run {
            logradouro?.toUpperCase()
        }
        .let { enderecoMaiusculo ->
            println(enderecoMaiusculo)
        }

    // let = faz alguma coisa utilizando o contexto como argumento (it) e devolve algo
    Endereco(logradouro = "endereço em minusculo")
        .let {
            it.logradouro?.toUpperCase()
        }
        .let { enderecoMaiusculo ->
            println(enderecoMaiusculo)
        }

    // apply = faz alguma coisa com o contexto (this) e devolve o próprio contexto
    Endereco(logradouro = "endereço em minusculo")
        .apply {
            logradouro = "outro logradouro"
        }
        .let { endereco ->
            println(endereco)
        }

    // also = faz alguma coisa com o contexto como argumento (it) e devolve o próprio contexto
    Endereco(logradouro = "endereço em minusculo")
        .also {
            println("Fazendo algo com o it $it")
        }
        .let { endereco ->
            println(endereco)
        }
}


fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12

    val contaPoupanca = ContaCorrente(Cliente(nome = "teste", cpf = "", senha = 123), 1)
    contaPoupanca
        .run {
            deposita(1000.0)
            saldo * taxaMensal
        }
        .let { rendimentoMensal ->
            println("rendimento mensal $rendimentoMensal")
        }

    run {
        var saldoAnual = contaPoupanca.saldo
        repeat(12) {
            saldoAnual += saldoAnual * taxaMensal
        }
        saldoAnual
    }
        .let { rendimentoAnual ->
            println("rendimento anual $rendimentoAnual")
        }
}

fun testaWith() {
    with(Endereco()) {
        logradouro = "Rua Sobe e desce"
        bairro = "Ninguem conhece"
        numero = 50
        cidade = "São Paulo"
        estado = "SP"
        cep = "00000.000"
        complemento = "Portão azul"
        completo()
    }
        .let(::println)
}
