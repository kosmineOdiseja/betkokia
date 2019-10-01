package bandymas.pirmas;

import java.io.Serializable;
import javax.persistence.*;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
public class Knyga implements Serializable{
	
	private static final long serialVersionUID = -6790693372846798580L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String pavadinimas;
	private String tipas;
	
	@Column(nullable=true)
	private Integer autorius_id;
 
	// @JsonIgnoreProperties("knyga")
	@ManyToOne 
	@JoinColumn(name="autorius_id"/*, referencedColumnName = "id"*/, insertable = false, updatable = false)
	private Autorius autorius;
 
	public Knyga() {}
 
	public Knyga(String pavadinimas, String tipas) {
	 
		this.pavadinimas = pavadinimas;
		this.tipas = tipas;
	 
	}
  
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}
 
	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}
 
	public String getTipas() {
		return tipas;
	}
 
	public void setTipas(String tipas) {
		 this.tipas = tipas;
	} 
 
	public Integer getAutorius_id() {
		return autorius_id;
	}

	public void setAutorius(Autorius autorius) {
		this.autorius = autorius;
	}
 
	public Autorius getAutorius() {
		return autorius;
	}

	public void setAutorius_id(Integer autorius_id) {
		this.autorius_id = autorius_id;
	}

} 