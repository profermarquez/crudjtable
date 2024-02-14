/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solucion.crudjtable.Interfaces;

import com.solucion.crudjtable.persistencia.DAOPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Sebastian
 */
public class ManejadorVentanas {
   
    private Login login = new Login(this);
    DAOPaciente dp1;
    private CrudPaciente crudpaciente;

    public ManejadorVentanas(DAOPaciente dp) {
        
        this.dp1=dp;//inicializa el DAOPaciente
        crudpaciente= new CrudPaciente(dp);
        this.invocarVentanas();
        
    }

    private void invocarVentanas() {
        java.awt.EventQueue.invokeLater(crudpaciente::mostrar);
        
    }
    
    public void mostrarMenuPrincipal(){}
    
    
}
