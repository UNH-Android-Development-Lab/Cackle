package edu.unh.cs.android.cackle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.client.Firebase;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, NewEventActivity.class);
        startActivity(intent);
      }
    });

    Firebase.setAndroidContext(this);

    Firebase firebaseRef = new Firebase("https://cackle.firebaseio.com/");

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

    List<Carcass> testWateringHole =
        Collections.singletonList(new Carcass(1, 650000, "MUB", "320", "Mosaico", Color.rgb(100, 100, 0)));

    WateringHoleAdapter wateringHoleAdapter = new WateringHoleAdapter(testWateringHole);

    LinearLayoutManager llm = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(llm);
    recyclerView.setAdapter(wateringHoleAdapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
