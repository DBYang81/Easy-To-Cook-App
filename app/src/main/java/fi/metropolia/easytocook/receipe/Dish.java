package fi.metropolia.easytocook.receipe;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity(tableName = "dish")    //as table in database
public class Dish {
    @PrimaryKey(autoGenerate = true)
    public long dishId;
    public String dishName;
    public double time;
    public String description;

//    public Dish(long dishId, String dishName, double time, String description) {
//        this.dishId = dishId;
//        this.dishName = dishName;
//        this.time = time;
//        this.description = description;
//    }

    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String toString(){
        return this.dishName + ", " + this.description;
    }
}
