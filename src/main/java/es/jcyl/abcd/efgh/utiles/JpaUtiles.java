package es.jcyl.abcd.efgh.utiles;

import java.util.ArrayList;
import es.jcyl.abcd.efgh.persistencia.entidades.*;

public final class JpaUtiles  {
	
	public final static ArrayList<TipoSala> LISTA_TIPOS_SALA = new ArrayList<TipoSala> () {{
	    add ( new TipoSala (null, "Auditorio"));
	    add ( new TipoSala (null, "Sala de reuniones"));
	    add ( new TipoSala (null, "Despacho"));
	}};
	
	
	
	public final static ArrayList<Sala> LISTA_SALAS = new ArrayList<Sala> () {{
	    add ( new Sala (null, "Sala de juntas", "Sala de juntas", 100, "Sotano S12", new TipoSala (1,"Auditorio") ) );
	    add ( new Sala (null, "Sala de reuniones de Informática", "Sala de reuniones de Informática en la pirámide", 12, "Sotano S112", new TipoSala (2,"Sala de reuniones")) );
	    add ( new Sala (null, "Despacho de reuniones 1", "Despacho de reuniones de Informática en la pirámide interior", 8, "Sotano S114", new TipoSala (3,"Despacho")) );
	    add ( new Sala (null, "Despacho de reuniones 2", "Sala de reuniones de Informática en la pirámide exterior", 10, "Sotano S115", new TipoSala (3,"Despacho")) );
    }};
}