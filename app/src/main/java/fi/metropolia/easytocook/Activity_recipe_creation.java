package fi.metropolia.easytocook;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import fi.metropolia.easytocook.receipe.Dish;
import fi.metropolia.easytocook.receipe.Ingredient;
import fi.metropolia.easytocook.relationship.IngredientForDish;

public class Activity_recipe_creation extends AppCompatActivity {
    public static AppDatabase myAppDatabase;
    EditText dishName, ingredientName, amount, calorie, cookTime, description;
    Button add, saveRecipe;
    List<IngredientForDish> ingredients = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_creation);

        Log.d(Activity_create_account.TAG, "on recipe created");

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "appDB").allowMainThreadQueries().build();
    }


    @Override
    protected void onStart() {
        super.onStart();
        dishName = findViewById(R.id.nameOfDish);
        ingredientName = findViewById(R.id.ingInput);
        amount = findViewById(R.id.amountOfIngredient);
        calorie = findViewById(R.id.calorie);
        cookTime = findViewById(R.id.ckTimeInput);
        description = findViewById(R.id.howToCookInput);

        add = findViewById(R.id.btnAdd);
        saveRecipe = findViewById(R.id.btnSaveRecipe);

        add.setOnClickListener(new View.OnClickListener() { //add button to create ingredient array for certain 1 dish
            @Override
            public void onClick(View v) {

                String ingredientInput = ingredientName.getText().toString();
                int amountInput = Integer.parseInt(amount.getText().toString());
                int calorieInput = Integer.parseInt(calorie.getText().toString());

                try {
                    Ingredient ing = myAppDatabase.ingredientDao().getIngredientByName(ingredientInput); //retrieve the database about ingredient
                    if (ing == null) {
                        ing = new Ingredient(); //if user input has not found, then create new one
                        ing.setIngredientName(ingredientInput);
                        ing.setCaloriePer100Gram(calorieInput);
                        ing.setQuantity(amountInput);
                        long id = myAppDatabase.ingredientDao().addIngredient(ing);
                        ing.setIngredientId(id);
                    }

                    IngredientForDish ingredient = new IngredientForDish(); //create the crossRef class object
                    ingredient.quantity = amountInput;
                    ingredient.ingredientId = ing.ingredientId;

                    ingredients.add(ingredient);
                    Toast.makeText(getApplicationContext(), "ingredient added", Toast.LENGTH_SHORT).show();
                } catch (Exception pokemon) {
                    Log.e("DB", pokemon.getMessage());//debug codes
                }

                ingredientName.setText("");
                calorie.setText(null);
                amount.setText(null);
            }
        });

        saveRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dishNameInput = dishName.getText().toString();
                String descriptionInput = description.getText().toString();
                double cookTimeInput = Double.parseDouble(cookTime.getText().toString());

                Dish dish = new Dish();// create new dish
                dish.setDishName(dishNameInput);
                dish.setTime(cookTimeInput);
                dish.setDescription(descriptionInput);

                try {
                    long dId = myAppDatabase.dishDao().addDish(dish); //dishDao method to retrieve data about dish
                    for (IngredientForDish ingredient : ingredients) { //loop crossRef class ingredient as foreign key within new List<>
                        ingredient.dishId = dId; // assigned dishId to each ingredient as their id
                        myAppDatabase.dishIngredientDao().insert(ingredient); //to save into database
                        Log.d("DB", "ingredient" + ingredient);
                    }
                    Toast.makeText(getApplicationContext(), "Recipe Created", Toast.LENGTH_SHORT).show();
                } catch (Exception pokemon) {
                    Log.e("DB", pokemon.getMessage());
                }

                dishName.setText("");
                cookTime.setText(null);
                description.setText("");
                ingredientName.setText("");
                amount.setText(null);
                calorie.setText(null);
            }
        });
    }
}
