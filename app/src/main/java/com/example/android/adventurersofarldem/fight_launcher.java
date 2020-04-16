package com.example.android.adventurersofarldem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.android.adventurersofarldem.Activities.EquipmentActivity;
import com.example.android.adventurersofarldem.Characters.Monster;
import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.Quests.ExploreTheMine.ExploreTheMinePartTwoActivity;
import com.example.android.adventurersofarldem.Quests.SlayTheBigRatQuests.SlayTheBigRatPartOneActivity;
import com.example.android.adventurersofarldem.Quests.SlayTheLich.SlayTheLichActivity;

import java.util.ArrayList;


public class fight_launcher extends AppCompatActivity {

    public ArrayList<String> spellList;
    public String playerLocation = "Fo";
    public String playerLocationGoNorth = "Fo";
    public String playerLocationGoEast = "Fo";
    public String playerLocationGoSouth = "Fo";
    public String playerLocationGoWest = "Fo";
    public int posX;
    public int posY;
    public WorldMapClass theWorld;
    public monsterTableClass foundMonster;
    public Monster monsterType;
    public ArrayList<String> monsterTypeArray = null;
    String currentMonster;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_launcher);
        theWorld = new WorldMapClass();
        playerLocation = theWorld.worldMap[Player.getInstance().getPosX()][Player.getInstance().getPosY()];
        System.out.println("OLI " + playerLocation);
        spellList = getIntent().getStringArrayListExtra("spellList");
        TextView confirmPlayerGold = findViewById(R.id.playerGold);
        confirmPlayerGold.setText(String.valueOf(Player.getInstance().getGold()));



        TextView confirmPlayerMaxHP = findViewById(R.id.playerMaxHealth);
        confirmPlayerMaxHP.setText(String.valueOf(Player.getInstance().getMaximumHealth()));

        TextView confirmPlayerCurrentHP = findViewById(R.id.playerCurrentHealth);
        confirmPlayerCurrentHP.setText(String.valueOf(Player.getInstance().getCurrentHealth()));

        TextView confirmPlayerMaxMP = findViewById(R.id.playerMaxMana);
        confirmPlayerMaxMP.setText(String.valueOf(Player.getInstance().getMaximumMana()));

        TextView confirmPlayerCurrentMP = findViewById(R.id.playerCurrentMana);
        confirmPlayerCurrentMP.setText(String.valueOf(Player.getInstance().getCurrentMana()));



        TextView confirmPlayerLevel = findViewById(R.id.playerLevel);
        confirmPlayerLevel.setText(String.valueOf(Player.getInstance().getLevel()));

        TextView playerXPos = findViewById(R.id.playerXPos);
        playerXPos.setText(String.valueOf(Player.getInstance().getPosX()));

        TextView playerYPos = findViewById(R.id.playerYPos);
        playerYPos.setText(String.valueOf(Player.getInstance().getPosY()));
        updateAllSceneryDirections();
    }

    public void refreshStats(){
        TextView confirmPlayerGold = findViewById(R.id.playerGold);
        confirmPlayerGold.setText(String.valueOf(Player.getInstance().getGold()));

        TextView confirmPlayerAgility = findViewById(R.id.playerCurrentAgility);
        confirmPlayerAgility.setText(String.valueOf(Player.getInstance().getAgility()));


        TextView confirmPlayerStrength = findViewById(R.id.playerCurrentStrength);
        confirmPlayerStrength.setText(String.valueOf(Player.getInstance().getStrength()));

        //Set final TextView to have the goblin's current health.
        TextView confirmPlayerIntellect = findViewById(R.id.playerCurrentIntellect);
        confirmPlayerIntellect.setText(String.valueOf(Player.getInstance().getIntellect()));

        TextView confirmPlayerMaxHP = findViewById(R.id.playerMaxHealth);
        confirmPlayerMaxHP.setText(String.valueOf(Player.getInstance().getMaximumHealth()));

        TextView confirmPlayerCurrentHP = findViewById(R.id.playerCurrentHealth);
        confirmPlayerCurrentHP.setText(String.valueOf(Player.getInstance().getCurrentHealth()));

        TextView confirmPlayerMaxMP = findViewById(R.id.playerMaxMana);
        confirmPlayerMaxMP.setText(String.valueOf(Player.getInstance().getMaximumMana()));

        TextView confirmPlayerCurrentMP = findViewById(R.id.playerCurrentMana);
        confirmPlayerCurrentMP.setText(String.valueOf(Player.getInstance().getCurrentMana()));

        TextView confirmPlayerArmorClass = findViewById(R.id.playerCurrentArmor);
        confirmPlayerArmorClass.setText(String.valueOf(Player.getInstance().getArmorClass()));

        TextView confirmPlayerLevel = findViewById(R.id.playerLevel);
        confirmPlayerLevel.setText(String.valueOf(Player.getInstance().getLevel()));

        TextView playerXPos = findViewById(R.id.playerXPos);
        playerXPos.setText(String.valueOf(Player.getInstance().getPosX()));

        TextView playerYPos = findViewById(R.id.playerYPos);
        playerYPos.setText(String.valueOf(Player.getInstance().getPosY()));
    }


    public void heal(View view){
        if (Player.getInstance().getGold() > 2){
            Player.getInstance().setCurrentHealth(Player.getInstance().getMaximumHealth());
            Player.getInstance().setCurrentMana(Player.getInstance().getMaximumMana());
            Player.getInstance().setGold(Player.getInstance().getGold() - 3);
            refreshStats();
            TextView status = findViewById(R.id.status);
            status.setText("You have healed to full health for 3 GP");
        }
        else {
            TextView status = findViewById(R.id.status);
            status.setText("You don't have enough gold");
        }

    }

    public void addFiveHealth(View view){
        if (Player.getInstance().getGold() > 4){
            Player.getInstance().setCurrentHealth(Player.getInstance().getCurrentHealth() + 5);
            Player.getInstance().setMaximumHealth(Player.getInstance().getMaximumHealth() + 5);
            Player.getInstance().setGold(Player.getInstance().getGold() - 5);
            refreshStats();
            TextView status = findViewById(R.id.status);
            status.setText("You have gained 5 HP");
        }
        else {
            TextView status = findViewById(R.id.status);
            status.setText("You don't have enough gold");

        }
    }

    public void addTenHealth(View view){
        if (Player.getInstance().getGold() > 7) {
            Player.getInstance().setCurrentHealth(Player.getInstance().getCurrentHealth() + 10);
            Player.getInstance().setMaximumHealth(Player.getInstance().getMaximumHealth() + 10);
            Player.getInstance().setGold(Player.getInstance().getGold() - 8);
            refreshStats();
            TextView status = findViewById(R.id.status);
            status.setText("You have gained 10 HP");
        }
        else {
            TextView status = findViewById(R.id.status);
            status.setText("You don't have enough gold");

        }
    }

    public void addOneStrength(View view){
        if (Player.getInstance().getGold() > 9){
            Player.getInstance().setStrength(Player.getInstance().getStrength() + 1);
            Player.getInstance().setGold(Player.getInstance().getGold() - 10);
            refreshStats();
            TextView status = findViewById(R.id.status);
            status.setText("You have gained 1 STR");
        }
        else {
            TextView status = findViewById(R.id.status);
            status.setText("You don't have enough gold");

        }
    }

    public void addOneAgility(View view){
        if (Player.getInstance().getGold() > 9){
            Player.getInstance().setAgility(Player.getInstance().getAgility() + 1);
            Player.getInstance().setGold(Player.getInstance().getGold() - 10);
            refreshStats();
            TextView status = findViewById(R.id.status);
            status.setText("You have gained 1 AGI");
        }
        else {
            TextView status = findViewById(R.id.status);
            status.setText("You don't have enough gold");

        }
    }

    public void addOneIntellect(View view){
        if (Player.getInstance().getGold() > 9){
            Player.getInstance().setIntellect(Player.getInstance().getIntellect() + 1);
            Player.getInstance().setGold(Player.getInstance().getGold() - 10);
            refreshStats();
            TextView status = findViewById(R.id.status);
            status.setText("You have gained 1 INT");
        }
        else {
            TextView status = findViewById(R.id.status);
            status.setText("You don't have enough gold");

        }
    }

    public void goWest(View view){
        updateScenery(view);
        if (Player.getInstance().getPosY() > 0){
            Player.getInstance().setPosY(Player.getInstance().getPosY() - 1);
            TextView playerXPos = findViewById(R.id.playerXPos);
            playerXPos.setText(String.valueOf(Player.getInstance().getPosX()));

            TextView playerYPos = findViewById(R.id.playerYPos);
            playerYPos.setText(String.valueOf(Player.getInstance().getPosY()));
        }
        updateScenery(view);
        Log.d("Loc", playerLocation);
    }

    public void goEast(View view) {
        updateScenery(view);
        if (Player.getInstance().getPosY() < 35) {
            Player.getInstance().setPosY(Player.getInstance().getPosY() + 1);
            TextView playerXPos = findViewById(R.id.playerXPos);
            playerXPos.setText(String.valueOf(Player.getInstance().getPosX()));

            TextView playerYPos = findViewById(R.id.playerYPos);
            playerYPos.setText(String.valueOf(Player.getInstance().getPosY()));
        }
        updateScenery(view);
        Log.d("Loc", playerLocation);
    }

    public void goSouth(View view){
        updateScenery(view);
        if (Player.getInstance().getPosX() < 35) {
            Player.getInstance().setPosX(Player.getInstance().getPosX() + 1);
            TextView playerXPos = findViewById(R.id.playerXPos);
            playerXPos.setText(String.valueOf(Player.getInstance().getPosX()));

            TextView playerYPos = findViewById(R.id.playerYPos);
            playerYPos.setText(String.valueOf(Player.getInstance().getPosY()));
        }
        updateScenery(view);
        Log.d("Loc", playerLocation);
    }

    public void goNorth(View view){
        updateScenery(view);
        if (Player.getInstance().getPosX() > 0) {
            Player.getInstance().setPosX(Player.getInstance().getPosX() - 1);
            TextView playerXPos = findViewById(R.id.playerXPos);
            playerXPos.setText(String.valueOf(Player.getInstance().getPosX()));

            TextView playerYPos = findViewById(R.id.playerYPos);
            playerYPos.setText(String.valueOf(Player.getInstance().getPosY()));
        }
        updateScenery(view);
        Log.d("Loc", playerLocation);
    }

    public Monster monsterTypeSelected(){
        int typeOfLocation;
        if (playerLocation.equals("To")) {
            typeOfLocation = 0;
        }
        else if (playerLocation.equals("Fo"))
            typeOfLocation = 1;
        else if (playerLocation.equals("Fa"))
            typeOfLocation = 2;
        else if (playerLocation.equals("Mo"))
            typeOfLocation = 3;
        else if (playerLocation.equals("De"))
            typeOfLocation = 4;
        else if (playerLocation.equals("Hi"))
            typeOfLocation = 5;
        else if (playerLocation.equals("Ri"))
            typeOfLocation = 6;
        else if (playerLocation.equals("Ca"))
            typeOfLocation = 7;
        else if (playerLocation.equals("Pl"))
            typeOfLocation = 8;
        else typeOfLocation = 9;

        foundMonster = new monsterTableClass();
        monsterType = foundMonster.monsterTable[typeOfLocation][Player.getInstance().getLevel()];
        return monsterType;

    }

    public void updateScenery(View view){
        playerLocation = theWorld.worldMap[Player.getInstance().getPosX()][Player.getInstance().getPosY()];
        ImageView sceneryView = findViewById(R.id.sceneryImage);
        if (playerLocation.equals("To")) {
            sceneryView.setImageResource(R.drawable.town);
        }
        else if (playerLocation.equals("Fo")){
            sceneryView.setImageResource(R.drawable.forest);
        }
        else if (playerLocation.equals("Fa")){
            sceneryView.setImageResource(R.drawable.farmland);
        }
        else if (playerLocation.equals("Mo")){
            sceneryView.setImageResource(R.drawable.mountains);
        }
        else if (playerLocation.equals("De")){
            sceneryView.setImageResource(R.drawable.desert);
        }
        else if (playerLocation.equals("Hi")){
            sceneryView.setImageResource(R.drawable.hills);
        }
        else if (playerLocation.equals("Ri")){
            sceneryView.setImageResource(R.drawable.river);
        }
        else if (playerLocation.equals("Ca")){
            sceneryView.setImageResource(R.drawable.caves);
        }
        else if (playerLocation.equals("Pl")){
            sceneryView.setImageResource(R.drawable.plains);
        }
        else if (playerLocation.equals("Oc")){
            sceneryView.setImageResource(R.drawable.oceans);
        }
        updateAllSceneryDirections();
    }

    public void updateNavigationSceneryGoNorth(){
        ImageView sceneryViewGoNorth = findViewById(R.id.northScene);
        ImageView sceneryViewGoEast = findViewById(R.id.eastScene);
        ImageView sceneryViewGoSouth = findViewById(R.id.southScene);
        ImageView sceneryViewGoWest = findViewById(R.id.westScene);
        if (Player.getInstance().getPosX() > 0) {
            playerLocationGoNorth = theWorld.worldMap[Player.getInstance().getPosX() - 1][Player.getInstance().getPosY()];
            if (playerLocationGoNorth .equals("To")) {
                sceneryViewGoNorth.setImageResource(R.drawable.town);
            }
            else if (playerLocationGoNorth .equals("Fo")){
                sceneryViewGoNorth.setImageResource(R.drawable.forest);
            }
            else if (playerLocationGoNorth .equals("Fa")){
                sceneryViewGoNorth.setImageResource(R.drawable.farmland);
            }
            else if (playerLocationGoNorth .equals("Mo")){
                sceneryViewGoNorth.setImageResource(R.drawable.mountains);
            }
            else if (playerLocationGoNorth .equals("De")){
                sceneryViewGoNorth.setImageResource(R.drawable.desert);
            }
            else if (playerLocationGoNorth .equals("Hi")){
                sceneryViewGoNorth.setImageResource(R.drawable.hills);
            }
            else if (playerLocationGoNorth .equals("Ri")){
                sceneryViewGoNorth.setImageResource(R.drawable.river);
            }
            else if (playerLocationGoNorth .equals("Ca")){
                sceneryViewGoNorth.setImageResource(R.drawable.caves);
            }
            else if (playerLocationGoNorth .equals("Pl")){
                sceneryViewGoNorth.setImageResource(R.drawable.plains);
            }
            else if (playerLocationGoNorth .equals("Oc")){
                sceneryViewGoNorth.setImageResource(R.drawable.oceans);
            }
        }
        else {
            sceneryViewGoNorth.setImageResource(R.drawable.noicon);
        }
    }

    public void updateNavigationSceneryGoSouth(){
        ImageView sceneryViewGoSouth = findViewById(R.id.southScene);
        if (Player.getInstance().getPosX() < 35) {
            playerLocationGoSouth = theWorld.worldMap[Player.getInstance().getPosX() + 1][Player.getInstance().getPosY()];
            if (playerLocationGoSouth .equals("To")) {
                sceneryViewGoSouth.setImageResource(R.drawable.town);
            }
            else if (playerLocationGoSouth .equals("Fo")){
                sceneryViewGoSouth.setImageResource(R.drawable.forest);
            }
            else if (playerLocationGoSouth .equals("Fa")){
                sceneryViewGoSouth.setImageResource(R.drawable.farmland);
            }
            else if (playerLocationGoSouth .equals("Mo")){
                sceneryViewGoSouth.setImageResource(R.drawable.mountains);
            }
            else if (playerLocationGoSouth .equals("De")){
                sceneryViewGoSouth.setImageResource(R.drawable.desert);
            }
            else if (playerLocationGoSouth .equals("Hi")){
                sceneryViewGoSouth.setImageResource(R.drawable.hills);
            }
            else if (playerLocationGoSouth .equals("Ri")){
                sceneryViewGoSouth.setImageResource(R.drawable.river);
            }
            else if (playerLocationGoSouth .equals("Ca")){
                sceneryViewGoSouth.setImageResource(R.drawable.caves);
            }
            else if (playerLocationGoSouth .equals("Pl")){
                sceneryViewGoSouth.setImageResource(R.drawable.plains);
            }
            else if (playerLocationGoSouth .equals("Oc")){
                sceneryViewGoSouth.setImageResource(R.drawable.oceans);
            }
        }
        else {
            sceneryViewGoSouth.setImageResource(R.drawable.noicon);
        }
    }

    public void updateNavigationSceneryGoEast(){
        ImageView sceneryViewGoEast = findViewById(R.id.eastScene);
        if (Player.getInstance().getPosY() < 35) {
            playerLocationGoEast = theWorld.worldMap[Player.getInstance().getPosX()][Player.getInstance().getPosY() + 1];
            if (playerLocationGoEast .equals("To")) {
                sceneryViewGoEast.setImageResource(R.drawable.town);
            }
            else if (playerLocationGoEast .equals("Fo")){
                sceneryViewGoEast.setImageResource(R.drawable.forest);
            }
            else if (playerLocationGoEast .equals("Fa")){
                sceneryViewGoEast.setImageResource(R.drawable.farmland);
            }
            else if (playerLocationGoEast .equals("Mo")){
                sceneryViewGoEast.setImageResource(R.drawable.mountains);
            }
            else if (playerLocationGoEast .equals("De")){
                sceneryViewGoEast.setImageResource(R.drawable.desert);
            }
            else if (playerLocationGoEast .equals("Hi")){
                sceneryViewGoEast.setImageResource(R.drawable.hills);
            }
            else if (playerLocationGoEast .equals("Ri")){
                sceneryViewGoEast.setImageResource(R.drawable.river);
            }
            else if (playerLocationGoEast .equals("Ca")){
                sceneryViewGoEast.setImageResource(R.drawable.caves);
            }
            else if (playerLocationGoEast .equals("Pl")){
                sceneryViewGoEast.setImageResource(R.drawable.plains);
            }
            else if (playerLocationGoEast .equals("Oc")){
                sceneryViewGoEast.setImageResource(R.drawable.oceans);
            }
        }
        else {
            sceneryViewGoEast.setImageResource(R.drawable.noicon);
        }
    }


    public void updateNavigationSceneryGoWest(){
        ImageView sceneryViewGoWest = findViewById(R.id.westScene);
        if (Player.getInstance().getPosY() > 0) {
            playerLocationGoWest = theWorld.worldMap[Player.getInstance().getPosX()][Player.getInstance().getPosY() - 1];
            if (playerLocationGoWest .equals("To")) {
                sceneryViewGoWest.setImageResource(R.drawable.town);
            }
            else if (playerLocationGoWest .equals("Fo")){
                sceneryViewGoWest.setImageResource(R.drawable.forest);
            }
            else if (playerLocationGoWest .equals("Fa")){
                sceneryViewGoWest.setImageResource(R.drawable.farmland);
            }
            else if (playerLocationGoWest .equals("Mo")){
                sceneryViewGoWest.setImageResource(R.drawable.mountains);
            }
            else if (playerLocationGoWest .equals("De")){
                sceneryViewGoWest.setImageResource(R.drawable.desert);
            }
            else if (playerLocationGoWest .equals("Hi")){
                sceneryViewGoWest.setImageResource(R.drawable.hills);
            }
            else if (playerLocationGoWest .equals("Ri")){
                sceneryViewGoWest.setImageResource(R.drawable.river);
            }
            else if (playerLocationGoWest .equals("Ca")){
                sceneryViewGoWest.setImageResource(R.drawable.caves);
            }
            else if (playerLocationGoWest .equals("Pl")){
                sceneryViewGoWest.setImageResource(R.drawable.plains);
            }
            else if (playerLocationGoWest .equals("Oc")){
                sceneryViewGoWest.setImageResource(R.drawable.oceans);
            }
        }
        else {
            sceneryViewGoWest.setImageResource(R.drawable.noicon);
        }
    }


    public void updateAllSceneryDirections(){
        updateNavigationSceneryGoEast();
        updateNavigationSceneryGoNorth();
        updateNavigationSceneryGoWest();
        updateNavigationSceneryGoSouth();
    }

    public void fightEnemy(View view){
        monsterTypeSelected();
        Player.getInstance().setNextEnemy(monsterType);
        Intent confirmIntent = new Intent(fight_launcher.this, level1Activity.class);

        Button button = findViewById(R.id.find_enemy_button);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(myAnim);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }
    }

    public void openInventory(View view){
        Intent confirmIntent = new Intent(fight_launcher.this, EquipmentActivity.class);

        Button button = findViewById(R.id.bag_button);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(myAnim);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }

    }

    public void changeTalents(View view){
        Intent confirmIntent = new Intent(fight_launcher.this, TalentTreeActivity.class);

        Button button = findViewById(R.id.change_talents_button);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(myAnim);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }

    }

    public void launchQuest(View view){
        Intent confirmIntent = new Intent(fight_launcher.this, SlayTheLichActivity.class);

        Button button = findViewById(R.id.change_talents_button);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        button.startAnimation(myAnim);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }

    }



    public void StatChoiceSelected(View view){
        Intent confirmIntent = new Intent(fight_launcher.this, StatChoice.class);
        if (confirmIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(confirmIntent); }
        }
    }


