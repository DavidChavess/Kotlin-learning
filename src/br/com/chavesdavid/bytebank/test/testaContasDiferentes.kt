package br.com.chavesdavid.bytebank.test

import br.com.chavesdavid.bytebank.model.Cliente
import br.com.chavesdavid.bytebank.model.ContaCorrente
import br.com.chavesdavid.bytebank.model.ContaPoupanca
import br.com.chavesdavid.bytebank.model.Endereco

fun testaContasDiferentes() {
    val contaCorrente = ContaCorrente(
        titular = Cliente(nome = "Alex", cpf = "1", senha = 1, endereco = Endereco(logradouro = "Rua sobe e desce")),
        numero = 1000
    )
    val contaPoupanca = ContaPoupanca(
        titular = Cliente(nome = "Fran", cpf = "2", senha = 2),
        numero = 1001
    )
    contaCorrente.deposita(1000.0)
    contaPoupanca.deposita(1000.0)

    println("saldo corrente: ${contaCorrente.saldo}")
    println("saldo poupança: ${contaPoupanca.saldo}")

    contaCorrente.saca(100.0)
    contaPoupanca.saca(100.0)

    println("saldo após saque corrente: ${contaCorrente.saldo}")
    println("saldo após saque poupança: ${contaPoupanca.saldo}")

    contaCorrente.transfere(100.0, contaPoupanca)

    println("saldo corrente após transferir para poupança: ${contaCorrente.saldo}")
    println("saldo poupança após receber transferência: ${contaPoupanca.saldo}")

    contaPoupanca.transfere(200.0, contaCorrente)

    println("saldo poupança após transferir para corrente: ${contaPoupanca.saldo}")
    println("saldo corrente após receber transferência: ${contaCorrente.saldo}")

    println("Titular conta corrente: ${contaCorrente.titular}")
    println("Titular conta poupança: ${contaPoupanca.titular}")
}