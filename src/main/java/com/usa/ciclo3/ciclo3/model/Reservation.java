package com.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";

    @ManyToOne
    @JoinColumn(name = "idSkate")
    @JsonIgnoreProperties({"reservations"})
    private Skate skate;

    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;

    private String score;

}
