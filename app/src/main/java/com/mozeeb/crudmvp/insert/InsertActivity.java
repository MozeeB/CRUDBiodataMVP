package com.mozeeb.crudmvp.insert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mozeeb.crudmvp.R;
import com.mozeeb.crudmvp.main.MainActivity;

public class InsertActivity extends AppCompatActivity implements InsertSiswaContruct.View {

    EditText nama, kelas, email;
    Button simpan;


    private InsertSiswaPresenter insertSiswaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_siswa);

        nama = findViewById(R.id.edt_nama);
        kelas = findViewById(R.id.edt_kelas);
        email = findViewById(R.id.edt_email);
        simpan = findViewById(R.id.btn_tambah);

        insertSiswaPresenter = new InsertSiswaPresenter(this);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertSiswaPresenter.addBiodata(nama.getText().toString(), kelas.getText().toString(), email.getText().toString());
            }
        });
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void addSuccess(String message) {
        Toast.makeText(this, "Insert Succeed!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(InsertActivity.this, MainActivity.class));
        finish();

    }

    @Override
    public void addFailed(String message) {
        Log.d("errornya disini", message);
        Toast.makeText(this, "Insert Failed!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFromValidate() {
        Toast.makeText(this, "Form must be valid!", Toast.LENGTH_SHORT).show();
    }
}
