package br.com.chavesdavid.bytebank.test

import br.com.chavesdavid.bytebank.exception.FalhaAutenticacaoException
import br.com.chavesdavid.bytebank.exception.SaldoInssuficienteException
import br.com.chavesdavid.bytebank.model.Cliente
import br.com.chavesdavid.bytebank.model.ContaCorrente
import br.com.chavesdavid.bytebank.model.ContaPoupanca

fun testaComportamentosConta() {
    val alex = Cliente(nome = "Alex", cpf = "1", senha = 1)
    val contaAlex = ContaCorrente(titular = alex, numero = 1000)
    contaAlex.deposita(200.0)

    val fran = Cliente(nome = "Fran", cpf = "1", senha = 1)
    val contaFran = ContaPoupanca(numero = 1001, titular = fran)
    contaFran.deposita(300.0)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println("depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)

    println("depositando na conta da Fran")
    contaFran.deposita(70.0)
    println(contaFran.saldo)

    println("sacando na conta do Alex")
    contaAlex.saca(250.0)
    println(contaAlex.saldo)

    println("sacando na conta da Fran")
    contaFran.saca(100.0)
    println(contaFran.saldo)

    println("saque em excesso na conta do Alex")
    contaAlex.saca(100.0)
    println(contaAlex.saldo)

    println("saque em excesso na conta da Fran")
    contaFran.saca(500.0)
    println(contaFran.saldo)

    println("Transferindo da conta da Fran para o Alex")

    try {
        contaFran.transfere(destino = contaAlex, valor = 100.0, senha = 1)
        println("Transferência sucedida")
    } catch (ex: SaldoInssuficienteException) {
        println("Falha na transferência")
        println(ex.message)
        ex.printStackTrace()
    } catch (ex: FalhaAutenticacaoException) {
        println("Falha na transferência")
        println(ex.message)
        ex.printStackTrace()
    }

    println(contaAlex.saldo)
    println(contaFran.saldo)
}