package com.example.toshiba.belajarquran;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AbjadAdapter extends RecyclerView.Adapter<AbjadAdapter.ViewHolder> {

    interface OnMusicStartListener {
        void startMusic(int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatImageButton abjadImage;
        OnMusicStartListener listener;
        public ViewHolder(@NonNull final View itemView, OnMusicStartListener listener) {
            super(itemView);
            this.listener = listener;
            abjadImage = (AppCompatImageButton) itemView;
            abjadImage.setOnClickListener(this);
        }

        public void setImage(Drawable drawable){
            abjadImage.setImageDrawable(drawable);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.startMusic(position);
        }
    }

    LayoutInflater mInflater;
    TypedArray abjads;
    OnMusicStartListener listener;

    public AbjadAdapter(Context context, TypedArray abjads, OnMusicStartListener listener){
        this.mInflater = LayoutInflater.from(context);
        this.abjads = abjads;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.abjad_layout,viewGroup,false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setImage(abjads.getDrawable(i));
    }

    @Override
    public int getItemCount() {
        return abjads.length();
    }

}
