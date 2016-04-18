package edu.unh.cs.android.cackle;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Chris Oelerich on 2/22/16.
 */
public class WateringHoleAdapter extends RecyclerView.Adapter<WateringHoleAdapter.EventAdapterViewHolder> {

  private static final String TAG = WateringHoleAdapter.class.getSimpleName();

  List<Carcass> wateringHole;

  WateringHoleAdapter(List<Carcass> wateringHole) {
    this.wateringHole = wateringHole;
  }

  public void update(List<Carcass> wateringHole) {
    this.wateringHole = wateringHole;
    notifyDataSetChanged();
  }

  @Override
  public EventAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    return new EventAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false));
  }

  @Override
  public void onBindViewHolder(EventAdapterViewHolder holder, final int position) {

    if (wateringHole == null) {
      return;
    }

    Carcass carcass = wateringHole.get(position);

    if (carcass == null) {
      return;
    }

    View itemView = holder.itemView;
    ImageView foodImage = (ImageView) itemView.findViewById(R.id.event_food_image);
    TextView timeBuildingRoom = (TextView) itemView.findViewById(R.id.event_time_building_room);
    TextView victim = (TextView) itemView.findViewById(R.id.event_victim);

    foodImage.setImageDrawable(
        ContextCompat.getDrawable(itemView.getContext(), Carcass.getDrawableId(carcass)));

    String string = carcass.formatTime() + " | " + carcass.building + " | " + carcass.room;

    timeBuildingRoom.setText(string);

    victim.setText(carcass.victim);

    itemView.setBackgroundColor(carcass.difficulty);
  }

  public int getItemCount() {
    if (wateringHole != null)
      return wateringHole.size();
    else {
      Log.e(TAG, "there's a hole in your hole");
      return 0;
    }
  }

  public static class EventAdapterViewHolder extends RecyclerView.ViewHolder {
    public EventAdapterViewHolder(View itemView) {
      super(itemView);
    }
  }
}
