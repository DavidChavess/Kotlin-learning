package br.com.chavesdavid.bytebank.exception

class FalhaAutenticacaoException(
    override val message: String = "Falha na autenticação"
) : Exception(message)