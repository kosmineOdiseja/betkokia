package com.ernadas.biblioteka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	
public class Autorius {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String vardas;
	private String pavarde;
	private String gimimo_metai;
	private String salis;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVardas() {
		return vardas;
	}
	public void setVardas(String vardas) {
		this.vardas = vardas;
	}
	public String getPavarde() {
		return pavarde;
	}
	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}
	public String getGimimo_metai() {
		return gimimo_metai;
	}
	public void setGimimo_metai(String gimimo_metai) {
		this.gimimo_metai = gimimo_metai;
	}
	public String getSalis() {
		return salis;
	}
	public void setSalis(String salis) {
		this.salis = salis;
	}
	
	
	
}
