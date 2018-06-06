package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.Date;
import java.util.List;

import es.jcyl.abcd.efgh.persistencia.entidades.SalaEntidad;

public interface PersonalizadoSalasRepositorio {
	
	public List<SalaEntidad> buscarDisponiblesPorFecha(Date fecha);

}
