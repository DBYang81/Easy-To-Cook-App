package fi.metropolia.easytocook;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fi.metropolia.easytocook.receipe.Dish;

@Dao
public interface DishDao {
    @Insert
    public long addDish (Dish dish);

    @Delete
    public void deleteDish (Dish dish);


    @Query("Select * From dish")
    public List<Dish> getAll();

    @Query("Select * From dish order by dishName")
    public List<Dish> getDishName();

    @Query("Select * From dish where dishId =:dishId")
    public Dish getDish(long dishId);

    @Query("Select * From dish order by time")
    public List<Dish> getDishByCookingTime();


}
