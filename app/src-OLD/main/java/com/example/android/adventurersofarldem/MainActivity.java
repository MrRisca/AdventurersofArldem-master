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
        displayPlayerHealth(0);
        displayPlayerMaxHealth(10);
        displayPlayerMana(0);
        displayPlayerMaxHana(10);
        displayPlayerStrength(1);
        displayPlayerInt(2);
        displayPlayerAgility(3);

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


    public void displayPlayerHealth(int player_current_HP) {
        TextView currentHealth = (TextView) findViewById(R.id.playerCurrentHealth);
        currentHealth.setText(String.valueOf(player_current_HP));
    }

    public void displayPlayerMaxHealth(int player_max_HP) {
        TextView maxHealth = (TextView) findViewById(R.id.playerMaxHealth);
        maxHealth.setText(String.valueOf(player_max_HP));
    }

    public void displayPlayerMana(int player_current_MP) {
        TextView currentMana = (TextView) findViewById(R.id.playerCurrentMana);
        currentMana.setText(String.valueOf(player_current_MP));
    }

    public void displayPlayerMaxHana(int player_max_MP) {
        TextView maxMana = (TextView) findViewById(R.id.playerMaxMana);
        maxMana.setText(String.valueOf(player_max_MP));
    }

    public void displayPlayerStrength(int player_str) {
        TextView str = (TextView) findViewById(R.id.playerCurrentStrength);
        str.setText(String.valueOf(player_str));
    }

    public void displayPlayerAgility(int player_agi) {
        TextView agi = (TextView) findViewById(R.id.playerCurrentAgility);
        agi.setText(String.valueOf(player_agi));
    }

    public void displayPlayerInt(int player_int) {
        TextView intellect = (TextView) findViewById(R.id.playerCurrentIntellect);
        intellect.setText(String.valueOf(player_int));
    }
}

