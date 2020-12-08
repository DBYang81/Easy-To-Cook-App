package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import fi.metropolia.easytocook.receipe.Dish;

public class Activity_search_by_dish extends AppCompatActivity {
    public static AppDatabase myAppDatabase;

    private final View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == findViewById(R.id.btnTime)) {
                Intent intentCookTime = new Intent(getApplicationContext(), Activity_cookingTime.class);
                startActivity(intentCookTime);
            } else if (v == findViewById(R.id.btnCalories)) {
                Intent intentCalories = new Intent(getApplicationContext(), Activity_calories.class);
                startActivity(intentCalories);
            } else if (v == findViewById(R.id.btnIngredients)){
                Intent intentIngredients = new Intent(getApplicationContext(), Activity_search_by_ingredients.class);
                startActivity(intentIngredients);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_dish);
        //add intent to direct to calories page
        findViewById(R.id.btnTime).setOnClickListener(myClickListener);
        //go to calories filter page
        findViewById(R.id.btnCalories).setOnClickListener(myClickListener);
        //go to ingredients filter page
        findViewById(R.id.btnIngredients).setOnClickListener(myClickListener);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"appDB").allowMainThreadQueries().build();

        List<Dish> allDishes = myAppDatabase.dishDao().getAll();

        ListView lvOfDishes = findViewById(R.id.listViewOnDishSearch);
        lvOfDishes.setAdapter(new ArrayAdapter<Dish>(
                this,
                android.R.layout.simple_list_item_1,
                allDishes
        ));

        lvOfDishes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d(Activity_create_account.TAG,"onItemClick("+ position +")");

                Dish d = allDishes.get(position);
                Log.d(Activity_create_account.TAG,"click dish"+ d.dishId);

                Intent intent = new Intent (getApplicationContext(),Activity_recipe_detail.class);
                intent.putExtra("indexOfDish",d.dishId);

                Log.d("Dish",Integer.toString(position));
                startActivity(intent);
            }
        });





    }
}