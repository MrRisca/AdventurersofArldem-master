package com.example.android.adventurersofarldem;

        import android.os.Parcel;
        import android.os.Parcelable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;


public class Orc extends Monster {
    public Orc() {
        super("Orc", 13, 8, 20, 5, 20, 5, 10);
    }



    public String toString(){
        return "Orc{" +
                "name='" + monsterName + '\'' +
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