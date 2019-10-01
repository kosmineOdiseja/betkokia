package com.ernadas.biblioteka;

import org.springframework.data.repository.CrudRepository;


public interface KnygosRepository extends CrudRepository<Knygos, Integer> {

	Knygos findByKnygosPav(String knygos_pav);
	// crudRepository nurodo kad tai bus knygos lentele is mysql o rasom is K didziosiosknygos 
	// kas taip nurodom klase kurioje yra seteriai ir geteriai ir jau ten pasiimam visa lentele
	// integer del to kad taip nurodom ar pasiima ta lentele su id kurie yra skaiciai!
}
