/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controller.ClienteController;
import interdisciplinar.Cliente;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import java.sql.*;
import static org.junit.Assert.*;
/**
 *
 * @author yurib
 */
public class TesteEditar {
@Test
public void testAtualizarCliente() throws SQLException {
    ClienteController controller = new ClienteController();
    
    String email = "editar@teste.com";
    String senha = "senha123";
    
    Cliente cliente = new Cliente();
    cliente.setEmail(email);
    cliente.setNome("Rogerio");
    cliente.setCSenha(senha);
    cliente.setNomeTime("Flamengo");
    cliente.setPermissao(0);
    controller.salvarCliente(cliente);

    System.out.println("Nome antigo: " + cliente.getNome());
    
    boolean atualizado = controller.alterarCliente(email, "Cleito", senha, "Palmeiras");
    assertTrue("Falha ao atualizar cliente", atualizado);

    Cliente clienteAtualizado = controller.buscarCliente(email, senha);
    assertNotNull("Cliente não encontrado após atualização", clienteAtualizado);
    assertEquals("Nome não atualizado corretamente", "Cleito", clienteAtualizado.getNome());
    assertEquals("Time não atualizado corretamente", "Palmeiras", clienteAtualizado.getNomeTime());
    System.out.println("Nome atualizado: " + clienteAtualizado.getNome());

    controller.excluirCliente(email, senha);
}
}