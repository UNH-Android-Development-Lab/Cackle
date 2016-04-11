package edu.unh.cs.android.cackle;

import android.graphics.Color;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Chris Oelerich on 2/22/16.
 */
public class Carcass {
  int time;
  int foodType;
  String building;
  String room;
  String victim;
  int difficulty;

  public int getTime() {
    return time;
  }

  public int getFoodType() {
    return foodType;
  }

  public String getBuilding() {
    return building;
  }

  public String getRoom() {
    return room;
  }

  public String getVictim() {
    return victim;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public Carcass() {} // Needed for Firebase to deserialize the data

  public Carcass(int food_type, int time, String building, String room, String victim, int difficulty) {
    this.foodType = food_type;
    this.time = time;
    this.building = building;
    this.room = room;
    this.victim = victim;
    this.difficulty = difficulty;
  }

  public static List<Integer> availibleDifficultyLevels() {
    return Arrays.asList(Color.GREEN, Color.rgb(100, 100, 0), Color.RED, Color.BLACK);
  }

  public static int getDrawableId(Carcass carcass) {

    int drawableId = 0;

    switch (carcass.foodType) {
      case Type.PIZZA:
        drawableId = R.drawable.pizza;
        break;

    }
    return drawableId;
  }

  public class Type {
    public final static int PIZZA = 1;
    public final static int SUBS = 2;
  }
}
