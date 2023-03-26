package br.com.chavesdavid.bytebank.model

class SistemaInterno {

    fun entra(admin: Autenticavel, senha: Int, run: () -> Unit = {}){
        if(admin.autentica(senha)){
            println("Bem vindo ao Bytebank")
            run()
        } else {
            println("Falha na autenticação")
        }
    }

}