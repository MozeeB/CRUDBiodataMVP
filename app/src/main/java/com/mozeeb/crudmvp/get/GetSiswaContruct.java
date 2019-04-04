package com.mozeeb.crudmvp.get;

import com.mozeeb.crudmvp.model.DataItem;

import java.util.List;

public interface GetSiswaContruct {
    interface View{
        void ShowBiodata(List dataSiswa);
        void goToEditBiodata(DataItem dataItem);
        void showError(String message);
        void showSucceed(String message);
        void showDeleteSuccess(String message);
        void showDeleteFailder(String message);
        void showDeletetion(String id);
//        void setClickOnDel();
    }
    interface Presenter{
        void getDataSiswa();
        void deleteBiodata(String id);
        void goToEditBiodata(DataItem dataItem);
        void confirmDeletion(String id);
    }
}
