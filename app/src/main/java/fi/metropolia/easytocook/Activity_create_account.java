package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fi.metropolia.easytocook.userProfile.User;

public class Activity_create_account extends AppCompatActivity {
    public static final String TAG = "myApp";
    EditText firstName, lastName, email, userName, password, verifiedPassword;
    Button createAccount;
    public static AppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Log.i(TAG, "on User Create Account");

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), //build up database with key name
                AppDatabase.class, "appDB").allowMainThreadQueries().build();

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.EmailAddress);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.Password);
        verifiedPassword = findViewById(R.id.verify_password);
        createAccount = findViewById(R.id.btn_create_account);

        createAccount.setOnClickListener(new View.OnClickListener() { //create button click to create User account
            @Override
            public void onClick(View v) {
                String firstNameInput = firstName.getText().toString();
                String lastNameInput = lastName.getText().toString();
                String emailInput = email.getText().toString();
                String userNameInput = userName.getText().toString();
                String passwordInput = password.getText().toString();
                String verifiedPasswordInput = verifiedPassword.getText().toString();

                User user = new User(1,firstNameInput,lastNameInput,emailInput,userNameInput,passwordInput,verifiedPasswordInput); //create new User
//                user.setFirstName(firstNameInput);
//                user.setLastName(lastNameInput);
//                user.setEmail(emailInput);
//                user.setUserName(userNameInput);
//                user.setPasswords(passwordInput);

                Activity_create_account.myAppDatabase.userDao().addUser(user); //save into Database
                Toast.makeText(getApplicationContext(),"User added successfully",Toast.LENGTH_SHORT).show(); // show info to User to see if account has been created

                //clean them for new user
                firstName.setText("");
                lastName.setText("");
                email.setText("");
                userName.setText("");
                password.setText("");
                verifiedPassword.setText("");
            }
        });



    }
}




