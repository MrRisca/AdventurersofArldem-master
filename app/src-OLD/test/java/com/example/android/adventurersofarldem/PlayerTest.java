package com.example.android.adventurersofarldem;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class WarriorTest {

    Warrior tester;

    @BeforeClass
    public static void testSetup() {
        tester = new Warrior("Oli", 8, 10, 4, 30, 5, 30, 5);
    }

}