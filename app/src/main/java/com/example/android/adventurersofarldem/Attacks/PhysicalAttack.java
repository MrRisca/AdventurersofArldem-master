package com.example.android.adventurersofarldem.Attacks;

import com.example.android.adventurersofarldem.Characters.Character;

public class PhysicalAttack extends Attack {

        public PhysicalAttack(int directDamage){
            super(directDamage);


        }

        @Override
        public void applyTo(Character character){
            super.applyTo(character);
        }

    }
