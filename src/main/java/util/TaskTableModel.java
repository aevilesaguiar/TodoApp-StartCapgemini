/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author AEVILES
 */

//A classe TasktableModel é a classe responsável por mostrar quais dados devem ser exibidos pelo jTable

//Essa classe AbstractTableModel é uma implementação padrão do java para Model
public class TaskTableModel extends AbstractTableModel{
     //vetor de string que chamarei de coluns, possui todas as strings que correspondem as colunas do meu table
    String[] columns = {"Nome" , "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList<>();
    
        
        
//3 métodos abstratos que essa classe já possui, e tenho que implementa-los pois é da classe AbstractTableModel
    @Override
    public int getRowCount() {//quantas linhas a minha tabela tem (minha jTable)
       return tasks.size();
    }

    @Override
    public int getColumnCount() {//quantas colunas eu tenho
        return columns.length;
    }
    
    //metodo que não é obrigatorio , mas precisamos para mostrar o nome das colunas
    @Override
    public String getColumnName (int columnIndex){
        return columns[columnIndex];
        
    }
    
    //metodo que faz com que as celulas da jTable sejam editáveis
    public boolean isCellEditable(int rowIndex, int columnIndex){
        
        //aqui ele permite apenas que editemos a column 3
        return columnIndex==3;
        /*
        if(columnIndex==3){
            return true;
        }else{
            return false;
        }*/
        
    }
    
    //método que implementa o check na coluna da coluna como concluída
    @Override
    public Class<?> getColumnClass(int columnIndex){//qual a classe de determinado componente, se é string, boolean..., da classe pai retorna String, vamos mudar para aparecer os tipos de cada coluna definido
        //se tasks estiver vazio retorno o tipo de dado Object, pois ele não tem nada para exibir na jtable
        if(tasks.isEmpty()){
            return Object.class;
                    
        }
        //caso não seja vazio ele chama o metodo getValueAt da primeira linha, se for coluna 1 (columnIndex) e ele retorna a classe e retorna o tipo de dado e retorna a classe do tipo String, boolean, date....
        return this.getValueAt(0,columnIndex).getClass();
    }
    
    
    //fazer um método que seta a informação
    @Override
    public void setValueAt(Object aValue,  int rowIndex, int columnIndex){
        //recebi o valor que foi setado na tarefa e pergunto se foi concluido ou não
        tasks.get(rowIndex).setIsCompleted((boolean) aValue);//CAST O COMPONENTE GRÁFICO TRANSFORMA EM OBJECT E FAÇO O CAST PARA BOOLEAN
       
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//qual o valor exibido em determinada linha e coluna, O switch foi feito a partir da coluna
        switch (columnIndex) {
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                //retorna a data formatada, deveolvendo uma String
                return dateFormat.format(tasks.get(rowIndex).getDeadline());
            case 3:
                return tasks.get(rowIndex).isIsCompleted();
            case 4:
                return "";
           case 5:
                return "";
            default:
               return "Dados não encontrados";
        }
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    
    
}
