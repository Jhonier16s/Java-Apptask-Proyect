
package Controlador;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexionBd {
    static String bd = "bdlogin";
    static String usuario = "root";
    static String clave = "12345678";
    static String url = "jdbc:mysql://localhost/"+bd;
    static Connection conexion = null;
    
    public static Connection conectarBD() throws SQLException {
        try {
            //cargar Driver//
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, clave);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el driver o problemas con la base"+ex.getMessage());
            
        }
        return conexion;
    }
    
    //Generar tabla de NotasApp//
    
    public static ResultSet getTabla (String consulta) throws SQLException{
        Connection cn = conectarBD();
        Statement st = null;
        ResultSet datos = null;
            
        try {
            st=cn.createStatement();
            datos=st.executeQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, ex);
            
        }
         return datos;     
    }

    public static void desconectarBD(){

        conexion=null;

    }
  
}
