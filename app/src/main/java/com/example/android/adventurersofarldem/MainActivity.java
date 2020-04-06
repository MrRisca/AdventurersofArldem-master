package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.android.adventurersofarldem.Activities.CharacterSelection;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setContentView(R.layout.activity_main);

        ImageView creation = findViewById(R.id.Dragon);

        creation.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link CreationActivity}
                Intent creationIntent = new Intent(MainActivity.this, CharacterSelection.class);

                // Start the new activity
                startActivity(creationIntent);
            }
        });
        }




}

