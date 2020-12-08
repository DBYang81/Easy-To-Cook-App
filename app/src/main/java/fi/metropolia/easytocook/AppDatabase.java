package fi.metropolia.easytocook;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import fi.metropolia.easytocook.receipe.Dish;
import fi.metropolia.easytocook.receipe.Ingredient;
import fi.metropolia.easytocook.relationship.IngredientForDish;
import fi.metropolia.easytocook.userProfile.User;

@Database(entities = {User.class, Ingredient.class, Dish.class, IngredientForDish.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract IngredientDao ingredientDao();

    public abstract DishDao dishDao();

    public abstract DishIngredientDao dishIngredientDao();
}
