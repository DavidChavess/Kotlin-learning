import br.com.chavesdavid.bytebank.model.Funcionario

fun testaCasting() {
    val calculadora = CalculadoraBonificacaoComAnyFuncionario()

    // lança ClassCastException
    calculadora.registraComCastNormal(1)

    // não lança ClassCastException
    calculadora.registraComCastMaisValidacao(1)
}

class CalculadoraBonificacaoComAnyFuncionario {
    var total: Double = 0.0
        private set

    fun registraComCastNormal(funcionario: Any) {
        funcionario as Funcionario
        this.total += funcionario.bonificacao
    }

    fun registraComCastMaisValidacao(funcionario: Any) {
        if (funcionario is Funcionario) {
            this.total += funcionario.bonificacao
        }
    }
}