/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author AEVILES
 */
public class TaskTableModel extends AbstractTableModel{
     //vetor de string que chamarei de coluna, possui todas as strings que correspondem as colunas do meu table
    String[] columns = {"Nome" , "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList<>();
    
        
        
//3 métodos abstratos que essa classe já possui, e tenho que implementa-los pois é da classe AbstractTableModel
    @Override
    public int getRowCount() {//quantas tarefas eu já tenho
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {//quantas colunas eu tenho
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int i, int i1) {//qual o valor exibido em determinada linha e coluna
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
