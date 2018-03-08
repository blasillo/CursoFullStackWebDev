package es.jcyl.abcd.efgh.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.jcyl.abcd.efgh.persistencia.entidades.Usuario;
import es.jcyl.abcd.efgh.servicios.TokenServicio;

@Controller
@RestController
public class AutenticacionControlador {
	
	@Autowired
	private TokenServicio tokenSrv;
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST )
	public ResponseEntity<?> login ( @RequestBody Usuario usuario) {
		
		if ( tokenSrv.estaAutorizado( usuario )) {
			 return new ResponseEntity<> ( tokenSrv.crearToken( usuario ), HttpStatus.OK );
		}
		
		return new ResponseEntity<> ( "No autorizado" , HttpStatus.UNAUTHORIZED );
	}
	
	
	@RequestMapping(value="/logout")
	public ResponseEntity<?> logout (@RequestParam (required=false, value="token") String token) {
		
		tokenSrv.borrarToken(token);
		
		return new ResponseEntity<>("Sin token" , HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/privado")
	public ResponseEntity<?> privado (@RequestParam (required=false, value="token") String token) {
		
		if ( tokenSrv.esTokenValido( token )) {
			return new ResponseEntity<>("Dentro de la zona privada", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No autorizado", HttpStatus.UNAUTHORIZED);
	}	
	
	
	
	
	

}
