import br.com.chavesdavid.bytebank.model.Cliente
import br.com.chavesdavid.bytebank.model.Conta
import br.com.chavesdavid.bytebank.model.ContaCorrente

fun testaFuncoes() {
    val fulano1 = ContaCorrente(titular = Cliente(nome = "Fulano 1", cpf = "", senha = 123), numero = 1)
    val fulano2 = ContaCorrente(titular = Cliente(nome = "Fulano 2", cpf = "", senha = 1234), numero = 2)
    val fulano3 = ContaCorrente(titular = Cliente(nome = "Fulano 3", cpf = "", senha = 1235), numero = 3)

    val contas = listOf(fulano1, fulano2, fulano3)

    MinhaListaDeContas(contas = contas)
        .executa { it.deposita(1000.0) } // deposita 1000 em cada conta
        .executa { println(it) }
        .executa { it.saca(500.0) } // saca 500 em cada conta
        .executa { println(it) }
        .filtraPor { it.numero % 2 == 0 } // filtra contas com numeros par
        .executa { println(it) }
}

class MinhaListaDeContas(val contas: List<Conta>) {

    fun filtraPor(predicate: (Conta) -> Boolean): MinhaListaDeContas {
        val contasFiltradas = arrayListOf<Conta>()

        for (conta in contas) {
            if (predicate(conta)) {
                contasFiltradas.add(conta)
            }
        }
        return MinhaListaDeContas(contasFiltradas)
    }

    fun executa(run: (Conta) -> Unit): MinhaListaDeContas {
        for (conta in contas) {
            run(conta)
        }
        return this
    }
}