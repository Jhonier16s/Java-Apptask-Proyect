/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Controlador.ConexionBd;
import DAO.UsuariosDAO;
import VO.UsuariosVO;
import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC 4
 */
public class FrmUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form FrmUsuarios
     */
    public FrmUsuarios() {
        initComponents();
        this.setTitle("Registro de Usuarios");
        this.setLocationRelativeTo(null);
        proteger();
       
        //INSTANCIAR//
        UsuariosDAO DAO = new UsuariosDAO();
        UsuariosVO VO = new UsuariosVO();
        DAO.mostrartabla(tablausuarios, "");
        
        ConexionBd cc = new ConexionBd ();
        try {
            Connection cn = cc.conectarBD();
        } catch (SQLException ex) {
            Logger.getLogger(FrmUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public String transaccion = "";
    
    
    private void proteger(){
        txtusuario.setEnabled(false);
        txtcontraseña.setEnabled(false);
        txtusuario.setText("Hola :D");
        txtcontraseña.setText("Hola :D");
        
        
 
    }
    private void desproteger(){
        txtusuario.setEnabled(true);
        txtcontraseña.setEnabled(true);
        
        
    }
    private void limpiar (){
        txtusuario.setText("");
        txtcontraseña.setText("");
        
    }
    
    private void modificardatos() {
    
    UsuariosDAO DAO = new UsuariosDAO();
    UsuariosVO VO = new UsuariosVO();
    VO.setUsuario(txtcontraseña.getText());
    VO.setUsuario(txtusuario.getText());
    DAO.ActualizarDatos(VO);
    DAO.mostrartabla(tablausuarios, "");
    mostrarcampos (0);
    
    }
    
    
    public void Agregarusuario() {
        
        String SQL=" Insert into tblusuarios (usuario,contraseña) values (?,?) ";
    
        try {
            
            PreparedStatement pst = ConexionBd.conectarBD().prepareStatement(SQL);
            
            pst.setString(1, txtusuario.getText());
            
            pst.setString(2, txtcontraseña.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro."+e.getMessage());
        }
        
        
    
    }
    
      
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btningresar = new javax.swing.JButton();
        btngrabar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btnretirar = new javax.swing.JButton();
        btnsalir1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnsalir2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablausuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btningresar.setBackground(new java.awt.Color(204, 255, 255));
        btningresar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btningresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ingresar2.png"))); // NOI18N
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        jPanel3.add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 50, 60));

        btngrabar.setBackground(new java.awt.Color(204, 255, 255));
        btngrabar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btngrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar.png"))); // NOI18N
        btngrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrabarActionPerformed(evt);
            }
        });
        btngrabar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btngrabarKeyPressed(evt);
            }
        });
        jPanel3.add(btngrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 50, 60));

        btneditar.setBackground(new java.awt.Color(204, 255, 255));
        btneditar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Editaryeah.png"))); // NOI18N
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });
        jPanel3.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 50, 60));

        btnretirar.setBackground(new java.awt.Color(204, 255, 255));
        btnretirar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnretirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/retirar.png"))); // NOI18N
        btnretirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnretirarActionPerformed(evt);
            }
        });
        jPanel3.add(btnretirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 60, 50));

        btnsalir1.setBackground(new java.awt.Color(204, 255, 255));
        btnsalir1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnsalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Salir.png"))); // NOI18N
        btnsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnsalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 60, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 40, 40));

        jLabel11.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel11.setText("Volver al menú");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, 20));

        jLabel12.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ingresar");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 40));

        jLabel13.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel13.setText("Grabar");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 40, 20));

        jLabel14.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Editar");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 70, 20));

        jLabel16.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel16.setText("Eliminar");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, 20));

        jLabel17.setFont(new java.awt.Font("Candara", 1, 12)); // NOI18N
        jLabel17.setText("Volver al menú");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, 20));

        btnsalir2.setBackground(new java.awt.Color(204, 255, 255));
        btnsalir2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnsalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Salir.png"))); // NOI18N
        btnsalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnsalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 60, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 40, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 130));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Usuario");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UsuarioRojo.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 40, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contra.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 50, 80));

        txtusuario.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });
        jPanel4.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 130, 30));

        txtcontraseña.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });
        txtcontraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcontraseñaKeyPressed(evt);
            }
        });
        jPanel4.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 130, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Contraseña");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 520, 210));

        tablausuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablausuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablausuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablausuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 520, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        transaccion = "I";
        desproteger();
        txtusuario.requestFocus();
        limpiar();
        
    }//GEN-LAST:event_btningresarActionPerformed

    private void btnsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalir1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FrmMenu Mn = new FrmMenu();
        Mn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FrmMenu Mn = new FrmMenu();
        Mn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnsalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalir2ActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
     
                       
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtusuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyPressed
       char teclapresionada = evt.getKeyChar();
          if (teclapresionada == KeyEvent.VK_ENTER)
          {
              if (txtusuario.getText().length()==0)
              {
                  JOptionPane.showMessageDialog(null, "Sr. Usuario, esto no puede quedar vacio");
                  txtusuario.requestFocus();
              }
              else
              {
                  txtcontraseña.requestFocus();
              }
              
          }  
    }//GEN-LAST:event_txtusuarioKeyPressed

    private void txtcontraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraseñaKeyPressed
        char teclapresionada = evt.getKeyChar();
          if (teclapresionada == KeyEvent.VK_ENTER)
          {
              if (txtcontraseña.getText().length()==0)
              {
                  JOptionPane.showMessageDialog(null, "Sr. Usuario, esto no puede quedar vacio");
                  txtcontraseña.requestFocus();
              }
              else
              {
                  
              }
              
          } 
    }//GEN-LAST:event_txtcontraseñaKeyPressed
  
        
    
    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed
        
    }//GEN-LAST:event_txtcontraseñaActionPerformed

    private void btngrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrabarActionPerformed
         UsuariosDAO DAO = new UsuariosDAO();
        UsuariosVO VO = new UsuariosVO();
        VO.setUsuario(txtusuario.getText());
        VO.setContraseña(txtcontraseña.getText());
        
        if  (transaccion.equals("I")){
        
           Agregarusuario();
        }
        else if (transaccion.equals("E")){
            txtusuario.getText();
            DAO.ActualizarDatos(VO);
        }
        
       
        DAO.mostrartabla(tablausuarios, "");
        
        
    }//GEN-LAST:event_btngrabarActionPerformed

    private void btngrabarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btngrabarKeyPressed
         
    }//GEN-LAST:event_btngrabarKeyPressed

    private void tablausuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablausuariosMouseClicked
        
        int fila = tablausuarios.getSelectedRow();
        if (fila==-1){
            JOptionPane.showMessageDialog(null, "Usuario no seleccionado");
        }
        else{
            String usuario =(String)tablausuarios.getValueAt(fila,0); 
            String contraseña =(String)tablausuarios.getValueAt(fila,1); 
            txtusuario.setText(usuario);
            txtcontraseña.setText(contraseña);
               txtcontraseña.setEnabled(false);
               txtusuario.setEnabled(false);
        }
    }//GEN-LAST:event_tablausuariosMouseClicked

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
     transaccion = "E";
     desproteger();
     txtusuario.setEnabled(false);
     txtcontraseña.requestFocus();
     
    }//GEN-LAST:event_btneditarActionPerformed

    private void btnretirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnretirarActionPerformed
       transaccion = "R";
       UsuariosVO VO = new UsuariosVO();
       UsuariosDAO DAO = new UsuariosDAO();
       VO.setUsuario(txtusuario.getText());
       DAO.EliminarUsuarios(VO);
       DAO.mostrartabla(tablausuarios, "");
       // mostrarcampos(0);
        proteger();
    }//GEN-LAST:event_btnretirarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btngrabar;
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnretirar;
    private javax.swing.JButton btnsalir1;
    private javax.swing.JButton btnsalir2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablausuarios;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

    private void mostrarcampos(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
