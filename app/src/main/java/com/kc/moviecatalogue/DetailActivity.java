package com.kc.moviecatalogue;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    TextView namafilm,kriteria;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

       namafilm = findViewById(R.id.tv_nama);
       kriteria = findViewById(R.id.tv_deskripsi);
       img = findViewById(R.id.img_photo);

       Movie film = getIntent().getParcelableExtra(EXTRA_MOVIE);
       String text1 = film.getNama();
       String text2 = film.getDeskripsi();
       int asd = film.getPhoto();
       Movie testmovie = new Movie();
       namafilm.setText(text1);
       kriteria.setText(text2);
       img.setImageResource(film.getPhoto());
    }

}
