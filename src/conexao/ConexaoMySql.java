/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author yurib
 */

public class ConexaoMySql {

    private boolean status = false;
    private String mensagem = "";   //variavel que vai informar o status da conexao
    private Connection con = null;  //variavel para conexao
    private Statement statement;
    private ResultSet resultSet;

    private String servidor = ("127.0.0.1:3306");
    private String nomeDoBanco = ("inter");
    private String usuario = ("root");
    private String senha = ("usbw");

    public ConexaoMySql(){}

    public ConexaoMySql(String pServidor, String pNomeDoBanco, String pUsuario, String pSenha){
        this.servidor = pServidor;
        this.nomeDoBanco = pNomeDoBanco;
        this.usuario = pUsuario;
        this.senha = pSenha;
    }

    //Abre uma conexao com o banco 
    public Connection conectar(){
        try {
            //Driver do Mysql
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            //local do banco, nome do banco, usuario e senha
            String url = "jdbc:mysql://" + servidor + "/" + nomeDoBanco;
            this.setCon((Connection) DriverManager.getConnection(url, usuario, senha));
            this.status = true;
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this.getCon();
    }
    public boolean executarSQL(String pSQL){
        try {
            this.setStatement(getCon().createStatement());
            this.setResultSet(getStatement().executeQuery(pSQL));

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean executarUpdateDeleteSQL(String pSQL){
        try {

            this.setStatement(getCon().createStatement());
            getStatement().executeUpdate(pSQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public int insertSQL(String pSQL){
        int status = 0;
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.getStatement().executeUpdate(pSQL);

            //consulta o ultimo id inserido
            this.setResultSet(this.getStatement().executeQuery("SELECT last_insert_id();"));

            //recupera o ultimo id inserido
            while(this.resultSet.next()){
                status = this.resultSet.getInt(1);
            }

            //retorna o ultimo id inserido
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }
    }

    public boolean fecharConexao(){
        try {
            if((this.getResultSet() != null) && (this.statement != null)){
                this.getResultSet().close();
                this.statement.close();
            }
            this.getCon().close();
            return true;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    public boolean isStatus() {
        return this.status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }


    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }


    public void setStatement(Statement statement) {
        this.statement = statement;
    }


    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    public void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
