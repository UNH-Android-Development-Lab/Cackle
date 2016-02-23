package edu.unh.cs.android.cackle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Chris Oelerich on 2/22/16.
 */
public class WateringHoleAdapter extends RecyclerView.Adapter<WateringHoleAdapter.EventAdapterViewHolder> {

  List<Carcass> wateringHole;

  WateringHoleAdapter(List<Carcass> wateringHole) {
    this.wateringHole = wateringHole;
  }

  @Override
  public EventAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    return new EventAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false));
  }

  @Override
  public void onBindViewHolder(EventAdapterViewHolder holder, final int position) {

  }

  public int getItemCount() {
    if (wateringHole != null)
      return wateringHole.size();
    else return 0;
  }

  public static class EventAdapterViewHolder extends RecyclerView.ViewHolder {
    public EventAdapterViewHolder(View itemView) {
      super(itemView);
    }
  }
}
