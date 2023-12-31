package com.github.throyer.todoapp.views;

import com.github.throyer.todoapp.domain.entities.Task;
import com.github.throyer.todoapp.domain.models.Session;
import com.github.throyer.todoapp.domain.repositories.TaskRepository;
import com.github.throyer.todoapp.infra.ui.View;
import com.github.throyer.todoapp.infra.ui.ViewManager;
import com.github.throyer.todoapp.infra.ui.Views;
import com.github.throyer.todoapp.utils.Icons;

import java.awt.Color;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jiconfont.icons.FontAwesome;
import org.springframework.stereotype.Component;

@Component
public class CreateTask extends View {

    private final TaskRepository repository;
    private final Session session;
    
    public CreateTask(
        TaskRepository repository,
        Session session
    ) {
        this.repository = repository;
        this.session = session;
        
        setIconImage(Icons.image(
            FontAwesome.LIST,
            45,
            new Color(160, 160, 160)
        ));

        setTitle(String.format("Cadastrar tarefa")); 
        
        initComponents();
    }

    @Override
    public void onOpen() {
        this.inputDateTimePicker.setDateTimePermissive(LocalDateTime.now());
    }
        
    public void handleCreateNewTask() {
        var name = inputName.getText();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                new JFrame("Campos invalidos"),
                "Informe o nome da tarefa"
            );
            
            return;
        }
        
        var date = inputDateTimePicker.getDateTimePermissive();
        var user = session.user().orElseThrow(() -> new RuntimeException("nenhum usuario encontrado"));
        
        repository.save(new Task(name, date, user));
               
        JOptionPane.showMessageDialog(
            new JFrame("Tarefa cadastrada com sucesso"),
            "Tarefa criada"
        );
            
        handleBackToTasks();
    }

    public void handleEditCategories() {
        ViewManager.navigate(Views.CREATE_TASK, Views.CATEGORY_MANAGER);
    }
    
    public void handleBackToTasks() {
        ViewManager.navigate(Views.CREATE_TASK, Views.TASK_MANAGER);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        PanelDescFrame = new javax.swing.JPanel();
        LabelDescFrame = new javax.swing.JLabel();
        SeparatorTop = new javax.swing.JSeparator();
        PanelInfoTarefa = new javax.swing.JPanel();
        PanelDescricao = new javax.swing.JPanel();
        PanelEspaceEsq = new javax.swing.JPanel();
        LabelDescricao = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        PanelEspaceDir = new javax.swing.JPanel();
        PanelEspaceInfo = new javax.swing.JPanel();
        PanelDateTimeCategories = new javax.swing.JPanel();
        PanelCategoriesPick = new javax.swing.JPanel();
        PanelDateTimeInfo = new javax.swing.JPanel();
        LabelDateTimeInfo = new javax.swing.JLabel();
        inputDateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        PanelCaregoriesInfo = new javax.swing.JPanel();
        LabelCategories = new javax.swing.JLabel();
        PanelTableCategories = new javax.swing.JPanel();
        scroller = new javax.swing.JScrollPane();
        TableCaregorias = new javax.swing.JTable();
        PanelEditarCategorias = new javax.swing.JPanel();
        buttonEditCategories = new javax.swing.JButton();
        SeparatorBot = new javax.swing.JSeparator();
        PanelButtons = new javax.swing.JPanel();
        buttomBackToTasks = new javax.swing.JButton();
        buttomCreateNewTask = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        PanelDescFrame.setLayout(new javax.swing.BoxLayout(PanelDescFrame, javax.swing.BoxLayout.LINE_AXIS));

        LabelDescFrame.setText("Adicionar tarefa");
        PanelDescFrame.add(LabelDescFrame);

        getContentPane().add(PanelDescFrame);

        SeparatorTop.setMinimumSize(new java.awt.Dimension(0, 10));
        SeparatorTop.setPreferredSize(new java.awt.Dimension(0, 10));
        getContentPane().add(SeparatorTop);

        PanelInfoTarefa.setLayout(new javax.swing.BoxLayout(PanelInfoTarefa, javax.swing.BoxLayout.Y_AXIS));

        PanelDescricao.setLayout(new javax.swing.BoxLayout(PanelDescricao, javax.swing.BoxLayout.LINE_AXIS));

        PanelEspaceEsq.setMaximumSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout PanelEspaceEsqLayout = new javax.swing.GroupLayout(PanelEspaceEsq);
        PanelEspaceEsq.setLayout(PanelEspaceEsqLayout);
        PanelEspaceEsqLayout.setHorizontalGroup(
            PanelEspaceEsqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        PanelEspaceEsqLayout.setVerticalGroup(
            PanelEspaceEsqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        PanelDescricao.add(PanelEspaceEsq);

        LabelDescricao.setText("Nome: ");
        PanelDescricao.add(LabelDescricao);

        inputName.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        inputName.setMinimumSize(new java.awt.Dimension(6, 30));
        inputName.setPreferredSize(new java.awt.Dimension(6, 30));
        PanelDescricao.add(inputName);

        PanelEspaceDir.setMaximumSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout PanelEspaceDirLayout = new javax.swing.GroupLayout(PanelEspaceDir);
        PanelEspaceDir.setLayout(PanelEspaceDirLayout);
        PanelEspaceDirLayout.setHorizontalGroup(
            PanelEspaceDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        PanelEspaceDirLayout.setVerticalGroup(
            PanelEspaceDirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        PanelDescricao.add(PanelEspaceDir);

        PanelInfoTarefa.add(PanelDescricao);

        PanelEspaceInfo.setMaximumSize(new java.awt.Dimension(10, 10));

        javax.swing.GroupLayout PanelEspaceInfoLayout = new javax.swing.GroupLayout(PanelEspaceInfo);
        PanelEspaceInfo.setLayout(PanelEspaceInfoLayout);
        PanelEspaceInfoLayout.setHorizontalGroup(
            PanelEspaceInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        PanelEspaceInfoLayout.setVerticalGroup(
            PanelEspaceInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        PanelInfoTarefa.add(PanelEspaceInfo);

        PanelDateTimeCategories.setLayout(new javax.swing.BoxLayout(PanelDateTimeCategories, javax.swing.BoxLayout.LINE_AXIS));

        PanelCategoriesPick.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelCategoriesPick.setLayout(new javax.swing.BoxLayout(PanelCategoriesPick, javax.swing.BoxLayout.Y_AXIS));

        PanelDateTimeInfo.setLayout(new javax.swing.BoxLayout(PanelDateTimeInfo, javax.swing.BoxLayout.LINE_AXIS));

        LabelDateTimeInfo.setText("Selecione uma data e um horario");
        PanelDateTimeInfo.add(LabelDateTimeInfo);

        PanelCategoriesPick.add(PanelDateTimeInfo);

        inputDateTimePicker.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        inputDateTimePicker.setMinimumSize(new java.awt.Dimension(240, 30));
        inputDateTimePicker.setPreferredSize(new java.awt.Dimension(240, 30));
        PanelCategoriesPick.add(inputDateTimePicker);

        PanelCaregoriesInfo.setLayout(new javax.swing.BoxLayout(PanelCaregoriesInfo, javax.swing.BoxLayout.LINE_AXIS));

        LabelCategories.setText("Selecione uma ou mais categorias para sua tarefa");
        PanelCaregoriesInfo.add(LabelCategories);

        PanelCategoriesPick.add(PanelCaregoriesInfo);

        PanelTableCategories.setLayout(new javax.swing.BoxLayout(PanelTableCategories, javax.swing.BoxLayout.LINE_AXIS));

        TableCaregorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Categoria", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroller.setViewportView(TableCaregorias);
        if (TableCaregorias.getColumnModel().getColumnCount() > 0) {
            TableCaregorias.getColumnModel().getColumn(0).setResizable(false);
            TableCaregorias.getColumnModel().getColumn(1).setResizable(false);
        }

        PanelTableCategories.add(scroller);

        PanelCategoriesPick.add(PanelTableCategories);

        PanelEditarCategorias.setLayout(new javax.swing.BoxLayout(PanelEditarCategorias, javax.swing.BoxLayout.LINE_AXIS));

        buttonEditCategories.setText("Editar categorias");
        buttonEditCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickEdit(evt);
            }
        });
        PanelEditarCategorias.add(buttonEditCategories);

        PanelCategoriesPick.add(PanelEditarCategorias);

        PanelDateTimeCategories.add(PanelCategoriesPick);

        PanelInfoTarefa.add(PanelDateTimeCategories);

        getContentPane().add(PanelInfoTarefa);

        SeparatorBot.setMinimumSize(new java.awt.Dimension(0, 10));
        SeparatorBot.setPreferredSize(new java.awt.Dimension(0, 10));
        getContentPane().add(SeparatorBot);

        PanelButtons.setLayout(new javax.swing.BoxLayout(PanelButtons, javax.swing.BoxLayout.LINE_AXIS));

        buttomBackToTasks.setText("Voltar");
        buttomBackToTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickBack(evt);
            }
        });
        PanelButtons.add(buttomBackToTasks);

        buttomCreateNewTask.setText("Adicionar");
        buttomCreateNewTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickCreate(evt);
            }
        });
        PanelButtons.add(buttomCreateNewTask);

        getContentPane().add(PanelButtons);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onClickEdit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickEdit
        handleEditCategories();
    }//GEN-LAST:event_onClickEdit

    private void onClickBack(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickBack
        handleBackToTasks();
    }//GEN-LAST:event_onClickBack

    private void onClickCreate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickCreate
        handleCreateNewTask();
    }//GEN-LAST:event_onClickCreate
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCategories;
    private javax.swing.JLabel LabelDateTimeInfo;
    private javax.swing.JLabel LabelDescFrame;
    private javax.swing.JLabel LabelDescricao;
    private javax.swing.JPanel PanelButtons;
    private javax.swing.JPanel PanelCaregoriesInfo;
    private javax.swing.JPanel PanelCategoriesPick;
    private javax.swing.JPanel PanelDateTimeCategories;
    private javax.swing.JPanel PanelDateTimeInfo;
    private javax.swing.JPanel PanelDescFrame;
    private javax.swing.JPanel PanelDescricao;
    private javax.swing.JPanel PanelEditarCategorias;
    private javax.swing.JPanel PanelEspaceDir;
    private javax.swing.JPanel PanelEspaceEsq;
    private javax.swing.JPanel PanelEspaceInfo;
    private javax.swing.JPanel PanelInfoTarefa;
    private javax.swing.JPanel PanelTableCategories;
    private javax.swing.JSeparator SeparatorBot;
    private javax.swing.JSeparator SeparatorTop;
    private javax.swing.JTable TableCaregorias;
    private javax.swing.JButton buttomBackToTasks;
    private javax.swing.JButton buttomCreateNewTask;
    private javax.swing.JButton buttonEditCategories;
    private com.github.lgooddatepicker.components.DateTimePicker inputDateTimePicker;
    private javax.swing.JTextField inputName;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JScrollPane scroller;
    // End of variables declaration//GEN-END:variables
}
