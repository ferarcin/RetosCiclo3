package com.usa.ciclo3.ciclo3.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name="score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;

    private Integer qualification;

    //@NonNull
    @Column(name= "score", nullable = false, length = 250)
    private String score;



}
