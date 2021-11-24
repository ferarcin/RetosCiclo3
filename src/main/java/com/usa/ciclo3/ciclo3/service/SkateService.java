package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Skate;
import com.usa.ciclo3.ciclo3.repository.SkateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkateService {
    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getAll(){
        return skateRepository.getAll();
    }

    public Optional<Skate> getSkate(int id){
        return skateRepository.getSkate(id);
    }

    public Skate save(Skate s){
        if(s.getId() == null){
            return skateRepository.save(s);
        }else{
            Optional<Skate> saux = skateRepository.getSkate(s.getId());
            if(saux.isEmpty()){
                return skateRepository.save(s);
            }else{
                return s;
            }
        }
    }
}
