package es.jcyl.abcd.efgh.persistencia.proyecciones;

import org.springframework.data.rest.core.config.Projection;

import es.jcyl.abcd.efgh.persistencia.entidades.DireccionEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;

@Projection (name="edicion", types= {EdificioEntidad.class, DireccionEntidad.class})
public interface EdificioEdicionProyeccion {
	
	public Integer getEdificioId();
	public String getNombre();
	public DireccionEntidad getDireccion();
	
	

}
