package com.github.throyer.todoapp.views;

import java.awt.Color;
import java.text.MessageFormat;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.github.throyer.todoapp.domain.models.Session;
import com.github.throyer.todoapp.domain.repositories.TaskRepository;
import com.github.throyer.todoapp.infra.ui.View;
import com.github.throyer.todoapp.infra.ui.ViewManager;
import com.github.throyer.todoapp.infra.ui.Views;
import com.github.throyer.todoapp.utils.Icons;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

@Component
public class Tasks extends View {
    private final int FINALIZACAO_CONTROLADA = 0;

    private final Session session;
    private final TaskRepository taskRepository;
    
    public Tasks(
        Session session,
        TaskRepository taskRepository
    ) {        
        this.session = session;
        this.taskRepository = taskRepository;
        
        initComponents();
        
        this.setExtendedState(MAXIMIZED_BOTH);
        
        setIconImage(Icons.image(
            FontAwesome.LIST,
            45,
            new Color(160, 160, 160)
        ));
    }

    @Override
    public void onOpen() {
        session.user().ifPresent(user -> {
            setTitle(String.format("Tarefas de %s", user.getName()));
            menuUsuario.setText(user.getName());
            userItemApagarConta.setText(String.format("Excluir %s", user.getName()));
            populateTable();
        });
    }
    
    public void handleSaveTasks() {
        int result = JOptionPane.showConfirmDialog(
            null,
            "Deseja salvar alterações?",
            "Alerta!",
            JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {
            
            for (int i = 0; i < table.getRowCount(); i++) {

                var id = (long) table.getValueAt(i, 0);
                var name = (String) table.getValueAt(i, 2);              
                var finished = (boolean) table.getValueAt(i, 5);

                var optional = taskRepository.findById(id);
                
                optional.ifPresent(task -> {
                    task.setName(name);
                    task.setFinished(finished);
                    
                    taskRepository.save(task);
                });               
            }
            
            JFrame frame = new JFrame("Alerta");
            JOptionPane.showMessageDialog(frame, "Tarefas atualizadas.");
        }
    }
    
    public void handleDeleteUser() {        
        int result = JOptionPane.showConfirmDialog(
            null,
            """
                Deseja mesmo apagar seu usuario?
                Ao clicar em "SIM" todas suas tarefas serão apagadas do Banco
            """,
            "Alerta!",
            JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(new JFrame("Alerta"), "Função em desenvolvimento");
            return;
        }
        
        JOptionPane.showMessageDialog(new JFrame("Alerta"), "Função em desenvolvimento");
    }
    
    public void handleChangePassword() {        
        int selectedOption = JOptionPane.showConfirmDialog(
            null,
            "Deseja mudar sua senha?",
            "Alerta!",
            JOptionPane.YES_NO_OPTION
        );

        JFrame frame = new JFrame("Alerta");
        if (selectedOption == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(frame, "Função em desenvolvimento");
            return;
        }
        
        JOptionPane.showMessageDialog(frame, "Função em desenvolvimento");
    }
    
    public void handlenavigateToCreateNewTask() {
        JOptionPane.showMessageDialog(new JFrame("Alerta"), "Função em desenvolvimento");
    }
    
    public void handleRemoveTasks() {
        int[] rows = table.getSelectedRows();
        
        var noneSelect = rows.length == 0;
        var moreThanOne = rows.length > 1;
        
        if (noneSelect) {
            JOptionPane.showMessageDialog(
                new JFrame("Alert!"),
                "Selecione ao menos uma tarefa"
            );
        }
        
        var moreThanOneMessage = "as tarefas selecionadas";
        var onlyOneMessage = "a tarefa selecionada";
        
        var message = moreThanOne ? moreThanOneMessage : onlyOneMessage;

        int result = JOptionPane.showConfirmDialog(
            null,
            MessageFormat.format("Deseja remover {1}?", message),
            "Alerta!",
            JOptionPane.YES_NO_OPTION
        );
        
        if (result == JOptionPane.YES_OPTION) {
            for (int i = 0; i < rows.length; i++) {
                var row = rows[i];
                var id = (long) table.getValueAt(row, 0);
                
                taskRepository.deleteById(id);
            }
                    
            populateTable();
        }        
    }
    
    public void handleNavigateToLogin() {
        session.logout();
        ViewManager.navigate(Views.TASK_MANAGER, Views.LOGIN);
    }
    
    public void handleCloseApp() {
        System.exit(FINALIZACAO_CONTROLADA);
    }

    private void populateTable() {
        this.session.user()
            .ifPresent(user -> {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
        
                var tasks = taskRepository.findByUser_Id(user.getId());

                for (int index = 0; index < tasks.size(); index++) {
                    
                    var task = tasks.get(index);
                    model.addRow(new Object[]{
                        task.getId(),
                        index + 1,
                        task.getName(),
                        "Não implementado",
                        Optional.ofNullable(task.getExpiresAt())
                            .map(date -> date
                                .format(DateTimeFormatter
                                    .ofPattern("dd/MM/yyyy hh:mm")))
                            .orElse("Não informado"),
                        task.getFinished(),
                        false
                    });
                }
            });        
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

        scroller = new javax.swing.JScrollPane();
        table = new JTable();
        panelButtons = new javax.swing.JPanel();
        buttonNovaTarefa = new javax.swing.JButton();
        buttonRemover = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();
        MenuPrincipal = new javax.swing.JMenuBar();
        menuTodosapp = new javax.swing.JMenu();
        IconFontSwing.register(FontAwesome.getIconFont());
        Icon siginOutIcon = IconFontSwing.buildIcon(FontAwesome.SIGN_OUT, 15, new Color(0, 0, 0));
        todosappItemMudarUsuario = new javax.swing.JMenuItem();
        IconFontSwing.register(FontAwesome.getIconFont());
        Icon exitIcon = IconFontSwing.buildIcon(FontAwesome.TIMES_CIRCLE, 15, new Color(0, 0, 0));
        todosappItemFechar = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        IconFontSwing.register(FontAwesome.getIconFont());
        Icon lockIcon = IconFontSwing.buildIcon(FontAwesome.LOCK, 15);
        userItemMudarSenha = new javax.swing.JMenuItem();
        IconFontSwing.register(FontAwesome.getIconFont());
        Icon trashIcon = IconFontSwing.buildIcon(FontAwesome.TRASH, 15);
        userItemApagarConta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "#", "Descrição", "Categorias", "Prazo", "Feita"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        scroller.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(1);
            table.getColumnModel().getColumn(0).setPreferredWidth(1);
            table.getColumnModel().getColumn(0).setMaxWidth(1);
            table.getColumnModel().getColumn(1).setMinWidth(30);
            table.getColumnModel().getColumn(1).setMaxWidth(30);
            table.getColumnModel().getColumn(4).setMinWidth(130);
            table.getColumnModel().getColumn(4).setMaxWidth(130);
            table.getColumnModel().getColumn(5).setMinWidth(50);
            table.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        getContentPane().add(scroller);

        panelButtons.setLayout(new javax.swing.BoxLayout(panelButtons, javax.swing.BoxLayout.LINE_AXIS));

        buttonNovaTarefa.setText("Nova Tarefa");
        IconFontSwing.register(FontAwesome.getIconFont());
        Icon plusIcon = IconFontSwing.buildIcon(FontAwesome.PLUS_SQUARE, 20);
        buttonNovaTarefa.setIcon(plusIcon);
        buttonNovaTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickNewTask(evt);
            }
        });
        panelButtons.add(buttonNovaTarefa);

        IconFontSwing.register(FontAwesome.getIconFont());
        Icon removeIcon = IconFontSwing.buildIcon(FontAwesome.TRASH, 20);
        buttonRemover.setIcon(removeIcon);
        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickRemoveTasks(evt);
            }
        });
        panelButtons.add(buttonRemover);

        IconFontSwing.register(FontAwesome.getIconFont());
        Icon saveIcon = IconFontSwing.buildIcon(FontAwesome.FLOPPY_O, 20);
        buttonSalvar.setIcon(saveIcon);
        buttonSalvar.setText("Salvar Alaterações");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickSaveTasks(evt);
            }
        });
        panelButtons.add(buttonSalvar);

        getContentPane().add(panelButtons);

        menuTodosapp.setText("todosApp");

        todosappItemMudarUsuario.setIcon(siginOutIcon);
        todosappItemMudarUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        todosappItemMudarUsuario.setText("Sair");
        todosappItemMudarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickLogout(evt);
            }
        });
        menuTodosapp.add(todosappItemMudarUsuario);

        todosappItemFechar.setIcon(exitIcon);
        todosappItemFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        todosappItemFechar.setText("Fechar");
        todosappItemFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickCloseApp(evt);
            }
        });
        menuTodosapp.add(todosappItemFechar);

        MenuPrincipal.add(menuTodosapp);

        userItemMudarSenha.setIcon(lockIcon);
        userItemMudarSenha.setText("Mudar senha");
        userItemMudarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickChangeMyPassword(evt);
            }
        });
        menuUsuario.add(userItemMudarSenha);

        userItemApagarConta.setIcon(trashIcon);
        userItemApagarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickDeleteMyAccount(evt);
            }
        });
        menuUsuario.add(userItemApagarConta);

        MenuPrincipal.add(menuUsuario);

        setJMenuBar(MenuPrincipal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onClickCloseApp(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickCloseApp
        handleCloseApp();
    }//GEN-LAST:event_onClickCloseApp

    private void onClickLogout(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickLogout
        handleNavigateToLogin();
    }//GEN-LAST:event_onClickLogout

    private void onClickRemoveTasks(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickRemoveTasks
        handleRemoveTasks();
    }//GEN-LAST:event_onClickRemoveTasks

    private void onClickNewTask(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickNewTask
        handlenavigateToCreateNewTask();
    }//GEN-LAST:event_onClickNewTask

    private void onClickSaveTasks(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickSaveTasks
        handleSaveTasks();
    }//GEN-LAST:event_onClickSaveTasks

    private void onClickChangeMyPassword(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickChangeMyPassword
        handleChangePassword();
    }//GEN-LAST:event_onClickChangeMyPassword

    private void onClickDeleteMyAccount(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onClickDeleteMyAccount
        handleDeleteUser();
    }//GEN-LAST:event_onClickDeleteMyAccount
           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JButton buttonNovaTarefa;
    private javax.swing.JButton buttonRemover;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JMenu menuTodosapp;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JScrollPane scroller;
    private javax.swing.JTable table;
    private javax.swing.JMenuItem todosappItemFechar;
    private javax.swing.JMenuItem todosappItemMudarUsuario;
    private javax.swing.JMenuItem userItemApagarConta;
    private javax.swing.JMenuItem userItemMudarSenha;
    // End of variables declaration//GEN-END:variables
}
