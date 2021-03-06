package com.example.android.adventurersofarldem.Attacks;

import com.example.android.adventurersofarldem.Characters.Character;

import java.util.List;

public interface RicochetAttack {
    // Your battle system could call this after a successful attack is applied to the primary target
    // You'd probably need to make this more complex if you wanted to provide metadata for targeting
    // You'd also need to think about whether you're helping or harming
    void receiveAdditionalTargets(List<Character> potentialTargetList);
}