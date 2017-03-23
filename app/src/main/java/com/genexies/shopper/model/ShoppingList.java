package com.genexies.shopper.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by pmiangolarra on 21/03/17.
 */

public class ShoppingList {


    private UUID id;
    private Date creationDate;
    private ArrayList<String> ingredients;


    public ShoppingList() {
        this.id = UUID.randomUUID();
        this.creationDate = new Date();
        this.ingredients = new ArrayList<String>();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getIngredientByIndex(int i){
        return ingredients.get(i);

    }

    public UUID getId() {
        return id;
    }
}
