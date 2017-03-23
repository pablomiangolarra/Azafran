package com.genexies.shopper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by pmiangolarra on 22/03/17.
 */

public class Recipe {

    private UUID id;
    private String name;
    private Date creationDate;
    private ArrayList<Ingredient> ingredients;

    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.creationDate = new Date();
        this.ingredients = ingredients;
    }

    public String getName(){
        return name;
    }
}
