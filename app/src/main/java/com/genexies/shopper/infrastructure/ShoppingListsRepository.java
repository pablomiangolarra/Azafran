package com.genexies.shopper.infrastructure;

import com.genexies.shopper.model.ShoppingList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by pmiangolarra on 22/03/17.
 */

public class ShoppingListsRepository {

    private ArrayList<ShoppingList> shoppingLists;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public ShoppingListsRepository(){
        shoppingLists  = new ArrayList<>();
        shoppingLists.add(new ShoppingList());
        shoppingLists.add(new ShoppingList());
        shoppingLists.add(new ShoppingList());
    }

    public ArrayList<String> getShoppingListsToShow(){

        ArrayList<String> stringShoppingLists = new ArrayList<>();

        for (ShoppingList sl : shoppingLists){
            //stringShoppingLists.add(sdf.format(sl.getCreationDate()));
            stringShoppingLists.add(sl.getId().toString());
        }
        return stringShoppingLists;
    }

    public ShoppingList getListById(String uuid){
        for (ShoppingList sl : shoppingLists){
            if (uuid.equals(sl.getId().toString())){
                return sl;
            }
        }
        return null;
    }
}
