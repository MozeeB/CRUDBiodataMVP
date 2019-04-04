package com.mozeeb.crudmvp.insert;

import android.util.Log;
import android.util.Patterns;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.mozeeb.crudmvp.GlobalClass;

import org.json.JSONException;
import org.json.JSONObject;

public class InsertSiswaPresenter implements InsertSiswaContruct.Presenter {

    private InsertSiswaContruct.View view;

    public InsertSiswaPresenter(InsertSiswaContruct.View view) {
        this.view = view;
    }

    @Override
    public void addBiodata(String nama, String kelas, String email) {

        if (nama.length() > 0 && kelas.length() > 0 && email.length() > 0 && Patterns.EMAIL_ADDRESS.matcher(email).matches()){

        }else {
            view.showFromValidate();
        }

        AndroidNetworking.post(GlobalClass.BASE_URL + "insertDataSiswa")
                .setPriority(Priority.HIGH)
                .addBodyParameter("nama", nama)
                .addBodyParameter("kelas", kelas)
                .addBodyParameter("email", email)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            if (response.getBoolean("status")){
                                view.addSuccess(response.toString());

                            }
                        } catch (JSONException e) {
                            view.addFailed(response.toString());
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("erromas", anError.getErrorBody());
                        view.addFailed(anError.toString());

                    }
                });

    }
}
