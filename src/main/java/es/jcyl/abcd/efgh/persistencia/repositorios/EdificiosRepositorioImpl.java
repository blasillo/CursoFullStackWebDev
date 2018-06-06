package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.*;
import javax.persistence.metamodel.SingularAttribute;

import es.jcyl.abcd.efgh.persistencia.entidades.*;

public class EdificiosRepositorioImpl implements PersonalizadoEdificiosRepositorio {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	

	@Override
	public List<EdificioEntidad> buscarEdificiosSinSalas() {
		
		/*
		Metamodel model = entityManager.getMetamodel();
		Set<EntityType<?>> entidades = model.getEntities();
		for ( EntityType entidad : entidades ) {
			
			System.out.println( entidad.getName() );
			
			Set<Attribute> atributos = entidad.getAttributes();
			
			for (Attribute atributo : atributos ) {
				System.out.println( atributo.getName() + " : " + atributo.getJavaType().getTypeName() + " [" + atributo.isAssociation() + "]" );
			}
				
		}
		
		*/
		
		
		/*
		   select e.*
             from edificios e
            where not (exists (select s.sala_id from salas s where s.edificio_id=e.edificio_id))
		 */
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<EdificioEntidad> consulta = builder.createQuery( EdificioEntidad.class );
		
		Root<EdificioEntidad> fromEdificio = consulta.from( EdificioEntidad.class );
		
		consulta.select( fromEdificio );
		
		Subquery<SalaEntidad> subconsulta = consulta.subquery( SalaEntidad.class );
		Root<SalaEntidad> fromSalas = subconsulta.from( SalaEntidad.class );
		subconsulta.select( fromSalas );
		
		Predicate p = builder.equal( fromSalas.get("edificio"), fromEdificio );
		subconsulta.where(p);
		consulta.where( builder.exists(subconsulta).not());
		
				
        TypedQuery<EdificioEntidad> typedQuery = entityManager.createQuery( consulta );
		List<EdificioEntidad> results = typedQuery.getResultList();
		
		return results;
		
	}

}
