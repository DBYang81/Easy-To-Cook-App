package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fi.metropolia.easytocook.receipe.Dish;
import fi.metropolia.easytocook.receipe.Ingredient;
import fi.metropolia.easytocook.relationship.IngredientForDish;

public class Activity_recipe_detail extends AppCompatActivity {
    public static AppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);


        TextView tv1 = findViewById(R.id.txtViewNameOfReceipeDetail); //initial the textview and listview
        ListView tv2 = findViewById(R.id.recipeDetail);
        TextView tv3 = findViewById(R.id.txtViewCookTime);
        TextView tv4 = findViewById(R.id.txtViewReceipeDetailInstruction);

        Bundle b = getIntent().getExtras();
        long i = b.getLong("indexOfDish"); //get from previous activity location in List

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "appDB")
                .allowMainThreadQueries().build();

        Dish d = myAppDatabase.dishDao().getDish(i); //retrieve the dish data by get previous putExtra
        Log.d("buggers", "dName" + i + " " + d.dishName);

        List<IngredientForDish> ingredientList = myAppDatabase.dishIngredientDao().getIngredientForDish(i); //by retrieving index to get crossRef class list
        List<Ingredient> ingredients = new ArrayList<>(); //create new list for ingredients
        for (IngredientForDish ingredient : ingredientList) { //use for each loop from crossRef class and
                                                                    // retrieved ingredient id referred data to add quantity and add into new arraylist
            Ingredient j = myAppDatabase.ingredientDao().getIngredientById(ingredient.ingredientId);
            j.quantity = ingredient.quantity;
            ingredients.add(j);

        }
        Log.d("ingredient", "ingredients" + ingredients);

        tv1.setText(d.getDishName());
        tv2.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, //display the ingredients info with related dish
                ingredients
        ));

        tv3.setText(Double.toString(d.time));
        tv4.setText((d.getDescription()));
    }

}