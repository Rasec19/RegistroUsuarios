
package ventas_camacho;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Antonio Urbalejo
 */
public class conectarBD {
    public Connection ConexionSQL(){
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/ventas_Rasec?userTimezone=true&serverTimezone=UTC";
        String user="root";
        String password="12345";
        
        Connection conex=null;
        
        try{
            Class.forName(driver);
            conex= DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null,"Conexion exitosa","Aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null,"Error al conectarse "+err.toString());
        }catch(ClassNotFoundException err){
            JOptionPane.showMessageDialog(null,"Clase no encontrada"+err.toString());
        }
        return conex;
    }
}
