fun testaWhenExpression() {
    val entrada = "1"
    val umNumero = converteNumero(entrada)

    val valorComTaxa: Double? = when {
        umNumero != null -> {
            umNumero + 0.1
        }
        else -> {
            null
        }
    }

    println("Valor com taxa $valorComTaxa")
}