package com.lazday.ytplayer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setList(this);
    }

    private void setList(Context context){

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String TITLES [] = {
                "Captain Marvel", "Captain America: Civil War", "Thor: Ragnarok", "Black Panther",
                "Ant-Man and The Wasp", "Spider-Man: Far From Home"
        };

        String KEYS [] = {
                "mbyd2kvRPnw", "dKrVegVI0Us", "ue80QwXMRHg", "xjDjIWPwcPU", "UUkn-enk2RU", "VUFmhKpZKlE"
        };

        List<MainModel> arrayList = new ArrayList<>();

        for (int i = 0; i < TITLES.length; i++) {

            MainModel model = new MainModel();
            model.setKey(KEYS[i]);
            model.setTitle(TITLES[i]);
            arrayList.add(model);
        }

        MainAdapter adapter = new MainAdapter(context, arrayList);
        recyclerView.setAdapter(adapter);
    }
}
