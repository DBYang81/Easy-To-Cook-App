package fi.metropolia.easytocook.relationship;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import fi.metropolia.easytocook.receipe.Dish;
import fi.metropolia.easytocook.receipe.Ingredient;

@Entity(foreignKeys = {@ForeignKey(entity = Dish.class,parentColumns = "dishId",childColumns = "dishId"),
        @ForeignKey(entity = Ingredient.class,parentColumns = "ingredientId",childColumns = "ingredientId")}) //crossref table with patrick's help
public class IngredientForDish {
    @PrimaryKey (autoGenerate = true)
    public long ingredientForDish;
    public long dishId;
    public long ingredientId;
    public long quantity;

    @Override
    public String toString() {
        return  "dishId: " + dishId +  " quantity:" + quantity;
    }
}
