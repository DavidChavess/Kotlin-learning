package br.com.chavesdavid.bytebank.model

class SistemaInternoV2(val conta: Conta) {

    fun entra(senha: Int, autenticado: () -> Unit = {}) {
        if (conta.titular.autentica(senha)) {
            println("Bem vindo ao Bytebank")
            autenticado()
        } else {
            println("Falha na autenticação")
        }
    }

    fun entraReceiver(senha: Int, autenticado: SistemaInternoV2.() -> Unit = {}) {
        if (conta.titular.autentica(senha)) {
            println("Bem vindo ao Bytebank")
            autenticado()
        } else {
            println("Falha na autenticação")
        }
    }

    fun pagamento(salario: Double) {
        println("Realizando pagamento de salário")
        conta.deposita(salario)
    }
}