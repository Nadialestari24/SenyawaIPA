package com.example.senyawa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView Unsur1,Kode, Unsur2, Kode2,Unsur3,Kode3,Unsur4,Kode4;
    private Unsur unsur;
    private ImageView gambar2,gambar3,gambar4;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Unsur1=(TextView)findViewById(R.id.unsur);
        Kode=(TextView)findViewById(R.id.kode);
        Unsur2=(TextView)findViewById(R.id.nama_unsur);
        Kode2=(TextView)findViewById(R.id.nama_kode);
        Unsur3=(TextView)findViewById(R.id.nama_unsur3);
        Kode3=(TextView)findViewById(R.id.nama_kode3);
        Unsur4=(TextView)findViewById(R.id.nama_unsur4);
        Kode4=(TextView)findViewById(R.id.nama_kode4);
        gambar2=(ImageView)findViewById(R.id.gambar);
        gambar3=(ImageView)findViewById(R.id.gambar3);
        gambar4=(ImageView)findViewById(R.id.gambar4);


        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<Unsur>call=apiInterface.getUnsure();
        call.enqueue(new Callback<com.example.senyawa.Unsur>() {
            @Override
            public void onResponse(Call<com.example.senyawa.Unsur> call, Response<com.example.senyawa.Unsur> response) {
                unsur=response.body();
                Unsur1.setText(unsur.getUnsur());
                Kode.setText(unsur.getKode());

                List<Senyawa>senyawas=unsur.getSenyawa();

                Unsur2.setText(senyawas.get(0).getNama());
                Kode2.setText(senyawas.get(0).getKode());
                Picasso.with(MainActivity.this).load(senyawas.get(0).getImage()).into(gambar2);

                Unsur3.setText(senyawas.get(1).getNama());
                Kode3.setText(senyawas.get(1).getKode());
                Picasso.with(MainActivity.this).load(senyawas.get(1).getImage()).into(gambar3);

                Unsur4.setText(senyawas.get(2).getNama());
                Kode4.setText(senyawas.get(2).getKode());
                Picasso.with(MainActivity.this).load(senyawas.get(2).getImage()).into(gambar4);

            }

            @Override
            public void onFailure(Call<com.example.senyawa.Unsur> call, Throwable t) {

            }
        });
    }
}
