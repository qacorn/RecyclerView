package com.qacorn.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.qacorn.adapter.callback.OnStartDrag;
import com.qacorn.adapter.viewholder.MusicGroupViewHolder;
import com.qacorn.recycler.R;

import java.util.Collections;
import java.util.List;

public class MusicGroupAdapter extends RecyclerView.Adapter<MusicGroupViewHolder> {

    private Context context;
    private List<String> musicGroupList;
    private LayoutInflater layoutInflater;
    private OnStartDrag onStartDrag;

    public MusicGroupAdapter(Context context, List<String> musicGroupList, OnStartDrag onStartDrag) {
        this.context = context;
        this.musicGroupList = musicGroupList;
        this.onStartDrag = onStartDrag;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MusicGroupViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MusicGroupViewHolder(layoutInflater.inflate(R.layout.item_music_group,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MusicGroupViewHolder musicGroupViewHolder, int i) {
        musicGroupViewHolder.music_group_name.setText(musicGroupList.get(i));
        musicGroupViewHolder.music_group_handler.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        onStartDrag.onStartDrag(musicGroupViewHolder);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return musicGroupList == null?0:musicGroupList.size();
    }


    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(musicGroupList,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);

    }
}
