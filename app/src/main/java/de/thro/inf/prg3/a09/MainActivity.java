package de.thro.inf.prg3.a09;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import de.thro.inf.prg3.a09.adapter.FighterRecyclerViewAdapter;
import de.thro.inf.prg3.a09.flyweight.FlyweightFactory;
import de.thro.inf.prg3.a09.model.Fighter;
import de.thro.inf.prg3.a09.model.FighterFactory;
import de.thro.inf.prg3.a09.adapter.FighterListAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int FIGHTER_COUNT = 400;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FighterFactory fighterFactory = new FighterFactory(this);
        FighterRecyclerViewAdapter fighterRecyclerViewAdapter = new FighterRecyclerViewAdapter();

        final RecyclerView fighterRecyclerView = findViewById(R.id.fighterListView);
        layoutManager = new LinearLayoutManager(this);
        fighterRecyclerView.setLayoutManager(layoutManager);
        fighterRecyclerView.setAdapter(fighterRecyclerViewAdapter);


        for (int i = 0; i < FIGHTER_COUNT; i++) {
            try {
                fighterRecyclerViewAdapter.add(fighterFactory.createFighter());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
