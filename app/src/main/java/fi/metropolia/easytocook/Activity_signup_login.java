package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fi.metropolia.easytocook.receipe.Dish;
import fi.metropolia.easytocook.receipe.Ingredient;
import fi.metropolia.easytocook.relationship.IngredientForDish;

public class Activity_signup_login extends AppCompatActivity {


    private final View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v == findViewById(R.id.btnLog_In)){
                Intent intentLogIn = new Intent(getApplicationContext(), Activity_logIn.class);
                startActivity(intentLogIn);
            } else if (v == findViewById(R.id.btnSignUp)){
                Intent intentCreateAccount = new Intent(getApplicationContext(), Activity_create_account.class);
                startActivity(intentCreateAccount);
            }else if (v == findViewById(R.id.btnTime)){
                Intent intentCookingTime = new Intent(getApplicationContext(), Activity_cookingTime.class);
                startActivity(intentCookingTime);
            }else if (v == findViewById(R.id.btnCalories)){
                Intent intentCalories = new Intent (getApplicationContext(), Activity_calories.class);
                startActivity(intentCalories);
            }else if (v == findViewById(R.id.btnDishSearch)){
                Intent intentDishSearch = new Intent (getApplicationContext(), Activity_search_by_dish.class);
                startActivity(intentDishSearch);
            } else if (v == findViewById(R.id.btnIngredient)){
                Intent intentIngredientSearch = new Intent (getApplicationContext(), Activity_search_by_ingredients.class);
                startActivity(intentIngredientSearch);


            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_login);

        //add intent to direct to Login page
        findViewById(R.id.btnLog_In).setOnClickListener(myClickListener);
        //add intent to direct to create account page
        findViewById(R.id.btnSignUp).setOnClickListener(myClickListener);
        //add intent to direct to cooking time page
        findViewById(R.id.btnTime).setOnClickListener(myClickListener);
        //add intent to direct to calories page
        findViewById(R.id.btnCalories).setOnClickListener(myClickListener);
        //add intent to direct to dish search page
        findViewById(R.id.btnDishSearch).setOnClickListener(myClickListener);
        //add intent to direct to ingredient search page
        findViewById(R.id.btnIngredient).setOnClickListener(myClickListener);








    }
}