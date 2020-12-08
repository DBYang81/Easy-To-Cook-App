package fi.metropolia.easytocook;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fi.metropolia.easytocook.receipe.Ingredient;

@Dao
public interface IngredientDao {
    @Insert
    public long addIngredient (Ingredient ingredient);


    @Delete
    public void deleteIngredient (Ingredient ingredient);
    

    @Query("select * from ingredient where caloriePer100Gram")
    public List<Ingredient> getIngredientByCalorie();

    @Query("select * from ingredient")
    public List<Ingredient> getIngredient();

    @Query("Select * from ingredient where ingredientName = :ingredientName")
    public Ingredient getIngredientByName(String ingredientName);

//    @Query("Select ingredientName from ingredient ")
//    public List<Ingredient> getIngredientName();

    @Query("Select * from ingredient where ingredientId = :ingredientId")
    public Ingredient getIngredientById(long ingredientId);


}
