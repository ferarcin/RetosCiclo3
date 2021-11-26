package com.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    @NonNull
    @Column(name= "messageText", nullable = false, length = 250)
    private String messageText;

    @ManyToOne
    @JoinColumn(name="idSkate")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Skate skate;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

}
