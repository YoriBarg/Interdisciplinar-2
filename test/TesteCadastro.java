/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controller.ClienteController;
import interdisciplinar.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author yurib
 */
public class TesteCadastro {
      @Test
    public void testCadastroUsuario() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("TesteCadastro");
        cliente.setEmail("testecadastro@gmail.com");
        cliente.setCSenha("123");
        cliente.setPermissao(0);
        cliente.setNomeTime("Palmeiras");

        ClienteController controle = new ClienteController();
        int id = controle.salvarCliente(cliente);
        assertTrue("Falha ao cadastrar cliente", id > 0);

        Cliente clienteSalvo = controle.buscarCliente("testecadastro@gmail.com", "123");

        assertNotNull("Cliente não encontrado após cadastro", clienteSalvo);
        assertEquals("Nome incorreto", "TesteCadastro", clienteSalvo.getNome());
        assertEquals("Time incorreto", "Palmeiras", clienteSalvo.getNomeTime());
        assertEquals("Permissão incorreta", 0, clienteSalvo.getPermissao());

        System.out.println("Cadastro bem-sucedido: ID " + id + " - " + clienteSalvo.getNome());
        
        boolean excluido = controle.excluirCliente("testecadastro@gmail.com", "123");
        assertTrue("Falha ao excluir cliente de teste", excluido);
    }
}
