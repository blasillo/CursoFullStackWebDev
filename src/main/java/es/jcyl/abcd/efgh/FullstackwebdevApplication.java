package es.jcyl.abcd.efgh;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import org.springframework.context.annotation.Import;

import es.jcyl.abcd.efgh.configuracion.AplicacionConfiguracion;


@SpringBootApplication
@Import ({AplicacionConfiguracion.class})
public class FullstackwebdevApplication {
	
    @SuppressWarnings(value = { "unused" })
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(FullstackwebdevApplication.class, args);
		
	}
}


