package com.qacorn.recycler;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.qacorn.adapter.MusicGroupAdapter;
import com.qacorn.adapter.callback.OnStartDrag;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnStartDrag {

    private List<String> musicGroupList = new ArrayList<>();

    private RecyclerView music_group_recycler;
    private MusicGroupAdapter musicGroupAdapter;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music_group_recycler = findViewById(R.id.music_group_recycler);
        music_group_recycler.setLayoutManager(new LinearLayoutManager(this));
        String[] musicGroupArray = getResources().getStringArray(R.array.music_group_array);
        for (int i = 0; i < musicGroupArray.length; i++) {
            musicGroupList.add(musicGroupArray[i]);
        }

        musicGroupAdapter = new MusicGroupAdapter(this,musicGroupList,this);
        music_group_recycler.setAdapter(musicGroupAdapter);

        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                return  makeMovementFlags(dragFlags,0);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                musicGroupAdapter.onItemMove(viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }
        });
        itemTouchHelper.attachToRecyclerView(music_group_recycler);
    }



    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }
}
