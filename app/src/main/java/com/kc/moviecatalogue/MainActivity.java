package com.kc.moviecatalogue;


import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.os.Looper.prepare;


public class MainActivity extends AppCompatActivity {

    String[] dataName;
    String[] dataDeskripsi;
    TypedArray dataPhoto;
    MovieAdapter adapter;
    ArrayList<Movie> movies;
    ListView listView;
    ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        final ListView listView = findViewById(R.id.lv1);
        listView.setAdapter(adapter);

        prepare();

        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movie = new Movie();
                movie.setPhoto(dataPhoto.getResourceId(i,-1));
                movie.setNama(dataName[i]);
                movie.setDeskripsi(dataDeskripsi[i]);
                Intent move = new Intent(MainActivity.this, DetailActivity.class);
                move.putExtra(DetailActivity.EXTRA_MOVIE, movie);
                startActivity(move);
            }
        });
    }

    private void addItem() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setNama(dataName[i]);
            movie.setDeskripsi(dataDeskripsi[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

}