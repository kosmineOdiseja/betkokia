package agentura;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class KlientuKeliones {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer klientai_id;
	private Integer  keliones_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getKlientai_id() {
		return klientai_id;
	}
	public void setKlientai_id(Integer klientai_id) {
		this.klientai_id = klientai_id;
	}
	public Integer getKeliones_id() {
		return keliones_id;
	}
	public void setKeliones_id(Integer keliones_id) {
		this.keliones_id = keliones_id;
	}
}
