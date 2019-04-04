package com.mozeeb.crudmvp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mozeeb.crudmvp.R;
import com.mozeeb.crudmvp.get.GetActivity;
import com.mozeeb.crudmvp.insert.InsertActivity;


public class MainActivity extends AppCompatActivity implements MainContruct.View{

    Button btn_lihat_siswa, btn_insert;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_lihat_siswa = findViewById(R.id.btn_lihat_bio);
        btn_insert = findViewById(R.id.btn_tambah_data);

        mainPresenter = new MainPresenter(this);

        btn_lihat_siswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.seeAllBiodata();

            }
        });
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.addBiodata();
            }
        });

    }

    @Override
    public void goToListBiodata() {
        Intent gotList = new Intent(MainActivity.this, GetActivity.class);
        startActivity(gotList);

    }

    @Override
    public void goToAddBiodata() {
        Intent addBio = new Intent(MainActivity.this, InsertActivity.class);
        startActivity(addBio);

    }
}
