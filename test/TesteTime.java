/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import interdisciplinar.Cliente;
import interdisciplinar.Time;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
/**
 *
 * @author yurib
 */
public class TesteTime {
       @Test
    public void testeTime() {
        Time time = new Time();
        time.setTime("Palmeiras");
        time.setCorPrimaria("Verde");
        time.setCorSecundaria("Branco");
        time.setCorTerciaria("Dourado");
        time.setBrasao("palmeiras.png");

        Cliente cliente = new Cliente();
        cliente.setNome("João");
        cliente.setNomeTime(time.getTime());

        System.out.println(" Time: " + time.getTime() +
                           ", Cores: 1°" + time.getCorPrimaria() + ", 2°" +
                                         time.getCorSecundaria() + ", 3°" +
                                         time.getCorTerciaria() +
                           ", Brasão: " + time.getBrasao() +
                           "Cliente: " + cliente.getNome());

        // Asserções (garantias)
        assertThat(time.getTime(), is("Palmeiras"));
        assertThat(time.getCorPrimaria(), is("Verde"));
        assertThat(time.getCorSecundaria(), is("Branco"));
        assertThat(time.getCorTerciaria(), is("Dourado"));
        assertThat(time.getBrasao(), is("palmeiras.png"));
        assertThat(cliente.getNomeTime(), is(time.getTime()));
    }
}
