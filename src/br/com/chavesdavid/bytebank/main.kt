package br.com.chavesdavid.bytebank

fun main() {
    println()
    testaSomaFuncaoReferencia()
    println()
    testaSomaFuncaoLambda()
    println()
    testaSomaFuncaoAnonima()
    println()
    testaSomaFuncaoClasse()
}

fun testaSomaFuncaoLambda() {
    data class SomaClass(val n1: Double, val n2: Double)

    val soma: (SomaClass) -> Double = {
        it.n1 + it.n2
    }

    val soma2 = { n1: Double, n2: Double ->
        n1 + n2
    }

    println("chamando soma lambda")
    println(soma(SomaClass(1.0, 2.0)))

    println("chamando soma2 lambda")
    println(soma2(1.0, 2.0))
}

fun testaSomaFuncaoAnonima() {
    val teste = fun(n1: Double, n2: Double): Double {
        return n1 + n2
    }
    teste(1.0, 2.0)
}

private fun testaSomaFuncaoClasse() {
    val soma =
        object : () -> Double {
            operator fun invoke(n1: Double, n2: Double): Double {
                println("chamando classe soma com 2 parametro")
                return n1 + n2
            }

            operator fun invoke(n1: Double, n2: Double, n3: Double): Double {
                println("chamando classe soma com 3 parametro")
                return this(n1, n2) + n3
            }

            operator fun invoke(n1: Double, n2: Double, n3: Double, n4: Double): Double {
                println("chamando classe soma com 4 parametro")
                return this(n1, n2, n3) + n4
            }

            operator fun invoke(values: List<Double>): Double {
                println("chamando classe soma com 4 parametro")
                return values.sum()
            }

            override fun invoke(): Double {
                throw IllegalArgumentException()
            }
        }

    // causa excption
    // println(soma())
    println(soma(1.0, 1.0))
    println(soma(1.0, 2.0, 3.0))
    println(soma(1.0, 2.0, 3.0, 4.0))
}

private fun testaSomaFuncaoReferencia() {
    fun soma(n1: Double, n2: Double): Double? {
        println("chamando soma referencia")
        return n1 + n2
    }

    val somaRef = ::soma
    println(somaRef(1.0, 2.0))
}