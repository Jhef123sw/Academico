package edu.unc.academico.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Investigador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInvestigador;
	@Column(unique = true)
	private String email;
	private String nombres;
	private String apePat;
	private String apeMat;
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	@ManyToOne
	@JsonBackReference
	private Departamento departamento;
	
	
	
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Long getIdInvestigador() {
		return idInvestigador;
	}
	public void setIdInvestigador(Long idInvestigador) {
		this.idInvestigador = idInvestigador;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApePat() {
		return apePat;
	}
	public void setApePat(String apePat) {
		this.apePat = apePat;
	}
	public String getApeMat() {
		return apeMat;
	}
	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
	
}
