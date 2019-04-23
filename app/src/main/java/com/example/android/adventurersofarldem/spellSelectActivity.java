package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class spellSelectActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spellSpinner1;
    private Spinner spellSpinner2;
    private Spinner spellSpinner3;
    private Spinner spellSpinner4;
    private String spellSelected1;
    private String spellSelected2;
    private String spellSelected3;
    private String spellSelected4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell_select);

        Spinner spellSpinner1 = findViewById(R.id.spell1);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spells_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spellSpinner1.setAdapter(adapter);

        spellSpinner1.setOnItemSelectedListener(this);

        String spellSelected1 = spellSpinner1.getSelectedItem().toString();

        Spinner spellSpinner2 = findViewById(R.id.spell2);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.spells_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spellSpinner2.setAdapter(adapter2);

        spellSpinner2.setOnItemSelectedListener(this);

        String spellSelected2 = spellSpinner2.getSelectedItem().toString();

        Spinner spellSpinner3 = findViewById(R.id.spell3);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.spells_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spellSpinner3.setAdapter(adapter3);

        spellSpinner3.setOnItemSelectedListener(this);

        String spellSelected3 = spellSpinner3.getSelectedItem().toString();

        Spinner spellSpinner4 = findViewById(R.id.spell4);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.spells_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spellSpinner4.setAdapter(adapter4);

        spellSpinner4.setOnItemSelectedListener(this);

        String spellSelected4 = spellSpinner4.getSelectedItem().toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
