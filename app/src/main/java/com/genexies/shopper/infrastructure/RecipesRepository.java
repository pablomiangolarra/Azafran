package com.genexies.shopper.infrastructure;

import com.genexies.shopper.model.Aisle;
import com.genexies.shopper.model.Ingredient;
import com.genexies.shopper.model.MetricUnit;
import com.genexies.shopper.model.Recipe;
import com.genexies.shopper.model.ShoppingList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by pmiangolarra on 22/03/17.
 */

public class RecipesRepository {

    private ArrayList<Recipe> recipesList;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public RecipesRepository(){
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        recipesList  = new ArrayList<>();
        recipesList.add(new Recipe("Lasaña",ingredientList));
        recipesList.add(new Recipe("Cocido",ingredientList));
        recipesList.add(new Recipe("Pavo",ingredientList));

    }

    public ArrayList<String> getRecipesToShow(){

        ArrayList<String> recipesListShow = new ArrayList<>();

        for (Recipe r : recipesList){
            recipesListShow.add(r.getName());
        }
        return recipesListShow;
    }
}
