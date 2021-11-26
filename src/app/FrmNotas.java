
 
package app;

import Controlador.ConexionBd;
import DAO.UsuariosDAO;
import VO.UsuariosVO;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.sql.ResulSet;
import javax.swing.JOptionPane;
import static sun.net.www.http.HttpClient.New;



public class FrmNotas extends javax.swing.JFrame {

   
    public FrmNotas() throws SQLException {
        initComponents();
        this.setTitle("Sistema de Tareas");
        this.setLocationRelativeTo(null);
        mostrar();
        txtid.setEnabled(false);
        int id; 
        txtcontenido.setEnabled(false);
        txtusuario.setEnabled(false);
        txtnombretarea.setEnabled(false);
       
//Proteger id para poder moodificar//
        
    }
    
    ConexionBd cc = new ConexionBd ();
    Connection cn = cc.conectarBD();
    
      
    //Mandar tareas para el MySQL//
    
    private void AgregarNotas() {

        String SQL = "insert into tblnotas (User,Nombre,Contenido) values (?,?,?)";

            try {
                PreparedStatement pst = ConexionBd.conectarBD().prepareStatement(SQL);
                  pst.setString(1, txtusuario.getText());
                  pst.setString(2, txtnombretarea.getText());
                  pst.setString(3, txtcontenido.getText());
                  
                  pst.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Tarea agregada con éxito...");
                  
                  //codigo para limpiar todo despues de agregar, y poner el focus en usuario//
                  txtcontenido.setText("");
                  txtid.setText("");
                  txtusuario.setText("");
                  txtnombretarea.setText("");
                  txtusuario.requestFocus();
                  
        } catch (Exception e)   {
            JOptionPane.showMessageDialog(null, "Error al agregar la Tarea "+e.getMessage());
        }

}
    
    
    //Mostrar tabla en el proyecto (desde mysql)//
     
    private void mostrar() throws SQLException{{
    
        DefaultTableModel modelo = new DefaultTableModel();
        ResultSet rs =  ConexionBd.getTabla("select ID,User,Nombre,Contenido from tblnotas"); //Seleccionar sql, los campos//
        modelo.setColumnIdentifiers(new Object []{"ID","Nombre"," Nombre de la tarea", " Contenido"}); //Crear el modelo (nombre de los campos en la tabla)//
        
        try {
            while (rs.next()){
                modelo.addRow(new Object[]{rs.getInt("ID"),rs.getString("User"), rs.getString("Nombre"), rs.getString("Contenido")}); //añadir los objetos de sql//
            }
            //asignar el modelo a la tabla//
            tabla.setModel(modelo);
            
            //linea de codigo para no ver la tercera colunma de la tabla. (colun(2) ancho (0)
            tabla.getColumnModel().getColumn(3).setMaxWidth(0);   //para contenido//
            tabla.getColumnModel().getColumn(0).setMaxWidth(50); //para el id//
            
                
        } catch (Exception e) {
            System.out.println(e);
        }
                
    }
    }
    
    //Eliminar tares//
    
        public void Eliminar(){
        
           int fila=tabla.getSelectedRow();
           String Id=tabla.getValueAt(fila, 0).toString();
           
            try {
                PreparedStatement Eliminar=ConexionBd.conectarBD().prepareStatement("Delete from tblnotas  where ID="+Id);
                Eliminar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Tarea eliminada correctamente");
                mostrar();
                //limpiar despues de liminar//
                txtcontenido.setText("");
                txtusuario.setText("");
                txtnombretarea.setText("");
                txtid.setText(" ");
            
            } catch (Exception e) {
            }
            
        }
    
        //modificar// 
    
        private void Modificar() {
                
            try {
                PreparedStatement Modificar=ConexionBd.conectarBD().prepareStatement("Update tblnotas set User='"+txtusuario.getText()+"',Nombre='"+txtnombretarea.getText()+"',Contenido='"+txtcontenido.getText()+"'where ID='"+txtid.getText()+"'");
                Modificar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Tarea modificada correctamente");
                mostrar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la tarea"+e.getMessage());
            }
 

    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtnombretarea = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtcontenido = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btneditar = new javax.swing.JLabel();
        btneliminar = new javax.swing.JLabel();
        btningresar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        oscuro = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TaskApp");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notas.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 70, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notas.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 90));

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnombretarea.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtnombretarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombretareaActionPerformed(evt);
            }
        });
        txtnombretarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombretareaKeyTyped(evt);
            }
        });
        jPanel3.add(txtnombretarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 180, 30));

        txtcontenido.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtcontenido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontenidoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtcontenido);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 530, 110));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 30, -1));

        txtusuario.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });
        jPanel3.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 180, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contenido de la tarea");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 180, 20));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(50);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 570, 120));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre de Usuario");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 180, 20));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 15), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save2.png"))); // NOI18N
        btnguardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarMouseClicked(evt);
            }
        });
        jPanel4.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 50, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Editar");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 130, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Eliminar");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 110, 30));

        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar (2).png"))); // NOI18N
        btneditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditarMouseClicked(evt);
            }
        });
        jPanel4.add(btneditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 50, 50));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trash.png"))); // NOI18N
        btneliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneliminarMouseClicked(evt);
            }
        });
        jPanel4.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 50, 70));

        btningresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ingresar3.png"))); // NOI18N
        btningresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btningresarMouseClicked(evt);
            }
        });
        jPanel4.add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 60, 90));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Guardar tarea");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 120, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ingresar");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 120, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 570, 120));
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        txtid.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jPanel3.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 40, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nombre de la tarea");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 180, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help 2.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 40, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home2.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 40, 50));

        oscuro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/night-mode.png"))); // NOI18N
        oscuro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oscuroMouseClicked(evt);
            }
        });
        jPanel3.add(oscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 40, 50));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sunny.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 50, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 630, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombretareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombretareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombretareaActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
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
                  txtnombretarea.requestFocus();
              }
              
          }
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtnombretareaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombretareaKeyTyped
       char teclapresionada = evt.getKeyChar();
          if (teclapresionada == KeyEvent.VK_ENTER)
          {
              if (txtnombretarea.getText().length()==0)
              {
                  JOptionPane.showMessageDialog(null, "Sr. Usuario, esto no puede quedar vacio");
                  txtnombretarea.requestFocus();
              }
              else
              {
                  txtcontenido.requestFocus();
              }
              
          }   
    }//GEN-LAST:event_txtnombretareaKeyTyped

    private void txtcontenidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontenidoKeyTyped
         char teclapresionada = evt.getKeyChar();
          if (teclapresionada == KeyEvent.VK_ENTER)
          {
              if (txtcontenido.getText().length()==0)
              {
                  JOptionPane.showMessageDialog(null, "Sr. Usuario, esto no puede quedar vacio");
                  txtcontenido.requestFocus();
              }
              else
              {
                 
              }
              
          }   
    }//GEN-LAST:event_txtcontenidoKeyTyped

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
            int fila = tabla.getSelectedRow();
        if (fila==-1){
            JOptionPane.showMessageDialog(null, "Usuario no seleccionado");
        }
        else{
            //Codigo para tocar la lista y que se vea en los txtfields//
            int id = Integer.parseInt((String)tabla.getValueAt(fila, 0).toString());
            String user =(String)tabla.getValueAt(fila,1); 
            String contraseña =(String)tabla.getValueAt(fila,2); 
            String contenido =(String)tabla.getValueAt(fila,3); 
            txtusuario.setText(user);
            txtnombretarea.setText(contraseña);
            txtcontenido.setText(contenido);
            txtid.setText(""+id);
            //codigo para bloquear//
               txtcontenido.setEnabled(true);
               txtusuario.setEnabled(true);
               txtnombretarea.setEnabled(true);
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void btnguardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarMouseClicked
        
        if (txtusuario.getText().length()==0 || txtcontenido.getText().length()==0 || txtnombretarea.getText().length()==0) //linea para que ninguna campo quede vacio//
        {
            JOptionPane.showMessageDialog(null, "Por favor ingrese los datos correspondientes");
            txtusuario.requestFocus();

        }
        else {AgregarNotas();

            try {
                mostrar();
            } catch (SQLException ex) {
                Logger.getLogger(FrmNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnguardarMouseClicked

    private void btneditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditarMouseClicked
         int fila = tabla.getSelectedRow();
          
        if (fila==-1){
            JOptionPane.showMessageDialog(null, "Por favor selecciona una tarea");
        }
        else{ Modificar();
        }
        
        txtcontenido.setEnabled(false);
        txtusuario.setEnabled(false);
        txtnombretarea.setEnabled(false);
      
    }//GEN-LAST:event_btneditarMouseClicked

    private void btneliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneliminarMouseClicked
        
        int fila = tabla.getSelectedRow();
        int respuesta = JOptionPane.showConfirmDialog(null, "Está seguro de retirar la tarea? S/N");
            if  ( respuesta == 0)
        if (fila==-1){
            JOptionPane.showMessageDialog(null, "Por favor selecciona una tarea");
        }
        else { Eliminar();}
    }//GEN-LAST:event_btneliminarMouseClicked

    private void btningresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btningresarMouseClicked
        txtusuario.requestFocus();
        txtcontenido.setEnabled(true);
        txtusuario.setEnabled(true);
        txtnombretarea.setEnabled(true);
        txtcontenido.setText("");
        txtusuario.setText("");
        txtnombretarea.setText("");
        txtid.setText(" ");
    }//GEN-LAST:event_btningresarMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
       FrmAyuda Mn = new FrmAyuda();
        Mn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        FrmMenu Mn = new FrmMenu();
        Mn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel14MouseClicked

    private void oscuroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oscuroMouseClicked
        jPanel3.setBackground(Color.black);
        jPanel4.setBackground(Color.decode("#1B1919"));
    }//GEN-LAST:event_oscuroMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
            jPanel3.setBackground(Color.decode("#990000"));
            jPanel4.setBackground(Color.black);
            
            
    }//GEN-LAST:event_jLabel15MouseClicked

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
            java.util.logging.Logger.getLogger(FrmNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmNotas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmNotas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btneditar;
    private javax.swing.JLabel btneliminar;
    private javax.swing.JLabel btnguardar;
    private javax.swing.JLabel btningresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel oscuro;
    private javax.swing.JTable tabla;
    private javax.swing.JTextPane txtcontenido;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombretarea;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
