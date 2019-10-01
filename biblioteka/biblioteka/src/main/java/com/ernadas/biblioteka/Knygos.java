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
    private String knygosPav;
    private String autorius;
    private String isleidimo_metai;
    
    public Knygos() {}
    
    public Knygos(String knygos_pav, String autorius, String isleidimo_metai) {
    	
    	 this.knygosPav = knygos_pav;
    	 this.autorius = autorius;
    	 this.isleidimo_metai = isleidimo_metai;
    	    	
    	
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKnygosPav() {
		return knygosPav;
	}
	public void setKnygosPav(String knygos_pav) {
		this.knygosPav = knygos_pav;
	}
	public String getAutorius() {
		return autorius;
	}
	public void setAutorius(String autorius) {
		this.autorius = autorius;
	}
	public String getIsleidimo_metai() {
		return isleidimo_metai.substring(0,4);
	}
	public void setIsleidimo_metai(String isleidimo_metai) {
		this.isleidimo_metai = isleidimo_metai;
	}
	public String toString() {
		return id + ": " + knygosPav + " " + autorius + " " + isleidimo_metai;
	}
}
