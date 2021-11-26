package com.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="skate")
@Data
public class Skate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(name= "name", nullable = false, length = 45)
    private String name;

    @NonNull
    @Column(name= "brand", nullable = false, length = 45)
    private String brand;


    private Integer year;

    @NonNull
    @Column(name= "description", nullable = false, length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    @JsonIgnoreProperties("skates")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties({"skate","client"})
    public List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties({"skate", "client"})
    public List<Reservation> reservations;

}
