

package app;

import Controlador.ConexionBd;
import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonier
 */
public class Login extends javax.swing.JFrame {

    
    public Login() {
        initComponents();
        this.setTitle("Login");
        this.setLocationRelativeTo(null);
        limpiar();
        txtusuario.requestFocus();
        
    }

     private void limpiar() {
    
         txtusuario.setText("");
         txtcontraseña.setText("");
   
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnentrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        txtcontraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(156, 26, 28));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Acceso al Sistema");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 330, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Login.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 80));

        jPanel3.setBackground(new java.awt.Color(156, 26, 28));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Derechos reservados ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 50));

        jLabel2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Diseño y programación por Jhonier Stephan");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 400, 100));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnentrar.setBackground(new java.awt.Color(255, 255, 255));
        btnentrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ingresar.png"))); // NOI18N
        btnentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnentrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 130, 40));

        jLabel6.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Usuario");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 170, 50));

        txtusuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtusuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtusuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusuarioKeyPressed(evt);
            }
        });
        jPanel4.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 110, -1));

        jLabel7.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Contraseña");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 170, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/UsuarioRojo.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 40, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contra.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 40, 90));

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Salir.png"))); // NOI18N
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel4.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 60, 50));

        txtcontraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcontraseñaKeyPressed(evt);
            }
        });
        jPanel4.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 110, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 400, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
     
    private void acceso() throws SQLException
            
    {
         String usuario = txtusuario.getText();
         String contraseña = txtcontraseña.getText();
         String usuariosistema = "";
         String contraseñasistema = "";
         try {
             
         Connection con = null;
         con = ConexionBd.conectarBD();
         String sql = "SELECT usuario,contraseña FROM tblusuarios where usuario = '"+ usuario + "' and contraseña = '"+ contraseña +"'";
         
        // JOptionPane.showMessageDialog(null, "sql -->"+sql); // Mostrar el SQL del nombre y contraseña Ingresado.
        
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         while (rs.next()){
            usuariosistema = rs.getString("usuario");
            contraseñasistema = rs.getString("contraseña");
         }
         ConexionBd.desconectarBD();
         if (usuario.equals(usuariosistema) && contraseña.equals(contraseñasistema))
         {
            FrmMenu Mn = new FrmMenu();
            Mn.setVisible(true);
            this.dispose(); 
         }
         else 
         {
             JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta ");
         }
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "la consulta no se pudo realizar --> "+ex.getMessage());
         }
    }
    
    private void btnentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentrarActionPerformed
            
       if (txtusuario.getText().length()==0) {
           JOptionPane.showMessageDialog(null, "Por favor, ingresa tu 'Usuario' y 'Contraseña'");
       }         
       else
       {
           try {
               acceso();
           } catch (SQLException ex) {
               Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }//GEN-LAST:event_btnentrarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

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
                  JOptionPane.showMessageDialog(null, "Sr. Usuario, este campo no puede quedar vacio");
                  txtcontraseña.requestFocus();
              }
              else
              {
                  if (teclapresionada == KeyEvent.VK_ENTER)
                 {
                      try {
                            acceso();
                          } catch (SQLException ex) {
                          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                           }
              }
              }
             
          }      
    }//GEN-LAST:event_txtcontraseñaKeyPressed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnentrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
