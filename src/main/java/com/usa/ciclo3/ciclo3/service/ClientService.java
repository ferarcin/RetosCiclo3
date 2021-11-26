package com.usa.ciclo3.ciclo3.service;

import com.usa.ciclo3.ciclo3.model.Client;
import com.usa.ciclo3.ciclo3.repository.ClientRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client c){
        if(c.getIdClient() == null){
            return clientRepository.save(c);
        }else{
            Optional<Client> caux = clientRepository.getClient(c.getIdClient());
            if(caux.isEmpty()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
          Optional<Client> c=clientRepository.getClient(client.getIdClient());

          if(!c.isEmpty()){
              if(client.getPassword()!=null){
                  c.get().setPassword(client.getPassword());
              }

              if(client.getName()!=null){
                  c.get().setName(client.getName());
              }

              if(client.getAge()!=null){
                  c.get().setAge(client.getAge());
              }

              clientRepository.save(c.get());
              return c.get();
          }else{
              return client;
          }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int id){
        Boolean aRespuesta = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aRespuesta;
    }
}
