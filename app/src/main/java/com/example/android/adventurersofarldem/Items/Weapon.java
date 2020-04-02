package com.example.android.adventurersofarldem.Items;

public abstract class Weapon extends Equippable {

    public int damageOfWeapon;

    public Weapon(String n, String des, boolean perma, int val, int rar, String sl, int dmg, String st, int am) {
        super(n, des, perma, val, rar, sl, st, am);
        damageOfWeapon = dmg;
    }

    public void setDamageOfWeapon(int newDamage){
        damageOfWeapon = newDamage;
    }

    public int getDamageOfWeapon(){
        return damageOfWeapon;
    }

    public abstract void onUseEffect();
}

