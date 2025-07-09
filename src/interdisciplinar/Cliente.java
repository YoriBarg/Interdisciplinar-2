/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interdisciplinar;
/**
 *
 * @author yurib
 */
public class Cliente {
    private int acesso;
    private String email;
    private String nome;
    private String csenha;
    private int idCliente;
    private String NomeTime;
    
    public static Cliente clienteLogado;

    public Cliente() { }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCSenha() {
        return csenha;
    }

    public void setCSenha(String csenha) {
        this.csenha = csenha;
    }
      public int getPermissao() {
        return acesso;
    }

    public void setPermissao(int permissao) {
        this.acesso = permissao;
    }
    
    public String getNomeTime() {
        return NomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.NomeTime = nomeTime;
    }

}