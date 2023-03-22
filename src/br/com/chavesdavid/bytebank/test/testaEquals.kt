import br.com.chavesdavid.bytebank.model.Endereco

fun testaEquals() {
    val endereco = Endereco(logradouro = "Rua 1", cep = "00000-000")
    val enderecoNovo = Endereco(logradouro = "Rua 2", cep = "00000-000")
    println(enderecoNovo.equals(endereco))
}