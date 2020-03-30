package com.example.android.adventurersofarldem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

import com.example.android.adventurersofarldem.Characters.Player;


public class StatChoice extends AppCompatActivity {

    public int minStrength;
    public int minAgility;
    public int minIntellect;
    public int minMaxHP;
    public int minMaxMP;


    // Imports the characters existing stats which will be based on their class chosen, and then
    // converts these into local variables to be edited by the methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat_choice);
        minStrength = Player.getInstance().getStrength();
        minAgility = Player.getInstance().getAgility();
        minIntellect = Player.getInstance().getIntellect();
        minMaxHP = Player.getInstance().getMaximumHealth();
        minMaxMP = Player.getInstance().getMaximumMana();
        statsDisplay(Player.getInstance().getAvailablePoints());
        strengthDisplay(Player.getInstance().getStrength());
        agilityDisplay(Player.getInstance().getAgility());
        intellectDisplay(Player.getInstance().getIntellect());
        maxHPDisplay(Player.getInstance().getMaximumHealth());
        maxMPDisplay(Player.getInstance().getMaximumMana());

    }

    //Submits updated stats and existing name and class to the confirmation intent

    public void submitStats(View view) {

        Intent confirmIntent = new Intent(StatChoice.this, fight_launcher.class);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }


    }

    //statsDisplay shows how many stats the user has remaining to use. Currently they don't have
    // to use any or all of them, this will be updated at later time.

    public void statsDisplay(int stat) {
        TextView statDisplay = (TextView) findViewById(R.id.statCounter);
        statDisplay.setText(String.valueOf(stat));
    }

    //strengthDisplay updates the number in between the two buttons to show the value of Strength

    public void strengthDisplay(int stat) {
        TextView strengthView = (TextView) findViewById(R.id.strength_number);
        strengthView.setText(String.valueOf(stat));
    }

    //increaseStrength checks if there are stats available, gives +1 to strength and takes an
    // available stat away.

    public void increaseStrength(View view) {
        if (Player.getInstance().getAvailablePoints() > 0) {
            Player.getInstance().setStrength(Player.getInstance().getStrength() + 1);
            Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() - 1);
            strengthDisplay(Player.getInstance().getStrength());
            statsDisplay(Player.getInstance().getAvailablePoints());
        }
    }

    //decreaseStrength checks if the use has less than 6 (the max stats available on creation)
    // stats available, and if so will reduce strength by 1 and increase the number of stats
    // available by 1

    public void decreaseStrength(View view) {
        if (Player.getInstance().getStrength() > minStrength) {

            if (Player.getInstance().getAvailablePoints() < 6) {

                Player.getInstance().setStrength(Player.getInstance().getStrength() - 1);
                Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() + 1);

                strengthDisplay(Player.getInstance().getStrength());
                statsDisplay(Player.getInstance().getAvailablePoints());
            }
        }
    }

    //The above commands are then replicated below but for the different stats to be changed

    public void agilityDisplay(int stat) {
        TextView agilityView = (TextView) findViewById(R.id.agility_number);
        agilityView.setText(String.valueOf(stat));
    }

    public void increaseAgility(View view) {
        if (Player.getInstance().getAvailablePoints() > 0) {

            Player.getInstance().setAgility(Player.getInstance().getAgility() + 1);
            Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() - 1);
            agilityDisplay(Player.getInstance().getAgility());
            statsDisplay(Player.getInstance().getAvailablePoints());
        }
    }

    public void decreaseAgility(View view) {
        if (Player.getInstance().getAgility() > minAgility) {
            if (Player.getInstance().getAvailablePoints() < 6) {
                Player.getInstance().setAgility(Player.getInstance().getAgility() - 1);
                Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() + 1);
                agilityDisplay(Player.getInstance().getAgility());
                statsDisplay(Player.getInstance().getAvailablePoints());
            }
        }
    }

    public void intellectDisplay(int stat) {
        TextView intellectView = (TextView) findViewById(R.id.intellect_number);
        intellectView.setText(String.valueOf(stat));
    }

    public void increaseIntellect(View view) {
        if (Player.getInstance().getAvailablePoints() > 0) {

            Player.getInstance().setIntellect(Player.getInstance().getIntellect() + 1);
            Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() - 1);
            intellectDisplay(Player.getInstance().getIntellect());
            statsDisplay(Player.getInstance().getAvailablePoints());
        }
    }

    public void decreaseIntellect(View view) {
        if (Player.getInstance().getIntellect() > minIntellect) {
            if (Player.getInstance().getAvailablePoints() < 6) {
                Player.getInstance().setIntellect(Player.getInstance().getIntellect() - 1);
                Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() + 1);
                intellectDisplay(Player.getInstance().getIntellect());
                statsDisplay(Player.getInstance().getAvailablePoints());
            }
        }
    }

    public void maxHPDisplay(int stat) {
        TextView maxHPView = (TextView) findViewById(R.id.hp_number);
        maxHPView.setText(String.valueOf(stat));
    }

    public void increaseHP(View view) {
        if (Player.getInstance().getAvailablePoints() > 0) {

            Player.getInstance().setMaximumHealth(Player.getInstance().getMaximumHealth() + 5);
            Player.getInstance().setCurrentHealth(Player.getInstance().getCurrentHealth() + 5);
            Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() - 1);
            maxHPDisplay(Player.getInstance().getMaximumHealth());
            statsDisplay(Player.getInstance().getAvailablePoints());
        }
    }

    public void decreaseHP(View view) {
        if (Player.getInstance().getMaximumHealth() - 5 > minMaxHP) {
            if (Player.getInstance().getAvailablePoints() < 6) {
                Player.getInstance().setMaximumHealth(Player.getInstance().getMaximumHealth() - 5);
                Player.getInstance().setCurrentHealth(Player.getInstance().getCurrentHealth() - 5);
                Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() + 1);

                maxHPDisplay(Player.getInstance().getMaximumHealth());
            }
            statsDisplay(Player.getInstance().getAvailablePoints());
        }
    }

    public void maxMPDisplay(int stat) {
        TextView maxMPView = (TextView) findViewById(R.id.mp_number);
        maxMPView.setText(String.valueOf(stat));
    }

    public void increaseMP(View view) {
        if (Player.getInstance().getAvailablePoints() > 0) {

            Player.getInstance().setMaximumMana(Player.getInstance().getMaximumMana() + 10);
            Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() - 1);
            maxMPDisplay(Player.getInstance().getMaximumMana());
            statsDisplay(Player.getInstance().getAvailablePoints());
        }
    }

    public void decreaseMP(View view) {
        if (Player.getInstance().getMaximumMana() > minMaxMP) {
            if (Player.getInstance().getAvailablePoints() < 6) {
                Player.getInstance().setMaximumMana(Player.getInstance().getMaximumMana() - 1);
                Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() + 1);
                maxMPDisplay(Player.getInstance().getMaximumMana());
                statsDisplay(Player.getInstance().getAvailablePoints());
            }
        }
    }
}




