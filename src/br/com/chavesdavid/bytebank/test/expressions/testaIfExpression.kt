fun testaIfExpression() {
    val entrada = "1"
    val umNumero = converteNumero(entrada)
    val valorComTaxa = if (umNumero != null) umNumero + 0.1 else 0.0
    println("Valor com taxa $valorComTaxa")
}
