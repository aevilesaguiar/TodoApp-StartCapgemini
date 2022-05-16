/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Task;
import util.ConnectionFactory;
/**
 *
 * @author AEVILES
 */

//CRIAR METODOS DO BANCO
public class TaskController {
    
    public void save(Task task){
          String sql = "INSERT INTO tasks ("
                +"idProject,"
                + "name,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,"
                +"createdAt,"
                + "updateAt) VALUES(?,?,?,?,?,?,?,?)"; //sempre que eu tiver que incluir um valor num sql e eu não tenha eu incluo uma interrogação
        
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
            //setando os valores para dentro do statment
          
            statment.setInt(1,task.getIdProject());
            statment.setString(2,task.getName());
            statment.setString(3, task.getDescription());
            statment.setBoolean(4,task.isIsCompleted());
            statment.setString(5,task.getNotes());
            statment.setDate(6,new Date(task.getDeadline().getTime()));//tenho que criar uma nova data, ele está convertendo pois o Date do java é diferente do Date do SQL, 
            statment.setDate(7, new Date( task.getCreatedAt().getTime()));
            statment.setDate(8, new Date( task.getUpdateAt().getTime()));
            //executando a query, quando a linha abaixo for executada aí iremos inserir os dados acima dentro da tarefa
            statment.execute();
            
        } catch (Exception e) {
            
        throw new RuntimeException("erro ao salvar? a tarefa"+ e.getMessage(),e);
        
        }finally{
            
            ConnectionFactory.closeConnection(conn, statment);
            
            
        }
    
    }
    
    public void update(Task task){
        
        String sql = "UPDATE tasks SET "
                +"idProject = ?, "
                +"name = ?, "
                +"description = ?, "
                +"notes=?, "
                +"completed = ?, "
                +"deadline = ?, "
                +"createdAt = ?, "
                +"updateAt = ? "
                +"WHERE id = ?";
        
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
    statment.setInt (1,task.getIdProject());
            statment.setString(2, task.getName());
            statment.setString(3, task.getDescription());
            statment.setString(4, task.getNotes());
            statment.setBoolean(5, task.isIsCompleted());
            statment.setDate(6, new Date (task.getDeadline().getTime()));
            statment.setDate(7, new Date(task.getCreatedAt().getTime()));
            statment.setDate(8, new Date( task.getUpdateAt().getTime()));
            statment.setInt(9, task.getId());
            statment.execute();
           
            
            //executando a query, quando a linha abaixo for executada aí iremos inserir os dados acima dentro da tarefa
            statment.execute();
            
        }catch (SQLException e) {
              throw new RuntimeException ("Erro ao atualizar a tarefa"+ e.getMessage());
        
        }finally{
            
            ConnectionFactory.closeConnection(conn, statment);
            
            
        }
                
                
        
    }
    
    
    public void removeById( int taskId) throws SQLException{
    
        String sql = "DELETE FROM tasks WHERE id=?";
        
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
            statment.setInt(1, taskId);
            //executando a query
            statment.execute();
            
        } catch (Exception e) { //ocorrer um erro agente trata a exceção
            throw new RuntimeException("Erro ao deletar a tarefa");
        } finally {  //o bloco finally é um bloco que sempre será executado
            ConnectionFactory.closeConnection(conn , statment);
        }
        
    }
    
    //Devolve uma lista de tarefas
    public List<Task> getAll(int idProject){
        
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        
        
           //Conexão
        Connection conn  = null;
        
        //Statment prepara o comando sql para ser utilizado no sql
        PreparedStatement statment=null;
        
        //variavel que guarda o Retorno do banco de dados o resultSet, é nessa que vamos guardar a resposta do Banco de dados
        ResultSet resultSet = null;
        
        //Lista de tarefas que será devolvida quando a chamada do método acontecer
        //usado para coleções, conjunto de valores
        List<Task> tasks = new ArrayList<>();
        
        
        try {
            //Estabelecendo a conexao com o DB
            conn = ConnectionFactory.getConnection();
            //preparando a query /prepara o comando sql para ser utilizado no sql
            statment = conn.prepareStatement(sql);
            //setando oo valor que corresponde ao filtro de busca
            statment.setInt(1, idProject);
            //executando a query
           resultSet= statment.executeQuery();//ele devolve o ResultSet
           
           //enquanto houverem valores percorridos no meu resultSet
            while (resultSet.next()) {//enquanto houver um proximo eu vou pegando esses valores
                //crio uma nova tarefa
               Task task = new Task();
               task.setId(resultSet.getInt("id"));
               task.setIdProject(resultSet.getInt("idProject"));
               task.setName(resultSet.getString("name"));
               task.setDescription(resultSet.getString("description"));
               task.setNotes(resultSet.getString("notes"));
               task.setIsCompleted(resultSet.getBoolean("completed"));
               task.setDeadline(resultSet.getDate("deadline"));
               task.setCreatedAt(resultSet.getDate("createdAt"));
               task.setUpdatedAt(resultSet.getDate("updateAt"));
                
                //pego os dados que populei e adiciono no banco de dados
                tasks.add(task);
                
            }
            
        } catch (Exception e) { //ocorrer um erro agente trata a exceção
           throw new RuntimeException("Erro ao inserir a tarefa" + e.getMessage());
        } finally {  //o bloco finally é um bloco que sempre será executado
            ConnectionFactory.closeConnection(conn , statment, resultSet);
        }
        
        //lista de tarefas que foi criada e carregada do banco de dados
        return tasks;
    }
    
}
