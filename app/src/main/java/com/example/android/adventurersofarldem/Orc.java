package com.example.android.adventurersofarldem;

        import android.os.Parcel;
        import android.os.Parcelable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;

        import java.util.Arrays;
        import java.util.List;


public class Orc extends Monster {
    public Orc() {
        super("Orc", 13, 8, 20, 5, 20, 5, 10, 10, 5, 1, 1,1,1);
    }

    public void setStrength(int st) {
        strength = st;
    }

    public int getStrength() {
        return strength;
    }


    public void setAgility(int ag) {
        agility = ag;
    }

    public int getAgility() {
        return agility;
    }


    public void setIntellect(int in) {
        intellect = in;
    }

    public int getIntellect() {
        return intellect;
    }

    public int attack(String target, String spell){
        int attackDamage = 0;

        return attackDamage;
    }


    public void setCharacterName(String n) {
        characterName = n;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterType(String type) {
        characterType = type;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setArmorClass(int ac) {
        armorClass = ac;
    }

    public int getArmorClass() {
        return armorClass;
    }


    public void setBaseDamage(int bd) {
        baseDamage = bd;
    }

    public int getBaseDamage() {
        return baseDamage;
    }


    public void setMaximumHealth(int maxHP) {
        maximumHealth = maxHP;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }


    public void setMaximumMana(int maxMP) {
        maximumMana = maxMP;
    }

    public int getMaximumMana() {
        return maximumMana;
    }

    public void setCurrentHealth(int currentHP) {
        currentHealth = currentHP;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setSpeed(int sp) {
        speed = sp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setCurrentMana(int currentMP) {
        currentMana = currentMP;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setExperience(int xp) {
        experience = xp;
    }

    public int getExperience() {
        return experience;
    }

    public void setGold(int gp) {
        gold = gp;
    }

    public int getGold() {
        return gold;
    }

    public void addStatusEffect(StatusEffect effectName){
        statusEffect = Arrays.asList(effectName);

    }

    public List<StatusEffect> getStatusEffect() {
        return statusEffect;
    }

    public int determineMod(){
        return level * 2;
    }

    public String toString(){
        return "Orc{" +

                ", armor class= " + armorClass +
                ", base damage= " + baseDamage +
                ", maximumHealth=" + maximumHealth +
                ", maximumMana=" + maximumMana +
                ", currentHealth=" + currentHealth +
                ", currentMana=" + currentMana +
                '}';

    }


    public String OrcData(String monsterName, int armorClass, int baseDamage, int maximumHealth, int maximumMana, int currentHealth, int currentMana){
        String OrcData = "Orc name is " + monsterName + ", \n Their AC is " + armorClass + "\n Their Base Damage is " + baseDamage;
        OrcData += "\n Their Max HP is " + maximumHealth + " and their current HP is " + currentHealth;
        OrcData += "\n Their Max MP is " + maximumMana + " and their current MP is " + currentMana;
        OrcData += "\n They are worth " + experience + " XP";

        return OrcData;
    }

    public int OrcStrength(){
        return getBaseDamage();
    }

    public int OrcHealth(){
        return  getCurrentHealth();
    }

    public int OrcExperience(){
        return getExperience();}
}