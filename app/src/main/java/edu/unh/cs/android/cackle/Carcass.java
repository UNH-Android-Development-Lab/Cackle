package edu.unh.cs.android.cackle;

import android.graphics.Color;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Chris Oelerich on 2/22/16.
 */
public class Carcass {
  long time;
  int food_type;
  String building;
  String room;
  String victim;
  int difficulty;

  public long getTime() {
    return time;
  }

  public int getFood_type() {
    return food_type;
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

  public Carcass(int food_type, long time, String building, String room, String victim, int difficulty) {
    this.food_type = food_type;
    this.time = time;
    this.building = building;
    this.room = room;
    this.victim = victim;
    this.difficulty = difficulty;
  }

  public String formatTime() {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(time);
    SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yy H:mm");
    return dateFormat.format(cal.getTime());
  }

  public static List<Integer> availibleDifficultyLevels() {
    return Arrays.asList(Color.GREEN, Color.rgb(100, 100, 0), Color.RED, Color.BLACK);
  }

  public static int getDrawableId(Carcass carcass) {

    int drawableId = 0;

    switch (carcass.food_type) {
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
