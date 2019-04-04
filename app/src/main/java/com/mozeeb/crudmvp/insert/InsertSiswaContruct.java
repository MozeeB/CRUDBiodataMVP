package com.mozeeb.crudmvp.insert;


public interface InsertSiswaContruct {

    interface View{
        void showProgressDialog();
        void addSuccess(String message);
        void addFailed(String message);
        void showFromValidate();
    }

    interface Presenter{
        void addBiodata(String nama, String kelas, String email);
    }
}
