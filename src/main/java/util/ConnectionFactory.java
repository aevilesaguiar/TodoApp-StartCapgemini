/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author AEVILES
 */

//CLASSE PARA CONEXÃO COM O BANCO DE DADOS
public class ConnectionFactory {
    
      //estipular qual será o driver de conexão - sempre que a aplicação se conecta ao BD utilizamos um driver, no java usamos o JDBC nesse caso do mysql
    //o jdbc preci ser incluso nas dependencias do gradle 
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    //URL é o caminho onde está o banco de dados
    public static final String URL = "jdbc:mysql://localhost:3312/todoapp"; // jdbc responsável por fazer a conexão com o banco de dados
    public static final String USER= "root";
    public static final String PASS= "";
    

    //método devolve uma conexão
    //usei static por que eu posso chamar esse método sem criar uma instancia é como se fosse um método global
  public static Connection getConnection() {
        try {
            Class.forName(DRIVER);//carrega o driver
            return DriverManager.getConnection(URL, USER, PASS);//driver manager faz uma conexão usando esses parametros
        } catch (Exception ex) {
             throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }
    
  //encerrar a conexão com o banco de dados
    public static void closeConnection(Connection connection) {
        try {//tentar fazer a conexão se der uma exceção eu faço o catch
            if (connection != null) {//se a conexão foi criada
                connection.close();//eu fecho a conexão
            }
        } catch (Exception ex) {//retorno a exceção
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement) {

        try {
            if (connection != null) {
                connection.close();
            }
            
            if(statement != null){
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
        
    }
    
     
    public static void closeConnection(Connection connection, PreparedStatement statement , ResultSet resultSet) {

        try {
            if (connection != null) {
                connection.close();
            }
            
            if(statement != null){
                statement.close();
            }
            
            if(resultSet != null){
                resultSet.close();
            }
            
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
        
    }
    
}
