package com.genexies.shopper.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by pmiangolarra on 22/03/17.
 */

public class Ingredient {

    private UUID id;
    private String name;
    private Date creationDate;
    private MetricUnit metricUnit;
    private Double amount;
    private Aisle aisle;
    private boolean gotIt = false;

    public Ingredient(String name, MetricUnit metricUnit, Double amount, Aisle aisle) {

        this.id = UUID.randomUUID();
        this.creationDate = new Date();
        this.name = name;
        this.metricUnit = metricUnit;
        this.amount = amount;
        this.aisle = aisle;
    }

    public String getName(){
        return name;
    }

    public void switchGotIt(){
        if (gotIt){
            gotIt = false;
        }else{
            gotIt = true;
        }
    }
}
