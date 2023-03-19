import br.com.chavesdavid.bytebank.model.Cliente
import br.com.chavesdavid.bytebank.newModel.Cliente as NovoCliente

fun testaImportAlias(){
    val cliente = Cliente(nome = "Teste", cpf = "", senha = 123)
    val cliente2 = NovoCliente(nome = "Client2", cpf = "")
}