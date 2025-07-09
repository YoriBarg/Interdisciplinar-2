/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import interdisciplinar.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.*;
import controller.ClienteController;



/**
 *
 * @author yurib
 */
public class LoginTeste {//primeiro teste feito, aprimorei para testar mais coisas como permissão e ate usuario inexistente
 @Test
public void testSalvarCliente() throws SQLException {
    Cliente cliente = new Cliente();
    cliente.setEmail("teste@teste.com");
    cliente.setNome("Teste");
    cliente.setCSenha("123");
    cliente.setPermissao(0);
    ClienteController controller = new ClienteController();
    int resultado = controller.salvarCliente(cliente);
    assertTrue("Cadastro falhou", resultado > 0);

    Cliente clienteSalvo = controller.buscarCliente("teste@teste.com", "123");
    assertNotNull("Cliente não foi encontrado", clienteSalvo);
    assertEquals("Nome não corresponde", "Teste", clienteSalvo.getNome());
    System.out.println("   Email: " + clienteSalvo.getEmail());
    System.out.println("   Nome: " + clienteSalvo.getNome());
    System.out.println("   Senha: " + clienteSalvo.getCSenha());
    
    boolean excluido = controller.excluirCliente("teste@teste.com", "123");
    assertTrue("Falha ao excluir cliente", excluido);

}
}