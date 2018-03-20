package es.jcyl.abcd.efgh;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import org.springframework.context.annotation.Import;

import es.jcyl.abcd.efgh.configuracion.AplicacionConfiguracion;


@SpringBootApplication
@Import ({AplicacionConfiguracion.class})
public class FullstackwebdevApplication {
	

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(FullstackwebdevApplication.class, args);
		
		
		/*
		ProvinciasRepositorio repoProv = context.getBean(ProvinciasRepositorio.class);
		PoblacionesRepositorio repoPop = context.getBean(PoblacionesRepositorio.class);
		
		
		
	
		
		
		
		System.out.println("PROVINCIAS COMIENZAN VALL:");
		for ( Provincia p:  repoProv.findByProvinciaStartingWithIgnoreCase ("vall")   ) {
			
			Page<Poblacion> pagina = repoPop.findByProvinciaAndPoblacionStartingWithIgnoreCase(p, "val", 
					new PageRequest(0,5, new Sort(new Order (Direction.DESC, "poblacion") )));
			System.out.println ( "Numero de poblaciones : " + pagina.getTotalElements() );
			for ( Poblacion po :  pagina ) {
			    System.out.println( po.getProvincia().getProvincia() + " / " + po.getPoblacion());
			}
		}
		*/
		
		/*
	 
		TipoSalaServicio servicio = context.getBean(TipoSalaServicio.class);
		
		
		//repo.save( JpaUtiles.LISTA_TIPOS_SALA );
		
		
		
		
		
		
		ArrayList<TipoSala> lista =  (ArrayList<TipoSala>) servicio.buscarPorTipo("e");
		
		for ( TipoSala ts : lista ) {
			System.out.println( ts.getTipoSalaId() + " - " + ts.getTipo() );
		}
		
		
		
		SalasServicio salaSrv = context.getBean(SalasServicio.class);
		
		//salaSrv.guardar( JpaUtiles.LISTA_SALAS );
		
		
		for ( Sala s : salaSrv.buscarPorCapacidad(12) ) {
			System.out.println( s );
		} 
		
	    
		
		EdificiosServicio srv = context.getBean( EdificiosServicio.class);
		
		for ( Edificio edif : srv.buscarPorProvincia( "vall") ) {
			System.out.println( edif );	
			
			System.out.println ("--------------------------------------------------------------");
		}
		
		
		for ( Edificio edif : srv.buscarPorDireccion( "zor") ) {
			System.out.println( edif.getNombre() + "\n" + edif.getDireccion().toString() );	
			
			System.out.println ("--------------------------------------------------------------");
		}
		
		for ( Edificio edif : srv.buscarPorTipoVia( TipoVia.AVENIDA ) ) {
			System.out.println( edif.getNombre() + "\n" + edif.getDireccion().toString() );	
			
			System.out.println ("--------------------------------------------------------------");
		}
		
		*/
		
		
		/*
		ReservasServicio reservasSrv = context.getBean( ReservasServicio.class);
		
		SalasServicio salasSrv = context.getBean( SalasServicio.class);
		
		
		Sala sala = salasSrv.buscarPorId( 1 );
		
		Reserva reserva = new Reserva ();
		reserva.setSala(sala);
		reserva.setUsuario("TORGARBL");
		try {
			reserva.setFechaReserva(  new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2018"));
		}
		catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		//reservasSrv.guardar( reserva );
	
		
		
		
		for ( Reserva r : reservasSrv.todos() ) {
			
			System.out.println( r );
		}
		
		 */
	}
}


