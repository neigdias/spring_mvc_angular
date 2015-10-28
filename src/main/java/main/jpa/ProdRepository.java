package main.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProdRepository extends CrudRepository<Prod, Integer> {
	List<Prod> findByNome(String nome);
}
