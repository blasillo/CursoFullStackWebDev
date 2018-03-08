package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.Sala;

@Repository
@RepositoryRestResource (path="/salas")
public interface SalasRepositorio extends JpaRepository <Sala, Integer> {
	
	
    
	public List<Sala> buscarPorCapacidad ( @Param ("capacidad") int capacidad);

} 
