package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.TipoVia;

@Repository
public interface EdificiosRepositorio extends JpaRepository <EdificioEntidad, Integer>, PersonalizadoEdificiosRepositorio {
	
	
	//TODO: buscar los edificios por tipo de via y por nombre de via
	public List<EdificioEntidad> findByDireccionTipoViaAndDireccionNombreViaContainsIgnoreCase ( @Param ("tipoVia") TipoVia tipoVia , @Param ("direccion")String direccion);
	
	
	//TODO: buscar los edificios de una provincia
	@Query ("select edif "
			+ "from EdificioEntidad edif "
			+ "left join edif.direccion.poblacion pob left join pob.provincia prov "
			+ "where upper(prov.provincia) like concat ('%',concat(upper(:prov),'%'))")
	public List<EdificioEntidad> buscarPorProvincia ( @Param ("prov") String prov );
	
	//TODO: bucar los edificios por nombre del edificio
	public List<EdificioEntidad> findByNombreContainsIgnoreCase (@Param ("nombre") String nombre); 
	
}
