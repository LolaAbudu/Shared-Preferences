package com.example.lolaabudu.sign_in_page_with_persistence_sharedpreference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity  extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE = "extra_message";

    private TextView displayMessageTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        displayMessageTextView = findViewById(R.id.second_activity_textView);

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String password = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        String textviewDisplay = "Your username: " + username + "\n" + "Your password: " + password;
        displayMessageTextView.setText(textviewDisplay);
    }
//Intent intent = getIntent();
//        String message1 = intent.getStringExtra(SeventhActivity.EXTRA_MESSAGE1);
 //   textView.setText(concatenatedMessage);
}
