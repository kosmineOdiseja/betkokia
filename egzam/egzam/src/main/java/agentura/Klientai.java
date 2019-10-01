package agentura;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class Klientai {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String vardasPavarde;
	private Integer flagPoilsines;
	private Integer flagPazintines;
	private Integer flagViskasIskaic;
	private Integer flagLaisvPasir;	
	
	public Klientai( ) {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVardasPavarde() {
		return vardasPavarde;
	}
	public void setVardasPavarde(String vardas_pavarde) {
		this.vardasPavarde = vardas_pavarde;
	}
	public Integer getFlag_poilsines() {
		return flagPoilsines;
	}
	public void setFlagPoilsines(Integer flag_poilsines) {
		this.flagPoilsines = flag_poilsines;
	}
	public Integer getFlagPazintines() {
		return flagPazintines;
	}
	public void setFlagPazintines(Integer flag_pazintines) {
		this.flagPazintines = flag_pazintines;
	}
	public Integer getFlagViskasIskaic() {
		return flagViskasIskaic;
	}
	public void setFlagViskasIskaic(Integer flag_viskas_iskaic) {
		this.flagViskasIskaic = flag_viskas_iskaic;
	}
	public Integer getFlagLaisvPasir() {
		return flagLaisvPasir;
	}
	public void setFlagLaisvPasir(Integer flag_laisv_pasir) {
		this.flagLaisvPasir = flag_laisv_pasir;
	}
}
	