package br.com.teste.rest.repositories;

import br.com.teste.rest.models.Costumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICostumerDao extends CrudRepository<Costumer,Long> {
}
