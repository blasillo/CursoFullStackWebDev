package es.jcyl.abcd.efgh;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.jcyl.abcd.efgh.persistencia.entidades.*;
import es.jcyl.abcd.efgh.persistencia.repositorios.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration ( classes = FullstackwebdevApplication.class)
public class TestSalasRepositorio {
	
	@Autowired
	private SalasRepositorio repo;
	
	@Autowired
	private ReservasRepositorio reservasRepo;

	@Test
	public void testBusquedaPorNombreEdificio() {
		List<SalaEntidad> salas = repo.findByEdificioNombreContainsIgnoreCase ("eum 1");
		
		assertNotNull (salas);
		
		for (SalaEntidad sala: salas) {
			System.out.println(sala);
		}
		assertTrue (salas.size() > 0);
	}
	
	@Test
	public void testBusquedaPorCapacidadEntre() {
		List<SalaEntidad> salas = repo.findByCapacidadBetween(12, 100);
		
		assertNotNull (salas);
		
		for (SalaEntidad sala: salas) {
			System.out.println(sala);
		}
		assertTrue (salas.size() > 0);
	}
	
	@Test
	public void testBusquedaPorTipoSala() {
		List<SalaEntidad> salas = repo.findByTipoSalaTipoContainsIgnoreCase("audit");
		
		assertNotNull (salas);
		
		for (SalaEntidad sala: salas) {
			System.out.println(sala);
		}
		assertTrue (salas.size() > 0);
	}
	
	
	@Test
	public void testBusquedaPorCriteria() {
		
		Date fechaReserva = new Date();
		
		ReservaEntidad reserva = new ReservaEntidad();
		reserva.setFechaReserva( fechaReserva );
		reserva.setUsuario( "torgarbl" );
		reserva.setSala(  repo.getOne ( 1 )  );
		
		reservasRepo.save( reserva );
		
		
		List<SalaEntidad> salas = null;
		
		try {				
		   salas = repo.buscarDisponiblesPorFechaYCapacidad(fechaReserva, 11);
		}
		catch (Exception e) {}
		finally {
			reserva = reservasRepo.findFirstByFechaReservaIs(fechaReserva);		
			reservasRepo.delete( reserva );
		}
		
        
		
		
		
		assertNotNull (salas);
		
		for (SalaEntidad sala: salas) {
			System.out.println(sala);
		}
		assertTrue (salas.size() == 1);
	}
	

}
