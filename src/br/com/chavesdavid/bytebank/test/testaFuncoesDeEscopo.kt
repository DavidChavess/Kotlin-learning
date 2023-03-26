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