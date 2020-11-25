package com.example.islamapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamapp.R;
import com.example.islamapp.model.radiosResponse.RadiosItem;

import java.util.List;


public class RadioChannelsAdapter extends RecyclerView.Adapter<RadioChannelsAdapter.ViewHolder> {
    List<RadiosItem> channels;
    OnItemClickListener onPlayClickListener;
    OnItemClickListener onStopClickListener;

    public RadioChannelsAdapter(List<RadiosItem> channels) {
        this.channels = channels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_radio, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final RadiosItem item = channels.get(position);
        holder.title.setText(item.getName());
        if (onPlayClickListener != null) {
            holder.play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPlayClickListener.onItemClick(position, item);
                }
            });
        }
        if (onStopClickListener != null) {
            holder.stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onStopClickListener.onItemClick(position, item);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return channels == null ? 0 : channels.size();
    }

    public void changeData(List<RadiosItem> channels) {
        this.channels = channels;
        notifyDataSetChanged();
    }

    public void setOnPlayClickListener(OnItemClickListener onPlayClickListener) {
        this.onPlayClickListener = onPlayClickListener;
    }

    public void setOnStopClickListener(OnItemClickListener onStopClickListener) {
        this.onStopClickListener = onStopClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int pos, RadiosItem item);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView play, stop;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            play = itemView.findViewById(R.id.play);
            stop = itemView.findViewById(R.id.stop);
            title = itemView.findViewById(R.id.title);
        }
    }
}
