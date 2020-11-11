package ventas_camacho;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author K02-33
 */
public class OperacionesCliente {
    
   conectarBD conexion = new conectarBD();
   
   //Metodo para insercion de registros de clientes
   
   public void insertarCliente(String nombre, String RFC, String direccion, int CP, String ciudad, int edad, char sexo){
       int filasAfectadas = 0;
       
       try{
           Connection conex = conexion.ConexionSQL();
           Statement stmt = conex.createStatement();
           String SQL = "insert into clientes (Nombre, RFC, Direccion, CP "
           + "Ciudad, Edad, Sexo) values"
           + "('"+nombre+"', '"+ciudad+"', '"+edad+"', '"+sexo+"')";
           filasAfectadas = stmt.executeUpdate(SQL);
           JOptionPane.showMessageDialog(null, "Se inserto" + filasAfectadas+
                   "registros", "resultado", JOptionPane.INFORMATION_MESSAGE);
           
       }/*fin try*/ catch(Exception err){
           JOptionPane.showMessageDialog(null, "Error SQL"+err.toString(), "Error", JOptionPane.ERROR_MESSAGE);
       }//fin catch
   }//fin metodo insertar cliente
    
    //Metodo para buscar clientes:
   
   public ResultSet BuscarCliente(int idCliente){
       
       ResultSet registros = null;
       
       try{
           Connection conex = conexion.ConexionSQL();
           Statement stmt = conex.createStatement();
           registros = stmt.executeQuery("select idCliente, Nombre, RFC, Direccion,"
           + "CP, Ciudad, Edad, Sexo, from clientes where idClientes"
           + "= " + idCliente + "");
           
           }/*fin try*/ catch (Exception err){
               JOptionPane.showMessageDialog(null, "Error SQL" + err.toString());
           }//fin catch
       return registros;
   }// fin metodo buscar clientes
   
   // Metodo para eliminar un cliente
   
   public void EliminarCliente(int idCliente){
       int filasAfectadas = 0;
       try{
           Connection conex = conexion.ConexionSQL();
           Statement stmt = conex.createStatement();
           String SQL = "delete from cliente where idCliente = "+idCliente+"";
           filasAfectadas = stmt.executeUpdate(SQL);
           JOptionPane.showMessageDialog(null, "Se elimino/eliminaron"+filasAfectadas+" registro/registros", "Resultado",
                   JOptionPane.INFORMATION_MESSAGE);
           
       }/*fin try*/ catch(Exception err){
           JOptionPane.showMessageDialog(null, "Error SQL" + err.toString(),
                   "Error", JOptionPane.ERROR_MESSAGE);
       }//fin catch
   }//fin metodo eliminar
   
   //Metodo para actualizar un cliente
   
   public void ActualizarCliente(int idCliente,String nombre, String RFC,
           String direccion, int CP, String ciudad, int edad, char sexo){
       int filasAfectadas = 0;
       try{
           Connection conex = conexion.ConexionSQL();
           Statement stmt = conex.createStatement();
           String SQL= "update clientes set Nombre'" + nombre +
                   "', RFC='" + RFC + "', Direccion='" + direccion
                   + "', CP='" + CP + "', Ciudad='" + ciudad
                   + "', Edad='" + edad +", Sexo='" + sexo + "'"
                   + " Where idCliente = " + idCliente + "";
           filasAfectadas= stmt.executeUpdate(SQL);
           JOptionPane.showMessageDialog(null,"Se actualizo "+filasAfectadas+
                   "Registros", "Resultado", JOptionPane.INFORMATION_MESSAGE);
       }/*fin try*/ catch(Exception err){
           JOptionPane.showMessageDialog(null, "Error SQL"+err.toString(),
                   "Error", JOptionPane.ERROR_MESSAGE);
       }//fin catch
   }//fin metodo actualizar cliente
}
