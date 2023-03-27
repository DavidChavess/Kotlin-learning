import br.com.chavesdavid.bytebank.model.SistemaInterno
import br.com.chavesdavid.bytebank.model.Autenticavel

fun testaObjectExpression() {
    val fran = object : Autenticavel {
        val nome: String = "Fran"
        val cpf: String = ""
        val senha: Int = 123
        override fun autentica(senha: Int): Boolean = this.senha == senha
    }

    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(fran, 123, run = {
        println("executa depois que estiver altenticado, - CALLBACK")
    })
}