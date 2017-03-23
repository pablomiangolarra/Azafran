package com.genexies.shopper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.genexies.shopper.infrastructure.ShoppingListsRepository;
import com.genexies.shopper.model.ShoppingList;

import java.util.ArrayList;

public class MainShopperActivity extends AppCompatActivity {

    private static final String TAG="shopper-main";
    private static final Class RECIPES_ACTIVITY = RecipesActivity.class;
    private static final Class SHOPPING_ACTIVITY = ShoppingActivity.class;
    private static ShoppingListsRepository listsRepository = new ShoppingListsRepository();
    private ArrayList<String> shoppingListsToShow = listsRepository.getShoppingListsToShow();

    // Create a message handling object as an anonymous class.
    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            // Do something in response to the click
            Toast.makeText(getApplicationContext(), "Opening shopping list: "+shoppingListsToShow.get(position), Toast.LENGTH_SHORT).show();
            Log.w(TAG, "Calling activity: "+SHOPPING_ACTIVITY);
            Intent dialogIntent = new Intent(MainShopperActivity.this, SHOPPING_ACTIVITY);
            Bundle b = new Bundle();
            b.putString("ShoopingListId", shoppingListsToShow.get(position)); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(dialogIntent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_shopper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup lisView with Items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, shoppingListsToShow);
        ListView listView = (ListView) findViewById(R.id.shoopinglistsview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(mMessageClickedHandler);

        // Setup button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w(TAG, "Calling activity: "+RECIPES_ACTIVITY);
                Intent dialogIntent = new Intent(MainShopperActivity.this, RECIPES_ACTIVITY);
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialogIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_shopper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
