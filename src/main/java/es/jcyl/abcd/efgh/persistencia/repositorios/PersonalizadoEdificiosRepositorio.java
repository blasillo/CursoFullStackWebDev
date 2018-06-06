package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;

public interface PersonalizadoEdificiosRepositorio {
	
	 public List<EdificioEntidad> buscarPorNombre(String nombre);
	
     public List<EdificioEntidad> buscarEdificiosSinSalas (); 
     
     public List<EdificioEntidad> buscarEdificiosConSalasYConCapacidad (Integer minCapacidad);
     
}
