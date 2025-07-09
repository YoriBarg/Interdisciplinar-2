/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexao.ConexaoMySql;
import interdisciplinar.Time;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yurib
 */
public class DAOTime {
         public int salvarTime(Time time) {

        ConexaoMySql conexao = new ConexaoMySql();

        try {
            conexao.conectar();

            String sql = "INSERT INTO time (nometime, corprimaria, brasao) VALUES ("
                       + "'" + time.getTime() + "',"
                       + "'" + time.getCorPrimaria() + "',"
                       + "'" + time.getBrasao() + "'"
                       + ");";

            System.out.println("SQL gerado: " + sql); // Debug
            return conexao.insertSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            conexao.fecharConexao();
        }
    }
     
     public boolean excluirByIdTime(int id) {
    ConexaoMySql conexao = new ConexaoMySql();

    try {
        conexao.conectar();

        String sql = "DELETE FROM time WHERE id = " + id + ";";

        return conexao.executarUpdateDeleteSQL(sql);

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        conexao.fecharConexao();
    }
}
     
    public List<String> listarTimes() throws SQLException {
        List<String> nomes = new ArrayList<>();
        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        ResultSet rs = stat.executeQuery("SELECT nometime FROM time");

    while(rs.next()){
    nomes.add(rs.getString("nometime"));
    }
    return nomes;
}
    
    public Time buscarPorNome(String nome) throws SQLException {
        ConexaoMySql con = new ConexaoMySql();
        Statement stat = con.conectar().createStatement();
        ResultSet rs = stat.executeQuery("SELECT * FROM time WHERE nometime = '" + nome + "'");

    if(rs.next()) {
        Time t = new Time();
        t.setId(rs.getInt("id"));
        t.setTime(rs.getString("nometime"));
        t.setCorPrimaria(rs.getString("CorPrimaria"));
        t.setBrasao(rs.getString("brasao"));
        t.setCorSecundaria(rs.getString("CorSecundaria"));
        t.setCorTerciaria(rs.getString("CorTerciaria"));
        return t;
    }
    return null;
}
}
