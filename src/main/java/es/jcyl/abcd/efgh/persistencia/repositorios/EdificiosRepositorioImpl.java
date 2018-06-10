package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.SalaEntidad;

public class EdificiosRepositorioImpl implements PersonalizadoEdificiosRepositorio {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<EdificioEntidad> buscarPorNombre(String nombre) {
		/*
 		select e.*
          from edificios e 
         where upper(e.nombre) like '%' || upper(':nombre') || '%';
		 */
		
		// 1. Usar CriteriaBuilder para crear un CriteriaQuery que retorne la entidad esperada
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EdificioEntidad> edificios = builder.createQuery( EdificioEntidad.class );
		
		// 2. Definir roots para las entidades involucradas en la consulta
		Root<EdificioEntidad> edificioRoot = edificios.from ( EdificioEntidad.class );
		
		// 3. Definir condiciones (predicados) usando CriteriaBuilder
		
		// TODO
		Predicate condicion = null;
		
		// 4. Anadir las condiciones a la consulta
		edificios.where( condicion ).select( edificioRoot );
		
		// 5. Construir la TypedQuery usando el entityManager y la consulta
		TypedQuery<EdificioEntidad> typedQuery = entityManager.createQuery( edificios );
		
		return typedQuery.getResultList();
	}
	

	@Override
	public List<EdificioEntidad> buscarEdificiosSinSalas() {	
		
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



	@Override
	public List<EdificioEntidad> buscarEdificiosConSalasYConCapacidad(Integer minCapacidad) {
		
		/*
		   select e.*
             from edificios e left join salas s on s.edificio_id = e.edificio_id
            where s.capacidad >=:capacidad
		 */
		
		// 1. Usar CriteriaBuilder para crear un CriteriaQuery que retorne la entidad esperada

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EdificioEntidad> consulta = builder.createQuery( EdificioEntidad.class );
		
		// 2. Definir roots para las entidades involucradas en la consulta
		Root<EdificioEntidad> edificioRoot = consulta.from ( EdificioEntidad.class );
		Root<SalaEntidad> salaRoot = consulta.from ( SalaEntidad.class );
		
		
		//Join<EdificioEntidad, SalaEntidad> join = edificioRoot.join( "edificioId", JoinType.LEFT);
		
		consulta.select( edificioRoot );
		
		
		// 3. Definir condiciones (predicados) usando CriteriaBuilder
		
		Predicate p1 = builder.equal( edificioRoot.get("edificioId") , salaRoot.get("edificio"));
		
		Predicate p2 = builder.greaterThanOrEqualTo( salaRoot.get("capacidad"), minCapacidad);
		
		// 4. Anadir las condiciones a la consulta
		consulta.where( builder.and (p2,p1) );
		
		// 5. Construir la TypedQuery usando el entityManager y la consulta
        TypedQuery<EdificioEntidad> typedQuery = entityManager.createQuery( consulta );
		
		return typedQuery.getResultList();
	}

	
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


	// 1. Usar CriteriaBuilder para crear un CriteriaQuery que retorne la entidad esperada
	
	// 2. Definir roots para las entidades involucradas en la consulta
	
	// 3. Definir condiciones (predicados) usando CriteriaBuilder
	
	// 4. Anadir las condiciones a la consulta
	
	// 5. Construir la TypedQuery usando el entityManager y la consulta

}
