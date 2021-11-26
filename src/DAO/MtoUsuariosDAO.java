
package DAO;

import Controlador.ConexionBd;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC 4
 */
public class MtoUsuariosDAO {
    public boolean mostrartabla(JTable tablamodelo,String valor) throws SQLException{
      boolean respuesta = false;
      String sql ="";
      DefaultTableModel modelo =new DefaultTableModel();
      modelo.addColumn("Usuario");
      modelo.addColumn("Contraseña Usuario");
      tablamodelo.setModel(modelo);
      String []datos = new String[2];
      Connection con =null;
      
      con = ConexionBd.conectarBD();
      
      if (valor.equals("")){
          sql = "Select usuario,contraseña from tblusuarios";
      }
      
      else {
          
          sql = "Select usuario,contraseña from t";
      
      }
      
      return respuesta;
}
}
