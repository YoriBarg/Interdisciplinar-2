
import controller.ClienteController;
import interdisciplinar.Cliente;
import org.junit.Test;
import java.sql.*;
import static org.junit.Assert.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yurib
 */
public class TesteExcluir {
     @Test
    public void testExcluirCliente() throws SQLException {
        ClienteController controller = new ClienteController();
        String email = "excluir@teste.com";
        String senha = "senha123";
        
        Cliente cliente = new Cliente();
        cliente.setEmail(email);
        cliente.setNome("To Vivo");
        cliente.setCSenha(senha);
        cliente.setNomeTime("Sao Paulo");
        cliente.setPermissao(0);
        controller.salvarCliente(cliente);
        
        Cliente clienteAntes = controller.buscarCliente(email, senha);
        System.out.println("Cliente: " + (clienteAntes != null ? clienteAntes.getNome() : "Não encontrado"));

        boolean excluido = controller.excluirCliente(email, senha);
        assertTrue("Falha ao excluir cliente", excluido);

        Cliente clienteDepois = controller.buscarCliente(email, senha);
        System.out.println("Cliente excluido " + (clienteDepois != null ? clienteDepois.getNome() : "Não encontrado"));

        Cliente clienteBuscado = controller.buscarCliente(email, senha);
        assertNull("Cliente ainda encontrado após exclusão", clienteBuscado);
    }
}
