package br.com.chavesdavid.bytebank.model

abstract class Funcionario(
    val nome: String,
    val cpf: String,
    val salario: Double
){
    abstract val bonificacao: Double


}