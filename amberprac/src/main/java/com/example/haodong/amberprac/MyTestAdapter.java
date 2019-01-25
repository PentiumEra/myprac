package com.example.haodong.amberprac;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * @Auther linghailong
 * created at 2019/1/25
 * @duscribe:
 */
public class MyTestAdapter extends RecyclerView.Adapter<MyTestAdapter.MyTestViewholder> {
    private final LayoutInflater layoutInflater;

    public MyTestAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public MyTestViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = layoutInflater.inflate(R.layout.sticker_image, viewGroup, false);
        MyTestViewholder vh = new MyTestViewholder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyTestViewholder myTestViewholder, int i) {
        myTestViewholder.stickerPreviewView.setImageResource(R.drawable.sticker_error);

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class MyTestViewholder extends RecyclerView.ViewHolder {
        public SimpleDraweeView stickerPreviewView;
        public MyTestViewholder(@NonNull View itemView) {
            super(itemView);
            stickerPreviewView = itemView.findViewById(R.id.sticker_preview);
        }
    }
}
