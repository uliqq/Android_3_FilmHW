package com.geektech.android3.ui.film_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.android3.data.models.Films;
import com.geektech.android3.databinding.ItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter <FilmsAdapter.FilmsViewHolder> {

    private OnItemClickListener onItemClickListener;
    private List<Films> films = new ArrayList<>();


    public void setFilms(List<Films> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    public Films getItem(int pos) {
        return films.get(pos);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new FilmsViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull FilmsAdapter.FilmsViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class FilmsViewHolder extends RecyclerView.ViewHolder {

        private ItemFilmBinding binding;

        public FilmsViewHolder(@NonNull ItemFilmBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;

        }

        public void onBind(Films films) {
            binding.getRoot().setOnClickListener(view -> {
                onItemClickListener.OnItemClick(getAdapterPosition());
            });
            binding.filmName.setText(films.getTitle());
            binding.filmDirector.setText(films.getDirector());
        }

    }
    public interface OnItemClickListener {
        void OnItemClick (int pos);
    }
//
//    public interface OnItemClickListener {
//        void OnItemClick(int pos);
//    }
}
