
import controller.ClienteController;
import interdisciplinar.Cliente;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import static org.junit.Assert.assertNull;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yurib
 */
public class TesteLogin {
    @Test
    public void testLoginAdministrador() throws Exception {
        ClienteController controle = new ClienteController();
        Cliente cliente = controle.buscarCliente("admin@email.com", "admin123");

        assertNotNull("ADM não encontrado", cliente);
        assertEquals("Permissão apenas de usuario", 1, cliente.getPermissao());

        System.out.println(cliente.getNome());
    }

    @Test
    public void testLoginUsuario() throws Exception {
        ClienteController controle = new ClienteController();
        Cliente cliente = controle.buscarCliente("usuario@email.com", "usuario123");

        assertNotNull("Cliente não encontrado", cliente);
        assertEquals("Permissão de ADM", 0, cliente.getPermissao());

        System.out.println(cliente.getNome());
    }

    @Test
    public void testLoginInvalido() throws Exception {
        ClienteController controle = new ClienteController();
        Cliente cliente = controle.buscarCliente("nulo@gmail.com", "nulo");

        assertNull("Login existente", cliente);

        System.out.println("Cliente não encontrado");
    }
}

