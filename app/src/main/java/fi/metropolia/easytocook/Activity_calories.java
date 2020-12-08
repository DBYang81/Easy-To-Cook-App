package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import fi.metropolia.easytocook.receipe.Dish;
import fi.metropolia.easytocook.receipe.Ingredient;
import fi.metropolia.easytocook.relationship.IngredientForDish;

public class Activity_calories extends AppCompatActivity {
    public static AppDatabase myAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "appDB")
                .allowMainThreadQueries().build();

        List<Ingredient> ingredients = new ArrayList<>();
        List<Dish> dishList = myAppDatabase.dishDao().getAll();
        for (Dish dish : dishList){

            List<IngredientForDish> ingredientList = myAppDatabase.dishIngredientDao().getIngredientForDish(dish.dishId);

            for(IngredientForDish ingredient: ingredientList){
                Ingredient j = myAppDatabase.ingredientDao().getIngredientById(ingredient.ingredientId);
                j.quantity = ingredient.quantity;
                ingredients.add(j);
            }
        }

        ListView lv = findViewById(R.id. listViewCalories);

        lv.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                ingredients
        ));


    }

}