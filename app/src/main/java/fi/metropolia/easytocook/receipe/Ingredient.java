package fi.metropolia.easytocook.receipe;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;
@Entity(tableName = "ingredient")
public class Ingredient {
    @PrimaryKey(autoGenerate = true)
    public long ingredientId;
    public String ingredientName;
    public int caloriePer100Gram;
    @Ignore
    public long quantity;


//    public Ingredient(long ingredientId, String ingredientName, int caloriePer100Gram, int ingredientQuantity) {
//        this.ingredientId = ingredientId;
//        this.ingredientName = ingredientName;
//        this.caloriePer100Gram = caloriePer100Gram;
//        this.ingredientQuantity = ingredientQuantity;
//    }

    @Override
    public String toString() {
        return "Ingredient:"+ ingredientName + '\'' + ", calorie/100g: " + caloriePer100Gram + ", quantity:" + quantity;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getCaloriePer100Gram() {
        return caloriePer100Gram;
    }

    public void setCaloriePer100Gram(int caloriePer100Gram) {
        this.caloriePer100Gram = caloriePer100Gram;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

}
