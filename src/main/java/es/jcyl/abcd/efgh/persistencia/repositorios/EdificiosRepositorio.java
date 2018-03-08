package es.jcyl.abcd.efgh.persistencia.repositorios;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.jcyl.abcd.efgh.persistencia.entidades.*;

@Repository
@RepositoryRestResource (collectionResourceRel="edificios", path="edificios")
public interface EdificiosRepositorio extends JpaRepository <Edificio, Integer> {
	
	public List<Edificio> findByDireccionNombreViaContainsIgnoreCase (@Param ("direccion")String direccion);
	
	public List<Edificio> findByDireccionTipoVia ( @Param ("tipoVia") TipoVia tipoVia );
	
	
	@Query ("select edif "
			+ "from Edificio edif "
			+ "left join edif.direccion.poblacion pob left join pob.provincia prov "
			+ "where upper(prov.provincia) like concat ('%',concat(upper(:prov),'%'))")
	public List<Edificio> buscarPorProvincia ( @Param ("prov") String prov );
}
