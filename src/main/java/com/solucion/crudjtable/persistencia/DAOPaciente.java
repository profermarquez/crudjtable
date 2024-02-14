/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.solucion.crudjtable.persistencia;

import com.solucion.crudjtable.Modelo.Paciente;
import java.awt.List;
import java.io.IOException;
import javax.persistence.EntityManager;

/**
 *
 * @author Sebastian
 */

//interface DAOPaciente{}
public class DAOPaciente {

    EntityManager em = null;

    public String createPaciente(String nombre,String apellido,String dire, String email) {
                //if()
        Paciente usuario =new Paciente(nombre,apellido,dire,email);
        
		try {
			em =Conexion.createEntityManager();
			//if(em == null){System.out.println("Error..");return;}
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			System.out.println("Paciente guardado");
		}
		catch(IOException e) {System.out.println(e);}
		finally {
			if(em!=null ) {
				
				em.close();
			}
		}
                return "Pacientecreado!";
    }
    
    public String eliminarPaciente(int id){
        Paciente usuario =new Paciente();
        
		try {
			em =Conexion.createEntityManager();
			
			em.getTransaction().begin();
                        
                        usuario =em.find(Paciente.class, id);
                        if(usuario != null ){em.remove(usuario);}else{return "Usuario no encontrado";}
			em.getTransaction().commit();
			
		}
		catch(Exception e) {System.out.println(e);}
		finally {
			if(em!=null ) {
				
				em.close();
			}
		}
                return "Paciente eliminado!";
    }
    
    public java.util.List<Paciente> getPacientes(){
        java.util.List<Paciente> listEmployee=null;
        try {
			em =Conexion.createEntityManager();
			//if(em == null){System.out.println("Error..");return;}
			em.getTransaction().begin();
                    listEmployee = 
                    em.createNativeQuery("SELECT id,nombre,direccio,apellido,email FROM paciente", Paciente.class).getResultList();
			em.getTransaction().commit();
			//System.out.println("Listado de usuarios");
		}
		catch(Exception e) {System.out.println(e);}
		finally {
			if(em!=null ) {
				
				em.close();
			}
		}
                return listEmployee;
        
    }
    
    public String modificarPaciente(int id,String nombre,String apellido,String dire, String email)
    {
        Paciente usuario =new Paciente( nombre, apellido,dire, email);
        
		try {
			em =Conexion.createEntityManager();
			
			em.getTransaction().begin();
                        String sql= "UPDATE paciente SET nombre = '"+ nombre+"', apellido = '"+apellido+"', direccio='"+dire+"', email = '"+email+"' WHERE id = "+String.valueOf(id);
                        System.out.println(sql);
                        int countUpdated = em.createNativeQuery(sql).executeUpdate();
                        if(countUpdated!=1){return "Error";} /// si es correcto da uno
                        //System.out.println(countUpdated);
			em.getTransaction().commit();
		}
		catch(Exception e) {System.out.println(e);}
		finally {
			if(em!=null ) {
				
				em.close();
			}
		}
                return "Paciente modificado!";
    }

}
