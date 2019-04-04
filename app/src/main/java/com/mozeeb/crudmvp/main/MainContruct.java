package com.mozeeb.crudmvp.main;

public interface MainContruct {
    interface View{
        void goToListBiodata();
        void goToAddBiodata();

    }
    interface Presenter{
        void seeAllBiodata();
        void addBiodata();
    }
}
