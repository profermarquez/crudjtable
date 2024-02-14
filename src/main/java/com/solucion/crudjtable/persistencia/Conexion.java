/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solucion.crudjtable.persistencia;

import java.io.IOException;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian
 */
public class Conexion {
	private static EntityManagerFactory emf =null;
         
	public static EntityManager createEntityManager() throws IOException {
                
     
	
		try {if(emf ==null) {
			
			emf=Persistence.createEntityManagerFactory("estudiante");
			System.out.println("conectado!");
                        Logger log = Logger.getLogger("Logger de Ejemplo");
		}
			
		}
		catch(Exception e) {System.out.println("Error en la conexion.... "+e);}
		
		
		return emf.createEntityManager();
	}
	
}
