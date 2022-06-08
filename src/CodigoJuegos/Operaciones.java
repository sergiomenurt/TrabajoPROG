/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoJuegos;

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

    private static Connection instance;
    
    
    //creamos la conexion
    static Connection cn =null;
    
    //creamos la clase conexion
    public static Connection Enlace() throws SQLException{
        
        //ruta de la base de datos la cual crearemos
        String ruta = "C:\\Users\\sergi\\OneDrive\\Escritorio\\basesergio.db";
        
        try{
            cn = DriverManager.getConnection(ruta);
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, e);
        }
        return cn;
    }

    public static Connection getInstance(){
        //solo hago el new si es null
        if(instance == null)
            instance = new Connection();
        //devuelvo siempre la única instancia
        return instance;
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
            String query = "select * from Puntuaciones";
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
    public void AgregarDatos(String Juego, String Nombre,int Puntuaciones){
        
        //dentro de try catch por si los errores
        
        try{
            Connection cn = Enlace();
            Statement s=cn.createStatement();
            String query = "INSERT INTO Puntuaciones(Juego,Nombre,Puntuaciones)values ('"+Juego+"''"+Nombre+"',"+Puntuaciones+")";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "AGREGADO");
            
        }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
       
        }
        
        
    }
    
}

