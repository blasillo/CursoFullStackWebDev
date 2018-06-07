package es.jcyl.abcd.efgh;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;
import es.jcyl.abcd.efgh.persistencia.repositorios.EdificiosRepositorio;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration ( classes = FullstackwebdevApplication.class)
public class TestEdificiosRepositorioImpl {
	
	@Autowired
	private EdificiosRepositorio repo;
	
	@Test
	public void testBuscarPorNombre() {
		

		List<EdificioEntidad> edificios = repo.buscarPorNombre("hospi");
		
		assertNotNull (edificios);
		
		for (EdificioEntidad edificio : edificios ) {
			System.out.println( edificio );
		}

		assertTrue ( edificios.size() == 1);
		
	}

	@Test
	public void testBusquedaEdificiosSinSalas() {
		
		System.out.println("Inicio ...");
		List<EdificioEntidad> edificios = repo.buscarEdificiosSinSalas();
		
		
		
		for (EdificioEntidad edificio : edificios ) {
			System.out.println( edificio );
		}

		System.out.println("Fin");
		
	}
	
	@Test
	public void testBuscarPorSalasConCapacidad() {
		

		List<EdificioEntidad> edificios = repo.buscarEdificiosConSalasYConCapacidad(100);
		
		assertNotNull (edificios);
		
		for (EdificioEntidad edificio : edificios ) {
			System.out.println( edificio );
		}

		assertTrue ( edificios.size() > 0);
		
	}

}
