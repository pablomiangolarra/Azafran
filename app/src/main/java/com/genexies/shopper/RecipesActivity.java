package com.genexies.shopper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.genexies.shopper.infrastructure.RecipesRepository;
import com.genexies.shopper.infrastructure.ShoppingListsRepository;

public class RecipesActivity extends AppCompatActivity {

    private static RecipesRepository recipesRepository = new RecipesRepository();
    private static final String TAG="shopper-recipes";
    private static final Class RECIPES_ACTIVITY = RecipesActivity.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipies);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup lisView with Items
        Log.w(TAG, "Starting activity: "+RECIPES_ACTIVITY);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, recipesRepository.getRecipesToShow());
        ListView listView = (ListView) findViewById(R.id.recipeslistview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(mMessageClickedHandler);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    // Create a message handling object as an anonymous class.
    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            // Do something in response to the click
            Toast.makeText(getApplicationContext(), "Item pressed: "+id, Toast.LENGTH_SHORT).show();
        }
    };
}
