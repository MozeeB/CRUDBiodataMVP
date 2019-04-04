package com.mozeeb.crudmvp.update;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mozeeb.crudmvp.R;
import com.mozeeb.crudmvp.get.GetActivity;
import com.mozeeb.crudmvp.model.DataItem;

public class UpdateActivity extends AppCompatActivity implements UpdateContruct.View {

    EditText nama , kelas, email;
    Button btn_update;

    private UpdatePresenter updatePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final DataItem  dataItem = (DataItem) getIntent().getSerializableExtra("data");

        nama = findViewById(R.id.edt_nama_update);
        kelas = findViewById(R.id.edt_kelas_update);
        email = findViewById(R.id.edt_email_update);


        nama.setText(dataItem.getNamaSiswa());
        kelas.setText(dataItem.getKelasSiswa());
        email.setText(dataItem.getEmailSiswa());

        updatePresenter = new UpdatePresenter(this);


        btn_update = findViewById(R.id.btn_update);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePresenter.updateData(dataItem.getIdSiswa(), nama.getText().toString(), kelas.getText().toString(), email.getText().toString());
            }
        });




    }

    @Override
    public void updateSuccess(String message) {
        Toast.makeText(this, "update success!", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void updateFailed(String message) {
        Toast.makeText(this, "update failed!", Toast.LENGTH_SHORT).show();

    }
}
