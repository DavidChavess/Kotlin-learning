package br.com.chavesdavid.bytebank

import br.com.chavesdavid.bytebank.model.Conta
import br.com.chavesdavid.bytebank.test.testaContasDiferentes

fun main() {
    testaContasDiferentes()
    println("total de contas criadas ${Conta.totalAccount}")
}