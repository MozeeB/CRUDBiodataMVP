package com.mozeeb.crudmvp.get;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.mozeeb.crudmvp.GlobalClass;
import com.mozeeb.crudmvp.model.DataItem;
import com.mozeeb.crudmvp.model.ResponseSiswa;

import org.json.JSONException;
import org.json.JSONObject;



public class GetSiswaPresenter implements GetSiswaContruct.Presenter {


    private GetSiswaContruct.View view;

    public GetSiswaPresenter(GetSiswaContruct.View view) {
        this.view = view;
    }

    @Override
    public void getDataSiswa() {
        AndroidNetworking.get(GlobalClass.BASE_URL + "getAllSiswa")
                .setPriority(Priority.HIGH)
                .build()
                .getAsObject(ResponseSiswa.class, new ParsedRequestListener<ResponseSiswa>() {

                    @Override
                    public void onResponse(ResponseSiswa response) {
                        view.showSucceed(response.toString());
                        view.ShowBiodata(response.getData());
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("ada ngak?", anError.toString());
                        view.showError(anError.toString());

                    }
                });
    }

    @Override
    public void deleteBiodata(String id) {
        AndroidNetworking.post(GlobalClass.BASE_URL + "deleteDataSiswa")
                .setPriority(Priority.HIGH)
                .addUrlEncodeFormBodyParameter("id", id)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        getDataSiswa();
                        try {
                            if (response.getBoolean("status")){
                                view.showDeleteSuccess(response.toString());

                            }
                        } catch (JSONException e) {
                            view.showDeleteFailder(e.getMessage());
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        view.showDeleteFailder(anError.toString());
                    }
                });

    }

    @Override
    public void goToEditBiodata(DataItem dataItem) {
        view.goToEditBiodata(dataItem);
    }

    @Override
    public void confirmDeletion(String id) {
        view.showDeletetion(id);
    }
}
