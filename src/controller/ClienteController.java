/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.DAOCliente;
import interdisciplinar.Cliente;

import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author yurib
 */
public class ClienteController {
        public int salvarCliente(Cliente cCliente){
        return new DAOCliente().salvarCliente(cCliente);
    }
    public boolean excluirCliente(String email,String csenha){
        return new DAOCliente().excluirCliente(email, csenha);
    }
    public boolean alterarCliente(String email, String nome, String csenha,String NomeTime){
        return new DAOCliente().alterarCliente(email, nome, csenha,NomeTime);
    }
    public List<Cliente> listarCliente() throws SQLException {
        DAOCliente dao = new DAOCliente();
        List<Cliente> clientes = dao.listar();
        return clientes;
    }
public Cliente buscarCliente(String email, String csenha) {
    try {
        DAOCliente dao = new DAOCliente();
        return dao.getByEmail(email, csenha);
    } catch (SQLException e) {
        System.err.println("Erro ao buscar cliente: " + e.getMessage());
        return null;
    }
}
    public boolean excluirById(int Id){
        return new DAOCliente().excluirById(Id);
    }
    public boolean permitirById(int Id,String permissao){
        return new DAOCliente().permitirById(Id,permissao);
    }
    public Cliente buscarTime(String nome) throws SQLException{
        DAOCliente dao = new DAOCliente();
        Cliente cliente = dao.getByNome(nome);
        return cliente;
}
}
