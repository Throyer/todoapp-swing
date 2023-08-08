/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifil.comp2028.todosapp.views;

import br.edu.unifil.comp2028.todosapp.dao.TarefaDAO;
import br.edu.unifil.comp2028.todosapp.entidades.Tarefa;
import br.edu.unifil.comp2028.todosapp.entidades.Usuario;

import java.awt.Color;
import java.awt.Image;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jiconfont.icons.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author Renato
 */
public class JFrameTarefas extends javax.swing.JFrame {

    /**
     * Creates new form frameTarefas
     *
     * @param usuario
     * @param img
     */
    public JFrameTarefas(Usuario usuario, Image img) {
        setIconImage(img);
        this.img = img;
        this.usuario = usuario;
        this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
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
        setTitle("Tarefas de "+usuario.getUsername().toUpperCase());
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "#", "Descrição", "Categorias", "Prazo", "Feita"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
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
        popularTabela();
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
                buttonNovaTarefaActionPerformed(evt);
            }
        });
        panelButtons.add(buttonNovaTarefa);

        IconFontSwing.register(FontAwesome.getIconFont());
        Icon removeIcon = IconFontSwing.buildIcon(FontAwesome.TRASH, 20);
        buttonRemover.setIcon(removeIcon);
        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverActionPerformed(evt);
            }
        });
        panelButtons.add(buttonRemover);

        IconFontSwing.register(FontAwesome.getIconFont());
        Icon saveIcon = IconFontSwing.buildIcon(FontAwesome.FLOPPY_O, 20);
        buttonSalvar.setIcon(saveIcon);
        buttonSalvar.setText("Salvar Alaterações");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });
        panelButtons.add(buttonSalvar);

        getContentPane().add(panelButtons);

        menuTodosapp.setText("todosApp");

        todosappItemMudarUsuario.setIcon(siginOutIcon);
        todosappItemMudarUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        todosappItemMudarUsuario.setText("Sair");
        todosappItemMudarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosappItemMudarUsuarioActionPerformed(evt);
            }
        });
        menuTodosapp.add(todosappItemMudarUsuario);

        todosappItemFechar.setIcon(exitIcon);
        todosappItemFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        todosappItemFechar.setText("Fechar");
        todosappItemFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todosappItemFecharActionPerformed(evt);
            }
        });
        menuTodosapp.add(todosappItemFechar);

        MenuPrincipal.add(menuTodosapp);

        menuUsuario.setText(usuario.getUsername());

        userItemMudarSenha.setIcon(lockIcon);
        userItemMudarSenha.setText("Mudar senha");
        userItemMudarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userItemMudarSenhaActionPerformed(evt);
            }
        });
        menuUsuario.add(userItemMudarSenha);

        userItemApagarConta.setIcon(trashIcon);
        userItemApagarConta.setText("Excluir "+usuario.getUsername());
        userItemApagarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userItemApagarContaActionPerformed(evt);
            }
        });
        menuUsuario.add(userItemApagarConta);

        MenuPrincipal.add(menuUsuario);

        setJMenuBar(MenuPrincipal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void todosappItemFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosappItemFecharActionPerformed
        // TODO add your handling code here:
        System.exit(FINALIZACAO_CONTROLADA);
    }//GEN-LAST:event_todosappItemFecharActionPerformed

    private void todosappItemMudarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todosappItemMudarUsuarioActionPerformed
        // TODO add your handling code here:
        JFrameLogin login = new JFrameLogin();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_todosappItemMudarUsuarioActionPerformed

    private void buttonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverActionPerformed
        // TODO add your handling code here:
        int[] linhas = table.getSelectedRows();
        if (linhas.length > 0) {
            if (linhas.length > 1) {
                int selectedOption = JOptionPane.showConfirmDialog(null,
                        "Deseja remover as tarefas selecionadas?",
                        "Alerta!",
                        JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION) {
                    removerTarefas(table);
                    JFrameTarefas tarefas = new JFrameTarefas(usuario, img);
                    tarefas.setVisible(true);
                    dispose();;
                }
            } else {
                int selectedOption = JOptionPane.showConfirmDialog(null,
                        "Deseja remover a tarefa selecionada?",
                        "Alerta!",
                        JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION) {
                    removerTarefas(table);
                    JFrameTarefas tarefas = new JFrameTarefas(usuario, img);
                    tarefas.setVisible(true);
                    dispose();;
                }
            }
        } else {
            JFrame frame = new JFrame();
            frame.setTitle("Alerta");
            frame.setIconImage(img);
            JOptionPane.showMessageDialog(frame, "Selecione ao menos uma tarefa");
        }
    }//GEN-LAST:event_buttonRemoverActionPerformed

    private void buttonNovaTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovaTarefaActionPerformed
        // TODO add your handling code here:
        JFrameAdicionarTrarefas addTarefa = new JFrameAdicionarTrarefas(usuario, img);

        addTarefa.setVisible(true);

        dispose();
    }//GEN-LAST:event_buttonNovaTarefaActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        // TODO add your handling code here:
        int selectedOption = JOptionPane.showConfirmDialog(
                null,
                "Deseja salvar alterações?",
                "Alerta!",
                JOptionPane.YES_NO_OPTION);

        if (selectedOption == JOptionPane.YES_OPTION) {
            atualizarTarefas(table);
            JFrame frame = new JFrame("Alerta");
            JOptionPane.showMessageDialog(frame, "Tarefas atualizadas.");
        }
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void userItemMudarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userItemMudarSenhaActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame("Alerta");
        int selectedOption = JOptionPane.showConfirmDialog(
                null,
                "Deseja mudar sua senha?",
                "Alerta!",
                JOptionPane.YES_NO_OPTION);

        if (selectedOption == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(frame, "Função em desenvolvimento");
        } else {
            JOptionPane.showMessageDialog(frame, "Função em desenvolvimento");
        }
    }//GEN-LAST:event_userItemMudarSenhaActionPerformed

    private void userItemApagarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userItemApagarContaActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame("Alerta");
        int selectedOption = JOptionPane.showConfirmDialog(
                null,
                "Deseja mesmo apagar seu usuario?\nAo clicar em SIM"
                + ", todas suas\n"
                + "Tarefas serão apagadas do Banco",
                "Alerta!",
                JOptionPane.YES_NO_OPTION);

        if (selectedOption == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(frame, "Função em desenvolvimento");
        } else {
            JOptionPane.showMessageDialog(frame, "Função em desenvolvimento");
        }
    }//GEN-LAST:event_userItemApagarContaActionPerformed

    private void atualizarTarefas(JTable table) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("todosappPU");

        TarefaDAO tarefaDAO = new TarefaDAO(emf);
        
        for (int i = 0; i < table.getRowCount(); i++) {

            int id = (int) table.getValueAt(i, 0);
            String descricao = (String) table.getValueAt(i, 2);
            //Categorias não implementado
            //Atualização do prazo não definida
            boolean status;
            status = (boolean) table.getValueAt(i, 5);
            
            Tarefa tarefa = tarefaDAO.findTarefa(id);
            
            tarefa.setDescricao(descricao);
            tarefa.setStatus(status);

            try {
                tarefaDAO.edit(tarefa);
            } catch (Exception ex) {
                Logger.getLogger(JFrameTarefas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        emf.close();
    }

    private void removerTarefas(JTable table) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("todosappPU");

        TarefaDAO tarefaDAO = new TarefaDAO(emf);

        int[] linhasArray;
        linhasArray = table.getSelectedRows();
        for (int i = 0; i < linhasArray.length; i++) {
            int linha = linhasArray[i];
            int id;
            id = (int) table.getValueAt(linha, 0);
            tarefaDAO.delete(tarefaDAO.findTarefa(id));
        }
        emf.close();
    }

    private void popularTabela() {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("todosappPU");
        TarefaDAO tarefaDAO = new TarefaDAO(emf);
        tarefas = tarefaDAO.findTarefaEntities();

        int numTarefas = 0;
        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            if (usuario.getId() == tarefa.getUsuarioId().getId()) {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String prazo = "Sem prazo definido";
                if (tarefa.getPrazo() != null) {
                    prazo = df.format(tarefa.getPrazo());
                }
                model.addRow(new Object[]{tarefa.getId(), numTarefas += 1, tarefa.getDescricao(), "Não implementado", prazo, tarefa.getStatus(), false});
            }

        }
    }

    private final Usuario usuario;
    private final int FINALIZACAO_CONTROLADA = 0;
    private List<Tarefa> tarefas;
    private static Image img;
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