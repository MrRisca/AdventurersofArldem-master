package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class spellSelectActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public Spinner spellSpinner1;
    public Spinner spellSpinner2;
    public Spinner spellSpinner3;
    public Spinner spellSpinner4;
    public String spellSelected1;
    public String spellSelected2;
    public String spellSelected3;
    public String spellSelected4;
    public String playerName;
    public String playerClass;
    public int playerStrength;
    public int playerAgility;
    public int playerIntellect;
    public int playerMaxHP;
    public int playerMaxMP;
    public int playerCurrentMP;
    public int playerCurrentHP;
    public int pArmorClass;
    public int playerExperience;
    public int playerLevel;
    public int levelComplete = 0;
    public int playerGold;
    public ArrayList<String> spellList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell_select);
        playerName = getIntent().getStringExtra("playerName");
        playerClass = getIntent().getStringExtra("playerClass");
        playerStrength = getIntent().getIntExtra("playerStrength", 0);
        playerAgility = getIntent().getIntExtra("playerAgility", 0);
        playerIntellect = getIntent().getIntExtra("playerIntellect", 0);
        playerMaxHP = getIntent().getIntExtra("playerMaxHP", 0);
        playerMaxMP = getIntent().getIntExtra("playerMaxMP",0);
        playerCurrentHP = getIntent().getIntExtra("playerCurrentHP", 0);
        playerCurrentMP = getIntent().getIntExtra("playerCurrentMP", 0);
        pArmorClass  = ((10 +(playerAgility / 2)) - 5);
        playerExperience = getIntent().getIntExtra("playerExperience", 0);
        playerLevel = getIntent().getIntExtra("playerLevel", 0);
        playerGold = getIntent().getIntExtra("playerGold", playerGold);
        spellList = getIntent().getStringArrayListExtra("spellList");

        Spinner spellSpinner1 = findViewById(R.id.spell1);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spells_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spellSpinner1.setAdapter(adapter);

        spellSpinner1.setOnItemSelectedListener(this);

//        Singleton.INSTANCE.playerSpellList.set(0, spellSelected1);


        Spinner spellSpinner2 = findViewById(R.id.spell2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.spells_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spellSpinner2.setAdapter(adapter2);

        spellSpinner2.setOnItemSelectedListener(this);

//        Singleton.INSTANCE.playerSpellList.set(1, spellSelected2);




        Spinner spellSpinner3 = findViewById(R.id.spell3);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.spells_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spellSpinner3.setAdapter(adapter3);

        spellSpinner3.setOnItemSelectedListener(this);

//        Singleton.INSTANCE.playerSpellList.set(2, spellSelected3);



        Spinner spellSpinner4 = findViewById(R.id.spell4);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.spells_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spellSpinner4.setAdapter(adapter4);

        spellSpinner4.setOnItemSelectedListener(this);

//        Singleton.INSTANCE.playerSpellList.set(3, spellSelected4);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (spellSpinner1 != null) {
            spellSpinner1.setOnItemSelectedListener(this);
            spellSelected1 = spellSpinner1.getSelectedItem().toString();
            spellList.set(0, spellSelected1);


        }
        if (spellSpinner2 != null) {
            spellSpinner2.setOnItemSelectedListener(this);
            spellSelected2 = spellSpinner2.getSelectedItem().toString();
            spellList.set(1, spellSelected2);


        }
        if (spellSpinner3 != null) {
            spellSpinner3.setOnItemSelectedListener(this);
            spellSelected3 = spellSpinner3.getSelectedItem().toString();
            spellList.set(2, spellSelected3);


        }
        if (spellSpinner4 != null) {
            spellSpinner4.setOnItemSelectedListener(this);
            spellSelected4 = spellSpinner4.getSelectedItem().toString();
            spellList.set(3, spellSelected4);


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveSpells(View view){

        Intent confirmIntent = new Intent(spellSelectActivity.this, fight_launcher.class);

        Button button = (Button)findViewById(R.id.saveSpells);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(myAnim);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        confirmIntent.putExtra("playerStrength", playerStrength);
        confirmIntent.putExtra("playerAgility", playerAgility);
        confirmIntent.putExtra("playerIntellect", playerIntellect);
        confirmIntent.putExtra("playerMaxHP", playerMaxHP);
        confirmIntent.putExtra("playerMaxMP", playerMaxMP);
        confirmIntent.putExtra("playerCurrentHP", playerCurrentHP);
        confirmIntent.putExtra("playerCurrentMP", playerCurrentMP);
        confirmIntent.putExtra("playerClass", playerClass);
        confirmIntent.putExtra("playerName", playerName);
        confirmIntent.putExtra("playerExperience", playerExperience);
        confirmIntent.putExtra("playerLevel", playerLevel);
        confirmIntent.putExtra("playerGold", playerGold);
        confirmIntent.putStringArrayListExtra("spellList", spellList);
        button.startAnimation(myAnim);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }
    }

}
