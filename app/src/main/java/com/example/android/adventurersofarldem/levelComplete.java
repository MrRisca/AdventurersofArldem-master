package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class levelComplete extends AppCompatActivity {


    public int playerGold = 1;
    public int levelComplete = 0;
    public int playerExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_complete);

        playerGold = getIntent().getIntExtra("playerGold", playerGold);
        playerExperience = getIntent().getIntExtra("playerExperience", playerExperience);
        TextView confirmExperienceDifference = (TextView) findViewById(R.id.experience_gained);
        confirmExperienceDifference.setText(String.valueOf(playerExperience));
        TextView confirmPlayerGold = (TextView) findViewById(R.id.gold_count);
        confirmPlayerGold.setText(String.valueOf(playerGold));
    }

    public void continueGame(View view){
        Intent confirmIntent = new Intent(levelComplete.this, fight_launcher.class);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }
    }

}
