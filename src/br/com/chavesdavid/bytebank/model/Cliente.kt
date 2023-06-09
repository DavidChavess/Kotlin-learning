package br.com.chavesdavid.bytebank.model

class Cliente(
    var nome: String,
    val cpf: String,
    var endereco: Endereco = Endereco(),
    private val senha: Int
) : Autenticavel {

    override fun autentica(senha: Int): Boolean {
        println("Validando autenticação do cliente")
        if (this.senha == senha) {
            return true
        }
        return false
    }

    override fun toString(): String {
        return "Cliente(nome='$nome', cpf='$cpf', endereco=$endereco, senha=$senha)"
    }
}