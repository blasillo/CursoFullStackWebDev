package es.jcyl.abcd.efgh.servicios;

import java.util.*;

import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.Usuario;

@Service
public class TokenServicio {
	
	
	ArrayList<Usuario> usuarios = new ArrayList () {{
		add (new Usuario ("TORGARBL","secreto"));
		add (new Usuario ("FERMATFE","secreto-1"));
		add (new Usuario ("MAROSLFE","secreto-2"));
	}};
	
	HashMap<String , Usuario> tokens = new HashMap<String , Usuario> ();
	
	public boolean estaAutorizado (Usuario us) {
		for (Usuario u : usuarios) {
			if ( u.getNombre().equals( us.getNombre() ) && u.getContrasena().equals( us.getContrasena() ) ) {
				return true;
			}
		}
		return false;	
	}
	
	public String crearToken ( Usuario u ) {
		String token = UUID.randomUUID().toString();
		
		tokens.put(token, u);
		
		return token;
	}
	
	
	public void borrarToken ( String token) {
		tokens.remove(token);
	}
	
	public boolean esTokenValido (String token ) {
		
		if ( tokens.get(token) != null ) { return true;}
		
		return false;
	}
	

}
