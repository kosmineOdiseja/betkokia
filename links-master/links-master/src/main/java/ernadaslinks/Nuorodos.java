package ernadaslinks;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Nuorodos {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String pav;    
    
	@Column(nullable=true)
    private String laikas;
	
	private String link;
	
	private Integer kategorijos_id;	
	
	private String tipas;	
	
	private Integer rating;
	
	private String flags;
	
	private String aprasymas;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "nuorodos_zymos", joinColumns = @JoinColumn(name = "nuorodos_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "zymos_id", referencedColumnName = "id"))  
	private Set<Zymos> zymos;	
    
    @ManyToOne
    @JoinColumn(insertable=false, updatable=false)
	private Kategorijos kategorijos;	
	
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

	public String getLaikas() {
		return laikas;
	}

	public void setLaikas(String laikas) {
		this.laikas = laikas;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getKategorijos_id() {
		return kategorijos_id;
	}

	public void setKategorijos_id(Integer kategorijos_id) {
		this.kategorijos_id = kategorijos_id;
	}

	public String getTipas() {
		return tipas;
	}

	public void setTipas(String tipas) {
		this.tipas = tipas;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getAprasymas() {
		return aprasymas;
	}

	public void setAprasymas(String aprasymas) {
		this.aprasymas = aprasymas;
	}

	public Kategorijos getKategorijos() {
		return kategorijos;
	}

	public void setKategorijos(Kategorijos kategorijos) {
		this.kategorijos = kategorijos;
	}
	
	public Set<Zymos> getZymos() {
		return zymos;
	}

	public void setZymos(Set<Zymos> zymos) {
		this.zymos = zymos;
	}	
}
