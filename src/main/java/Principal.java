/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Sebastian
 */
import com.solucion.crudjtable.Interfaces.ManejadorVentanas;
import com.solucion.crudjtable.persistencia.DAOPaciente;


public class Principal {
   
    
    
    public static void main(String []arg){
        
        DAOPaciente dp1 = new DAOPaciente();
        ManejadorVentanas mv = new ManejadorVentanas(dp1);
    }
    
}
