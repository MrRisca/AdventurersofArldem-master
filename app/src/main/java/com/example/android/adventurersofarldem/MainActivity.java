package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public int player_max_health = 10;
    public int player_current_health = 0;
    public int player_max_mana = 0;
    public int player_current_mana = 0;
    public int player_strength = 0;
    public int player_agility = 0;
    public int player_intellect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setContentView(R.layout.activity_main);

        ImageView creation = (ImageView) findViewById(R.id.Dragon);

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


// The following are the commands to update the text fields showing player stats.

}

