package com.qacorn.adapter.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qacorn.recycler.R;

public class MusicGroupViewHolder extends RecyclerView.ViewHolder {


    public RelativeLayout music_group_root;
    public TextView music_group_name;
    public ImageButton music_group_handler;

    public MusicGroupViewHolder(@NonNull View itemView) {
        super(itemView);
        music_group_root = itemView.findViewById(R.id.music_group_root);
        music_group_name = itemView.findViewById(R.id.music_group_name);
        music_group_handler = itemView.findViewById(R.id.music_group_handler);
    }
}
