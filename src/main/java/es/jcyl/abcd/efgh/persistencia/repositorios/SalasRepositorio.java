package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.SalaEntidad;

@Repository
public interface SalasRepositorio extends JpaRepository <SalaEntidad, Integer> {

	//TODO: buscar salas por nombre del edificio 
	public List<SalaEntidad> findByEdificioNombreContainsIgnoreCase (@Param ("nombre") String nombre);
	
	//TODO: buscar salar por capacidad
	public List<SalaEntidad> findByCapacidad ( @Param ("capacidad") Integer capacidad);
	
	//TODO: buscar salas con una capacidad entre 2 valores
	public List<SalaEntidad> findByCapacidadBetween ( int min, int max);
	
	//TODO: buscar salas por tipo de sala
	public List<SalaEntidad> findByTipoSalaTipoContainsIgnoreCase (@Param ("tipo") String tipo);

} 
