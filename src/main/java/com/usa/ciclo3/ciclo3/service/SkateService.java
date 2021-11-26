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

    public Skate update(Skate skate) {
        if (skate.getId() != null) {
            Optional<Skate> s = skateRepository.getSkate((skate.getId()));
            if (!s.isEmpty()) {
                if (skate.getName() != null) {
                    s.get().setName(skate.getName());
                }

                if (skate.getBrand() != null) {
                    s.get().setBrand(skate.getBrand());
                }

                if (skate.getYear() != null) {
                    s.get().setYear(skate.getYear());
                }

                if (skate.getDescription() != null) {
                    s.get().setDescription(skate.getDescription());
                }

                if (skate.getCategory() != null) {
                    s.get().setCategory(skate.getCategory());
                }

                skateRepository.save(s.get());
                return s.get();
            } else {
                return skate;
            }
        } else {
            return skate;
        }
    }

    public boolean deleteSkate(int id){
        Boolean aRespuesta = getSkate(id).map(skate -> {
            skateRepository.delete(skate);
            return true;
        }).orElse(false);
        return aRespuesta;
    }

    public boolean deleteSkate2(int id){
        Optional<Skate> s=getSkate(id);
        if(!s.isEmpty()){
            skateRepository.delete(s.get());
            return true;
        }
        return false;
    }
}
