package es.jcyl.abcd.efgh.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;

@Entity
@Table (name="SALAS")

@NamedQuery (name="Sala.buscarPorCapacidad" , query="select s from Sala s where s.capacidad >= :capacidad")

public class Sala {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column ( name="SALA_ID", updatable=false)
	private Integer salaId;
	
	@Column (name="NOMBRE", nullable=false, length=50)
	private String nombre;
	
	@Column (name="DESCRIPCION", nullable=true, length=120)
	private String descripcion;
	
	@Column (name="CAPACIDAD", nullable=true)
    private Integer capacidad;
    
	@Column (name="LOCALIZACION", nullable=true, length=100)
    private String localizacion;
    
	@ManyToOne ( fetch=FetchType.EAGER)
	@JoinColumn(name="TIPO_ID")
    private TipoSala tipoSala;
	
	
	@ManyToOne ( fetch=FetchType.EAGER)
	@JoinColumn(name="EDIFICIO_ID")
	private Edificio edificio;

	public Sala() { }
	
	
	public Sala(Integer salaId, String nombre) {
		super();
		this.salaId = salaId;
		this.nombre = nombre;
	}
	

	public Sala(Integer salaId, String nombre, String descripcion, Integer capacidad, String localizacion,
			TipoSala tipoSala) {
		super();
		this.salaId = salaId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.localizacion = localizacion;
		this.tipoSala = tipoSala;
	}


	/* get y set */

	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public TipoSala getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(TipoSala tipoSala) {
		this.tipoSala = tipoSala;
	}
	
	


	public Edificio getEdificio() {
		return edificio;
	}


	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}


	@Override
	public String toString() {
		return "Sala [salaId=" + salaId + ", nombre=" + nombre + ", descripcion=" + descripcion + ", capacidad="
				+ capacidad + ", localizacion=" + localizacion + ", tipoSala=" + tipoSala + "]";
	}
    
    
	

}
