package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CharacterSelection extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_selection);

        mButton = (Button) findViewById(R.id.confirm);

    }

    Button mButton;
    String playerClass = "";
    int playerSt = 0;
    int playerAg = 0;
    int playerIn = 0;
    int playerMHP = 0;
    int playerCHP = 0;
    int playerMMP = 0;
    int playerCMP = 0;


    public void submitPlayer(View view){
        EditText pName = (EditText) findViewById(R.id.addName);
        String playerName = pName.getText().toString();
        Intent confirmIntent = new Intent(CharacterSelection.this, StatChoice.class);
        confirmIntent.putExtra("playerName", playerName);
        confirmIntent.putExtra("playerClass", playerClass);
        confirmIntent.putExtra("playerSt", playerSt);
        confirmIntent.putExtra("playerAg", playerAg);
        confirmIntent.putExtra("playerIn", playerIn);
        confirmIntent.putExtra("playerMHP", playerMHP);
        confirmIntent.putExtra("playerCHP", playerCHP);
        confirmIntent.putExtra("playerMMP", playerMMP);
        confirmIntent.putExtra("playerCMP", playerCMP);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent);
    }}


    public void playerSelectedWizard(View view){
        ImageView wizardClass;
            wizardClass = (ImageView) findViewById(R.id.Wizard);
            wizardClass.setImageResource(R.drawable.wizardyes);

        ImageView rangerClass;
            rangerClass = (ImageView) findViewById(R.id.Ranger);
            rangerClass.setImageResource(R.drawable.ranger);

        ImageView warriorClass;
            warriorClass = (ImageView) findViewById(R.id.Warrior);
            warriorClass.setImageResource(R.drawable.warrior);

        //playerName = findViewById(R.id.addName).getText();

    }

    public void playerSelectedWarrior(View view) {
        ImageView wizardClass;
            wizardClass = (ImageView) findViewById(R.id.Wizard);
            wizardClass.setImageResource(R.drawable.wizard);

        ImageView rangerClass;
            rangerClass = (ImageView) findViewById(R.id.Ranger);
            rangerClass.setImageResource(R.drawable.ranger);

        ImageView warriorClass;
            warriorClass = (ImageView) findViewById(R.id.Warrior);
            warriorClass.setImageResource(R.drawable.warrioryes);

        playerClass = "Warrior";
        playerSt = 12;
        playerAg = 8;
        playerIn = 8;
        playerMHP = 8;
        playerCHP = 8;
        playerMMP = 4;
        playerCMP = 4;
    }

    public void playerSelectedRanger(View view){
        ImageView wizardClass;
            wizardClass = (ImageView) findViewById(R.id.Wizard);
            wizardClass.setImageResource(R.drawable.wizard);

        ImageView rangerClass;
            rangerClass = (ImageView) findViewById(R.id.Ranger);
            rangerClass.setImageResource(R.drawable.rangeryes);

        ImageView warriorClass;
            warriorClass = (ImageView) findViewById(R.id.Warrior);
            warriorClass.setImageResource(R.drawable.warrior);
    }
}

