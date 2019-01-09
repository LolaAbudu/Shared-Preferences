package com.example.lolaabudu.sign_in_page_with_persistence_sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String SHARED_PREFERENCE_KEY = "com.example.lolaabudu.sign_in_page_with_persistence_sharedpreference";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    public static final String EXTRA_MESSAGE1 = "username_extra_message";
    public static final String EXTRA_MESSAGE2 = "password_extra_message";

    private SharedPreferences sharedPreferences;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private CheckBox saveCredentialsCheckbox;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findAllViews();

        buttonOnClickListener();
        getAndSetLoginCredentials();
    }




    private void buttonOnClickListener() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                boolean isChecked = saveCredentialsCheckbox.isChecked();

                if(isChecked){
                    sharedPreferences.edit()
                            .putString(USERNAME_KEY, username)
                            .putString(PASSWORD_KEY, password)
                            .apply();
                    Toast.makeText(getApplicationContext(), "You saved it!", Toast.LENGTH_SHORT).show();
                }
                goToSecondACtivity();
            }
        });
    }

    private void findAllViews() {
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_KEY, MODE_PRIVATE);
        usernameEditText = findViewById(R.id.username_editText);
        passwordEditText = findViewById(R.id.password_editText);
        saveCredentialsCheckbox = findViewById(R.id.saveCredentials_checkBox);
        submitButton = findViewById(R.id.submit_button);
    }

    private void getAndSetLoginCredentials(){
        String getUsername = sharedPreferences.getString(USERNAME_KEY, "");
        String getPassword = sharedPreferences.getString(PASSWORD_KEY, "");

        usernameEditText.setText(getUsername);
        passwordEditText.setText(getPassword);
    }

    private void goToSecondACtivity(){
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE1, username);
        intent.putExtra(EXTRA_MESSAGE2, password);
        startActivity(intent);
    }
}
