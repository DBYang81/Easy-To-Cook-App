package fi.metropolia.easytocook;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import fi.metropolia.easytocook.receipe.Ingredient;
import fi.metropolia.easytocook.relationship.IngredientForDish;

@Dao
public interface DishIngredientDao {
    @Insert
    public long insert(IngredientForDish ingredientForDish);

    @Query("Select * From ingredientfordish where dishId = :dishId")
    public List<IngredientForDish> getIngredientForDish(long dishId);


}
