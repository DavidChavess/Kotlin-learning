package br.com.chavesdavid.bytebank.test

import br.com.chavesdavid.bytebank.model.Cliente
import br.com.chavesdavid.bytebank.model.ContaCorrente
import br.com.chavesdavid.bytebank.model.ContaPoupanca

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = ContaCorrente(Cliente(nome = "João", cpf = "1", senha = 1), 1002)
    contaJoao.titular.nome = "João"
    var contaMaria = ContaPoupanca(Cliente(nome = "Maria", cpf = "2", senha = 2), 1003)
    contaMaria.titular.nome = "Maria"
    contaJoao.titular.nome = "João"

    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")

    println(contaJoao)
    println(contaMaria)
}