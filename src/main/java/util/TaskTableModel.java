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
    String[] columns = {"Nome" , "Descri��o", "Prazo", "Tarefa Conclu�da", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList<>();
    
        
        
//3 m�todos abstratos que essa classe j� possui, e tenho que implementa-los pois � da classe AbstractTableModel
    @Override
    public int getRowCount() {//quantas tarefas eu j� tenho
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
