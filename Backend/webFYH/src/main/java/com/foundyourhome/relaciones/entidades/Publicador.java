package com.foundyourhome.relaciones.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TP_PUBLICADOR")
public class Publicador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_PUBLICADOR")
	private Long codigo;

	@Column(unique = true, length = 20)
	private String razonSocial;
	@Column(unique = true, length = 20)
	private String ruc;
	@Column(length = 20)
	private String nombre;
	@Column(length = 20)
	private String apellido;
	@Column(unique = true, length = 20)
	private String correo;
	@Column(unique = true)
	private String contacto;

	@OneToMany(mappedBy = "publicador", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Vivienda> vivienda;

	@OneToOne(mappedBy = "publicador")
	private ResumenDiseno resumenDiseno;

	@OneToOne(mappedBy = "publicador")
	private Suscripcion suscripcion;

	public Publicador(Long codigo, String razonSocial, String ruc, String nombre, String apellido, String correo,
			String contacto, List<Vivienda> vivienda, ResumenDiseno viviendaDiseno, Suscripcion suscripcion) {
		super();
		this.codigo = codigo;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contacto = contacto;
		this.vivienda = vivienda;
		this.resumenDiseno = viviendaDiseno;
		this.suscripcion = suscripcion;
	}

	public Publicador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Vivienda> getVivienda() {
		return vivienda;
	}

	public void setVivienda(List<Vivienda> vivienda) {
		this.vivienda = vivienda;
	}

	public ResumenDiseno getViviendaDiseno() {
		return resumenDiseno;
	}

	public void setViviendaDiseno(ResumenDiseno resumenDiseno) {
		this.resumenDiseno = resumenDiseno;
	}

	public Suscripcion getSuscripcion() {
		return suscripcion;
	}

	public void setSuscripcion(Suscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicador other = (Publicador) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
