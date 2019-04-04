package com.mozeeb.crudmvp.update;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.mozeeb.crudmvp.GlobalClass;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdatePresenter implements UpdateContruct.Presenter  {

    private UpdateContruct.View view;

    public UpdatePresenter(UpdateContruct.View view) {
        this.view = view;
    }


    @Override
    public void updateData(String id, String nama, String kelas, String email) {

        AndroidNetworking.post(GlobalClass.BASE_URL + "updateDataSiswa")
                .setPriority(Priority.HIGH)
                .addUrlEncodeFormBodyParameter("id", id)
                .addUrlEncodeFormBodyParameter("nama", nama)
                .addUrlEncodeFormBodyParameter("kelas", kelas)
                .addUrlEncodeFormBodyParameter("email", email)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        view.updateSuccess(response.toString());
                        try {
                            if (response.getBoolean("status")){

                            }
                        } catch (JSONException e) {
                            view.updateFailed(response.toString());
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("sini mas", anError.toString());
                        view.updateFailed(anError.toString());

                    }
                });

    }
}
