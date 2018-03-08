package es.jcyl.abcd.efgh.persistencia.proyecciones;

import org.springframework.data.rest.core.config.Projection;

import es.jcyl.abcd.efgh.persistencia.entidades.Direccion;
import es.jcyl.abcd.efgh.persistencia.entidades.Edificio;

@Projection (name="edicion", types= {Edificio.class, Direccion.class})
public interface EdificioEdicionProyeccion {
	
	public Integer getEdificioId();
	public String getNombre();
	public Direccion getDireccion();
	
	

}
