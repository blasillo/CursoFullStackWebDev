package es.jcyl.abcd.efgh;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.jcyl.abcd.efgh.persistencia.entidades.*;
import es.jcyl.abcd.efgh.persistencia.repositorios.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration ( classes = FullstackwebdevApplication.class)
public class TestReservasRopositorio {
	
	@Autowired
	private ReservasRepositorio reservasRepo;
	
	@Autowired
	private SalasRepositorio salasRepo;
	
	@Test
	public void testNuevoRecuperaBorra () throws Exception {
		
		ReservaEntidad reserva = new ReservaEntidad ();
		reserva.setUsuario("torgarbl");
		reserva.setFechaReserva( new Date ());
		reserva.setSala( salasRepo.getOne( 1 ) );
		
		
		reservasRepo.save( reserva );
		
		assertTrue ( reservasRepo.count() >= 1 );
		
		for ( ReservaEntidad res: reservasRepo.findAll()) {
			System.out.println(res);
			assertNotNull ( res );
			reservasRepo.delete( res );
		}
	
		assertTrue ( reservasRepo.count() == 0 );
	}
	
	@Test
	public void testExcepcionAlCrear () throws Exception {
		
		ReservaEntidad reserva = new ReservaEntidad ();
		reserva.setUsuario(null);
		reserva.setFechaReserva( new Date ());
		reserva.setSala( salasRepo.getOne( 1 ) );
		
		try { reservasRepo.save( reserva ); }
		catch (DataIntegrityViolationException dive) {
			assertTrue (true);
		}
		catch (Exception e) {
			System.out.println(e);
			assertTrue (false);
		}
	}
	
	@Test
	public void testExcepcionTamanoCampo () throws Exception {
		
		ReservaEntidad reserva = new ReservaEntidad ();
		reserva.setUsuario("torgarbltorgarbltorgarbl");
		reserva.setFechaReserva( new Date ());
		reserva.setSala( salasRepo.getOne( 1 ) );
		
		try { reservasRepo.save( reserva ); }
		catch (DataIntegrityViolationException dive) {
			assertTrue (true);
		}
		catch (Exception e) {
			System.out.println(e);
			assertTrue (false);
		}
	}
}
