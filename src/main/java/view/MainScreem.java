/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ProjectController;
import controller.TaskController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import model.Project;
import model.Task;
import util.ButtonColumnCellRederer;
import util.DeadlineColumnCellRederer;
import util.TaskTableModel;

/**
 *
 * @author FLAVILES
 */
public class MainScreem extends javax.swing.JFrame {

    /**
     * Ciar duas instancias do controlador por que ele vai trazer os dados do banco de dados
     */
    
    ProjectController projectController;
    TaskController taskController;
    
    
    //carregar os dados para o list
    //essa implemeta��o � padr�o do java , s� colocamos os dados e ele apresenta, ESPECIFICA O QUE SER� MOSTRADA NO JLIST
    DefaultListModel projectsModel;
    
    TaskTableModel taskModel;
    
    //m�todo construto
    public MainScreem() {
        initComponents();
        
    
        
        initDataController();
        
        initComponentsModel ();
        
        
        //incluo no final, ap�s renderizar os dados
        decorateTableTasks();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneTasks = new javax.swing.JScrollPane();
        jTableTasks = new javax.swing.JTable();
        jPanelToolBar = new javax.swing.JPanel();
        jLabelToolBarTitle = new javax.swing.JLabel();
        ToolBarSubTitle = new javax.swing.JLabel();
        jPanelProjects = new javax.swing.JPanel();
        jLabelProjectsTitle = new javax.swing.JLabel();
        jLabelProjectsAdd = new javax.swing.JLabel();
        jPanelTasks = new javax.swing.JPanel();
        jLabelTasksTitle = new javax.swing.JLabel();
        jLabelTasksAdd = new javax.swing.JLabel();
        jPanelProjectList = new javax.swing.JPanel();
        jScrollPaneProjects = new javax.swing.JScrollPane();
        jListProjects = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jPanelEmptyList = new javax.swing.JPanel();
        jLabelEmptyListTitle = new javax.swing.JLabel();
        jLabelEmptyListSubTitle = new javax.swing.JLabel();
        jLabelEmptyListIscon = new javax.swing.JLabel();

        jTableTasks.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Descri��o", "Prazo", "Tarefa Conclu�da"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTasks.setGridColor(new java.awt.Color(255, 255, 255));
        jTableTasks.setRowHeight(50);
        jTableTasks.setSelectionBackground(new java.awt.Color(204, 255, 204));
        jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTasks.setShowGrid(false);
        jTableTasks.setShowHorizontalLines(true);
        jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTasksMouseClicked(evt);
            }
        });
        jScrollPaneTasks.setViewportView(jTableTasks);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 800));

        jPanelToolBar.setBackground(new java.awt.Color(0, 153, 102));

        jLabelToolBarTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelToolBarTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolBarTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png"))); // NOI18N
        jLabelToolBarTitle.setText("Todo App");

        ToolBarSubTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ToolBarSubTitle.setForeground(new java.awt.Color(255, 255, 255));
        ToolBarSubTitle.setText("Anote Tudo n�o esque�a nada");

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabelToolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(533, 533, 533))
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(ToolBarSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelToolBarLayout.setVerticalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelToolBarTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ToolBarSubTitle)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanelProjects.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjects.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelProjectsTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelProjectsTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelProjectsTitle.setText("Projetos");

        jLabelProjectsAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelProjectsAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectsAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
        jPanelProjects.setLayout(jPanelProjectsLayout);
        jPanelProjectsLayout.setHorizontalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProjectsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addComponent(jLabelProjectsAdd)
                .addContainerGap())
        );
        jPanelProjectsLayout.setVerticalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProjectsAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelProjectsTitle))
                .addContainerGap())
        );

        jPanelTasks.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTasksTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTasksTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelTasksTitle.setText("Tarefas");

        jLabelTasksAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelTasksAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTasksLayout = new javax.swing.GroupLayout(jPanelTasks);
        jPanelTasks.setLayout(jPanelTasksLayout);
        jPanelTasksLayout.setHorizontalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(734, 734, 734)
                .addComponent(jLabelTasksAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTasksLayout.setVerticalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTasksAdd))
                .addContainerGap())
        );

        jPanelProjectList.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjectList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jListProjects.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jListProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProjects.setFixedCellHeight(50);
        jListProjects.setSelectionBackground(new java.awt.Color(0, 153, 102));
        jListProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProjectsMouseClicked(evt);
            }
        });
        jScrollPaneProjects.setViewportView(jListProjects);

        javax.swing.GroupLayout jPanelProjectListLayout = new javax.swing.GroupLayout(jPanelProjectList);
        jPanelProjectList.setLayout(jPanelProjectListLayout);
        jPanelProjectListLayout.setHorizontalGroup(
            jPanelProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjects, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelProjectListLayout.setVerticalGroup(
            jPanelProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjects)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanelEmptyList.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEmptyListTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelEmptyListTitle.setForeground(new java.awt.Color(0, 153, 102));
        jLabelEmptyListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListTitle.setText("Nenhuma tarefa por aqui :D");

        jLabelEmptyListSubTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelEmptyListSubTitle.setForeground(new java.awt.Color(153, 153, 153));
        jLabelEmptyListSubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListSubTitle.setText("Clique no bot�o \"+\" para adicionar uma nova Tarefa");

        jLabelEmptyListIscon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListIscon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N

        javax.swing.GroupLayout jPanelEmptyListLayout = new javax.swing.GroupLayout(jPanelEmptyList);
        jPanelEmptyList.setLayout(jPanelEmptyListLayout);
        jPanelEmptyListLayout.setHorizontalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                .addGroup(jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmptyListLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelEmptyListSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE))
                    .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabelEmptyListTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelEmptyListIscon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelEmptyListLayout.setVerticalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                .addContainerGap(468, Short.MAX_VALUE)
                .addComponent(jLabelEmptyListTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabelEmptyListSubTitle)
                .addGap(234, 234, 234))
            .addGroup(jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelEmptyListIscon, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE))
        );

        jPanel7.add(jPanelEmptyList, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelProjectsAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectsAddMouseClicked
        // TODO add your handling code here:
        //evento que eu gero quando clico no add
        
        ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen(this, rootPaneCheckingEnabled);
        projectDialogScreen.setVisible(true);
        
             //esse trecho eu estou adicionando um listener de janela, ou seja um ouvinte
            //o listener de janela avisa quando a janela for chamada WindowAdapter();
            //quando ocorrer um evento de fechar execute o loadProjects(mostrar os projetos do Banco de dados)
        projectDialogScreen.addWindowListener(new WindowAdapter() {
            
            //quando a janela de cadastro de projeto for fechada eu atualizo 
            public void windowClosed(WindowEvent e){
                loadProjects();
            }
        });
        
        
        
    }//GEN-LAST:event_jLabelProjectsAddMouseClicked

    private void jLabelTasksAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTasksAddMouseClicked
        // TODO add your handling code here:
        
        //criar uma nova tela de task
        TaskDialogScreen dialogScreen = new TaskDialogScreen(this, rootPaneCheckingEnabled);
        //setar essa tela
        //dialogScreen.setProject(null);
        
        //retorna o indice da lista selecionada
        int projectIndex=jListProjects.getSelectedIndex();
        Project project = (Project)projectsModel.get(projectIndex);
        dialogScreen.setProject(project);
        
        //mostrar a tela para o usuario
        dialogScreen.setVisible(true);
        
                //adicionar um Listner a janela TaskDialog
        
         dialogScreen.addWindowListener(new WindowAdapter() {
            
            //quando a janela de cadastro de projeto for fechada eu atualizo 
            public void windowClosed(WindowEvent e){
                
                //pegar a posi��o que est� selecionada do nosso componente gr�fico
                int projectIndex = jListProjects.getSelectedIndex();
                //vou pegar do meu model o objeto projeto, que corresponde ao item selecionado do meu jList
                Project project = (Project)projectsModel.get(projectIndex);
                loadTasks(project.getId());
            }
         });
    }//GEN-LAST:event_jLabelTasksAddMouseClicked

    private void jTableTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTasksMouseClicked

            // qual a linha da jTableTask, linha que ocorreu o click
            int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());
            int columnIndex = jTableTasks.columnAtPoint(evt.getPoint());
            Task task = taskModel.getTasks().get(rowIndex);
            switch (columnIndex) {
                //quando o evento ocorrer na coluna 3, que mostra se a coluna foi conclu�da ou n�o
                case 3:
                    
                    taskController.update(task);
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    //remover tarefa
                    taskController.removeById(task.getId());
                    taskModel.getTasks().remove(task);
                    
                    int projectIndex = jListProjects.getSelectedIndex();
                    Project project =(Project) projectsModel.get(projectIndex);
                    
                   // atualizar a lista
                    loadTasks(project.getId());
                    
                    break;
                    
                default:
                    throw new AssertionError();
            }
   
        
    }//GEN-LAST:event_jTableTasksMouseClicked
    //quando o usuario clicar na lista de projetos ele deve aparecer as tarefas daquele projeto
    private void jListProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProjectsMouseClicked
        int projectIndex=jListProjects.getSelectedIndex();
        
        Project project = (Project)projectsModel.get(projectIndex);
        loadTasks(project.getId());
        
    }//GEN-LAST:event_jListProjectsMouseClicked

    //ele decide se vai mostrar a lista de tarefas ou n�o
    private void showJTaleTasks(boolean hasTasks){
        
        if(hasTasks){//se existem tarefas
            //a mensagem de lista vazia est� visivel para o usuario
            if(jPanelEmptyList.isVisible()){
                jPanelEmptyList.setVisible(false);
       
                //removi a mensagem de listas vazias
                jPanel7.remove(jPanelEmptyList);
            }
                //se houver tarefas , adicione jScrollPaneTasks) visivel
            jPanel7.add(jScrollPaneTasks);
            //faz jScrollPaneTasks) ficar visivel
            jScrollPaneTasks.setVisible(true);
            //ajuste o tamanho dele para o meu jPanelTasks
            jScrollPaneTasks.setSize(jPanel7.getWidth(), jPanel7.getHeight());
            
        }else{//sen�o tem tarefa e meuJscrollpane que mostra as tarefas ,
            if(jScrollPaneTasks.isVisible()){
                jScrollPaneTasks.setVisible(false);
                // eu vou remov�-lo da tela
                jPanel7.remove(jScrollPaneTasks);
            }
            // e vou adicion�-lo no meu jPanel que tem a lista vazia
            jPanel7.add(jPanelEmptyList);
            //vou deixar visivel
            jPanelEmptyList.setVisible(true);
            //e ajustar no jPanel7
            jPanelEmptyList.setSize(jPanel7.getWidth(), jPanel7.getHeight());
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                //corresponde a um template padr�o do java
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ToolBarSubTitle;
    private javax.swing.JLabel jLabelEmptyListIscon;
    private javax.swing.JLabel jLabelEmptyListSubTitle;
    private javax.swing.JLabel jLabelEmptyListTitle;
    private javax.swing.JLabel jLabelProjectsAdd;
    private javax.swing.JLabel jLabelProjectsTitle;
    private javax.swing.JLabel jLabelTasksAdd;
    private javax.swing.JLabel jLabelTasksTitle;
    private javax.swing.JLabel jLabelToolBarTitle;
    private javax.swing.JList<String> jListProjects;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelEmptyList;
    private javax.swing.JPanel jPanelProjectList;
    private javax.swing.JPanel jPanelProjects;
    private javax.swing.JPanel jPanelTasks;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPaneProjects;
    private javax.swing.JScrollPane jScrollPaneTasks;
    private javax.swing.JTable jTableTasks;
    // End of variables declaration//GEN-END:variables

public void decorateTableTasks(){
    //Customizando o header da table de tarefas
    jTableTasks.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD, 14));
    jTableTasks.getTableHeader().setBackground(new Color(0,153,102));
    jTableTasks.getTableHeader().setForeground(new Color(255,255,255));
    
    //eu estou pegando a minha jTable, e pego a segunda coluna, seta o cellRenderer();, ao inv�s de usar o padr�o ele o que foi desenvolvido
    jTableTasks.getColumnModel().getColumn(2).setCellRenderer(new DeadlineColumnCellRederer());
    
     jTableTasks.getColumnModel().getColumn(4).setCellRenderer(new ButtonColumnCellRederer("edit"));
      jTableTasks.getColumnModel().getColumn(5).setCellRenderer(new ButtonColumnCellRederer("delete"));
    
    
    //criando um sorte autom�tico para as colunas da table.
    //faz com que possamos ordenar as colunas
    jTableTasks.setAutoCreateRowSorter(true);
    
    
    
}
    //vou chamar esse m�todo no m�todo construtor
public void initDataController(){
    
    //instanciei as variaveis que descrevi acima
    projectController = new ProjectController();
    taskController = new TaskController();
    
    
    
}
//iniciando o meu projectsModel
    public void initComponentsModel (){
        //vou guardar dentro dele os meus projetos
    projectsModel = new DefaultListModel();
    
    //carregar os dados para dentro desse model, para ele poder exibir
    loadProjects();
    
    taskModel = new TaskTableModel();
    jTableTasks.setModel(taskModel);

    
    //se foi carregado algum projeto seto os itens da lista para ser o item selecionado primerio
    if (!projectsModel.isEmpty()) {
            jListProjects.setSelectedIndex(0);
            int projectIndex = jListProjects.getSelectedIndex();
            Project project = (Project) projectsModel.get(projectIndex);
            loadTasks(project.getId());
        }
    
    
    }
    
    //esse m�todo vai carregar as tarefas do BD, e vai setar as tarefas para dentro do nosso tableModel
    public void loadTasks(int idProject){//id do projeto
        //carrega todas as tarefas  no banco de dados
        List<Task> tasks = taskController.getAll(idProject);
        //setei as tarefas
        taskModel.setTasks(tasks);
        
        //mostra a jTable de tarefas(a lista n�o est� vazia)
        showJTaleTasks(! tasks.isEmpty()); //se a lista n�o estiver vazia vir� um true ,
        
    }
    



public void loadProjects(){
    
    //estrutura que vai guardar os nossos projets
    List<Project> projects = projectController.getAll();
    
    //caso exista dados, eu quero que limpe os dados
    //limpei a estrutura que guarda esses projetos da classe jList
    projectsModel.clear();
    
    //vou adicionar todos os projetos que est�o dentro dessa lista
    for(int i=0; i<projects.size();i++){
    
        Project project = projects.get(i);
        projectsModel.addElement(project);
        
    }
    
    
    //depois que carregamos temos que vincular que project model est� vinculado ao jList
    jListProjects.setModel(projectsModel);
    
    
}

}
