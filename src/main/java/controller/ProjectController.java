/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author AEVILES
 */

//CRIAR METODOS DO BANCO
public class ProjectController {
    
    public void save(Project project){
         String sql = "INSERT INTO projects(name, description, createdAt, updateAt) VALUES (?, ?, ?, ?)"; //sempre que eu tiver que incluir um valor num sql e eu não tenha eu incluo uma interrogação
        
        //Conexão
        Connection conn= null;
         //Statment prepara o comando sql para ser utilizado no sql
        PreparedStatement statment= null; 
        
        //um bloco try por que podemos ter uma operação de erro
        
        try {
              //Estabelecendo a conexao com o DB
             conn =  ConnectionFactory.getConnection();
            //preparando a query /prepara o comando sql para ser utilizado no sql
            statment = conn.prepareStatement(sql);
            //setando os valores para dentro do statment
            statment.setString(1, project.getName());
            statment.setString(2, project.getDescription());
            statment.setDate(3,new Date(project.getCreatedAt().getTime()));
            statment.setDate(4, new Date( project.getUpdateAt().getTime()));
            //executando a query, quando a linha abaixo for executada aí iremos inserir os dados acima dentro do project
            statment.execute();
            
            } catch (SQLException e) {
                        throw new RuntimeException("Não foi possível salvar" +e.getMessage());
                    } finally{
                        ConnectionFactory.closeConnection(conn , statment);
                    }
    
    }
    
    public void update(Project project){
        
         String sql = "UPDATE projects SET name = ?,"+ "description = ?,"+ "createdAt = ?,"+ "updateAt = ? WHERE id=?";
        
         //Conexão
        Connection conn= null;
         //Statment prepara o comando sql para ser utilizado no sql
        PreparedStatement statment= null; 
        
        //um bloco try por que podemos ter uma operação de erro
        
        try {
              //Estabelecendo a conexao com o DB
            conn = ConnectionFactory.getConnection();
            //preparando a query /prepara o comando sql para ser utilizado no sql
            statment = conn.prepareStatement(sql);
            //setando os valores do statment
            statment.setString(1, project.getName());
            statment.setString(2, project.getDescription());
            statment.setDate(3,new Date(project.getCreatedAt().getTime()));
            statment.setDate(4, new Date( project.getUpdateAt().getTime()));
            statment.setInt(5, project.getId());
           
            
            //executando a query, quando a linha abaixo for executada aí iremos inserir os dados acima dentro da tarefa
            statment.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível atualizar o projeto."+ e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(conn, statment);
        }
    }
                
    
  
    
    //Devolve uma lista de tarefas
    public List<Project> getAll(){
        
        String sql = "SELECT * FROM projects";
        
        
           //Conexão
        Connection conn  = null;
        
        //Statment prepara o comando sql para ser utilizado no sql
        PreparedStatement statment=null;
        
        //variavel que guarda o Retorno do banco de dados o resultSet, é nessa que vamos guardar a resposta do Banco de dados
        //quando eu faço um select eu tenho que pegar o resultado que vem do meu banco de dados
        ResultSet resultSet = null;
        
        //Lista de tarefas que será devolvida quando a chamada do método acontecer
        //usado para coleções, conjunto de valores
        List<Project> projects = new ArrayList<>();
        
        
        try {
            //Estabelecendo a conexao com o DB
            conn = ConnectionFactory.getConnection();
            //preparando a query /prepara o comando sql para ser utilizado no sql
            statment = conn.prepareStatement(sql);

            //executando a query
           resultSet= statment.executeQuery();//ele devolve o ResultSet
           
           //enquanto houverem valores percorridos no meu resultSet
            while (resultSet.next()) {//enquanto houver um proximo eu vou pegando esses valores
                
                //crio um novo projeto
                Project project = new Project();
                
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updateAt"));
                
                //adiciono o ptojeto recuperado na lista de projetos
                projects.add(project);
                
            }
            
        } catch (SQLException e) { //ocorrer um erro agente trata a exceção
            throw new RuntimeException("Erro ao buscar os projetos"+ e.getMessage());
        } finally {  //o bloco finally é um bloco que sempre será executado
            ConnectionFactory.closeConnection(conn , statment, resultSet);
        }
        
        //lista de tarefas que foi criada e carregada do banco de dados
        return projects;
    }
    
     
    public void removeById( int idProject) {
    
        String sql = "DELETE FROM projects WHERE id = ?";
        
        //Conexão
        Connection conn  = null;
        
        //Statment prepara o comando sql para ser utilizado no sql
        PreparedStatement statment=null;
        
     
        try {
            //Estabelecendo a conexao com o DB
            conn = ConnectionFactory.getConnection();
            //preparando a query /prepara o comando sql para ser utilizado no sql
            statment = conn.prepareStatement(sql);
            //setando os valores
            statment.setInt(1, idProject);
            //executando a query
            statment.execute();
            
        } catch (SQLException e) { //ocorrer um erro agente trata a exceção
            throw new RuntimeException("Erro ao deletar a tarefa" + e.getMessage());
        } finally {  //o bloco finally é um bloco que sempre será executado
            ConnectionFactory.closeConnection(conn , statment);
        }
        
    }
    
}
