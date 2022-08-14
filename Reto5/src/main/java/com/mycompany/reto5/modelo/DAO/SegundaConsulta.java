
package com.mycompany.reto5.modelo.DAO;

import com.mycompany.reto5.modelo.VO.Lider;
import com.mycompany.reto5.modelo.VO.Proyecto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class SegundaConsulta {
    
    public void segundaconsulta(DefaultTableModel modelo) {
        
    Proyecto proyecto = new Proyecto();
    
    
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectar();
            
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto WHERE Clasificacion='Casa Campestre' AND Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla')");
            
            while (rs.next()){
                proyecto.setId_proyecto(rs.getInt(1));
                proyecto.setConstructora(rs.getString(2));
                proyecto.setNumero_habitaciones(rs.getInt(3));
                proyecto.setCiudad(rs.getString(4));
                
                modelo.addRow(new Object[]{proyecto.getId_proyecto(), proyecto.getConstructora(), proyecto.getNumero_habitaciones(), proyecto.getCiudad()});
            }
            
            rs.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SegundaConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
     }

        
       


    
    

