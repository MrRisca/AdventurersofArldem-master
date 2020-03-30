package com.example.android.adventurersofarldem;

import com.example.android.adventurersofarldem.Characters.Character;

public interface StatusAttack {
    public int getDuration();
    public void onCharacterEndedTurn(Character character);
}

