package com.kc.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return movies.size();
    }
    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            //Menghubungkan ViewHolder dengan View
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        Movie movie = (Movie)getItem(i);
        TextView tvNama = view.findViewById(R.id.tv_nama);
        TextView tvDeskripsi = view.findViewById(R.id.tv_deskripsi);
        ImageView imgPhoto = view.findViewById(R.id.img_photo);
        tvNama.setText(movie.getNama());
        tvDeskripsi.setText(movie.getDeskripsi());
        imgPhoto.setImageResource(movie.getPhoto());

        return view;

    }

}
