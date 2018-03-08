package es.jcyl.abcd.efgh.configuracion;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("es.jcyl.abcd.efgh.persistencia")
@EnableTransactionManagement
@ComponentScan ("es.jcyl.abcd.efgh.persistencia")
public class DatosConfiguracion {
	
	

}
