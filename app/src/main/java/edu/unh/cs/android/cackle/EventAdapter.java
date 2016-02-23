package edu.unh.cs.android.cackle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chris Oelerich on 2/22/16.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventAdapterViewHolder> {

  @Override
  public EventAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    return new EventAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false));
  }

  @Override
  public void onBindViewHolder(EventAdapterViewHolder holder, final int position) {
  }

  public int getItemCount() {
    return 5;
  }

  public static class EventAdapterViewHolder extends RecyclerView.ViewHolder {
    public EventAdapterViewHolder(View itemView) {
      super(itemView);
    }
  }

}
