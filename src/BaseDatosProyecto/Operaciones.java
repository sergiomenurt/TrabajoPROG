/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatosProyecto;

/**
 *
 * @author sergi
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Operaciones {
    
    
    //creamos la coneccion
    static Connection cn =null;
    
    //creamos la clase conexion
    public static Connection Enlace() throws SQLException{
        
        //ruta de la base de datos la cual crearemos
        String ruta = "jdbc:sqlite:C:\\Users\\34653\\OneDrive\\Escritorio\\sergio.db";
        
        try{
            cn = DriverManager.getConnection(ruta);
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e);
        }
        return cn;
    }
    
    //creamos las variables para la conexion
    
  
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo=new DefaultTableModel();
    
    //creamos la operacion para mostrar datos en el jform
    public DefaultTableModel lista(){
        
        try{
            
            cn = Enlace();
            
            Statement s=cn.createStatement();
            
            //consulta a mostrar
            String query = "select * from producto";
            rs = s.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            //contenemos numero de columnas
            int CanColumns = rsmd.getColumnCount();
            
            //comprobamos
            for(int i=1;i<=CanColumns;i++){
                
                //cargamos columnas en modelo
                
                modelo.addColumn(rsmd.getColumnLabel(i));
                
            }
            while(rs.next()){
                
                //Creamos array
                
                Object[] fila=new Object[CanColumns];
                
                //cargamos datos a modelo
                for(int i=0;i<CanColumns;i++){
                    
                    fila[i]  =rs.getObject(i+1);
                }
                modelo.addRow(fila);
                
            }
            
        }catch(Exception e){}
            
            //retornamos modelo para jtable

            return modelo;
        
        
    }
    
    //creamos metodo para insertar datos
    public void AgregarDatos(String id, String nombre,String precio){
        
        //dentro de try catch por si los errores
        
        try{
            cn = Enlace();
            Statement s=cn.createStatement();
            String query = "INSERT INTO producto(id,nombre,precio)values ('"+id+"','"+nombre+"',"+precio+")";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "AGREGADO");
            
        }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
       
        }
        
        //creamos metodo para eliminar datos
       
        
    }
    
     
        public void EliminarConsulta(String id){
            
            try{
                cn = Enlace();
                Statement s = cn.createStatement();
                String query = "DELETE FROM producto WHERE id='"+id+"'";
                s.executeUpdate(query);
                s.close();
                cn.close();
                JOptionPane.showMessageDialog(null, "ELIMINADO");
                
                
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
            
        }
        
        //creamos metodo para modificar datos
        
        public void ModificarConsulta(String nombre,String precio,String id){
            
            try{
                cn = Enlace();
                Statement s = cn.createStatement();
                String query = "UPDATE producto SET nombre='"+nombre+"', precio="+precio+"WHERE id ="+id+"";
                s.executeUpdate(query);
                s.close();
                cn.close();
                
                JOptionPane.showMessageDialog(null, "MODIFICADO");
                
            }catch(Exception e){JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
}

