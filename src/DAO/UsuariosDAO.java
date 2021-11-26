
package DAO;

import Controlador.ConexionBd;
import VO.UsuariosVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC 4
 */
public class UsuariosDAO {
    
    //Ingresar datos a la tabla//
    
    public void registrarDato(UsuariosVO VO){
        String sql="";
        sql=" Insert Into tblusuarios (usuario,contraseña) values (?,?)";
        try {
            
            Connection con = null;
            con = ConexionBd.conectarBD();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, VO.getUsuario());
            pst.setString(2, VO.getContraseña());
            
            int nr = pst.executeUpdate();
            ConexionBd.desconectarBD();
            if(nr<0) {
                JOptionPane.showMessageDialog(null, "El registro no se pudo guardar");
            }
            else {
                
            }} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR"+ ex.getMessage());
        }
       
       
    }
    
    
    
    
    public boolean mostrartabla(JTable tablamodelo,String valor){
        
            boolean respuesta = false;
            String sql ="";
            DefaultTableModel modelo =new DefaultTableModel();
            modelo.addColumn("Usuario");
            modelo.addColumn("Contraseña");
            tablamodelo.setModel(modelo);
            String []datos = new String[2];
            try {
            Connection con =null;
            
            con = ConexionBd.conectarBD();
            
            if (valor.equals("")){
                sql = "Select usuario,contraseña from tblusuarios order by usuario";
            }
            
            else {
                
                sql = "Select usuario,contraseña from tblusuarios = '"+valor+ "'";
                
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next())
            {
                
                datos[0]= rs.getString("usuario");
                datos[1]= rs.getString("contraseña");
                modelo.addRow(datos);
                
            }
            tablamodelo.setModel(modelo);
            
            return respuesta;
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERROR"+ ex);
                respuesta =false;
        }
        return false;

}
    public void ActualizarDatos (UsuariosVO VO){
       
        String sql="";
        sql = "UPDATE tblusuarios set contraseña=? where usuario =?";
        
        try {
           
            Connection con = null;
            con = ConexionBd.conectarBD();       
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, VO.getContraseña());
            pst.setString(2, VO.getUsuario());
            int nr = pst.executeUpdate();
            if (nr < 0){
                JOptionPane.showMessageDialog(null, "El usuario no se pudo actualizar");
            }
            else {
                JOptionPane.showMessageDialog(null, "El registro se actualizo correcatamente");
            }
            ConexionBd.desconectarBD();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema y no se pudo actualizar"+ex.getMessage());
        }
          
    }
    
    public void EliminarUsuarios (UsuariosVO VO) {
     String sql = "";
     sql = "Delete from tblusuarios where usuario =?";
     Connection con = null;
        try {
            
            con = ConexionBd.conectarBD();
            int respuesta = JOptionPane.showConfirmDialog(null, "Está seguro de retirar el registro? S/N");
            if  ( respuesta == 0)
            {
                try {
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, VO.getUsuario());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "El registro fue retirado correctamente");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al retirar el registro"+ex.getMessage());
                }
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    
}

