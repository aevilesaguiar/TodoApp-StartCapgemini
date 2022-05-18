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

//A classe TasktableModel � a classe respons�vel por mostrar quais dados devem ser exibidos pelo jTable

//Essa classe AbstractTableModel � uma implementa��o padr�o do java para Model
public class TaskTableModel extends AbstractTableModel{
     //vetor de string que chamarei de coluns, possui todas as strings que correspondem as colunas do meu table
    String[] columns = {"Nome" , "Descri��o", "Prazo", "Tarefa Conclu�da", "Editar", "Excluir"};
    List<Task> tasks = new ArrayList<>();
    
        
        
//3 m�todos abstratos que essa classe j� possui, e tenho que implementa-los pois � da classe AbstractTableModel
    @Override
    public int getRowCount() {//quantas linhas a minha tabela tem (minha jTable)
       return tasks.size();
    }

    @Override
    public int getColumnCount() {//quantas colunas eu tenho
        return columns.length;
    }
    
    //metodo que n�o � obrigatorio , mas precisamos para mostrar o nome das colunas
    @Override
    public String getColumnName (int columnIndex){
        return columns[columnIndex];
        
    }
    
    //metodo que faz com que as celulas da jTable sejam edit�veis
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
    
    //m�todo que implementa o check na coluna da coluna como conclu�da
    @Override
    public Class<?> getColumnClass(int columnIndex){//qual a classe de determinado componente, se � string, boolean..., da classe pai retorna String, vamos mudar para aparecer os tipos de cada coluna definido
        //se tasks estiver vazio retorno o tipo de dado Object, pois ele n�o tem nada para exibir na jtable
        if(tasks.isEmpty()){
            return Object.class;
                    
        }
        //caso n�o seja vazio ele chama o metodo getValueAt da primeira linha, se for coluna 1 (columnIndex) e ele retorna a classe e retorna o tipo de dado e retorna a classe do tipo String, boolean, date....
        return this.getValueAt(0,columnIndex).getClass();
    }
    
    
    //fazer um m�todo que seta a informa��o
    @Override
    public void setValueAt(Object aValue,  int rowIndex, int columnIndex){
        //recebi o valor que foi setado na tarefa e pergunto se foi concluido ou n�o
        tasks.get(rowIndex).setIsCompleted((boolean) aValue);//CAST O COMPONENTE GR�FICO TRANSFORMA EM OBJECT E FA�O O CAST PARA BOOLEAN
       
        
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
               return "Dados n�o encontrados";
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
