package bandymas.pirmas;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
public class Autorius {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String vardas;
	private String pavarde;

	@JsonIgnoreProperties("autorius")
	@OneToMany(mappedBy = "autorius",cascade = CascadeType.ALL)
	private List<Knyga> knyga; 

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

	public List<Knyga> getKnyga() {
	
		return knyga;
	}

	public void setKnyga (List<Knyga> knyga) {
	
		this.knyga = knyga;
	}

} 