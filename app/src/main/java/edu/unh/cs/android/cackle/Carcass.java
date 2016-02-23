package edu.unh.cs.android.cackle;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Chris Oelerich on 2/22/16.
 */
public class Carcass implements Parcelable {
  int time;
  int food_type;
  String building;
  String room;
  String victim;
  int difficulty;

  public Carcass(int food_type, int time, String building, String room, String victim, int difficulty) {
    this.food_type = food_type;
    this.time = time;
    this.room = room;
    this.victim = victim;
    this.difficulty = difficulty;
  }

  private Carcass(Parcel in) {
    food_type = in.readInt();
    time = in.readInt();
    building = in.readString();
    room = in.readString();
    victim = in.readString();
    difficulty = in.readInt();
  }

  public static List<Integer> availibleDifficultyLevels() {
    return Arrays.asList(Color.GREEN, Color.YELLOW, Color.RED, Color.BLACK);
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

  public static final Parcelable.Creator<Carcass> CREATOR = new Parcelable.Creator<Carcass>() {
    @Override
    public Carcass createFromParcel(Parcel in) {
      return new Carcass(in);
    }

    @Override
    public Carcass[] newArray(int size) {
      return new Carcass[size];
    }
  };

  @Override
  public void writeToParcel(Parcel out, int flags) {
    out.writeInt(food_type);
    out.writeInt(time);
    out.writeString(building);
    out.writeString(room);
    out.writeString(victim);
    out.writeInt(difficulty);
  }

  @Override
  public int describeContents() {
    return 0;
  }
}
