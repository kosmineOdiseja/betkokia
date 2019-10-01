package bandymas.pirmas;

import org.springframework.data.repository.CrudRepository;

public interface KnygaRepository extends CrudRepository<Knyga, Integer> {

	Knyga findByPavadinimas(String pavadinimas);

	

}