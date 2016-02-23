package edu.unh.cs.android.cackle;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Chris Oelerich on 2/22/16.
 */
public class Carcass implements Parcelable {

  public class Type {
    public final static int PIZZA = 0;
    public final static int SUBS = 1;
  }

  public class Difficulty {
    public final static int GREEN = 0;
    public final static int YELLOW = 1;
    public final static int RED = 2;
    public final static int BLACK = 3;
  }

  int time;
  int food_type;
  String building;
  String room;
  String victim;
  int difficulty;

  private Carcass(Parcel in) {
    food_type = in.readInt();
    time = in.readInt();
    building = in.readString();
    room = in.readString();
    victim = in.readString();
    difficulty = in.readInt();
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
