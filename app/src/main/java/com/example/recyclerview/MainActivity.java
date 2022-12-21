package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview.Adapters.AnimeAdapter;
import com.example.recyclerview.Classes.RecyclerItemClickListener;
import com.example.recyclerview.Models.AnimeModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<AnimeModel> list = new ArrayList<>();

        list.add(new AnimeModel(R.drawable.anime,"Anime"));
        list.add(new AnimeModel(R.drawable.baki,"Baki"));
        list.add(new AnimeModel(R.drawable.deathnote,"Death Note"));
        list.add(new AnimeModel(R.drawable.demon,"Demon"));
        list.add(new AnimeModel(R.drawable.naruto,"Naruto"));
        list.add(new AnimeModel(R.drawable.dragonball,"Dragon Ball Z"));

        AnimeAdapter adapter = new AnimeAdapter(list,this);
        recyclerView.setAdapter(adapter);


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){
                    case 0:
                        Intent i = new Intent(MainActivity.this,ScrollingActivity.class);
                        startActivity(i);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "2nd Item is Clicked", Toast.LENGTH_SHORT).show();
                    break;
                    case 2:
                        Toast.makeText(MainActivity.this, "3nd Item is Clicked", Toast.LENGTH_SHORT).show();
                    break;

                    default:
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "OnLongPress", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                }
            }
        }
        ));

//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);


//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(gridLayoutManager);
//
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        recyclerView.setLayoutManager(layoutManager);
    }

}