package br.com.teste.rest.services;

import br.com.teste.rest.models.Costumer;

import java.util.List;

public interface ICostumerService {
    Long addCostumer(Costumer costumer) throws Exception;
    boolean updateCostumer(Costumer costumer) throws Exception;
    boolean deleteCostumer(Long costumerId) throws Exception;
    List<Costumer> costumerList();
}
