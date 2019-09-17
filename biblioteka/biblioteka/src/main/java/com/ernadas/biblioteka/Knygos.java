package com.ernadas.biblioteka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Knygos {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Integer id;
    private String knygos_pav;
    private String autorius;
    private String isleidimo_metai;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKnygos_pav() {
		return knygos_pav;
	}
	public void setKnygos_pav(String knygos_pav) {
		this.knygos_pav = knygos_pav;
	}
	public String getAutorius() {
		return autorius;
	}
	public void setAutorius(String autorius) {
		this.autorius = autorius;
	}
	public String getIsleidimo_metai() {
		return isleidimo_metai;
	}
	public void setIsleidimo_metai(String isleidimo_metai) {
		this.isleidimo_metai = isleidimo_metai;
	}
 
}
