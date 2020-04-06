package com.example.android.adventurersofarldem.Attacks;

import com.example.android.adventurersofarldem.Characters.Character;

public class LeachAttack extends Attack {

        public LeachAttack(int directDamage){
            super(directDamage);


        }


        public void applyTo(Character character) {

            character.currentHealth -= directDamage;

        }

        public void leachDamage(Character caster) {
            caster.setCurrentHealth(caster.getCurrentHealth() + (directDamage / 2));
            if (caster.getCurrentHealth() > caster.getMaximumHealth()){
                caster.setCurrentHealth(caster.getMaximumHealth());
            }
        }
    }
