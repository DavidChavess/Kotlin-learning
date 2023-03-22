import br.com.chavesdavid.bytebank.model.Endereco

fun testaPilhas() {
    testa()
}
private fun testa() {
    println("testa 1")
    testa2()
    println("fim testa 1")
}

private fun testa2() {
    println("testa 2")
    for (i in 1..5) {
        try {
            println(i)
            val endereco = Any()
            endereco as Endereco
        } catch (ex: ClassCastException) {
            println("Lançou")
        }
    }
    println("fim testa 2")
}