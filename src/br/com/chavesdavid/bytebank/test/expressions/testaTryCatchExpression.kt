fun testaTryCatchExpression() {
    val entrada = "a"
    println("Numero convertido ${converteNumero(entrada)}")
}

fun converteNumero(entrada: String): Double? =
    try {
        println("Convertendo numero: ${entrada}")
        entrada.toDouble()
    } catch (ex: Exception) {
        println("Erro ao converter numero")
        null
    }