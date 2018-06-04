package es.jcyl.abcd.efgh;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
public class TestEdificiosRepositorio {
	
	@Autowired
	private EdificiosRepositorio repo;
	
	@Test
	public void testBusquedaPorProvincia () throws Exception {
		List<EdificioEntidad> edificios = repo.buscarPorProvincia("vall");
		
		assertNotNull ( edificios);
		
		for (EdificioEntidad edificio : edificios ) {
			System.out.println( edificio );
		}
		
		assertTrue ( edificios.size() > 0 );
	}
	
	@Test
	public void testBusquedaPorVia () throws Exception {
		List<EdificioEntidad> edificios = repo.findByDireccionTipoViaAndDireccionNombreViaContainsIgnoreCase(TipoVia.CALLE, "santiago");
 
		assertNotNull ( edificios);
		
		for (EdificioEntidad edificio : edificios ) {
			System.out.println( edificio );
		}
		
		assertTrue ( edificios.size() > 0 );
		
	}
	
	@Test
	public void testBusquedaPorNombre () throws Exception {
		List<EdificioEntidad> edificios = repo.findByNombreContainsIgnoreCase("hospital");
		
		assertNotNull ( edificios);
		
		for (EdificioEntidad edificio : edificios ) {
			System.out.println( edificio );
		}
		
		assertTrue ( edificios.size() > 0 );
		
		
		
	}

}
