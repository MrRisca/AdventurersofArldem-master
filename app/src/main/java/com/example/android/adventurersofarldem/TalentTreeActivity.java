package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.adventurersofarldem.Activities.EquipmentActivity;
import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.StatusEffects.StatusEffect;
import com.example.android.adventurersofarldem.Talents.Talent;

import java.util.List;

public class TalentTreeActivity extends AppCompatActivity {


    public int maxTalentsSize = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talent_tree);
        TextView playerStrength = findViewById(R.id.playerStrength);
        TextView playerIntellect = findViewById(R.id.playerIntellect);
        String playerClass = Player.getInstance().getCharacterClass();
        List<Talent> allTalents = Player.getInstance().getAllTalents();
            for (int numberOfTalents = 0; numberOfTalents < allTalents.size(); numberOfTalents++) {
                if (allTalents.get(numberOfTalents).getAvailableClass().equals(playerClass) && allTalents.get(numberOfTalents).getMinimumLevel() < (Player.getInstance().getLevel() + 1)){
                    Player.getInstance().getPossibleTalents().add(allTalents.get(numberOfTalents));

            }
        }
        ImageView talentViewOne = findViewById(R.id.selectTalentOne);
        ImageView talentViewTwo = findViewById(R.id.selectTalentTwo);
        talentViewOne.setImageResource(R.drawable.noicon);
        talentViewTwo.setImageResource(R.drawable.noicon);
        playerStrength.setText(String.valueOf(Player.getInstance().getStrength()));
        playerIntellect.setText(String.valueOf(Player.getInstance().getIntellect()));
        Log.d("Start Talents", String.valueOf(Player.getInstance().getPlayerTalents()));
        Log.d("Start ALL Talents", String.valueOf(Player.getInstance().getAllTalents()));
        Log.d("Start Pos Talents", String.valueOf(Player.getInstance().getPossibleTalents()));


        if (allTalents.size() > 0){
            if (Player.getInstance().getPlayerTalents().size() > 0) {
                if (Player.getInstance().getPlayerTalents().contains(Player.getInstance().getPossibleTalents().get(0))) {
                    talentViewOne.setImageResource(Player.getInstance().getPossibleTalents().get(0).confPath);
                }
            }
            else {
            talentViewOne.setImageResource(Player.getInstance().getPossibleTalents().get(0).iconPath);}
        }
        if (allTalents.size() > 1){
            if (Player.getInstance().getPlayerTalents().size() > 0) {
                if (Player.getInstance().getPlayerTalents().contains(Player.getInstance().getPossibleTalents().get(1))) {
                    talentViewOne.setImageResource(Player.getInstance().getPossibleTalents().get(1).confPath);
                }
            }
                talentViewTwo.setImageResource(Player.getInstance().getPossibleTalents().get(1).iconPath);
        }
    }

    public void updateStats(){
        TextView playerStrength = findViewById(R.id.playerStrength);
        TextView playerIntellect = findViewById(R.id.playerIntellect);
        playerStrength.setText(String.valueOf(Player.getInstance().getStrength()));
        playerIntellect.setText(String.valueOf(Player.getInstance().getIntellect()));
    }

    public void playerSelectedOne(View view) {
        Log.d("Pos Talents", String.valueOf(Player.getInstance().getPossibleTalents()));
            if (!Player.getInstance().getPlayerTalents().contains(Player.getInstance().getPossibleTalents().get(0))) {
                if (Player.getInstance().getPlayerTalents().size() < maxTalentsSize) {
                    Player.getInstance().addToPlayerTalents(Player.getInstance().getPossibleTalents().get(0));
                    Player.getInstance().getPossibleTalents().get(0).addPassiveEffect();
                    ImageView talentViewOne = findViewById(R.id.selectTalentOne);
                    talentViewOne.setImageResource(Player.getInstance().getPossibleTalents().get(0).confPath);
                    Log.d("Player Talents ", String.valueOf(Player.getInstance().getPlayerTalents()));
                }
            }
            else {
                Player.getInstance().removeFromPlayerTalents(Player.getInstance().getPossibleTalents().get(0));
                Player.getInstance().getPossibleTalents().get(0).removePassiveEffect();
                ImageView talentViewOne = findViewById(R.id.selectTalentOne);
                talentViewOne.setImageResource(Player.getInstance().getPossibleTalents().get(0).iconPath);
                Log.d("Player Talents AR", String.valueOf(Player.getInstance().getPlayerTalents()));
            }
            updateStats();

    }

    public void playerSelectedTwo(View view){
        Log.d("Pos Talents", String.valueOf(Player.getInstance().getPossibleTalents()));
            if (!Player.getInstance().getPlayerTalents().contains(Player.getInstance().getPossibleTalents().get(1))) {
                if (Player.getInstance().getPlayerTalents().size() < maxTalentsSize) {
                    Player.getInstance().addToPlayerTalents(Player.getInstance().getPossibleTalents().get(1));
                    Player.getInstance().getPossibleTalents().get(1).addPassiveEffect();
                    ImageView talentViewTwo = findViewById(R.id.selectTalentTwo);
                    talentViewTwo.setImageResource(Player.getInstance().getPossibleTalents().get(1).confPath);
                    Log.d("Player Talents ", String.valueOf(Player.getInstance().getPlayerTalents()));

                }
            }else {
                Player.getInstance().removeFromPlayerTalents(Player.getInstance().getPossibleTalents().get(1));
                Player.getInstance().getPossibleTalents().get(1).removePassiveEffect();
                ImageView talentViewTwo = findViewById(R.id.selectTalentTwo);
                talentViewTwo.setImageResource(Player.getInstance().getPossibleTalents().get(1).iconPath);
                Log.d("Player Talents AR", String.valueOf(Player.getInstance().getPlayerTalents()));

            }
            updateStats();

    }

    public void submitTalents(View view){
        Intent confirmIntent = new Intent(TalentTreeActivity.this, fight_launcher.class);

        Button button = findViewById(R.id.confirm);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(myAnim);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }

    }
    }

