package com.example.android.adventurersofarldem;

import com.example.android.adventurersofarldem.Characters.Monster;
import com.example.android.adventurersofarldem.Items.Equippable;
import com.example.android.adventurersofarldem.Quests.SlayTheLich.SlayTheLichActivity;

import java.util.Objects;

public class Room {

    public int x;
    public int y;


    public Room(int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Room)) {
            return false;
        }

        Room r = (Room) o;

        return x == r.x
                && r.y == this.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }

}
