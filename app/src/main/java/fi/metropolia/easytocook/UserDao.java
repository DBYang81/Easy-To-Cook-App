package fi.metropolia.easytocook;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import fi.metropolia.easytocook.userProfile.User;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addUser (User user);

    @Delete
    public void deleteUser (User user);

//    @Query("Select * from user")
//    public List<UserWithDishAndIngredient> getUserWithDishAndIngredient();


}
