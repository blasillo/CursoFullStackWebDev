package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.jcyl.abcd.efgh.persistencia.entidades.*;

public class ReservasRepositorioImpl implements PersonalizadoReservasRepositorio {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public List<SalaEntidad> buscarDisponiblesPorFecha(Date fecha) {
		// 1. Usar CriteriaBuilder para crear un CriteriaQuery que retorne la entidad esperada
		
		// 2. Definir roots para las entidades involucradas en la consulta
		
		// 3. Definir condiciones (predicados) usando CriteriaBuilder
		
		// 4. Anadir las condiciones a la consulta
		
		// 5. Construir la TypedQuery usando el entityManager y la consulta
		
		
		return null;
	}
	
	

}
