package com.usa.ciclo3.ciclo3.repository;

import com.usa.ciclo3.ciclo3.model.Skate;
import com.usa.ciclo3.ciclo3.repository.crud.SkateCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SkateRepository {
    @Autowired
    private SkateCrudRepository skateCrudRepository;

    public List<Skate> getAll(){
        return (List<Skate>) skateCrudRepository.findAll();
    }

    public Optional<Skate> getSkate(int id){
        return skateCrudRepository.findById(id);
    }

    public Skate save(Skate s){
        return skateCrudRepository.save(s);
    }
}
