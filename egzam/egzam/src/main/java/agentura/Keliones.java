package agentura;

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
	private String kaina;
	
	
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

	public String getKaina() {
		return kaina;
	}

	public void setKaina(String kaina) {
		this.kaina = kaina;
	}

}
