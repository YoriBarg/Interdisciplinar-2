
import interdisciplinar.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yurib
 */
public class TesteCliente {


    @Test
    public void testeCliente() {
        Cliente cliente = new Cliente();

        cliente.setNome("yuri");
        cliente.setEmail("yuri@hotmail.com");
        cliente.setCSenha("123");
        cliente.setPermissao(0);
        cliente.setNomeTime("Corinthians");
        
        assertThat(cliente.getNome(), is("yuri"));
        assertThat(cliente.getEmail(), is("yuri@hotmail.com"));
        assertThat(cliente.getCSenha(), is("123"));
        assertThat(cliente.getPermissao(), is(0));
        assertThat(cliente.getNomeTime(), is("Corinthians"));
        
        System.out.println(" Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail() + ", Senha: " + cliente.getCSenha() + 
                ", Acesso: " + cliente.getPermissao() + ", Time: " + cliente.getNomeTime());
    }
}
