package com.usa.ciclo3.ciclo3.model;

import lombok.Data;

@Data
public class YearAmount {
    private int year;
    private int amount;

    public YearAmount(int year, int amount){
        this.year=year;
        this.amount=amount;
    }
}
