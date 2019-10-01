package agenturax_egzamx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Keliones {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String pav;
	private String aprasymas;
	private String pozymiai;
	private Double kaina;
	
	
	// persiziureti Id parent!!!
//	 @Column(nullable=true)
//	 private Integer id_parent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public String getAprasymas() {
		return aprasymas;
	}

	public void setAprasymas(String aprasymas) {
		this.aprasymas = aprasymas;
	}

	public String getPozymiai() {
		return pozymiai;
	}

	public void setPozymiai(String pozymiai) {
		this.pozymiai = pozymiai;
	}

	public Double getKaina() {
		return kaina;
	}

	public void setKaina(Double kaina) {
		this.kaina = kaina;
	}

	/*
	 * public Integer getId_parent() { return id_parent; }
	 * 
	 * public void setId_parent(Integer id_parent) { this.id_parent = id_parent; }
	 */
	 
}
