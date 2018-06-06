package es.jcyl.abcd.efgh.utiles;

import java.util.ArrayList;
import es.jcyl.abcd.efgh.persistencia.entidades.*;

public final class JpaUtiles  {
	
	public final static ArrayList<TipoSalaEntidad> LISTA_TIPOS_SALA = new ArrayList<TipoSalaEntidad> () {{
	    add ( new TipoSalaEntidad (null, "Auditorio"));
	    add ( new TipoSalaEntidad (null, "Sala de reuniones"));
	    add ( new TipoSalaEntidad (null, "Despacho"));
	}};
	
	
	
	public final static ArrayList<SalaEntidad> LISTA_SALAS = new ArrayList<SalaEntidad> () {{
	    add ( new SalaEntidad (null, "Sala de juntas", "Sala de juntas", 100, "Sotano S12", new TipoSalaEntidad (1,"Auditorio") ) );
	    add ( new SalaEntidad (null, "Sala de reuniones de Informática", "Sala de reuniones de Informática en la pirámide", 12, "Sotano S112", new TipoSalaEntidad (2,"Sala de reuniones")) );
	    add ( new SalaEntidad (null, "Despacho de reuniones 1", "Despacho de reuniones de Informática en la pirámide interior", 8, "Sotano S114", new TipoSalaEntidad (3,"Despacho")) );
	    add ( new SalaEntidad (null, "Despacho de reuniones 2", "Sala de reuniones de Informática en la pirámide exterior", 10, "Sotano S115", new TipoSalaEntidad (3,"Despacho")) );
    }};
}