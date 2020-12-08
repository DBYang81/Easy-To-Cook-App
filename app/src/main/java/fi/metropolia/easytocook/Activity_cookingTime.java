package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import fi.metropolia.easytocook.receipe.Dish;

public class Activity_cookingTime extends AppCompatActivity {
    public static AppDatabase myAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking_time);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "appDB")
                .allowMainThreadQueries().build();

        List<Dish> dishList = myAppDatabase.dishDao().getDishByCookingTime();

        ListView lv = findViewById(R.id.listViewCookingTime);
        lv.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dishList
        ));
    }
}