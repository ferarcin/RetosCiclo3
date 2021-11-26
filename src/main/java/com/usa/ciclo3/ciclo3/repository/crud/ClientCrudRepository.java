package com.usa.ciclo3.ciclo3.repository.crud;

import com.usa.ciclo3.ciclo3.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientCrudRepository extends CrudRepository <Client, Integer> {
    @Query("SELECT c.age, COUNT(c.age) FROM Client AS c GROUP BY c.age ORDER BY COUNT(c.age) DESC")
    public List<Object[]> countTotalClientsByAge();
}
