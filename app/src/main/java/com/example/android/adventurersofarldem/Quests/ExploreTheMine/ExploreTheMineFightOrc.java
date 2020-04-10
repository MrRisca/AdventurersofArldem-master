package com.example.android.adventurersofarldem.Quests.ExploreTheMine;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.adventurersofarldem.Abilities.Ability;
import com.example.android.adventurersofarldem.Abilities.MeleeStrike;
import com.example.android.adventurersofarldem.Characters.Goblin;
import com.example.android.adventurersofarldem.Characters.Monster;
import com.example.android.adventurersofarldem.Characters.Orc;
import com.example.android.adventurersofarldem.Characters.Player;
import com.example.android.adventurersofarldem.R;
import com.example.android.adventurersofarldem.RollDice;
import com.example.android.adventurersofarldem.StatusEffects.StatusEffect;
import com.example.android.adventurersofarldem.levelUp;
import com.example.android.adventurersofarldem.youDead;

import java.util.List;
import java.util.Random;

public class ExploreTheMineFightOrc extends Fragment {

    public int levelComplete = 0;


    public int playerOldExperience;
    public int playerNewExperience;
    public int playerOldGold;
    public int playerNewGold;
    public int playerOldLevel;
    List<Ability> spellList = Player.getInstance().getSpellList();
    private Monster monster = new Orc();
    private View view;

    public ExploreTheMineFightOrc() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_explore_the_mine_fight_orc, container, false);

        Button exitFragment = (Button)view.findViewById(R.id.completeLevel);
        exitFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endLevel();
                //getFragmentManager().beginTransaction().remove(ExploreTheMineFightGoblin.this).commit();
                //getActivity().finish();
            }

        });

        Button spell1Button = (Button)view.findViewById(R.id.playerSpell1);
        spell1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackOne();
                //getFragmentManager().beginTransaction().remove(ExploreTheMineFightGoblin.this).commit();
                //getActivity().finish();
            }

        });

        Button spell2Button = (Button)view.findViewById(R.id.playerSpell2);
        spell2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackTwo();
                //getFragmentManager().beginTransaction().remove(ExploreTheMineFightGoblin.this).commit();
                //getActivity().finish();
            }

        });

        Button spell3Button = (Button)view.findViewById(R.id.playerSpell3);
        spell3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackThree();
                //getFragmentManager().beginTransaction().remove(ExploreTheMineFightGoblin.this).commit();
                //getActivity().finish();
            }

        });

        Button spell4Button = (Button)view.findViewById(R.id.playerSpell4);
        spell4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackFour();
                //getFragmentManager().beginTransaction().remove(ExploreTheMineFightGoblin.this).commit();
                //getActivity().finish();
            }

        });

        playerOldExperience = Player.getInstance().getExperience();
        playerOldGold = Player.getInstance().getGold();
        playerOldLevel = Player.getInstance().getLevel();

        //Import the Player's name, class and stats from where they just entered them


        TextView confirmEnemyType = view.findViewById(R.id.Enemy);
        confirmEnemyType.setText(String.valueOf(monster.getCharacterName()));


        //Create strings of the player information and monster information to make sure it's correct in testing.

        TextView confirmPlayerAgility = view.findViewById(R.id.playerCurrentAgility);
        confirmPlayerAgility.setText(String.valueOf(Player.getInstance().getAgility()));


        TextView confirmPlayerStrength = view.findViewById(R.id.playerCurrentStrength);
        confirmPlayerStrength.setText(String.valueOf(Player.getInstance().getStrength()));

        TextView confirmPlayerIntellect = view.findViewById(R.id.playerCurrentIntellect);
        confirmPlayerIntellect.setText(String.valueOf(Player.getInstance().getIntellect()));

        TextView confirmPlayerMaxHP = view.findViewById(R.id.playerMaxHealth);
        confirmPlayerMaxHP.setText(String.valueOf(Player.getInstance().getMaximumHealth()));

        TextView confirmPlayerCurrentHP = view.findViewById(R.id.playerCurrentHealth);
        confirmPlayerCurrentHP.setText(String.valueOf(Player.getInstance().getCurrentHealth()));

        TextView confirmPlayerMaxMP = view.findViewById(R.id.playerMaxMana);
        confirmPlayerMaxMP.setText(String.valueOf(Player.getInstance().getMaximumMana()));

        TextView confirmPlayerCurrentMP = view.findViewById(R.id.playerCurrentMana);
        confirmPlayerCurrentMP.setText(String.valueOf(Player.getInstance().getCurrentMana()));

        TextView confirmPlayerArmorClass = view.findViewById(R.id.playerCurrentArmor);
        confirmPlayerArmorClass.setText(String.valueOf(Player.getInstance().getArmorClass()));

        TextView confirmPlayerLevel = view.findViewById(R.id.playerLevel);
        confirmPlayerLevel.setText(String.valueOf(Player.getInstance().getLevel()));

        TextView playerSpell1 = view.findViewById(R.id.playerSpell1);
        playerSpell1.setText(spellList.get(0).getName());

        TextView playerSpell2 = view.findViewById(R.id.playerSpell2);
        playerSpell2.setText(spellList.get(1).getName());

        TextView playerSpell3 = view.findViewById(R.id.playerSpell3);
        playerSpell3.setText(spellList.get(2).getName());

        TextView playerSpell4 = view.findViewById(R.id.playerSpell4);
        playerSpell4.setText(spellList.get(3).getName());

        TextView monsterCurrentHealth = view.findViewById(R.id.monsterCurrentHealth);
        monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));

        TextView monsterMaximumHealth = view.findViewById(R.id.monsterMaxHealth);
        monsterMaximumHealth.setText(String.valueOf(monster.getMaximumHealth()));


        return view;


    }

    //Perform battle to compare goblins' AC vs player's roll to see if damage is done.


    //Method to update the TextView showing Monster's HP.
    public void displayMonsterHealth() {
        TextView monsterCurrentHealth = view.findViewById(R.id.monsterCurrentHealth);
        TextView monsterMaximumHealth = view.findViewById(R.id.monsterMaxHealth);
        monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
    }


    public void attackOne() {
        TextView monsterCurrentHealth = view.findViewById(R.id.monsterCurrentHealth);
        TextView monsterMaximumHealth = view.findViewById(R.id.monsterMaxHealth);
        if (Player.getInstance().getStunnedTurns() > 0){
            ifPlayerStunned();

        }
        else {
            Random rand = new Random();
            int attackerRoll = rand.nextInt((20) + 1) + 1;
            int defenderRoll = rand.nextInt((20) + 1) + 1;
            int attackerMod = Player.getInstance().determineMod();
            int defenderMod = monster.determineMod();
            Ability abilityToCast = spellList.get(0);
            RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
            if (didHit.isSuccessful()) {
                abilityToCast.toAttack(Player.getInstance()).applyTo(monster);
                monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
                if (abilityToCast.hasDamageEffect()) {
                    abilityToCast.addDamageEffect(monster);
                    TextView wasDotAdded = view.findViewById(R.id.dotResults);
                    wasDotAdded.setText("Yes dot was added");
                    TextView dotInfo = view.findViewById(R.id.dotResults2);
                    dotInfo.setText(String.valueOf(abilityToCast.addDamageEffect(Player.getInstance()).getPeriodicDamage()));
                } else {
                    TextView wasDotAdded = view.findViewById(R.id.dotResults);
                    wasDotAdded.setText("No Dot was not added");
                }
                if (abilityToCast.hasStunEffect()) {
                    abilityToCast.addStunEffect(monster);
                }
                if (abilityToCast.hasWeakenEffect()) {
                    if (!monster.getIsWeakened()) {
                        abilityToCast.addWeakenEffect(monster);
                        TextView wasWeakenAdded = view.findViewById(R.id.weakenResults);
                        wasWeakenAdded.setText(String.valueOf(monster.getBaseDamage()));
                        monster.setIsWeakened(true);
                    }
                }
                if (abilityToCast.hasLeachEffect()){
                    abilityToCast.addLeachEffect(Player.getInstance());
                }
            }
            TextView resultsString = view.findViewById(R.id.attackResults);
            resultsString.setText(new StringBuilder().append("You = ").append((attackerMod + attackerRoll)).append("Gob = ").append((defenderMod + defenderRoll)).toString());
            endTurn();
        }
    }

    public void attackTwo() {
        TextView monsterCurrentHealth = view.findViewById(R.id.monsterCurrentHealth);
        TextView monsterMaximumHealth = view.findViewById(R.id.monsterMaxHealth);
        if (Player.getInstance().getStunnedTurns() > 0){
            ifPlayerStunned();
        } else {
            Random rand = new Random();
            int attackerRoll = rand.nextInt((20) + 1) + 1;
            int defenderRoll = rand.nextInt((20) + 1) + 1;
            int attackerMod = Player.getInstance().determineMod();
            int defenderMod = monster.determineMod();
            Ability abilityToCast = spellList.get(1);
            RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
            if (didHit.isSuccessful()) {
                abilityToCast.toAttack(Player.getInstance()).applyTo(monster);
                monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
                if (abilityToCast.hasDamageEffect()) {
                    abilityToCast.addDamageEffect(monster);
                    TextView wasDotAdded = view.findViewById(R.id.dotResults);
                    wasDotAdded.setText("Yes dot was added");
                    TextView dotInfo = view.findViewById(R.id.dotResults2);
                    dotInfo.setText(String.valueOf(abilityToCast.addDamageEffect(Player.getInstance()).getPeriodicDamage()));
                } else {
                    TextView wasDotAdded = view.findViewById(R.id.dotResults);
                    wasDotAdded.setText("No Dot was not added");
                }
                if (abilityToCast.hasStunEffect()) {
                    abilityToCast.addStunEffect(monster);
                }
                if (abilityToCast.hasWeakenEffect()) {
                    if (!monster.getIsWeakened()) {
                        abilityToCast.addWeakenEffect(monster);
                        TextView wasWeakenAdded = view.findViewById(R.id.weakenResults);
                        wasWeakenAdded.setText(String.valueOf(monster.getBaseDamage()));
                        monster.setIsWeakened(true);
                    }
                }
                if (abilityToCast.hasLeachEffect()){
                    abilityToCast.addLeachEffect(Player.getInstance());
                }
            }
            TextView resultsString = view.findViewById(R.id.attackResults);
            resultsString.setText(new StringBuilder().append("You = ").append((attackerMod + attackerRoll)).append("Gob = ").append((defenderMod + defenderRoll)).toString());

            endTurn();
        }
    }

    public void attackThree() {
        TextView monsterCurrentHealth = view.findViewById(R.id.monsterCurrentHealth);
        TextView monsterMaximumHealth = view.findViewById(R.id.monsterMaxHealth);
        if (Player.getInstance().getStunnedTurns() > 0){
            ifPlayerStunned();
        } else {
            Random rand = new Random();
            int attackerRoll = rand.nextInt((20) + 1) + 1;
            int defenderRoll = rand.nextInt((20) + 1) + 1;
            int attackerMod = Player.getInstance().determineMod();
            int defenderMod = monster.determineMod();
            Ability abilityToCast = spellList.get(2);
            RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
            if (didHit.isSuccessful()) {
                abilityToCast.toAttack(Player.getInstance()).applyTo(monster);
                monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
                if (abilityToCast.hasDamageEffect()) {
                    abilityToCast.addDamageEffect(monster);
                    TextView wasDotAdded = view.findViewById(R.id.dotResults);
                    wasDotAdded.setText("Yes dot was added");
                    TextView dotInfo = view.findViewById(R.id.dotResults2);
                    dotInfo.setText(String.valueOf(abilityToCast.addDamageEffect(Player.getInstance()).getPeriodicDamage()));
                    Log.d("has effect", String.valueOf((abilityToCast.hasDamageEffect())));
                    Log.d("dot info", (String.valueOf(abilityToCast.addDamageEffect(Player.getInstance()).getPeriodicDamage())));
                } else {
                    TextView wasDotAdded = view.findViewById(R.id.dotResults);
                    wasDotAdded.setText("No Dot was not added");
                }
                if (abilityToCast.hasStunEffect()) {
                    abilityToCast.addStunEffect(monster);
                }
                if (abilityToCast.hasLeachEffect()){
                    abilityToCast.addLeachEffect(Player.getInstance());
                }
                if (abilityToCast.hasWeakenEffect()) {
                    if (!monster.getIsWeakened()) {
                        abilityToCast.addWeakenEffect(monster);
                        TextView wasWeakenAdded = view.findViewById(R.id.weakenResults);
                        wasWeakenAdded.setText(String.valueOf(monster.getBaseDamage()));
                        monster.setIsWeakened(true);
                    }
                }
            }
            TextView resultsString = view.findViewById(R.id.attackResults);
            resultsString.setText(new StringBuilder().append("You = ").append((attackerMod + attackerRoll)).append("Gob = ").append((defenderMod + defenderRoll)).toString());
            endTurn();
        }
    }
    public void attackFour() {
        TextView monsterCurrentHealth = view.findViewById(R.id.monsterCurrentHealth);
        TextView monsterMaximumHealth = view.findViewById(R.id.monsterMaxHealth);
        if (Player.getInstance().getStunnedTurns() > 0){
            ifPlayerStunned();

        } else {
            Random rand = new Random();
            int attackerRoll = rand.nextInt((20) + 1) + 1;
            int defenderRoll = rand.nextInt((20) + 1) + 1;
            int attackerMod = Player.getInstance().determineMod();
            int defenderMod = monster.determineMod();
            Ability abilityToCast = spellList.get(3);
            RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
            if (didHit.isSuccessful()) {
                abilityToCast.toAttack(Player.getInstance()).applyTo(monster);
                monsterCurrentHealth.setText(String.valueOf(monster.getCurrentHealth()));
                if (abilityToCast.hasDamageEffect()) {
                    abilityToCast.addDamageEffect(monster);
                    TextView wasDotAdded = view.findViewById(R.id.dotResults);
                    wasDotAdded.setText("Yes dot was added");
                    TextView dotInfo = view.findViewById(R.id.dotResults2);
                    dotInfo.setText(String.valueOf(abilityToCast.addDamageEffect(Player.getInstance()).getPeriodicDamage()));
                } else {
                    TextView wasDotAdded = view.findViewById(R.id.dotResults);
                    wasDotAdded.setText("No Dot was not added");
                }
                if (abilityToCast.hasStunEffect()) {
                    abilityToCast.addStunEffect(monster);
                }
                if (abilityToCast.hasWeakenEffect()) {
                    if (!monster.getIsWeakened()) {
                        abilityToCast.addWeakenEffect(monster);
                        TextView wasWeakenAdded = view.findViewById(R.id.weakenResults);
                        wasWeakenAdded.setText(String.valueOf(monster.getBaseDamage()));
                        monster.setIsWeakened(true);
                    }
                }
                if (abilityToCast.hasLeachEffect()){
                    abilityToCast.addLeachEffect(Player.getInstance());
                }

            }
            TextView resultsString = view.findViewById(R.id.attackResults);
            resultsString.setText(new StringBuilder().append("You = ").append((attackerMod + attackerRoll)).append("Gob = ").append((defenderMod + defenderRoll)).toString());

            endTurn();
        }
    }

    public boolean checkIfMonsterDead() {
        return monster.getCurrentHealth() < 1;
    }

    public void characterKillGains() {
        playerNewExperience = Player.getInstance().experience + monster.getExperience();
        playerNewGold = Player.getInstance().gold + monster.getGold();
        Player.getInstance().setExperience(playerNewExperience);
        Player.getInstance().setGold(playerNewGold);
        levelUp check = new levelUp(playerNewExperience, Player.getInstance().getExperience());
        int experienceNeeded = check.experienceNeeded(Player.getInstance().level);
        if (experienceNeeded < Player.getInstance().getExperience()) {
            Player.getInstance().setLevel(Player.getInstance().getLevel() + 1);
            Player.getInstance().setAvailablePoints(Player.getInstance().getAvailablePoints() + 1);

        }

    }

    public void ifPlayerStunned() {
        Player player = Player.getInstance();
        TextView stunned = view.findViewById(R.id.playerStunResults);
        stunned.setText("You are stunned");
        player.setStunnedTurns(Player.getInstance().getStunnedTurns() - 1);
    }


    public void checkForStatusEffects(Monster character) {
        List<StatusEffect> monsterStatusEffect = character.getStatusEffects();
        Log.d("listOfEffects", String.valueOf(monsterStatusEffect));

        //If the List is not empty, cycle through it and remove any that are 0 duration left
        if (monsterStatusEffect != null) {
            for (int x = 0; x < monsterStatusEffect.size(); x++) {
                if (monsterStatusEffect.get(x).duration == 0 && monsterStatusEffect.get(x).getName() != "Weaken" && monsterStatusEffect.get(x).getName() != "LessenAgility" && monsterStatusEffect.get(x).getName() != "LessenIntellect") {
                    monsterStatusEffect.remove(x);
                }
                //If the Status Effect is "Weaken", we're going to do stuff with that later. Right now, just deal the DOT damage
                else if (!monsterStatusEffect.get(x).getName().equals("Weaken") && !monsterStatusEffect.get(x).getName().equals("LessenAgility") && !monsterStatusEffect.get(x).getName().equals("LessenIntellect")){
                    Log.d("Dot before reduce", String.valueOf(monsterStatusEffect.get(x).duration));
                    monsterStatusEffect.get(x).applyPeriodicDamage(character);
                    monsterStatusEffect.get(x).periodicDamage = monsterStatusEffect.get(x).definePeriodicDamage(monsterStatusEffect.get(x));
                    displayMonsterHealth();
                    Log.d("Dot endOfTurn name", String.valueOf(monsterStatusEffect.get(x).name));
                    Log.d("Dot endOfTurn duration", String.valueOf(monsterStatusEffect.get(x).duration));
                    Log.d("Dot endOfTurn duration", String.valueOf(monsterStatusEffect.get(x).periodicDamage));
                    //applyPeriodicDamage also reduces the duration by 1, so we check again to see if it's 0 and remove if it is.
                    if (monsterStatusEffect.get(x).duration == 0) {
                        monsterStatusEffect.remove(x);
                    }
                }
                //If the effect is Weaken, we check the duration. If it's more than 0, just set duration down 1 and update the text view
                if (monsterStatusEffect.get(x).getName() == "Weaken" && character.getIsWeakened() && monsterStatusEffect.get(x).duration > 0){
                    monsterStatusEffect.get(x).duration -=1;
                    TextView wasWeakenAdded = view.findViewById(R.id.weakenResults);
                    wasWeakenAdded.setText(String.valueOf(character.getBaseDamage()));
                }
                //If it's 0, we call to remove the status effect. We can only do this AFTER we check if it's not 0, because otherwise it could grow when we don't want it to.
                if (monsterStatusEffect.get(x).getName() == "Weaken" && character.getIsWeakened() && monsterStatusEffect.get(x).duration == 0){
                    monsterStatusEffect.get(x).removeWeakenEffect(character);
                    character.setIsWeakened(false);
                    monsterStatusEffect.remove(x);
                    TextView wasWeakenAdded = view.findViewById(R.id.weakenResults);
                    wasWeakenAdded.setText(String.valueOf(character.getBaseDamage()));
                }

                //Do the same as above but for LessenAgility
                if (monsterStatusEffect.get(x).getName() == "LessenAgility" && character.getIsWeakened() && monsterStatusEffect.get(x).duration > 0){
                    monsterStatusEffect.get(x).duration -=1;
                    displayPlayerStats();
                }
                //If it's 0, we call to remove the status effect. We can only do this AFTER we check if it's not 0, because otherwise it could grow when we don't want it to.
                if (monsterStatusEffect.get(x).getName() == "LessenAgility" && character.getIsWeakened() && monsterStatusEffect.get(x).duration == 0){
                    monsterStatusEffect.get(x).removeLessenAgilityEffect(character);
                    character.setIsWeakened(false);
                    monsterStatusEffect.remove(x);
                    displayPlayerStats();
                }

                //Do the same as above but for LessenIntellect
                if (monsterStatusEffect.get(x).getName().equals("LessenIntellect") && character.getIsWeakened() && monsterStatusEffect.get(x).duration > 0){
                    monsterStatusEffect.get(x).duration -=1;
                    displayPlayerStats();
                }
                //If it's 0, we call to remove the status effect. We can only do this AFTER we check if it's not 0, because otherwise it could grow when we don't want it to.
                if (monsterStatusEffect.get(x).getName().equals("LessenIntellect") && character.getIsWeakened() && monsterStatusEffect.get(x).duration == 0){
                    monsterStatusEffect.get(x).removeLessenIntellectEffect(character);
                    character.setIsWeakened(false);
                    monsterStatusEffect.remove(x);
                    displayPlayerStats();
                }

                //Check if the monster died
                if (checkIfMonsterDead()) {
                    displayMonsterDefinitelydead();
                    characterKillGains();
                }
            }
        }

        //Then do the same thing for the Player
        List<StatusEffect> playerStatusEffect = Player.getInstance().getStatusEffects();
        if (playerStatusEffect != null) {
            for (int numberOfPlayerStatusEffects = 0; numberOfPlayerStatusEffects < playerStatusEffect.size(); numberOfPlayerStatusEffects++) {
                if (playerStatusEffect.get(numberOfPlayerStatusEffects).duration > 0) {
                    playerStatusEffect.get(numberOfPlayerStatusEffects).applyPeriodicDamage(Player.getInstance());
                    displayPlayerHealth();
                    if (playerStatusEffect.get(numberOfPlayerStatusEffects).getName() == "Weaken") {
                        playerStatusEffect.get(numberOfPlayerStatusEffects).removeWeakenEffect(Player.getInstance());
                        TextView wasWeakenAdded = view.findViewById(R.id.weakenResults);
                        wasWeakenAdded.setText(String.valueOf(character.getBaseDamage()));
                    }
                    if (checkIfPlayerDead()) {
                        displayPlayerDead();
                    }
                }
            }
        }
        if (character.getStunnedTurns() > 0) {
            Log.d("Mon Stun", String.valueOf(character.getStunnedTurns()));
            TextView resultsString2 = view.findViewById(R.id.attackResults2);
            resultsString2.setText("Monster could not attack");
            character.setStunnedTurns(character.getStunnedTurns() - 1);
            TextView resultsString5 = view.findViewById(R.id.stunResults);
            resultsString5.setText("Monster is stunned" + character.getStunnedTurns());
            Log.d("new mon stun", String.valueOf(character.getStunnedTurns()));
        }
    }

    public void endTurn() {
        if (checkIfMonsterDead() && !monster.getIsDead()) {
            displayMonsterDefinitelydead();
            characterKillGains();
            monster.setIsDead(true);
        }
        else if (monster.getIsDead()){
            displayMonsterDefinitelydead();
        }


        else {
            checkForStatusEffects(monster);
            Random rand = new Random();
            int attackerRoll = rand.nextInt(20 + 1) + 1;
            int defenderRoll = rand.nextInt((20) + 1) + 1;
            int attackerMod = monster.determineMod();
            int defenderMod = Player.getInstance().determineMod();
            Ability abilityToCast = new MeleeStrike(1);
            RollDice didHit = new RollDice(attackerRoll, defenderRoll, attackerMod, defenderMod);
            TextView resultsString2 = view.findViewById(R.id.attackResults2);
            resultsString2.setText(new StringBuilder().append("You = ").append((defenderMod + defenderRoll)).append("Gob = ").append((attackerMod + attackerRoll)).toString());
            if (didHit.isSuccessful() && monster.getStunnedTurns() < 1) {
                checkIfMonsterStunned();
                abilityToCast.toAttack(monster).applyTo(Player.getInstance());
                displayPlayerHealth();
                TextView resultsString3 = view.findViewById(R.id.attackResults);
                resultsString3.setText(new StringBuilder().append("Your roll + mod = ").append((defenderMod + defenderRoll)).append("You took ").append(monster.baseDamage * abilityToCast.spellLevel).toString());
                TextView resultsString4 = view.findViewById(R.id.attackResults2);
                resultsString4.setText(new StringBuilder().append("Gob roll + mod = ").append((attackerMod + attackerRoll)).toString());
                if (checkIfPlayerDead()) {
                    displayPlayerDead();
                    new youDead();
                }
            }
        }
    }


    public void checkIfMonsterStunned() {
        if (monster.getStunnedTurns() < 0) {
            TextView resultsString5 = view.findViewById(R.id.stunResults);
            resultsString5.setText("Monster is NOT stunned");

        }

    }

    public boolean checkIfPlayerDead() {
        return Player.getInstance().getCurrentHealth() < 1;
    }

    public void displayMonsterDamage(String x) {
        TextView returnDamage = view.findViewById(R.id.attackResults);
        returnDamage.setText(x);
    }

    public void displayMonsterDefinitelydead() {
        TextView leaveItalone = view.findViewById(R.id.attackResults2);
        String x = "The Monster's dead Dave. You gained " + monster.getExperience() + " experience";
        leaveItalone.setText(x);
        levelComplete = 1;
        Button endLevel = view.findViewById(R.id.completeLevel);
        endLevel.setBackgroundColor(0xFFFF0000);
    }

    public void displayPlayerDead() {
        Intent intent = new Intent(getActivity(), youDead.class);
        startActivity(intent);
    }

    public void displayPlayerHealth() {
        TextView playerCurrentHealth = view.findViewById(R.id.playerCurrentHealth);
        playerCurrentHealth.setText(String.valueOf(Player.getInstance().getCurrentHealth()));
        TextView confirmPlayerCurrentMP = view.findViewById(R.id.playerCurrentMana);
        confirmPlayerCurrentMP.setText(String.valueOf(Player.getInstance().getCurrentMana()));
    }

    public void displayPlayerStats() {
        TextView confirmPlayerAgility = view.findViewById(R.id.playerCurrentAgility);
        confirmPlayerAgility.setText(String.valueOf(Player.getInstance().getAgility()));


        TextView confirmPlayerStrength = view.findViewById(R.id.playerCurrentStrength);
        confirmPlayerStrength.setText(String.valueOf(Player.getInstance().getStrength()));

        TextView confirmPlayerIntellect = view.findViewById(R.id.playerCurrentIntellect);
        confirmPlayerIntellect.setText(String.valueOf(Player.getInstance().getIntellect()));

        TextView confirmPlayerMaxHP = view.findViewById(R.id.playerMaxHealth);
        confirmPlayerMaxHP.setText(String.valueOf(Player.getInstance().getMaximumHealth()));

        TextView confirmPlayerCurrentHP = view.findViewById(R.id.playerCurrentHealth);
        confirmPlayerCurrentHP.setText(String.valueOf(Player.getInstance().getCurrentHealth()));

        TextView confirmPlayerMaxMP = view.findViewById(R.id.playerMaxMana);
        confirmPlayerMaxMP.setText(String.valueOf(Player.getInstance().getMaximumMana()));

        TextView confirmPlayerCurrentMP = view.findViewById(R.id.playerCurrentMana);
        confirmPlayerCurrentMP.setText(String.valueOf(Player.getInstance().getCurrentMana()));

        TextView confirmPlayerArmorClass = view.findViewById(R.id.playerCurrentArmor);
        confirmPlayerArmorClass.setText(String.valueOf(Player.getInstance().getArmorClass()));

        TextView confirmPlayerLevel = view.findViewById(R.id.playerLevel);
        confirmPlayerLevel.setText(String.valueOf(Player.getInstance().getLevel()));
    }

    public void displayLevelUp() {
        TextView confirmLevelUp = view.findViewById(R.id.Enemy);
        confirmLevelUp.setText("Level up!");
        displayLevel();
    }

    public void displayLevel() {
        TextView confirmPlayerLevel = view.findViewById(R.id.playerLevel);
        confirmPlayerLevel.setText(String.valueOf(Player.getInstance().getLevel()));
    }

    public void endLevel() {
        if (levelComplete == 1) {
            getFragmentManager().beginTransaction().remove(ExploreTheMineFightOrc.this).commit();
            }
        }
    }



