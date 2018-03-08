package es.jcyl.abcd.efgh.persistencia.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="EDIFICIOS")
public class Edificio {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column (name = "EDIFICIO_ID", updatable=false)
	private Integer edificioId;
	
	@Column (name="NOMBRE" , nullable = false)
    private String nombre;
    
	@Column (name="TITULARIDAD" , nullable = true)
    private String titularidad;
	
	@Embedded
    private Direccion direccion;
	

	public Edificio() {
		super();
	}

	public Edificio(Integer edificioId, String nombre, String titularidad, Direccion direccion) {
		super();
		this.edificioId = edificioId;
		this.nombre = nombre;
		this.titularidad = titularidad;
		this.direccion = direccion;
	}

	public Integer getEdificioId() {
		return edificioId;
	}

	public void setEdificioId(Integer edificioId) {
		this.edificioId = edificioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitularidad() {
		return titularidad;
	}

	public void setTitularidad(String titularidad) {
		this.titularidad = titularidad;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Edificio [edificioId=" + edificioId + ", nombre=" + nombre + ", titularidad=" + titularidad
				+ ", direccion=" + direccion + "]";
	}

    
	

}




