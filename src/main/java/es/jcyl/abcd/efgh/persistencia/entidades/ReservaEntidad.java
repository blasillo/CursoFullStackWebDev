package es.jcyl.abcd.efgh.persistencia.entidades;

import java.util.Date;

import javax.persistence.*;


//@Entity
//TODO
public class ReservaEntidad {
	
	
//	TODO
//	TODO
//	TODO
	private Integer reservaId;
	
//	TODO
//	TODO
	private SalaEntidad sala;
	
//	TODO
//	TODO
	private Date fechaReserva;
	
//	TODO
	private String usuario;

	
	
	public ReservaEntidad() {
		super();
	}

	public Integer getReservaId() {
		return reservaId;
	}

	public void setReservaId(Integer reservaId) {
		this.reservaId = reservaId;
	}

	public SalaEntidad getSala() {
		return sala;
	}

	public void setSala(SalaEntidad sala) {
		this.sala = sala;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Reserva [reservaId=" + reservaId + ", sala=" + sala + ", fechaReserva=" + fechaReserva + ", usuario="
				+ usuario + "]";
	}
	
	
 
}
