package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import es.jcyl.abcd.efgh.persistencia.entidades.*;

public class SalasRepositorioImpl implements PersonalizadoSalasRepositorio {
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<SalaEntidad> buscarDisponiblesPorFechaYCapacidad (Date fecha , Integer minCapacidad ) {
		
		// select s.*
		//  from salas s
		//  where s.sala_id not in (select sala_id from reservas r where r.fec_reserva = ?0   )
		//    and s.capacidad > 10;
		
		
		// 1. Usar CriteriaBuilder para crear un CriteriaQuery que retorne la entidad esperada
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SalaEntidad> salas = builder.createQuery( SalaEntidad.class );
		
		// 2. Definir roots para las entidades involucradas en la consulta
		Root<SalaEntidad> salaRoot = salas.from ( SalaEntidad.class );
		
		// 3. Definir condiciones (predicados) usando CriteriaBuilder
		
		Subquery<ReservaEntidad> subconsulta = salas.subquery( ReservaEntidad.class );
		Root<ReservaEntidad> reservaRoot = subconsulta.from( ReservaEntidad.class );
		subconsulta.select( reservaRoot.get("sala") );
		subconsulta.where( builder.equal( reservaRoot.get("fechaReserva") , fecha) );
		
		
		// 4. Anadir las condiciones a la consulta
		
		Predicate p1 = salaRoot.get("salaId").in(subconsulta).not();
		
		// TODO
		Predicate p2 = null; 
		
		Predicate condicion = builder.and( p1, p2 );
		
		salas.where( p1  )
		     .select( salaRoot );
		
		// 5. Construir la TypedQuery usando el entityManager y la consulta
		
		TypedQuery<SalaEntidad> typedQuery = entityManager.createQuery( salas );
		List<SalaEntidad> results = typedQuery.getResultList();
		
		return results;
	}

}
