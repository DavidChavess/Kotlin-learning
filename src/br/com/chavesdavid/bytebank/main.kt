package br.com.chavesdavid.bytebank

import br.com.chavesdavid.bytebank.model.QUANTIDADE_CONTAS
import br.com.chavesdavid.bytebank.test.testaContasDiferentes
import testaObjectExpression

fun main() {
    testaContasDiferentes()
    testaObjectExpression()
    println("total de contas criadas $QUANTIDADE_CONTAS")
}