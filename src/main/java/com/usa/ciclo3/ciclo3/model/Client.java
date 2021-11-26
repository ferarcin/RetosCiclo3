package com.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @NonNull
    @Column(name= "email", nullable = false, length = 45)
    private String email;

    @NonNull
    @Column(name= "password", nullable = false, length = 45)
    private String password;

    @NonNull
    @Column(name= "name", nullable = false, length = 250)
    private String name;
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties({"client", "skate"})
    public List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties({"client", "skate"})
    public List<Reservation> reservations;
}
