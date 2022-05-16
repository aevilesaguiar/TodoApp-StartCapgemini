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

//CLASSE PARA CONEX�O COM O BANCO DE DADOS
public class ConnectionFactory {
    
      //estipular qual ser� o driver de conex�o - sempre que a aplica��o se conecta ao BD utilizamos um driver, no java usamos o JDBC nesse caso do mysql
    //o jdbc preci ser incluso nas dependencias do gradle 
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    //URL � o caminho onde est� o banco de dados
    public static final String URL = "jdbc:mysql://localhost:3312/todoapp"; // jdbc respons�vel por fazer a conex�o com o banco de dados
    public static final String USER= "root";
    public static final String PASS= "";
    

    //m�todo devolve uma conex�o
    //usei static por que eu posso chamar esse m�todo sem criar uma instancia � como se fosse um m�todo global
  public static Connection getConnection() {
        try {
            Class.forName(DRIVER);//carrega o driver
            return DriverManager.getConnection(URL, USER, PASS);//driver manager faz uma conex�o usando esses parametros
        } catch (Exception ex) {
             throw new RuntimeException("Erro na conex�o com o banco de dados", ex);
        }
    }
    
  //encerrar a conex�o com o banco de dados
    public static void closeConnection(Connection connection) {
        try {//tentar fazer a conex�o se der uma exce��o eu fa�o o catch
            if (connection != null) {//se a conex�o foi criada
                connection.close();//eu fecho a conex�o
            }
        } catch (Exception ex) {//retorno a exce��o
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados", ex);
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
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados", ex);
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
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados", ex);
        }
        
    }
    
}
